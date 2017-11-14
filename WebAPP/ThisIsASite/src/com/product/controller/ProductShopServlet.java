package com.product.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.*;

public class ProductShopServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("insert".equals(action)) {}

		if ("getOne_Product".equals(action)) { // 來自listAllPrd.jsp 的請求

			

			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑:
																// 【/emp/listAllEmp.jsp】	

			try {
				/*************************** 1.接收請求參數 ****************************************/
				String prd_no = new String(req.getParameter("prd_no"));

				/*************************** 2.開始查詢資料 ****************************************/
				PrdService prdSvc = new PrdService();
				PrdVO prdVO = prdSvc.getOnByPrdNo(prd_no);

				/***************************
				 * 3.查詢完成,準備轉交(Send the Success view)
				 ************/
				req.setAttribute("PrdVO", prdVO); // 資料庫取出的empVO物件,存入req
				String url = "/shopping/PrdInfo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交PrdInfo.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 ************************************/
			} catch (Exception e) {
				System.out.print("走到商品頁面失敗,送回原頁面" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}

		}

		
		if ("update".equals(action)) {}

		if ("delete".equals(action)) {}

	}
}
