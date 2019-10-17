package com.java.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.model.SimcardResult;
import com.java.po.Simcard;
import com.java.service.logger.LoggerService;
import com.java.service.logger.LoggerServiceImpl;
import com.java.service.login.LoginServiceImpl;
import com.java.service.simcard.SimcardService;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年6月18日 上午9:39:05 
* 类说明 
*/

@Controller
@RequestMapping("simcard")
public class SimcardController {
	@Autowired
	private SimcardService simcardServiceImpl;
	@Autowired
	private LoggerService loginServiceImpl;
	/**
	 * 添加sim用户，完成
	 */
	@GetMapping("/addSim")
	public String addSim() {
		return "thymeleaf/simcard/addsiminfo.html";
	}
	/**
	 * 添加用户，保存操作
	 */
	@PostMapping("/addsimlist")
	@ResponseBody
	@RequiresPermissions("sim卡增加")
	public Map<String, Object> addSimList(Simcard simcard) {
		Map<String, Object> map = new HashMap<>();
		if (simcard.getSimid() == "") {
			map.put("status", "SIM编号不能为空！");
			return map;
		} else {
			int row = simcardServiceImpl.insert(simcard);
			if (row == 1) {
				map.put("status", "创建成功");
				loginServiceImpl.insertLog("添加了SIM卡编号'"+simcard.getSimid()+"'的SIM卡信息");
				return map;
			} else {
				map.put("status", "此SIM编号已存在！");
				return map;
			}
		}
	}
	/**
	 * 获取sim列表
	 */
	@GetMapping("/sim_index")
	public String getsimlist() {
		return "thymeleaf/simcard/simcard.html";
	}
	//复制查询
	@PostMapping("/simlist")
	@ResponseBody
	@RequiresPermissions("sim卡查询所有")
	public Map<String, Object> simlist(Integer start, Integer length, String simid, String phone, Integer isuse,
			Integer terminalid) {
		return simcardServiceImpl.selectSimList(start, length,simid, phone, isuse, terminalid);
	}
	/**
	 * 进入修改用户信息页面
	 */
	@GetMapping("/setSim")
	public String setSim(int simcardid) {
		return "thymeleaf/simcard/updatesiminfo.html";
	}

	/**
	 * 修改后保存。
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("/set_simlist")
	@ResponseBody
	@RequiresPermissions("sim卡更改")
	public Map<String, Object> setSimList(Simcard simcard) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<>();
		switch (simcard.getSimid()) {
		case "":
			map.put("status", "SIM编号不能为空！");
			return map;
		default:
			if (simcardServiceImpl.setSimList(simcard) == 1) {
				map.put("status", "修改成功");
				loginServiceImpl.insertLog("修改了SIM卡编号'"+simcard.getSimid()+"'的SIM卡信息");
				return map;
			} else {
				map.put("status", "此SIM编号已存在！");
				return map;
			}
		}
	}
	/**
	 * 删除操作
	 */
	@PostMapping("/del_simInfo")
	@ResponseBody
	@RequiresPermissions("sim卡删除")
	public String delSimList(Integer simcardid) {
		if (simcardServiceImpl.delSimList(simcardid) == 1) {
			loginServiceImpl.insertLog("删除了id为'"+simcardid+"'的SIM卡信息");
			return "删除成功";
		} else {
			return "删除失败，请联系管理员";
		}
	}
	/**
	 * 返回指定SIM卡信息
	 */
	@RequestMapping("/getSimcard")
	@ResponseBody
	@RequiresPermissions("sim卡查询详细")
	public SimcardResult getSimcard(Integer id) {
		return simcardServiceImpl.selectId(id);
	}
	
	// 批量导入导出Excel功能
	@PostMapping("/importExcel")
	@Transactional
	@RequiresPermissions("sim卡批量导入")
	public String uploadExcel(@RequestParam("file") MultipartFile file, HttpServletRequest req) {
		// String fileName = file.getOriginalFilename();
		// String contentType = file.getContentType();
		if (file.isEmpty()) {
			req.setAttribute("status", "文件为空！");
			return "thymeleaf/simcard/simCard";
		} else {
			// 实体类集合
			List<Simcard> simInfoList = new ArrayList<Simcard>();
			// 根据路径获取这个操作excel的实例
			// excel的文档对象
			try (HSSFWorkbook wb = new HSSFWorkbook(file.getInputStream());) {
				// 根据页面index 获取sheet页
				// excel的表单,获取第一张表
				HSSFSheet sheet = wb.getSheetAt(0);
				// 声明行
				// excel的行
				HSSFRow row = null;
				// 循环sheet页中数据从第二行开始，第一行是标题
				// sheet.getPhysicalNumberOfRows()获得的实际行数,不一定有数据的行数。
				Date now = new Date();
				for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
					
					row = sheet.getRow(i);
					Simcard simInfo = new Simcard();
					if (row.getCell(0) == null || "".equals(row.getCell(0))) {
						continue;
					}
					row.getCell(0).setCellType(CellType.STRING);
					row.getCell(1).setCellType(CellType.STRING);
					row.getCell(2).setCellType(CellType.STRING);
					row.getCell(3).setCellType(CellType.STRING);
					row.getCell(4).setCellType(CellType.STRING);
					simInfo.setSimid(row.getCell(0).getStringCellValue());
					simInfo.setPhone(row.getCell(1).getStringCellValue());
					String isUseString = row.getCell(2).getStringCellValue().toString();
					Short isUse;
					if ("启用".equals(isUseString)) {
						isUse = 0;
					} else if ("停用".equals(isUseString)) {
						isUse = 1;
					} else if ("作废".equals(isUseString)) {
						isUse = 2;
					} else {
						isUse = null;
					}
					simInfo.setIsuse(isUse);
					simInfo.setTerminalid(Integer.valueOf(row.getCell(3).getStringCellValue()));
					simInfo.setNote(row.getCell(4).getStringCellValue());
					simInfo.setLastupdate(now);
					simInfoList.add(simInfo);
				}
			} catch (Exception e) {
				req.setAttribute("status", "请检查文件内容格式！");
				return "thymeleaf/simcard/simcard.html";
			}
			for (Simcard simInfo : simInfoList) {
				if (!simcardServiceImpl.selectSimid(simInfo.getSimid())) {
					throw new RuntimeException("sim卡编号:" + simInfo.getSimid() + "重复或已存在！");
					
				}
				simcardServiceImpl.insert(simInfo);
				loginServiceImpl.insertLog("批量导入了SIM卡编号'"+simInfo.getSimid()+"'的SIM卡信息");
			}
			
			return "redirect:sim_index";
		}

	}
}
