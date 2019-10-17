package com.java.service.getdata;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.java.po.GetData;
import com.java.po.TerminalData;


/**
 * @Author Li Zongsheng E-mail:lizs07216819@163.com
 * @Date 2019年4月2日 上午8:39:53
 * @Version 1.0
 */

public interface GetdataService {
	public List<TerminalData> ifSelect(String time1, String time2, String mac);

	public List<Integer> SelectCS8(String time1, String time2, String mac);
	
	public List<Float> SelectCS15(String time1, String time2, String mac);
	
	public List<Float> SelectCS(String time1, String time2, String mac, String CSName);

	public List<Date> SelectTime(String time1, String time2, String mac);

//	public List<Byte> SelectCS39(String time1, String time2, String mac, String devicenum);

    public List<String> showSBSBM();

    public List<TerminalData> ifSelectBySBSBM(String time1, String time2, String sbsbm);


    public List<Integer> SelectCS8BySBSBM(String sbsbm,String time1, String time2, String mac);
    public List<Float> SelectCSBySBSBM(String sbsbm,String time1, String time2, String CSName);
    public List<Float> SelectCS15BySBSBM(String sbsbm,String time1, String time2, String mac);
//    public List<Byte> SelectCS39BySBSBM(String sbsbm,String time1, String time2, String mac, String devicenum);

    public List<Date> SelectTimeBySBSBM(String sbsbm, String time1, String time2);
    //新图表查询数据接口
    public Map<String, Object> SelectPFBySBSBM(String sbsbm,String time1, String time2, String pfName);
}
