package com.java.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.po.Terminal;
import com.java.service.logger.LoggerService;
import com.java.service.terminal.TerminalServiceImpl;

@Controller
@RequestMapping("terminal")
public class TerminalController {
	@Autowired
	private TerminalServiceImpl terminalServiceImpl;
	@Autowired
	private LoggerService loggerServiceImpl;
	// 进入所有展示
	@RequestMapping("/listTerminalHtml")
	public String listTerminalHtml() {
		return "thymeleaf/terminal/listterminal.html";
	}

	// 查询所有数据
	@RequestMapping("/queryTerminal")
	@ResponseBody
	@RequiresPermissions("设备查询所有")
	public Map<String, Object> queryTerminal(int draw, int start, int length, Terminal terminal,  String customernum) {

		return terminalServiceImpl.queryTerminal(draw, (start / length) + 1, length, terminal, customernum);
	} 

	// 删除
	@RequestMapping("/deleteTerminal")
	@ResponseBody
	@RequiresPermissions("设备删除")
	public Map<String, Object> deleteTerminal(int id) {
		Map<String, Object> map = new HashMap<>();
		
		int i = terminalServiceImpl.delete(id);
		if (i == 1) {
			map.put("status", "删除成功");
			loggerServiceImpl.insertLog("删除了id为'"+id+"'的终端信息");
		}else {
			map.put("status", "此用户正在被sim卡使用中不能删除");
		}
		return map;
	}
	// 进入更改页面
	@RequestMapping("/updataTerminalHtml")
	public String updataTerminalHtml(int id) {
		return "thymeleaf/terminal/updateterminal.html";
	}
	// 获得详细信息
	@RequestMapping("/getTerminal")
	@ResponseBody
	@RequiresPermissions("设备查询详细")
	public Terminal getTerminal(int id) {
		Terminal terminal = terminalServiceImpl.queryTerminalId(id);
		return terminal;
	}
	// 更改操作
	@RequestMapping("/updataTerminal")
	@ResponseBody
	@RequiresPermissions("设备更改")
	public Map<String, Object> updataTerminal(Terminal terminal) {
		Map<String, Object> map = new HashMap<>();
		//判断num是否为空或已存在
		if(terminal.getDevicenum() == ""){
			map.put("status", "设备识别码不能为空！");
			return map;
		}
		//查询此设备识别码是否已存在！
		int i = terminalServiceImpl.queryNum(terminal.getDevicenum());
		//判断设备识别码num是否不等于未更改之前的num  且 识别码已存在
		Terminal oldTerminal = terminalServiceImpl.queryTerminalId(terminal.getTerminalid());
		if(i == 1 && !terminal.getDevicenum().equals(oldTerminal.getDevicenum())){
			map.put("status", "设备识别码已存在！");
			return map;
		}
		if(terminalServiceImpl.updata(terminal) == 1){
			map.put("status", "更改成功");
			loggerServiceImpl.insertLog("修改了设备识别码为'"+terminal.getDevicenum()+"'的终端信息");
			return map;
		}else {
			map.put("status", "更改失败请检查mac和识别码信息");
			return map;
		}
	}

	// 进入新增页面
	@RequestMapping("/insertTerminalHtml")
	public String insertTerminalHtml() {
		return "thymeleaf/terminal/insertterminal.html";
	}
	//新增操作
	@RequestMapping("/insertTerminal")
	@ResponseBody
	@RequiresPermissions("设备增加")
	public Map<String, Object> insertTerminal(Terminal terminal) {
		Map<String, Object> map = new HashMap<>();
		// 判断num是否为空或已存在
		if (terminal.getDevicenum() == "") {
			map.put("status", "设备识别码不能为空");
			return map;
		}
		// 查询此设备识别码是否已存在！
		int i = terminalServiceImpl.queryNum(terminal.getDevicenum());

		if (i == 1) {
			map.put("status", "设备识别码已存在");
			return map;
		}
		if (terminalServiceImpl.insert(terminal) == 1) {
			map.put("status", "新建成功");
			loggerServiceImpl.insertLog("添加了设备识别码为'"+terminal.getDevicenum()+"'的终端信息");
			return map;
		} else {
			map.put("status", "新建失败请检查mac和识别码信息");
			return map;
		}
	}
	//-------------------------
	//给simcard提供list
	/**
	 * 设备id获取
	 */
	@PostMapping("/getTeminalIdList")
	@ResponseBody
	public List<Integer> getTeminalList() {
		List<Integer> teminalIdList = terminalServiceImpl.getTeminalIdList();
		return teminalIdList;
	}

	/**
	 * 设备编码获取
	 */
	@PostMapping("/getTeminalNum")
	@ResponseBody
	public String getTeminalNum(Integer terminalId) {
		String teminalNum = terminalServiceImpl.getTeminalNum(terminalId);
		return teminalNum;
	}
}
