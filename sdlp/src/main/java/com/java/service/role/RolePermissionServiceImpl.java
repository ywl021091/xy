package com.java.service.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.PermissionMapper;
import com.java.dao.RolepermissionMapper;
import com.java.po.Permission;
import com.java.po.Role;
import com.java.po.RolepermissionKey;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年3月11日 下午2:41:27 
* 类说明 
*/
@Service
public class RolePermissionServiceImpl implements RolePermissionService{
	@Autowired
	private RolepermissionMapper rolepermissionMapper;
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	@Autowired
	private PermissionMapper permissionMapper;
	//新增
	@Override
	public int insert(RolepermissionKey rolepermissionKey) {
		return rolepermissionMapper.insert(rolepermissionKey);
	}
	//删除全部关系
	@Override
	public int delete(String name) {
		Role role = roleServiceImpl.queryusernumRole(name);
		return rolepermissionMapper.deleteByPrimaryKey(role.getRoleid());
	}
	//全部删除重新赋值
	@Override
	public int update(List<String> list,String name) {
		Role role = roleServiceImpl.queryusernumRole(name);
		rolepermissionMapper.deleteByPrimaryKey(role.getRoleid());
		RolepermissionKey rolepermissionKey = new RolepermissionKey(role.getRoleid());
		for (int i = 0; i < list.size(); i++) {
			Permission permission = permissionMapper.selectByname(list.get(i));
			rolepermissionKey.setPermissionid(permission.getPermissionid());
			insert(rolepermissionKey);
		}
		return 0;
	}
	//创建已有权限和可赋予权限列表
	@Override
	public Map<String, Object> query(String name) {
		//获取所有权限列表
		List<Permission> list = permissionMapper.query();
		//获取角色id
		Role role = roleServiceImpl.queryusernumRole(name);
		//获取本角色权限列表
		List<RolepermissionKey> list2= rolepermissionMapper.getlistrolepermission(role.getRoleid());
		//可赋予权限
		List<String> strlist1 = new ArrayList<>();
		//已有权限
		List<String> strlist2 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			strlist1.add(list.get(i).getName());
		}
		for (int i=0; i<list2.size(); i++) {
			int fid = list2.get(i).getPermissionid();
			Permission permission = permissionMapper.selectByPrimaryKey(fid);
			strlist2.add(permission.getName());
		}
		strlist1.removeAll(strlist2);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("strlist1", strlist1);
		resultMap.put("strlist2", strlist2);
		return resultMap;
	}
}
