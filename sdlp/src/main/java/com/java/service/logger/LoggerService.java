package com.java.service.logger;

import java.util.Map;

/**
* @Author Zhao Jie 	E-mail:elmx100020@163.com
* @Date 2019年5月9日 
* @Version 1.0
*/
public interface LoggerService {

	//分页模糊查询
	Map<String, Object> queryLogger(Integer start, Integer length, String date, String operator);
	
	//向数据库插入日志
	Integer insertLog(String operation);
}
















