<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
  // 한글처리
  //request.setCharacterEncoding("UTF-8"); /////////
  // id passwd name가져오기
  String memId = request.getParameter("memId");
  String memPwd = request.getParameter("memPwd");
  String memName = request.getParameter("memName");
  String phone = request.getParameter("phone");
  String email = request.getParameter("email");
  String address = request.getParameter("address");
  
  ResultSet rs = null;
  try {
   // 1단계 드라이버로더
   Class.forName("oracle.jdbc.driver.OracleDriver");
   // 2단계 디비연결
   Connection con = null;
   String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
   String user = "FUNDING";
   String pwd = "FUNDING";

   con = DriverManager.getConnection(url, user, pwd);
   // 3단계 : id에 해당하는 passwd를 가져오는 sql(sql 생성)
   PreparedStatement pstmt = null;
   String sql = "";
   
   sql = "select passwd from member where id=?";
   pstmt = con.prepareStatement(sql);
   pstmt.setString(1, memId);
   
   rs = pstmt.executeQuery();
   
   //   폼비밀번호 rs비밀번호 비교 맞으면 => 수정
   //                     틀리면 => 비밀번호틀림
   //            없으면 id없음
   if(rs.next()){
    //id있음
//     rs.getString(1);
   		//String dbPass=rs.getString("memPwd");
	    //if(memPwd.equals(dbPass)){
	     //비밀번호 일치
	     sql = "UPDATE MEMBER SET MEM_NAME=?, PHONE=?, EMAIL=?, ADDRESS=? WHERE MEM_ID=?";
	     pstmt=con.prepareStatement(sql);
	     pstmt.setString(1, memName);
	     pstmt.setString(2, phone);
	     pstmt.setString(3, email);
	     pstmt.setString(4, address);
	     pstmt.setString(5, memId);
	        
	     
	     pstmt.executeUpdate(); //insert,update,delete
	     out.println("정보수정");
	    //}else{
	     //out.println("비밀번호 오류");
	   // }    
   }else{
    out.println("id 없음");
   }
   
  } catch (Exception e) {
   e.printStackTrace();
  }finally{
   
  }
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .mpInfotb{
            /*text-align: center;*/
            position: relative;
            left: 300px;
            top: 200px;
        }
        #profileImg{
            width: 90px;
            height: 90px;
            background-color: lightgray;
            margin-bottom: 20px
        }
        td{
            height: 50px;
            width: 70px;
        }
        .mpi{
            width: 200px;
            height: 20px;    
        }
        .mpInfotb{
        	font-size: 20px
        }
        button{
        	background-color: rgb(70, 155, 224);
        	color: white;
        	border-radius: 5px;
        	width: 110px;
        	height: 30px;
        	/*border: 3px gray;*/
        }
        button:hover{
        	background-color: blue;
        }
        #uiBtn{
            margin-left: 360px;
            margin-top: 230px;
        }
        
</style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

	<!-- <div class="mypageinfo">
	
	<form id="updateForm" action="<%=request.getContextPath() %>/updateInfo.mp" method="post">
        <table class="mpInfotb">
            <tr>
            	<td><div id="profileImg"></div></td>
            	<td><input type="file" name="fileName" style="float: bottom;"></td>               
            </tr>
            <tr>
                <td>아이디</td>
                <td><input type="text" class="mpi" id="mpId" name="memId" value = "<%= memId %>" readonly></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" class="mpi" id="mpPwd" name="memName" value = "<%= memName %>" required></td>
            </tr>
            <tr>
                <td>연락처</td>
                <td><input type="text" class="mpi" id="mpPhone" name="phone" value = "<%= phone %>" required></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" class="mpi" id="mpEmail" name="email" value = "<%= email %>" required></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" class="mpi" id="mpAddress" name="address" value = "<%= address %>" required></td>
            </tr>
        </table>

		<button type="submit" id="uiBtn">확인</button>
	</form>		

    </div> -->

	<div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>

	
</body>
</html>