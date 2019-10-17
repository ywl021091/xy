package com.java.service.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.po.Permission;
import com.java.po.Role;

/*
 * 2013/1/11 郑广润 权限管理 登录登录赋予角色及权限操作
 */
public interface LoginService {
	
	//登录
	public String login(HttpServletRequest request);
	//登出
	public void login_out();
	//赋予角色
	public void getRoles(HttpServletRequest request);
	//给予权限
	List<Permission> getPermission(Role role);
	
	
}
