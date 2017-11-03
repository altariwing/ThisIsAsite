package com.employee.model;

import java.util.List;

/**
 * EmployeeDAO_interface
 * insert
 * update
 * delete
 * findByPK
 * getAll
 */
public interface EmployeeDAO_interface {
	/**
	 * insert a row 
	 * */
	public void insert(EmployeeVO EmployeeVO);
	/**
	 * update that emp_no's row 
	 * */
	public void update(EmployeeVO EmployeeVO);
	/**
	 * delete that emp_no's row 
	 * */
	public void delete(String emp_no);
	/**
	 * select PK from table
	 * */
	EmployeeVO findByPK(String emp_no);
	/**
	 * select all from table
	 * */
	List<EmployeeVO> getAll();
}