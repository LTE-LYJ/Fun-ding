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
       	font-size: 40px;
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
<title>로그인</title>
</head>
<body>
 <%@ include file ="../common/menubar.jsp" %>
  		<div id="title">
            <h1 style="margin-bottom:0px;">login</h1>
        </div>
        
        <div id="login">
            <div id="loginBox">
            <form id="loginForm" action="<%=request.getContextPath()%>/login.me" method="post"  onsubmit="return loginValidate();">
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
                        <td style="height:60px"><a href="#" onclick="findId();">아이디 찾기</a> | <a href="#" onclick="findPwd();">비밀번호 찾기</a></td>
                        <th></th>
                     </tr>
                </table>
                <script>
                
                var popHeight = 430;    // 띄울 팝업창 높이                                    
                var popWidth = 600;     // 띄울 팝업창 너비                                  

                var winHeight = document.body.clientHeight;	  // 현재창의 높이
                var winWidth = document.body.clientWidth;	  // 현재창의 너비

                var winX = window.screenLeft;	// 현재창의 x좌표
                var winY = window.screenTop;	// 현재창의 y좌표
                	
                var popX = winX + (winWidth - popWidth)/2;
                var popY = winY + (winHeight - popHeight)/2;
                
                	function findId(){
                		window.open("<%=request.getContextPath()%>/findIdForm.me", "아이디 찾기",  "top="+popY+", left="+popX+",width="+popWidth+",height="+popHeight+", scrollbars=yes,resizable=yes");
                	}
                	
                	function findPwd() {
                		window.open("<%=request.getContextPath()%>/findPwdForm.me", "비밀번호 찾기", "top="+popY+", left="+popX+",width="+popWidth+",height="+popHeight+", scrollbars=yes,resizable=yes");
                	}
               
                // 엔터 클릭이벤트 연결
                $("#userPwd").keydown(function(keyNum){
                	if(keyNum.keyCode == 13) {
                		$("#loginBtn").click();
                	}
                });
                
                function loginValidate() {
                    if($("#userId").val().trim().length == 0){
                       alert("아이디를 입력하세요");
                       $("#userId").focus();
                       return false;
                    }
                    if($("#userPwd").val().trim().length == 0){
                       alert("비밀번호를 입력하세요");
                       $("#userPwd").focus();
                       return false;
                    }
                    return true;
                 }
               
                </script>
            </form> 
            </div>      
        </div>
        <%@ include file ="../common/footer.jsp" %>
</body>
</html>