package com.kh.board.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.BoardReply;
import com.kh.board.model.vo.BoardView;

public class BoardDao {

	public List<BoardView> getBoardList(Connection con, String field, String query, int page, String cate) {
		List<BoardView> list = new ArrayList<>();

		String sql = "SELECT * FROM ( "
				+ "    SELECT ROWNUM NUM, B.* "
				+ "    FROM (SELECT * FROM BOARD_VIEW "
				+ "    WHERE " + field + " LIKE ? "
				+ "	   AND BOARD_CAT_NO LIKE ? "
				+ "    ORDER BY CREATE_DATE DESC) B "
				+ "    ) "
				+ "WHERE NUM BETWEEN ? AND ? ";

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setString(2, "%" + cate + "%");
			st.setInt(3, 1 + (page - 1) * 10);
			st.setInt(4, page * 10);
			rs = st.executeQuery();

			while (rs.next()) {
				int bBoardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				int count = rs.getInt("COUNT");
				Date createDate = rs.getDate("CREATE_DATE");
				String category = rs.getString("BOARD_CAT_NAME");
				String boardWriter = rs.getString("MEM_NAME");
				String status = rs.getString("STATUS");
				int repCount = rs.getInt("REP_COUNT");
				BoardView board = new BoardView(
						bBoardNo,
						boardTitle,
						count,
						createDate,
						category,
						boardWriter,
						status,
						repCount);

				list.add(board);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		return list;
	}

	public int getBoardCount(Connection con, String field, String query) {
		int count = 0;
		String sql = "SELECT COUNT(BOARD_NO) COUNT FROM (" + "SELECT ROWNUM NUM, N.* " + " FROM (SELECT * FROM BOARD A "
				+ "	 INNER JOIN MEMBER B ON MEM_NO = BOARD_WRITER" + " WHERE " + field + " LIKE  ? "
				+ " AND A.STATUS = 'Y' " + "ORDER BY CREATE_DATE DESC) N " + ") ";
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");

			rs = st.executeQuery();
			if (rs.next())
				count = rs.getInt("COUNT");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}

		return count;
	}

	public Board getBoard(Connection con, int boardNo) {
		Board board = null;
		
		String sql = "SELECT * FROM BOARD "
				+ "	INNER JOIN MEMBER  ON MEM_NO = BOARD_WRITER"
				+ " INNER JOIN BOARD_CAT ON BOARD_CAT_NO = CATEGORY_NO"
				+ " WHERE BOARD_NO=?";
		PreparedStatement st =null;
		ResultSet rs = null;
		try {
			
			st = con.prepareStatement(sql);
			st.setInt(1, boardNo);
		
			rs = st.executeQuery();
			
			
			if (rs.next()) {
				int bBoardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				int count = rs.getInt("COUNT");
				Date createDate = rs.getDate("CREATE_DATE");
				String category = rs.getString("BOARD_CAT_NAME");
				String boardWriter = rs.getString("MEM_NAME");
				String status = rs.getString("STATUS");
				String files = rs.getString("FILES");
				int boardWriterNo = rs.getInt("BOARD_WRITER");
				
				board = new Board(
						bBoardNo,
						boardTitle,
						boardContent,
						count,
						createDate,
						category,
						boardWriter,
						status,
						files,
						boardWriterNo
						);
					
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		
		return board;
	}

	public Board getNextBoard(Connection con, int id) {
		Board board = null;

		String sql = "SELECT BOARD_NO, BOARD_TITLE FROM BOARD "
				+ "				WHERE BOARD_NO = ( "
				+ "				SELECT BOARD_NO FROM BOARD "
				+ "				WHERE CREATE_DATE > (SELECT CREATE_DATE FROM BOARD WHERE BOARD_NO=?) "
				+ "				AND STATUS = 'Y' "
				+ "				AND ROWNUM =1)";

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = con.prepareStatement(sql);
			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {
				int bBoardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				
				
				board = new Board(
						bBoardNo,
						boardTitle
						);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		return board;
	}

	public Board getPrevBoard(Connection con, int id) {
		Board board = null;

		String sql = "SELECT BOARD_NO, BOARD_TITLE FROM (SELECT * FROM BOARD "
				+ "				ORDER BY CREATE_DATE DESC) "
				+ "				WHERE CREATE_DATE < (SELECT CREATE_DATE FROM BOARD WHERE BOARD_NO=? ) "
				+ "				AND STATUS = 'Y' "
				+ "				AND ROWNUM = 1";

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = con.prepareStatement(sql);
			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {
				int bBoardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				
				
				board = new Board(
						bBoardNo,
						boardTitle
						);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		return board;
	}

	public int insertBoard(Connection con, Board b) {
		int result = 0;
		String sql = "INSERT INTO BOARD" + " VALUES(BOARD_NO_SEQ.NEXTVAL, ?, ?, DEFAULT, DEFAULT, ?, ?, DEFAULT, ?)";
		PreparedStatement st = null;

		try {
			st = con.prepareStatement(sql);
			st.setString(1, b.getBoardTitle());
			st.setString(2, b.getBoardContent());
			st.setInt(3, Integer.parseInt(b.getCategory()));
			st.setInt(4, Integer.parseInt(b.getBoardWriter()));
			st.setString(5, b.getFiles());

			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}

		return result;
	}

	public int deleteBoard(Connection con, int boardNo) {
		int result = 0;
		String sql = "UPDATE BOARD SET STATUS='N' WHERE BOARD_NO=?";
		PreparedStatement st = null;

		try {
			st = con.prepareStatement(sql);
			st.setInt(1, boardNo);

			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}

		return result;
	}

	public Board selectBoard(Connection con, int boardNo) {
		Board b = null;
		String sql = "SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT, COUNT, CREATE_DATE, BOARD_CAT_NAME , MEM_NAME,FILES, BOARD_WRITER  "
				+ "					FROM BOARD "
				+ "                 INNER JOIN MEMBER ON MEM_NO = BOARD_WRITER"
				+ "                 INNER JOIN BOARD_CAT  ON BOARD_CAT_NO = CATEGORY_NO"
				+ "                 WHERE BOARD_NO=? ";

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = con.prepareStatement(sql);

			st.setInt(1, boardNo);
			rs = st.executeQuery();
			if (rs.next()) {
				b = new Board(rs.getInt("BOARD_NO"),
						rs.getString("BOARD_TITLE"),
						rs.getString("BOARD_CONTENT"),
						rs.getInt("COUNT"),
						rs.getDate("CREATE_DATE"),
						rs.getString("BOARD_CAT_NAME"),
						rs.getString("MEM_NAME"),
						rs.getString("FILES"),
						rs.getInt("BOARD_WRITER"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
		}
		
		return b;
	}

	public int UpdateBoard(Connection con, Board b) {

		int result = 0;
		PreparedStatement st = null;

		String sql = "UPDATE BOARD SET BOARD_TITLE=?, BOARD_CONTENT=?, CATEGORY_NO=?, FILES=? WHERE BOARD_NO=?";

		try {
			st = con.prepareStatement(sql);
			st.setString(1, b.getBoardTitle());
			st.setString(2, b.getBoardContent());
			st.setInt(3, Integer.parseInt(b.getCategory()));
			st.setString(4, b.getFiles());
			st.setInt(5, b.getBoardNo());

			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}
		return result;
	}

	public int updateCount(Connection con, int boardNo) {
		int result = 0;
		PreparedStatement st = null;

		String sql = "UPDATE BOARD SET COUNT = COUNT+1 WHERE BOARD_NO=?";

		try {
			st = con.prepareStatement(sql);
			st.setInt(1, boardNo);

			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}
		return result;
	}

	public int insertBoard(Connection con, BoardReply reply) {
		int result = 0;
		String sql = "INSERT INTO BOARD_REPLY "
				+ "VALUES(BOARD_REPLY_SEQ.NEXTVAL, ?, ?, ?, DEFAULT, DEFAULT)";
		PreparedStatement st = null;

		try {
			st = con.prepareStatement(sql);
			st.setString(1, reply.getBoardReplyContent());
			st.setInt(2, reply.getBoardRefBno());
			st.setInt(3, reply.getBoardReplyWriter());

			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}

		return result;
	}

	public List<BoardReply> getReplyList(Connection con, int boardNo) {
		List<BoardReply> list = new ArrayList<>();

		String sql = "SELECT MEM_NAME, A.* "
				+ "FROM BOARD_REPLY A "
				+ "LEFT JOIN MEMBER ON MEM_NO = BOARD_REPLY_WRITER "
				+ "WHERE BOARD_REF_BNO = ? "
				+ "AND A.STATUS = 'Y' ";

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = con.prepareStatement(sql);
			st.setInt(1, boardNo);
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				int boardReplyNo = rs.getInt("BOARD_REPLY_NO");
				String boardReplyContent = rs.getString("BOARD_REPLY_CONTENT");
				int boardRefBno = rs.getInt("BOARD_REF_BNO");
				int boardReplyWriter = rs.getInt("BOARD_REPLY_WRITER");
				String memName = rs.getString("MEM_NAME");
				Date createDate = rs.getDate("CREATE_DATE");
				String status = rs.getString("STATUS");
				
				
				BoardReply reply = new BoardReply(
						boardReplyNo,
						boardReplyContent,
						boardRefBno,
						boardReplyWriter,
						memName,
						createDate,
						status
							);
						

				list.add(reply);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		return list;
	}

	public int replyDelete(Connection con, int boardReplyNo) {
		int result = 0;
		String sql = "DELETE BOARD_REPLY  WHERE BOARD_REPLY_NO=?";
		PreparedStatement st = null;

		try {
			st = con.prepareStatement(sql);
			st.setInt(1, boardReplyNo);

			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
		}

		return result;
	}

	

	

}
