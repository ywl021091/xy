package com.java.dao;

import java.util.Date;
/**
 * @描述： getdata增、删、改、查操作——Mapper层
 * @ClassName GetdataMapper
 * @author 李宗胜
 * @date 2019年2月21日 下午15:26
 * @version 1.0
 */
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.java.po.GetData;
import com.java.po.TerminalData;


@Mapper
public interface GetdataMapper {
	@SelectProvider(type = com.java.provider.GetDataProvider.class, method = "selectGetDataCS8")
	public List<Integer> getlistcs8(@Param("time1") String time1, @Param("time2") String time2,
			@Param("mac") String mac, @Param("newTime") Date newTime);

	/**
	 * 同时更新图、表CS15
	 * 
	 * @return
	 */
	@SelectProvider(type = com.java.provider.GetDataProvider.class, method = "selectGetDataCS15")
	public List<Float> getlistcs15(@Param("time1") String time1, @Param("time2") String time2, @Param("mac") String mac,
			 @Param("newTime") Date newTime);

	/**
	 * 同时更新图、表CS
	 * 
	 * @return
	 */
	@SelectProvider(type = com.java.provider.GetDataProvider.class, method = "selectGetDataCS")
	public List<Float> getlistcs(@Param("time1") String time1, @Param("time2") String time2, @Param("mac") String mac, 
			@Param("newTime") Date newTime, @Param("csName") String csName);

	/**
	 * 查询时间
	 * 
	 * @return
	 */
	@SelectProvider(type = com.java.provider.GetDataProvider.class, method = "selectGetDataTime")
	public List<Date> getlistTime(@Param("time1") String time1, @Param("time2") String time2, @Param("mac") String mac, @Param("newTime") Date newTime);

	/**
	 * 复杂查询
	 */
	@SelectProvider(type = com.java.provider.GetDataProvider.class, method = "selectGetDataList")
	public List<TerminalData> ifSelect(@Param("time1") String time1, @Param("time2") String time2, @Param("mac") String mac);

	@Select("select devicenum from terminal group by devicenum")
    public List<String> showSBSBM();

	@SelectProvider(type = com.java.provider.GetDataProvider.class, method = "selectGetDataListBySBSBM")
    public List<TerminalData> ifSelectBySBSBM(@Param("time1") String time1, @Param("time2") String time2, @Param("sbsbm")String sbsbm);

	@SelectProvider(type = com.java.provider.GetDataProvider.class, method = "selectGetDataCS8BySBSBM")
    public List<Integer> getlistcs8BySBSBM(@Param("sbsbm")String sbsbm,@Param("time1") String time1, @Param("time2") String time2,
            @Param("mac") String mac, @Param("newTime") Date newTime);

	@SelectProvider(type = com.java.provider.GetDataProvider.class, method = "selectGetDataCSBySBSBM")
    public List<Float> getlistcsBySBSBM(@Param("sbsbm")String sbsbm,@Param("time1") String time1, @Param("time2") String time2,
            @Param("newTime") Date newTime, @Param("pfName") String pfName);

	@SelectProvider(type = com.java.provider.GetDataProvider.class, method = "selectGetDataTimeBySBSBM")
    public List<Date> getlistTimeBySBSBM(@Param("sbsbm")String sbsbm,@Param("time1") String time1, @Param("time2") String time2, @Param("newTime") Date newTime);

	@SelectProvider(type = com.java.provider.GetDataProvider.class, method = "selectGetDataCS15BySBSBM")
    public List<Float> getlistcs15BySBSBM(@Param("sbsbm")String sbsbm,@Param("time1") String time1, @Param("time2") String time2, @Param("mac") String mac,
            @Param("newTime") Date newTime);
}
