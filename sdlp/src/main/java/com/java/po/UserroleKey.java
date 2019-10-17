package com.java.po;

public class UserroleKey {
    private Integer userid;

    private Integer roleid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

	public UserroleKey(Integer userid, Integer roleid) {
		super();
		this.userid = userid;
		this.roleid = roleid;
	}

	public UserroleKey() {
		super();
	}

	@Override
	public String toString() {
		return "UserroleKey [userid=" + userid + ", roleid=" + roleid + "]";
	}
    
}