<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   %>
    
<%

    //request.setCharacterEncoding("UTF-8"); /////////

	Member m = (Member)request.getAttribute("loginUser");
	ProfileAttachment atf = (ProfileAttachment)request.getAttribute("at");

	String memId = m.getMemId();
	//int memNo = m.getMemNo();
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
            
            margin-top: 230px;
        }

    </style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
<%@ include file = "../mypage/mypageMenubar.jsp" %>

	<div class="mypageinfo">
	
		<form action="profileImageUpdate.mp" method="post" enctype="multipart/form-data">
			<div class="image-section">
				<div class="img-area">
					<img id="image_section" src="<%=request.getContextPath() %>/resources/upfiles_profile/<%= at.getChangeName()%>" alt=""/>
						<label for="imgFile" class="del-button img-up">
							<input type="file" id="imgFile" name="imgFile" value=""/>업로드
						</label>
					<button class="up-button" type="submit">저장</button>
					<button class="del-button" onclick="delImg()" type="button">제거</button>
				</div>
			</div>
		</form>
	

	<form action="<%=request.getContextPath() %>/updateInfoOk.mp" method="post" id="infoForm" name="infoForm">
    
        <table class="mpInfotb">
            <!--<tr>
                <!--<td id="profileImg" name="proImg">
                <td>
	                <%--<%if(atf == null){ %>--%>
						<!--<img id="profileImage" src="<%--<%=request.getContextPath()%>--%>/resources/images/default.PNG" style="width:70px; height:70px;"> 
						<%--<%} else { %>--%>
						<img id="profileImage"  src="<%--<%=request.getContext가나다Path() %>--%>/resources/upfiles_profile/<%--<%= at.getChangeName()%>--%>" style="width:70px; height:70px;"> 
					<%--<%} %>--%>
				<!--</td>
                <td><input type="file" name="fileName" style="float: bottom;"></td>
            </tr>-->
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
		<div class="btns" align="center">
			<button type="submit" id="updateInfoBtn">회원정보 수정</button>
		</div>
	</form>
		
    </div>
    
    

	<div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>


<script>
	function readURL(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			
			reader.onload = function(e){
				$('#image_section').attr('src', target.result);
			}
			
			reader.readAsDataURL(input.files[0]);
		}
	}
	$('#imgFile').change(function(){
		readURL(this);
	});
	function delImg(){
		$('#image_section').removeAttr('src');
		$('#image_section').attr('src', '../resources/images/default.PNG');
	}
</script>
</body>
</html>













