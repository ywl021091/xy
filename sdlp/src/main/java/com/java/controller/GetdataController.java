package com.java.controller;
/**
 * @描述： getdata增、删、改、查操作——Controller层
 * @ClassName GetdataContorller
 * @author 李宗胜
 * @date 2019年2月20日 上午午11:00
 * @version 1.0
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.po.TerminalData;
import com.java.service.getdata.GetdataService;

@Controller
@RequestMapping("getdata")
public class GetdataController {
    @Autowired
    private GetdataService getdataServiceImpl;

    /**
     * 访问远程信息查询页面
     */
    @GetMapping("/queryDataHtml")
    public String queryDataHtml() {
        return "thymeleaf/getData/querydata.html";
    }

    /**
     * 访问信息展示页面
     */
    @GetMapping("/dataListHtml")
    public String getDataHtml() {
        return "thymeleaf/getData/getdata.html";
    }

    /**
     * 时间判断
     */
    @GetMapping("/if_time")
    @ResponseBody
    public String isTime(String time1, String time2) {
        String status = new String();

        if (time1 != "") {
            if (time2 != "") {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date dt1 = df.parse(time1);
                    Date dt2 = df.parse(time2);
                    if (dt1.getTime() > dt2.getTime()) {
                        status = "开始时间应小于结束时间";
                    } else if((dt2.getTime()-dt1.getTime())/1000/60/60/24>7) {
                    	status = "请选择间隔不超过7天的日期";
                    }
                } catch (ParseException e) {
                    // 可能不是时间time1，此项目无需考虑
                    e.printStackTrace();
                }
            } else {
                status = "请输入结束时间";
            }
        } else if (time2 != "") {
            status = "请输入开始时间";

        } else if ("".equals(time1) && "".equals(time2)) {

        }
        return status;
    }
    /**
     * 条件查询+分页展示 信息展示((start/length)+1),String extra_search
     */
    @PostMapping("/if_dataList")
    @ResponseBody
    public Map<String, Object> ifDataList(HttpSession session,HttpServletRequest req, Integer start, Integer length, String time1,
            String time2) {
        String sbsbm = (String)session.getAttribute("sbsbm");
        PageHelper.startPage(((start / length) + 1), length);
        Map<String, Object> map = new HashMap<String, Object>();
        List<TerminalData> dataList;
        dataList = getdataServiceImpl.ifSelectBySBSBM(time1, time2, sbsbm);
        
        PageInfo<TerminalData> appsPageInfo = new PageInfo<>(dataList);
        // 将总页数计算封存
        map.put("iTotalRecords", appsPageInfo.getTotal());
        map.put("iTotalDisplayRecords", appsPageInfo.getTotal());
        map.put("data", dataList);

        return map;
    }
    /**
     * 图表展示信息
     */
    @PostMapping("/if_dataCS")
    @ResponseBody
    public Map<String, Object> ifDataList(HttpSession session,String time1, String time2,String pfName) {
        String sbsbm = (String)session.getAttribute("sbsbm");
        Map<String, Object> map = new HashMap<String, Object>();
        /*List<Date> dataTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = new String();
        List<String> times = new ArrayList<String>();
    	List<Float> cs;
    	dataTime = getdataServiceImpl.SelectTimeBySBSBM(sbsbm,time1, time2);
        for (int i = 0; i < dataTime.size(); i++) {
            time = sdf.format(dataTime.get(i));
            times.add(time);
        }
        map.put("time", times);
    	cs = getdataServiceImpl.SelectCSBySBSBM(sbsbm,time1, time2, csName);
    	map.put("cs", cs);*/
        map = getdataServiceImpl.SelectPFBySBSBM(sbsbm, time1, time2, pfName);
     	return map;
    }

    @PostMapping("/show_sbsbm")
    @ResponseBody
    public List<String> showSBSBM(HttpSession session) {
        List<String> SBSBM = getdataServiceImpl.showSBSBM();
        List<String> SBSBM_List = new ArrayList<String>();
        String sbsbm_session = (String) session.getAttribute("sbsbm");
       // if (sbsbm_session != null&&!"所有".equals(sbsbm_session)) {
        if (sbsbm_session != null) {
            SBSBM_List.add(0, (String)session.getAttribute("sbsbm"));
            //SBSBM_List.add("所有");
            for (String sbsbm : SBSBM) {
                if (!sbsbm.equals(sbsbm_session)) {
                    SBSBM_List.add(sbsbm);
                }
            }
            
//        } else if ("所有".equals(sbsbm_session)) {
//            SBSBM_List.add(0, (String)session.getAttribute("sbsbm"));
//            for (String sbsbm : SBSBM) {
//                if (!sbsbm.equals(sbsbm_session)) {
//                    SBSBM_List.add(sbsbm);
//                }
//            }
        } else {
//            SBSBM_List.add(0, "所有");
//            session.setAttribute("sbsbm", "所有");
            for (String sbsbm : SBSBM) {
                if (!sbsbm.equals(sbsbm_session)) {
                    SBSBM_List.add(sbsbm);
                }
            }
        }

        return SBSBM_List;
    }

    @PostMapping("/toSbsbm")
    @ResponseBody
    public void toSbsbm(HttpSession session, String sbsbm) {
        session.setAttribute("sbsbm", sbsbm);
    }

    
}
