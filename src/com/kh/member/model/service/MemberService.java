package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) { // 로그인 회원 정보가져오기
		
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
		System.out.println(result);
		close(conn);
		
		return result;
	}


	public int insertMember(Member m) { //회원객체 정보
		Connection conn = getConnection();
		int result =new MemberDao().insertMember(conn,m); 
	      
	      if(result >0) {
	    	  
	         commit(conn);
	      }else {
	         rollback(conn);
	      }
	      close(conn);
	      return result;
	}
	
	public int selectMemNo(String memId) { //회원가입한 유저 번호 알아내기 
		Connection conn = getConnection();
		int result = new MemberDao().selectMemNo(conn, memId);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		  close(conn);
		  return result;
	}
	
	public int insertAttachment(ProfileAttachment at, int memNo) { //회원프로필
		Connection conn = getConnection();
		
		int result = 0;
		
	    if(at != null) {
	         result = new MemberDao().insertAttachment(conn, at, memNo);
	    }
	    
	    if(result > 0 ) {
	    	commit(conn);
	    } else {
	    	rollback(conn);
	    } 
	    
	    close(conn);
		  return result;
	    
	     
	}
	

	
	public String findId(String userName, String email) { //아이디 찾기
		Connection conn = getConnection();
		
		String userId = new MemberDao().findId(conn, userName, email);
		
		close(conn);
		
		return userId;
	}
	
	public String findPwd(String userId, String userName) {
		Connection conn = getConnection();
		
		String userPwd = new MemberDao().findPwd(conn, userId, userName);
		
		close(conn);
		
		return userPwd;
	}

	public ArrayList<Member> selectList() { //관리자 페이지의 멤버 조회 
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().selectList(conn);
		
		close(conn);
		
		return list;

		
	}

	public Member selectMember(String memId) { //관리자 페이지의 멤버 상세조회
		Connection conn = getConnection();
		
		Member member = new MemberDao().selectMember(conn, memId);
		
		close(conn);
		
		return member;
	}

	public int deleteMember(String memId) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, memId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	

}
