package com.order.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.order.model.PrdOdrService;
import com.prdimg.model.PrdImgService;
import com.prdimg.model.PrdImgVO;
import com.product.model.PrdVO;

@WebServlet("/front/order/PrdOrd.do")
public class OrderHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); // 處理中文檔名
		res.setContentType("text/html; charset=UTF-8");
		String action = req.getParameter("action");

		// 來自 addprd.jsp 的請求
		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			String requestURL = req.getParameter("requestURL"); // 取得來源網頁路徑
			HttpSession session = req.getSession();

			PrdOdrService poSvc = new PrdOdrService();
			try {
				/***********************
				 * 1.接收請求參數 - 輸入格式的錯誤處理
				 *************************/
				
				List<PrdVO> cartlist = (List<PrdVO>) session.getAttribute("cartlist");
System.out.println(cartlist == null);
				for(PrdVO cart:cartlist){
					
					//購買人NO 在session裡面
					String mem_no = req.getParameter("mem_no");
					String cp_no = req.getParameter("cp_no");
					
					
					//商家NO
					//數量
					//價格
					//使用的折價卷
					String slr_no = req.getParameter("slr_no");
					String quantity = cart("quantity");
					String prd_price = req.getParameter("prd_price");
					
					
				}
				

				/***************************
				 * 訂單處理完成,準備轉交(Send the Success view)
				 ***********/
				String orderCreated = "訂單已建立!";
				req.setAttribute("orderCreated", orderCreated);
				RequestDispatcher successView = req.getRequestDispatcher(requestURL);
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front/seller/product/addprd.jsp");
				failureView.forward(req, res);
			}
		}

		// 來自  管理訂單 的請求
		if ("cancel".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			String requestURL = req.getParameter("requestURL"); // 取得來源網頁路徑
			HttpSession session = req.getSession();

			PrdOdrService poSvc = new PrdOdrService();
			try {
				/***********************
				 * 1.接收請求參數 - 輸入格式的錯誤處理
				 *************************/
				
				String pdo_no = req.getParameter("pdo_no");
				
				/*************************** 開始更新訂單狀態 ***************************************/
				PrdOdrService prdOdrSvc = new PrdOdrService();
				prdOdrSvc.setPdoStat("取消", pdo_no);

				/***************************
				 * 訂單處理完成,準備轉交(Send the Success view)
				 ***********/
				String orderCanceled = "訂單已取消!";
				req.setAttribute("orderCanceled", orderCanceled);
				RequestDispatcher successView = req.getRequestDispatcher(requestURL);
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front/seller/product/addprd.jsp");
				failureView.forward(req, res);
			}
		}

		// 來自 OdrList.jsp 的設定出貨按鈕
		if ("set_shipped".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			String requestURL = req.getParameter("requestURL"); // 取得來源網頁路徑

			try {
				/*********************** 1.接收請求參數 *************************/
				String pdo_no = req.getParameter("pdo_no");

				/*************************** 開始更新出貨狀態 ***************************************/
				PrdOdrService prdOdrSvc = new PrdOdrService();
				prdOdrSvc.setPdoStat("已出貨", pdo_no);

				/***************************
				 * 刪除完成,準備轉交(Send the Success view)
				 ***********/
				String setShipStat = "已設定為出貨!";
				req.setAttribute("setShipStat", setShipStat);
				RequestDispatcher successView = req.getRequestDispatcher(requestURL);
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("設定出貨失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}

	}
}
