<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
		//String memId = (String)session.getAttribute("memId");
	
		//Member m = (Member)request.getAttribute("loginUser");
	
		//String memId = m.getMemId();
		//String memPwd = m.getMemPwd();
		
		request.setCharacterEncoding("UTF-8");
		
		//Member m = (Member)request.getAttribute("loginUser");
		
		//String memId = m.getMemId();
		//String memPwd = m.getMemPwd();
		
		//String id = (String)session.getAttribute("id");
		//String pw = request.getParameter("passwd");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		
		
		ResultSet rset = null;
		
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String username = "FUNDING";
		String password = "FUNDING";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		PreparedStatement pstmt = null;
		String sql = "";
		
		
		try{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, username, password);
			//conn = JDBC
			sql = "SELECT MEM_PWD FROM MEMBER WHERE MEM_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				//rset.getString(1);
				String dbPass = rset.getString("passwd");
				
				if(passwd.equals(dbPass)){
					
					//sql="DELETE FROM MEMBER WHERE MEM_ID = ? ";
					sql = "UPDATE MEMBER SET STATUS = 'N' WHERE MEM_ID=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					
					pstmt.executeUpdate();
					//out.println("삭제");
					System.out.println("삭제");
					
					session.removeAttribute("loginUser");
					
				}else{
					System.out.println("비밀번호가 일치하지 않음");
				}
				
			}else{
				System.out.println("아이디가 일치하지 않음");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			rset.close();
				
			pstmt.close();
		    	
		    conn.close();
		
		    
		}
		
		
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file = "../common/menubar.jsp" %>
<%@ include file = "../mypage/mypageMenubar.jsp" %>

	<h3>회원정보가 삭제되었습니다.</h3>

</body>
</html>