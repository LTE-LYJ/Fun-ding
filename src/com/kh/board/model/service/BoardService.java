package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class BoardService {

	public List<Board> getBoardList() {

		return getBoardList("BOARD_TITLE", "", 1);
	}

	public List<Board> getBoardList(int page) {

		return getBoardList("BOARD_TITLE", "", page);
	}

	public List<Board> getBoardList(String field, String query, int page) {
		Connection con = getConnection();

		List<Board> list = new BoardDao().getBoardList(con, field, query, page);

		return list;
	}

	
	public int getBoardCount() {

		return getNoticeCount("BOARD_TITLE", "");
	}

	
	
	public int getNoticeCount(String field, String query) {
		Connection con = getConnection();

		int count = new NoticeDao().getNoticeCount(con, field, query);

		return count;
	}

	public Notice getNotice(int noticeNo) {
		Connection con = getConnection();

		Notice notice = new NoticeDao().getNotice(con, noticeNo);

		return notice;
	}

	public Notice getNextNotice(int id) {
		Connection con = getConnection();

		Notice notice = new NoticeDao().getNextNotice(con, id);

		return notice;
	}

	public Notice getPrevNotice(int id) {
		Connection con = getConnection();
		Notice notice = new NoticeDao().getPrevNotice(con, id);

		return notice;
	}

	public int insertNotice(Notice n) {
		Connection con = getConnection();
		int result = new NoticeDao().insertNotice(con, n);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int deleteNotice(int noticeNo) {
		Connection con = getConnection();
		int result = new NoticeDao().deleteNotice(con, noticeNo);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public Notice selectUpdateNotice(int noticeNo) {
		Connection con = getConnection();
		Notice n = new NoticeDao().selectNotice(con, noticeNo);

		return n;
	}

	public int updateNotice(Notice n) {
		Connection con = getConnection();
		int result = new NoticeDao().UpdateNotice(con, n);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int uodateCount(int noticeNo) {
		Connection con = getConnection();
		int result = new NoticeDao().uodateCount(con, noticeNo);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
