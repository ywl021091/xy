package com.java.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.po.CurData;
import com.java.service.curdata.CurdataService;

/**
* @Author Li Zongsheng	E-mail:lizs07216819@163.com
* @Date 2019年4月2日 上午8:34:40 
* @Version 1.0
*/
@Controller
@RequestMapping("warn")
public class CurdataController {
    
    @Autowired
    CurdataService warnServiceImpl;
    
    //进入警告信息
    @GetMapping("/warnMessageHtml")
    public String warningMessageHtml() {
        return "thymeleaf/curData/warnmessage.html";
    }
    //警告信息
    @PostMapping("/selectWarn")
    @ResponseBody
    public List<CurData> selectWarn(HttpSession session) {
        String sbsbm = (String)session.getAttribute("sbsbm");
        System.out.println(warnServiceImpl.selectWarn(sbsbm));
        return warnServiceImpl.selectWarn(sbsbm);
    }
    
    //进入显示设备正常值
    @GetMapping("/warnMessage2Html")
    public String warningMessage2Html() {
        return "thymeleaf/curData/warnmessage2.html";
    }
    //显示设备正常值
    @PostMapping("/selectWarnValue")
    @ResponseBody
    public Map<String, Object> selectWarnValue(HttpSession session,Integer start, Integer length) {
        String sbsbm = (String)session.getAttribute("sbsbm");
    	return warnServiceImpl.selectWarnValue(start, length, sbsbm);
    }
    /**
     * 导航栏方式进入控制指令界面mac号的显示
     */
    @PostMapping("/selectMac")
    @ResponseBody
   public List<String> selectMac(){
        List<String> macList = warnServiceImpl.selectMacList();
        return macList;
    }
    /**
     * 通过信息警告页面和导航栏进入不同的控制指令页面
    
    @PostMapping("/selectCurDataByMac")
    @ResponseBody
    public CurData selectCurData(String mac) {
            CurData curData = warnServiceImpl.selectCurData(mac);
        return curData;
    }
     */
    
    
}
