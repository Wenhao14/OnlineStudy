package com.ols.Bean;
//数据库正在学习表映射
import java.util.Date;

public class nowdataBean extends dataBean{
    private int  n_id;
    private int s_id;
    private String n_s;
    private String n_time;
    private Date last_time;
    
	public String getN_s() {
		return n_s;
	}
	public void setN_s(String n_s) {
		this.n_s = n_s;
	}
	public int getN_id() {
		return n_id;
	}
	public void setN_id(int n_no) {
		this.n_id = n_no;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getN_time() {
		return n_time;
	}
	public void setN_time(String n_time) {
		this.n_time = n_time;
	}
	public Date getLast_time() {
		return last_time;
	}
	public void setLast_time(Date last_time) {
		this.last_time = last_time;
	}
    
}
