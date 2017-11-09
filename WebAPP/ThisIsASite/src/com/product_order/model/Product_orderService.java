package com.product_order.model;

import java.util.List;

public class Product_orderService {

	private Product_orderDAO_interface dao;
	 
	public Product_orderService(){
		dao = new Product_orderDAO();
	}
	
	/**
	 * add a Product_order row
	 */
	public Product_orderVO addPdo(String mem_no,String slr_no,String cp_no){
		Product_orderVO pdoVO = new Product_orderVO();
		pdoVO.setMem_no(mem_no);
		pdoVO.setSlr_no(slr_no);
		pdoVO.setCp_no(cp_no);
		dao.insert(pdoVO);		
		return pdoVO;
	}
	
	/**
	 * using PK update pdo_stat
	 * @return Product_orderVO
	 */
	public Product_orderVO changePdoState(String pdo_stat, String pdo_no){
		
		Product_orderVO pdoVO=new Product_orderVO();
		
		pdoVO.setPdo_stat(pdo_stat);
		pdoVO.setPdo_no(pdo_no);
		
		dao.update(pdoVO);
		
		return pdoVO;
	}
	
	/**
	 * delete a row
	 * SHOULD NEVER DELETE A LOW
	 * please use changePdoState() instead.
	 */
	public void deletePdo(String pdo_no){
		dao.delete(pdo_no);
	}
	
	/**
	 * get a row
	 */
	public Product_orderVO getOnePdo(String pdo_no){
		return  dao.findByPK(pdo_no);		
	}
	
	/**
	 * get all
	 */
	public List<Product_orderVO> getAll(){
		return dao.getAll();
	}
}
