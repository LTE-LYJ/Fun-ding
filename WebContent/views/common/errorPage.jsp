<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	String message = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align ="center"><%= message %></h1>

      <%
    String msg = (String)request.getAttribute("msg");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align ="center"><%= msg%></h1>
	<div align = "center">
		<button onclick="location.href='<%= request.getContextPath()%>/views/common/menubar.jsp'" style="width:50%;">홈으로 돌아가기</button>
	</div>

</body>
</html>