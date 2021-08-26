package com.kh.project.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.attachment.model.vo.ProjectAttachment;
import com.kh.project.model.dao.ProjectDao;
import com.kh.project.model.vo.Creator;
import com.kh.project.model.vo.PageInfo;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.Reward;

public class ProjectService {
	
	//getListCount
	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new ProjectDao().getListCount(conn);
		close(conn);
		return listCount;
	}
	
	public int getPopularListCount() {
		Connection conn = getConnection();
		
		int listCount = new ProjectDao().getPopularListCount(conn);
		close(conn);
		return listCount;
	}

	public int getNewListCount() {
		Connection conn = getConnection();
		
		int listCount = new ProjectDao().getNewListCount(conn);
		close(conn);
		return listCount;
	}

	public int getCloseListCount() {
		Connection conn = getConnection();
		
		int listCount = new ProjectDao().getCloseListCount(conn);
		close(conn);
		return listCount;
	}

	
	//selectList
	public ArrayList<Project> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().selectList(conn, pi);
		close(conn);
		return list;
	}

	public ArrayList<Project> selectCloseList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().selectCloseList(conn, pi);
		close(conn);
		return list;
	}

	public ArrayList<Project> selectPopularList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().selectPopularList(conn, pi);
		close(conn);
		return list;
	}

	public ArrayList<Project> selectNewList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().selectNewList(conn, pi);
		close(conn);
		return list;
	}

	
	//메인 페이지 select
	public ArrayList<Project> selectAllList() {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().selectAllList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Project> selectPopularList() {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().selectPopularList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Project> selectNewList() {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().selectNewList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Project> selectCloseList() {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().selectCloseList(conn);
		close(conn);
		return list;
	}

	
	//insert
	/*
	public int insertProject(Project p, ProjectAttachment at) {
		Connection conn = getConnection();
		
		int result1 = new ProjectDao().insertProject(conn, p);
		
		int result2 = 1;
		if(at != null) {
			result2 = new ProjectDao().insertAttachment(conn, at);
		}
		
		if(result1 * result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2;
	}

	public int insertCreator(Creator c) {
		Connection conn = getConnection();
		
		int result = new ProjectDao().insertCreator(conn, c);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	*/

	public int insertProject(Project p, ProjectAttachment at, Reward[] rList, Creator c) {
		Connection conn = getConnection();
		
		int result1 = new ProjectDao().insertProject(conn, p);
		
		int result2 = 1;
		if(at != null) {
			result2 = new ProjectDao().insertAttachment(conn, at);
		}
		
		int result3 = new ProjectDao().insertReward(conn, rList);
		
		int result4 = new ProjectDao().insertCreator(conn, c);
		
		if(result1 * result2 * result3 * result4 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2 * result3 * result4;
	}

}
