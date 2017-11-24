package com.hsecoll.model;

import java.io.Serializable;

public class HseCollVO implements Serializable{
	
	private String mem_no;
	private String house_no;
	
	public HseCollVO(){
		super();
	}
	

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public String getMem_no() {
		return mem_no;
	}

	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
}
