package com.kh.notice.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.kh.member.model.dao.MemberDao;
import com.kh.notice.model.vo.Notice;

public class NoticeDao {
	
	

	public List<Notice> getNoticeList(Connection con, String field, String query, int page) {
		List<Notice> list = new ArrayList<>();
		
		String sql = "SELECT * FROM( "
				+ "				 SELECT ROWNUM NUM, N.* "
				+ "			FROM (SELECT A.*, B.MEM_NAME "
				+ "                FROM NOTICE A"
				+ "                INNER JOIN MEMBER B ON MEM_NO = NOTICE_WRITER "
				+ "            WHERE "+ field+ " LIKE ? ORDER BY CREATE_DATE DESC) N  "
				+ "				WHERE STATUS = 'Y'"
				+ "				 ) "
				+ "			 WHERE NUM BETWEEN ? AND ? ";
		
		PreparedStatement st =null;
		ResultSet rs = null;
		
		try {
			
			st = con.prepareStatement(sql);
			st.setString(1, "%"+ query +"%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page*10);
			rs = st.executeQuery();
			
			
			while (rs.next()) {
				int noticeNo = rs.getInt("NOTICE_NO");
				String noticeTitle = rs.getString("NOTICE_TITLE");
				String noticeContent = rs.getString("NOTICE_CONTENT");
				String noticeWriter = rs.getString("MEM_NAME");
				int count = rs.getInt("COUNT");
				Date createDate = rs.getDate("CREATE_DATE");
				String status = rs.getString("STATUS");
				String files = rs.getString("FILES");
				
				Notice notice = new Notice(
						noticeNo,
						noticeTitle,
						noticeContent,
						noticeWriter,
						count,
						createDate,
						status,
						files
						);
				
				list.add(notice);
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		return list;
	}

	public int getNoticeCount(Connection con, String field, String query) {
		int count = 0;
		String sql = "SELECT COUNT(NOTICE_NO) COUNT FROM ("
				+ "SELECT ROWNUM NUM, P.* "
				+ " FROM (SELECT * FROM NOTICE N "
				+ "	LEFT JOIN MEMBER ON MEM_NO = NOTICE_WRITER "
				+ " WHERE "+ field +" LIKE  ? "
				+ " AND N.STATUS = 'Y' "
				+ "ORDER BY CREATE_DATE DESC) P "
				+ ") ";
		PreparedStatement st =null;
		ResultSet rs = null;
		
		try {
			
			st = con.prepareStatement(sql);
			st.setString(1, "%"+ query +"%");
			
			rs = st.executeQuery();
			if(rs.next())
			count = rs.getInt("COUNT");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		
		return count;
	}


	public Notice getNotice(Connection con, int noticeNo) {
		Notice notice = null;
		
		String sql = "SELECT * FROM NOTICE A"
				+ "	INNER JOIN MEMBER B ON MEM_NO = NOTICE_WRITER"
				+ " WHERE NOTICE_NO=?";
		PreparedStatement st =null;
		ResultSet rs = null;
		try {
			
			st = con.prepareStatement(sql);
			st.setInt(1, noticeNo);
		
			rs = st.executeQuery();
			
			
			if (rs.next()) {
				int nNoticeNo = rs.getInt("NOTICE_NO");
				String noticeTitle = rs.getString("NOTICE_TITLE");
				String noticeContent = rs.getString("NOTICE_CONTENT");
				String noticeWriter = rs.getString("MEM_NAME");
				int count = rs.getInt("COUNT");
				Date createDate = rs.getDate("CREATE_DATE");
				String status = rs.getString("STATUS");
				String files = rs.getString("FILES");
				
				notice = new Notice(
						nNoticeNo,
						noticeTitle,
						noticeContent,
						noticeWriter,
						count,
						createDate,
						status,
						files
						);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		
		return notice;
	}

	public Notice getNextNotice(Connection con, int id) {
		Notice notice = null;
		
		String sql = "SELECT NOTICE_NO, NOTICE_TITLE FROM NOTICE "
				+ "				WHERE NOTICE_NO = ( "
				+ "				SELECT NOTICE_NO FROM NOTICE "
				+ "				WHERE CREATE_DATE > (SELECT CREATE_DATE FROM NOTICE WHERE NOTICE_NO= ? ) "
				+ "				AND STATUS = 'Y' "
				+ "				AND ROWNUM = 1) ";
			
		
		PreparedStatement st =null;
		ResultSet rs = null;
		
		try {
			
			st = con.prepareStatement(sql);
			st.setInt(1, id);
		
			rs = st.executeQuery();
			
			
			if (rs.next()) {
				int noticeNo = rs.getInt("NOTICE_NO");
				String noticeTitle = rs.getString("NOTICE_TITLE");
				
				notice = new Notice(
						noticeNo,
						noticeTitle
						);
				
				
			}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		return notice;
	}

	public Notice getPrevNotice(Connection con, int id) {
		Notice notice = null;
		
		String sql = "SELECT NOTICE_NO, NOTICE_TITLE FROM (SELECT * FROM NOTICE A"
				+ "				ORDER BY CREATE_DATE DESC) "
				+ "				WHERE CREATE_DATE < (SELECT CREATE_DATE FROM NOTICE WHERE NOTICE_NO=?  ) "
				+ "				AND STATUS = 'Y' "
				+ "				AND ROWNUM = 1";
		
		PreparedStatement st =null;
		ResultSet rs = null;
		
		try {
			
			st = con.prepareStatement(sql);
			st.setInt(1, id);
		
			rs = st.executeQuery();
			
			
			if (rs.next()) {
				int noticeNo = rs.getInt("NOTICE_NO");
				String noticeTitle = rs.getString("NOTICE_TITLE");
				
				
				notice = new Notice(
						noticeNo,
						noticeTitle
						);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			close(rs);
			close(st);
			close(con);
		}
		return notice;
	}

	
	public int insertNotice(Connection con, Notice n) {
		int result = 0;
		String sql = "INSERT INTO NOTICE"
				+ " VALUES(NOTICE_NO_SEQ.NEXTVAL, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT, ?)";
		PreparedStatement st =null;
		
		try {
			st = con.prepareStatement(sql);
			st.setString(1, n.getNoticeTitle());
			st.setString(2, n.getNoticeContent());
			st.setInt(3, Integer.parseInt(n.getNoticeWriter()));
			st.setString(4, n.getFiles());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}
		
		return result;
	}

	public int deleteNotice(Connection con, int noticeNo) {
		int result = 0;
		String sql = "UPDATE NOTICE SET STATUS='N' WHERE NOTICE_NO=?";
		PreparedStatement st =null;
		
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, noticeNo);
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}
		
		return result;
	}

	public Notice selectNotice(Connection con, int noticeNo) {
		Notice n = null;
		String sql = "SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, MEM_NAME, COUNT, CREATE_DATE, FILES  "
				+ " FROM NOTICE N "
				+ "INNER JOIN MEMBER ON MEM_NO = NOTICE_WRITER "
				+ "WHERE NOTICE_NO=? ";
				
				
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = con.prepareStatement(sql);
			
			st.setInt(1, noticeNo);
			rs = st.executeQuery();
			if(rs.next()) {
				n = new Notice(
						rs.getInt("NOTICE_NO"),
						rs.getString("NOTICE_TITLE"),
						rs.getString("NOTICE_CONTENT"),
						rs.getString("MEM_NAME"),
						rs.getInt("COUNT"),
						rs.getDate("CREATE_DATE"),
						rs.getString("FILES")
						);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
		}
		return n;
	}

	public int UpdateNotice(Connection con, Notice n) {
		
		int result = 0;
		PreparedStatement st = null;
		
		String sql = "UPDATE NOTICE SET NOTICE_TITLE=?, NOTICE_CONTENT=?, FILES=? WHERE NOTICE_NO=?";
		
		try {
			st = con.prepareStatement(sql);
			st.setString(1, n.getNoticeTitle());
			st.setString(2, n.getNoticeContent());
			st.setString(3, n.getFiles());
			st.setInt(4, n.getNoticeNo());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}
		return result;
	}

	public int updateCount(Connection con, int noticeNo) {
		int result = 0;
		PreparedStatement st = null;
		
		String sql = "UPDATE NOTICE SET COUNT = COUNT+1 WHERE NOTICE_NO=?";
		
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, noticeNo);
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}
		return result;
	}

	
	
	
}
