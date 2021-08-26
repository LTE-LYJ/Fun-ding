<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@ include file ="views/common/menubar.jsp" %>
 
 <br><div>메인메뉴</div><br>
   <a href="<%=request.getContextPath()%>/viewAll.pr">프로젝트 모아보기 확인용 링크</a><br>
   <a href="<%=request.getContextPath()%>/writeCreator.pr">프로젝트 업로드 페이지 확인용 링크</a><br>
   <a href="<%=request.getContextPath()%>/mainPage">메인 페이지 확인용 링크</a><br>
   <a href="#" onclick="go()">상세페이지 확인용 링크-prjNum=1로 설정</a>
<a href="#" onclick="gofinish()">상세페이지 확인용 링크-prjNum=2로 설정</a>
 <%@ include file ="views/common/footer.jsp" %>
 <script type="text/javascript">
function go() {
	var num=1;
	location.href="<%=request.getContextPath()%>/proInfo.list?num="+num;
}
function gofinish() {
	var num=2;
	location.href="<%=request.getContextPath()%>/proInfo.list?num="+num;
}
	
</script>
</body>
</html>