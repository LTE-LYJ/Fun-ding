<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    //request.setCharacterEncoding("UTF-8");

    Member m = (Member) request.getAttribute("loginUser");

    String memId = m.getMemId();
    String memName = m.getMemName();
    String phone = m.getPhone();
    String email = m.getEmail();
    String address = m.getAddress();

    String profileImage = (String) request.getAttribute("profileImage");
    
    if (profileImage == null) profileImage = "default.PNG";

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지 회원정보 수정</title>
    <style>
        .mpInfotb {
            /*text-align: center;*/
            position: relative;
            left: 300px;
            top: 200px;
        }

        #profileImage {
            width: 90px;
            height: 90px;
            background-color: lightgray;
            margin-bottom: 20px
        }

        td {
            height: 50px;
            width: 70px;
        }

        .mpi {
            width: 200px;
            height: 20px;
        }

        .mpInfotb {
            font-size: 20px
        }

        button {
            background-color: rgb(70, 155, 224);
            color: white;
            border-radius: 5px;
            width: 110px;
            height: 30px;
            /*border: 3px gray;*/
        }

        button:hover {
            background-color: blue;
            cursor: pointer;
        }

        #updateInfoBtn {

            margin-top: 230px;
        }

    </style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

<div class="mypageinfo">

    <form action="<%=request.getContextPath() %>/updateInfoOk.mp" method="post" id="infoForm"
    	  name="infoForm" enctype="multipart/form-data">

        <table class="mpInfotb">
            <tr>
                <td><img id="profileImage" src="<%= request.getContextPath() %>/resources/upfiles_profile/<%= profileImage %>"
                         alt="프로필 이미지">
                </td><td>
                    <input id="profileImageInput" type="file" name="profileImage"></td>
            </tr>
            <tr>
                <td>아이디</td>
                <td><input type="text" class="mpi" id="mpId" name="memId" value="<%= memId %>" readonly></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" class="mpi" id="mpPwd" name="memName" value="<%= memName %>" required></td>
            </tr>
            <tr>
                <td>연락처</td>
                <td><input type="text" class="mpi" id="mpPhone" name="phone" value="<%= phone %>" required></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" class="mpi" id="mpEmail" name="email" value="<%= email %>" required></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" class="mpi" id="mpAddress" name="address" value="<%= address %>" required></td>
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
    const image = document.getElementById('profileImage');
    const imageInput = document.getElementById('profileImageInput');

    imageInput.onchange = () => {
        if (imageInput.files.length !== 1) return;

        const reader = new FileReader();
        
        reader.readAsDataURL(imageInput.files[0]);
        
        reader.onload = (e) => image.src = e.target.result;
    };
</script>

</body>
</html>
