<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
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
        width: 500px;
        border: 1px solid black;
        background-color:white;
    }


    table{
        margin-top: 40px;
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
	<div id="title">
        <h1 style="line-height: 80px;">아이디 찾기</h1>
    </div>
    <div id="find">
        <div id="findBox">
            <table>
                <tr>
                    <th><input id="userName" type="text" name="userName" placeholder="Name"></th>
                </tr>
                <tr>  
                    <th><input id="email" type="email" name="email" placeholder="Email"></th> 
                </tr>
            </table>
            <br>
                <div class="btns" align="center">
                    <button id="close" onclick=window.close();>취소</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button id="confirmBtn" onclick="findId();">확인</button>
                </div> 
        </div>      
    </div>
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
				//console.log(result);
				
				if(result.length == 0 ){
					alert("일치하는 회원정보가 없습니다.")
				


                }else {
                	alert("회원님의 아이디는 " + result + " 입니다.")
					
				}
				
			},
			error:function(e){
				$("#findId").text("ajax 통신 실패");
			}
		})
	}
</script>
</html>