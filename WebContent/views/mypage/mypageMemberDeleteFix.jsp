<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 회원 탈퇴</title>
</head>
<body>
<%

		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		ResultSet rset = null;
		
		Connection conn = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String username = "FUNDING";
		String password = "FUNDING";
		
		PreparedStatement pstmt = null;
		String sql = "";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
			sql = "SELECT MEM_PWD FROM MEMBER WHERE MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				//rset.getString(1);
				String dbPass = rset.getString("passwd");
				
				if(passwd.equals(dbPass)){
					//sql="DELETE FROM MEMBER WHERE MEM_ID = ?";
					sql = "UPDATE MEMBER SET STATUS = 'N' WHERE MEM_ID=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					
					pstmt.executeUpdate();
					out.println("삭제");
					//System.out.println("삭제");
					session.removeAttribute("loginUser");
					
				}else{
					out.println("비밀번호가 일치하지 않음");
				}
				
			}else{
				out.println("아이디가 일치하지 않음");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if(rset != null){
				try {
					rset.close();
				} catch (SQLException ex) {
					
				}
			}
			
		    if(pstmt != null){
		    	try {
		    		pstmt.close();
		    	} catch (SQLException ex) {
		    		
		    	}
		    }
		    
		    if(conn != null) {
		    	try {
		    		conn.close();
		    	} catch (SQLException ex) {
		    		
		    	}
		    }
		    
		}
		
	%>
<%@ include file = "../common/menubar.jsp" %>
<%@ include file = "../mypage/mypageMenubar.jsp" %>

	<h3>회원정보가 삭제되었습니다.</h3>

</body>
</html>