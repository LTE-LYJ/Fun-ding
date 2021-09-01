<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList" %>
<%
	ArrayList<Project> list = (ArrayList<Project>)request.getAttribute("listMyPro");
	ArrayList<Project> listClose = (ArrayList<Project>)request.getAttribute("listClose");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 프로젝트 내역</title>
<style>	
	.prjOuter{
		margin-top: 200px;
		margin-left: 350px;
	}
	.prjwrap1{
		margin-bottom: 100px;
		overflow: auto;
        width: 800px;
	}
	.prjwrap2{
		width: 100%;
        border: 1px lightgray;
	}
    .prj1{
        
        border: 1px lightgray;
        
    }
    .prj2{
        overflow: auto;
        
    }
    .prjBox {
		width: 600px;
		height: 100px;
		order-radius: 15px;
		display: inline-block;
		margin-top: 20px;
		margin-left: 20px;
		margin-bottom: 20px;
		position: relative;
		border:solid 2px lightgray;
		border-radius: 10px;
		overflow: hidden;
		text-align: center;
		padding: 30px 0px 0px 0px;
	}
</style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

<div class="prjOuter">
	<div class="prjwrap1">
        <h3>진행 중인 프로젝트</h3>
        
        <%if(list.isEmpty()){ %>
	        <div class="prjBox">
	        	조회된 리스트가 없습니다.
			</div>
		<%}else{ %>
			<% for(Project p : list){ %>
				<div class="prjBox">
					<%= p.getPrjTitle() %><br><br>
					<input type="button" value="수정" onclick="goupdate(<%= p.getPrjNo() %>);">
					<input type="button" value="삭제" onclick="godelete(<%= p.getPrjNo() %>);">
				</div>
			<%} %>
		<%} %>
	</div>

	<div class="prjwrap2">
        <h3>종료된 프로젝트</h3>
        
        <%if(listClose.isEmpty()){ %>
			<div class="prjBox">
				조회된 리스트가 없습니다.
			</div>
			<%}else{ %>
				<% for(Project p : listClose){ %>
					<div class="prjBox">
						<%= p.getPrjTitle() %><br><br>
						<% if(p.getPrjTarget() - p.getPrjCurrent() < 0) { %>
							<input type="button" value="달성">
						<% } else { %>
							<input type="button" value="미달성">
						<% } %>
					</div>
				<%} %>
			<%} %>
    </div>
</div>

	<div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>
	<script>
		function godelete(pno) {
			location.href="<%=request.getContextPath()%>/delete.pr?pno="+pno;
		}
		function goupdate(pno) {
			location.href="<%=request.getContextPath()%>/updateCreator.pr?pno="+pno;
		}	
	</script>   
    
</body>
</html>