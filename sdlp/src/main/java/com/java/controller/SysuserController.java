package com.java.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.po.Sysuser;
import com.java.service.logger.LoggerService;
import com.java.service.logger.LoggerServiceImpl;
import com.java.service.sysuser.SysuserService;

@Controller
@RequestMapping("sysuser")
public class SysuserController {
	@Autowired
	private SysuserService SysuserServiceImpl;
	@Autowired
	private LoggerService loggerServiceImpl;
	//进入所有用户展示
	@RequestMapping("/listSysuserHtml")
	public String listsysuserHtml() {
		return "thymeleaf/sysuser/listsysuser.html";
	}
	//查询用户所有数据
	@RequestMapping("/querySysuser")
	@ResponseBody
	@RequiresPermissions("用户查询所有")
	public Object querySysuser(int draw,int start,int length,String usernum,String name,String job,String dept,String authority) {
		return SysuserServiceImpl.querySysuser(draw, (start/length)+1, length,usernum,name,job,dept,authority);
	}
	//删除用户
	@RequestMapping("/deleteSysuser")
	@ResponseBody
	@RequiresPermissions("用户删除")
	public Map<String, Object> deletesysuser(Integer id) {
			Map<String, Object> map = new HashMap<>();
			int i = SysuserServiceImpl.delete(id);
			if (i == 1) {
				map.put("status", "删除成功");
				loggerServiceImpl.insertLog("删除了id为'"+id+"'的用户");
			}else {
				map.put("status", "此用户正在被客户关联或为管理员角色不能删除");
			}
			return map;
	}
	
	//获得用户信息
	@RequestMapping("/selectSysuserUsernum")
	@ResponseBody
	public Map<String, Object> selectSysuserUsernum(String usernum) {
		Map<String, Object> map = new HashMap<>();
		Sysuser Sysuser = SysuserServiceImpl.queryusernumSysuser(usernum);
		if (Sysuser == null
				) {
			map.put("status", "400");
		}else {
			map.put("status", "200");
		}
		return map;
	}
	//进入更改页面
	@RequestMapping("/updatesysuserHtml")
	public String updatesysuserHtml(int id) {
		return "thymeleaf/sysuser/updatesysuser.html";
	}
	@RequestMapping("/selectSysuserId")
	@ResponseBody
	@RequiresPermissions("用户查询详细")
	public Sysuser selectsysuserid(int id) {
		Sysuser sysuser = SysuserServiceImpl.querySysuserId(id);
		return sysuser;
	}
	//更改用户操作
	@RequestMapping("/updateSysuser")
	@ResponseBody
	@RequiresPermissions("用户更改")
	public Map<String, Object> updateSysuser(Sysuser sysuser) {
		HashMap<String, Object> map = new HashMap<>();
		Date lastupdate = new Date();
		sysuser.setLastupdate(lastupdate);
		if(sysuser.getUsernum().equals("")|| sysuser.getUsernum() == null) {
			map.put("status", "登录名不能为空");
			return map;
		}
		if(sysuser.getName().equals("") || sysuser.getName() == null) {
			map.put("status","用户名不能为空");
			return map;
		}
		if(sysuser.getRoleid() == null) {
			map.put("status","用户角色不能为空");
			return map;
		}
		int i = SysuserServiceImpl.update(sysuser);
		if(i == 1) {
			map.put("status","更改成功");
			loggerServiceImpl.insertLog("修改了用户'"+sysuser.getName()+"'的用户信息");
			return map;
		}else {
			map.put("status","更改失败");
			return map;
		}
	}
	//进入新增用户页面
	@RequestMapping("/insertSysuserHtml")
	public String insertsysuserHtml(){
		return "thymeleaf/sysuser/insertsysuser.html";
	}
	//新增用户操作
	@RequestMapping("/insert")
	@ResponseBody
	@RequiresPermissions("用户增加")
	public Map<String,Object> insertsysuser(Sysuser sysuser) {
		HashMap<String, Object> map = new HashMap<>();
	 	//判断登录名不包含汉字空格等
        String pattern = "^[0-9a-zA-Z]+$";
        boolean isMatch = Pattern.matches(pattern, sysuser.getUsernum());
        if(!isMatch) {
        	map.put("status", "登录名只能是字母及数字");
        	return map;
        }
		if(sysuser.getUsernum().equals("")|| sysuser.getUsernum() == null) {
			map.put("status", "登录名不能为空");
			return map;
		}
		if(sysuser.getName().equals("") || sysuser.getName() == null) {
			map.put("status", "用户名不能为空");
			return map;
		}
		if(sysuser.getPass().equals("") || sysuser.getPass() == null) {
			map.put("status", "密码不能为空");
			return map;
		}
		if(sysuser.getRoleid() == null) {
			map.put("status", "用户角色不能为空");
			return map;
		}
		Date date = new Date();
		sysuser.setLastupdate(date);
		int i = SysuserServiceImpl.insert(sysuser);
		if(i == 1) {
			map.put("status", "创建成功");
			loggerServiceImpl.insertLog("添加了用户'"+sysuser.getName()+"'");
			return map;
		}else {
			map.put("status", "创建失败");
			return map;
		}
	}
	//返回部门集合
	@RequestMapping("queryDept")
	@ResponseBody
	public Map<String,Object> queryDept() {
		HashMap<String, Object> map = new HashMap<>();
		HashSet<String> list = SysuserServiceImpl.queryDept();
		map.put("list",list);
		map.put("status", "200");
		return map;		
	}
	//重置密码
	@RequestMapping("resetPass")
	@ResponseBody
	@RequiresPermissions("用户密码重置")
	public Map<String,Object> resetPass(int id) {
		HashMap<String, Object> map = new HashMap<>();
		int r = SysuserServiceImpl.resetPass(id);
		map.put("r",r);
		map.put("status", "200");
		return map;
	}
	//修改密码
	@RequestMapping("updatePass")
	@ResponseBody
	@RequiresPermissions("用户密码修改")
	public Map<String,Object> updatePass(HttpServletRequest request,String oldpass,String newpass,String confirmpass) {
		int i = SysuserServiceImpl.updatePass(request, oldpass, newpass, confirmpass);
		HashMap<String, Object> map = new HashMap<>();
		if(i == 1) {
			map.put("status", "成功");
			loggerServiceImpl.insertLog("修改密码成功");
		}else {
			map.put("status", "失败");
		}
		return map;
	}
	//验证登录名唯一
	@RequestMapping("verifyUsernum")
	@ResponseBody
	public Map<String,Object> verifyUsernum(int id,String usernum) {
		int i = SysuserServiceImpl.verifyUsernum(id, usernum);
		HashMap<String, Object> map = new HashMap<>();
		//成功返回200
		//失败返回400
		if(i == 1) {
			map.put("status", "200");
		}else {
			map.put("status", "400");
		}
		return map;
	}
}
