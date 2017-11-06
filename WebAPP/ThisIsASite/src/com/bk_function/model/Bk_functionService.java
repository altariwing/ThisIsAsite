package com.bk_function.model;

import java.util.List;

import com.employee.model.EmployeeDAO_interface;
import com.employee.model.EmployeeVO;

public class Bk_functionService {

	private Bk_functionDAO_interface dao;
	
	public Bk_functionService(){
		dao = new Bk_functionDAO();
	}
	
	public Bk_functionVO addBkf(String name,String dsb,String state){
		Bk_functionVO bkfVO = new Bk_functionVO();
		bkfVO.setBkf_name(name);
		bkfVO.setBkf_dsb(dsb);
		bkfVO.setBkf_state(state);
		
		dao.insert(bkfVO);
		
		return bkfVO;
	}
	
	//預留給 Struts 2 用的
	public void addBkf(Bk_functionVO bkfVO) {
		dao.insert(bkfVO);
	}	
	
	
}
