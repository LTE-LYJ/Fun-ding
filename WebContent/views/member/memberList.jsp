<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.member.model.vo.*"%>
<% 
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<style>
    body{
        min-width:865px;
    }
   
    #title{
        margin: 80px;;
        color:#1b5ac2;
        text-align: center;
       	font-size: 45px;
        font-weight:bold;
        margin-bottom: 0px;
    }
  
    #wrap{
     	display: flex;
        justify-content: center;
        align-items: center;
        width:100%;
    }

    #searchWrap{
        display: flex;
        justify-content: center;
        align-items: center;
    }

    #memberSearch{
        height:35px;
        width:250px;
        border: 1px solid #1b5ac2;
        background-color: #ffffff;
        margin-left:250px;
    }

    #memName{
        font-size: 12px;
        width:150px;
        padding: 10px;
        border:0px;
        outline: none;
    }

    #searchBtn {
        width:45px;
        height:100%;
        border:0px;
        background: #1b5ac2;
        outline: none;
        float: right;
        color:#ffffff;
    }

    #memberList{
        margin: 87px;
        margin-left: 100px;
        margin-top:40px;
        display: flex;
        justify-content: center;
        align-items:flex-start;
       	width:700px;
        height:500px;
    }

    table {
        font-size: 12pt;
        border-collapse:collapse;

    }

    .line{
        border-bottom: 2px black solid;
    }

    table td:nth-child(1){
        text-align:center;
        width:120px; 
        height:30px;
    }

    table td:nth-child(2){
        text-align:center;
        width:150px; 
        height:30px;
    }

    table td:nth-child(3){
        text-align:center;
        width:150px; 
        height:30px;
    }

    table th:nth-child(4){
        text-align:left;
    }

    #deleteBtn{
        background-color: white;
        border:black 1px solid;
        font-weight:bold;
        border-radius: 5px;
        width:50px;
        height:25px;
    }

    #deleteBtn:hover{ 
        background-color: rgb(31, 80, 126);
        color:white;
    }
</style>
</head>
<body>
<%@ include file ="../common/menubar.jsp" %>
	<div id="title">
            <h1 style="line-height: 80px;">회원 리스트</h1>
        </div>
        <div id="searchWrap">
            <div id="memberSearch">
                <input id="memName" type="text" placeholder="회원이름 검색">
                <button id="searchBtn">검색</button>
            </div>
        </div>

        <div id="wrap">
            <div id="memberList">
             <table id="memberTable" >
                 <%if(list.isEmpty()){%>
                 <tbody>
                 <tr>
                 	<td colspan="4" style="width:500px; padding:30px;">조회된 회원 리스트가 없습니다.</td>
                 </tr>
                 </tbody>
                 
                 <%} else { %>
                 
                 <thead>
                 <tr>
                     <th class="line">회원번호</th>
                     <th class="line">회원이름</th>
                     <th class="line">회원Id</th>
                     <th class="line"></th>
                 </tr>
             </thead>
                 <tbody>
                 	<%for(Member mList : list) {%>
                 <tr>
                     <td class="line"><%= mList.getMemNo() %></th>
                     <td class="line"><%= mList.getMemId() %></th>
                     <td class="line"><%= mList.getMemNo() %></th>
                     <td class="line">&nbsp;<button id="deleteBtn">탈퇴</button></th>
                 </tr>
            <%} %>
           		 </tbody>
            <%} %>
             </table>
             <script>
             		$("#searchBtn").click(function(){
             			var memName = $("#memName").val();
             			
             			$.ajax({
             				url: "searchMember.bo",
             				data: { memName : memName },
             				type:"post",
             				dataType:"json",
             				success: function(list){
             					console.log(list);
             					
             					var $tableBody = $("memberTable tbody");
             					
             					
             					$.each(list, function(i){
             						var $tr = $("<tr>");
    								var $noTd = $('<td class="line">').text(list[i].no);
    								var $naemTd = $('<td class="line">').text(list[i].name);
    								var $ageTd = $('<td class="line">').text(list[i].id);
    								var $genderTd = $('<td class="line">').text('&nbsp;<button id="deleteBtn">탈퇴</button>');
    								
    								$tr.append($noTd);
    								$tr.append($naemTd);
    								$tr.append($ageTd);
    								$tr.append($genderTd);
    								
    								$tableBody.append($tr);
    								
             					})
             					
             				},
             				error:function(){
    							console.log("Ajax 통신 실패");
    						}
             			
             			})
             		})
             	
             </script>
            </div>
        </div>
  <%@ include file ="../common/footer.jsp" %>
</body>
</html>