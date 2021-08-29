package com.kh.board.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.board.model.vo.BoardCat;

public class BoardCatDao {

	public List<BoardCat> getBoardCatList(Connection con) {
		List<BoardCat> catList = new ArrayList<>();
		String sql = "SELECT * FROM BOARD_CAT";
		
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int boardCatNo = rs.getInt("BOARD_CAT_NO");
				String boardCatName = rs.getString("BOARD_CAT_NAME");
				
				BoardCat cat = new BoardCat(boardCatNo, boardCatName);
				
				catList.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		
		
		return catList;
	}

}
