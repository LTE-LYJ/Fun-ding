<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/projectDetailNewPop.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
</head>
<body>
		<div class="outer">
		<div id="box_1">
        <h3 id="Ask_creater">창작자에게 문의하기</h3>
        <br>
        <form>
        <table>
            <tr>
                <th><h4 class="modal_n">받는 사람</h4></th>
                <th><textarea class="modal_con" cols="50" rows="1" readonly>창작자1</textarea></th>
            </tr>
            <tr>
                <th><h4 class="modal_n">문의 제목</h4></th>
                <th><textarea class="modal_con" cols="50" rows="1"></textarea></th>
            </tr>
            <tr>
                <th><h4 class="modal_n">문의 내용</h4></th>
                <th><textarea class="modal_con" cols="50" rows="6" placeholder="프로젝트 진행자에게 말하고 싶은 내용을 적어주세요!"></textarea></th>
            </tr>
        </table>
       
		<button type="submit" id="AskBtn">뮨의하기</button>
        </form>
    </div>
    </div>
</body>
</html>