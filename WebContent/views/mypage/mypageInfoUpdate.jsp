<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	
	
	String memId = (String)request.getAttribute("memId");
	String memName = (String)request.getAttribute("memName");
	String phone = (String)request.getAttribute("phone");
	String email = (String)request.getAttribute("email");
	String address = (String)request.getAttribute("address");
	
	//Member m = (Member)request.getAttribute("loginUser");

	//String memId = m.getMemId();
	//String memName = m.getMemName();
	//String phone = m.getPhone();
	//String email = m.getEmail();
	//String address = m.getAddress();
	
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
        }
        #uiBtn{
            margin-left: 360px;
            margin-top: 230px;
        }
        
    </style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

	<div class="mypageinfo">
	
<form id="updateForm" action="<%=request.getContextPath() %>/updateInfo.mp" method="post">
        <table class="mpInfotb">
            <tr>
            	<td><div id="profileImg"></div></td>
            	<td><input type="file" name="fileName" style="float: bottom;"></td>               
            </tr>
            <tr>
                <td>아이디</td>
                <td><input type="text" class="mpi" id="mpId" name="memId" value = "<%= memId %>" readonly></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" class="mpi" id="mpPwd" name="memName" value = "<%= memName %>" required></td>
            </tr>
            <tr>
                <td>연락처</td>
                <td><input type="text" class="mpi" id="mpPhone" name="phone" value = "<%= phone %>" required></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" class="mpi" id="mpEmail" name="email" value = "<%= email %>" required></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" class="mpi" id="mpAddress" name="address" value = "<%= address %>" required></td>
            </tr>
        </table>

		<button type="submit" id="uiBtn">확인</button>
</form>		
    </div>

	<div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>
		
	<script>
		function uiBtn(){
			alert("회원정보가 수정되었습니다.");
			
		}
	</script>
	
</body>
</html>