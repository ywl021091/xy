package com.java.service.getdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.GetdataMapper;
import com.java.po.GetData;
import com.java.po.TerminalData;

/**
 * @描述： getdata增、删、改、查操作——Service层
 * 
 * @ClassName GetdataService
 * @author 李宗胜
 * @date 2019年2月21日 下午15:28
 * @version 1.0
 */
@Service
public class GetdataServiceImpl implements GetdataService {
	@Autowired
	private GetdataMapper getdataMapper;

	/**
	 * 展示46个字段,表
	 */
	public List<TerminalData> ifSelect(String time1, String time2, String mac) {
		// List<Getdata> dataList = getdataMapper.getlistgetdata();
		List<TerminalData> dataList = getdataMapper.ifSelect(time1, time2, mac);
		return dataList;
	}

	/**
	 * 时间，图
	 */
	public List<Date> SelectTime(String time1, String time2, String mac) {
		Date newTime = new Date();
		List<Date> dataTime = getdataMapper.getlistTime(time1, time2, mac, newTime);
		return dataTime;
	}

	/**
	 * 缺水报警，图
	 */
//	public List<Byte> SelectCS39(String time1, String time2, String mac, String devicenum) {
//		List<Byte> dataCS39 = getdataMapper.getlistcs39(time1, time2, mac, devicenum);
//		return dataCS39;
//	}

	/**
	 * 余氯值，图
	 */
	public List<Float> SelectCS15(String time1, String time2, String mac) {

		Date newTime = new Date();
		// String newTime = time;
		List<Float> dataCS15 = getdataMapper.getlistcs15(time1, time2, mac, newTime);
		// System.out.println("Service:"+dataCS15);
		return dataCS15;
	}
	
	public List<Integer> SelectCS8(String time1, String time2, String mac) {

		Date newTime = new Date();
		// String newTime = time;
		List<Integer> dataCS8 = getdataMapper.getlistcs8(time1, time2, mac, newTime);
		// System.out.println("Service:"+dataCS15);
		return dataCS8;
	}

	/**
	 * 按参数查CS,仅限Float型，图
	 */
	public List<Float> SelectCS(String time1, String time2, String mac, String csName) {
		Date newTime = new Date();
		// String newTime = time;
		List<Float> dataCS = getdataMapper.getlistcs(time1, time2, mac, newTime, csName);
		// System.out.println("Service:"+dataCS15);
		return dataCS;
	}

    @Override
    public List<String> showSBSBM() {
        List<String> SBSBM = getdataMapper.showSBSBM();
        return SBSBM;
    }

    @Override
    public List<TerminalData> ifSelectBySBSBM(String time1, String time2, String sbsbm) {
        List<TerminalData> dataList = getdataMapper.ifSelectBySBSBM(time1, time2, sbsbm);
        return dataList;
    }

    @Override
    public List<Integer> SelectCS8BySBSBM(String sbsbm, String time1, String time2, String mac) {
        Date newTime = new Date();
        List<Integer> dataCS8 = getdataMapper.getlistcs8BySBSBM(sbsbm,time1, time2, mac, newTime);
        return dataCS8;
    }

    @Override
    public List<Float> SelectCSBySBSBM(String sbsbm, String time1, String time2, String csName) {
        Date newTime = new Date();
        List<Float> dataCS = getdataMapper.getlistcsBySBSBM(sbsbm,time1, time2, newTime, csName);
        return dataCS;
    }

    @Override
    public List<Float> SelectCS15BySBSBM(String sbsbm, String time1, String time2, String mac) {
        Date newTime = new Date();
        List<Float> dataCS15 = getdataMapper.getlistcs15BySBSBM(sbsbm,time1, time2, mac, newTime);
        return dataCS15;
    }


    @Override
    public List<Date> SelectTimeBySBSBM(String sbsbm, String time1, String time2) {
        Date newTime = new Date();
        List<Date> dataTime = getdataMapper.getlistTimeBySBSBM(sbsbm,time1, time2, newTime);
        return dataTime;
    }

    //新图表数据查询接口
	@Override
	public Map<String, Object> SelectPFBySBSBM(String sbsbm, String time1, String time2, String pfName) {
		//投加运行频率
		String[]  pfName1 = {"pf40", "pf41", "pf42"};
		//电解槽温度值
		String[]  pfName2 = {"pf28", "pf29", "pf30"};
		//余氯值
		String[]  pfName3 = {"pf43"};
		//电解累计分钟
		String[]  pfName4 = {"pf16", "pf17", "pf18"};
		//电解电压实际值
		String[]  pfName5 = {"pf25", "pf26", "pf27"};
		//流量值
		String[]  pfName6 = {"pf51"};
		List<String[]> list = new ArrayList<String[]>();
		list.add(pfName1);
		list.add(pfName2);
		list.add(pfName3);
		list.add(pfName4);
		list.add(pfName5);
		list.add(pfName6);
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i = 1; i<=6; i++) {
			if(("data"+i).equals(pfName) ) {
				map = SelectPF(sbsbm, time1, time2, list.get(i-1));
			}
		}
        List<Date> dataTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = new String();
        List<String> times = new ArrayList<String>();
    	dataTime = SelectTimeBySBSBM(sbsbm,time1, time2);
        for (int i = 0; i < dataTime.size(); i++) {
            time = sdf.format(dataTime.get(i));
            times.add(time);
        }
        map.put("time", times);
     	return map;
	}
	
	/*
	 * 将数组中包含的要查的数据查出封装到map中，命名pf0，pf1，pf2。。。
	 */
	private Map<String, Object>  SelectPF(String sbsbm, String time1, String time2, String[] pfName){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Float> pf;
		Date newTime = new Date();
		map.put("pf1", "");
		map.put("pf2", "");
		for(int i = 0; i < pfName.length; i++) {
			pf = getdataMapper.getlistcsBySBSBM(sbsbm,time1, time2, newTime, pfName[i]);
			map.put("pf"+i, pf);
		}
		return map;
		
	}
}
