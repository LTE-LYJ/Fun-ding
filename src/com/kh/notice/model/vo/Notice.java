package com.kh.notice.model.vo;
//테스트
import java.util.Date;

public class Notice {
	//공지사항
	
	private int noticeNo; //공지사항번호
	private String noticeTitle; //공지사항제목
	private String noticeContent; //공지사항내용
	private int noticeWriter; //작성자회원번호
	private int count; //조회수
	private Date createDate; //작성일
	private String status; //상태값(Y/N)

}
