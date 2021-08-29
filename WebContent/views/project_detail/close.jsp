<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/projectDetailNewPop.css">
</head>
<body>
	<div class="outer" style="height: 400px">
		<div id="box_1" style="height: 300px">
			<h3 id="Ask_creater">창작자에게 문의하기</h3>
			<br>
			<table>
			    <tr>
			        <th><h2 class="modal_n" style="width: 500px; color: red; margin-top: 50px; margin-bottom: 70px; text-align: center">해당 게시글이 성공적으로 삭제 되었습니다.</h2></th>
			        <td style="width: 375px;" colspan="3"></td>
			    </tr>
			</table>
			 <button id="AskBtn" style="background-color: background-color: rgb(192, 57, 43); cursor: pointer;">완료</button>
		</div>
	</div>
	<script type="text/javascript">
		$("#AskBtn").click(function() {
			window.close();
		})
	
		window.onload = function(){

			window.close();

		}
	</script>
</body>
</html>