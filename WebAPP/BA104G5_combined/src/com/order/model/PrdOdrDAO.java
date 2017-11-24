package com.order.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PrdOdrDAO implements PrdOdrDAO_interface {
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/BA104G5");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT = 
			"INSERT INTO PRODUCT_ORDER (pdo_no,mem_no,slr_no,pdo_params,cp_no)"
			+ "VALUES ('OD'||TO_CHAR(SYSDATE,'RRMMDD')||'-'||(LPAD(TO_CHAR(PDO_NO_SEQ.NEXTVAL),6,'0')),?,?,?,?)" ;
	private static final String SETPDOSTAT = "UPDATE PRODUCT_ORDER SET pdo_stat=? WHERE pdo_no=?";
	private static final String SETSLRRATE = "UPDATE PRODUCT_ORDER SET slr_rate=? WHERE pdo_no=?";
	private static final String SETMEM = "UPDATE PRODUCT_ORDER SET mem_rate=?, mem_review=?";
	private static final String SETPAYMENT = "UPDATE PRODUCT_ORDER SET pdo_params=? WHERE pdo_no=?";
	private static final String MEM_GET_NEW = "SELECT * FROM PRODUCT_ORDER WHERE mem_no=? and pdo_stat='待出貨'";
	private static final String MEM_GET_DELIVER = "SELECT * FROM PRODUCT_ORDER WHERE mem_no=? and pdo_stat='已出貨'";
	private static final String MEM_GET_CANCEL = "SELECT * FROM PRODUCT_ORDER WHERE mem_no=? and pdo_stat='取消'";
	private static final String SLR_GET_NEW = "SELECT * FROM PRODUCT_ORDER WHERE slr_no=? and pdo_stat='待出貨'";
	private static final String SLR_GET_DELIVER = "SELECT * FROM PRODUCT_ORDER WHERE slr_no=? and pdo_stat='已出貨'";
	private static final String SLR_GET_CANCEL = "SELECT * FROM PRODUCT_ORDER WHERE slr_no=? and pdo_stat='取消'";
	private static final String FIND_BY_PDO_NO = "SELECT * FROM PRODUCT_ORDER WHERE pdo_no=?";

	@Override
	public String insert(PrdOdrVO prdOdrVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String keyPdoNo = null;
		
		try {
			con = ds.getConnection();
			String[] col = { "pdo_no" };
			pstmt = con.prepareStatement(INSERT,col); //insert時要順便拿自增PK
			
			pstmt.setString(1, prdOdrVO.getMem_no());
			pstmt.setString(2, prdOdrVO.getSlr_no());
			pstmt.setString(3, prdOdrVO.getPdo_params());
			pstmt.setString(4, prdOdrVO.getCp_no());
						
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys(); //從 結果取出PK
			rs.next();
			keyPdoNo = rs.getString(1);
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(insert出問題了) " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return keyPdoNo;
	}

	@Override
	public void update(PrdOdrVO prdOdrVO) {
		
	}
	
	@Override
	public void setPdoStat(String pdo_stat,String pdo_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SETPDOSTAT);
			
			pstmt.setString(1, pdo_stat);
			pstmt.setString(2, pdo_no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(setPdoStat出問題了) " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void setSlrRate(Integer slr_rate,String pdo_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SETSLRRATE);
			
			pstmt.setInt(1, slr_rate);
			pstmt.setString(2, pdo_no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(setSlrRate出問題了) " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void setMem(Integer mem_rate, String mem_review) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SETMEM);
			
			pstmt.setInt(1, mem_rate);
			pstmt.setString(2, mem_review);
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(setMem出問題了) " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void setPayment(String pdo_params,String pdo_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SETPAYMENT);
			
			pstmt.setString(1, pdo_params);
			pstmt.setString(2, pdo_no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(setPayment出問題了) " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public List<PrdOdrVO> memGetByNew(String mem_no) {
		List<PrdOdrVO> list = new ArrayList<PrdOdrVO>();
		PrdOdrVO prdOdrVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MEM_GET_NEW);
			pstmt.setString(1, mem_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				prdOdrVO = new PrdOdrVO();
				prdOdrVO.setPdo_no(rs.getString("pdo_no"));
				prdOdrVO.setMem_no(rs.getString("mem_no"));
				prdOdrVO.setSlr_no(rs.getString("slr_no"));
				prdOdrVO.setPdo_stat(rs.getString("pdo_stat"));
				prdOdrVO.setPdo_resr_date(rs.getDate("pdo_resr_date"));
				prdOdrVO.setSlr_rate(rs.getInt("slr_rate"));
				prdOdrVO.setMem_rate(rs.getInt("mem_rate"));
				prdOdrVO.setMem_review(rs.getString("mem_review"));
				prdOdrVO.setPdo_params(rs.getString("pdo_params"));
				prdOdrVO.setCp_no(rs.getString("cp_no"));
				list.add(prdOdrVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(memGetByNew出問題了) "
					+ se.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}


	@Override
	public List<PrdOdrVO> memGetByDeliver(String mem_no) {
		List<PrdOdrVO> list = new ArrayList<PrdOdrVO>();
		PrdOdrVO prdOdrVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MEM_GET_DELIVER);
			pstmt.setString(1, mem_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				prdOdrVO = new PrdOdrVO();
				prdOdrVO.setPdo_no(rs.getString("pdo_no"));
				prdOdrVO.setMem_no(rs.getString("mem_no"));
				prdOdrVO.setSlr_no(rs.getString("slr_no"));
				prdOdrVO.setPdo_stat(rs.getString("pdo_stat"));
				prdOdrVO.setPdo_resr_date(rs.getDate("pdo_resr_date"));
				prdOdrVO.setSlr_rate(rs.getInt("slr_rate"));
				prdOdrVO.setMem_rate(rs.getInt("mem_rate"));
				prdOdrVO.setMem_review(rs.getString("mem_review"));
				prdOdrVO.setPdo_params(rs.getString("pdo_params"));
				prdOdrVO.setCp_no(rs.getString("cp_no"));
				list.add(prdOdrVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(memGetByDeliver出問題了) "
					+ se.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public List<PrdOdrVO> memGetByCancel(String mem_no) {
		List<PrdOdrVO> list = new ArrayList<PrdOdrVO>();
		PrdOdrVO prdOdrVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MEM_GET_CANCEL);
			pstmt.setString(1, mem_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				prdOdrVO = new PrdOdrVO();
				prdOdrVO.setPdo_no(rs.getString("pdo_no"));
				prdOdrVO.setMem_no(rs.getString("mem_no"));
				prdOdrVO.setSlr_no(rs.getString("slr_no"));
				prdOdrVO.setPdo_stat(rs.getString("pdo_stat"));
				prdOdrVO.setPdo_resr_date(rs.getDate("pdo_resr_date"));
				prdOdrVO.setSlr_rate(rs.getInt("slr_rate"));
				prdOdrVO.setMem_rate(rs.getInt("mem_rate"));
				prdOdrVO.setMem_review(rs.getString("mem_review"));
				prdOdrVO.setPdo_params(rs.getString("pdo_params"));
				prdOdrVO.setCp_no(rs.getString("cp_no"));
				list.add(prdOdrVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(memGetByCancel出問題了) "
					+ se.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public List<PrdOdrVO> slrGetByNew(String slr_no) {
		List<PrdOdrVO> list = new ArrayList<PrdOdrVO>();
		PrdOdrVO prdOdrVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SLR_GET_NEW);
			pstmt.setString(1, slr_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				prdOdrVO = new PrdOdrVO();
				prdOdrVO.setPdo_no(rs.getString("pdo_no"));
				prdOdrVO.setMem_no(rs.getString("mem_no"));
				prdOdrVO.setSlr_no(rs.getString("slr_no"));
				prdOdrVO.setPdo_stat(rs.getString("pdo_stat"));
				prdOdrVO.setPdo_resr_date(rs.getDate("pdo_resr_date"));
				prdOdrVO.setSlr_rate(rs.getInt("slr_rate"));
				prdOdrVO.setMem_rate(rs.getInt("mem_rate"));
				prdOdrVO.setMem_review(rs.getString("mem_review"));
				prdOdrVO.setPdo_params(rs.getString("pdo_params"));
				prdOdrVO.setCp_no(rs.getString("cp_no"));
				list.add(prdOdrVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(slrGetByNew出問題了) "
					+ se.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public List<PrdOdrVO> slrGetByDeliver(String slr_no) {
		List<PrdOdrVO> list = new ArrayList<PrdOdrVO>();
		PrdOdrVO prdOdrVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SLR_GET_DELIVER);
			pstmt.setString(1, slr_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				prdOdrVO = new PrdOdrVO();
				prdOdrVO.setPdo_no(rs.getString("pdo_no"));
				prdOdrVO.setMem_no(rs.getString("mem_no"));
				prdOdrVO.setSlr_no(rs.getString("slr_no"));
				prdOdrVO.setPdo_stat(rs.getString("pdo_stat"));
				prdOdrVO.setPdo_resr_date(rs.getDate("pdo_resr_date"));
				prdOdrVO.setSlr_rate(rs.getInt("slr_rate"));
				prdOdrVO.setMem_rate(rs.getInt("mem_rate"));
				prdOdrVO.setMem_review(rs.getString("mem_review"));
				prdOdrVO.setPdo_params(rs.getString("pdo_params"));
				prdOdrVO.setCp_no(rs.getString("cp_no"));
				list.add(prdOdrVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(slrGetByDeliver出問題了) "
					+ se.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public List<PrdOdrVO> slrGetByCancel(String slr_no) {
		List<PrdOdrVO> list = new ArrayList<PrdOdrVO>();
		PrdOdrVO prdOdrVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SLR_GET_CANCEL);
			pstmt.setString(1, slr_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				prdOdrVO = new PrdOdrVO();
				prdOdrVO.setPdo_no(rs.getString("pdo_no"));
				prdOdrVO.setMem_no(rs.getString("mem_no"));
				prdOdrVO.setSlr_no(rs.getString("slr_no"));
				prdOdrVO.setPdo_stat(rs.getString("pdo_stat"));
				prdOdrVO.setPdo_resr_date(rs.getDate("pdo_resr_date"));
				prdOdrVO.setSlr_rate(rs.getInt("slr_rate"));
				prdOdrVO.setMem_rate(rs.getInt("mem_rate"));
				prdOdrVO.setMem_review(rs.getString("mem_review"));
				prdOdrVO.setPdo_params(rs.getString("pdo_params"));
				prdOdrVO.setCp_no(rs.getString("cp_no"));
				list.add(prdOdrVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(slrGetByCancel出問題了) "
					+ se.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public PrdOdrVO findByPdoNo(String pdo_no) {
		PrdOdrVO prdOdrVO = new PrdOdrVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_PDO_NO);
			pstmt.setString(1, pdo_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				prdOdrVO.setPdo_no(rs.getString("pdo_no"));
				prdOdrVO.setMem_no(rs.getString("mem_no"));
				prdOdrVO.setSlr_no(rs.getString("slr_no"));
				prdOdrVO.setPdo_stat(rs.getString("pdo_stat"));
				prdOdrVO.setPdo_resr_date(rs.getDate("pdo_resr_date"));
				prdOdrVO.setSlr_rate(rs.getInt("slr_rate"));
				prdOdrVO.setMem_rate(rs.getInt("mem_rate"));
				prdOdrVO.setMem_review(rs.getString("mem_view"));
				prdOdrVO.setPdo_params(rs.getString("pdo_params"));
				prdOdrVO.setCp_no(rs.getString("cp_no"));
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured.(findByPdoNo出問題了) "
					+ se.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return null;
	}

}
