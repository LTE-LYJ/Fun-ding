<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/writeProject.css">
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<main role="main">
	
		<section class="panel important">
			<h2>창작자 정보</h2>
			<form id="insertForm" action="writePlan.pr" method="post">
				<div class="twothirds">
					창작자 이름:<br>
					<input type="text" name="cname" size="40" placeholder="이름을 입력해주세요."/><br>
					창작자 소개:<br>
					<textarea name="ccontent" rows="15" cols="67" placeholder="창작자님의 이력과 소개를 써주세요."></textarea><br>
					<br>
					<div class="btnsPro" align="center">
						<button type="submit" class="btnPro" name="next">다음으로</button>
						<button type="button" class="btnPro" name="cancel">취소하기</button>
					</div>
				</div>				
			</form>
		</section>	
	</main>
	
	<%@ include file="../common/footer.jsp" %>

</body>
</html>