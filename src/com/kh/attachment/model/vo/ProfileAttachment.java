package com.kh.attachment.model.vo;

import java.sql.Date;

public class ProfileAttachment {
	//프로필 이미지

	private int fileNo; // 파일번호
	private String originName; // 원본파일명
	private String changeName; // 수정파일명
	private String filePath; // 저장폴더경로
	private Date uploadDate; // 업로드날짜
	private String status; // 상태값(Y/N)
	private int memNo; //회원번호
	
}
