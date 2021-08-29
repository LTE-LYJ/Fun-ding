package com.kh.project.model.vo;

public class Reward {
	//리워드
	
	private int rwNo; //리워드 번호
	private String rwName; //리워드 이름
	private String reContent; //리워드 설명
	private int rwPrice; //금액 설정
	private int prjNo; //프로젝트 번호
	
	public Reward() {
		// TODO Auto-generated constructor stub
	}

	public Reward(int rwNo, String rwName, String reContent, int rwPrice, int prjNo) {
		super();
		this.rwNo = rwNo;
		this.rwName = rwName;
		this.reContent = reContent;
		this.rwPrice = rwPrice;
		this.prjNo = prjNo;
	}

	public Reward(int prjNo, String rwName, String reContent, int rwPrice) {
		super();
		this.rwName = rwName;
		this.reContent = reContent;
		this.rwPrice = rwPrice;
		this.prjNo = prjNo;
	}

	public int getRwNo() {
		return rwNo;
	}

	public void setRwNo(int rwNo) {
		this.rwNo = rwNo;
	}

	public String getRwName() {
		return rwName;
	}

	public void setRwName(String rwName) {
		this.rwName = rwName;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public int getRwPrice() {
		return rwPrice;
	}

	public void setRwPrice(int rwPrice) {
		this.rwPrice = rwPrice;
	}

	public int getPrjNo() {
		return prjNo;
	}

	public void setPrjNo(int prjNo) {
		this.prjNo = prjNo;
	}

	@Override
	public String toString() {
		return "Reward [rwNo=" + rwNo + ", rwName=" + rwName + ", reContent=" + reContent + ", rwPrice=" + rwPrice
				+ ", prjNo=" + prjNo + "]";
	}
	
	

}
