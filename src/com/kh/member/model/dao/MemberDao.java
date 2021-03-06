package com.kh.member.model.dao;

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

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberPageInfo;

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
	
	//	private int fileNo;        // ???????????? ATTACHMENT_NO
	//	private String originName; // ??????????????? ORIGIN_NAME
	//	private String changeName; // ??????????????? CHANGE_NAME
	//	private String filePath;   // ?????????????????? ATTACHMENT_PATH
	//	private Date uploadDate;   // ??????????????? 	UPLOAD_DATE
	//	private String status;     // ?????????(Y/N) STATUS
	//	private int memNo;         //????????????
	
	public ProfileAttachment memberProfile(Connection conn, String userId) {
		ProfileAttachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
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

	public ArrayList<Member> selectList(Connection conn, MemberPageInfo pi) {
		ArrayList<Member> list = new ArrayList();
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
	
	public ArrayList<Member> searchList(Connection conn) {
		ArrayList<Member> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchList");
		
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
		}
		
		return listCount;
	}

	//mypage
	public boolean removeMemberProfile(Connection conn, int memNo) {
        
		String sql = prop.getProperty("removeMemberAttachment");

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, memNo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
