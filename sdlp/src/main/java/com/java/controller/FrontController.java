package com.java.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.login.LoginServiceImpl;
//用户控制器 用户的增删改查操作
@Controller
public class FrontController {
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	// 登录页面
	@RequestMapping("/loginHtml")
	public String loginHtml() {
		return "thymeleaf/public/login.html";
	}
	// 首页
	@RequestMapping("/indexHtml")
	public String indexHtml() {
		return "thymeleaf/public/index.html";
	}
	// 登录
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpSession session) {
		// 获取返回的结果
		String successinfo = loginServiceImpl.login(request);
		request.setAttribute("successinfo", successinfo);
		if (successinfo.equals("登录成功")) {
			return "redirect:indexHtml";
		} else {
			return "thymeleaf/public/login.html";
		}
	}
	// 登出
	@RequestMapping(value = "/loginout")
	public String loginout() {
		loginServiceImpl.login_out();
		return "redirect:loginHtml";
	}
	// 菜单页
	@RequestMapping("/navHtml")
	public String navHtml() {
		return "thymeleaf/nav.html";
	}
	// 当前用户的session信息
	@RequestMapping("/activeUser")
	@ResponseBody
	public Map<String, Object> activeUser(HttpSession session) {
		HashMap<String, Object> map = new HashMap<>();
		String usernum = (String) session.getAttribute("usernum");
		String name = (String) session.getAttribute("name");
		map.put("usernum", usernum);
		map.put("name", name);
		return map;
	}
}
