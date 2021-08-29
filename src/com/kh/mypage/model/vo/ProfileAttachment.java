package com.kh.mypage.model.vo;

import java.sql.Date;

public class ProfileAttachment {
	
	private int fileNo; // 파일번호
	private String originName; // 원본파일명
	private String changeName; // 수정파일명
	private String filePath; // 저장폴더경로
	private Date uploadDate; // 업로드날짜
	private String status; // 상태값(Y/N)
	private int memNo; //회원번호
	
	public ProfileAttachment() {
		// TODO Auto-generated constructor stub
	}

	public ProfileAttachment(int fileNo, String originName, String changeName, String filePath, Date uploadDate,
			String status, int memNo) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.status = status;
		this.memNo = memNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	@Override
	public String toString() {
		return "ProfileAttachment [fileNo=" + fileNo + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", status=" + status + ", memNo=" + memNo
				+ "]";
	}
	
	

}
