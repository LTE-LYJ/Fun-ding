package com.kh.project.model.vo;

public class Project {
	//프로젝트
	
	private int prjNo; //프로젝트 번호
	private String prjTitle; //프로젝트 제목
	private String prjContent; //프로젝트 소개
	private double prjTarget; //목표 금액
	private double prjCurrent; //현재 후원 금액
	private String prjStartDate; //펀딩 시작일
	private String prjEndDate; //펀딩 종료일
	private int prjRecount; //재펀딩 요청 회수
	private int creNo; //회원 번호
	private int prjCatNo; //프로젝트 카테고리 번호
	private String creName; //창작자 이름
	private String prjCatName; //프로젝트 카테고리 이름
	private int attachmentNo; //첨부 이미지 번호
	private String attachmentName; //첨부 이미지 이름
	private String status; //상태값(Y/N)
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int prjNo, String prjTitle, String prjContent, double prjTarget, double prjCurrent, String prjStartDate,
			String prjEndDate, int prjRecount, String creName, String prjCatName, int attachmentNo, String status) {
		super();
		this.prjNo = prjNo;
		this.prjTitle = prjTitle;
		this.prjContent = prjContent;
		this.prjTarget = prjTarget;
		this.prjCurrent = prjCurrent;
		this.prjStartDate = prjStartDate;
		this.prjEndDate = prjEndDate;
		this.prjRecount = prjRecount;
		this.creName = creName;
		this.prjCatName = prjCatName;
		this.attachmentNo = attachmentNo;
		this.status = status;
	}

	public Project(int prjNo, String prjTitle, String creName, String prjCatName, double prjTarget, double prjCurrent, String prjStartDate, String prjEndDate) {
		super();
		this.prjNo = prjNo;
		this.prjTitle = prjTitle;
		this.prjTarget = prjTarget;
		this.prjCurrent = prjCurrent;
		this.prjStartDate = prjStartDate;
		this.prjEndDate = prjEndDate;
		this.creName = creName;
		this.prjCatName = prjCatName;
	}

	public Project(int prjNo, double prjTarget, String prjStartDate, String prjEndDate) {
		super();
		this.prjNo = prjNo;
		this.prjTarget = prjTarget;
		this.prjStartDate = prjStartDate;
		this.prjEndDate = prjEndDate;
	}

	public Project(int prjNo, String prjTitle, String prjContent, String prjCatName) {
		super();
		this.prjNo = prjNo;
		this.prjTitle = prjTitle;
		this.prjContent = prjContent;
		this.prjCatName = prjCatName;
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

	public double getPrjTarget() {
		return prjTarget;
	}

	public void setPrjTarget(double prjTarget) {
		this.prjTarget = prjTarget;
	}

	public double getPrjCurrent() {
		return prjCurrent;
	}

	public void setPrjCurrent(double prjCurrent) {
		this.prjCurrent = prjCurrent;
	}

	public String getPrjStartDate() {
		return prjStartDate;
	}

	public void setPrjStartDate(String prjStartDate) {
		this.prjStartDate = prjStartDate;
	}

	public String getPrjEndDate() {
		return prjEndDate;
	}

	public void setPrjEndDate(String prjEndDate) {
		this.prjEndDate = prjEndDate;
	}

	public int getPrjRecount() {
		return prjRecount;
	}

	public void setPrjRecount(int prjRecount) {
		this.prjRecount = prjRecount;
	}

	public String getCreName() {
		return creName;
	}

	public void setCreName(String creName) {
		this.creName = creName;
	}

	public String getPrjCatName() {
		return prjCatName;
	}

	public void setPrjCatName(String prjCatName) {
		this.prjCatName = prjCatName;
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

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	@Override
	public String toString() {
		return "Project [prjNo=" + prjNo + ", prjTitle=" + prjTitle + ", prjContent=" + prjContent + ", prjTarget="
				+ prjTarget + ", prjCurrent=" + prjCurrent + ", prjStartDate=" + prjStartDate + ", prjEndDate="
				+ prjEndDate + ", prjRecount=" + prjRecount + ", creName=" + creName + ", prjCatName=" + prjCatName
				+ ", attachmentNo=" + attachmentNo + ", status=" + status +", creNo=" + creNo+", prjCatNo=" + prjCatNo+"]";
	}

}
