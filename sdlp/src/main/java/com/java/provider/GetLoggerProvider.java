package com.java.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class GetLoggerProvider {

	public String queryLogger(@Param("date")String date, @Param("operator")String operator){
		String sql = new SQL(){
			{
				SELECT("date, operator, operation");
				FROM("loginfo");
				if (date == null || date == "") {
				} else {
					WHERE("DATE_FORMAT(#{date},'%y-%m-%d 00:00:00')<=date and DATE_FORMAT(#{date},'%y-%m-%d 23:59:59')>=date");
				}
				 if (operator != "") {
	                    WHERE("operator like CONCAT('%',#{operator},'%')");
	                }
			}
		}.toString() + " order by date desc";
		return sql;
	}
}
