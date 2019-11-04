package com.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.po.Terminal;
import com.java.service.citymap.CityMapService;


/**
* @Author Li Zongsheng  E-mail:lizs07216819@163.com
* @Date 2019年3月13日 上午9:05:13 
* @Version 1.0
*/


@Controller
@RequestMapping("getMap")
public class CityMapController {

    @Autowired 
    CityMapService cityMapServiceImpl;
    
    
    /**
     * 访问城市信息
     * @return 返回城市信息页面
     */
    @GetMapping("/cityMapHtml")
    public String accessCityMapHtml(HttpServletRequest request) {
        request.setAttribute("status", "正在根据您的浏览器获取当前城市信息，请稍后...");
        return "thymeleaf/cityMap/citymap.html";
    }
    //根据点击查询按钮按条件查询传入地址的经纬度
    
    @PostMapping("/query_longitude_latitude")
    @ResponseBody
    public List<Terminal> queryLongitudeAndLatitude(String province,String city) {
        
        //String sbsbm = (String)session.getAttribute("sbsbm");
        List<Terminal> longitudeAndLatitude;
        //根据条件查询部分地址的经纬度
        longitudeAndLatitude = cityMapServiceImpl.queryLongitudeAndLatitudeBySBSBM(province,city);
        for(Terminal lal : longitudeAndLatitude) {
        lal.setNote(cityMapServiceImpl.queryCustomername(lal.getCustomerid()));
        }
        return longitudeAndLatitude;
    }
    

   
}
