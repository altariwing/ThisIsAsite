package com.hsecoll.model;

import java.util.List;


public interface HseCollDAO_interface {
	void insert(HseCollVO hseCollVO);

	void update(HseCollVO hseCollVO);

	void delete(String mem_no , String house_no);

	HseCollVO findByPrimaryKey(String mem_no , String house_no);
	
	List<HseCollVO> getAll_kuei(String mem_no);

	List<HseCollVO> getAll();
}
