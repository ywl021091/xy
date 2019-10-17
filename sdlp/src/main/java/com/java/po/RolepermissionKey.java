package com.java.po;

public class RolepermissionKey {
    private Integer roleid;

    private Integer permissionid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

	public RolepermissionKey(Integer roleid, Integer permissionid) {
		super();
		this.roleid = roleid;
		this.permissionid = permissionid;
	}

	public RolepermissionKey() {
		super();
	}

	public RolepermissionKey(Integer roleid) {
		super();
		this.roleid = roleid;
	}
    
}