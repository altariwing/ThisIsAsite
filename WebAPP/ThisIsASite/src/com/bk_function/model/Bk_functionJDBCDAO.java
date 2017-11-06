package com.bk_function.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Bk_functionJDBCDAO implements Bk_functionDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "BA104";
	String passwd = "123456";
	private static final String INSERT = "INSERT INTO BK_FUNCTION(BKF_NO, BKF_NAME, BKF_DSB, BKF_STATE)" 
			+"VALUES(BKF_NO_SEQ.NEXTVAL, ?, ? ,?)";	
	private static final String UPDATE = "UPDATE BK_FUNCTION set BKF_NAME=?, BKF_DSB=?, BKF_STATE=? where BKF_NO = ?";
	
	
	
	@Override
	public void insert(Bk_functionVO Bk_functionVO) {
		int updateCount = 0;
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try{
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT);
			
			pstmt.setString(1, Bk_functionVO.getBkf_name());
			pstmt.setString(2, Bk_functionVO.getBkf_dsb());
			pstmt.setString(3, Bk_functionVO.getBkf_state());
			
			updateCount = pstmt.executeUpdate();
			System.out.println("成功新增"+updateCount+"筆資料");
			
			
		}catch(ClassNotFoundException e){
			throw new RuntimeException("Couldn't load database driver. "+e.getMessage());
			// Handle any SQL errors
		}catch (SQLException se){
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally				
	}

	@Override
	public void update(Bk_functionVO Bk_functionVO) {
		int updateCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try{
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, Bk_functionVO.getBkf_name());
			pstmt.setString(2, Bk_functionVO.getBkf_dsb());
			pstmt.setString(3, Bk_functionVO.getBkf_state());
			pstmt.setInt(4, Bk_functionVO.getBkf_no());
						
			updateCount = pstmt.executeUpdate();
			System.out.println("成功新增"+updateCount+"筆資料");
			
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void delete(String bkf_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bk_functionVO findByPK(String bkf_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bk_functionVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
