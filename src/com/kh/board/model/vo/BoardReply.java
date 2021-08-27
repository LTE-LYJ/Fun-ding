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
	private Date createDate; //작성일
	private String status; //상태값(Y/N)

}
