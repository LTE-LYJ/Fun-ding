package com.kh.board.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
	//자유게시판
	
	private int boardNo; //게시글번호
	private String boardTitle; //게시글제목
	private String boardContent; //게시글내용
	private int count; //조회수
	private Date createDate; //작성일
	private int categoryNo; //카테고리번호
	private int boardWriter; //작성자회원번호
	private String status; //상태값(Y/N)
	private String files; // 파일
	
	
	public Board(int boardNo, String boardTitle, String boardContent, int count, Date createDate, 
			int categoryNo, int boardWriter, String status, String files) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.count = count;
		this.createDate = createDate;
		this.categoryNo = categoryNo;
		this.boardWriter = boardWriter;
		this.status = status;
		this.files = files;
	}
	
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

}
