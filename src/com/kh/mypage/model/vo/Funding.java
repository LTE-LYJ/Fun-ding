package com.kh.mypage.model.vo;

public class Funding {
	
	private int fundingNo; //후원번호
	private int memNo; //회원번호
	private int PrjNo; //프로젝트번호
	private int RewardNo; //리워드번호
	
	public Funding() {
		// TODO Auto-generated constructor stub
	}

	public Funding(int fundingNo, int memNo, int prjNo, int rewardNo) {
		super();
		this.fundingNo = fundingNo;
		this.memNo = memNo;
		PrjNo = prjNo;
		RewardNo = rewardNo;
	}

	public int getFundingNo() {
		return fundingNo;
	}

	public void setFundingNo(int fundingNo) {
		this.fundingNo = fundingNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getPrjNo() {
		return PrjNo;
	}

	public void setPrjNo(int prjNo) {
		PrjNo = prjNo;
	}

	public int getRewardNo() {
		return RewardNo;
	}

	public void setRewardNo(int rewardNo) {
		RewardNo = rewardNo;
	}

	@Override
	public String toString() {
		return "Funding [fundingNo=" + fundingNo + ", memNo=" + memNo + ", PrjNo=" + PrjNo + ", RewardNo=" + RewardNo
				+ "]";
	}

}
