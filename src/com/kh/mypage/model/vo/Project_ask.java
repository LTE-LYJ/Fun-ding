package com.kh.mypage.model.vo;

import java.sql.Date;

public class Project_ask {

	private int prjAskNo;//	문의번호
	private String prjAskTitle;//	문의제목
	private String prjAskContent;//	문의내용
	private int count;//	조회수
	private Date enrollDate;//	작성일
	private int status;//	상태값(Y/N)
	private int prjNo;//	프로젝트 번호
	private int memNo;//	회원번호
	
	public Project_ask() {
		// TODO Auto-generated constructor stub
	}

	public Project_ask(int prjAskNo, String prjAskTitle, String prjAskContent, int count, Date enrollDate, int status,
			int prjNo, int memNo) {
		super();
		this.prjAskNo = prjAskNo;
		this.prjAskTitle = prjAskTitle;
		this.prjAskContent = prjAskContent;
		this.count = count;
		this.enrollDate = enrollDate;
		this.status = status;
		this.prjNo = prjNo;
		this.memNo = memNo;
	}

	public Project_ask(int prjAskNo, String prjAskTitle, Date enrollDate, int memNo) {
		super();
		this.prjAskNo = prjAskNo;
		this.prjAskTitle = prjAskTitle;
		this.enrollDate = enrollDate;
		this.memNo = memNo;
	}

	public int getPrjAskNo() {
		return prjAskNo;
	}

	public void setPrjAskNo(int prjAskNo) {
		this.prjAskNo = prjAskNo;
	}

	public String getPrjAskTitle() {
		return prjAskTitle;
	}

	public void setPrjAskTitle(String prjAskTitle) {
		this.prjAskTitle = prjAskTitle;
	}

	public String getPrjAskContent() {
		return prjAskContent;
	}

	public void setPrjAskContent(String prjAskContent) {
		this.prjAskContent = prjAskContent;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPrjNo() {
		return prjNo;
	}

	public void setPrjNo(int prjNo) {
		this.prjNo = prjNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	@Override
	public String toString() {
		return "Project_ask [prjAskNo=" + prjAskNo + ", prjAskTitle=" + prjAskTitle + ", prjAskContent=" + prjAskContent
				+ ", count=" + count + ", enrollDate=" + enrollDate + ", status=" + status + ", prjNo=" + prjNo
				+ ", memNo=" + memNo + "]";
	}
	
	
}
