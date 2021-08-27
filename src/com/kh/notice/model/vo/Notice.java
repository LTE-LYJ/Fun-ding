package com.kh.notice.model.vo;
//테스트
import java.util.Date;

import lombok.Data;

@Data
public class Notice {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeWriter;
	private int count;
	private Date createDate;
	private String status;
	private String files;
	
	
	
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}


	public Notice(String noticeTitle,String noticeWriter, String noticeContent) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
	}


	public Notice(int noticeNo, String noticeTitle, String noticeContent, String noticeWriter, int count,
			Date createDate, String files) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.count = count;
		this.createDate = createDate;
		this.files = files;
	}


	public Notice(int noticeNo, String noticeTitle, String noticeContent, String noticeWriter, int count,
			Date createDate, String status, String files) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
		this.files = files;
	}


	public Notice(int noticeNo, String noticeTitle, String noticeContent, String noticeWriter, String files) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.files = files;
	}


	public Notice(String noticeTitle, String noticeContent, String noticeWriter, String files) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.files = files;
	}


	
	


	


	
	
	
	
	
}
