package com.employee.model;

import java.sql.Timestamp;
import java.util.*;

public class TEST_EmployeeJDBCDAO {
    public static void main(String[] args){
    	System.out.println("hello World!");
    	
    	EmployeeJDBCDAO dao = new EmployeeJDBCDAO();
    	
    	//some test inputs
    	Calendar calendar = Calendar.getInstance();
    	java.util.Date now = calendar.getTime();
    	java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
    	byte[] testByteArray = "abc".getBytes();
    	    	
    	//✈Test insert(EmployeeVO EmployeeVO);
		EmployeeVO empVO1 = new EmployeeVO();
		
    	empVO1.setEmp_id("aaa@forhouse.com");
    	empVO1.setEmp_psw("654321");
    	empVO1.setEmp_name("喵喵喵");
    	empVO1.setEmp_lstlog(currentTimestamp);
    	empVO1.setEmp_badlog(currentTimestamp);
    	empVO1.setEmp_badlogtry(6);
    	empVO1.setEmp_photo(testByteArray);
    	empVO1.setEmp_state("Active");
    	empVO1.setEmp_newdate(currentTimestamp);
    	int updateCount_insert = dao.insert(empVO1);
    	System.out.println(updateCount_insert);
  	
    	System.out.println("======i am a cute <tr>======");
   	
    	//✈Test update(EmployeeVO EmployeeVO)
    	EmployeeVO empVO2 = new EmployeeVO();
    	empVO2.setEmp_no("EM00000004");
    	empVO2.setEmp_id("mmm@forhouse.com");
    	empVO2.setEmp_psw("123456");
    	empVO2.setEmp_name("喵喵喵");
    	empVO2.setEmp_lstlog(currentTimestamp);
    	empVO2.setEmp_badlog(currentTimestamp);
    	empVO2.setEmp_badlogtry(6);
    	empVO2.setEmp_photo(testByteArray);
    	empVO2.setEmp_state("Active");
    	empVO2.setEmp_newdate(currentTimestamp);
    	int updateCount_update= dao.update(empVO2);
    	System.out.println(updateCount_update);
    	
    	System.out.println("======i am a cute <tr>======");
    	
    	//✈Test delete(String emp_no)
    	int updateCount_delete=dao.delete("EM00000004");
    	System.out.println(updateCount_delete);

    	
		System.out.println("======i am a cute <tr>======");
    	
   	
    	//✈Test findByPK(String emp_no)
    	EmployeeVO empVO3 = dao.findByPK("EM00000003");
    	System.out.print(empVO3.getEmp_no()+", "); 
		System.out.print(empVO3.getEmp_id()+", ");
		System.out.print(empVO3.getEmp_psw()+", ");
		System.out.print(empVO3.getEmp_name()+", ");
		System.out.print(empVO3.getEmp_lstlog()+", ");
		System.out.print(empVO3.getEmp_badlog()+", ");
		System.out.print(empVO3.getEmp_badlogtry()+", ");
		System.out.print(empVO3.getEmp_photo()+", ");
		System.out.print(empVO3.getEmp_state()+", ");
		System.out.println(empVO3.getEmp_newdate()+", ");
    	
		
		System.out.println("======i am a cute <tr>======");
    	
    	
		//✈Test getAll()  	
		List<EmployeeVO> list = dao.getAll();
    	for(EmployeeVO emp:list){
    		System.out.print(emp.getEmp_no()+", "); 
    		System.out.print(emp.getEmp_id()+", ");
    		System.out.print(emp.getEmp_psw()+", ");
    		System.out.print(emp.getEmp_name()+", ");
    		System.out.print(emp.getEmp_lstlog()+", ");
    		System.out.print(emp.getEmp_badlog()+", ");
    		System.out.print(emp.getEmp_badlogtry()+", ");
    		System.out.print(emp.getEmp_photo()+", ");
    		System.out.print(emp.getEmp_state()+", ");
    		System.out.println(emp.getEmp_newdate()+", ");
    	}
    	
    }
}
