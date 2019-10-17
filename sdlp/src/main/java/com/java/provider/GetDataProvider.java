package com.java.provider;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author Li Zongsheng E-mail:lizs07216819@163.com
 * @Date 2019年4月2日 上午9:57:40
 * @Version 1.0
 */

public class GetDataProvider {
    /**
     * getdata 分页展示表的查询功能
     * 
     * @param id
     * @param phone
     * @param isUse
     * @return
     */
    public String selectGetDataList(@Param("time1") String time1, @Param("time2") String time2,
            @Param("mac") String mac) {
        String sql = new SQL() {
            {
                SELECT("batchid AS batchid,mac,devicenum,timestamp,pb1,pb2,pb3,pb4,pb5,pb6,pb7,pb8,pb9,pb10,pb11,pb12,pb13,pb14,pb15,pb16,pb17,pb18,pb19,pb20,pb21,pb22,pb23,pb24,pb25,pb26,pb27,pb28,pb29,pb30,pb31,pb32,pb33,pb34,pb35,pb36,pb37,pb38,pb39,pb40,pb41,pb42,pb43,pb44,pb45,pb46,pb47,pb48,pb49,pb50,pb51,pb52,pb53,pb54,pb55,pb56,pb57,pb58,pb59,pb60,pb61,pb62,pb63,pb64,pb65,pb66,pb67,pb68,pf1,pf2,pf3,pf4,pf5,pf6,pf7,pf8,pf9,pf10,pf11,pf12,pf13,pf14,pf15,pf16,pf17,pf18,pf19,pf20,pf21,pf22,pf23,pf24,pf25,pf26,pf27,pf28,pf29,pf30,pf31,pf32,pf33,pf34,pf35,pf36,pf37,pf38,pf39,pf40,pf41,pf42,pf43,pf44,pf45,pf46,pf47,pf48,pf49,pf50,pf51,pf52,pf53,pf54,pf55,pf56,pf57,pf58,pf59");
                FROM("terminaldata");
                if (time1 != "") {
                    if (time2 != "") {
                        WHERE("DATE_FORMAT(#{time1},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{time2},'%y-%m-%d 23:59:59')>=timestamp");
                    }
                }
                if (mac != "") {
                    WHERE("mac like CONCAT('%',#{mac},'%')");
                }
                ;
            }
        }.toString() + " order by timestamp desc";
        // System.out.println(sql);
        return sql;
    }
    public String selectGetDataListBySBSBM(@Param("sbsbm")String sbsbm,@Param("time1") String time1, @Param("time2") String time2) {
        // DATE_FORMAT('2018-01-01','%y-%m-%d %H:%i:%s')<=time and
        // DATE_FORMAT('2019-09-02','%y-%m-%d')>=time;
        String sql = new SQL() {
            {
                SELECT("batchid AS batchid,mac,devicenum,timestamp,pb1,pb2,pb3,pb4,pb5,pb6,pb7,pb8,pb9,pb10,pb11,pb12,pb13,pb14,pb15,pb16,pb17,pb18,pb19,pb20,pb21,pb22,pb23,pb24,pb25,pb26,pb27,pb28,pb29,pb30,pb31,pb32,pb33,pb34,pb35,pb36,pb37,pb38,pb39,pb40,pb41,pb42,pb43,pb44,pb45,pb46,pb47,pb48,pb49,pb50,pb51,pb52,pb53,pb54,pb55,pb56,pb57,pb58,pb59,pb60,pb61,pb62,pb63,pb64,pb65,pb66,pb67,pb68,pf1,pf2,pf3,pf4,pf5,pf6,pf7,pf8,pf9,pf10,pf11,pf12,pf13,pf14,pf15,pf16,pf17,pf18,pf19,pf20,pf21,pf22,pf23,pf24,pf25,pf26,pf27,pf28,pf29,pf30,pf31,pf32,pf33,pf34,pf35,pf36,pf37,pf38,pf39,pf40,pf41,pf42,pf43,pf44,pf45,pf46,pf47,pf48,pf49,pf50,pf51,pf52,pf53,pf54,pf55,pf56,pf57,pf58,pf59");
                FROM("terminaldata");
                if (time1 != "") {
                    if (time2 != "") {
                        WHERE("DATE_FORMAT(#{time1},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{time2},'%y-%m-%d 23:59:59')>=timestamp");
                    }
                }
                WHERE("devicenum = #{sbsbm}");
            }
        }.toString() + " order by timestamp desc";
        return sql;
    }
    
    public String selectGetDataCS8(@Param("time1") String time1, @Param("time2") String time2, @Param("mac") String mac,
            @Param("newTime") Date newTime) {
        String sql = new SQL() {
            {
                SELECT("cs8");
                FROM("getdata");
                if (time1 != "") {
                    if (time2 != "") {
                        WHERE("DATE_FORMAT(#{time1},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{time2},'%y-%m-%d 23:59:59')>=timestamp");
                    }
                } else {
                    WHERE("DATE_FORMAT(#{newTime},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{newTime},'%y-%m-%d %H:%i:%s') >=timestamp");
                }
                if (mac != "") {
                    WHERE("mac like CONCAT('%',#{mac},'%')");
                }
                ;
            }
        }.toString() + " order by timestamp ";
        return sql;
    }
    public String selectGetDataCS8BySBSBM(@Param("sbsbm")String sbsbm,@Param("time1") String time1, @Param("time2") String time2, @Param("mac") String mac,
           @Param("newTime") Date newTime) {
        String sql = new SQL() {
            {
                SELECT("cs8");
                FROM("getdata");
                if (time1 != "") {
                    if (time2 != "") {
                        WHERE("DATE_FORMAT(#{time1},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{time2},'%y-%m-%d 23:59:59')>=timestamp");
                    }
                } else {
                    WHERE("DATE_FORMAT(#{newTime},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{newTime},'%y-%m-%d %H:%i:%s') >=timestamp");
                }
                if (mac != "") {
                    WHERE("mac like CONCAT('%',#{mac},'%')");
                }
                WHERE("devicenum = #{sbsbm}");
            }
        }.toString() + " order by timestamp";
        return sql;
    }
    
    /**
     * getdata cs15余氯值查询功能
     * 
     * @param id
     * @param phone
     * @param isUser
     * @return
     */
    public String selectGetDataCS15(@Param("time1") String time1, @Param("time2") String time2,
            @Param("mac") String mac, @Param("newTime") Date newTime) {
        String sql = new SQL() {
            {
                SELECT("cs15");
                FROM("getdata");
                if (time1 != "") {
                    if (time2 != "") {
                        WHERE("DATE_FORMAT(#{time1},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{time2},'%y-%m-%d 23:59:59')>=timestamp");
                    }
                } else {
                    WHERE("DATE_FORMAT(#{newTime},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{newTime},'%y-%m-%d %H:%i:%s') >=timestamp");
                }
                if (mac != "") {
                    WHERE("mac like CONCAT('%',#{mac},'%')");
                }
                ;
            }
        }.toString() + " order by timestamp";
        return sql;
    }
    public String selectGetDataCS15BySBSBM(@Param("sbsbm")String sbsbm,@Param("time1") String time1, @Param("time2") String time2,
            @Param("mac") String mac, @Param("newTime") Date newTime) {
        String sql = new SQL() {
            {
                SELECT("cs15");
                FROM("getdata");
                if (time1 != "") {
                    if (time2 != "") {
                        WHERE("DATE_FORMAT(#{time1},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{time2},'%y-%m-%d 23:59:59')>=timestamp");
                    }
                } else {
                    WHERE("DATE_FORMAT(#{newTime},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{newTime},'%y-%m-%d %H:%i:%s') >=timestamp");
                }
                if (mac != "") {
                    WHERE("mac like CONCAT('%',#{mac},'%')");
                }
                WHERE("devicenum = #{sbsbm}");
            }
        }.toString() + " order by timestamp";
        return sql;
    }
    /**
     * 查询float类型的CS数据
     * @param time1
     * @param time2
     * @param mac
     * @param devicenum
     * @param newTime
     * @param CSdevicenum   CS序号
     * @return
     */
    public String selectGetDataCS(@Param("time1") String time1, @Param("time2") String time2,
            @Param("mac") String mac, @Param("newTime") Date newTime, @Param("csName") String csName) {
        String sql = new SQL() {
            {
                SELECT(csName);
                FROM("terminaldata");
                if (time1 != "") {
                    if (time2 != "") {
                        WHERE("DATE_FORMAT(#{time1},'%y-%m-%d %H:%i:%s')<=timestamp and DATE_FORMAT(#{time2},'%y-%m-%d %H:%i:%s')>=timestamp");
                    }
                } else {
                    WHERE("DATE_FORMAT(#{newTime},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{newTime},'%y-%m-%d %H:%i:%s') >=timestamp");
                }
                if (mac != "") {
                    WHERE("mac like CONCAT('%',#{mac},'%')");
                }
                ;
            }
        }.toString() + " order by timestamp ";
        return sql;
    }
    public String selectGetDataCSBySBSBM(@Param("sbsbm")String sbsbm,@Param("time1") String time1, @Param("time2") String time2,
            @Param("newTime") Date newTime, @Param("pfName") String pfName) {
        String sql = new SQL() {
            {
                SELECT(pfName);
                FROM("terminaldata");
                if (time1 != "") {
                    if (time2 != "") {
                        WHERE("DATE_FORMAT(#{time1},'%y-%m-%d %H:%i:%s')<=timestamp and DATE_FORMAT(#{time2},'%y-%m-%d 23:59:59')>=timestamp");
                    }
                } else {
                    WHERE("DATE_FORMAT(#{newTime},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{newTime},'%y-%m-%d %H:%i:%s') >=timestamp");
                }
          
                WHERE("devicenum = #{sbsbm}");
            }
        }.toString() + " order by timestamp ";
        return sql;
    }

    /**
     * getdata time查询功能
     * 
     * @param id
     * @param phone
     * @param isUser
     * @return
     */
    public String selectGetDataTime(@Param("time1") String time1, @Param("time2") String time2,
            @Param("mac") String mac, @Param("newTime") Date newTime) {
        String sql = new SQL() {
            {
                SELECT("timestamp");
                FROM("terminaldata");
                if (time1 != "") {
                    if (time2 != "") {
                        WHERE("DATE_FORMAT(#{time1},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{time2},'%y-%m-%d 23:59:59')>=timestamp");
                    }
                } else {
                    WHERE("DATE_FORMAT(#{newTime},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{newTime},'%y-%m-%d %H:%i:%s') >=timestamp");
                }
                if (mac != "") {
                    WHERE("mac like CONCAT('%',#{mac},'%')");
                }
                ;
            }
        }.toString() + " order by timestamp ";
        // System.out.println(sql);
        return sql;
    }
       public String selectGetDataTimeBySBSBM(@Param("sbsbm")String sbsbm,@Param("time1") String time1, @Param("time2") String time2,
                @Param("newTime") Date newTime) {
            String sql = new SQL() {
                {
                    SELECT("timestamp");
                    FROM("terminaldata");
                    if (time1 != "") {
                        if (time2 != "") {
                            WHERE("DATE_FORMAT(#{time1},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{time2},'%y-%m-%d 23:59:59')>=timestamp");
                        }
                    } else {
                        WHERE("DATE_FORMAT(#{newTime},'%y-%m-%d 00:00:00')<=timestamp and DATE_FORMAT(#{newTime},'%y-%m-%d %H:%i:%s') >=timestamp");
                    }
                    WHERE("devicenum = #{sbsbm}");
                }
            }.toString() + " order by timestamp ";
            return sql;
        }
}
