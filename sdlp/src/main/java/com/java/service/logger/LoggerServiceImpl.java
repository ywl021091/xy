package com.java.service.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.dao.LoggerMapper;
import com.java.po.Loginfo;

/**
* @Author Zhao Jie 	E-mail:elmx100020@163.com
* @Date 2019年5月9日 
* @Version 1.0
*/
@Service
public class LoggerServiceImpl implements LoggerService{
	@Value("${logging.path}")
    private String logPosition;

	@Autowired
	private LoggerMapper loggerMapper;

	/**
	 * 从session中获取当前用户姓名和用户名 
	 * @return 用户姓名，姓名 
	 */
	private String getOperator(){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		HttpSession session = request.getSession();
		return session.getAttribute("name").toString()+","+session.getAttribute("usernum").toString();
	}

	/* 
	 * 分页展示数据
	 */
	public Map<String, Object> queryLogger(Integer start, Integer length, String date, String operator) {
		PageHelper.startPage(((start / length) + 1), length);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Loginfo> logList = loggerMapper.queryLogger(date, operator);
        PageInfo<Loginfo> appsPageInfo = new PageInfo<>(logList);
        // 将总页数计算封存上
        map.put("iTotalRecords", appsPageInfo.getTotal());
        map.put("iTotalDisplayRecords", appsPageInfo.getTotal());
        map.put("data", logList);
        return map;
	}
	
	/*
	 * 插入日志
	 */
	public Integer insertLog(String operation) {
		//日志生成时间
		Date now = new Date();
		String operator = getOperator();
		Loginfo logInfo = new Loginfo();
		logInfo.setDate(now);
		logInfo.setOperator(operator);
		logInfo.setOperation(operation);
		Integer i = loggerMapper.insertLog(logInfo);
		return i;
	}

	
}
