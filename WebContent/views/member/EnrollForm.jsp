<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<style>
    body{
        min-width:865px;
    }

    #title{
        margin: 100px;;
        color:rgba(156, 228, 228);
        text-align: center;
       	font-size: 38px;
        font-weight:bold;
        margin-bottom: 0px;
    }
    
    #wrap{
     	display: flex;
        justify-content: center;
        align-items: center;
        width:100%;
    }
  
    #enroll{
        margin: 87px;
        margin-left: 100px;
        margin-top:40px;
        display: flex;
        justify-content: center;
        align-items: center;
       	background-color: rgba(156, 228, 228, 0.253);
       	width:800px;
        height:500px;
    }

    table {
        font-size: 12pt;
        border-collapse:collapse;
    }

    input {       
       padding:8px; 
       width:250px;
    }

    #enrollForm th:nth-child(1){
        width:200px;
    }

    #enrollForm th:nth-child(2){
        width:150px;
     
    }  
		
		
    #enrollForm th:nth-child(3){
        width:150px;
        text-align:left;
    }
 
    #profilImg {
    	float: right;
    	margin-right: 40px;
    	margin-top: 5px;
    	border-radius: 70%;
	}
   
    button{
        background-color: white;
        border:black 1px solid;
        font-weight:bold;
        border-radius: 5px;
        width:80px;
        height:30px;
    }

    button:hover{ 
        background-color: rgb(31, 80, 126);
        color:white;
    }
   
   
</style>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
 <%@ include file ="../common/menubar.jsp" %>
        <div id="title">
            <h1 style="line-height: 80px;">Welcome to fund-ing</h1>
        </div>
        <div id="wrap">
            <div id="enroll">
                <form id="enrollForm" action="<%=request.getContextPath()%>/insert.me" method="post" onsubmit="return joinValidate();" enctype="multipart/form-data">
                <table border=3px >
                    <tr>
                        <th rowspan="5"><img id="profilImg" width= "120" height= "120"></th>
                        <th><input type="text" maxlength="13" name="userId" placeholder="ID" required></th>
                        <th style= "border-top: none; border-bottom: none; border-left: none; border-right: none;">
                            &nbsp; <button type="button" id="idCheckBtn" onclick="checkId();">중복확인</button>
                        </th>
                    </tr>
                    <tr>
                        <!--<td></td>-->
                        <th><input type="password" maxlength="15" name="userPwd" placeholder="PWD" required></th>
                        <th style= "border-top: none; border-bottom: none; border-left: none; border-right: none;"></th>
                    </tr>
                    <tr>
                         <!--<td></td>-->
                        <th><input type="password" maxlength="15" name="checkPwd" required placeholder="PWD Check"></th>
                        <th style= "border-top: none; border-bottom: none; border-left: none; border-right: none;"><label id = "pwdResult"></label></th>
                    </tr>	
                    <tr>
                         <!--<td></td>-->
                        <th><input type="text" maxlength="5" name="userName" required placeholder="Name"></th>
                        <th style= "border-top: none; border-bottom: none; border-left: none; border-right: none;"></th>
                    </tr>
                    <tr>
                         <!--<td></td>-->
                        <th><input type="tel" maxlength="13" name="phone" placeholder="Phone" required></th>
                        <th style= "border-top: none; border-bottom: none; border-left: none; border-right: none;"></th>
                    </tr>
                    <tr>
                        <th rowspan="2"> 프로필 사진</th>
                        <th><input type="email" name="email" required placeholder="Email"></th>
                        <th style= "border-top: none; border-bottom: none; border-left: none; border-right: none;"></th>
                    </tr>
                    <tr>
                        <!--<td></td>-->
                        
                    <c:forTokens var="addr" items="${ loginUser.address }" delims="/" varStatus="status">
						<c:if test="${ status.index eq 1 }">
							<c:set var="address1" value="${ addr }"/>
						</c:if>
					</c:forTokens>
                        <th>
							<input type="text" id='address'  name="address1" class="form-control postcodify_address" value="${ address1 }"  placeholder="Address">   
						</th>  
						                   
                        <th style="text-align:left; border-top: none; border-bottom: none; border-left: none; border-right: none;"> 
                             &nbsp;<button type="button" class="btn btn-primary" id="postcodify_search_button" style=" width:50px;">검색</button>
                        </th>
                    </tr>
                </table>
                <!-- 상세주소 검색 api -->
                <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
				<script>
					// 검색 단추를 누르면 팝업 레이어가 열리도록 설정한다.
					$(function(){
						$("#postcodify_search_button").postcodifyPopUp();
					});
				</script>
				
				<!-- 프로필 이미지 -->
                <div id="imgArea">
                    <input type="file" name="file1" id ="file1" onchange="loadImg(this)">
                </div>
                <br><br>
                <div class="btns" align="center">
                    <button type="button" id="goMain" onclick="main()">취소</button>&nbsp;&nbsp;&nbsp;&nbsp;

                    <button type="submit" id="joinBtn" disabled>가입</button>
                </div>
                </form>
            </div>
          </div>
           <%@ include file ="../common/footer.jsp" %>
</body>
<script>
	//프로필 사진 등록
	$(function() {
		$("#imgArea").hide();

		$("#profilImg").click(function() {
			$("#file1").click();
		})
	})

	function loadImg(inputFile) {
		if (inputFile.files.length == 1) {
			var reader = new FileReader();
			reader.readAsDataURL(inputFile.files[0]);

			reader.onload = function(e) {
					$("#profilImg").attr("src", e.target.result);
			}
		}
	}
	
	function main() { //취소버튼 클릭시 메인페이지 이동
		  location.href="<%=request.getContextPath()%>";
	}
	
	
	
	function joinValidate(){
		
		//아이디가 영어로 시작하고 4~11자리수인지 확인
		if(!(/^[a-z][a-z\d]{3,11}$/i.test($("#enrollForm input[name=userId]").val()))){
			$("#enrollForm input[name=userId]").focus();
	        return false;
		}
		
		//비밀번호, 비밀번호 확인이 일치하는지 확인
		if($("#enrollForm input[name=userPwd]").val() != $("#enrollForm input[name=checkPwd]").val()){
			console.log("불일치")
			$("#pwdResult").text("비밀번호 불일치").css("color", "red");
			$("#pwdResult").select();
			return false;			
		}
		//이름이 한글로 2글자 이상인지 확인 
		 if(!(/^[가-힣]{2,}$/.test($("#enrollForm input[name=userName]").val()))){
			 $("#enrollForm input[name=userName]").focus();
	        return false;
		 }
		 
		 return true;
	}
	
	// 전화번호 자동 (-) 추가
	$("#enrollForm input[name=phone]").on("keyup", function() { 
	    $(this).val($(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-")); 
	 });
	
	
	//id 중복검사
	function checkId() {
		var userId = $("#enrollForm input[name=userId]")
		if (userId.val() == "") {
			alert("ID를 입력해주세요");
			return false;
		}

		$.ajax({
			url : "idcheck.me",
			type : "post",
			data : {
				userId : userId.val()
			},
			success : function(result) {
				if (result == "fail") {
					alert("사용할 수 없는 아이디입니다.");
					 $("#enrollForm input[name=userId]").select();

				} else {
					if (confirm("사용가능한 아이디입니다. 사용하시겠습니까?")) {
						 $("#enrollForm input[name=userId]").attr("readonly","true");
						$("#joinBtn").removeAttr("disabled");
						
					} else {
						userId.focus();
					}
				}
			},
			error : function() {
				console.log("서버통신 실패")
			}
		})
	}
	  // 엔터 클릭이벤트 연결
	  $("#address").keydown(function(keyNum){
	    	if(keyNum.keyCode == 13) {
	    		$("#joinBtn").click();
	    	}
	  });
</script>
</html>