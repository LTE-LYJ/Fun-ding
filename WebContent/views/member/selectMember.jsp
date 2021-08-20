<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kh.member.model.vo.Member" %>
<%@ page import = "com.kh.attachment.model.vo.ProfileAttachment" %>
<% 
	String memId = request.getParameter("memId");
	Member member = (Member)request.getAttribute("member");
	ProfileAttachment at = (ProfileAttachment)request.getAttribute("at");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
</head>
    <style>
     #title{
        margin-top: 70px;
        color:rgba(156, 228, 228);
        text-align: center;
        font-weight:bold;
        margin-bottom: 0px;
    }
   
   #wrap{
        display: flex;
        justify-content: center;
        align-items: center;
    }

    #box{
        margin: 40px;
        height:350px;
        width: 600px;
        border: 2px solid black;
    }

    #findPwd {
        margin-top:50px;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    table{
        margin-top: 50px;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    input {       
       padding:8px;
       width: 200px; 
    }

    img {
    	width:100px;
    	height: 100px;
        border-radius: 70%;
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
        <h1 style="line-height: 80px;">회원개인정보</h1>
    </div>

    <div id="wrap">
        <div id="box">
          
            <table border=1px frame=void>
                <tr>  
                <%if(at == null){ %>
					<th rowspan="4" style="width: 150px; "><img src="<%=request.getContextPath()%>/resources/images/default.PNG"></th> 
				<%} else { %>
				 	<th rowspan="4" style="width: 150px; "><img src="<%=request.getContextPath() %>/resources/upfiles_profile/<%= at.getChangeName()%>"></th>  
				<%} %> 
                    <td style="border: hidden;"rowspan="5"></td>        
                    <th><input id="userId" type="text" name="userId" value=<%= memId %> readonly></th>
                </tr>

                <tr>  
                    <!-- <th></th>-->
                    <!-- <td></td>-->
                    <th><input id="userName" type="text" name="userName" value=<%= member.getMemName() %> readonly></th>
                </tr>

                <tr>  
                     <!-- <th></th>-->
                     <!-- <td></td>-->
                    <th><input id="email" type="text" name="email" value=<%= member.getEmail() %> readonly></th>
                </tr>

                <tr>  
                    <!-- <th></th>-->
                    <!-- <td></td>-->
                    <th><input id="phone" type="text" name="phone" value=<%= member.getPhone() %> readonly></th>
                </tr>

               <tr>  
                    <th >프로필사진</th>
                    <!-- <td></td>-->
                    <th><input id="enrollDate" type="text" name="enrollDate" value=<%= member.getEnrollDate() %> readonly></th>
               </tr>
                
            </table>
            <br>
                <div class="btns" align="center">
                    <button id="close" onclick=window.close();>취소</button>&nbsp;&nbsp;&nbsp;&nbsp;
                   <button id="deleteBtn" type="button" onclick="deleteMember()">탈퇴</button>
                </div>
        </div>      
    </div>
	<script>
	function deleteMember() {
		var memId = $("#userId").val();
		location.href = "<%=request.getContextPath()%>/delete.me?memId="+ memId;
		opener.parent.location="<%=request.getContextPath()%>/memberList.bo"
		window.close();
		
	}
	</script>

</body>
</html>