<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지 회원탈퇴</title>
    <style>
        .delwrap {
            margin-top: 200px;
            margin-left: 350px;
        }

        #deltb {
            margin-left: 250px;
        }

        .deltd {
            padding: 10px;
        }

        input {
            width: 220px;
            height: 24px;
        }

        #delPwd {
            background-color: rgb(70, 155, 224);
            color: white;
            border-radius: 5px;
            width: 110px;
            height: 30px;
            /*border: 3px gray;*/
            items-align: center;
        }

        #delPwd:hover {
            background-color: blue;
        }

        #fm {
            text-align: center;
        }
    </style>
</head>
<body>
<%
    Member m = (Member) session.getAttribute("loginUser");

    String memId = m.getMemId();
    String memPwd = (String) session.getAttribute("memPwd");
%>

<%@ include file="../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

<div class="delwrap">
    <h4>회원 탈퇴</h4>
    <hr style="margin-bottom:30px;">

    <form action="<%= request.getContextPath() %>/memberDelete.mp" method="post" id="fm">
        아이디 &nbsp; &nbsp; <input type="text" name="id"><br><br>
        비밀번호 &nbsp; <input type="password" name="passwd"><br><br>
        <input type="submit" id="delPwd" value="탈퇴하기"><br>
    </form>

</div>

<div class="ft" style="margin-top: 200px;">
    <%@ include file="../common/footer.jsp" %>
</div>


<script type="text/javascript">

</script>
</body>
</html>
