package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.java.model.TerminalResult;
import com.java.po.Terminal;

@Mapper
public interface TerminalMapper {
	 @Insert("insert into terminal(mtype,isuse,owner,customerid,devicenum,note,usedate,lastupdate,longitude,latitude,province,city,mac) values(#{mtype},#{isuse},#{owner},#{customerid},#{devicenum},#{note},#{usedate},#{lastupdate},#{longitude},#{latitude},#{province},#{city},#{mac})")
	 public int insert(Terminal terminal);
	 @Update("update terminal set mtype=#{mtype},isuse=#{isuse},owner=#{owner},customerid=#{customerid},devicenum=#{devicenum},note=#{note},usedate=#{usedate},lastupdate=#{lastupdate},longitude=#{longitude},latitude=#{latitude},province=#{province},city=#{city},mac=#{mac} where terminalid=#{terminalid}")
	 public int update(Terminal terminal);
	 @Delete("delete from terminal where terminalid=#{terminalid}")
	 public int delete(int terminalid);
	 @Select("select * from terminal where terminalid=#{terminalid}")
	 public Terminal queryTerminalId(int terminalid);
	 @Select("select count(1) from terminal where devicenum=#{devicenum}")
	 public int queryNum(String num);
	 @SelectProvider(type=com.java.provider.TerminalProvider.class,method="queryTerminal")
	 public List<TerminalResult> queryTerminal(@Param("terminal")Terminal terminal, @Param("customernum")String customernum);
	 @Select("select terminalid from terminal")
     public List<Integer> getTeminalIdList();
     @Select("select devicenum from terminal where terminalid = #{terminalid}")
     public String getTeminalNum(Integer id);
}