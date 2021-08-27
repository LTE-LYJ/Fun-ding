package com.kh.project_report.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ProjectReport {
	//신고게시판
	
	private int prjReportNo; //신고게시글번호
	private String prjReportTitle; //신고게시글제목
	private String prjReportContent; //신고게시글내용
	private int prjReportWriter; //작성자회원번호
	private int count; //조회수
	private Date createDate; //작성일
	private int prjReportLevel; //게시글레벨 신고글:1/신고글답변:2
	private String status; //상태값(Y/N)
	private String files; //파일
	
	public ProjectReport(int prjReportNo, String prjReportTitle, String prjReportContent, int prjReportWriter,
			int count, Date createDate, int prjReportLevel, String status, String files) {
		super();
		this.prjReportNo = prjReportNo;
		this.prjReportTitle = prjReportTitle;
		this.prjReportContent = prjReportContent;
		this.prjReportWriter = prjReportWriter;
		this.count = count;
		this.createDate = createDate;
		this.prjReportLevel = prjReportLevel;
		this.status = status;
		this.files = files;
	}
	
	
	public ProjectReport() {
		// TODO Auto-generated constructor stub
	}


	

}
