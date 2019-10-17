package com.java.service.sysuser;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.java.po.Sysuser;

public interface SysuserService {
	//增
	public int insert(Sysuser sysuser);
	//查所有
	public List<Sysuser> getlistuser();
	//更新
	public int update(Sysuser sysuser);
	//删除
	public int delete(int id);
	//通过用户名查询指定用户
	public Sysuser queryusernumSysuser(String usernum);
	//通过ID查询指定用户
	public Sysuser querySysuserId(int id);
	//分页模糊查询
	public Map<String, Object> querySysuser(int draw, int start, int length,String usernum,String name,String job,String dept,String authority);
	
	//返回部门
	public HashSet<String> queryDept();
	//重置密码
	public int resetPass(int id);
	//验证密码
	public int verifyPass(HttpServletRequest request,String oldpass);
	//修改密码
	public int updatePass(HttpServletRequest request,String oldpass,String newpass,String confirmpass);
	//验证登录唯一
	public int verifyUsernum(int id,String usernum);
	
}
