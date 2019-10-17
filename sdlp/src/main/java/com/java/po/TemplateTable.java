package com.java.po;

public class TemplateTable {
    private Integer templatetableid;

    private String templatetablename;

    public Integer getTemplatetableid() {
        return templatetableid;
    }

    public void setTemplatetableid(Integer templatetableid) {
        this.templatetableid = templatetableid;
    }

    public String getTemplatetablename() {
        return templatetablename;
    }

    public void setTemplatetablename(String templatetablename) {
        this.templatetablename = templatetablename == null ? null : templatetablename.trim();
    }

	public TemplateTable(Integer templatetableid, String templatetablename) {
		super();
		this.templatetableid = templatetableid;
		this.templatetablename = templatetablename;
	}

	public TemplateTable() {
		super();
	}
    
}