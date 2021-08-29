<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.delwrap{
		margin-top: 200px;
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
	#fm{
		text-align: center;
	}
</style>
</head>
<body>
<%

	Member m = (Member)session.getAttribute("loginUser");

	String memId = m.getMemId();
	//String memPwd = m.getMemPwd();
	String memPwd = (String)session.getAttribute("memPwd");


%>

<%@ include file = "../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

	<div class="delwrap">
	<h4>회원 탈퇴</h4>
		<hr style="margin-bottom:30px;">
	
	<!--<form name="deleteform" method="post" action="views/mypage/mypageMemberDeleteFix.jsp"
        onsubmit="return checkValue()">
      
		<table id="deltb">
			<tr>
				 <td class="deltd">아이디</td>
				
				
				<td class="deltd">비밀번호</td>
				<td class="deltd"><input type="password" id="mpwd" name="passwd"></td>
				<td colspan="2" align="center">
					<input type="button" value="취소" onclick="window.location='mypageInfo.jsp'"/>
					<input type="submit" value="탈퇴" id="delPwd" onclick="deleteMember();"/>
				</td>
			</tr>

		</table> 

	</form>-->
	
	<form action="mypageMemberDeleteFix.jsp" method="post" id="fm">
	
		아이디 &nbsp; &nbsp; <input type="text" name="id"><br><br>
		비밀번호 &nbsp; <input type="password" name="passwd"><br><br>
	
		<input type="submit" id="delPwd" value="탈퇴하기"><br>
	</form>
	
	</div>


    <div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>
	
	
	<script type="text/javascript">
	<%--function checkValue(){
			if(!document.deleteForm.password.value){
				alert("비밀번호를 입력하지 않았습니다.");
				return false;
			}
		}
		
		
		
		
		
		function deleteMember(){
			//var pwd = document.
			if("<%= memPwd %>" == pwd){
				var val = confirm("정말로 탈퇴하시겠습니까?");
				
				if(val){
					$("#updateForm").attr("action", "<%= request.getContextPath()%>/memberDelete.mp");
					%("#updateForm").submit();
				}else {
					alert("취소하였습니다");
				}
			}else {
				alert("비밀번호를 잘못 입력하였습니다.");
			}
			
		}--%>
		
		
	</script>
</body>
</html>