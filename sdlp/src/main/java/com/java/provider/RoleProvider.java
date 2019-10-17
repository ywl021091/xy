package com.java.provider;

import org.apache.ibatis.jdbc.SQL;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年6月12日 下午2:04:09 
* 角色模块的复杂查询
*/
public class RoleProvider {
	
	public String queryRole(String name) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM("role");
				if (name == null || name == "") {
				} else {
					WHERE("name like concat('%',#{name},'%')");
				}
			}
		}.toString();

		return sql;
	}

}
