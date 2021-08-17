package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) { // 로그인 회원 정보가져오기
		System.out.println("service");
		
		Connection conn = getConnection();
	
		Member loginUser = new MemberDao().loginMember(conn, userId, userPwd);
	
		close(conn);
		
		return loginUser;
	}

	public ProfileAttachment memberProfile(String userId) { //로그인 프로필 경로 가져오기
		Connection conn = getConnection();
		
		ProfileAttachment at = new MemberDao().memberProfile(conn,userId);
		
		close(conn);
		
		return at;
	}

	public int idCheck(String userId) { //아이디 중복확인
		Connection conn = getConnection();
		
		int result = new MemberDao().idCheck(conn, userId);
		
		close(conn);
		
		return result;
	}

	public String findId(String userName, String email) { //아이디 찾기
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Member> selectList() { //관리자 페이지의 멤버 조회 
		// TODO Auto-generated method stub
		return null;
	}

}
