package com.kh.project_report.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;
import com.kh.project_report.model.dao.ProjectReportDao;
import com.kh.project_report.model.vo.PrAnswer;
import com.kh.project_report.model.vo.ProjectReport;

public class ProjectReportService {

	public List<ProjectReport> getProjectReportList() {
		return getProjectReportList("PRJ_REPORT_TITLE", "", 1);
	}

	public List<ProjectReport> getProjectReportList(int page) {
		return getProjectReportList("PRJ_REPORT_TITLE", "", page);
	}

	public List<ProjectReport> getProjectReportList(String field, String query, int page) {
		Connection con = getConnection();

		List<ProjectReport> list = new ProjectReportDao().getProjectReportList(con, field, query, page);

		return list;
	}

	public int getProjectReportCount() {

		return getProjectReportCount("PRJ_REPORT_TITLE", "");
	}

	public int getProjectReportCount(String field, String query) {
		Connection con = getConnection();

		int count = new ProjectReportDao().getProjectReportCount(con, field, query);

		return count;
	}

	public ProjectReport getProjectReport(int ProjectReportNo) {
		Connection con = getConnection();

		ProjectReport prjReport = new ProjectReportDao().getProjectReport(con, ProjectReportNo);

		return prjReport;
	}

	public ProjectReport getNextProjectReport(int ProjectReportNo) {
		Connection con = getConnection();

		ProjectReport prjReport = new ProjectReportDao().getNextProjectReport(con, ProjectReportNo);

		return prjReport;
	}

	public ProjectReport getPrevProjectReport(int ProjectReportNo) {
		Connection con = getConnection();
		ProjectReport prjReport = new ProjectReportDao().getPrevProjectReport(con, ProjectReportNo);

		return prjReport;
	}

	public int insertProjectReport(ProjectReport n) {
		Connection con = getConnection();
		int result = new ProjectReportDao().insertProjectReport(con, n);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int deleteProjectReport(int ProjectReportNo) {
		Connection con = getConnection();
		int result = new ProjectReportDao().deleteProjectReport(con, ProjectReportNo);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public ProjectReport selectProjectReport(int ProjectReportNo) {
		Connection con = getConnection();
		ProjectReport n = new ProjectReportDao().selectProjectReport(con, ProjectReportNo);

		return n;
	}

	public int updateProjectReport(ProjectReport n) {
		Connection con = getConnection();
		int result = new ProjectReportDao().updateProjectReport(con, n);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int updateCount(int prjReportNo) {
		Connection con = getConnection();
		int result = new ProjectReportDao().updateCount(con, prjReportNo);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public ProjectReport selectUpdateProjectReport(int prjReportNo) {
		Connection con = getConnection();
		ProjectReport pr = new ProjectReportDao().selectProjectReport(con, prjReportNo);

		return pr;
	}

	public int answerProjectReport(PrAnswer p) {
		Connection con = getConnection();
		int result = new ProjectReportDao().answerProjectReport(con, p);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int answerCheck(int prjReportNo) {
		Connection con = getConnection();
		int result = new ProjectReportDao().answerCheck(con, prjReportNo);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int updateAnswerCount(int prjReportNo) {
		Connection con = getConnection();
		int result = new ProjectReportDao().updateAnswerCount(con, prjReportNo);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public PrAnswer getPrAnswer(int prjReportNo) {
		Connection con = getConnection();

		PrAnswer prAnswer = new ProjectReportDao().getPrAnswer(con, prjReportNo);

		return prAnswer;
	}

	public int deleteAnswer(int prjReportNo) {
		Connection con = getConnection();
		int result = new ProjectReportDao().deleteAnswer(con, prjReportNo);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public int prjDeleteAnswer(int prjReportNo) {
		Connection con = getConnection();
		int result = new ProjectReportDao().prjDeleteAnswer(con, prjReportNo);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

}