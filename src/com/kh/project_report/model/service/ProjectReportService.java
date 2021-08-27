package com.kh.project_report.model.service;

import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.project_report.model.dao.ProjectReportDao;
import com.kh.project_report.model.vo.ProjectReport;

public class ProjectReportService {

	

	
	public List<ProjectReport> getProjectReportList() {
		return getProjectReportList("PROJECT_TITLE", "", 1);
	}
	
	public List<ProjectReport> getProjectReportList(int page) {
		return getProjectReportList("PROJECT_TITLE", "", page);
	}
	
	public List<ProjectReport> getProjectReportList(String field, String query, int page) {
		Connection con = getConnection();
		
		List<ProjectReport> list = new ProjectReportDao().getProjectReportList(con, field, query, page);
		
		return list;
	}

	
	
	public int getNoticeCount(String field, String query) {
		// TODO Auto-generated method stub
		return 0;
	}
}
