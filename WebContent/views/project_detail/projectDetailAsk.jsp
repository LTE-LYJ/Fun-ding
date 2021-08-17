<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.project_detail.model.vo.ProjectAsk"%>
<%

ArrayList<ProjectAsk> askList = (ArrayList<ProjectAsk>)request.getAttribute("askList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="projectDetailView.jsp"/>
	        <div id="body_content2">
            <div id="body">
                    <div id="box">
            <table class="listArea">
			<thead>
				<tr>
					<th class="table1">글번호</th>
					<th class="table2">글제목</th>
					<th class="table3">작성자</th>
					<th class="table4">작성일</th>
					<th class="table5">조회수</th>
				</tr>
			<thead>
			<tbody>
               <%-- <tr>
                    <td class="table1" >4</td>
                    <td class="table2">아니 정말 개소리를 파시는 건가요? 아니 제가 정말 개소리인줄아니 정말 개소리를 파시는 건가요? 아니 제가 정말 개소리인줄</td>
                    <td class="table3">후원자11</td>
                    <td class="table4">2021.07.31</td>
                    <td class="table5">1</td>
                </tr>
                <tr>
                    <td class="table1">3</td>
                    <td class="table2">쿠로 콘서트 부탁드립니다.</td>
                    <td class="table3">쿠로극성팬1</td>
                    <td class="table4">2021.07.29</td>
                    <td class="table5">25</td>
                </tr>
                <tr>
                    <td class="table1">2</td>
                    <td class="table2">포토카드 선택할수 없나요?</td>
                    <td class="table3">크n</td>
                    <td class="table4">2021.07.28</td>
                    <td class="table5">1</td>
                </tr>
                <tr>
                    <td class="table1">1</td>
                    <td class="table2">쿠로 콘서트 부탁드립니다.</td>
                    <td class="table3">쿠로지구뿌셔</td>
                    <td class="table4">2021.07.22</td>
                    <td class="table5">5</td>
                </tr>--%>
                  <% if(askList.isEmpty()){ %>
				 	<tr>
						<td colspan="5">존재하는 공지사항이 없습니다.</td>
					</tr>
				 <% }else{  %>
				 	<% for(ProjectAsk n : askList){ %>
				 		<tr>
				 			<td class="table1"><%= n.getPrjAskNo() %></td>
							<td class="table2"><%= n.getPrjAskTitle() %></td>
							<td class="table3"><%= n.getMemId() %></td>
							<td class="table4"><%= n.getCount() %></td>
							<td class="table5"><%= n.getEnrollDate() %></td>
				 		</tr>
				 	<% } %>
				 <% } %>
			</tbody>
		</table>
        <button type="button" id="btn_ask" onclick="wirteAsk()">문의하기</button><br style="float: none;">
                    </div>
                </div>
            </div> 
                    <%@ include file="../common/footer.jsp" %>
         <script>
            function wirteAsk() {
            	window.open("<%=request.getContextPath()%>/writeAsk.de", "문의쓰기", "top=100px, left=300px, height=430px, width=600px, resizable=no");
			}
            $('#proInfo').click(function() {
		    	location.href="<%=request.getContextPath()%>/proInfo.list";
			});
		    $('#proReview').click(function() {
		    	location.href="<%=request.getContextPath()%>/proReview.list";
			});
		    $('#proAsk').click(function() {
		    	location.href="<%=request.getContextPath()%>/proAsk.list";
			});
         </script>
</body>
</html>