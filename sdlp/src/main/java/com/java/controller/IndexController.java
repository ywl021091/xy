package com.java.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.model.TerminalDataResult;
import com.java.service.index.IndexService;

/** 
* @author 赵杰
* @version 创建时间：2019年8月1日 
* 首页刷新数据的方法
*/
@Controller
@RequestMapping("indexRefresh")
public class IndexController {
	
	@Autowired
	private IndexService indexServiceImpl;
	
	/*
	 * 刷新设备各个状态值
	 */
	@PostMapping("/refresh")
	@ResponseBody
	public TerminalDataResult RefreshData(HttpSession session) {
		String sbsbm = (String)session.getAttribute("sbsbm");
		return indexServiceImpl.selectLastData(sbsbm);
	}
}
