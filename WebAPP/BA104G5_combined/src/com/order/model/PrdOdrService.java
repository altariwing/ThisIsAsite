package com.order.model;

import java.util.List;

public class PrdOdrService {
	private PrdOdrDAO_interface dao;
	public PrdOdrService() {
		dao = new PrdOdrDAO();
	}
	
	public String addOrder(PrdOdrVO prdOdrVO) {
		return dao.insert(prdOdrVO);
	}
	
	public void update(PrdOdrVO prdOdrVO) {
		dao.update(prdOdrVO);
	}
	
	public void setPdoStat(String pdo_stat,String pdo_no) {
		dao.setPdoStat(pdo_stat, pdo_no);
	}
	
	public void setSlrRate(Integer slr_rate,String pdo_no) {
		dao.setSlrRate(slr_rate, pdo_no);
	}
	
	public void setMem(Integer mem_rate, String mem_review) {
		dao.setMem(mem_rate, mem_review);
	}
	
	public void setPayment(String pdo_params,String pdo_no) {
		dao.setPayment(pdo_params, pdo_no);
	}
	
	public List<PrdOdrVO> memGetByNew(String mem_no) {
		return dao.memGetByNew(mem_no);
	}
	
	public List<PrdOdrVO> memGetByDeliver(String mem_no) {
		return dao.memGetByDeliver(mem_no);
	}
	
	public List<PrdOdrVO> memGetByCancel(String mem_no) {
		return dao.memGetByCancel(mem_no);
	}
	
	public List<PrdOdrVO> slrGetByNew(String slr_no) {
		return dao.slrGetByNew(slr_no);
	}
	
	public List<PrdOdrVO> slrGetByDeliver(String slr_no) {
		return dao.slrGetByDeliver(slr_no);
	}
	
	public List<PrdOdrVO> slrGetByCancel(String slr_no) {
		return dao.slrGetByCancel(slr_no);
	}
	
	public PrdOdrVO findByPdoNo(String pdo_no) {
		return dao.findByPdoNo(pdo_no);
	}
}
