package com.java.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

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
    public String selectSimList(@Param("simid") String simid,@Param("phone")String phone,@Param("isuse")Integer isuse,@Param("terminalid")Integer terminalid) {
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
				} else {
					WHERE("simcard.terminalid like concat('%',#{terminalid},'%')");
				}
            }
        }.toString();
        return sql;
    }
}
