package com.kh.project_detail.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.attachment.model.vo.ProjectAttachment;
import com.kh.member.model.vo.Member;
import com.kh.project.model.vo.Creator;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.ProjectCat;
import com.kh.project.model.vo.Reward;
import com.kh.project_detail.model.vo.Funding;
import com.kh.project_detail.model.vo.Order;
import com.kh.project_detail.model.vo.PageInfo;
import com.kh.project_detail.model.vo.Pay;
import com.kh.project_detail.model.vo.ProjectAsk;
import com.kh.project_detail.model.vo.Review;

public class PrjDeDao {
	
	private Properties prop = new Properties();
	
	public PrjDeDao() {
		String fileName = PrjDeDao.class.getResource("/com/sql/project_detail/projectDetail-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProjectAsk> selectList(Connection conn, int num, PageInfo pi) {
		ArrayList<ProjectAsk> askList = new ArrayList<ProjectAsk>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		 int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		 int endRow = startRow + pi.getBoardLimit()-1;
		 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			ProjectAsk a = null;
			while(rset.next()) {
				
				a =  new ProjectAsk();
				a.setPrjAskNo(rset.getInt("PRJ_ASK_NO"));
				a.setPrjAskNownum(rset.getInt("RNUM"));
				a.setPrjAskTitle(rset.getString("PRJ_ASK_TITLE"));
				a.setMemId(rset.getString("MEM_ID"));
				a.setCount(rset.getInt("COUNT"));
				a.setEnrollDate(rset.getDate("ENROLL_DATE"));
				
				askList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return askList;
	}

	public int insertAsk(Connection conn, ProjectAsk a) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAsk");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getPrjAskTitle());
			pstmt.setString(2, a.getPrjAskContent());
			pstmt.setInt(3, a.getPrjNo());//프로젝트번호
			pstmt.setInt(4, Integer.parseInt(a.getMemId()));//회원번호
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Review> selectReList(Connection conn, int num) {
		ArrayList<Review> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRelist");
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				Review a = new Review();
				
				a.setReviewNo(rset.getInt("REVIEW_NO"));
				a.setReviewContent(rset.getString("REVIEW_CONTENT"));
				a.setMemId(rset.getString("MEM_ID"));
				a.setChangeName(rset.getString("CHANGE_NAME"));
							list.add(a);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int insertReview(Connection conn, Review r) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, r.getReviewContent());
			pstmt.setInt(2, r.getPrjNo());
			pstmt.setInt(3, Integer.parseInt(r.getMemId()));
			
			result = pstmt.executeUpdate(); 
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Project selectPList(Connection conn, int num) {
		Project p = new Project();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("prjList");
		System.out.println(sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			DateFormat sdFormat = new SimpleDateFormat("yy/MM/dd");
			if(rset.next()) {
				p.setPrjNo(rset.getInt("PRJ_NO"));
				p.setPrjTitle(rset.getString("PRJ_TITLE"));
				p.setPrjContent(rset.getString("PRJ_CONTENT"));
				p.setPrjTarget(rset.getInt("PRJ_TARGET"));
				p.setPrjCurrent(rset.getInt("PRJ_CURRENT"));
				p.setPrjStartDate(sdFormat.format(rset.getDate("PRJ_STARTDATE")));
				p.setPrjEndDate(sdFormat.format(rset.getDate("PRJ_ENDDATE")));
				p.setPrjRecount(rset.getInt("PRJ_RECOUNT"));
				p.setCreNo(rset.getInt("MEM_NO"));
				p.setPrjCatNo(rset.getInt("PRJ_CAT_NO"));
				p.setStatus(rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}

	public ArrayList<Reward> selectRewordList(Connection conn, int num) {
		ArrayList<Reward> list = new ArrayList<Reward>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("rewordList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			
			Reward re = null;
			while(rset.next()) {
				re= new Reward();
				re.setRwNo(rset.getInt("RW_NO"));
				re.setRwName(rset.getString("RW_NAME"));
				re.setReContent(rset.getString("RW_CONTENT"));
				re.setRwPrice(rset.getInt("RW_PRICE"));
				
				list.add(re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ProjectAsk detailPopupList(Connection conn, int askNum, int num) {
		ProjectAsk ask = new ProjectAsk();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("askPopupList");
		System.out.println(sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, askNum);
			pstmt.setInt(2, num);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				ask.setPrjAskTitle(rset.getString("PRJ_ASK_TITLE"));
				ask.setPrjAskContent(rset.getString("PRJ_ASK_CONTENT"));
				ask.setCount(rset.getInt("COUNT"));
				ask.setEnrollDate(rset.getDate("ENROLL_DATE"));
				ask.setMemId(rset.getString("MEM_ID"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return ask;
	}

	public int askIncreaseCount(Connection conn, int askNum, int num) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("askIncreaseCount");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, askNum);
			pstmt.setInt(2, num);
			
			result = pstmt.executeUpdate();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Creator selectCreList(Connection conn, int num, int writer) {
		Creator c = new Creator();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("creatorList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writer);
			pstmt.setInt(2, num);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c.setCreNo(rset.getInt("CRE_NO"));
				c.setCreName(rset.getString("CRE_NAME"));
				c.setCreContent(rset.getString("CRE_CONTENT"));
				c.setPrjCountNo(rset.getInt("PRE_COUNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return c;
	}

	public ProjectCat selectPreCatList(Connection conn, int num) {
		ProjectCat pc = new ProjectCat();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("prjCatList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pc.setPrjCatName(rset.getString("PRJ_CAT_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return pc;
	}

	public int increaseReCount(Connection conn, int num) {
		Project p = new Project();
		PreparedStatement pstmt = null;
		int result =0;
		String sql = prop.getProperty("reIncreaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int getListCount(Connection conn, int num) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
	      
	      String sql = prop.getProperty("getListCount");
	      
	      try {
	    	  pstmt = conn.prepareStatement(sql);
	    	  pstmt.setInt(1, num);
	    	  rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            listCount = rset.getInt(1); 
	         }
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return listCount;
	   }

	public int deleteReview(Connection conn, int reNum, int num, int writer) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReview");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, reNum);
			pstmt.setInt(2, num);
			pstmt.setInt(3, writer);
			
			result = pstmt.executeUpdate(); 
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ProfileAttachment selectCreatorProfile(Connection conn, int num) {
		ProfileAttachment cp = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCreatorProfile");
		System.out.println(sql);
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				cp = new ProfileAttachment();
				cp.setFileNo(rset.getInt("ATTACHMENT_NO"));
				cp.setOriginName(rset.getString("ORIGIN_NAME"));
				cp.setChangeName(rset.getString("CHANGE_NAME"));
				cp.setFilePath(rset.getString("ATTACHMENT_PATH"));
				
				
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return cp;
}

	public ArrayList<ProjectAttachment> selectPrjAList(Connection conn, int num) {
		ArrayList<ProjectAttachment> list = new ArrayList<ProjectAttachment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewProfileList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			
			ProjectAttachment pa = null;
			while(rset.next()) {
				pa= new ProjectAttachment();
				pa.setFileNo(rset.getInt("ATTACHMENT_NO"));
				pa.setOriginName(rset.getString("ORIGIN_NAME"));
				pa.setChangeName(rset.getString("CHANGE_NAME"));
				pa.setFilePath(rset.getString("ATTACHMENT_PATH"));
				
				list.add(pa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Project prjRecountSelect(Connection conn, int num) {
		Project p = new Project();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("prjRecountSelect");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p.setPrjRecount(rset.getInt("PRJ_RECOUNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}

	public ArrayList<Pay> selectPayList(Connection conn, int writer) {
		ArrayList<Pay> list = new ArrayList<Pay>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("payMeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writer);
			rset = pstmt.executeQuery();
			
			Pay p = null;
			while(rset.next()) {
				p= new Pay();
				p.setCardNo(rset.getLong("CARD_NO"));
				p.setPayDate(rset.getString("CARD_DATE"));
				p.setCardPwd(rset.getString("CARD_PASSWORD"));
				p.setBirth(rset.getString("BIRTH"));
				p.setBank(rset.getString("BANK"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int insertPayMethod(Connection conn, int writer, Pay pay) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPayMethod");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setLong(1, pay.getCardNo());
			pstmt.setString(2, pay.getPayDate());
			pstmt.setString(3, pay.getCardPwd());
			pstmt.setString(4, pay.getBirth());
			pstmt.setString(5, pay.getBank());
			pstmt.setInt(6, writer);
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Pay checkPwdnDate(Connection conn, int writer, String cardPwd, String cardDate, Long opt3) {
		Pay p = new Pay();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("checkPayPwdnDate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, opt3);
			pstmt.setString(2, cardDate);
			pstmt.setString(3, cardPwd);
			pstmt.setInt(4, writer);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p.setPayMNo(rset.getInt("PAY_M_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}

	public int insertPayMethod(Connection conn, int writer, int coin) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("coinPlus");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, coin);
			pstmt.setInt(2, writer);
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Member getCoinCount(Connection conn, int writer) {
		Member p = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getCoinCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writer);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p.setCoin(rset.getInt("COIN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return p;
}

	public int insertFunding(Connection conn, Funding funding) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFunding");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, funding.getMemNo());
			pstmt.setInt(2, funding.getPrjNo());
			pstmt.setInt(3, funding.getRwNo());
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Funding findFundingNum(Connection conn, Funding funding) {
		Funding f = new Funding();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectFunding");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, funding.getMemNo());
			pstmt.setInt(2, funding.getPrjNo());
			pstmt.setInt(3, funding.getRwNo());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				
				f.setFdNo(rset.getInt("FD_NO"));
				System.out.println(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return f;
	}

	public int insertOrder(Connection conn, Order order, int fNum) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertOrderPrj");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, order.getMemName());
			pstmt.setString(2, order.getPhone());
			pstmt.setString(3, order.getReceiverName());
			pstmt.setString(4, order.getShippingAddr());
			pstmt.setInt(5, fNum);
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertOrder(Connection conn, Pay pay) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPay");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, pay.getMemNo());
			pstmt.setInt(2, pay.getPrjNo());
			pstmt.setInt(3, pay.getPrice());
			pstmt.setInt(4, pay.getFdNo());
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int setPrjCurrentAdd(Connection conn, int rewordPrice, int num) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("setPrjCurrentAm");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, rewordPrice);
			pstmt.setInt(2, num);
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}

	public int payCoin(Connection conn, int rewordPrice, int writer) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("payCoin");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, rewordPrice);
			pstmt.setInt(2, writer);
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Reward selectReword(Connection conn, int rewordNum) {
		Reward re = new Reward();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReword");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rewordNum);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				re.setRwName(rset.getString("RW_NAME"));
				re.setReContent(rset.getString("RW_CONTENT"));
				re.setRwPrice(rset.getInt("RW_PRICE"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return re;
	}

	public Order selectOrder(Connection conn, int fNum) {
		Order or = new Order();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectOrder");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fNum);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				or.setOrderNo(rset.getInt("ORDER_PRJ_NO"));
				or.setMemName(rset.getString("BUYER_NAME"));
				or.setPhone(rset.getString("PHONE"));
				or.setReceiverName(rset.getString("RECEIVER_NAME"));
				or.setShippingAddr(rset.getString("SHIPPING_ADDRESS"));
				or.setFdNo(rset.getInt("FD_NO"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return or;
	}

	public int deleteAsk(Connection conn, int askNum, int num, int writer) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteAsk");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, askNum);
			pstmt.setInt(2, num);
			pstmt.setInt(3, writer);
			
			result = pstmt.executeUpdate(); 
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}

