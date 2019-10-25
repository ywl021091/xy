package com.java.provider;
 
import java.util.Date;
 
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
 
import com.java.po.Terminal;
 
/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年6月14日 下午2:33:42 
* 类说明 
*/
public class TerminalProvider {
    // 终端模块的复杂查询 2019/1/30 郑广润
        public String queryTerminal(@Param("mtype")String mtype, @Param("isuse")String isuse,  @Param("owner")String owner, @Param("devicenum")String devicenum, @Param("usedate")Date usedate, @Param("terminalid") Integer terminalid, @Param("customernum") String customernum) {
            String sql = new SQL() {
                {
                    SELECT("terminal.terminalid,terminal.mtype,terminal.isuse,terminal.owner,terminal.customerid,terminal.devicenum,terminal.customerid,customer.customernum as customernum,terminal.devicenum,terminal.note,terminal.usedate,terminal.lastupdate,terminal.longitude,terminal.latitude,terminal.province,terminal.city,terminal.mac");
                    FROM("terminal");
                    LEFT_OUTER_JOIN("customer on terminal.customerid = customer.customerid");
                    if (terminalid == null) {
                    } else {
                        WHERE("terminalid = #{terminalid}");
                    }
                    if (mtype == null || mtype == "") {
                    } else {
                        WHERE("mtype like concat('%',#{mtype},'%')");
                    }
                    if (isuse == null || isuse == "") {
                    } else {
                        WHERE("isuse like concat('%',${isuse},'%')");
                    }
                    if (owner == null || owner == "") {
                    } else {
                        WHERE("owner like concat('%',#{owner},'%')");
                    }
                    if (customernum == null || customernum == "") {
                    } else {
                        WHERE("customernum like concat('%',#{customernum},'%')");
                    }
                    if (devicenum == null || devicenum == "") {
                    } else {
                        WHERE("devicenum like concat('%',#{devicenum},'%')");
                    }
                    if (usedate == null) {
                    } else {
                        WHERE("usedate = #{usedate}");
                    }
 
                }
            }.toString();
 
            return sql;
        }
}
