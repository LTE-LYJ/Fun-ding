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

	public int deleteProject(int pno) {
		Connection conn = getConnection();
		
		int result1 = new ProjectDao().deleteProject(conn, pno);
		int result2 = new ProjectDao().deleteAttachment(conn, pno);
		if(result1 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1; //첨부파일 넣는 건 필수가 아니기 때문에 result1만 체크
	}

	
	//selectProject
	public Creator selectProjectCreator(int pno) {
		Connection conn = getConnection();
		
		Creator c = new ProjectDao().selectProjectCreator(conn, pno);
		
		close(conn);
		return c;
	}

	public Project selectProjectPlan(int pno) {
		Connection conn = getConnection();
		
		Project p = new ProjectDao().selectProjectPlan(conn, pno);
		
		close(conn);
		return p;
	}

	public int getRewardCount(int pno) {
		Connection conn = getConnection();
		
		int rcount = new ProjectDao().getRewardCount(conn, pno);
		close(conn);
		return rcount;
	}

	public Reward[] selectProjectReward(int pno, int rcount) {
		Connection conn = getConnection();
		
		Reward[] r = new ProjectDao().selectProjectReward(conn, pno, rcount);
		
		close(conn);
		return r;
	}

	public Project selectProjectInfo(int pno) {
		Connection conn = getConnection();
		
		Project p = new ProjectDao().selectProjectInfo(conn, pno);
		
		close(conn);
		return p;
	}

	public ProjectAttachment selectAttachment(int pno) {
		Connection conn = getConnection();
		
		ProjectAttachment at = new ProjectDao().selectAttachment(conn, pno);
		
		close(conn);
		return at;
	}

	public int updateProject(Project p, ProjectAttachment at, Reward[] rList, Creator c) {
		Connection conn = getConnection();
		
		int result1 = new ProjectDao().updateProject(conn, p);
		
		int result2 = 1;		
		if(at != null) {
			if(at.getFileNo() != 0) {
				result2 = new ProjectDao().updateAttachment(conn, at);
			} else {
				result2 = new ProjectDao().insertNewAttachment(conn, at);
			}
		}
		
//		int result3 = new ProjectDao().updateReward(conn, rList);
		int result3 = new ProjectDao().deleteReward(conn, p);
		int result4 = new ProjectDao().insertNewReward(conn, rList, p);
		
		int result5 = new ProjectDao().updateCreator(conn, c);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
		System.out.println("result4 : " + result4);
		System.out.println("result5 : " + result5);
		System.out.println("result1 * result2 * result3 * result4 * result5 : " + result1 * result2 * result3 * result4 * result5);
		
		if(result1 * result2 * result3 * result4 * result5 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2 * result3 * result4 * result5;
	}

}
