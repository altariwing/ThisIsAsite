package com.tool.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prdimg.model.*;

public class ShowImage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

		res.setContentType("image/*");
		ServletOutputStream out = res.getOutputStream();
		String getImg = req.getParameter("getImg");
		
		if("prdimg".equals(getImg)){

			String prd_no = req.getParameter("prd_no");
			PrdImgService prdImgSvc = new PrdImgService();
			try {
				PrdImgVO prdImgVO = prdImgSvc.findFirstByPrdNo(prd_no);
				InputStream in = new ByteArrayInputStream(prdImgVO.getPrd_img());
				byte[] buffer = new byte[in.available()];
				int len = 0;
				try {
					while ((len = in.read(buffer)) != -1)
						out.write(buffer, 0, len);
					out.close();
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				FileInputStream in = new FileInputStream(getServletContext().getRealPath("/shopping/images/nopic.jpg"));
				byte[] pic = new byte[in.available()];
				in.read(pic);
				out.write(pic);
				in.close();
			}
		
			
			
		}
		
	}
}