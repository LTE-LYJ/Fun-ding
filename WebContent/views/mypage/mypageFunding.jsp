<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
    List<Project> running = (List<Project>) request.getAttribute("running");
    List<Project> closed = (List<Project>) request.getAttribute("closed");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 펀딩 내역</title>
    <style>
        .fdOuter {
            margin-top: 200px;
            margin-left: 350px;
        }

        .fd1 {
            margin-bottom: 100px;
            border: 1px lightgray;
        }

        .fd2 {
            border: 1px lightgray;
        }

        .fd1 {
            overflow: auto;
            border: 1px lightgray;
        }

        .fd1 {
            overflow: auto;
            border: 1px lightgray;
        }
    </style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

<div class="fdOuter">
    <div class="fdwrap">
    
        <h3>진행 중인 펀딩</h3>

        <div class="fd1">
            <table class="fdtb1" align="center">
				<%if (running.isEmpty()) { %>
				<h3>조회된 리스트가 없습니다.</h3>
				<%} else { %>
				<%
					for (int i = 0; i < running.size(); i++) {
				%>
				<jsp:include page="mypageFundingForm.jsp" flush="true">
					<jsp:param name="listName" value="running"/>
					<jsp:param name="index" value="<%= i %>"/>
				</jsp:include>
				<%} %>
				<%} %>
            </table>
        </div>

        <div class="fd2">
        
            <h3>종료된 펀딩</h3>
            
            <table class="fdtb2" align="center">
                <%if (closed.isEmpty()) { %>
                <h3>조회된 리스트가 없습니다.</h3>
                <%} else { %>
                <%
                    for (int i = 0; i < closed.size(); i++) {
                %>
                
                <jsp:include page="mypageFundingForm.jsp" flush="true">
                    <jsp:param name="listName" value="closed"/>
                    <jsp:param name="index" value="<%= i %>"/>
                </jsp:include>
                
                <%} %>
                <%} %>
            </table>
        </div>
    </div>

</div>

<div class="ft" style="margin-top: 200px;">
    <%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>
