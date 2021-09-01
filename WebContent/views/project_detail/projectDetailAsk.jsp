<%@page import="com.kh.project.model.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.project_detail.model.vo.*, 
    com.kh.project.model.vo.*, com.kh.project_detail.model.vo.PageInfo, java.util.Date
    , java.util.Date,com.kh.attachment.model.vo.*, java.text.SimpleDateFormat"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
Project project = (Project)request.getAttribute("project");
ProjectCat projectCat = (ProjectCat)request.getAttribute("projectCat");
int num= project.getPrjNo();
ArrayList<ProjectAsk> askList =(ArrayList<ProjectAsk>)request.getAttribute("askList");
ArrayList<ProjectAttachment> prjAttList = (ArrayList<ProjectAttachment>)request.getAttribute("prjAttList");
PageInfo pi = (PageInfo)request.getAttribute("pi");
SimpleDateFormat sdFormat = new SimpleDateFormat("yy/MM/dd");
int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
Date date = new Date();
%>
<%--int prjNum =(int)request.getAttribute("prjNum");--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 상세페이지</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/projectDetail.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
	        <div id="body_content1"> 
	            <h1 id="title"><%=project.getPrjTitle() %></h1>
	                <h3 id="category"><%=projectCat.getPrjCatName() %></h3>
	                <div id="top_content">
	                    <div id="top_left_img"><img src="resources/upfiles_project/<%=prjAttList.get(0).getChangeName()%>"  style="width: 725px; height: 418px;"></div>
	                    <div id="top_right_bar">
	                        <aside id="aside1">
	                                <div><h4 style="margin-bottom: 10px; margin-top: 00px;">모은금액</h4></div>
	                                <div style="margin-bottom: 20px"><h1  class="textFiled" style="display: inline;"><fmt:formatNumber value="<%=project.getPrjCurrent()%>" groupingUsed="true"/></h1>
	                                    <h4 style="display: inline;">원</h4>
	                                        <span style="width: 100px;"></span>
	                                    <span><h4 style="color: red; display: inline; float: right;"><fmt:formatNumber value="<%=(float)project.getPrjCurrent()/project.getPrjTarget()%>" type="percent"/> 달성</h4></span></div>
	                                    <p style="clear: both;"></p>
	                                <div style=" margin-bottom: 10px;"><h4 style="display: inline;">펀딩시작일</h4></div>
	                                <div><h2  class="textFiled"><fmt:formatDate value="<%=sdFormat.parse(project.getPrjStartDate())%>" type="date" pattern="MM월 dd일 "/></h2><span style="display: inline-flex;">
	                               	<% if((date.getTime()<sdFormat.parse(project.getPrjEndDate()).getTime())){%>
	                                	<h4>( <%=(sdFormat.parse(project.getPrjEndDate()).getTime()-(date.getTime()))/(24*60*60*1000)%> 일 남음 )</h4></span></div> 
	                                <%}else{%>
	                                	<h4>( 마감된 프로젝트 )</h4></span></div> 
	                                <%}%>
	                                <div><h4 style="margin-bottom: 10px; margin-top: 0px;">펀딩종료일</h4></div>
	                                <div><h2  class="textFiled" ><fmt:formatDate value="<%=sdFormat.parse(project.getPrjEndDate())%>" type="date" pattern="MM월 dd일"/></h2></div>
	                                <div style="margin-top: 30px; margin-bottom: 20px;" id="buttonarea">
	                                    <%if(project.getStatus().equals("Y")){%>
	                                    <input type="button" id="btn_fd" value="펀딩하기" onclick="goInfo();"></input>
	                                   <%}else{%>
	                                    <input type="button" id="btn_fd2" value="재펀딩요청하기 <%=project.getPrjRecount()%>"></input>
	                                    <%}%>
	                                </div>
	                                <div>
	                                    <input type="button" id="btn_po" value="창작자 신고하기" onclick="location.href='<%=request.getContextPath()%>/views/notice/noticeEnrollForm'" ></input>
	                                </div>
	                            </aside>
	                        </div>
	                    </div>
	                </div>
					<script type="text/javascript">
	                $(document).on('click', "#btn_fd2", function(){
	        	            $.ajax({
	        	               url:"countPlus.de",
	        	               type:"post",
	        	               data:{num : <%=num%>},
	        	               success:function(status){
	        	            	   if(status=="success"){
	        	            		   alert('재펀딩 요청이 완료되었습니다.');
	        	            		   selectList();
	        	            	   }
		        	            },
	        	               error:function(){
	        	                  console.log("ajax 통신 실패 - 댓글 등록");
	        	               }
	        	            })
	        	         })
	        	      function selectList(){
	                	$("#buttonarea").empty(); //기존 내용 지우고 다시 불러온다. 
	        	         $.ajax({
	        	            url:"countSelect.de",
	        	            data:{num : <%=num%>}, <%--프로젝트 넘버를 넘겨서 --%>
	        	            type:"post",
	        	            success:function(number){ 
	        	               var value = ""
	        	            	   value='<input type="button" id="btn_fd2" value="재펀딩요청하기 '+number+'"></input>';
	        	               	$("#buttonarea").html(value);
	        	            },
	        	            error:function(){
	        	                console.log("ajax 통신 실패 - 댓글 조회");
	        	             }
	        	          })
	        	       }
	                
	                </script>
	                <!---                         네비바 부분                   -->
	            <div id="navi_bar_parent">
	                <div id="navi_bar">
	                    <hr>
	                    <ul id="navi">
	                        <li><a href="#;" id="proInfo" onclick="proInfoBtn()">프로젝트 정보</a></li>
	                        <li><a href="#;" id="proReview" onclick="proReviewBtn()">후기작성</a></li>
	                        <li><a href="#;" id="proAsk" onclick="proAskBtn()">창작자에게 문의하기</a></li>
	                    </ul>
	                    <hr style="clear: both;">
	                </div>
	            </div>
	            
	            
	            <script>
	            function goInfo(){
					alert("리워드를 선택해주세요");
					location.href="<%=request.getContextPath()%>/proInfo.list?num="+<%=num%>;
				
		   		 };
	            </script>
	        <div id="body_content2">
            <div id="body">
                    <div id="box">
            <table class="listArea">
			<thead>
				<tr>
					<th class="table1">글번호</th>
					<input type="hidden" class="table6" />
					<th class="table2">글제목</th>
					<th class="table3">작성자</th>
					<th class="table4">작성일</th>
					<th class="table5">조회수</th>
				</tr>
			<thead>
			<tbody>
               <%-- <tr>
                    <td class="table1" >4</td>
                    <td class="table2">아니 정말 개소리를 파시는 건가요? 아니 제가 정말 개소리인줄아니 정말 개소리를 파시는 건가요? 아니 제가 정말 개소리인줄</td>
                    <td class="table3">후원자11</td>
                    <td class="table4">2021.07.31</td>
                    <td class="table5">1</td>
                </tr>
                <tr>
                    <td class="table1">3</td>
                    <td class="table2">쿠로 콘서트 부탁드립니다.</td>
                    <td class="table3">쿠로극성팬1</td>
                    <td class="table4">2021.07.29</td>
                    <td class="table5">25</td>
                </tr>
                <tr>
                    <td class="table1">2</td>
                    <td class="table2">포토카드 선택할수 없나요?</td>
                    <td class="table3">크n</td>
                    <td class="table4">2021.07.28</td>
                    <td class="table5">1</td>
                </tr>
                <tr>
                    <td class="table1">1</td>
                    <td class="table2">쿠로 콘서트 부탁드립니다.</td>
                    <td class="table3">쿠로지구뿌셔</td>
                    <td class="table4">2021.07.22</td>
                    <td class="table5">5</td>
                </tr>--%>
                  <% if(askList.isEmpty()){ %>
				 	<tr class="table0">
						<td colspan="5" style="height: 40px;">존재하는 문의사항이 없습니다.</td>
					</tr>
				 <% }else{  %>
				 	<% for(ProjectAsk n : askList){ %>
				 		<tr style="cursor: pointer;">
				 			<td class="table1"><%= n.getPrjAskNownum() %></td>
				 			<input type="hidden" class="table6" value="<%= n.getPrjAskNo() %>" style="border-left: none;"/>
							<td class="table2"><%= n.getPrjAskTitle() %></td>
							<td class="table3"><%= n.getMemId() %></td>
							<td class="table4"><%= n.getEnrollDate() %></td>
							<td class="table5"><%= n.getCount() %></td>
				 		</tr>
				 	<% } %>
				 <% } %>
			</tbody>
		</table>
		<!-- 페이징바 만들기 -->
		<br>
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=request.getContextPath()%>/proAsk.list?currentPage=1&num='+<%=num %>"> &lt;&lt; </button>
		
			<!-- 이전페이지로(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/proAsk.list?currentPage=<%= currentPage-1 %>'+'&num='+<%=num %>"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currentPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/proAsk.list?currentPage=<%= p %>'+'&num='+<%=num %>"> <%= p %> </button>
				<%} %>
				
			<%} %>
			
			<!-- 다음페이지로(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%=request.getContextPath()%>/proAsk.list?currentPage=<%=currentPage+1 %>'+'&num='+<%=num %>"> &gt; </button>
			<%} %>
		
			<!-- 맨 끝으로 (>>) -->
			 <button onclick="location.href='<%=request.getContextPath()%>/proAsk.list?currentPage=<%=maxPage%>'+'&num='+<%=num %>"> &gt;&gt; </button>
		</div> 
        <button type="button" id="btn_ask" onclick="wirteAsk()">문의하기</button><br style="float: none;">

                    </div>
                </div>
            </div> 
                    <%@ include file="../common/footer.jsp" %>
                    
         <script>
            function wirteAsk() {
            	<%if(loginUser!=null){%>
            	window.open("views/project_detail/projectDetailAskNewPop.jsp?num="+<%=num%>, "문의쓰기", "top=100px, left=300px, height=430px, width=600px, resizable=no");
            	
    			<%}else{%>
				alert("로그인 후 이용 가능합니다.")
				location.href="<%=request.getContextPath()%>/loginform.me";
			<%}%>
			}
            $('#proAsk').css('color','black');
            $('#proInfo').click(function() {
    	    	location.href="<%=request.getContextPath()%>/proInfo.list?num="+<%=num%>;
    		});
    	    $('#proReview').click(function() {
    	    	location.href="<%=request.getContextPath()%>/proReview.list?num="+<%=num%>;
    		});
    	    $('#proAsk').click(function() {
    	    	location.href="<%=request.getContextPath()%>/proAsk.list?num="+<%=num%>;
    		});
		    
		    <%if(!askList.isEmpty()){%>
            $(function(){
               $(".listArea>tbody>tr").click(function(){
            	  var askNum = $(this).children().eq(1).val();
            	  <%if(loginUser!=null){%>
                  	window.open("<%=request.getContextPath()%>/detail.prjPop?askNum="+askNum +"&num="+<%=num%>, "문의쓰기", "top=100px, left=300px, height=430px, width=600px, resizable=no");
                  	location.reload();
                  <% }else{  %>
                  	alert("로그인 후 이용 가능합니다.")
  					location.href="<%=request.getContextPath()%>/loginform.me";
                  <%}%>
               })
            });
         <%}%>

         </script>
         
</body>
</html>