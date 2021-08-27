package com.kh.project_report.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
				int count = rs.getInt("COUNT");
				Date createDate = rs.getDate("CREATE_DATE");
				int prjReportLevel = rs.getInt("PRJ_REPORT_LEVEL");
				String status = rs.getString("STATUS");
				String files = rs.getString("FILES");
				
				ProjectReport prjReport = new ProjectReport(
						prjReportNo,
						prjReportTitle,
						prjReportContent,
						prjReportWriter,
						count,
						createDate,
						prjReportLevel,
						status,
						files
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

}
