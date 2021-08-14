package com.kh.board.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
	
	private int boardNo; //게시글번호
	private String boardTitle; //게시글제목
	private String boardContent; //게시글내용
	private int count; //조회수
	private Date createDate; //작성일
	private int boardType; //게시글타입(일반1/사진2)
	private int categoryNo; //카테고리번호
	private int boardWriter; //작성자회원번호
	private String status; //상태값(Y/N)

}
