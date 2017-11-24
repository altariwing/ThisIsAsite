package com.hsecoll.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.hsecoll.model.*;

public class HseCollServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

        if ("insert".equals(action)) { // 來自addHseColl.jsp的請求  
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String mem_no = req.getParameter("mem_no");
				String mem_noReg = "^[M][B][0-9]{8}$";
				if (mem_no == null || mem_no.trim().length() == 0) {
					errorMsgs.put("mem_no","會員編號: 請勿空白");
				} else if(!mem_no.trim().matches(mem_noReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.put("mem_no","員工編號: 只能是MB 開頭加數字 , 且長度必需為10位");
	            }
				
				String house_no = req.getParameter("house_no");
				String house_noReg = "^[H][N][0-9]{8}$";
				if (house_no == null || house_no.trim().length() == 0) {
					errorMsgs.put("house_no","房屋編號: 請勿空白");
				} else if(!house_no.trim().matches(house_noReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.put("house_no","房屋編號: 只能是HN 開頭加數字 , 且長度必需為10位");
	            }
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/hseColl/addHseColl.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				HseCollService hseCollSvc = new HseCollService();
				hseCollSvc.addHseColl(mem_no , house_no);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/hseColl/listAllHseColl.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllHseColl.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.put("Exception",e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/hseColl/addHseColl.jsp");
				failureView.forward(req, res);
			}
		}
	}
}