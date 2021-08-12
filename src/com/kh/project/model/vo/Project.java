package com.kh.project.model.vo;

import java.util.Date;

public class Project {
	//프로젝트
	
	private int prjNo; //프로젝트 번호
	private String prjTitle; //프로젝트 제목
	private String prjContent; //프로젝트 소개
	private int prjTarget; //목표 금액
	private int prjCurrent; //현재 후원 금액
	private Date prjStartDate; //펀딩 시작일
	private Date prjEndDate; //펀딩 종료일
	private int prjRecount; //재펀딩 요청 회수
	private int creNo; //창작자 번호
	private int prjCatNo; //프로젝트 카테고리 번호
	private int attachmentNo; //첨부 이미지 번호
	private String status; //상태값(Y/N)

}
