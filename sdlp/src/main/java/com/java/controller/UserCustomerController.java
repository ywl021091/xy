package com.java.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.sysuser.SysuserServiceImpl;
import com.java.service.usercustomer.UserCustomerServiceImpl;

/**
 * @author 郑广润 E-mail: 489551132@qq.com
 * @version 创建时间：2019年5月30日 下午2:18:48 类说明
 */
@Controller
@RequestMapping("usercustomer")
public class UserCustomerController {
	@Autowired
	private UserCustomerServiceImpl userCustomerServiceImpl ;
	@Autowired
	private SysuserServiceImpl sysuserServiceImpl;
	// 获得信息进入更改页面
	@RequestMapping("/updateHtml")
	public String updateHtml(int id) {
		return "thymeleaf/sysuser/updateusercustomer.html";
	}
	// 返回客户列表操作
	@RequestMapping("select")
	@ResponseBody
	public Map<String, Object> select(int id) {
		Map<String, Object> map = userCustomerServiceImpl.select(id);
		return map;
	}
	
	// 修改
	@RequestMapping("update")
	@ResponseBody
	public String update(@RequestParam(value = "list[]") List<String> list, int id) {
		userCustomerServiceImpl.update(list, id);
		return "succes";
	}
	// 修改
	@RequestMapping("delete")
	@ResponseBody
	public String update(int id) {
		userCustomerServiceImpl.delete(id);
		return "succes";
	}
}
