package com.product_order.model;

import java.util.List;

public class Product_orderJDBCDAO implements Product_orderDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "BA104";
	String passwd = "123456";
	private static final String INSERT =
			"INSERT INTO PRODUCT_ORDER(PDO_NO, MEM_NO, SLR_NO)"
			+"VALUES('OD'||TO_CHAR(SYSDATE,'RRMMDD')||'-'||(LPAD(TO_CHAR(PDO_NO_SEQ.NEXTVAL),6,'0')), ?, ?)";
	
	
	@Override
	public void insert(Product_orderVO Product_orderVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product_orderVO Product_orderVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String pdo_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product_orderVO findByPK(String pdo_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product_orderVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
