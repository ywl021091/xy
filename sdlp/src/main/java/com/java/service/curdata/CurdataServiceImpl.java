package com.java.service.curdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.dao.CurdataMapper;
import com.java.po.CurData;


/**
* @Author Li Zongsheng	E-mail:lizs07216819@163.com
* @Date 2019年4月2日 上午8:37:25 
* @Version 1.0
*/
@Service
public class CurdataServiceImpl implements CurdataService{
    
    @Autowired
    CurdataMapper curdataMapper;
    
    @Override
    public List<String> selectMacList() {
        List<String> macList = curdataMapper.selecMacList();
        return macList;
    }
    
   /* @Override
    public CurData selectCurData(String mac) {
        CurData curData = curdataMapper.selectCurData(mac);
        if(curData.getCs16()==null) {
            curData.setCs16((float)0);
        }
        if(curData.getCs17()==null) {
            curData.setCs17((float)0);
        }
        if(curData.getCs18()==null) {
            curData.setCs18((float)0);
        }
        if(curData.getCs19()==null) {
            curData.setCs19((float)0);
        }
        if(curData.getCs20()==null) {
            curData.setCs20((float)0);
        }
        if(curData.getCs21()==null) {
            curData.setCs21((float)0);
        }
        if(curData.getCs22()==null) {
            curData.setCs22((float)0);
        }
        if(curData.getCs24()==null) {
            curData.setCs24((float)0);
        }
        if(curData.getCs25()==null) {
            curData.setCs25((float)0);
        }
        if(curData.getCs26()==null) {
            curData.setCs26((float)0);
        }
        if(curData.getCs27()==null) {
            curData.setCs27((float)0);
        }
        if(curData.getCs28()==null) {
            curData.setCs28((float)0);
        }
        if(curData.getCs29()==null) {
            curData.setCs29((float)0);
        }
        if(curData.getCs30()==null) {
            curData.setCs30((float)0);
        }
        
        return curData;
    }
    */
    public List<CurData> selectWarn(String sbsbm){
        List<CurData> warnList;
        warnList = curdataMapper.selectWarnBySBSBM(sbsbm);
        return warnList;
    }

    @Override
    public Map<String, Object> selectWarnValue(Integer start, Integer length, String sbsbm) {
        List<CurData> warnValueList;
        warnValueList = curdataMapper.selectWarnBySBSBM(sbsbm);
        PageInfo<CurData> appsPageInfo = new PageInfo<>(warnValueList);
        Map<String, Object> map = new HashMap<String, Object>();
        // 将总页数计算封存
        map.put("iTotalRecords", appsPageInfo.getTotal());
        map.put("iTotalDisplayRecords", appsPageInfo.getTotal());
        map.put("data", warnValueList);
        return map;
    }
}
