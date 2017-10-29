package com.employee.model;

import java.util.List;

public class EmployeeService {

	private EmployeeDAO_interface dao;
	
	public EmployeeService(){
		dao = new EmployeeDAO();
	}
	
}
