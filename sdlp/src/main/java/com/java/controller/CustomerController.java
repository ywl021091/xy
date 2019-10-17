package com.java.controller;

import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.po.Customer;
import com.java.service.customer.CustomerService;
import com.java.service.logger.LoggerService;
import com.java.util.ExcelExportUtil;

//用户控制器 用户的增删改查操作
@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private LoggerService loggerServiceImpl;
	// 增
	@RequestMapping("insert")
	@ResponseBody
	@RequiresPermissions("客户增加")
	public Object insert(Customer customer) {
		HashMap<String, Object> map = new HashMap<>();
		if(customer.getCustomername().equals("")|| customer.getCustomername() == null) {
			map.put("status", "客户名不能为空");
			return map;
		}
		if(customer.getCustomernum().equals("")|| customer.getCustomernum() == null) {
			map.put("status", "客户编码不能为空");
			return map;
		}
		Date lastupdate = new Date();
		customer.setLastupdate(lastupdate);
		if (customerService.insert(customer) == 1) {
			map.put("status", "创建成功");
			loggerServiceImpl.insertLog("添加了客户'"+customer.getCustomername()+"'的客户信息");
			return map;
		} else {
			map.put("status", "创建失败");
			return map;
		}
	}
	// 增 页面
	@RequestMapping("insertHtml")
	public String insertHtml() {
		return "thymeleaf/customer/insert.html";
	}

	// 删
	@RequestMapping("delete")
	@ResponseBody
	@RequiresPermissions("客户删除")
	public Map<String, Object> delete(int customerid) {
		Map<String, Object> map = new HashMap<>();
		int i = customerService.delete(customerid);
		if (i == 1) {
			map.put("status", "删除成功");
			loggerServiceImpl.insertLog("删除了id为'"+customerid+"'的客户信息");
		} else {
			map.put("status", "此客户正在被用户关联或被终端信息关联不能删除");
		}
		return map;
	}

	// 改
	@RequestMapping("update")
	@ResponseBody
	@RequiresPermissions("客户修改")
	public Map<String, Object> update(Customer customer) {
		Map<String, Object> map = new HashMap<>();
		if(customer.getCustomernum().equals("")|| customer.getCustomernum() == null) {
			map.put("status", "用户编码不能为空");
			return map;
		}
		if(customer.getCustomername().equals("")|| customer.getCustomername() == null) {
			map.put("status", "用户名不能为空");
			return map;
		}
		Date now = new Date();
		customer.setLastupdate(now);
		if (customerService.update(customer) == 1) {
			map.put("status", "修改成功");
			loggerServiceImpl.insertLog("修改了客户'"+customer.getCustomername()+"'的客户信息");
			return map;
		} else {
			map.put("status", "修改失败");
			return map;
		}
	}

	// 改 页面
	@RequestMapping("updateHtml")
	public String updateHtml(int customerid) {
		return "thymeleaf/customer/update.html";
	}

	// 查询所有HTML
	@RequestMapping("/listHtml")
	public String listHtml() {
		return "thymeleaf/customer/list.html";
	}
	
	// 查询所有
	@RequestMapping("/query")
	@ResponseBody
	@RequiresPermissions("客户查询所有")
	public Map<String, Object> query(Customer customer,int draw,int start,int length) {
		return customerService.queryCustomer(customer, draw, start, length);
	}
	
	//查一个
	@RequestMapping("/selectByCustomernum")
	@ResponseBody
	@RequiresPermissions("客户查询详细")
	public Map<String, Object> selectByUsernum(String customernum) {
		Map<String, Object> map = new HashMap<>();
		Customer customer = customerService.selectByCustomernum(customernum);
		if (customer == null){
			map.put("status", "400");
		}else {
			map.put("status", "200");
		}
		return map;
	}
	//修改操作判断唯一
	@RequestMapping("/updateByCustomernum")
	@ResponseBody
	public Map<String, Object> updateByCustomernum(Integer customerid, String customernum) {
		
		Map<String, Object> map = new HashMap<>();
		Customer oldCustomer = customerService.selectByid(customerid);
		Customer customer = customerService.selectByCustomernum(customernum);
		if (customer == null || oldCustomer.getCustomernum().equals(customernum)){
			map.put("status", "400");
		}else{
			map.put("status", "200");
		}

		return map;
	}
	
	//返回指定客户信息
	@RequestMapping("/getCustomer")
	@ResponseBody
	public Customer getCustomer(int id) {
		return customerService.selectByid(id);
	}
	
	//提供客户列表接口
	@RequestMapping("/selectCustomer")
	@ResponseBody
	public Map<String, Object> selectCustomer() {
		return customerService.query();
	}
	 /**
     * 导出报表
     * @return
     */
    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletRequest request,HttpServletResponse response) throws Exception {
    		loggerServiceImpl.insertLog("导出了所有客户信息");
           //获取数据
           List<Customer> list= customerService.ListCustomer();

           //excel标题
           String[] title = {"客户编码","客户姓名","客户地址","客户备注","客户电话"};

           //excel文件名
           String fileName = "客户信息表"+System.currentTimeMillis()+".xls";
           //sheet名
           String sheetName = "客户信息表";
           //生成数组
           String[][] content = new String[list.size()][title.length];
			
           for (int i = 0; i < list.size(); i++) {

            content[i][0] = list.get(i).getCustomernum().toString();
            content[i][1] = list.get(i).getCustomername().toString();
            content[i][2] = list.get(i).getAddress().toString();
            content[i][3] = list.get(i).getNote().toString();
            content[i][4] = list.get(i).getTel().toString();
           }
           //创建HSSFWorkbook 
           HSSFWorkbook wb = ExcelExportUtil.getHSSFWorkbook(sheetName, title, content, null);
           
           //响应到客户端
           try {
        	   ExcelExportUtil.setResponseHeader(response, fileName);
               OutputStream os = response.getOutputStream();
               wb.write(os);
               os.flush();
               os.close();
			} catch (Exception e) {
				
			}
    }
   
}    

