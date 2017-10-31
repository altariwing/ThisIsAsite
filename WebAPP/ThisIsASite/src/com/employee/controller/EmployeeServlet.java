package com.employee.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.employee.model.*;

public class EmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************
				 * 1.接收請求參數 - 輸入格式的錯誤處理
				 *************************/
				String emp_name = req.getParameter("emp_name");
				String emp_name_Reg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (emp_name == null || emp_name.trim().length() == 0) {
					errorMsgs.put("emp_name", "員工姓名: 請勿空白");
				} else if (!emp_name.trim().matches(emp_name_Reg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.put("ename", "員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				String emp_id = req.getParameter("emp_id").trim();
				String emp_id_Reg = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
				if (emp_id == null || emp_id.trim().length() == 0) {
					errorMsgs.put("emp_id", "職位請勿空白");
				} else if (!emp_id.trim().matches(emp_id_Reg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.put("emp_id", "員工信箱: 必須為電子郵件");
				}

				/*************************** 2.開始新增資料 ***************************************/

				/* emp_psw 由以下程式碼產生 */
				final String PSWDIC = "23456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";//包含字元
				final int PSWLENGTH = 10;//長度
				Random random = new Random();
				StringBuilder sb = new StringBuilder(PSWLENGTH);
				for (int i = 0; i < PSWLENGTH; i++)
					sb.append(PSWDIC.charAt(random.nextInt(PSWDIC.length())));
				String emp_psw = sb.toString();

				EmployeeService empSvc = new EmployeeService();
				empSvc.addEmp(emp_id, emp_psw, emp_name);

				/***************************
				 * 3.新增完成,準備轉交(Send the Success view)
				 ***********/
				String url = "/employee/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.put("Exception", e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/employee/addEmp.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
