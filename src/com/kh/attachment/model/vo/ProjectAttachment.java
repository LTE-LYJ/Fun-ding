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

}
