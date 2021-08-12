package com.kh.attachment.model.vo;

import java.sql.Date;

public class BoardAttachment {
	//게시판 첨부파일
	
	private int fileNo; // 파일번호
	private int refBNo; // 참조게시글번호
	private String originName; // 원본파일명
	private String changeName; // 수정파일명
	private String filePath; // 저장폴더경로
	private Date uploadDate; // 업로드날짜
	private int fileLevel; // 파일레벨(1공지/2문의/3신고/4자유)
	private String status; // 상태값(Y/N)

}
