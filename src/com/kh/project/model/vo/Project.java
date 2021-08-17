package com.kh.project.model.vo;

import java.util.Date;

public class Project {
	//프로젝트
	
	private int prjNo; //프로젝트 번호
	private String prjTitle; //프로젝트 제목
	private String prjContent; //프로젝트 소개
	private int prjTarget; //목표 금액
	private int prjCurrent; //현재 후원 금액
	private Date prjStartDate; //펀딩 시작일
	private Date prjEndDate; //펀딩 종료일
	private int prjRecount; //재펀딩 요청 회수
	private int creNo; //창작자 번호
	private int prjCatNo; //프로젝트 카테고리 번호
	private int attachmentNo; //첨부 이미지 번호
	private String status; //상태값(Y/N)
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int prjNo, String prjTitle, String prjContent, int prjTarget, int prjCurrent, Date prjStartDate,
			Date prjEndDate, int prjRecount, int creNo, int prjCatNo, int attachmentNo, String status) {
		super();
		this.prjNo = prjNo;
		this.prjTitle = prjTitle;
		this.prjContent = prjContent;
		this.prjTarget = prjTarget;
		this.prjCurrent = prjCurrent;
		this.prjStartDate = prjStartDate;
		this.prjEndDate = prjEndDate;
		this.prjRecount = prjRecount;
		this.creNo = creNo;
		this.prjCatNo = prjCatNo;
		this.attachmentNo = attachmentNo;
		this.status = status;
	}

	public int getPrjNo() {
		return prjNo;
	}

	public void setPrjNo(int prjNo) {
		this.prjNo = prjNo;
	}

	public String getPrjTitle() {
		return prjTitle;
	}

	public void setPrjTitle(String prjTitle) {
		this.prjTitle = prjTitle;
	}

	public String getPrjContent() {
		return prjContent;
	}

	public void setPrjContent(String prjContent) {
		this.prjContent = prjContent;
	}

	public int getPrjTarget() {
		return prjTarget;
	}

	public void setPrjTarget(int prjTarget) {
		this.prjTarget = prjTarget;
	}

	public int getPrjCurrent() {
		return prjCurrent;
	}

	public void setPrjCurrent(int prjCurrent) {
		this.prjCurrent = prjCurrent;
	}

	public Date getPrjStartDate() {
		return prjStartDate;
	}

	public void setPrjStartDate(Date prjStartDate) {
		this.prjStartDate = prjStartDate;
	}

	public Date getPrjEndDate() {
		return prjEndDate;
	}

	public void setPrjEndDate(Date prjEndDate) {
		this.prjEndDate = prjEndDate;
	}

	public int getPrjRecount() {
		return prjRecount;
	}

	public void setPrjRecount(int prjRecount) {
		this.prjRecount = prjRecount;
	}

	public int getCreNo() {
		return creNo;
	}

	public void setCreNo(int creNo) {
		this.creNo = creNo;
	}

	public int getPrjCatNo() {
		return prjCatNo;
	}

	public void setPrjCatNo(int prjCatNo) {
		this.prjCatNo = prjCatNo;
	}

	public int getAttachmentNo() {
		return attachmentNo;
	}

	public void setAttachmentNo(int attachmentNo) {
		this.attachmentNo = attachmentNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Project [prjNo=" + prjNo + ", prjTitle=" + prjTitle + ", prjContent=" + prjContent + ", prjTarget="
				+ prjTarget + ", prjCurrent=" + prjCurrent + ", prjStartDate=" + prjStartDate + ", prjEndDate="
				+ prjEndDate + ", prjRecount=" + prjRecount + ", creNo=" + creNo + ", prjCatNo=" + prjCatNo
				+ ", attachmentNo=" + attachmentNo + ", status=" + status + "]";
	}
	
	

}
