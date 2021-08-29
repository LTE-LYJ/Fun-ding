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
	private String category; //카테고리번호
	private String boardWriter; //작성자회원번호
	private String status; //상태값(Y/N)
	private String files; // 파일
	private int boardWriterNo;
	
	
	public Board(int boardNo, String boardTitle, String boardContent, int count, Date createDate, 
			String category, String boardWriter, String status, String files) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.count = count;
		this.createDate = createDate;
		this.category = category;
		this.boardWriter = boardWriter;
		this.status = status;
		this.files = files;
	}
	
	
	public Board() {
		// TODO Auto-generated constructor stub
	}


	public Board(String boardTitle, String boardContent, String category, String boardWriter, String files) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.category = category;
		this.boardWriter = boardWriter;
		this.files = files;
	}


	public Board(int boardNo, String boardTitle, String boardContent, int count, Date createDate, String category,
			String boardWriter, String files) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.count = count;
		this.createDate = createDate;
		this.category = category;
		this.boardWriter = boardWriter;
		this.files = files;
	}


	public Board(int boardNo, String boardTitle) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
	}


	public Board(int boardNo, String boardTitle, int count, Date createDate, String category, String boardWriter,
			String status) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.count = count;
		this.createDate = createDate;
		this.category = category;
		this.boardWriter = boardWriter;
		this.status = status;
	}


	public Board(int boardNo, String boardTitle, String boardContent, int count, Date createDate, 
			String boardWriter, String status, String files, int boardWriterNo) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.count = count;
		this.createDate = createDate;
		this.boardWriter = boardWriter;
		this.status = status;
		this.files = files;
		this.boardWriterNo = boardWriterNo;
	}


	public Board(int boardNo, String boardTitle, String boardContent, int count, Date createDate, String category,
			String boardWriter, String status, String files, int boardWriterNo) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.count = count;
		this.createDate = createDate;
		this.category = category;
		this.boardWriter = boardWriter;
		this.status = status;
		this.files = files;
		this.boardWriterNo = boardWriterNo;
	}




	

	
	
	
}
