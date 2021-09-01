package com.kh.mypage.model.service;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.mypage.model.dao.MypageDao;
import com.kh.mypage.model.vo.Board;
import com.kh.mypage.model.vo.PageInfo;
import com.kh.mypage.model.vo.Project;
import com.kh.mypage.model.vo.Project_ask;
import com.kh.mypage.model.vo.Project_report;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;

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
		
		return updateMem;
	}


	public int getMainListCount(int memNo) {
		Connection conn = getConnection();

		int listCount = new MypageDao().getMainListCount(conn, memNo);
		
		close(conn);
		return listCount;
	}

	public List<Board> selectMainList(int memNo, PageInfo pi) {
		Connection conn = getConnection();

		List<Board> list = new MypageDao().selectMainList(conn, memNo, pi);
		
		close(conn);
		return list;
	}


	public int getAskListCount(int memNo) {
		Connection conn = getConnection();

		int listCount = new MypageDao().getAskListCount(conn, memNo);
		
		close(conn);
		return listCount;
	}

	public List<Project_ask> selectAskList(int memNo, PageInfo pi) {
		
		Connection conn = getConnection();

		List<Project_ask> list = new MypageDao().selectAskList(conn, memNo, pi);
		close(conn);
		return list;
	}


	public int getReportListCount(int memNo) {
		Connection conn = getConnection();

		int listCount = new MypageDao().getReportListCount(conn, memNo);
		close(conn);
		return listCount;
	}

	public List<Project_report> selectReportList(int memNo, PageInfo pi) {
		Connection conn = getConnection();

		List<Project_report> list = new MypageDao().selectReportList(conn, memNo, pi);
		close(conn);
		return list;
	}

	public int deleteMember(String memId, String memPwd) {

		Connection conn = getConnection();
		int result = new MypageDao().deleteMember(conn, memId, memPwd);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Member updatePwd(String memId, String memPwd, String changePwd) {

		Connection conn = getConnection();
		Member updateMem = null;
		int result = new MypageDao().updatePwd(conn, memId, memPwd, changePwd);
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, memId);

		}else {
			rollback(conn);
		}

		close(conn);

		return updateMem;
	}

	public int getPrjListCount(int memNo) {
		Connection conn = getConnection();

		int listCount = new MypageDao().getProjectListCount(conn, memNo);
		close(conn);
		return listCount;
	}

	public ArrayList<Project> selectPrjList(Member m) {
		
		Connection conn = getConnection();
		
		ArrayList<Project> list = new MypageDao().selectPrjList(conn, m);
		close(conn);
		return list;
	}


	public ArrayList<Project> selectPrjListClose(Member m) {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new MypageDao().selectPrjListClose(conn, m);
		close(conn);
		
		return list;
	}

	public List<Project> selectFundingList(int memNo, PageInfo pageInfo) {
		
		try (Connection conn = getConnection()) {
			return new MypageDao().selectFundingList(conn, memNo, pageInfo);
		} catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}

	public Member updateMem(Member m, ProfileAttachment at) {

		Connection conn = getConnection();
		Member updateMem = null;
		
		int result = new MypageDao().updateMember(conn, m, at);
		if(result > 0) {
			commit(conn);
			

		}else {
			rollback(conn);
		}

		close(conn);
		return updateMem;
	}

}
