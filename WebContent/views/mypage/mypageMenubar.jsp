<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="com.kh.member.model.vo.Member, com.kh.mypage.model.vo.*"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
	.mpMenu{
		float: left;
        position: relative;
        left: 20px;
		margin-top: 100px;
		/*margin-right: 100px;*/    
	}
	h1{
		font-weight: normal;
		margin-bottom: 100px;
	}
	.myPageMenubar{
		font-size: 17px;
		border-color: lightgray;
		border-collapse: collapse;
	}
	.myPageMenubar #fl{
		background-color: rgb(196, 226, 238);
		width: 10px;
		height: 50px;
	}
	.myPageMenubar #sl{
		width: 200px;
 		height: 50px;
 		padding-left: 25px;
 		cursor: pointer;
	}
</style>
</head>
<body>
	<div class="mpMenu">
        <h1>마이페이지</h1>
		<table class="myPageMenubar" border="1px">
			<tr>
				<td rowspan="5" id="fl"></td>
				<td id="sl" onclick="mpInfo();">내 정보</td>
			</tr>
            <tr>
				<td id="sl" onclick="mpFunding();">펀딩 내역</td>
			</tr>
            <tr>
				<td id="sl" onclick="mpPrj();">프로젝트 내역</td>
			</tr>
            <tr>
				<td id="sl" onclick="mpList();">내가 작성한 글</td>
			</tr>
            <tr>	
				<td id="sl" onclick="mpWdw();">회원 탈퇴</td>
			</tr>            
		</table>
	</div>
	
	<script>
		function mpInfo(){
			location.href = "<%=request.getContextPath()%>/info.mp";
		}
		function mpFunding(){
			location.href = "<%=request.getContextPath()%>/funding.mp";
		}
		function mpPrj(){
			location.href = "<%=request.getContextPath()%>/project.mp";
		}
		function mpList(){
			location.href = "<%=request.getContextPath()%>/boardMainList.mp";
		}
		function mpWdw(){
			location.href = "views/mypage/mypageMemberDelete.jsp";
		}
	</script>
</body>
</html>