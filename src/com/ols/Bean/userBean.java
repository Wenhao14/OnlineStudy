package com.ols.Bean;
//数据库用户表映射
public class userBean {
   private int s_id;
   private String s_user;
   private String s_name;
   private String s_pwd;
   private String s_section;
   private int c_id;
   private String s_phone ;
   private String s_sex;
   private String s_mile;
	public String getS_mile() {
	return s_mile;
}
public void setS_mile(String s_mile) {
	this.s_mile = s_mile;
}
	public String getS_user() {
		return s_user;
	}
	public void setS_user(String s_user) {
		this.s_user = s_user;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_pwd() {
		return s_pwd;
	}
	public void setS_pwd(String s_pwd) {
		this.s_pwd = s_pwd;
	}
	public String getS_section() {
		return s_section;
	}
	public void setS_section(String s_section) {
		this.s_section = s_section;
	}
	public int getC_id() {
		return c_id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}
}
