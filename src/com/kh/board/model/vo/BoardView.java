package com.kh.board.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardView extends Board {
	private int repCount;

	public BoardView(int boardNo, String boardTitle,  int count, Date createDate, String category,
			String boardWriter, String status,  int replyCount) {
		super(boardNo, boardTitle, count, createDate, category, boardWriter, status);
		this.repCount = replyCount;
	}
	
	public BoardView() {
		// TODO Auto-generated constructor stub
	}

	
}
