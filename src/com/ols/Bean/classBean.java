package com.ols.Bean;

import java.util.Date;

//数据库支部表映射
public class classBean {
     private int c_id;
     private String c_name;
     private Date c_date;
     private int p_id;
     public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	private String  c_notice;
     public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_no) {
		this.c_id = c_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public String getC_notice() {
		return c_notice;
	}
	public void setC_notice(String c_notice) {
		this.c_notice = c_notice;
	}
	
}
