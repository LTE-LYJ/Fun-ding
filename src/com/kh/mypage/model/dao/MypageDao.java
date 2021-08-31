package com.kh.mypage.model.dao;

//import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.member.model.vo.Member;
import com.kh.mypage.model.vo.Board;
import com.kh.mypage.model.vo.PageInfo;
import com.kh.mypage.model.vo.Project;
import com.kh.mypage.model.vo.Project_ask;
import com.kh.mypage.model.vo.Project_report;

public class MypageDao {
	
	private Properties prop = new Properties();
	
	public MypageDao() {
		String fileName = MypageDao.class.getResource("/com/sql/mypage/mypage-query.properties").getPath();
		System.out.println("fileName   " + fileName);
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

	public int updateMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		//Member member = null;
		
		//String sql = prop.getProperty("updateMember");
		String sql = "UPDATE MEMBER SET MEM_NAME=?, PHONE=?, EMAIL=?, ADDRESS=? WHERE MEM_ID=?";

		
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, loginUser);
			
			pstmt.setString(1, m.getMemName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getMemId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		//System.out.println(m);
		return result;
	}

	public int getMainListCount(Connection conn) {
		
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getMainListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<Board> selectMainList(Connection conn, PageInfo pi) {
		
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//String sql = prop.getProperty("selectList");
		String sql = "SELECT BOARD_NO "
				+ ", BOARD_TITLE "
				+ ", BOARD_WRITER "
				+ ", CREATE_DATE "
				+ "FROM BOARD "
				+ "INNER JOIN MEMBER ON MEM_NO = BOARD_WRITER "
				+ "WHERE BOARD_WRITER = ? ";
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("BOARD_NO"),
									
									rset.getString("BOARD_TITLE"),
									rset.getInt("BOARD_WRITER"),
									rset.getDate("CREATE_DATE")
									));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int getAskListCount(Connection conn) {

		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getAskListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Project_ask> selectAskList(Connection conn, PageInfo pi) {

		ArrayList<Project_ask> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String sql = "SELECT PRJ_ASK_NO "
				+ ", PRJ_ASK_TITLE "
				
				+ ", ENROLL_DATE "
				+ ", MEM_NO "
				+ "FROM PROJECT_ASK "
				+ "INNER JOIN MEMBER ON MEM_NO = MEM_NO "
				+ "WHERE MEM_NO = ?"; 
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Project_ask(rset.getInt("PRJ_ASK_NO"),									
									rset.getString("PRJ_ASK_TITLE"),
									rset.getDate("ENROLL_DATE"),
									rset.getInt("MEM_NO")
									
									));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	public int getReportListCount(Connection conn) {

		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getReportListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<Project_report> selectReportList(Connection conn, PageInfo pi) {

		ArrayList<Project_report> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String sql = "SELECT PRJ_REPORT_NO "
				+ ", PRJ_PEPORT_TITLE "
				+ ", CREATE_DATE "
				+ ", PRJ_REPORT_WRITER "
				+ "FROM PROJECT_REPORT "
				+ "INNER JOIN MEMBER ON MEM_NO = PRJ_REPORT_WRITER "
				+ "WHERE MEM_NO = ?"; ////////////////////////////
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Project_report(rset.getInt("PRJ_REPORT_NO"),									
									rset.getString("PRJ_PEPORT_TITLE"),
									
									rset.getInt("PRJ_REPORT_WRITER"),
									rset.getDate("CREATE_DATE")
									
									));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	
	
	
	

	public int deleteMember(Connection conn, String memId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePwd(Connection conn, String memPwd, String memId,String changePwd) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		//Member m = null;
		String sql = prop.getProperty("updatePwd");
		//String sql = "UPDATE MEMBER SET MEM_PWD=? WHERE MEM_ID=? AND MEM_PWD=?";

		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memPwd);
			pstmt.setString(2, memId);
			pstmt.setString(3, changePwd);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		//System.out.println(result);
		return result;
	}

	public int getPrjListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getPrjListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<Project> selectPrjList(Connection conn, PageInfo pi) {
		
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String sql = "SELECT PRJ_NO "
				+ ", PRJ_TITLE "
				
				+ "INNER JOIN MEMBER ON MEM_NO = MEM_NO "
				+ "WHERE MEM_NO = ?";
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Project(rset.getInt("PRJ_NO"),									
									rset.getString("PRJ_TITLE"),
									
									rset.getInt("MEM_NO")
									
									));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	

	public int updateMember(Connection conn, Member m, ProfileAttachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
		//Member member = null;
		
		//String sql = prop.getProperty("updateMember");
		String sql = "UPDATE MEMBER SET MEM_NAME=?, PHONE=?, EMAIL=?, ADDRESS=? WHERE MEM_ID=?";

		
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, loginUser);
			
			pstmt.setString(1, m.getMemName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getMemId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		//System.out.println(m);
		return result;
	}

	public ProfileAttachment selectAttachment(Connection conn, int memNo) {
		
		ProfileAttachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				at = new ProfileAttachment();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return at;
	}
	
	
	
	

	
	
	
	

	

}
