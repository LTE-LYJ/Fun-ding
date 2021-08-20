<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.member.model.vo.*"%>
<% 
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 리스트</title>
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

    table td:nth-child(4){
        text-align:center;
        width:180px; 
        height:30px;
    }
    
     table th:nth-child(5){
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
    
	#memberTable >tbody >tr {
		cursor: pointer;
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
             <table id="memberTable">
                 <thead>
                 <tr>
                     <th class="line" style="width:120px;">회원번호</th>
                     <th class="line" style="width:150px;;">아이디</th>
                     <th class="line" style="width:150px;;">이름</th>
                     <th class="line" style="width:180px;">이메일</th>
                     <th class="line"></th>
                 </tr>
             	</thead>
             	 <tbody>
             	<%if(list.isEmpty()){%>
                 <tr>
                 	<td colspan="4" style="width:500px; padding:30px;">조회된 회원 리스트가 없습니다.</td>
                 </tr>
                 <%} else { %>
             	 <%for(Member mList : list) {%>
                 	<tr>
                     	<td class="line"><%= mList.getMemNo() %></td>
                     	<td class="line"><%= mList.getMemId() %></td>
                     	<td class="line"><%= mList.getMemName() %></td>
                     	<td class="line"><%= mList.getEmail() %></td>
                     	<th class="line">&nbsp;<button id="deleteBtn" type="button" onclick="deleteMember()">탈퇴</button></th>
                 	</tr>
                 	
            	<%} %>
            	<%} %>
            </tbody>
             </table>
            </div>
        </div>
           <script>
             		$("#searchBtn").click(function(){
             			var memName = $("#memName").val();
             			console.log(memName);
             			$.ajax({
             				url: "searchMember.bo",
             				data: { memName : memName },
             				type:"post",
             				dataType:"json",
             				success: function(list){
             					console.log(list);
             					
             					if(list.length != 0){
             						
             					
             					$("#memberTable > tbody").empty();
             					
             					var str = '';
             					
             					$.each(list, function(i){
             						str += '<tr>'+'<td class="line">'+
 		                  	 	 	list[i].no + '</td><td class="line">'+
 		                  		 	list[i].id + '</td><td class="line">'+
 		                  		 	list[i].name + '</td><td class="line">'+
 		                  		 	list[i].email + '</td><th class="line">'+
 		                  			'&nbsp;<button id="deleteBtn" type="button" onclick="deleteMember()">탈퇴</button>' + '</th>'
 		                  			+ '</tr>'
 		               			   
 		           				});
             					
                    
 									$("#memberTable").append(str); 
 									
             					} else if(list.length == 0) {
             						
             						//$("#memberTable > thead").empty();
             						$("#memberTable > tbody").empty();
             						
             						var str = '<tbody><tr>'+
             						'<td colspan="4" style="width:500px; padding:30px;">'
             						+ "조회된 회원 리스트가 없습니다. 이름을 정확히 입력해주세요." + '</td>' 
             						+ '</tr></<tbody>'
             						
             						$("#memberTable").append(str); 
             					}
             					
                     
             				},
             				error:function(){
    							console.log("Ajax 통신 실패");
    						}
             			
             			})
             		})
             		
             		<%if(!list.isEmpty()) {%>
             		$(function(){
             			$(document).on("mouseenter", "#memberTable > tbody >tr", function (e) { 
             				$(this).css("background-color","#1b5ac2");
         					$(this).css("color","white");
             			});
             			
             			$(document).on("mouseleave", "#memberTable  > tbody > tr", function (e) { 
             				$(this).css("background-color","white");
         					$(this).css("color","black");
             			});
             			
             			$(document).on("click", "#memberTable >tbody > tr >td", function (e) { 
             				var memId = $(this).parent().children().eq(1).text();
         					window.open("<%=request.getContextPath()%>/aboutMember.me?memId="+ memId, "멤버 조회", "width=750, height=650");
             			});
             
             		})
             		<%}%>
             		
             		function deleteMember() {
             			for (let i = 1; i < memberTable.rows.length; i++) {
                 			memberTable.rows[i].cells[4].onclick = function(){
                 				let memId = memberTable.rows[i].cells[1].innerText;
                     			location.href = "<%=request.getContextPath()%>/delete.me?memId="+ memId;
                 			}
                 		}
             		}
             </script>
  <%@ include file ="../common/footer.jsp" %>
</body>
</html>