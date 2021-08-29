<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   %>
    
<%
	//request.setCharacterEncoding("UTF-8");

	Member m = (Member)request.getAttribute("loginUser");

	String memId = m.getMemId();
	String memName = m.getMemName();
	String phone = m.getPhone();
	String email = m.getEmail();
	String address = m.getAddress();
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .mpInfotb{
            /*text-align: center;*/
            position: relative;
            left: 300px;
            top: 200px;
        }
        #profileImg{
            width: 90px;
            height: 90px;
            background-color: lightgray;
            margin-bottom: 20px
        }
        td{
            height: 50px;
            width: 70px;
        }
        .mpi{
            width: 200px;
            height: 20px;    
        }
        .mpInfotb{
        	font-size: 20px
        }
        button{
        	background-color: rgb(70, 155, 224);
        	color: white;
        	border-radius: 5px;
        	width: 110px;
        	height: 30px;
        	/*border: 3px gray;*/
        }
        button:hover{
        	background-color: blue;
        	cursor: pointer;
        }
        #updateInfoBtn{
            margin-left: 360px;
            margin-top: 230px;
        }
        
        
    </style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
<%@ include file = "../mypage/mypageMenubar.jsp" %>

	<div class="mypageinfo">

	<form action="views/mypage/mypageInfoUpdateFix.jsp" method="post" id="infoForm" name="infoForm">
    
        <table class="mpInfotb">
            <caption>
                <div id="profileImg"></div>
            </caption>
            <tr>
                <td>아이디</td>
                <td><input type="text" class="mpi" id="mpId" name="memId" value = "<%= memId %>" readonly></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" class="mpi" id="mpPwd" name="memName" value = "<%= memName %>" readonly></td>
            </tr>
            <tr>
                <td>연락처</td>
                <td><input type="text" class="mpi" id="mpPhone" name="phone" value = "<%= phone %>" readonly></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" class="mpi" id="mpEmail" name="email" value = "<%= email %>" readonly></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" class="mpi" id="mpAddress" name="address" value = "<%= address %>" readonly></td>
            </tr>
        </table>

		<button type="button" id="updateInfoBtn" onclick="updateInfo();">회원정보 수정</button>
		&nbsp;
        <button type="button" id="updatePwdBtn" onclick="updateBtn();">비밀번호 변경</button>
	
	</form>
		
    </div>
    
    <script>
    	function updateInfo(){
    		
    		location.href="<%=request.getContextPath() %>/updateInfo.mp";
    		
    	}
    	function updateBtn(){
    		location.href="views/mypage/mypageInfoUpdatePwd.jsp";
    	}
    </script>

	<div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>

</body>
</html>