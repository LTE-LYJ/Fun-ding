<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
   <style>
    body{
        min-width:865px;
    }

    #title{
        margin: 100px;;
        color:rgba(156, 228, 228);
        text-align: center;
       	font-size: 45px;
        font-weight:bold;
        margin-bottom: 0px;
    }

    #find{
        margin: 87px;
        margin-top:40px;
        display: flex;
        height:500px;
        justify-content: center;
        align-items: center;
    }

    #findBox{
        margin: 87px;
        margin-top:40px;
        height:350px;
        width: 600px;
        background-color: rgba(156, 228, 228, 0.253);
    }

    #findId {
        margin-top:40px;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    table{
        margin-top:80px;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    input {       
       padding:8px;
       width: 200px; 
    }

    button{
        background-color: white;
        border:black 1px solid;
        font-weight:bold;
        border-radius: 5px;
        width:70px;
        height:35px;
    }

    button:hover{ 
        background-color: rgb(31, 80, 126);
        color:white;
    }
    </style>
<body>
 <%@ include file ="../common/menubar.jsp" %>
	<div id="title">
        <h1 style="line-height: 80px;">아이디 찾기</h1>
    </div>

    <div id="find">
        <div id="findBox">
            <div id="findId"> </div>
            <table>
                <tr>
                    <th><input id="userName" type="text" name="userName" placeholder="Name"></th>
                </tr>
                <tr>  
                    <th><input id="email" type="email" name="email" placeholder="Email"></th> &nbsp;
                </tr>
            </table>
            <br><br>
                <div class="btns" align="center">
                    <button id="goMain" onclick="history.go(-1)">취소</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button id="confirmBtn" onclick="findId();">확인</button>
                </div> 
        </div>      
    </div>
     <%@ include file ="../common/footer.jsp" %>
</body>
<script>
	function findId() {
		var userName = $("#userName").val();
		var email = $("#email").val();
		
		$.ajax({
			url:"findId.me",
			data: {
				userName : userName,
				email : email
			},
			type:"post",
			success: function(result){
				console.log("ajax 통신 성공");
				$("#findId").text("회원님의 아이디는 " + result + " 입니다.");
				$("table").css("margin-top","55px");
			},
			error:function(e){
				$("#findId").text("ajax 통신 실패");
			}
		})
	}
</script>
</html>