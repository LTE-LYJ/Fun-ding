package com.kh.project_report.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PrAnswer {
	
	private int prjReportNo; //신고게시글번호
	private String prjReportTitle; //신고게시글제목
	private String prjReportContent; //신고게시글내용
	private int prjReportWriter; //작성자회원번호
	private String writerName; // 작성자 이름
	private int count; //조회수
	private Date createDate; //작성일
	private String files; //파일
	private int prjNo; // 프로젝트 번호
	
	
	public PrAnswer(int prjReportNo, String prjReportTitle, String prjReportContent, int prjReportWriter,
			String writerName, int count, Date createDate, String files, int prjNo) {
		super();
		this.prjReportNo = prjReportNo;
		this.prjReportTitle = prjReportTitle;
		this.prjReportContent = prjReportContent;
		this.prjReportWriter = prjReportWriter;
		this.writerName = writerName;
		this.count = count;
		this.createDate = createDate;
		this.files = files;
		this.prjNo = prjNo;
	}
	
	public PrAnswer() {
		// TODO Auto-generated constructor stub
	}

	public PrAnswer(int prjReportNo, String prjReportTitle, String prjReportContent, String writerName, String files,
			int prjNo) {
		super();
		this.prjReportNo = prjReportNo;
		this.prjReportTitle = prjReportTitle;
		this.prjReportContent = prjReportContent;
		this.writerName = writerName;
		this.files = files;
		this.prjNo = prjNo;
	}
	
	
	

}
