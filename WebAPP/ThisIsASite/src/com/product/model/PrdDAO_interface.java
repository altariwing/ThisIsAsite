package com.product.model;

import java.util.List;

public interface PrdDAO_interface {
	public String insert(PrdVO prdVO);
	public void update(PrdVO prdVO);
	public void changeState(String prd_state, String prd_no);
	public List<PrdVO> getStateOn();
	public List<PrdVO> findBySlrOff(String slr_no);
	public List<PrdVO> findBySlrOn(String slr_no);
	public List<PrdVO> findBySlrCate(String cate_no, String slr_no);
	public PrdVO getOnByPrdNo(String prd_no);
}
