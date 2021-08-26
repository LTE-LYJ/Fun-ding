<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member, com.kh.project.model.vo.Project"%>
<%
String msg = (String)request.getAttribute("msg");
String sTag = (String)request.getAttribute("sTag");
Member loginUser = (Member)session.getAttribute("loginUser");
int num = Integer.parseInt(request.getParameter("num"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/projectDetailNewPop.css">
</head>
<body>
		<div class="outer">
		<div id="box_1">
        <h3 id="Ask_creater">창작자에게 문의하기</h3>
        <br>
        <form id="AskForm" action="<%=request.getContextPath()%>/insert.ask" method="post">
        <table>
            <tr>
                <th><h4 class="modal_n">받는 사람</h4></th>
                <th><textarea class="modal_con" cols="50" rows="1" readonly name="creator"><%=loginUser.getMemId() %> </textarea></th>
            </tr>
            <tr>
                <th><h4 class="modal_n">문의 제목</h4></th>
                <th><textarea class="modal_con" cols="50" rows="1" name="title" >문의합니다!</textarea></th>
            </tr>
            <tr>
                <th><h4 class="modal_n">문의 내용</h4></th>
                <th><textarea class="modal_con" cols="50" rows="6" placeholder="프로젝트 진행자에게 말하고 싶은 내용을 적어주세요!" name="content" id="content" maxlength="300"></textarea></th>
            </tr>
            <tr>
                <th><input type="hidden" name="num" value="<%=num%>"></th>
                <th> <input type="text" placeholder="글자 수" id="textLengthCheck" style=" float: right; border: none; text-align:right;"/><th>
            </tr>
        </table>
		<button id="AskBtn" onclick="checktrim()" style="clear: both; margin-top: 5px">뮨의하기</button>
        </form>
    </div>
    </div>
    <script type="text/javascript">
    function checktrim() {
		var title = $("textarea[name='title']").val();
		var content = $("textarea[name='content']").val();
		
		if(title.trim() ==""||content.trim()==""){
			alert("내용을 입력해주세요!");
			return false;
		}
	
		$("#AskForm").submit();
		window.opener.location.reload();
	}
    
	$("#content").keyup(function(e) {
		var content = $(this).val();
		$("#textLengthCheck").val("(" + content.length + "/ 300)"); // 카운팅
		if(content.length > 300) {
			alert("최대 300자까지 입력 가능합니다.");
			$(this).val(content.substring(0, 300)); // 넘친 글자 지우기
			$('#textLengthCheck').val("(300 / 최대 300자)");
			$("#content").focus();
		}
	});
    </script>
</body>
</html>