<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<style>
    body{
        min-width:865px;
    }
   
    #title{
        margin: 100px;
        text-align: center;
       	font-size: 70px;
        font-weight:bold;
        color:rgba(156, 228, 228);
        margin-bottom: 0px;
    }
  
    table {font-size: 12pt;}

    input {       
       padding:8px;
       width: 200px; 
    }

    #login{
        margin: 87px;
        margin-top:40px;
        display: flex;
        height:500px;
        justify-content: center;
        align-items: center;
    }

    #loginBox{
        margin: 87px;
        margin-top:40px;
        height:350px;
        width: 600px;
        background-color: rgba(156, 228, 228, 0.253);
    }

    table{
        margin-top:100px;
        margin-left:50px;
        display: flex;
        justify-content: center;
    }

    #loginBtn{
        background-color: white;
        border:black 1px solid;
        font-weight:bold;
        border-radius: 5px;
        width:60px;
        height:35px;
    }

    #loginBtn:hover{ 
        background-color: rgb(31, 80, 126);
        color:white;
    }
      
</style>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
 <%@ include file ="../common/menubar.jsp" %>
  		<div id="title">
            <h1 style="margin-bottom:0px;">login</h1>
        </div>
        
        <div id="login">
            <div id="loginBox">
            <form id="loginForm" action="<%=request.getContextPath()%>/login.me" method="post" onsubmit="return loginValidate();">
                <table>
                    <tr>
                        <th><input id="userId" type="text" name="userId" placeholder="ID"></th>
                        <th></th>
                    </tr>
                    
                    <tr>
                        <th><input id="userPwd" type="password" name="userPwd" placeholder="PASSWORD"></th> &nbsp;
                        <th><button id="loginBtn" type="submit">로그인</button></th>
                    </tr>
                    
                    <tr>
                        <td style="height:60px"><a href="">아이디 찾기</a> | <a href="">비밀번호 재설정</a></td>
                        <th></th>
                     </tr>
                </table>
            </form> 
            </div>      
        </div>
</body>
</html>