package com.kh.project.model.vo;

public class Creator {
	//창작자
	
	private int creNo; //창작자 번호
	private String creName; //창작자 이름
	private String creContent; //창작자 소개
	private String memNo; //회원번호
	private int prjNo; //프로젝트 번호
	private int prjCountNo;// 프로젝트수
	
	public Creator() {
		// TODO Auto-generated constructor stub
	}

	public Creator(int creNo, String creName, String creContent, String memNo) {
		super();
		this.creNo = creNo;
		this.creName = creName;
		this.creContent = creContent;
		this.memNo = memNo;
	}

	public Creator(int prjNo, String creName, String creContent) {
		super();
		this.prjNo = prjNo;
		this.creName = creName;
		this.creContent = creContent;
	}

	public int getCreNo() {
		return creNo;
	}

	public void setCreNo(int creNo) {
		this.creNo = creNo;
	}

	public String getCreName() {
		return creName;
	}

	public void setCreName(String creName) {
		this.creName = creName;
	}

	public String getCreContent() {
		return creContent;
	}

	public void setCreContent(String creContent) {
		this.creContent = creContent;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public int getPrjCountNo() {
		return prjCountNo;
	}

	public void setPrjCountNo(int prjCountNo) {
		this.prjCountNo = prjCountNo;
	}
	
	public int getPrjNo() {
		return prjNo;
	}

	public void setPrjNo(int prjNo) {
		this.prjNo = prjNo;
	}

	@Override
	public String toString() {
		return "Creator [creNo=" + creNo + ", creName=" + creName + ", creContent=" + creContent + ", memNo=" + memNo+ ", prjCountNo=" + prjCountNo
				+ "]";
	}
	
	

}
