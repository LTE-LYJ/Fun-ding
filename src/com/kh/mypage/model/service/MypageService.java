package com.kh.mypage.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.board.model.dao.BoardDao;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.mypage.model.dao.MypageDao;
import com.kh.mypage.model.vo.Board;
import com.kh.mypage.model.vo.PageInfo;
import com.kh.mypage.model.vo.Project_ask;
import com.kh.mypage.model.vo.Project_report;
//import com.kh.project.model.vo.Project;
import com.kh.mypage.model.vo.Project;

public class MypageService {
	
	private Properties prop = new Properties();

	public Member updateMember(Member m) {
		
		Connection conn = getConnection();
		Member updateMem = null;
		int result = new MypageDao().updateMember(conn, m);
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, m.getMemId());
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		//System.out.println(m);
		return updateMem;
	}

	
	public int getMainListCount() {
		Connection conn = getConnection();
		
		int listCount = new MypageDao().getMainListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectMainList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new MypageDao().selectMainList(conn, pi);
		close(conn);
		return list;
	}
	
	
	public int getAskListCount() {
		Connection conn = getConnection();
		
		int listCount = new MypageDao().getAskListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Project_ask> selectAskList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Project_ask> list = new MypageDao().selectAskList(conn, pi);
		close(conn);
		return list;
	}

	
	public int getReportListCount() {
		Connection conn = getConnection();
		
		int listCount = new MypageDao().getReportListCount(conn);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Project_report> selectReportList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Project_report> list = new MypageDao().selectReportList(conn, pi);
		close(conn);
		return list;
	}
	
	
	
	public int deleteMember(String memId) {
		
		Connection conn = getConnection();
		int result = new MypageDao().deleteMember(conn, memId);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Member updatePwd(String memPwd, String memId, String changePwd) {
		
		Connection conn = getConnection();
		Member updateMem = null;
		int result = new MypageDao().updatePwd(conn, memPwd, memId, changePwd);
		
		System.out.println(result); // result 값 출력해서 결과 확인 //0
		
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, memId);
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
	}


	public int getPrjListCount() {
		Connection conn = getConnection();
		
		int listCount = new MypageDao().getPrjListCount(conn);
		close(conn);
		return listCount;
	}


	public ArrayList<Project> selectPrjList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new MypageDao().selectPrjList(conn, pi);
		close(conn);
		return list;
	}


	public Member updateMem(Member m, ProfileAttachment at) {
		
		Connection conn = getConnection();
		Member updateMem = null;
		int result = new MypageDao().updateMember(conn, m, at); //Member
		if(result > 0) {
			commit(conn);
			//updateMem = new MemberDao().selectMember(conn, m.getMemId(), at);
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		//System.out.println(m);
		return updateMem;
	}


	public ProfileAttachment selectAttachment(int memNo) {
		Connection conn = getConnection();
		
		ProfileAttachment at = new MypageDao().selectAttachment(conn, memNo);
		
		close(conn);
		return at;
	}


	


	


	


	



	


	

}
