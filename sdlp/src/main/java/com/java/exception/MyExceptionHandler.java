package com.java.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年3月6日 上午9:43:49 
* 类说明 
*/
@ControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public ModelAndView errHandler(HttpServletRequest request,HttpServletResponse response,Exception e) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception",e);
		modelAndView.addObject("url", request.getRequestURI());
		modelAndView.setViewName("thymeleaf/public/404.html");
		return modelAndView;
	}
}
