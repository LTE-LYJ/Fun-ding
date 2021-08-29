package com.kh.board.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardReply {
	//자유게시판 댓글
	
	private int boardReplyNo; //댓글번호
	private String boardReplyContent; //댓글내용
	private int boardRefBno; //참조하는게시글번호
	private int boardReplyWriter; //작성자회원번호
	private String memName;	// 작성자
	private Date createDate; //작성일
	private String status; //상태값(Y/N)
	
	public BoardReply(String boardReplyContent, int boardRefBno, int boardReplyWriter) {
		super();
		this.boardReplyContent = boardReplyContent;
		this.boardRefBno = boardRefBno;
		this.boardReplyWriter = boardReplyWriter;
	}

	public BoardReply(int boardReplyNo, String boardReplyContent, int boardRefBno,
			int boardReplyWriter, String memName,
			Date createDate, String status) {
		super();
		this.boardReplyNo = boardReplyNo;
		this.boardReplyContent = boardReplyContent;
		this.boardRefBno = boardRefBno;
		this.memName = memName;
		this.createDate = createDate;
		this.status = status;
	}

	public BoardReply() {
		// TODO Auto-generated constructor stub
	}
	
	

}
