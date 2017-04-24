package com.ols.Bean;

import java.util.Date;

//论坛主题回复映射
public class restoreBean {
  private String t_id;
  private String s_user;
  private String s_name;
  private String r_key;
  private Date r_time;
  public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
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
public String getR_key() {
	return r_key;
}
public void setR_key(String r_key) {
	this.r_key = r_key;
}
public Date getR_time() {
	return r_time;
}
public void setR_time(Date r_time) {
	this.r_time = r_time;
}
  
}
