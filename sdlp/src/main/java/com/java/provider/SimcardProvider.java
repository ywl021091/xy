package com.java.provider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年6月18日 下午1:41:28 
* 类说明 
*/
public class SimcardProvider {
    /**
     * sim卡查询功能
     * 
     * @param id
     * @param phone
     * @param isUse
     * @param terminalid
     * @return
     */
    public String selectSimList(@Param("simid") String simid,@Param("phone")String phone,@Param("isuse")Integer isuse,@Param("terminalid")Integer terminalid, @Param("usernum")String usernum) {
    	        String sql = new SQL() {
            {
                SELECT("simcard.simcardid,simcard.simid,simcard.phone,simcard.isuse,simcard.terminalid,simcard.note,simcard.lastupdate,terminal.devicenum");
                FROM("simcard");
                LEFT_OUTER_JOIN("terminal on simcard.terminalid = terminal.terminalid");
                if (simid == null || simid == "") {
				} else {
					WHERE("simcard.simid like concat('%',#{simid},'%')");
				}
				if (phone == null || phone == "") {
				} else {
					WHERE("simcard.phone like concat('%',#{phone},'%')");
				}
				if (isuse == null) {
				} else {
					WHERE("simcard.isuse =#{isuse}");
				}
				if (terminalid == null) {
					WHERE("terminal.customerid in (SELECT customerid FROM usercustomer WHERE userid=(SELECT sysuserid FROM sysuser WHERE usernum = #{usernum}))");
				} else {
					WHERE("terminal.customerid in (SELECT customerid FROM usercustomer WHERE userid=(SELECT sysuserid FROM sysuser WHERE usernum = #{usernum}))");
					WHERE("simcard.terminalid like concat('%',#{terminalid},'%')");
				}
            }
        }.toString();
        return sql;
    }
}
