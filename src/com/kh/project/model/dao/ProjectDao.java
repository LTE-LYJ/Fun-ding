package com.kh.project.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
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
				Project p = new Project();
				p.setPrjNo(rset.getInt("PRJ_NO"));
				p.setPrjTitle(rset.getString("PRJ_TITLE"));
				p.setCreName(rset.getString("CRE_NAME"));
				p.setPrjCatName(rset.getString("PRJ_CAT_NAME"));
				p.setPrjTarget(rset.getDouble("PRJ_TARGET"));
				p.setPrjCurrent(rset.getDouble("PRJ_CURRENT"));
				p.setPrjStartDate(rset.getString("PRJ_STARTDATE"));
				p.setPrjEndDate(rset.getString("PRJ_ENDDATE"));
				p.setAttachmentName(rset.getString("CHANGE_NAME"));
				
				list.add(p);
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
				Project p = new Project();
				p.setPrjNo(rset.getInt("PRJ_NO"));
				p.setPrjTitle(rset.getString("PRJ_TITLE"));
				p.setCreName(rset.getString("CRE_NAME"));
				p.setPrjCatName(rset.getString("PRJ_CAT_NAME"));
				p.setPrjTarget(rset.getDouble("PRJ_TARGET"));
				p.setPrjCurrent(rset.getDouble("PRJ_CURRENT"));
				p.setPrjStartDate(rset.getString("PRJ_STARTDATE"));
				p.setPrjEndDate(rset.getString("PRJ_ENDDATE"));
				p.setAttachmentName(rset.getString("CHANGE_NAME"));
				
				list.add(p);
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
				Project p = new Project();
				p.setPrjNo(rset.getInt("PRJ_NO"));
				p.setPrjTitle(rset.getString("PRJ_TITLE"));
				p.setCreName(rset.getString("CRE_NAME"));
				p.setPrjCatName(rset.getString("PRJ_CAT_NAME"));
				p.setPrjTarget(rset.getDouble("PRJ_TARGET"));
				p.setPrjCurrent(rset.getDouble("PRJ_CURRENT"));
				p.setPrjStartDate(rset.getString("PRJ_STARTDATE"));
				p.setPrjEndDate(rset.getString("PRJ_ENDDATE"));
				p.setAttachmentName(rset.getString("CHANGE_NAME"));
				
				list.add(p);
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
				Project p = new Project();
				p.setPrjNo(rset.getInt("PRJ_NO"));
				p.setPrjTitle(rset.getString("PRJ_TITLE"));
				p.setCreName(rset.getString("CRE_NAME"));
				p.setPrjCatName(rset.getString("PRJ_CAT_NAME"));
				p.setPrjTarget(rset.getDouble("PRJ_TARGET"));
				p.setPrjCurrent(rset.getDouble("PRJ_CURRENT"));
				p.setPrjStartDate(rset.getString("PRJ_STARTDATE"));
				p.setPrjEndDate(rset.getString("PRJ_ENDDATE"));
				p.setAttachmentName(rset.getString("CHANGE_NAME"));
				
				list.add(p);
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
		int endRow = 3;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Project p = new Project();
				p.setPrjNo(rset.getInt("PRJ_NO"));
				p.setPrjTitle(rset.getString("PRJ_TITLE"));
				p.setCreName(rset.getString("CRE_NAME"));
				p.setPrjCatName(rset.getString("PRJ_CAT_NAME"));
				p.setPrjTarget(rset.getDouble("PRJ_TARGET"));
				p.setPrjCurrent(rset.getDouble("PRJ_CURRENT"));
				p.setPrjStartDate(rset.getString("PRJ_STARTDATE"));
				p.setPrjEndDate(rset.getString("PRJ_ENDDATE"));
				p.setAttachmentName(rset.getString("CHANGE_NAME"));
				
				list.add(p);
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
		int endRow = 3;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Project p = new Project();
				p.setPrjNo(rset.getInt("PRJ_NO"));
				p.setPrjTitle(rset.getString("PRJ_TITLE"));
				p.setCreName(rset.getString("CRE_NAME"));
				p.setPrjCatName(rset.getString("PRJ_CAT_NAME"));
				p.setPrjTarget(rset.getDouble("PRJ_TARGET"));
				p.setPrjCurrent(rset.getDouble("PRJ_CURRENT"));
				p.setPrjStartDate(rset.getString("PRJ_STARTDATE"));
				p.setPrjEndDate(rset.getString("PRJ_ENDDATE"));
				p.setAttachmentName(rset.getString("CHANGE_NAME"));
				
				list.add(p);
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
		int endRow = 3;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Project p = new Project();
				p.setPrjNo(rset.getInt("PRJ_NO"));
				p.setPrjTitle(rset.getString("PRJ_TITLE"));
				p.setCreName(rset.getString("CRE_NAME"));
				p.setPrjCatName(rset.getString("PRJ_CAT_NAME"));
				p.setPrjTarget(rset.getDouble("PRJ_TARGET"));
				p.setPrjCurrent(rset.getDouble("PRJ_CURRENT"));
				p.setPrjStartDate(rset.getString("PRJ_STARTDATE"));
				p.setPrjEndDate(rset.getString("PRJ_ENDDATE"));
				p.setAttachmentName(rset.getString("CHANGE_NAME"));
				
				list.add(p);
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
		int endRow = 3;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Project p = new Project();
				p.setPrjNo(rset.getInt("PRJ_NO"));
				p.setPrjTitle(rset.getString("PRJ_TITLE"));
				p.setCreName(rset.getString("CRE_NAME"));
				p.setPrjCatName(rset.getString("PRJ_CAT_NAME"));
				p.setPrjTarget(rset.getDouble("PRJ_TARGET"));
				p.setPrjCurrent(rset.getDouble("PRJ_CURRENT"));
				p.setPrjStartDate(rset.getString("PRJ_STARTDATE"));
				p.setPrjEndDate(rset.getString("PRJ_ENDDATE"));
				p.setAttachmentName(rset.getString("CHANGE_NAME"));
				
				list.add(p);
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

	public int deleteProject(Connection conn, int pno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteProject");		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteAttachment(Connection conn, int pno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteAttachment");		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Creator selectProjectCreator(Connection conn, int pno) {
		Creator c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProject");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Creator(rset.getInt("PRJ_NO"),
						rset.getString("CRE_NAME"),
						rset.getString("CRE_CONTENT")
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}

	public Project selectProjectPlan(Connection conn, int pno) {
		Project p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProject");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Project(rset.getInt("PRJ_NO"),
						rset.getDouble("PRJ_TARGET"),
						rset.getString("PRJ_STARTDATE"),
						rset.getString("PRJ_ENDDATE")
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return p;
	}

	public int getRewardCount(Connection conn, int pno) {
		int rcount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getRewardCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				rcount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return rcount;
	}
	
	public Reward[] selectProjectReward(Connection conn, int pno, int rcount) {
		Reward[] rArr = new Reward[rcount];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int index = 0;
		
		String sql = prop.getProperty("selectProjectReward");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				rArr[index] = new Reward(rset.getInt("PRJ_NO"),
										 rset.getString("RW_NAME"),
										 rset.getString("RW_CONTENT"),
										 rset.getInt("RW_PRICE"));
				index++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		for(int i=0; i<rArr.length; i++) {
			System.out.println(rArr[i]);
		}
		
		return rArr;
	}

	public Project selectProjectInfo(Connection conn, int pno) {
		Project p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProject");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Project(rset.getInt("PRJ_NO"),
						rset.getString("PRJ_TITLE"),
						rset.getString("PRJ_CONTENT"),
						rset.getString("PRJ_CAT_NAME")
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return p;
	}

	public ProjectAttachment selectAttachment(Connection conn, int pno) {
		ProjectAttachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				at = new ProjectAttachment();
				at.setFileNo(rset.getInt("ATTACHMENT_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return at;
	}

	public int updateProject(Connection conn, Project p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateProject");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getPrjTitle());
			pstmt.setString(2, p.getPrjContent());
			pstmt.setDouble(3, p.getPrjTarget());
			pstmt.setString(4, p.getPrjStartDate());
			pstmt.setString(5, p.getPrjEndDate());
			pstmt.setInt(6, Integer.parseInt(p.getPrjCatName()));
			pstmt.setInt(7, p.getPrjNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateAttachment(Connection conn, ProjectAttachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAttachment");		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getChangeName());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setInt(4, at.getFileNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertNewAttachment(Connection conn, ProjectAttachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNewAttachment");		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, at.getPrjNo());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateReward(Connection conn, Reward[] rList) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReward");
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i=0; i<rList.length; i++) {
				pstmt.setString(1, rList[i].getRwName());
				pstmt.setString(2, rList[i].getReContent());
				pstmt.setInt(3, rList[i].getRwPrice());
				pstmt.setInt(4, rList[i].getPrjNo());
				
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

	public int updateCreator(Connection conn, Creator c) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateCreator");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCreName());
			pstmt.setString(2, c.getCreContent());
			pstmt.setInt(3, c.getPrjNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteReward(Connection conn, Project p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReward");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getPrjNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertNewReward(Connection conn, Reward[] rList, Project p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNewReward");
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i=0; i<rList.length; i++) {
				pstmt.setString(1, rList[i].getRwName());
				pstmt.setString(2, rList[i].getReContent());
				pstmt.setInt(3, rList[i].getRwPrice());
				pstmt.setInt(4, p.getPrjNo());
				
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

}
