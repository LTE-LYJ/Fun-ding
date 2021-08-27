package com.kh.mypage.model.vo;

import java.sql.Date;

public class Board {

	private int boardNo; //게시글번호
	private String boardTitle; //게시글제목
	private String boardContent; //게시글내용
	private int count; //조회수
	private Date createDate; //작성일
	private int categoryNo; //카테고리번호
	private int boardWriter; //작성자회원번호
	private String statues; //상태값(Y/N)
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	

	public Board(int boardNo, String boardTitle, int boardWriter, Date createDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		
		this.boardWriter = boardWriter;
		this.createDate = createDate;
	}

	public Board(int boardNo, String boardTitle, String boardContent, int count, Date createDate, int categoryNo,
			int boardWriter) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.count = count;
		this.createDate = createDate;
		this.categoryNo = categoryNo;
		this.boardWriter = boardWriter;
	}

	public Board(int boardNo, String boardTitle, String boardContent, int count, Date createDate, int categoryNo,
			int boardWriter, String statues) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.count = count;
		this.createDate = createDate;
		this.categoryNo = categoryNo;
		this.boardWriter = boardWriter;
		this.statues = statues;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(int boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getStatues() {
		return statues;
	}

	public void setStatues(String statues) {
		this.statues = statues;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", count=" + count + ", createDate=" + createDate + ", categoryNo=" + categoryNo + ", boardWriter="
				+ boardWriter + ", statues=" + statues + "]";
	}

	
	
	
	
	
}
