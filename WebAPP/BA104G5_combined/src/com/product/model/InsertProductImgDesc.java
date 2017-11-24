package com.product.model;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertProductImgDesc {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "BA104G5";
	private static final String PASSWORD = "ba104g5";
	private static final String IMG = "INSERT INTO PRDIMG(IMG_NO, PRD_NO, PRD_IMG)" + "VALUES(PRDIMG_SEQ.NEXTVAL, ?, ?)";
	private static final String DESC = "UPDATE PRODUCT SET PRD_DESC=? WHERE PRD_NO=?";

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;

		// 將 ForHouseCowork 的  product 資料夾放到 D: 下即可執行本程式
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(IMG);
			
			// 圖片部分
			int total = 0;
			for(int prd_no=1 ; prd_no<37 ; prd_no++){
				int pcs = 0 ;
				for(int i=1 ; i<8 ; i++) {
					if (new File("D:/product/img/" + prd_no + i + ".jpg").exists()) {
						byte[] pic = getPictureByteArray("D:/product/img/" + prd_no + i + ".jpg");
						if(prd_no<10){
							pstmt.setString(1, "PD0000000" + prd_no);
						} else {
							pstmt.setString(1, "PD000000" + prd_no);
						}
						pstmt.setBytes(2, pic);
						pstmt.executeUpdate();
						pcs++;
					}
				}
				total = total + pcs;
				System.out.println("prd_no:" + prd_no +" 新增 "+ pcs + " 張成功!");
			}
			System.out.println("共新增 " + total + " 張圖片!");
			
			// 清空裡面參數，重覆使用已取得的PreparedStatement物件
			pstmt.clearParameters();
						
			// 商品詳情部分
			pstmt2 = con.prepareStatement(DESC);
			int i = 1;
			for(i=1 ; i<34 ; i++){
					if (new File("D:/product/info/" + i + ".txt").exists()) {
						String str = getLongString("D:/product/info/" + i + ".txt");
						pstmt2.setString(1, str);
						if(i<10){
							pstmt2.setString(2, "PD0000000" + i);
						} else {
							pstmt2.setString(2, "PD000000" + i);
						}
						pstmt2.executeUpdate();
					}
			}
			System.out.println("共新增 " + i + " 筆資料!");
			
			
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		} catch (SQLException se) {
			System.out.println(se);
		} catch (IOException ie) {
			System.out.println(ie);
		} finally {
			if (pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}
		
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int i;
		while ((i = fis.read(buffer)) != -1) {
			baos.write(buffer, 0, i);
		}
		baos.close();
		fis.close();
		return baos.toByteArray();
	}
	
	public static String getLongString(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		StringBuilder sb = new StringBuilder(); // StringBuffer is thread-safe!
		String str;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		br.close();
		return sb.toString();
	}

}
