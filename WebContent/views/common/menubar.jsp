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
        <li><a href="<%=request.getContextPath()%>">???</a></li>

        <li><a href="<%=request.getContextPath()%>/">???????????? ????????????</a>
            <ul style="z-index:2;">
                <li><a href="<%=request.getContextPath()%>/viewAll.pr">?????? ????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/viewPopular.pr">?????? ????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/viewNew.pr">?????? ????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/viewClose.pr">??????/?????? ????????????</a></li>
            </ul>
        </li>
        

        <li><a href="#" onclick="checkLoginPrj();">???????????? ?????????</a></li>
        <li><a href="<%=request.getContextPath()%>/views/board/boardListView">????????????</a></li>


        <li><a href="<%=request.getContextPath()%>/">????????????</a>
            <ul style="z-index:2;">
                <li><a href="<%=request.getContextPath()%>/views/notice/noticeListView">????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/views/project_report/projectReportListView">?????? ?????????</a></li>
            </ul>
        </li>

        <span class="info">
			<button class="btn" onclick="login()">?????????</button>&nbsp;
			<button class="btn" onclick="enroll()">????????????</button>
		</span>
    </ul>
    </header>
    
    <hr  style="height: 1px; background-color: black;">
	<% }else{%>
	
		<%if(loginUser.getMemNo() == 100) { %> <!-- ????????? ????????????????????? -->
	<header>
    <ul class="navi">
        <li class="logo">fund-ing</li>
        <li><a href="<%=request.getContextPath()%>">???</a></li>

        <li><a href="<%=request.getContextPath()%>/">???????????? ????????????</a>
            <ul style="z-index:2;">
                <li><a href="<%=request.getContextPath()%>/viewAll.pr">?????? ????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/viewPopular.pr">?????? ????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/viewNew.pr">?????? ????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/viewClose.pr">??????/?????? ????????????</a></li>
            </ul>
        </li>
        
        <li><a href="#" onclick="checkLoginPrj();">???????????? ?????????</a></li>
        <li><a href="<%=request.getContextPath()%>/views/board/boardListView">????????????</a></li>
        <li><a href="<%=request.getContextPath()%>/views/notice/noticeListView">????????????</a>
            <ul style="z-index:2;">
                <li><a href="<%=request.getContextPath()%>/views/notice/noticeListView">????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/views/project_report/projectReportListView">?????? ?????????</a></li>
            </ul>
        </li>

       <img id="profile" src="<%=request.getContextPath()%>/resources/images/default.PNG" style="width:40px; height:40px"> 
		
		<span class="userInfo">
          <a href="<%=request.getContextPath()%>/memberList.bo" style="font-size:15px; font-weight:bold;">?????? ?????????</a><br>
          <a href="<%=request.getContextPath()%>/logout.me" style="font-size:10px; font-weight:bold; color:red;"> ????????????</a>
        </span>
    </ul>
    </header>
	
	<hr style="height: 1px; background-color: black;">
		
		<%} else {%>
		
	<header>
    <ul class="navi">
        <li class="logo">fund-ing</li>
        <li><a href="<%=request.getContextPath()%>">???</a></li>

        <li><a href="<%=request.getContextPath()%>/">???????????? ????????????</a>
            <ul style="z-index:2;">
                <li><a href="<%=request.getContextPath()%>/viewAll.pr">?????? ????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/viewPopular.pr">?????? ????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/viewNew.pr">?????? ????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/viewClose.pr">??????/?????? ????????????</a></li>
            </ul>
        </li>
        
        <li><a href="#" onclick="checkLoginPrj();">???????????? ?????????</a></li>
        <li><a href="<%=request.getContextPath()%>/views/board/boardListView">????????????</a></li>
        <li><a href="<%=request.getContextPath()%>/views/notice/noticeListView">????????????</a>
            <ul style="z-index:2;">
                <li><a href="<%=request.getContextPath()%>/views/notice/noticeListView">????????????</a></li>
                <li><a href="<%=request.getContextPath()%>/views/project_report/projectReportListView">?????? ?????????</a></li>
            </ul>
        </li>

       	<%if(at == null){ %>
		<img id="profile" src="<%=request.getContextPath()%>/resources/images/default.PNG" style="width:40px; height:40px"> 
		<%} else { %>
		<img id="profile"  src="<%=request.getContextPath() %>/resources/upfiles_profile/<%= at.getChangeName()%>" style="width:40px; height:40px"> 
		<%} %>
		
		<span class="userInfo">
            <a href="<%=request.getContextPath()%>/info.mp" style="font-size:15px; font-weight:bold;"><%= loginUser.getMemName() %></a><br>
            <a href="<%=request.getContextPath()%>/logout.me" style="font-size:10px; font-weight:bold; color:red;"> ????????????</a>
        </span>
    </ul>
    </header>
	
	<hr style="height: 1px; background-color: black;">

	<% } %>
	<%} %>
	
	<script>
        function login(){ //?????????
        		 location.href="<%=request.getContextPath()%>/loginform.me"
        }

        function enroll(){//????????????
        	  location.href="<%= request.getContextPath()%>/enrollForm.me";
        }
        
        function checkLoginPrj(){
			<%if(loginUser != null){%>
				location.href="<%=request.getContextPath()%>/writeCreator.pr";
			<%}else{%>
				alert("???????????? ???????????????.");
				location.href="<%=request.getContextPath()%>/loginform.me";
			<%}%>
	    };
    
    </script>
</body>
</html>