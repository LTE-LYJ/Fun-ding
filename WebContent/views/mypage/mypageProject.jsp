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
	.prjOuter{
		margin-top: 200px;
		margin-left: 350px;
	}
	.prjwrap1{
		margin-bottom: 100px;
		overflow: auto;
        height: 300px;
        width: 700px;
	}
	.prjwrap2{
		height: 300px;
        width: 700px;
        border: 1px lightgray;
	}
    .prj1{
        
        border: 1px lightgray;
        
    }
    .prj2{
        overflow: auto;
        
    }
</style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

<div class="prjOuter">
	<div class="prjwrap1">
        <h3>진행 중인 프로젝트</h3>
        
        <table class="prjtb1" align="center">
        		
        	
				<%if(list.isEmpty()){ %>
				<tr>
					<td colspan="2">조회된 리스트가 없습니다.</td>
				</tr>
				<%}else{ %>
					<% for(Project p : list){ %>
					<tr>
						<td><input type="image" id="pri"></td>
						<td>
							<%= p.getPrjTitle() %><br>
							<input type="button" value="수정" onclick="goPrj();">
						</td>
						
					</tr>
					<%} %>
				<%} %>
		</table>
	</div>

	<!-- <div class="prjwrap2">
        <h3>종료된 펀딩</h3>
        
        <table class="prjtb2" align="center">
				<%--<%if(list.isEmpty()){ %>
				<tr>
					<td colspan="2">조회된 리스트가 없습니다.</td>
				</tr>
				<%}else{ %>
					<% for(Project p : list){ %>
					<tr>
						<td><input type="image"></td>
						<td>
							<%= p.getPrjTitle() %><br>
							<input type="button" value="수정" onclick="goupdate();">
							<input type="button" value="삭제" onclick="godelete();">
						</td>
						
					</tr>
					<%} %>
				<%} %>--%>
		</table>
    </div> -->
</div>

	<div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>
	<script>
		function godelete() {
			var pno=1;
			location.href="<%=request.getContextPath()%>/delete.pr?pno="+pno;
		}
		function goupdate() {
			var pno=2;
			location.href="<%=request.getContextPath()%>/updateCreator.pr?pno="+pno;
		}	
	</script>   
    
</body>
</html>