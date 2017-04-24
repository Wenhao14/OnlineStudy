package com.ols.Bean;

import java.util.Date;

//数据库已学表映射
public class hasdataBean extends dataBean {
    private int h_id;
    private int s_id;
    private Date h_time;
    private String if_know;
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int h_no) {
		this.h_id = h_no;
	}
	
	public Date getH_time() {
		return h_time;
	}
	public void setH_time(Date h_time) {
		this.h_time = h_time;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_no) {
		this.s_id = s_no;
	}
	public String getIf_know() {
		return if_know;
	}
	public void setIf_know(String if_know) {
		this.if_know = if_know;
	}
}
