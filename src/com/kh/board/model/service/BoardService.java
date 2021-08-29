package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.BoardReply;
import com.kh.board.model.vo.BoardView;

public class BoardService {

	public List<BoardView> getBoardList() {

		return getBoardList("BOARD_TITLE", "", 1,"");
	}

	public List<BoardView> getBoardList(int page) {

		return getBoardList("BOARD_TITLE", "", page,"");
	}

	public List<BoardView> getBoardList(String field, String query, int page, String cate) {
		Connection con = getConnection();

		List<BoardView> list = new BoardDao().getBoardList(con, field, query, page, cate);

		return list;
	}

	
	public int getBoardCount() {

		return getBoardCount("BOARD_TITLE", "");
	}

	
	
	public int getBoardCount(String field, String query) {
		Connection con = getConnection();

		int count = new BoardDao().getBoardCount(con, field, query);

		return count;
	}

	public Board getBoard(int boardNo) {
		Connection con = getConnection();

		Board board = new BoardDao().getBoard(con, boardNo);

		return board;
	}

	public Board getNextBoard(int id) {
		Connection con = getConnection();

		Board board = new BoardDao().getNextBoard(con, id);

		return board;
	}

	public Board getPrevBoard(int id) {
		Connection con = getConnection();
		Board board = new BoardDao().getPrevBoard(con, id);

		return board;
	}

	public int insertBoard(Board n) {
		Connection con = getConnection();
		int result = new BoardDao().insertBoard(con, n);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int deleteBoard(int boardNo) {
		Connection con = getConnection();
		int result = new BoardDao().deleteBoard(con, boardNo);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public Board selectUpdateBoard(int boardNo) {
		Connection con = getConnection();
		Board b = new BoardDao().selectBoard(con, boardNo);

		return b;
	}

	public int updateBoard(Board b) {
		Connection con = getConnection();
		int result = new BoardDao().UpdateBoard(con, b);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int updateCount(int boardNo) {
		Connection con = getConnection();
		int result = new BoardDao().updateCount(con, boardNo);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int insertReply(BoardReply reply) {
		Connection con = getConnection();
		int result = new BoardDao().insertBoard(con, reply);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public List<BoardReply> getReplyList(int boardNo) {
		Connection con = getConnection();

		List<BoardReply> list = new BoardDao().getReplyList(con, boardNo);

		return list;
	}

	public int replyDelete(int boardReplyNo) {
		Connection con = getConnection();
		int result = new BoardDao().replyDelete(con, boardReplyNo);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}


	

}
