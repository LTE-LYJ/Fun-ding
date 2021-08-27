package com.kh.mypage.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.mypage.model.dao.MypageDao;
import com.kh.mypage.model.vo.Board;
import com.kh.mypage.model.vo.PageInfo;
import com.kh.project.model.vo.Project;
import com.kh.member.model.vo.Member;

public class MypageService {
	
	private Properties prop = new Properties();

	public Member updateMember(Member m) {
		
		Connection conn = getConnection();
		Member updateMem = null;
		int result = new MypageDao().updateMember(conn, m); //Member
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

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new MypageDao().getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new MypageDao().selectList(conn, pi);
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

	public ArrayList<Project> selectPrj(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new MypageDao().selectList(conn, pi);
		close(conn);
		return list;
	}

}
