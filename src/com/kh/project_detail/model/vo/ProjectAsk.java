package com.kh.project_detail.model.vo;

import java.util.Date;

import lombok.Data;
@Data
public class ProjectAsk {
	//문의작성
	
	private int prjAskNo; //문의번호
	private int prjAskNownum; //rownum번호
	private String prjAskTitle; //문의제목
	private String prjAskContent; //문의내용
	private int count; //조회수
	private Date enrollDate; //작성일
	private String status; //상태값(Y/N)
	private int prjNo; //프로젝트 번호
	private String memId; //회원 아이디
	
	
}
