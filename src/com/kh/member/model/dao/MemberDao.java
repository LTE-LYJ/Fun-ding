package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();

	public MemberDao() {
		String fileName = MemberDao.class.getResource("/com/sql/member/member-query.properties").getPath();
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

	public Member loginMember(Connection conn, String userId, String userPwd) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setMemNo(rset.getInt("MEM_NO"));
				member.setMemId(rset.getString("MEM_ID"));
				member.setMemPwd(rset.getString("MEM_PWD"));
				member.setMemName(rset.getString("MEM_NAME"));	
				member.setPhone(rset.getString("PHONE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setAddress(rset.getString("ADDRESS"));	
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				member.setStatus(rset.getString("STATUS"));
				member.setCoin(rset.getInt("COIN"));
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return member;
	}

	public ProfileAttachment memberProfile(Connection conn, String userId) {
		ProfileAttachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
	//	private int fileNo; // 파일번호 ATTACHMENT_NO
	//	private String originName; // 원본파일명 ORIGIN_NAME
	//	private String changeName; // 수정파일명 CHANGE_NAME
	//	private String filePath;   // 저장폴더경로 ATTACHMENT_PATH
	//	private Date uploadDate;   // 업로드날짜 	UPLOAD_DATE
	//	private String status;     // 상태값(Y/N) STATUS
	//	private int memNo;       //회원번호

		
		String sql = prop.getProperty("loginMemberAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				at = new ProfileAttachment();
				
				at.setFileNo(rset.getInt("ATTACHMENT_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("ATTACHMENT_PATH"));
				at.setUploadDate(rset.getDate("UPLOAD_DATE"));
				at.setStatus(rset.getString("STATUS"));
						
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

	public int idCheck(Connection conn, String userId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return 0;
	}

}
