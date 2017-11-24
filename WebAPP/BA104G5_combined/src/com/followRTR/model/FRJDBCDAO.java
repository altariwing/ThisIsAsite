package com.followRTR.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FRJDBCDAO implements FR_interface {

	String name = "BA104G5";
	String password = "ba104g5";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String driver = "oracle.jdbc.driver.OracleDriver";

	static final String INSERT = "insert into follow_rtr (rtr_no,mem_no,state,follow_date) values(?,?,?,current_timestamp)";
	static final String UPDATE = "update follow_rtr set rtr_no=?,mem_no=?,state=? where rtr_no=? and mem_no=? ";
	static final String DELETE = "delete from follow_rtr where rtr_no=? and mem_no=?";
	static final String GET_ONE = "select * from follow_rtr where ";
	static final String GET_ALL = "select * from follow_rtr";

	@Override
	public void insert(FRVO frVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(url, name, password);
			pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1, frVO.getRtr_no());
			pstmt.setString(2, frVO.getMem_no());
			pstmt.setString(3, frVO.getState());
			pstmt.executeUpdate();
			System.out.println("成功上傳");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void update(FRVO frVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(url, name, password);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, frVO.getRtr_no());
			pstmt.setString(2, frVO.getMem_no());
			pstmt.setString(3, frVO.getState());
			pstmt.setString(4, frVO.getRtr_no());
			pstmt.setString(5, frVO.getMem_no());
			pstmt.executeUpdate();
			System.out.println("成功修改");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void delete(String rtr_no, String mem_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(url, name, password);
			pstmt = con.prepareStatement(DELETE);
			pstmt.setString(1, rtr_no);
			pstmt.setString(2, mem_no);
			pstmt.executeUpdate();
			System.out.println("成功刪除");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public List<FRVO> findByNumber(String someone_no) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String user = null;
		String GetOneByNumber = null;
		List<FRVO> list = new ArrayList<>();

		try {
			con = DriverManager.getConnection(url, name, password);
			user = someone_no.substring(0, 3);
			System.out.println(user);
			if (user.equals("rtr")) {
				GetOneByNumber = GET_ONE + "rtr_no = '" + someone_no + "'";
			}
			if (user.equals("mem")) {
				GetOneByNumber = GET_ONE + "mem_no = '" + someone_no + "'";
			} else {
				System.out.println("輸入格式錯誤");
			}
			System.out.println(GetOneByNumber);
			pstmt = con.prepareStatement(GetOneByNumber);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FRVO frVO = new FRVO();
				frVO.setMem_no(rs.getString("mem_no"));
				frVO.setRtr_no(rs.getString("rtr_no"));
				frVO.setState(rs.getString("state"));
				frVO.setFollow_date(rs.getTimestamp("follow_date"));
				list.add(frVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return list;

	}

	@Override
	public List<FRVO> getAll() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FRVO> list = new ArrayList<>();

		try {
			con = DriverManager.getConnection(url, name, password);

			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FRVO frVO = new FRVO();
				frVO.setMem_no(rs.getString("mem_no"));
				frVO.setRtr_no(rs.getString("rtr_no"));
				frVO.setState(rs.getString("state"));
				frVO.setFollow_date(rs.getTimestamp("follow_date"));
				list.add(frVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// 新增OK
		FRJDBCDAO dao = new FRJDBCDAO();
		FRVO frVO = new FRVO();

		// frVO.setRtr_no("rtr00001");
		// frVO.setMem_no("mem00001");
		// frVO.setState("following");
		// dao.insert(frVO);
		//
		// frVO.setRtr_no("rtr00001");
		// frVO.setMem_no("mem00002");
		// frVO.setState("following");
		// dao.insert(frVO);
		//
		// frVO.setRtr_no("rtr00002");
		// frVO.setMem_no("mem00001");
		// frVO.setState("following");
		// dao.insert(frVO);
		//
		// frVO.setRtr_no("rtr00002");
		// frVO.setMem_no("mem00002");
		// frVO.setState("off");
		// dao.insert(frVO);
		//
		// frVO.setRtr_no("rtr00003");
		// frVO.setMem_no("mem00003");
		// frVO.setState("following");
		// dao.insert(frVO);

		// 修改OK
		// frVO.setRtr_no("rtr00001");
		// frVO.setMem_no("mem00001");
		// frVO.setState("off");
		// dao.update(frVO);
		//
		// frVO.setRtr_no("rtr00002");
		// frVO.setMem_no("mem00002");
		// frVO.setState("following");
		// dao.update(frVO);

		// 刪除成功
		// String rtr_no = "rtr00001";
		// String mem_no = "mem00001";
		// dao.delete(rtr_no, mem_no);

		// 單方查詢OK
		// String someone_no = "mem00001";
		// String someone_no = "rtr00001";
		// List<FRVO> list = dao.findByNumber(someone_no);
		//
		// for (FRVO frVOa : list) {
		// System.out.println(frVOa.getMem_no());
		// System.out.println(frVOa.getRtr_no());
		// System.out.println(frVOa.getFollow_date());
		// }

		// 所有查詢OK
		// List<FRVO> list = dao.getALL();
		// for (FRVO frVOa : list) {
		// System.out.println(frVOa.getMem_no());
		// System.out.println(frVOa.getRtr_no());
		// System.out.println(frVOa.getFollow_date());
		// }

	}
}
