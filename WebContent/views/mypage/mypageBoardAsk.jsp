<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.bmwrap{
		margin-left: 400px;
		margin-top: 170px;
		margin-bottom: 300px;
	}
    #bmtb{
        border-collapse: collapse;
        width: 700px;
        border-bottom: 1px gray;
        
    }
    tr{
        text-align: center;
        height: 35px;
    }
    #tr1{
        background-color: rgb(154, 184, 196);
        /*margin-bottom: 100px;*/
    }
    #td1{
        width: 10%;
    }
    #td2{
        width: 60%;
    }
    #td3{
        width: 15%;
    }
    #td4{
        width: 15%;
    }
</style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
<%@ include file="../mypage/mypageMenubar.jsp" %>

    <div class="bmwrap">
        <h2 style="margin-bottom: 100px;">문의게시판</h2>
        
        <table id="bmtb">
        
			<tr>
	        	<td valgn="top" colspan="4" style="text-align: right;">
	        		<select name="search" onchange="window.location.href=this.value">
	        			<option value="">게시판선택</option>
	        			<option value="mypageBoardMain.jsp">자유게시판</option>
	        			<option value="mypageBoardAsk.jsp" >문의게시판</option>
	        			<option value="mypageBoardReport.jsp">신고게시판</option>
	        		</select>
	        	</td>
        	</tr> 
        	
            <tr id="tr1">
                <td id="td1">번호</td>
                <td id="td2">제목</td>
                <td id="td3">작성자</td>
                <td id="td4">작성일</td>
            </tr>
            <tr>
                <td>1</td>
                <td>문의게시판 테스트입니다.</td>
                <td>user1</td>
                <td>2021.08.16</td>
            </tr>
        </table>
    </div>
    
    <div class="ft" style="margin-top: 200px;">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>