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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
<style>
body {
	min-width: 1200px;
}

.logo {
    width: 700px;
	margin: auto;
	text-align: center;
	color: rgb(31, 80, 126);
	font-weight: bold;
	width: 150px;
	display: table-cell;
	font-size: 30px;
	vertical-align: middle;
	font-family: 'Black Han Sans';
}

header> ul {
    clear: both;
    list-style:none;
}

header>ul>li{
     display: inline-block;
}

.navi{
    list-style-type: none;
    height: 40px;
    padding: 0;
    margin: 0;

}
.navi li {
    float: left;
    margin-right: 5%;
    position: relative;
    line-height: 40px;
}

.navi li a{
    clear: both;
    display: block;
    font-weight: 600;
    font-size: 14px;
    color: rgb(31, 80, 126);
    text-decoration: none;
}

.navi li a:hover{
    color: rgb(31, 80, 126);
}

.navi li ul{
    opacity: 0; 
    position: absolute;
    left:0;
    width: 180px;
    background-color: rgb(31, 80, 126);
    list-style-type: none;
    padding:0;
    margin: 0;
    width:150px;
}

.navi li:hover ul{
    opacity: 1; 
}

.navi li ul li {
    float: none; 
    height: 0;
    line-height:0;
    background: none;
}

.navi li:hover ul li {
    height: 30px;
    line-height: 30px;
    padding: 5px 0;
    margin-left: 10px;
}

.navi li ul li a{
    background-color: rgb(31, 80, 126);
    font-weight: 600;
    font-size: 12px;
    color: white;
}

.navi li ul li a:hover{
    color: white;
    background-color: rgba(60, 115, 167, 0.644);
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
	margin-top: 3px;
	margin-right: 20px;
}

.userInfo {
	float: right;
	margin-top: 5px;
	margin-right: 10px;
	text-align: right;
	width: 150px;
	height: 35px;
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
	color: rgb(31, 80, 126);
	text-decoration: none;
}

#profile {
	float: right;
	margin-right: 20px;
	border-radius: 70%;
}
</style>

<script>
$(function(){
    var msg = "<%=message%>";
    
    if(msg != "null"){
       alert(msg);	
       
       <%session.removeAttribute("msg");%>
    }
 	});
</script>

<body>
	<% if(loginUser == null){ %>
	<header>
    <ul class="navi">
        <li class="logo">fund-ing</li>
        <li><a href="<%=request.getContextPath()%>">홈</a></li>

        <li><a href="<%=request.getContextPath()%>/">프로젝트 둘러보기</a>
            <ul>
                <li><a href="">모든 프로젝트</a></li>
                <li><a href="">인기 프로젝트</a></li>
                <li><a href="">신규프로젝트</a></li>
                <li><a href="">마감/실패 프로젝트</a></li>
            </ul>
        </li>
        
        <li><a href="<%=request.getContextPath()%>/">프로젝트 올리기</a></li>
        <li><a href="<%=request.getContextPath()%>/">커뮤니티</a></li>
        <li><a href="<%=request.getContextPath()%>/">고객지원</a>
            <ul>
                <li><a href="<%=request.getContextPath()%>/">공지사항</a></li>
                <li><a href="<%=request.getContextPath()%>/">신고 게시판</a></li>
            </ul>
        </li>

        <span class="info">
			<button class="btn" onclick="login()">로그인</button>&nbsp;
			<button class="btn" onclick="enroll()">회원가입</button>
		</span>
    </ul>
    </header>
    
    <hr  style="height: 1px; background-color: black;">
	<% }else{%>
	
		<%if(loginUser.getMemNo() == 100) { %> <!-- 관리자 로그인상태라면 -->
	<header>
    <ul class="navi">
        <li class="logo">fund-ing</li>
        <li><a href="<%=request.getContextPath()%>">홈</a></li>

        <li><a href="<%=request.getContextPath()%>/">프로젝트 둘러보기</a>
            <ul>
                <li><a href="">모든 프로젝트</a></li>
                <li><a href="">인기 프로젝트</a></li>
                <li><a href="">신규프로젝트</a></li>
                <li><a href="">마감/실패 프로젝트</a></li>
            </ul>
        </li>
        
        <li><a href="<%=request.getContextPath()%>/">프로젝트 올리기</a></li>
        <li><a href="<%=request.getContextPath()%>/">커뮤니티</a></li>
        <li><a href="<%=request.getContextPath()%>/">고객지원</a>
            <ul>
                <li><a href="<%=request.getContextPath()%>/">공지사항</a></li>
                <li><a href="<%=request.getContextPath()%>/">신고 게시판</a></li>
            </ul>
        </li>

       <img id="profile" src="<%=request.getContextPath()%>/resources/images/default.PNG" style="width:40px; height:40px"> 
		
		<span class="userInfo">
          <a href="<%=request.getContextPath()%>/memberList.bo" style="font-size:15px; font-weight:bold;">회원 리스트</a>
          <a href="<%=request.getContextPath()%>/logout.me" style="font-size:10px; font-weight:bold; color:red;"> 로그아웃</a>
        </span>
    </ul>
    </header>
	
	<hr style="height: 1px; background-color: black;">
		
		<%} else {%>
		
	<header>
    <ul class="navi">
        <li class="logo">fund-ing</li>
        <li><a href="<%=request.getContextPath()%>">홈</a></li>

        <li><a href="<%=request.getContextPath()%>/">프로젝트 둘러보기</a>
            <ul>
                <li><a href="">모든 프로젝트</a></li>
                <li><a href="">인기 프로젝트</a></li>
                <li><a href="">신규프로젝트</a></li>
                <li><a href="">마감/실패 프로젝트</a></li>
            </ul>
        </li>
        
        <li><a href="<%=request.getContextPath()%>/">프로젝트 올리기</a></li>
        <li><a href="<%=request.getContextPath()%>/">커뮤니티</a></li>
        <li><a href="<%=request.getContextPath()%>/">고객지원</a>
            <ul>
                <li><a href="<%=request.getContextPath()%>/">공지사항</a></li>
                <li><a href="<%=request.getContextPath()%>/">신고 게시판</a></li>
            </ul>
        </li>

       	<%if(at == null){ %>
		<img id="profile" src="<%=request.getContextPath()%>/resources/images/default.PNG" style="width:40px; height:40px"> 
		<%} else { %>
		<img id="profile"  src="<%=request.getContextPath() %>/resources/upfiles_profile/<%= at.getChangeName()%>" style="width:40px; height:40px"> 
		<%} %>
		
		<span class="userInfo">
            <a href="" style="font-size:15px; font-weight:bold;"><%= loginUser.getMemName() %></a><br>
            <a href="<%=request.getContextPath()%>/logout.me" style="font-size:10px; font-weight:bold; color:red;"> 로그아웃</a>
        </span>
    </ul>
    </header>
	
	<hr style="height: 1px; background-color: black;">

	<% } %>
	<%} %>
	
	<script>
        function login(){ //로그인
        		 location.href="<%=request.getContextPath()%>/loginform.me"
        }

        function enroll(){//회원가입
        	  location.href="<%= request.getContextPath()%>/enrollForm.me";
        }

    
    </script>
</body>
</html>