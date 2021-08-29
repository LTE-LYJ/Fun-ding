<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <style>
    body {background-color:azure;}
    
     #title{
        margin: 30px;
        text-align: center;
        font-weight:bold;
        margin-bottom: 0px;
    }
   
   #find{
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 10px;
        
    }

    #findBox{
        margin: 60px;
        margin-top: 10px;
        height:200px;
        width:500px;
        border: 1px solid black;
        background-color:white;
    }


    #findPwdtable{
     	margin-top: 20px;
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
</head>
<body>
    <div id="title">
        <h1 style="line-height: 80px;">비밀번호 찾기</h1>
    </div>

    <div id="find">
        <div id="findBox">
            <table id="findPwdtable">
                <tr>  
                    <th><input id="userId" type="text" name="userId" placeholder="ID"></th>&nbsp;
                   
                </tr>
                <tr>
                    <th><input id="userName" type="text" name="userName" placeholder="Name"></th>
                   
                </tr>
            </table>
            <br>
                <div class="btns" align="center">
                    <button id="close" onclick=window.close();>취소</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button id="confirmBtn" onclick="findPwd();">확인</button>
                </div>
        </div>      
    </div>
</body>
<script>
	function findPwd() {
		var userId = $("#userId").val();
		var userName = $("#userName").val();
		
		$.ajax({
			url:"findPwd.me",
			data: {
				userId : userId,
				userName : userName
			},
			type:"post",
			success: function(result){
				console.log("ajax 통신 성공");
				
				var pwd = "";
				
				if(result.length == 0 ){
					alert("일치하는 회원정보가 없습니다.")
					
				} else {
					for(var i= 0; i<2; i++){
						pwd += result.charAt(i);
					}
					
					for(var i=2; i<result.length;i++){
						pwd += '*';
					}
					alert("회원님의 비밀번호는 " + pwd + " 입니다.")
				}
				
			},
			error:function(e){
				$("#findPwd").text("ajax 통신 실패");
			}
		})
	}
	
	  // 엔터 클릭이벤트 연결
    $("#userName").keydown(function(keyNum){
    	if(keyNum.keyCode == 13) {
    		$("#confirmBtn").click();
    	}
    });
</script>
</html>