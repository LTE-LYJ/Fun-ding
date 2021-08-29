package com.kh.project_report.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kh.notice.model.vo.Notice;
import com.kh.project_report.model.vo.ProjectReport;

public class ProjectReportDao {

	public List<ProjectReport> getProjectReportList(Connection con, String field, String query, int page) {
List<ProjectReport> list = new ArrayList<>();
		
		String sql = "SELECT * FROM( "
				+ "				 SELECT ROWNUM NUM, N.* "
				+ "			FROM (SELECT A.*, B.MEM_NAME "
				+ "                FROM PROJECT_REPORT A"
				+ "                INNER JOIN MEMBER B ON MEM_NO = PRJ_REPORT_WRITER "
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
				int prjReportNo = rs.getInt("PRJ_REPORT_NO");
				String prjReportTitle = rs.getString("PRJ_REPORT_TITLE");
				String prjReportContent = rs.getString("PRJ_REPORT_CONTENT");
				int prjReportWriter = rs.getInt("PRJ_REPORT_WRITER");
				String writerName = rs.getString("MEM_NAME");
				int count = rs.getInt("COUNT");
				Date createDate = rs.getDate("CREATE_DATE");
				int prjReportLevel = rs.getInt("PRJ_REPORT_LEVEL");
				String status = rs.getString("STATUS");
				String files = rs.getString("FILES");
				int prj_no = rs.getInt("PRJ_NO");
				
				ProjectReport prjReport = new ProjectReport(
						prjReportNo,
						prjReportTitle,
						prjReportContent,
						prjReportWriter,
						writerName,
						count,
						createDate,
						prjReportLevel,
						status,
						files,
						prj_no
						);
				
				list.add(prjReport);
				
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
	public int getProjectReportCount(Connection con, String field, String query) {
		int count = 0;
		String sql = "SELECT COUNT(PRJ_REPORT_NO) COUNT FROM ("
				+ "SELECT ROWNUM NUM, P.* "
				+ " FROM (SELECT * FROM PROJECT_REPORT "
				+ " WHERE "+ field +" LIKE  ? "
				+ " AND STATUS = 'Y' "
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


	public ProjectReport getProjectReport(Connection con, int projectReportNo) {
		ProjectReport prjReport = null;
		
		String sql = "SELECT * FROM PROJECT_REPORT A"
				+ "	INNER JOIN MEMBER B ON MEM_NO = PRJ_REPORT_WRITER"
				+ " WHERE PRJ_REPORT_NO=?";
		PreparedStatement st =null;
		ResultSet rs = null;
		try {
			
			st = con.prepareStatement(sql);
			st.setInt(1, projectReportNo);
		
			rs = st.executeQuery();
			
			
			if (rs.next()) {
				int prjReportNo = rs.getInt("PRJ_REPORT_NO");
				String prjReportTitle = rs.getString("PRJ_REPORT_TITLE");
				String prjReportContent = rs.getString("PRJ_REPORT_CONTENT");
				int prjReportWriter = rs.getInt("PRJ_REPORT_WRITER");
				String writerName = rs.getString("MEM_NAME");
				int count = rs.getInt("COUNT");
				Date createDate = rs.getDate("CREATE_DATE");
				int prjReportLevel = rs.getInt("PRJ_REPORT_LEVEL");
				String status = rs.getString("STATUS");
				String files = rs.getString("FILES");
				int prj_no = rs.getInt("PRJ_NO");
				
				prjReport = new ProjectReport(
						prjReportNo,
						prjReportTitle,
						prjReportContent,
						prjReportWriter,
						writerName,
						count,
						createDate,
						prjReportLevel,
						status,
						files,
						prj_no
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
		
		return prjReport;
	}

	public ProjectReport getNextProjectReport(Connection con, int id) {
		ProjectReport prjReport = null;
		
		String sql = "SELECT PRJ_REPORT_NO, PRJ_REPORT_TITLE FROM PROJECT_REPORT "
				+ "				WHERE PRJ_REPORT_NO = ( "
				+ "				SELECT PRJ_REPORT_NO FROM PROJECT_REPORT "
				+ "				WHERE CREATE_DATE > (SELECT CREATE_DATE FROM PROJECT_REPORT WHERE PRJ_REPORT_NO = ? ) "
				+ "				AND STATUS = 'Y' "
				+ "				AND ROWNUM = 1) ";
			
		
		PreparedStatement st =null;
		ResultSet rs = null;
		
		try {
			
			st = con.prepareStatement(sql);
			st.setInt(1, id);
		
			rs = st.executeQuery();
			
			
			if (rs.next()) {
				int prjReportNo = rs.getInt("PRJ_REPORT_NO");
				String prjReportTitle = rs.getString("PRJ_REPORT_TITLE");
				
				prjReport = new ProjectReport(
						prjReportNo,
						prjReportTitle
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
		return prjReport;
	}

	public ProjectReport getPrevProjectReport(Connection con, int id) {
		ProjectReport prjReport = null;
		
		String sql = "SELECT PRJ_REPORT_NO, PRJ_REPORT_TITLE FROM (SELECT * FROM PROJECT_REPORT A"
				+ "				ORDER BY CREATE_DATE DESC) \r\n"
				+ "				WHERE CREATE_DATE < (SELECT CREATE_DATE FROM PROJECT_REPORT WHERE PRJ_REPORT_NO=? AND STATUS = 'Y' ) "
				+ "				AND ROWNUM = 1";
		
		PreparedStatement st =null;
		ResultSet rs = null;
		
		try {
			
			st = con.prepareStatement(sql);
			st.setInt(1, id);
		
			rs = st.executeQuery();
			
			
			if (rs.next()) {
				int prjReportNo = rs.getInt("PRJ_REPORT_NO");
				String prjReportTitle = rs.getString("PRJ_REPORT_TITLE");
				
				
				prjReport = new ProjectReport(
						prjReportNo,
						prjReportTitle
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
		return prjReport;
	}

	
	public int insertProjectReport(Connection con, ProjectReport p) {
		int result = 0;
		String sql = "INSERT INTO PROJECT_REPORT "
				+ "VALUES(PRJ_REPORT_NO_SEQ.NEXTVAL, ? , ? , ?, DEFAULT,DEFAULT,  1, DEFAULT, ?, ?)";
		PreparedStatement st =null;
		
		try {
			st = con.prepareStatement(sql);
			st.setString(1, p.getPrjReportTitle());
			st.setString(2, p.getPrjReportContent());
			st.setInt(3, Integer.parseInt(p.getWriterName()));
			st.setInt(4, p.getPrjNo());
			st.setString(5, p.getFiles());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}
		
		return result;
	}

	public int deleteProjectReport(Connection con, int prjRrportNo) {
		int result = 0;
		String sql = "UPDATE PROJECT_REPORT SET STATUS='N' WHERE PRJ_REPORT_NO=?";
		PreparedStatement st =null;
		
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, prjRrportNo);
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}
		
		return result;
	}

	public ProjectReport selectProjectReport(Connection con, int ProjectReportNo) {
		ProjectReport prjReport = null;
		String sql = "SELECT MEM_NAME, P.*  "
				+ " FROM PROJECT_REPORT P "
				+ "INNER JOIN MEMBER ON MEM_NO = PRJ_REPORT_WRITER "
				+ "WHERE PRJ_REPORT_NO=? ";
				
				
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = con.prepareStatement(sql);
			
			st.setInt(1, ProjectReportNo);
			rs = st.executeQuery();
			if(rs.next()) {
				int prjReportNo = rs.getInt("PRJ_REPORT_NO");
				String prjReportTitle = rs.getString("PRJ_REPORT_TITLE");
				String prjReportContent = rs.getString("PRJ_REPORT_CONTENT");
				int prjReportWriter = rs.getInt("PRJ_REPORT_WRITER");
				String WriterName = rs.getString("MEM_NAME");
				int count = rs.getInt("COUNT");
				Date createDate = rs.getDate("CREATE_DATE");
				int prjReportLevel = rs.getInt("PRJ_REPORT_LEVEL");
				String status = rs.getString("STATUS");
				String files = rs.getString("FILES");
				int prj_no = rs.getInt("PRJ_NO");
				prjReport = new ProjectReport(
						prjReportNo,
						prjReportTitle,
						prjReportContent,
						prjReportWriter,
						WriterName,
						count,
						createDate,
						prjReportLevel,
						status,
						files,
						prj_no
						);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
		}
		return prjReport;
	}

	public int updateProjectReport(Connection con, ProjectReport p) {
		
		int result = 0;
		PreparedStatement st = null;
		
		String sql = "UPDATE PROJECT_REPORT SET PRJ_REPORT_TITLE=?, PRJ_REPORT_CONTENT=?, FILES=?, PRJ_NO=?  WHERE PRJ_REPORT_NO=?";
		
		try {
			st = con.prepareStatement(sql);
			st.setString(1, p.getPrjReportTitle());
			st.setString(2, p.getPrjReportContent());
			st.setString(3, p.getFiles());
			st.setInt(4, p.getPrjNo());
			st.setInt(5, p.getPrjReportNo());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}
		return result;
	}

	public int updateCount(Connection con, int projectReportNo) {
		int result = 0;
		PreparedStatement st = null;
		
		String sql = "UPDATE PROJECT_REPORT SET COUNT = COUNT+1 WHERE PRJ_REPORT_NO=?";
		
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, projectReportNo);
			
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
