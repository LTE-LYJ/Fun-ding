<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "com.kh.member.model.vo.Member" %>
 <%@ page import = "com.kh.attachment.model.vo.ProfileAttachment" %>
 <%
 	Member loginUser = (Member)session.getAttribute("loginUser");
 	ProfileAttachment at = (ProfileAttachment)session.getAttribute("at");
 	String message = (String)session.getAttribute("msg");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fund-ing</title>
</head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
<style>
body {
	min-width: 1200px;
}

.navWrap {
	width: 100%;
	height: 50px
}

.navWrap>.nav {
	width: 1200px;
	margin: auto;
}

.navWrap>.logo {
	width: 700px;
	margin: auto;
}

.logo {
	text-align: center;
	color: rgb(31, 80, 126);
	font-weight: bold;
	width: 150px;
	height: 50px;
	display: table-cell;
	font-size: 30px;
	vertical-align: middle;
	font-family: 'Black Han Sans';
}

.menu {
	text-align: center;
	color: black;
	font-weight: bold;
	width: 160px;
	height: 50px;
	display: table-cell;
	font-size: 15px;
	vertical-align: middle;
	font-family: sans-serif;
}

.menu:hover {
	color: blue;
}

.btn {
	background-color: white;
	border: black 1px solid;
	font-weight: bold;
	border-radius: 5px;
	height: 35px;
	width: 100px;
}

.btn:hover {
	background-color: rgb(31, 80, 126);
	color: white;
}

.info {
	float: right;
	margin-top: 10px;
	margin-right: 20px;
}

.userInfo {
	float: right;
	margin-top: 10px;
	margin-right: 10px;
	text-align: right;
	width: 150px;
	height: 40px;
}

a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	color: black;
	text-decoration: none;
}

a:hover {
	color: rgb(31, 80, 126);;
	text-decoration: none;
}

img {
	float: right;
	margin-right: 20px;
	margin-top: 5px;
}
</style>

<body>
	<% if(loginUser == null){ %>
	<div class="navWrap">
		<span class="nav">
			<div class="logo">fund-ing</div>
			<div class="menu" style="width: 100px;" onclick="goMain();">홈</div>
			<div class="menu" onclick="goProject();">프로젝트 둘러보기</div>
			<div class="menu" onclick="goProjectUp();">프로젝트 올리기</div>
			<div class="menu" style="width: 100px;" onclick="goCommunity();">커뮤니티</div>
			<div class="menu" style="width: 100px;" onclick="goConsumer();">고객지원</div>

		</span> 
		<span class="info">
			<button class="btn" onclick="login()">로그인</button>&nbsp;
			<button class="btn" onclick="enroll()">회원가입</button>
		</span>
		<hr style="height: 1px; background-color: black;">
	</div>
	<% }else{%>
	
		<%if(loginUser.getMemNo() == 100) { %> <!-- 관리자 로그인상태라면 -->
		<div class="navWrap">
		<span class="nav">
			<div class="logo">fund-ing</div>
			<div class="menu" style="width: 100px;" onclick="goMain();">홈</div>
			<div class="menu" onclick="goProject();">프로젝트 둘러보기</div>
			<div class="menu" onclick="goProjectUp();">프로젝트 올리기</div>
			<div class="menu" style="width: 100px;" onclick="goCommunity();">커뮤니티</div>
			<div class="menu" style="width: 100px;" onclick="goConsumer();">고객지원</div>

		</span> 
		
		<img src="<%=request.getContextPath()%>/resources/images/default.PNG" style="width:50px; height:50px"> 
		
		<span class="userInfo">
            <a href="<%=request.getContextPath()%>/memberList.bo" style="font-size:15px; font-weight:bold;">회원관리리스트</a><br>
            <a href="<%=request.getContextPath()%>/logout.me" style="font-size:10px; font-weight:bold;"> 로그아웃</a>
        </span>
		<hr style="height: 1px; background-color: black;">
		</div>
		
		<%} else {%>
		
		<div class="navWrap">
		<span class="nav">
			<div class="logo">fund-ing</div>
			<div class="menu" style="width: 100px;" onclick="goMain();">홈</div>
			<div class="menu" onclick="goProject();">프로젝트 둘러보기</div>
			<div class="menu" onclick="goProjectUp();">프로젝트 올리기</div>
			<div class="menu" style="width: 100px;" onclick="goCommunity();">커뮤니티</div>
			<div class="menu" style="width: 100px;" onclick="goConsumer();">고객지원</div>

		</span> 
		
		<%if(at == null){ %>
		<img src="<%=request.getContextPath()%>/resources/images/default.PNG" style="width:50px; height:50px"> 
		<%} else { %>
		<img src="<%=request.getContextPath() %>/resources/images/<%= at.getChangeName() %>" style="width:50px; height:50px"> 
		<%} %>
		
		 
		<span class="userInfo">
            <a href="" style="font-size:15px; font-weight:bold;"><%= loginUser.getMemName() %></a><br>
            <a href="<%=request.getContextPath()%>/logout.me" style="font-size:10px; font-weight:bold;"> 로그아웃</a>
        </span>
		<hr style="height: 1px; background-color: black;">
		</div>
	
	<% } %>
	<%} %>
	
	<script>
        function goMain(){ 
            location.href="<%=request.getContextPath()%>";
        }
    
        function goProject(){ //프로젝트 둘러보기
            location.href="<%=request.getContextPath()%>/";
		
		}

		function goProjectUp() { //프로젝트 올리기
			location.href = "<%=request.getContextPath()%>/";

        }
        
        function goCommunity(){ // 커뮤니티
            location.href="<%=request.getContextPath()%>/";
        }

        function goConsumer(){ //고객지원
            location.href="<%=request.getContextPath()%>/";
        }
    
        function login(){ //로그인
        		 location.href="<%=request.getContextPath()%>/loginform.me"
        }

        function enroll(){//회원가입
        	  location.href="<%= request.getContextPath()%>/enrollForm.me";
        }

    
    </script>
</body>
</html>