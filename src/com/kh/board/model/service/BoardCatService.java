package com.kh.board.model.service;

import java.sql.Connection;
import java.util.List;
import static com.kh.common.JDBCTemplate.*;

import com.kh.board.model.dao.BoardCatDao;
import com.kh.board.model.vo.BoardCat;

public class BoardCatService {

	public List<BoardCat> getBoardCatList() {
		Connection con = getConnection();
		List<BoardCat> cat = new BoardCatDao().getBoardCatList(con);
		return cat;
	}

}
