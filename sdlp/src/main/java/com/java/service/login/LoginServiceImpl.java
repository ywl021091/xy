package com.java.service.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.PermissionMapper;
import com.java.dao.RoleMapper;
import com.java.dao.RolepermissionMapper;
import com.java.dao.SysuserMapper;
import com.java.po.Permission;
import com.java.po.Role;
import com.java.po.RolepermissionKey;
import com.java.po.Sysuser;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private SysuserMapper sysuserMapper;	

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RolepermissionMapper rolepermissionMapper;
	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public String login(HttpServletRequest request) {
		
		//认证主体
		Subject subject = SecurityUtils.getSubject();
		String usernum = request.getParameter("usernum");
		String password = request.getParameter("password");
		
        //生成认证信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(usernum,password);
        //密码加密
        //Md5Hash md5Hash = new Md5Hash(password);
        //进行登录验证，这里可以捕获异常，然后返回对应信息
        
        try {
			subject.login(usernamePasswordToken);
		} catch (AuthenticationException e) {
			return "用户名密码不正确";
		}
        
        
        //查询name
        String name = sysuserMapper.queryUserNum(usernum).getName();
        request.getSession().setAttribute("name", name);
        //赋予角色
        getRoles(request);
        
        
        //将登录名放入session
        HttpSession Session = request.getSession();
        Session.setAttribute("usernum", usernum);
		return "登录成功";
	}
	//退出登录
	@Override
	public void login_out() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}
	//获取角色
	@Override
	public void getRoles(HttpServletRequest request) {
		//获取用户名
		String usernum = request.getParameter("usernum");
		//获取用户
		Sysuser sysuser = sysuserMapper.queryUserNum(usernum);
		try {
			int i = sysuser.getRoleid();
			Role role = new Role();
			role = roleMapper.selectByPrimaryKey(i);
			request.getSession().setAttribute("role", role.getName());
			//给予权限，菜单权限
			List<Permission> listPermission = getPermission(role);
			request.getSession().setAttribute("listPermission",listPermission);
		} catch (Exception e) {
			
		}
		
	}
	//通过角色获取权限
	@Override
	public List<Permission> getPermission(Role role) {
		List<RolepermissionKey> list = rolepermissionMapper.getlistrolepermission(role.getRoleid());
		
		List<Permission> listI = new ArrayList<Permission>();
		for (RolepermissionKey rolepermissionKey : list) {	
			Permission permission = permissionMapper.selectByPrimaryKey(rolepermissionKey.getPermissionid());
			listI.add(permission);
		}
		return listI;
	}
	
}
