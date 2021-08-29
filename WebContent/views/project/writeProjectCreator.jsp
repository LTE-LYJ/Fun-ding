<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 올리기</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/writeProject.css">
<style>
	body{
		background: white;
	}
	main[role="main"] {
    margin: 20px 0 40px 200px;
  	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<main role="main">
	
		<section class="panel important">
			<h2>창작자 정보</h2>
			<form id="insertForm" action="writePlan.pr" method="post">
				<div class="twothirds">
					창작자 이름:<br>
					<input type="text" name="cname" id="cname" size="40" placeholder="이름을 입력해주세요."/><br>
					창작자 소개:<br>
					<textarea name="ccontent" id="ccontent" rows="15" cols="67" placeholder="창작자님의 이력과 소개를 써주세요."></textarea><br>
					<br>
					<div class="btnsPro" align="center">
						<button type="submit" class="btnPro" name="next" onclick="return check()">다음으로</button>
						<button type="button" class="btnPro" name="cancel" onclick="goMain()">취소하기</button>
					</div>
				</div>				
			</form>
		</section>	
	</main>
	
	<script>
		function goMain(){
			const result = confirm("업로드를 취소하시겠습니까?");
			
			if(result){
				location.href="<%=request.getContextPath()%>";
            }
		}

		function check(){
			const cname = document.getElementById("cname");
			const ccontent = document.getElementById("ccontent");

	        if(cname.value == "" || cname.value.length == 0){
                alert("창작자 이름은 필수 항목입니다.");
                cname.focus();
                return false;
            } else if(ccontent.value == "" || ccontent.value.length == 0){
                alert("창작자 소개는 필수 항목입니다.");
                ccontent.focus();
                return false;
            } else{
            	return true;
            }
	    }
	</script>
	
	<%@ include file="../common/footer.jsp" %>

</body>
</html>