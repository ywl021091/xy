package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.java.model.SimcardResult;
import com.java.po.Simcard;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年6月18日 上午9:42:22 
* 类说明 
*/

@Mapper
public interface SimcardMapper {
	@Insert("insert into simcard(simid,phone,isuse,terminalid,note,lastupdate) values(#{simid},#{phone},#{isuse},#{terminalid},#{note},#{lastupdate})")
    public Integer insert(Simcard simcard)throws Exception;

	/**
     * 复杂查询
     */
    @SelectProvider(type=com.java.provider.SimcardProvider.class,method="selectSimList")
    public List<SimcardResult> selectSimList(@Param("simid")String simid,@Param("phone")String phone,@Param("isuse")Integer isuse,@Param("terminalid")Integer terminalid);
    /**
     * 根据id获取用户信息 
     * @param id
     * @return
     */
	 @Select("select simcard.simcardid,simcard.simid,simcard.phone,simcard.isuse,simcard.terminalid,simcard.note,simcard.lastupdate,terminal.devicenum from simcard left outer  join terminal on simcard.terminalid = terminal.terminalid  where simcardid=#{simcardid};")
	 public SimcardResult selectByid(Integer simcardid);
     /**
      * 修改用户信息
      */
     @Update("update simcard set simid=#{simid},phone=#{phone},isuse=#{isuse},terminalid=#{terminalid},note=#{note},lastupdate=#{lastupdate} where simcardid=#{simcardid}")
     public Integer update(Simcard simcard)throws Exception;
     /**
      * 根据id删除用户数据
      * @param id
      */
     @Delete("Delete from simcard where simcardid=#{simcardid}")
     public Integer delete(Integer simcardid);
     /**
      * 查一个返回指定sim卡信息
      */
     @Select("select * from simcard where simcardid = #{id}")
     public Simcard getSimcard(Integer id);
     //查询simId,保证Excel 插入数据的simId不能重复
     @Select("select simid  from simcard")
     public List<String> selectSimid();
}
