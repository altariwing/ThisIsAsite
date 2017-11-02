package com.bk_function.model;

import java.util.List;

/**
 * Bk_functionDAO_interface
 * insert
 * update
 * delete
 * findByPK
 * getAll
 */
public interface Bk_functionDAO_interface {
	
	/**
	 * insert a row 
	 * */
	public void insert(Bk_functionVO Bk_functionVO);
	
	/**
	 * update that emp_no's row 
	 * */
	public void update(Bk_functionVO Bk_functionVO);
	
	/**
	 * delete that emp_no's row 
	 * */
	public void delete(String bkf_no);
	
	/**
	 * select PK from table
	 * */
	Bk_functionVO findByPK(String bkf_no);
	
	/**
	 * select all from table
	 * */
	List<Bk_functionVO> getAll();
	
	
}
