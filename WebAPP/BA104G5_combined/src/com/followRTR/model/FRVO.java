package com.followRTR.model;

import java.sql.Timestamp;

public class FRVO {
	private String rtr_no;
	private String mem_no;
	private String state;
	private Timestamp follow_date;
	
	
	public String getRtr_no() {
		return rtr_no;
	}
	public void setRtr_no(String rtr_no) {
		this.rtr_no = rtr_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Timestamp getFollow_date() {
		return follow_date;
	}
	public void setFollow_date(Timestamp follow_date) {
		this.follow_date = follow_date;
	}
	
	
	

}
