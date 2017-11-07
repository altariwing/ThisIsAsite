package com.employee.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJDBCDAO implements EmployeeDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "BA104";
	String passwd = "123456";
	private static final String INSERT = 
	"INSERT INTO EMPLOYEE(EMP_NO, EMP_ID, EMP_PSW, EMP_NAME) "
	+ "VALUES('EM'||(LPAD(to_char(EMP_SEQ.NEXTVAL),8,'0')), ?, ?, ?)";
	private static final String UPDATE = 
	"UPDATE EMPLOYEE set EMP_ID=?, EMP_PSW=?, EMP_NAME=?,Emp_photo=?, EMP_STATE=?"
	+ "where emp_no = ?";
	private static final String DELETE = "DELETE FROM EMPLOYEE where EMP_NO = ?";
	private static final String FIND_BY_PK = "SELECT * FROM EMPLOYEE WHERE EMP_NO = ?";
	private static final String FIND_BY_ID = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
	private static final String GET_ALL = "SELECT * FROM EMPLOYEE";

	@Override
	public void insert(EmployeeVO EmployeeVO) {
		int updateCount = 0;
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try{
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT);
			
			pstmt.setString(1, EmployeeVO.getEmp_id());
			pstmt.setString(2, EmployeeVO.getEmp_psw());
			pstmt.setString(3, EmployeeVO.getEmp_name());
						
			updateCount=pstmt.executeUpdate();
			System.out.println(updateCount);
			// Handle any driver errors
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		} // end finally		
		
		
		
	}

	@Override
	public void update(EmployeeVO EmployeeVO) {
		int updateCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, EmployeeVO.getEmp_id());
			pstmt.setString(2, EmployeeVO.getEmp_psw());
			pstmt.setString(3, EmployeeVO.getEmp_name());
			pstmt.setBytes(4, EmployeeVO.getEmp_photo());
			pstmt.setString(5, EmployeeVO.getEmp_state());
			pstmt.setString(6, EmployeeVO.getEmp_no());

			updateCount=pstmt.executeUpdate();
			System.out.println(updateCount);
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
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
	public void delete(String emp_no) {
		int updateCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, emp_no);

			updateCount = pstmt.executeUpdate();
			System.out.println(updateCount);

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
	public EmployeeVO findByPK(String emp_no) {
		EmployeeVO employeeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PK);

			pstmt.setString(1, emp_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				employeeVO = new EmployeeVO();
				employeeVO.setEmp_no(rs.getString("emp_no"));
				employeeVO.setEmp_id(rs.getString("emp_id"));
				employeeVO.setEmp_psw(rs.getString("emp_psw"));
				employeeVO.setEmp_name(rs.getString("emp_name"));
				employeeVO.setEmp_lstlog(rs.getTimestamp("emp_lstlog"));
				employeeVO.setEmp_badlog(rs.getTimestamp("emp_badlog"));
				employeeVO.setEmp_badlogtry(rs.getInt("emp_badlogtry"));
				employeeVO.setEmp_photo(rs.getBytes("emp_photo"));
				employeeVO.setEmp_state(rs.getString("emp_state"));
				employeeVO.setEmp_newdate(rs.getTimestamp("emp_newdate"));
			}

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

		return employeeVO;
	}

	@Override
	public EmployeeVO findByID(String emp_id) {
		EmployeeVO employeeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_ID);

			pstmt.setString(1, emp_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				employeeVO = new EmployeeVO();
				employeeVO.setEmp_no(rs.getString("emp_no"));
				employeeVO.setEmp_id(rs.getString("emp_id"));
				employeeVO.setEmp_psw(rs.getString("emp_psw"));
				employeeVO.setEmp_name(rs.getString("emp_name"));
				employeeVO.setEmp_lstlog(rs.getTimestamp("emp_lstlog"));
				employeeVO.setEmp_badlog(rs.getTimestamp("emp_badlog"));
				employeeVO.setEmp_badlogtry(rs.getInt("emp_badlogtry"));
				employeeVO.setEmp_photo(rs.getBytes("emp_photo"));
				employeeVO.setEmp_state(rs.getString("emp_state"));
				employeeVO.setEmp_newdate(rs.getTimestamp("emp_newdate"));
			}

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

		return employeeVO;
	
	}
	
	
	@Override
	public List<EmployeeVO> getAll() {
		

		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		EmployeeVO employeeVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// EmployeeVO �]�٬� Domain objects
				employeeVO = new EmployeeVO();
				employeeVO.setEmp_no(rs.getString("emp_no"));
				employeeVO.setEmp_id(rs.getString("emp_id"));
				employeeVO.setEmp_psw(rs.getString("emp_psw"));
				employeeVO.setEmp_name(rs.getString("emp_name"));
				employeeVO.setEmp_lstlog(rs.getTimestamp("emp_lstlog"));
				employeeVO.setEmp_badlog(rs.getTimestamp("emp_badlog"));
				employeeVO.setEmp_badlogtry(rs.getInt("emp_badlogtry"));
				employeeVO.setEmp_photo(rs.getBytes("emp_photo"));
				employeeVO.setEmp_state(rs.getString("emp_state"));
				employeeVO.setEmp_newdate(rs.getTimestamp("emp_newdate"));

				list.add(employeeVO); // Store the row in the list
			}

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
