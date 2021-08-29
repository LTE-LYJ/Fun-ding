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
	private String writerName; // 작성자 이름
	private int count; //조회수
	private Date createDate; //작성일
	private String status; //상태값(Y/N)
	private String files; //파일
	private int prjNo; // 프로젝트 번호
	private String answer; // 답변여부
	
	public ProjectReport(int prjReportNo, String prjReportTitle, String prjReportContent, int prjReportWriter,
			int count, Date createDate, String status, String files, String answer) {
		super();
		this.prjReportNo = prjReportNo;
		this.prjReportTitle = prjReportTitle;
		this.prjReportContent = prjReportContent;
		this.prjReportWriter = prjReportWriter;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
		this.files = files;
		this.answer = answer;	}
	
	
	public ProjectReport() {
		// TODO Auto-generated constructor stub
	}


	public ProjectReport(int prjReportNo, String prjReportTitle, String prjReportContent, int prjReportWriter,
			String writerName, int count, Date createDate, String status, String files, String answer) {
		super();
		this.prjReportNo = prjReportNo;
		this.prjReportTitle = prjReportTitle;
		this.prjReportContent = prjReportContent;
		this.prjReportWriter = prjReportWriter;
		this.writerName = writerName;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
		this.files = files;
		this.answer = answer;
	}


	public ProjectReport(String prjReportTitle, String prjReportContent, int prjReportWriter) {
		super();
		this.prjReportTitle = prjReportTitle;
		this.prjReportContent = prjReportContent;
		this.prjReportWriter = prjReportWriter;
	}


	public ProjectReport(int prjReportNo, String prjReportTitle) {
		super();
		this.prjReportNo = prjReportNo;
		this.prjReportTitle = prjReportTitle;
	}


	public ProjectReport(String prjReportTitle, String prjReportContent, int prjReportWriter, String files) {
		super();
		this.prjReportTitle = prjReportTitle;
		this.prjReportContent = prjReportContent;
		this.prjReportWriter = prjReportWriter;
		this.files = files;
	}


	public ProjectReport(int prjReportNo, String prjReportTitle, String prjReportContent, int prjReportWriter,
			String writerName, int count, Date createDate, String status, String files,
			int prjNo, String answer ) {
		super();
		this.prjReportNo = prjReportNo;
		this.prjReportTitle = prjReportTitle;
		this.prjReportContent = prjReportContent;
		this.prjReportWriter = prjReportWriter;
		this.writerName = writerName;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
		this.files = files;
		this.prjNo = prjNo;
		this.answer = answer;
	}


	public ProjectReport(String prjReportTitle, String prjReportContent, String writerName, String files, int prjNo) {
		super();
		this.prjReportTitle = prjReportTitle;
		this.prjReportContent = prjReportContent;
		this.writerName = writerName;
		this.files = files;
		this.prjNo = prjNo;
	}


	public ProjectReport(int prjReportNo, String prjReportTitle, String prjReportContent, String writerName, String files, int prjNo) {
		super();
		this.prjReportNo = prjReportNo;
		this.prjReportTitle = prjReportTitle;
		this.prjReportContent = prjReportContent;
		this.writerName = writerName;
		this.files = files;
		this.prjNo = prjNo;
	}


	
	

}
