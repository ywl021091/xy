package com.java.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年6月13日 上午9:41:30 
* 类说明 
*/
public class SysuserResult {
    private Integer sysuserid;

    private String usernum;

    private String name;

    private String sex;
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone="GMT+8")
    private Date birthday;

    private String address;

    private String job;

    private String dept;

    private String tel;

    private String authority;

    private String note;
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone="GMT+8")
    private Date lastupdate;

    private String pass;

    public Integer getSysuserid() {
        return sysuserid;
    }

    public void setSysuserid(Integer sysuserid) {
        this.sysuserid = sysuserid;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum == null ? null : usernum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }


	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

	@Override
	public String toString() {
		return "SysuerResult [sysuserid=" + sysuserid + ", usernum=" + usernum + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", address=" + address + ", job=" + job + ", dept=" + dept + ", tel=" + tel
				+ ", authority=" + authority + ", note=" + note + ", lastupdate=" + lastupdate + ", pass=" + pass + "]";
	}
    
}
