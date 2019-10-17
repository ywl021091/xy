package com.java.service.role;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.dao.PermissionMapper;
import com.java.dao.RoleMapper;
import com.java.dao.RolepermissionMapper;
import com.java.po.Permission;
import com.java.po.Role;
import com.java.po.RolepermissionKey;
import com.java.service.logger.LoggerService;
/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年3月1日 上午9:24:51 
* 角色控制
*/
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private RolepermissionMapper rolepermissionMapper;
	
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private LoggerService loggerServiceImpl;
	@Override
	public int insert(String name) {
		int i = 0;
		try {
			i = roleMapper.insert(name);
		} catch (Exception e) {
		}
		return i;
	}
	@Override
	public int delete(int roleid) {
		int i = 0;
		try {
			i = roleMapper.deleteByPrimaryKey(roleid);
		} catch (Exception e) {
		}
		return i;
	}
	@Override
	public int update(Role role) {
		int i = 0;
		HashMap<String, Object> map = new HashMap<>();
		Role role2 = queryRoleId(role.getRoleid());
		switch (role.getName()) {
		case "管理员":
		case "":
		default:
			try {
				i = roleMapper.update(role);
			} catch (Exception e) {
			}
		}
		if(i == 1) {
			loggerServiceImpl.insertLog(role2.getName()+"角色名更改为"+role.getName()+"角色名称");
		}
		return i;
	}
	@Override
	public Role queryusernumRole(String name) {
		
		return roleMapper.selectByName(name);
	}
	@Override
	public Role queryRoleId(int id) {
		try {
			return roleMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public Map<String, Object> queryRole(int draw, int start, int length,String name) {
		// 使用PageHelper分页
		PageHelper.startPage((start / length) + 1, length,"roleid");
		List<Role> list = roleMapper.queryRole(name);
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		// 将得到的pageinfo类放进map方便前台展示
		Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("draw",draw);
        resultMap.put("recordsTotal",pageInfo.getTotal());
        resultMap.put("recordsFiltered",pageInfo.getTotal());
        resultMap.put("data",list);
		return resultMap;
	}
	@Override
	public Map<String, Object> query() {
		List<Role> list = roleMapper.queryRole("");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("list", list);
		return resultMap;
	}
	@Override
	public List<Permission> selectByName(HttpSession session) {
		//在session获取对象角色名
		String name = (String) session.getAttribute("role");
		
		Role role = roleMapper.selectByName(name);
		//通过角色对象的编号获取权限对应关系
		List<RolepermissionKey> list = rolepermissionMapper.getlistrolepermission(role.getRoleid());
		//生成返回集合
		List<Permission> listResult = new ArrayList<>();
		//处理对应关系返回权限集合
		for (int i = 0; i < list.size(); i++) {
			Permission permission = permissionMapper.selectByPrimaryKey(list.get(i).getPermissionid());
			listResult.add(permission);
		}
		return listResult;
	}
	
}
