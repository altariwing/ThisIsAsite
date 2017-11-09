package com.order_detail.model;

import java.util.List;

public class Order_detailJDBCDAO implements Order_detailDAO_interface{

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "BA104";
	String passwd = "123456";
	private static final String INSERT = "INSERT INTO ORDER_DETAIL(PDO_NO, PRD_NO, ODER_UNI_PRICE, ODER_QUANTITY)" 
	+"VALUES(?, ?, ? ,?)";
	private static final String UPDATE = "UPDATE ORDER_DETAIL set ODER_QUANTITY=? where PDO_NO = ? and PRD_NO = ?";
	private static final String DELETE = 
			"DELETE FROM ORDER_DETAIL where PDO_NO = ? and PRD_NO = ?";
	private static final String FIND_BY_PK = 
	"SELECT PDO_NO, PRD_NO, ODER_UNI_PRICE, ODER_QUANTITY FROM ORDER_DETAIL where PDO_NO = ? and PRD_NO = ?";
	private static final String GET_ALL = "SELECT * FROM ORDER_DETAIL";
	
	@Override
	public void insert(Order_detailVO Order_detailVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Order_detailVO Order_detailVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String pdo_no, String prd_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order_detailVO findByPK(String pdo_no, String prd_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order_detailVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
