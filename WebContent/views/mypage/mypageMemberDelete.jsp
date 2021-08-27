<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.delwrap{
		margin-top: 170px;
		margin-left: 350px;
	}
	#deltb{
		margin-left: 250px;
	}
	.deltd{
		padding: 10px;
	}
	input{
		width: 220px;
		height: 24px;
	}
	#delPwd{
        	background-color: rgb(70, 155, 224);
        	color: white;
        	border-radius: 5px;
        	width: 110px;
        	height: 30px;
        	/*border: 3px gray;*/
        	items-align: center;
	}
	#delPwd:hover{
		background-color: blue;
	}
</style>
</head>
<body>
<%

	Member m = (Member)session.getAttribute("loginUser");

	String memId = m.getMemId();
	String memPwd = m.getMemPwd();
	String originPwd = (String)session.getAttribute("originPwd");


%>

<%@ include file = "../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

	<div class="delwrap">
		<h4 style="margin-bottom:30px; font-weight: normal";> &nbsp;&nbsp;&nbsp; 비밀번호 변경</h4>
		<hr style="margin-bottom:30px;">
	
	<form name="deleteform" method="post" action="views/mypage/mypageDeleteFix.jsp"
        onsubmit="return checkValue()">
		<table id="deltb">
		
		
			<tr>
				<td class="deltd">비밀번호</td>
				<td class="deltd"><input type="password" id="mpwd"></td>
			</tr>

		</table>
		
		<button type="submit" id="delPwd" onclick="deleteMember();">탈퇴</button>
	</form>
	</div>


    <div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>
	
	
<script>
		function updatePwd(){
			window.open("<%= request.getContextPath()%>/updatePwdForm.me","비밀번호 변경창", "width=500, height=300");
			
		}
	
		function deleteMember(){
			var pwd = prompt("현재 비밀번호를 입력하세요");
			if("<%= originPwd %>" == pwd){
				var val = confirm("정말로 탈퇴하시겠습니까?");
				
				if(val){
					$("#updateForm").attr("action", "<%= request.getContextPath()%>/delete.me");
					%("#updateForm").submit();
				}else {
					alert("취소하였습니다");
				}
			}else {
				alert("비밀번호를 잘못 입력하였습니다.");
			}
			
		}	
	</script>
</body>
</html>