package com.kh.mypage.model.dao;

import static com.kh.common.JDBCTemplate.close;
//import static com.kh.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.member.model.vo.Member;
import com.kh.mypage.model.vo.Board;
import com.kh.mypage.model.vo.PageInfo;
import com.kh.mypage.model.vo.Project;
import com.kh.mypage.model.vo.Project_ask;
import com.kh.mypage.model.vo.Project_report;

public class MypageDao {

	private Properties prop = new Properties();

	public MypageDao() {
		String fileName = MypageDao.class.getResource("/com/sql/mypage/mypage-query.properties").getPath();
		System.out.println("fileName   " + fileName);
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int updateMember(Connection conn, Member m) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET MEM_NAME=?, PHONE=?, EMAIL=?, ADDRESS=? WHERE MEM_ID=?";

		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, loginUser);

			pstmt.setString(1, m.getMemName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getMemId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int getMainListCount(Connection conn, int memNo) {
		return executeCountQuery(conn, prop.getProperty("countBoardList"), memNo);
	}

	public List<Board> selectMainList(Connection conn, int memNo, PageInfo pi) {
		return selectList(conn, prop.getProperty("selectBoardList"),memNo, pi, Board::fromResultSet);
	}

	public int getAskListCount(Connection conn, int memNo) {
		return executeCountQuery(conn, prop.getProperty("countAskList"), memNo);
	}

	public List<Project_ask> selectAskList(Connection conn, int memNo, PageInfo pi) {
		return selectList(conn,
				prop.getProperty("selectAskList"),
				memNo,
				pi,
				Project_ask::fromResultSet);
	}


	public int getReportListCount(Connection conn, int memNo) {
		return executeCountQuery(conn, prop.getProperty("countReportList"), memNo);
	}

	public List<Project_report> selectReportList(Connection conn, int memNo, PageInfo pi) {
		return selectList(conn,
				prop.getProperty("selectReportList"),
				memNo,
				pi,
				Project_report::fromResultSet);
	}

	public int deleteMember(Connection conn, String memId, String memPwd) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteMember");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPwd);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updatePwd(Connection conn, String memId, String memPwd, String changePwd) {
		int result = 0;

		try (PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updatePwd"))) {
			pstmt.setString(1, changePwd);
			pstmt.setString(2, memId);
			pstmt.setString(3, memPwd);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int getProjectListCount(Connection conn, int memNo) {
		try (PreparedStatement stmt = conn.prepareStatement(prop.getProperty("getProjectListCount"))) {
			stmt.setInt(1, memNo);

			ResultSet resultSet = stmt.executeQuery();
			if (!resultSet.next()) return 0;

			return resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public ArrayList<Project> selectPrjList(Connection conn, Member m) {
			ArrayList<Project> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = "SELECT PRJ_NO, PRJ_TITLE, PRJ_TARGET, PRJ_CURRENT "
					+ "FROM PROJECT "
					+ "WHERE STATUS='Y' AND MEM_NO=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, m.getMemNo());
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Project p = new Project();
					p.setPrjNo(rset.getInt("PRJ_NO"));
					p.setPrjTitle(rset.getString("PRJ_TITLE"));
					p.setPrjTarget(rset.getInt("PRJ_TARGET"));
					p.setPrjCurrent(rset.getInt("PRJ_CURRENT"));
					
					list.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			System.out.println(list);	
			return list;
		}
	
		public ArrayList<Project> selectPrjListClose(Connection conn, Member m) {
			
			ArrayList<Project> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
				
			String sql = "SELECT PRJ_NO, PRJ_TITLE, PRJ_TARGET, PRJ_CURRENT "
					+ "FROM PROJECT "
					+ "WHERE STATUS='N' AND MEM_NO=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, m.getMemNo());
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Project p = new Project();
					p.setPrjNo(rset.getInt("PRJ_NO"));
					p.setPrjTitle(rset.getString("PRJ_TITLE"));
					p.setPrjTarget(rset.getInt("PRJ_TARGET"));
					p.setPrjCurrent(rset.getInt("PRJ_CURRENT"));
					
					list.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			System.out.println(list);
			
			return list;
		}

		
	public ArrayList<Project> selectFundingList(Connection conn, int memNo, PageInfo pageInfo) {
		
		try (PreparedStatement stmt = conn.prepareStatement(prop.getProperty("selectFundingList"))) {
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;

			stmt.setInt(1, memNo);
			stmt.setInt(2, startRow);
			stmt.setInt(3, endRow);

			ResultSet rset = stmt.executeQuery();

			ArrayList<Project> projects = new ArrayList<>(rset.getFetchSize());
			while (rset.next()) {
				projects.add(Project.fromResultSet(rset));
			}
			return projects;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateMember(Connection conn, Member m, ProfileAttachment at) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "UPDATE MEMBER SET MEM_NAME=?, PHONE=?, EMAIL=?, ADDRESS=? WHERE MEM_ID=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getMemName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getMemId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	private int executeCountQuery(Connection conn, String sql, int memNo) {
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, memNo);

			ResultSet resultSet = stmt.executeQuery();
			int result = 0;
			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}
			close(resultSet);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private <T> List<T> selectList(Connection conn,
								   String sql,
								   int memNo,
								   PageInfo pageInfo,
								   FunctionWithException<ResultSet, T, SQLException> converter) {
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, memNo);
			stmt.setInt(2, pageInfo.getOffset());
			stmt.setInt(3, pageInfo.getOffset() + pageInfo.getBoardLimit());

			ResultSet resultSet = stmt.executeQuery();
			ArrayList<T> result = new ArrayList<>(resultSet.getFetchSize());
			while (resultSet.next()) {
				result.add(converter.apply(resultSet));
			}
			close(resultSet);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@FunctionalInterface
	private static interface FunctionWithException<T, R, E extends Exception> {
		R apply(T t) throws E;
	}
	
	
	
	
	
	
	
	

	
}
