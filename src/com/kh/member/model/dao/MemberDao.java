package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		System.out.println(sql);
		
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
		
		return result;
	}

	public int insertMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
	    String sql = prop.getProperty("insertMember");
	    //INSERT INTO MEMBER 
	    //VALUES 
	    //(SEQ_MEM_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE, DEFAULT, 0);
	    

	    try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,m.getMemId());
			pstmt.setString(2, m.getMemPwd());
			pstmt.setString(3, m.getMemName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			 close(pstmt);
		}
       
		return result;
	}

	public int insertAttachment(Connection conn, ProfileAttachment at, int memNo) {
		int result =0;
		PreparedStatement pstmt = null;
	    String sql = prop.getProperty("insertAttachment");
		   
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getOriginName());
	        pstmt.setString(2, at.getChangeName());
	        pstmt.setString(3, at.getFilePath());
	        pstmt.setInt(4, memNo);
	         
	        result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			 close(pstmt);
		}
		   
		   
		return result;
	}

	public int selectMemNo(Connection conn, String memId) {
		int memNo = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemNo");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
	
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				memNo = rset.getInt("MEM_NO");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return memNo;
	}

	public String findId(Connection conn, String userName, String email) {
		String userId = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("findId");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				userId = rset.getString("MEM_ID");
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userId;
	}

	public String findPwd(Connection conn, String userId, String userName) {
		String userPwd = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("findPwd");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				userPwd = rset.getString("MEM_PWD");
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userPwd;
	}

	public ArrayList<Member> selectList(Connection conn) {
		
		ArrayList<Member> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())  {
				Member member = new Member();
				
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
				
				list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public Member selectMember(Connection conn, String memId) {
		
		Member member = new Member();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())  {
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
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public int deleteMember(Connection conn, String memId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
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
