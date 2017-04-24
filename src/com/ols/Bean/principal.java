package com.ols.Bean;
//数据库负责人表映射
public class principal {
     private int p_id ;
     private String p_user;
     private String p_pwd;
     private String p_name;
     private String p_dept;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_no) {
		this.p_id = p_no;
	}
	public String getP_user() {
		return p_user;
	}
	public void setP_user(String p_user) {
		this.p_user = p_user;
	}
	public String getP_pwd() {
		return p_pwd;
	}
	public void setP_pwd(String p_pwd) {
		this.p_pwd = p_pwd;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_dept() {
		return p_dept;
	}
	public void setP_dept(String p_dept) {
		this.p_dept = p_dept;
	}
}
