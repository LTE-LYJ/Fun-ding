<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList, com.kh.project.model.vo.Project" %>
<%
	ArrayList<Project> list = (ArrayList<Project>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>	
    .prj1{
        overflow: auto;
        height: 300px;
        width: 700px;
        border: 1px lightgray;
    }
    .prj2{
        overflow: auto;
        height: 300px;
        width: 700px;
        border: 1px lightgray;
    }
</style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

	<div class="prjwrap">
        <h3>진행 중인 프로젝트</h3>
        
        <table class="prjtb1" align="center">
				<%if(list.isEmpty()){ %>
				<tr>
					<td colspan="2">조회된 리스트가 없습니다.</td>
				</tr>
				<%}else{ %>
					<% for(Project p : list){ %>
					<tr>
						<td></td>
						<td><%= p.getPrjTitle() %></td>
						<td>
							<input type="button" value="수정" onclick="goPrj();">
							
						</td>
					</tr>
					<%} %>
				<%} %>
		</table>
	</div>

	<div class="prjwrap">
        <h3>종료된 펀딩</h3>
        
        <table class="prjtb2" align="center">
				<%if(list.isEmpty()){ %>
				<tr>
					<td colspan="2">조회된 리스트가 없습니다.</td>
				</tr>
				<%}else{ %>
					<% for(Project p : list){ %>
					<tr>
						
						<td><%= p.getPrjTitle() %></td>
						<td><input type="text" id="stausPrj" readonly></td>
						
					</tr>
					<%} %>
				<%} %>
		</table>
    </div>
    
<script>
	function goPrj(){
		
	}
</script>    
    
</body>
</html>