package com.order_detail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Order_detailJDBCDAO implements Order_detailDAO_interface {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "BA104";
	String passwd = "123456";
	private static final String INSERT = "INSERT INTO ORDER_DETAIL(PDO_NO, PRD_NO, ODER_UNI_PRICE, ODER_QUANTITY)"
			+ "VALUES(?, ?, ? ,?)";
	private static final String UPDATE = "UPDATE ORDER_DETAIL set ODER_QUANTITY=? where PDO_NO = ? and PRD_NO = ?";
	private static final String DELETE = "DELETE FROM ORDER_DETAIL where PDO_NO = ? and PRD_NO = ?";
	private static final String FIND_BY_PK = "SELECT PDO_NO, PRD_NO, ODER_UNI_PRICE, ODER_QUANTITY FROM ORDER_DETAIL where PDO_NO = ? and PRD_NO = ?";
	private static final String GET_ALL = "SELECT * FROM ORDER_DETAIL";

	@Override
	public void insert(Order_detailVO Order_detailVO) {
		int updateCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT);

			pstmt.setString(1, Order_detailVO.getPdo_no());
			pstmt.setString(2, Order_detailVO.getPrd_no());
			pstmt.setInt(3, Order_detailVO.getOder_uni_price());
			pstmt.setInt(4, Order_detailVO.getOder_quantity());
			updateCount = pstmt.executeUpdate();
			System.out.println("成功新增" + updateCount + "筆資料");

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

	}

	@Override
	public void update(Order_detailVO Order_detailVO) {
		int updateCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, Order_detailVO.getOder_quantity());
			pstmt.setString(2, Order_detailVO.getPdo_no());
			pstmt.setString(3, Order_detailVO.getPrd_no());

			updateCount = pstmt.executeUpdate();
			System.out.println("成功修改" + updateCount + "筆資料");

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		} // end finally
	}

	@Override
	public void delete(String pdo_no, String prd_no) {
		int updateCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, pdo_no);
			pstmt.setString(2, prd_no);

			updateCount = pstmt.executeUpdate();
			System.out.println("成功刪除" + updateCount + "筆資料");

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		} // end finally

	}

	@Override
	public Order_detailVO findByPK(String pdo_no, String prd_no) {
		Order_detailVO order_detailVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PK);

			pstmt.setString(1, pdo_no);
			pstmt.setString(2, prd_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				order_detailVO = new Order_detailVO();
				order_detailVO.setPdo_no(pdo_no);
				order_detailVO.setPrd_no(prd_no);
				order_detailVO.setOder_uni_price(rs.getInt("oder_uni_price"));
				order_detailVO.setOder_quantity(rs.getInt("oder_quantity"));

			}
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		} // end finally
		return order_detailVO;
	}

	@Override
	public List<Order_detailVO> getAll() {
		List<Order_detailVO> list = new ArrayList<Order_detailVO>();
		Order_detailVO order_detailVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order_detailVO = new Order_detailVO();
				order_detailVO.setPdo_no(rs.getString("pdo_no"));
				order_detailVO.setPrd_no(rs.getString("prd_no"));
				order_detailVO.setOder_uni_price(rs.getInt("oder_uni_price"));
				order_detailVO.setOder_quantity(rs.getInt("oder_quantity"));

				list.add(order_detailVO); // Store the row in the list
			}
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		} // end finally
		
		return list;
	}

}
