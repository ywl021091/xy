package com.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.po.TemplateContrast;
import com.java.po.TemplateTable;
import com.java.po.TemplateTableContrast;
import com.java.service.templatecontrast.TemplateContrastService;
import com.java.service.templatetable.TemplateTableService;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年8月26日 下午2:54:33 
* 终端类型表（模板表）
*/
@Controller
@RequestMapping("template")
public class TemplateTableController{
	@Autowired
	private TemplateContrastService templateContrastService;
	@Autowired
	private TemplateTableService templateTableService;

	//展示所有终端类型表页面
	@RequestMapping("/listHtml")
	public String listHtml() {
		return "thymeleaf/template/list.html";
	}
	//展示所有终端类型表页面
	@RequestMapping("/insertHtml")
	public String insertHtml() {
		return "thymeleaf/template/insert.html";
	}
	//返回所有参数集合
	@RequestMapping("queryTemplateContrast")
	@ResponseBody
	public Map<String,Object> queryTemplateContrast() {
		HashMap<String, Object> map = new HashMap<>();
		List<TemplateContrast> list = templateContrastService.queryTemplateContrast();
		map.put("list",list);
		return map;		
	}
	//新增终端类型
	@RequestMapping("insert")
	@ResponseBody
	@RequiresPermissions("终端类型增加")
	public String insert(@RequestParam(value = "list[]") List<String> list, String templatetablename){
		int i = 0;
		try {
			i = templateTableService.insert(list,templatetablename);
		} catch (Exception e) {
			return "终端名称重复";
		}
		if(i==1) {
			return "创建成功";
		}else {
			return "创建失败";
		}	
	}
	//删除终端类型
	@RequestMapping("deleteTemplateTable")
	@ResponseBody
	@RequiresPermissions("终端类型删除")
	public Object deleteTemplateTable(String templatetablename){
		int i = templateTableService.deleteTemplateTable(templatetablename);
		int j = templateTableService.deleteTemplateTableContrast(templatetablename);
		if(i!=0&&j!=0) {
			return "删除成功";
		}else {
			return "删除失败";
		}
	}
	//按条件返回所有终端类型名称集合
	@RequestMapping("templateTableNameList")
	@ResponseBody
	public Map<String, Object> templateTableNameList(int start,int length,int draw,String templatetablename) {
		// 使用PageHelper分页
		PageHelper.startPage(start, length);
		List<TemplateTable> list = templateTableService.getlist(templatetablename);
		PageInfo<TemplateTable> pageInfo = new PageInfo<>(list);
		// 将得到的pageinfo类进行转化给datatable方便前台展示
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("draw",draw);
        resultMap.put("recordsTotal",pageInfo.getTotal());
        resultMap.put("recordsFiltered",pageInfo.getTotal());
        resultMap.put("data",list);
		return resultMap;
	}
	//返回所有终端类型集合
	@RequestMapping("getTemplateTableNameList")
	@ResponseBody
	public List<TemplateTable> getTemplateTableNameList() {
		List<TemplateTable> list = templateTableService.getlist("");
		return list;
	}
	//返回一个终端类型所有参数
	@RequestMapping("query")
	@ResponseBody
	public List<TemplateContrast> query(String templatetablename) {
		List<TemplateTableContrast> list = templateTableService.query(templatetablename);
		ArrayList<TemplateContrast> listresult = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			TemplateContrast templateContrast = templateContrastService.select(list.get(i).getTemplatenum());
			listresult.add(templateContrast);
		}
		return listresult;
	}

	
}
