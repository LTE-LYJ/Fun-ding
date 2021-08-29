package com.kh.board.model.vo;

import lombok.Data;

@Data
public class BoardCat {
	// 자유게시판 카테고리

	private int boardCatNo; // 카테고리번호
	private String boardCatName; // 카테고리명

	public BoardCat(int boardCatNo, String boardCatName) {
		super();
		this.boardCatNo = boardCatNo;
		this.boardCatName = boardCatName;
	}

	public BoardCat() {
		// TODO Auto-generated constructor stub
	}
}
