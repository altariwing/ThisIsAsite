package com.employee.model;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmployeeJNDIDAO implements EmployeeDAO_interface{

	private static DataSource ds = null;
	static {
		try{
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	
	private static final String INSERT = 
			"INSERT INTO EMPLOYEE(EMP_NO, EMP_ID, EMP_PSW, EMP_NAME, EMP_LSTLOG,EMP_BADLOG,EMP_BADLOGTRY,EMP_PHOTO, EMP_STATE,EMP_NEWDATE) "
			+ "VALUES('EM'||(LPAD(to_char(EMP_SEQ.NEXTVAL),8,'0')), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			private static final String UPDATE = 
			"UPDATE EMPLOYEE set EMP_ID=?, EMP_PSW=?, EMP_NAME=?, EMP_LSTLOG=?, EMP_BADLOG=?, EMP_BADLOGTRY=? ,Emp_photo=?, EMP_STATE=?, EMP_NEWDATE=? "
			+ "where emp_no = ?";
			private static final String DELETE = "DELETE FROM EMPLOYEE where EMP_NO = ?";
			private static final String FIND_BY_PK = "SELECT * FROM EMPLOYEE WHERE EMP_NO = ?";
			private static final String GET_ALL = "SELECT * FROM EMPLOYEE";

	
	@Override
	public int insert(EmployeeVO EmployeeVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(EmployeeVO EmployeeVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String emp_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmployeeVO findByPK(String emp_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
