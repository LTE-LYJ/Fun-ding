<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList, com.kh.project.model.vo.Project" %>
<%
	ArrayList<Project> list = (ArrayList<Project>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<%
	
%>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>	
    .fd1{
        overflow: auto;
        height: 300px;
        width: 700px;
        border: 1px lightgray;
    }
    .fd1{
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

	<div class="fdwrap">
        <h3>진행 중인 펀딩</h3>
        
        <div class="fd1">
            <!--
            <div id="temp1"></div>
            <div id="temp2"></div>
            <div id="temp3"></div>-->
            <table class="fdtb1" align="center">
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
							<input type="button" value="수정" onclick="goFd();">
							
						</td>
					</tr>
					<%} %>
				<%} %>
			</table>
        </div>

        <h3>종료된 펀딩</h3>
        
        <div class="fd2">
            
            <!-- <div id="temp4">
            	<div class="fdp" style="background-color: gray; width:50px; height: 50px;"></div>
                <div id="st">상태</div>
            </div> -->
            <table class="fdtb2" align="center">
				<%if(list.isEmpty()){ %>
				<tr>
					<td colspan="2">조회된 리스트가 없습니다.</td>
				</tr>
				<%}else{ %>
					<% for(Project p : list){ %>
					<tr>
						
						<td><%= p.getPrjTitle() %></td>
						<td><input type="text" id="stausFd" readonly></td>
						
					</tr>
					<%} %>
				<%} %>
			</table>
        </div>
    </div>
    
    <div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>