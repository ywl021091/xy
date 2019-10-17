package com.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.po.Permission;
import com.java.po.Role;
import com.java.service.logger.LoggerService;
import com.java.service.role.RolePermissionServiceImpl;
import com.java.service.role.RoleServiceImpl;

/**
 * @author 郑广润 E-mail: 489551132@qq.com
 * @version 创建时间：2019年3月1日 上午9:29:23 角色控制
 */
@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	@Autowired
	private RolePermissionServiceImpl rolePermissionServiceImpl;
	@Autowired
	private LoggerService loggerServiceImpl;
	// 获得信息进入更改页面
	@RequestMapping("/selectRoleId")
	@RequiresPermissions("角色权限查询详细")
	public String selectRoleid(int id) {
		if (id == 1) {
			return "redirect:listRoleHtml";
		} else {		
			return "thymeleaf/role/updaterole.html";
		}
	}
	
	// 更改权限操作
	@RequestMapping("/updateRolePermission")
	@ResponseBody
	@RequiresPermissions("角色权限更改")
	public String updateRolePermission(@RequestParam(value = "list[]") List<String> list, String str) {
		Role role = roleServiceImpl.queryusernumRole(str);
		if (role.getRoleid() == 1) {
			return "false";
		} else {
			rolePermissionServiceImpl.update(list, str);
			loggerServiceImpl.insertLog("更改了"+str+"权限");
		}
		return "succes";
	}
	// 删除权限操作
	@RequestMapping("/deleteRolePermission")
	@ResponseBody
	@RequiresPermissions("角色权限删除")
	public String deleteRolePermission(String str) {
		Role role = roleServiceImpl.queryusernumRole(str);
		if (role.getRoleid() == 1) {
			return "false";
		} else {
			rolePermissionServiceImpl.delete(str);
			loggerServiceImpl.insertLog("删除了"+str+"权限");
		}
		return "succes";
	}
	// 返回权限列表操作
	@RequestMapping("/RolePermissionJs")
	@ResponseBody
	@RequiresPermissions("角色权限查询详细")
	public Map<String, Object> RolePermissionJs(String str) {
		return rolePermissionServiceImpl.query(str);
	}
//-----------------------------------------------------权限和角色分割线
	// 进入所有角色展示
	@RequestMapping("/listRoleHtml")
	public String listRoleHtml() {
		return "thymeleaf/role/listrole.html";
	}
	
	// 查询角色所有数据
	@RequestMapping("/queryRole")
	@ResponseBody
	@RequiresPermissions("角色查询所有")
	public Map<String, Object> queryRole(int draw, int start, int length, String name) {
		return roleServiceImpl.queryRole(draw, start, length, name);
	}
	// 新增操作
	@RequestMapping("/insertRole")
	@ResponseBody
	@RequiresPermissions("角色增加")
	public Object insertRole(String name) {
		HashMap<String, Object> map = new HashMap<>();
		switch (name) {
		case "管理员":
			map.put("status", "名称不能是管理员失败");
			return map;
		case "":
			map.put("status", "新建失败");
			return map;
		default:
			int i = roleServiceImpl.insert(name);
			if (i == 1) {
				map.put("status", "新建成功");
				loggerServiceImpl.insertLog("新建了"+name+"角色");
				return map;
			} else {
				map.put("status", "新建失败");
				return map;
			}
		}
	}
	// 删除
	@RequestMapping("/deleteRole")
	@ResponseBody
	@RequiresPermissions("角色删除")
	public Map<String,Object> deleteRole(int id) {
			HashMap<String, Object> map = new HashMap<>();
			Role role = roleServiceImpl.queryRoleId(id);
			switch (id) {
			case 1:
				map.put("status", "管理员不可删除");
				break;
			default:
				int i = roleServiceImpl.delete(id);
				if(i == 1) {
					map.put("status", "删除成功");
					loggerServiceImpl.insertLog("删除了"+role.getName()+"角色");
				}else {
					map.put("status", "此角色正在被用户使用不能删除");
				}
				break;
			}
			return map;
	}
	

	// 返回所有角色类型
	@RequestMapping("/selectRole")
	@ResponseBody
	public Map<String, Object> selectRole() {
		return roleServiceImpl.query();
	}

	// 返回固定角色的所有权限
	@RequestMapping("/selectPermissionList")
	@ResponseBody
	public List<Permission> selectPermissionList(HttpSession session) {
		return roleServiceImpl.selectByName(session);
	}
	//返回指定角色信息
	@RequestMapping("/getRole")
	@ResponseBody
	public Role getRole(int id) {
		return roleServiceImpl.queryRoleId(id);
	}
	// 更改操作
	@RequestMapping("/updateRole")
	@RequiresPermissions("角色更改")
	public  String updateRole(Role role) {
		int i = roleServiceImpl.update(role);
		return "redirect:listRoleHtml";
	}
}
