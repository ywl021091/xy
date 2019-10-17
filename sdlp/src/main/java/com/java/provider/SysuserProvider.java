package com.java.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年4月2日 上午8:42:03 
* 类说明 
*/
public class SysuserProvider {
		// 用户模块的复杂查询 2019/1/30 郑广润
		public String querySysuser(@Param("usernum") String usernum, @Param("name") String name, @Param("job") String job,
				@Param("dept") String dept, @Param("authority") String authority) {
			
			String sql = new SQL() {
				{
					SELECT("sysuser.sysuserid,sysuser.usernum,sysuser.name,sysuser.sex,sysuser.birthday,sysuser.address,sysuser.job,sysuser.dept,sysuser.tel,role.name as authority,sysuser.note,sysuser.lastupdate,sysuser.pass");
					FROM("sysuser");
					LEFT_OUTER_JOIN("role on sysuser.roleid = role.roleid");
					if (usernum == null || usernum == "") {
					} else {
						WHERE("sysuser.usernum like concat('%',#{usernum},'%')");
					}
					if (name == null || name == "") {
					} else {
						WHERE("sysuser.name like concat('%',#{name},'%')");
					}
					if (job == null || job == "") {
					} else {
						WHERE("sysuser.job like concat('%',#{job},'%')");
					}
					if (dept == null || dept == "" || "所有".equals(dept)) {
					} else {
						WHERE("sysuser.dept like concat('%',#{dept},'%')");
					}
					if (authority == null || authority == "") {
					} else {
						WHERE("role.name like concat('%',#{authority},'%')");
					}
				}
			}.toString();
			return sql;
		}
}
