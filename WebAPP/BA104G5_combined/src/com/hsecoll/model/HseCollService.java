package com.hsecoll.model;

import java.util.List;

public class HseCollService {

	private HseCollDAO_interface dao;
	
	public HseCollService(){
		dao = new HseCollJDBCDAO();
	}
	
	public HseCollVO addHseColl(String mem_no , String house_no){
		
		HseCollVO hseCollVO = new HseCollVO();
		
		hseCollVO.setMem_no(mem_no);
		hseCollVO.setHouse_no(house_no);
		
		dao.insert(hseCollVO);
		
		return hseCollVO;
	}
	
	public void addHseColl (HseCollVO hseCollVO){
		dao.insert(hseCollVO);
	}
	
	public HseCollVO updateHseCollVO(){
		return null;
	}
	
	public void updateHseCollVO(HseCollVO hseCollVO){
		dao.update(hseCollVO);
	}
	
	public void deletHseColl(String mem_no , String house_no){
		dao.delete(mem_no, house_no);
	}
	
	public HseCollVO getOneHseColl(String mem_no , String house_no){
		return dao.findByPrimaryKey(mem_no, house_no);
	}
	
	public List<HseCollVO> getAll(){
		return dao.getAll();
	}
	
	public List<HseCollVO> getAll_kuei(String mem_no){
		return dao.getAll_kuei(mem_no);
	}
}
