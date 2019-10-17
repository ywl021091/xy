package com.java.controller;

import java.text.ParseException;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.logger.LoggerService;

/**
 * @描述 logger增、删、查操作controller层
 * @ClassName LoggerController
 * @author 赵杰
 * @date 2019年5月9日
 * @version 1.0
 */
@Controller
@RequestMapping("logger")
public class LoggerController {

	@Autowired
	private LoggerService logServiceImpl;
	

	// 进入所有用户展示
	@GetMapping("/getLoggerHtml")
	public String listLoggerHtml() throws ParseException {
		
		return "thymeleaf/logger/getlogger.html";
	}
	// 查询日志所有数据
	@PostMapping("/queryLogger")
	@ResponseBody
	@RequiresPermissions("日志查询")
	public Map<String, Object> querySysuser(Integer draw, Integer start, Integer length, String date, String operator) {
        return logServiceImpl.queryLogger(start, length, date, operator);
	}


}
