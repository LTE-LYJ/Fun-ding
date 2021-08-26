package com.kh.project.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.attachment.model.vo.ProjectAttachment;
import com.kh.project.model.vo.Creator;
import com.kh.project.model.vo.PageInfo;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.Reward;

public class ProjectDao {
	
	private Properties prop = new Properties();
	
	public ProjectDao() {
		String fileName = ProjectDao.class.getResource("/com/sql/project/project-query.properties").getPath();
		System.out.println("fileName : " + fileName);
		
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
	
	//getListCount
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	public int getPopularListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getPopularListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public int getNewListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getNewListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public int getCloseListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getCloseListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}


	//selectList
	public ArrayList<Project> selectList(Connection conn, PageInfo pi) {
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new Project(rset.getInt("PRJ_NO"),
									 rset.getString("PRJ_TITLE"),
									 rset.getString("CRE_NAME"),
									 rset.getString("PRJ_CAT_NAME"),
									 rset.getDouble("PRJ_TARGET"),
									 rset.getDouble("PRJ_CURRENT"),
									 rset.getString("PRJ_STARTDATE"),
									 rset.getString("PRJ_ENDDATE")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(list);
		
		return list;
	}

	public ArrayList<Project> selectPopularList(Connection conn, PageInfo pi) {
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPopularList");
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new Project(rset.getInt("PRJ_NO"),
									 rset.getString("PRJ_TITLE"),
									 rset.getString("CRE_NAME"),
									 rset.getString("PRJ_CAT_NAME"),
									 rset.getDouble("PRJ_TARGET"),
									 rset.getDouble("PRJ_CURRENT"),
									 rset.getString("PRJ_STARTDATE"),
									 rset.getString("PRJ_ENDDATE")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(list);
		
		return list;
	}

	public ArrayList<Project> selectNewList(Connection conn, PageInfo pi) {
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNewList");
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new Project(rset.getInt("PRJ_NO"),
									 rset.getString("PRJ_TITLE"),
									 rset.getString("CRE_NAME"),
									 rset.getString("PRJ_CAT_NAME"),
									 rset.getDouble("PRJ_TARGET"),
									 rset.getDouble("PRJ_CURRENT"),
									 rset.getString("PRJ_STARTDATE"),
									 rset.getString("PRJ_ENDDATE")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(list);
		
		return list;
	}

	public ArrayList<Project> selectCloseList(Connection conn, PageInfo pi) {
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCloseList");
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new Project(rset.getInt("PRJ_NO"),
									 rset.getString("PRJ_TITLE"),
									 rset.getString("CRE_NAME"),
									 rset.getString("PRJ_CAT_NAME"),
									 rset.getDouble("PRJ_TARGET"),
									 rset.getDouble("PRJ_CURRENT"),
									 rset.getString("PRJ_STARTDATE"),
									 rset.getString("PRJ_ENDDATE")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(list);
		
		return list;
	}

	
	//메인 페이지 select
	public ArrayList<Project> selectAllList(Connection conn) {
		System.out.println("mainPage selectAllList");
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		int startRow = 1;
		int endRow = 4;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new Project(rset.getInt("PRJ_NO"),
									 rset.getString("PRJ_TITLE"),
									 rset.getString("CRE_NAME"),
									 rset.getString("PRJ_CAT_NAME"),
									 rset.getDouble("PRJ_TARGET"),
									 rset.getDouble("PRJ_CURRENT"),
									 rset.getString("PRJ_STARTDATE"),
									 rset.getString("PRJ_ENDDATE")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(list);
		
		return list;
	}

	public ArrayList<Project> selectPopularList(Connection conn) {
		System.out.println("mainPage selectPopularList");
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPopularList");
		int startRow = 1;
		int endRow = 4;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new Project(rset.getInt("PRJ_NO"),
									 rset.getString("PRJ_TITLE"),
									 rset.getString("CRE_NAME"),
									 rset.getString("PRJ_CAT_NAME"),
									 rset.getDouble("PRJ_TARGET"),
									 rset.getDouble("PRJ_CURRENT"),
									 rset.getString("PRJ_STARTDATE"),
									 rset.getString("PRJ_ENDDATE")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(list);
		
		return list;
	}

	public ArrayList<Project> selectNewList(Connection conn) {
		System.out.println("mainPage selectNewList");
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNewList");
		int startRow = 1;
		int endRow = 4;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new Project(rset.getInt("PRJ_NO"),
									 rset.getString("PRJ_TITLE"),
									 rset.getString("CRE_NAME"),
									 rset.getString("PRJ_CAT_NAME"),
									 rset.getDouble("PRJ_TARGET"),
									 rset.getDouble("PRJ_CURRENT"),
									 rset.getString("PRJ_STARTDATE"),
									 rset.getString("PRJ_ENDDATE")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(list);
		
		return list;
	}

	public ArrayList<Project> selectCloseList(Connection conn) {
		System.out.println("mainPage selectCloseList");
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCloseList");
		int startRow = 1;
		int endRow = 4;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new Project(rset.getInt("PRJ_NO"),
									 rset.getString("PRJ_TITLE"),
									 rset.getString("CRE_NAME"),
									 rset.getString("PRJ_CAT_NAME"),
									 rset.getDouble("PRJ_TARGET"),
									 rset.getDouble("PRJ_CURRENT"),
									 rset.getString("PRJ_STARTDATE"),
									 rset.getString("PRJ_ENDDATE")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(list);
		
		return list;
	}

	
	//insert
	public int insertProject(Connection conn, Project p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertProject");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getPrjTitle());
			pstmt.setString(2, p.getPrjContent());
			pstmt.setDouble(3, p.getPrjTarget());
			pstmt.setString(4, p.getPrjStartDate());
			pstmt.setString(5, p.getPrjEndDate());
			pstmt.setInt(6, Integer.parseInt(p.getCreName()));
			pstmt.setInt(7, Integer.parseInt(p.getPrjCatName()));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertAttachment(Connection conn, ProjectAttachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachment");		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReward(Connection conn, Reward[] rList) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReward");
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i=0; i<rList.length; i++) {
				pstmt.setString(1, rList[i].getRwName());
				pstmt.setString(2, rList[i].getReContent());
				pstmt.setInt(3, rList[i].getRwPrice());
				
				result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertCreator(Connection conn, Creator c) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertCreator");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCreName());
			pstmt.setString(2, c.getCreContent());
			pstmt.setInt(3, Integer.parseInt(c.getMemNo()));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
