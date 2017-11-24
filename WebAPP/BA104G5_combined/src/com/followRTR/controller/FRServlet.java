package com.followRTR.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.followRTR.model.*;


@WebServlet("/FRServlet")
public class FRServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		String local = req.getParameter("localtion");
		if("findByMemNo".equals(action)){
			String mem_no = req.getParameter("mem_no");
			FRService frSvc = new FRService();
			List<FRVO> list = frSvc.findByNumber(mem_no);
									
		}				
	}
}
