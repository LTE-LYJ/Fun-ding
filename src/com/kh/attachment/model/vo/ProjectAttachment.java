package com.kh.attachment.model.vo;

import java.sql.Date;

public class ProjectAttachment {
	//프로젝트 이미지
	
	private int fileNo; // 파일번호
	private String originName; // 원본파일명
	private String changeName; // 수정파일명
	private String filePath; // 저장폴더경로
	private Date uploadDate; // 업로드날짜
	private int fileLevel; // 파일레벨(1대표이미지/2내용이미지)
	private String status; // 상태값(Y/N)
	private int prjNo; //프로젝트번호
	
	public ProjectAttachment() {
		// TODO Auto-generated constructor stub
	}

	public ProjectAttachment(int fileNo, String originName, String changeName, String filePath, Date uploadDate,
			int fileLevel, String status, int prjNo) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.fileLevel = fileLevel;
		this.status = status;
		this.prjNo = prjNo;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
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

	@Override
	public String toString() {
		return "ProjectAttachment [fileNo=" + fileNo + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", fileLevel=" + fileLevel + ", status="
				+ status + ", prjNo=" + prjNo + "]";
	}
	
	

}
