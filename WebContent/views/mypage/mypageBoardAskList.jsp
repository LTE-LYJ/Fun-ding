<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList"%>
<%
	ArrayList<Project_ask> list = (ArrayList<Project_ask>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 문의게시판</title>
<style>
	.bmwrap{
		margin-left: 400px;
		margin-top: 170px;
		margin-bottom: 300px;
	}
    #bmtb{
        border-collapse: collapse;
        width: 900px;
        border-bottom: 1px gray;
    }
	td {
		cursor: pointer;
	}
    #bmtb> tbody> tr{
        text-align: center;
        height: 35px;
    }
    #bmtb> thead> tr{
        text-align: center;
        height: 50px;
    }
    #tr1{
        background-color: rgb(154, 184, 196);
    }
    #td1{
        width: 10%;
    }
    #td2{
        width: 60%;
    }
    #td3{
        width: 15%;
    }
    #td4{
        width: 15%;
    }
</style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

    <div class="bmwrap">
        <h2 style="margin-bottom: 100px;">문의게시판</h2>

        <div valgn="top" colspan="3" style="margin-left: 810px;">
       		<select name="search" onchange="window.location.href=this.value">
       			<option value="">게시판선택</option>
       			<option value="<%= request.getContextPath()%>/boardMainList.mp">자유게시판</option>
       			<option value="<%= request.getContextPath()%>/boardAskList.mp" >문의게시판</option>
       			<option value="<%= request.getContextPath()%>/boardReportList.mp">신고게시판</option>
       		</select>
       	</div>
        <br>
        <table id="bmtb">
        	<thead>
	            <tr id="tr1">
	                <td id="td1">번호</td>
	                <td id="td2">제목</td>
	               
	                <td id="td4">작성일</td>
	            </tr>
            </thead>

            <tbody>

	             <%if(list.isEmpty()){ %>
				<tr>
					<td colspan="4">조회된 리스트가 없습니다.</td>
				</tr>
				<%}else{ %>
					<% for(Project_ask p : list){ %>
					<tr onclick="onItemClick(<%= p.getPrjAskNo() %>, <%= p.getPrjNo() %>)">
						<td><%= p.getPrjAskNo() %></td>
						<td><%= p.getPrjAskTitle() %></td>
						
						<td><%= p.getEnrollDate() %></td>
					</tr>
					<%} %>
				<%} %>

            </tbody>
        </table>
    </div>

    <div class="pagingArea" align="center">
		<!-- 맨 처음으로 (<<) -->
		<button onclick="location.href='<%=contextPath%>//boardAskList.mp?currentPage=1'"> &lt;&lt; </button>

		<!-- 이전페이지로(<) -->
		<%if(currentPage == 1){ %>
		<button disabled> &lt; </button>
		<%}else{ %>
		<button onclick="location.href='<%= contextPath %>//boardAskList.mp?currentPage=<%= currentPage-1 %>'"> &lt; </button>
		<%} %>

		<!-- 페이지 목록 -->
		<%for(int p=startPage; p<=endPage; p++){ %>

			<%if(p == currentPage){ %>
			<button disabled> <%= p %> </button>
			<%}else{ %>
			<button onclick="location.href='<%=contextPath %>//boardAskList.mp?currentPage=<%= p %>'"> <%= p %> </button>
			<%} %>

		<%} %>

		<!-- 다음페이지로(>) -->
		<%if(currentPage == maxPage){ %>
		<button disabled> &gt; </button>
		<%}else { %>
		<button onclick="location.href='<%= contextPath %>//boardAskList.mp?currentPage=<%= currentPage+1 %>'"> &gt; </button>
		<%} %>

		<!-- 맨 끝으로 (>>) -->
		<button onclick="location.href='<%=contextPath%>//boardAskList.mp?currentPage=<%=maxPage%>'"> &gt;&gt; </button>

    </div>

    <div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>

	<script>
		function onItemClick(no, projectNum) {
			window.open("<%=request.getContextPath()%>/detail.prjPop?askNum="+no +"&num="+projectNum, "문의", "top=100px, left=300px, height=430px, width=600px, resizable=no");
		}
	</script>
</body>
</html>
