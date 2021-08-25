package com.kh.project_detail.model.vo;

import lombok.Data;
@Data
public class Review {
	//후기작성
	private int reviewNo; //후기번호
	private String reviewContent; //후기내용
	private String status; //상태값(Y/N)
	private int prjNo; //프로젝트 번호
	private String memId; //회원번호
	private int fileNo; // 파일번호
	private String originName; // 원본파일명
	private String changeName; // 수정파일명
}
