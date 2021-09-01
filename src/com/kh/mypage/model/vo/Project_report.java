package com.kh.mypage.model.vo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Project_report {

	private int prjReportNo; //	신고게시글번호
	private String prjReportTitle; //	신고게시글제목
	private String prjReportContent;//	신고게시글내용
	private int prjReportWriter;//	작성자회원번호
	private int count;//	조회수
	private Date createDate;//	작성일
	private int prjReportLevel;//	게시글레벨 신고글:1/신고글답변:2
	private int prjNo;//	상태값(Y/N)
	private int files;//	프로젝트번호
	private String answer;

	public Project_report() {
		// TODO Auto-generated constructor stub
	}

	public Project_report(int prjReportNo, String prjReportTitle, String prjReportContent, int prjReportWriter,
			int count, Date createDate, int prjReportLevel, int prjNo, int files, String answer) {
		super();
		this.prjReportNo = prjReportNo;
		this.prjReportTitle = prjReportTitle;
		this.prjReportContent = prjReportContent;
		this.prjReportWriter = prjReportWriter;
		this.count = count;
		this.createDate = createDate;
		this.prjReportLevel = prjReportLevel;
		this.prjNo = prjNo;
		this.files = files;
		this.answer = answer;
	}

	public Project_report(int prjReportNo, String prjReportTitle, int prjReportWriter, Date createDate) {
		super();
		this.prjReportNo = prjReportNo;
		this.prjReportTitle = prjReportTitle;
		this.prjReportWriter = prjReportWriter;
		this.createDate = createDate;
	}

	public int getPrjReportNo() {
		return prjReportNo;
	}

	public void setPrjReportNo(int prjReportNo) {
		this.prjReportNo = prjReportNo;
	}

	public String getPrjReportTitle() {
		return prjReportTitle;
	}

	public void setPrjReportTitle(String prjReportTitle) {
		this.prjReportTitle = prjReportTitle;
	}

	public String getPrjReportContent() {
		return prjReportContent;
	}

	public void setPrjReportContent(String prjReportContent) {
		this.prjReportContent = prjReportContent;
	}

	public int getPrjReportWriter() {
		return prjReportWriter;
	}

	public void setPrjReportWriter(int prjReportWriter) {
		this.prjReportWriter = prjReportWriter;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getPrjReportLevel() {
		return prjReportLevel;
	}

	public void setPrjReportLevel(int prjReportLevel) {
		this.prjReportLevel = prjReportLevel;
	}

	public int getPrjNo() {
		return prjNo;
	}

	public void setPrjNo(int prjNo) {
		this.prjNo = prjNo;
	}

	public int getFiles() {
		return files;
	}

	public void setFiles(int files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Project_report [prjReportNo=" + prjReportNo + ", prjReportTitle=" + prjReportTitle
				+ ", prjReportContent=" + prjReportContent + ", prjReportWriter=" + prjReportWriter + ", count=" + count
				+ ", createDate=" + createDate + ", prjReportLevel=" + prjReportLevel + ", prjNo=" + prjNo + ", files="
				+ files + "]";
	}

	public static Project_report fromResultSet(ResultSet rset) throws SQLException {
		return new Project_report(
				rset.getInt("PRJ_REPORT_NO"),
				rset.getString("PRJ_REPORT_TITLE"),
				rset.getString("PRJ_REPORT_CONTENT"),
				rset.getInt("PRJ_REPORT_WRITER"),
				rset.getInt("COUNT"),
				rset.getDate("CREATE_DATE"),
				0,
				rset.getInt("PRJ_NO"),
				rset.getInt("FILES"),
				rset.getString("ANSWER")
		);
	}
}
