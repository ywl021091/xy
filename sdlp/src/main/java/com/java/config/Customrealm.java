package com.java.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.dao.PermissionMapper;
import com.java.dao.RoleMapper;
import com.java.dao.RolepermissionMapper;
import com.java.po.Role;
import com.java.po.RolepermissionKey;
import com.java.po.Sysuser;
import com.java.service.sysuser.SysuserServiceImpl;

public class Customrealm extends AuthorizingRealm{
	@Autowired
	private SysuserServiceImpl sysuserService;
	
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RolepermissionMapper rolepermissionMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	//角色认证 role（职位）
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String usernum = (String)principals.getPrimaryPrincipal();
		//从数据库或缓存中获取角色数据
		Set<String> roles = getRoles(usernum);
		//获取权限数据
		Set<String> permissions = new HashSet<>();
		
		for (String str : roles) {
			Set<String> permissionlist = getPermission(str);
			permissions.addAll(permissionlist);
		}
		
		//验证
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.setStringPermissions(permissions);
		simpleAuthorizationInfo.setRoles(roles);
		return simpleAuthorizationInfo;
	}
	//用户身份验证(账号密码)
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	    //1.从主体传过来的认证信息中，获得用户名 
		String usernum = (String)token.getPrincipal();
		//2通过用户名到数据库中获取凭证
		String password = getpassword(usernum);
		if (password == null|| password == "") {
			return null;
		}
		//加密
		//Md5Hash md5Hash = new Md5Hash(password,"yan");
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(usernum, password,"customrealm");
		return authenticationInfo;
	}
	//根据service方法获取用户密码
	private String getpassword(String usernum) {
		Sysuser sysuser = sysuserService.queryusernumSysuser(usernum);
		return sysuser.getPass();
	} 
	//从数据库或缓存中获取角色数据方法
	private Set<String> getRoles(String usernum){
	    Set<String> set = new HashSet<String>();
		Sysuser sysuser = sysuserService.queryusernumSysuser(usernum);
	    int i = sysuser.getRoleid();
	       
	    set.add(roleMapper.selectByPrimaryKey(i).getName());    
		return set;
	}
	
	
	//获取权限数据方法
	private Set<String> getPermission(String rolename){
	    Set<String> set = new HashSet<String>();
        Role role = roleMapper.selectByName(rolename);
        List<RolepermissionKey> list = rolepermissionMapper.getlistrolepermission(role.getRoleid());
        for (int i = 0; i < list.size(); i++) {
            int r = list.get(i).getPermissionid();
            set.add(permissionMapper.selectByPrimaryKey(r).getName());
        }
		return set;
		
	}
}
