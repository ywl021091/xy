package com.java.dao;

import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.java.model.SysuserResult;
import com.java.po.Sysuser;
@Mapper
public interface SysuserMapper {
	//查询所有用户
	@Select("select * from sysuser")
	public List<Sysuser> getlistuser();
	//增加用户
	@Insert("insert into sysuser(usernum,name,sex,birthday,address,job,dept,tel,roleid,note,lastupdate,pass) values(#{usernum},#{name},#{sex},#{birthday},#{address},#{job},#{dept},#{tel},#{roleid},#{note},#{lastupdate},#{pass})")
	public int insert(Sysuser sysuser);
	//更改用户信息
	@Update("update sysuser set usernum=#{usernum},name=#{name},sex=#{sex},birthday=#{birthday},address=#{address},job=#{job},dept=#{dept},tel=#{tel},roleid=#{roleid},note=#{note},lastupdate=#{lastupdate} where sysuserid=#{sysuserid}")
	public int update(Sysuser sysuser);
	//删除用户信息
	@Delete("Delete from sysuser where sysuserid = #{sysuserid}")
	public int delete(int sysuserid);
	//通过编号查询用户
	@Select("select sysuserid,usernum,name,sex,birthday,address,job,dept,tel,roleid,note,lastupdate from sysuser where sysuserid = #{sysuserid}")
	public Sysuser querySysuserId(int sysuserid);
	//通过用户登录名查询用户
	@Select("select * from sysuser where usernum=#{usernum}")
	public Sysuser queryUserNum(String usernum);
	//所有符合条件查询返回集合
	@SelectProvider(type=com.java.provider.SysuserProvider.class,method="querySysuser")
	public List<SysuserResult> querySysuser(@Param("usernum")String usernum,@Param("name")String name,@Param("job")String job,@Param("dept")String dept,@Param("authority")String aothority);
	//返回部门集合
	@Select("select dept from sysuser")
	public HashSet<String> queryDept();
	//重置用户密码
	@Update("update sysuser set pass=123456 where sysuserid=#{sysuserid}")
	public int resetPass(int sysuserid);
	//修改用户密码
	@Update("update sysuser set pass=#{pass} where sysuserid=#{sysuserid}")
	public int updatePass(@Param("sysuserid")int sysuserid,@Param("pass")String pass);
}