<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member, com.kh.project_detail.model.vo.ProjectAsk"%>
<%
String msg = (String)request.getAttribute("msg");
String sTag = (String)request.getAttribute("sTag");
Member loginUser = (Member)session.getAttribute("loginUser");
ProjectAsk askDetail = (ProjectAsk)request.getAttribute("askDetail");
int askNum =(Integer)request.getAttribute("askNum");
int num =(Integer)request.getAttribute("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/projectDetailNewPop.css">
<script type="text/javascript">
var msg = "<%= msg %>";
var sTag = "<%= sTag %>";

$(function() {
	if(msg != "null"){
		alert(msg);
	} 
	
	if(sTag == "Y"){
		window.close();
	}
	
})
</script>
</head>
<body>
		<div class="outer" style="padding-top: 20px; padding-bottom: 20px">
		<div id="box_1" style="min-height: 310px">
        <h3 id="Ask_creater">창작자에게 문의하기</h3>
        <br>
        <form id="AskDetail"  action="<%=request.getContextPath() %>/delete.ask" method="post">
        <table>
            <tr>
                <th><h4 class="modal_n">작성자</h4></th>
                <td style="width: 375px;" colspan="3"><%=askDetail.getMemId() %></td>
            </tr>
             <tr>
             <td colspan="4"><hr></td>
             </tr>
             <tr>
                <th><h4 class="modal_n">작성일</h4></th>
                <td style="width: 375px;"><%=askDetail.getEnrollDate() %></td>
                <th><h4 class="modal_n">조회수</h4></th>
                <td style="width: 375px;"><%=askDetail.getCount() %></td>
            </tr>
             <tr>
             <td colspan="4"><hr></td>
             </tr>
            <tr>
                <th><h4 class="modal_n">문의 제목</h4></th>
                <td colspan="3"><%=askDetail.getPrjAskTitle() %></td>
            </tr>
             <tr>
             <td colspan="4"><hr></td>
             </tr>
            <tr>
                <th><h4 class="modal_n">문의 내용</h4></th>
                <td colspan="3"><%=askDetail.getPrjAskContent() %></td>
                <input type="hidden" id="askNum" name="askNum" value="<%=askNum  %>" style="border-left: none;"/>
                <input type="hidden" id="num" name="num" value="<%=num  %>" style="border-left: none;"/>
            </tr>
            <tr>
            </tr>
        </table>
        <%if(askDetail.getMemId().equals(loginUser.getMemId())){ %>
		<button id="AskBtn" style="background-color: background-color: rgb(192, 57, 43); cursor: pointer; margin-top: 0px" >삭제하기</button>
		<%}%>
		
        </form>
    </div>
    </div>
	<script type="text/javascript">
		$("#AskBtn").click(function() {
			if(confirm("삭제하시겠습니까?")){
				$("#AskDetail").submit();
				window.opener.location.reload();
			}
		})
	</script>
</body>
</html>