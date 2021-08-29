<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.member.model.vo.*"%>
<% 
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	MemberPageInfo pi = (MemberPageInfo) request.getAttribute("pi");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();

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
    
    #category {
     margin-left:200px;
     border: 1px solid #1b5ac2;
     width:80px;
     height:35px;
    }

    #memberSearch{
        height:35px;
        width:250px;
        border: 1px solid #1b5ac2;
        background-color: #ffffff;
        margin-left:10px;
    }

    #mem{
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
         <select id="category" >
    			  <option value="no" selected>회원번호</option>
    			  <option value="name">회원이름</option>
    			  <option value="id">아이디</option>
  			 </select>
            <div id="memberSearch">
                <input id="mem" type="text">
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
                     <th class="line" style="width:60px;"></th>
                 </tr>
             	</thead>
             	 <tbody>
             	<%if(list.isEmpty()){%>
                 <tr>
                 	<td colspan="5" style="width:500px; padding:30px;">조회된 회원 리스트가 없습니다.</td>
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
            <br>
            <div class=pagingArea align="center">
             		<button onclick="location.href = '<%=request.getContextPath()%>/memberList.bo?currentPage=1'">&lt;&lt;</button>
             		
             		<%if(currentPage == 1) { %>
             			<button disabled>&lt;</button>
             		<%} else { %>
             			<button onclick="location.href = '<%=request.getContextPath()%>/memberList.bo?currentPage=<%= currentPage-1%>'">&lt;</button>
             		<%} %>
             		
             		<%for(int p=startPage; p<=endPage; p++){ %>
             			<%if(p == currentPage) { %>
             				<button disabled><%= p%></button>
             			<%} else { %>
             				<button onclick="location.href = '<%=request.getContextPath()%>/memberList.bo?currentPage=<%=p%>'"> <%= p %></button>
             			<%} %>
             		<%} %>
             		
             		<%if(currentPage == maxPage) { %>
             			<button disabled>&gt;</button>
             		<%} else { %>
             		    <button onclick="location.href = '<%=request.getContextPath()%>/memberList.bo?currentPage=<%= currentPage+1%>'">&gt;</button>
             		<%} %>
             		<button onclick="location.href = '<%=request.getContextPath()%>/memberList.bo?currentPage=<%= maxPage%>>'">&gt;&gt;</button>
             	</div>
            </div>
             </div>
             	
       
           <script>
             		$("#searchBtn").click(function(){
             			var mem = $("#mem").val();
             			console.log(mem);
             			
             			var selValue = $("#category option:selected").text();
             		
             			console.log(selValue);
             			
             			$.ajax({
             				url: "searchMember.bo",
             				data: {
             					selValue:selValue,
             					mem : mem },
             				type:"post",
             				dataType:"json",
             				success: function(list){
             					console.log(list);
             					
             					if(list.length != 0){
             						
             						$("#memberTable > tbody").empty();
             						$(".pagingArea").empty();
             					
             						var str = '';
             						var paging = '';
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
             						$(".pagingArea").empty();
             						
             						var str = '<tbody><tr>'+
             						'<td colspan="4" style="width:500px; padding:30px;">'
             						+ "조회된 회원 리스트가 없습니다. 정확히 입력해주세요." + '</td>' 
             						+ '</tr></<tbody>'
             						
             						$("#memberTable").append(str); 
             					}
             					
                     
             				},
             				error:function(){
    							console.log("Ajax 통신 실패");
    							
    							$("#memberTable > tbody").empty();
         						$(".pagingArea").empty();
         						
         						var str = '<tbody><tr>'+
         						'<td colspan="4" style="width:500px; padding:30px;">'
         						+ "조회된 회원 리스트가 없습니다. 정확히 입력해주세요." + '</td>' 
         						+ '</tr></<tbody>'
         						
         						$("#memberTable").append(str); 
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
             		
             		$("#mem").keydown(function(keyNum){
             	    	if(keyNum.keyCode == 13) {
             	    		$("#searchBtn").click();
             	    	}
             	    });
             </script>
  <%@ include file ="../common/footer.jsp" %>
</body>
</html>