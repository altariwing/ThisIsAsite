package 資料庫表格建立;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.employee.model.EmployeeDAO_interface;
import com.employee.model.EmployeeJDBCDAO;
import com.employee.model.EmployeeVO;

public class EmployeeJDBCDAOs {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "BA104";
	String passwd = "123456";
	private static final String INSERT = 
			"INSERT INTO EMPLOYEE(EMP_NO, EMP_ID, EMP_PSW, EMP_NAME, EMP_LSTLOG,EMP_BADLOG,EMP_BADLOGTRY,EMP_PHOTO) "
			+ "VALUES('EM'||(LPAD(to_char(EMP_SEQ.NEXTVAL),8,'0')), ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = 
	"UPDATE EMPLOYEE set EMP_ID=?, EMP_PSW=?, EMP_NAME=?,Emp_photo=?, EMP_STATE=?"
	+ "where emp_no = ?";
	private static final String DELETE = "DELETE FROM EMPLOYEE where EMP_NO = ?";
	private static final String FIND_BY_PK = "SELECT * FROM EMPLOYEE WHERE EMP_NO = ?";
	private static final String GET_ALL = "SELECT * FROM EMPLOYEE";

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
			pstmt.setTimestamp(4, EmployeeVO.getEmp_lstlog());
			pstmt.setTimestamp(5, EmployeeVO.getEmp_badlog());
			pstmt.setInt(6, EmployeeVO.getEmp_badlogtry());
			pstmt.setBytes(7, EmployeeVO.getEmp_photo());
			
						
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

	

	

	public List<EmployeeVO> getAll() {
		// TODO Auto-generated method stub

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

	
	
	
}//end EmployeeJDBCDAOs
