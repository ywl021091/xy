package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.java.po.Terminal;

/**
* @Author Li Zongsheng	E-mail:lizs07216819@163.com
* @Date 2019年3月14日 上午9:50:16 
* @Version 1.0
*/

@Mapper
public interface CityMapMapper {
    
    
    @Select("select devicenum,isuse,longitude,latitude,customerid from terminal where province=#{province} and city=#{city}")
    public List<Terminal> queryLongitudeAndLatitude(@Param("province")String province, @Param("city")String city);
    
    
    
    //@Select("select devicenum,isuse,longitude,latitude,customerid from terminal where province=#{province} and city=#{city}")
    @Select("select devicenum,isuse,longitude,latitude,customerid from terminal")
    public List<Terminal> queryLongitudeAndLatitudeBySBSBM(@Param("province")String province,@Param("city") String city);


    @Select("select customername from customer where customerid=#{customerid}")
    public String queryCustomername(Integer customerid);
    
}
