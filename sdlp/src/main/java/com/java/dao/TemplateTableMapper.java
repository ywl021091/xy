package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.java.po.TemplateTable;
import com.java.po.TemplateTableContrast;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年8月26日 下午3:00:15 
* 终端类型表（模板表）和 终端类型模板参数关系表 
*/
@Mapper
public interface TemplateTableMapper {
	//增加终端类型
	@Insert("insert into templatetable(templatetablename) values(#{templatetablename})")
	public int insertTemplateTable(String templatetablename);
	//增加终端类型与参数关系
	@Insert("insert into templatetablecontrast(templatetablename,templatenum) values(#{templatetablename},#{templatenum})")
	public int insertTemplateTableContrast(TemplateTableContrast templatetablecontrast);
	//通过名称查所有终端类型名称
	@Select("select * from templatetable where templatetablename like concat('%',#{templatetablename},'%')")
	public List<TemplateTable> getListTemplateTable(String templatetablename);
	//删除终端类型信息
	@Delete("delete from templatetable where templatetablename = #{templatetablename}")
	public int deleteTemplateTable(String templatetablename);
	//删除终端类型与模板参数关系
	@Delete("delete from templatetablecontrast where templatetablename = #{templatetablename}")
	public int deleteTemplateTableContrast(String templatetablename);
	//通过名称查一个终端所有参数
	@Select("select * from templatetablecontrast where templatetablename = #{templatetablename}")
	public List<TemplateTableContrast> query(String templatetablename);

	

}
