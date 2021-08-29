<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
	String sTag = (String)request.getAttribute("sTag");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</script>
<style>
	.upwrap{
		margin-top: 170px;
		margin-left: 350px;
	}
	#upBtn{
		 margin-left: 360px;
         margin-top: 230px;
	}
	#uptb{
		margin-left: 250px;
	}
	.uptd{
		padding: 10px;
	}
	input{
		width: 220px;
		height: 24px;
	}
	.upbtn{
        	background-color: rgb(70, 155, 224);
        	color: white;
        	border-radius: 5px;
        	width: 110px;
        	height: 30px;
        	/*border: 3px gray;*/
        	text-align: center;
        	margin-left: 350px;
	}
	.upbtn:hover{
		background-color: blue;
	}
</style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

	<div class="upwrap">
		<h4 style="margin-bottom:30px; font-weight: normal;"> &nbsp;&nbsp;&nbsp; 비밀번호 변경</h4>
		<hr style="margin-bottom:30px;">
	
	<form id="updatePwdForm" action="<%= request.getContextPath() %>/updatePwd.mp" method="post">
	
		<table id="uptb">
			<tr>
				<td class="uptd">현재 비밀번호</td>
				<td class="uptd"><input type="password" name="memPwd" id="memPwd"></td>
			</tr>
			<tr>
				<td class="uptd">변경 비밀번호</td>
				<td class="uptd"><input type="password" name="changePwd"></td>
			</tr>
			<tr>
				<td class="uptd">비밀번호 확인</td>
				<td class="uptd"><input type="password" name="checkPwd"></td>
			</tr>
		</table>
		<br>
		<div id="updatePwdForm" class="upbtn" onclick="upPwdBtn();">변경하기</div>
	</form>
	
	</div>

	<script type="text/javascript">
		function upPwdBtn(){
			
			var memPwd = $("#memPwd");
			var changePwd = $("input[name='changePwd']");
			var checkPwd = $("input[name='checkPwd']");
			
			if(memPwd.val().trim() == "" || changePwd.val().trim() == "" || checkPwd.val().trim() == ""){
				alert("비밀번호를 입력하세요");
				return false;
			}
			
			if(changePwd.val() != checkPwd.val()){
				alert("비밀번호가 일치하지 않습니다..");
				checkPwd.val('');
				checkPwd.focus();
				return false;
			}
			
			alert("비밀번호가 변경되었습니다.")
			$("#updatePwdForm").submit();
		
		}
	</script>

    <div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>