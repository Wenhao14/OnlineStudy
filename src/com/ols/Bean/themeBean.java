package com.ols.Bean;

import java.util.Date;

//论坛主题表映射
public class themeBean extends userBean{
   private String t_id;
   private Date t_time;
   private String t_theme;
public String getT_id() {
	return t_id;
}
public void setT_id(String t_id) {
	this.t_id = t_id;
}
public Date getT_time() {
	return t_time;
}
public void setT_time(Date t_time) {
	this.t_time = t_time;
}
public String getT_theme() {
	return t_theme;
}
public void setT_theme(String t_theme) {
	this.t_theme = t_theme;
}
   
}
