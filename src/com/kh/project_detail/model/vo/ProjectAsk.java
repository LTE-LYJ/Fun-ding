package com.kh.project_detail.model.vo;

import java.util.Date;

public class ProjectAsk {
	//문의작성
	
	private int prjAskNo; //문의번호
	private String prjAskTitle; //문의제목
	private String prjAskContent; //문의내용
	private int count; //조회수
	private Date enrollDate; //작성일
	private String status; //상태값(Y/N)
	private int prjNo; //프로젝트 번호
	private String memId; //회원 아이디
	
	public ProjectAsk() {
		// TODO Auto-generated constructor stub
	}
	

	public ProjectAsk(int prjAskNo, String prjAskTitle, String prjAskContent, int count, Date enrollDate, String status,
			int prjNo, String memId) {
		super();
		this.prjAskNo = prjAskNo;
		this.prjAskTitle = prjAskTitle;
		this.prjAskContent = prjAskContent;
		this.count = count;
		this.enrollDate = enrollDate;
		this.status = status;
		this.prjNo = prjNo;
		this.memId = memId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrjNo() {
		return prjNo;
	}

	public void setPrjNo(int prjNo) {
		this.prjNo = prjNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	@Override
	public String toString() {
		return "ProjectAsk [prjAskNo=" + prjAskNo + ", prjAskTitle=" + prjAskTitle + ", prjAskContent=" + prjAskContent
				+ ", count=" + count + ", enrollDate=" + enrollDate + ", status=" + status + ", prjNo=" + prjNo
				+ ", memNo=" + memId + "]";
	}

}
