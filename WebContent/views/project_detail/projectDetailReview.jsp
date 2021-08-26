<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.project.model.vo.*,java.util.Date, 
    java.util.Date,com.kh.attachment.model.vo.*, java.text.SimpleDateFormat"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
Project project = (Project)request.getAttribute("project");
ProjectCat projectCat = (ProjectCat)request.getAttribute("projectCat");
ArrayList<ProjectAttachment> prjAttList = (ArrayList<ProjectAttachment>)request.getAttribute("prjAttList");
int num= project.getPrjNo();
Date date = new Date();
SimpleDateFormat sdFormat = new SimpleDateFormat("yy/MM/dd");
%>
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
	                <h3 id="category"><%=projectCat.getPrjCatName()%></h3>
	                <div id="top_content">
	                    <div id="top_left_img"><img src="resources/upfiles_project/<%=prjAttList.get(0).getChangeName()%>" style="width: 725px; height: 418px;"></div>
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
	                                    <input type="button" id="btn_po" value="창작자 신고하기" onclick="location.href=''" ></input>
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
	        	            		   selectList();
	        	            	   }
		        	            },
	        	               error:function(){
	        	                  console.log("ajax 통신 실패 - 댓글 등록");
	        	               }
	        	            })
	        	         })
	        	      function selectList(){
	        	    	  <%if(project.getStatus().equals("Y")){%>
                          <input type="button" id="btn_fd" value="펀딩하기" onclick="checkLogin();"></input>
                         <%}else{%>
                         $("#buttonarea").empty(); //기존 내용 지우고 다시 불러온다. 
                          <%}%>
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
                        <div id="creator">
                        <%if(at == null){ %>
							<img id="rev_Img" src="<%=request.getContextPath()%>/resources/images/default.PNG"> 
							<%} else { %>
							<img id="rev_Img"  src="<%=request.getContextPath() %>/resources/upfiles_profile/<%= at.getChangeName()%>"> 
							<%} %>
                        <% if(loginUser != null){ %>
                            <span id="name_area"><h4 id="rev_Name"><%=loginUser.getMemId() %></h4></span>
                            <textarea id="replyContent" name="contentarea" cols="107" rows="8" style="resize:none;" placeholder="--자 이내로 입력해주세요."></textarea>
                        <% }else{ %>
                        <span id="name_area"><h4 id="rev_Name">비회원</h4></span>
                        <textarea  id="replyContent" name="contentarea" readonly cols="107" rows="8" style="resize:none;" placeholder="로그인한 사용자만 가능한 서비스입니다. 로그인 후 이용해주세요"></textarea>
                        <% } %>
                        </div>
                        <input type="button" id="btn_con" value="댓글작성"></input><br><br><br><br>
                        <hr>

                 <table id="reviewArea">
                     <%-- <tr>
                         <td><img class="imgContent" src="resources/images/favicon.PNG"></td>
                         <td><h4 class="creatorName">창작자1</h4></td>
                         <td></td>
                    </tr>
                    <tr>
                        <td></td>
                         <td><p class="text_a">보이는 끝까지 찾아다녀도 목숨이 있는 때까지 방황하여도 보이는 것은 거친 모래뿐일 것이다 
                             이상의 꽃이 없으면 쓸쓸한 인간에 남는 것은 영락과 부패 있다.</p></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><a class="delete_btn" href="">삭제</a></td>
                    </tr>
                    <tr>
                        <td colspan="3"><hr></td>
                    </tr>
    				</table>
                    <table>
                        <tr>
                            <td><img class="imgContent" src="resources/images/favicon.PNG"></td>
                            <td><h4 class="creatorName">창작자1</h4></td>
                            <td></td>
                       </tr>
                       <tr>
                           <td></td>
                            <td><p class="text_a">보이는 끝까지 찾아다녀도 목숨이 있는 때까지 방황하여도 보이는 것은 거친 모래뿐일 것이다 
                                이상의 꽃이 없으면 쓸쓸한 인간에 남는 것은 영락과 부패 있다.</p></td>
                           <td></td>
                       </tr>
                       <tr>
                           <td></td>
                           <td></td>
                           <td><a class="delete_btn" href="">삭제</a></td>
                       </tr>
                       <tr>
                        <td colspan="3"><hr></td>
                        </tr>
                    
                        <tr>
                            <td><img class="imgContent" src="resources/images/favicon.PNG"></td>
                            <td><h4 class="creatorName">쿠로지구뿌셔</h4></td>
                            <td></td>
                       </tr>
                       <tr>
                           <td></td>
                            <td><p class="text_a">보이는 끝까지 찾아다녀도 목숨이 있는 때까지 방황하여도 보이는 것은 거친 모래뿐일 것이다 
                                이상의 꽃이 없으면 쓸쓸한 인간에 남는 것은 영락과 부패 있다.</p></td>
                           <td></td>
                       </tr>
                       <tr>
                           <td></td>
                           <td></td>
                           <td><a class="delete_btn" href="">삭제</a></td>
                       </tr>
                        <tr>
                        <td colspan="3"><hr></td>
                        </tr> --%>
                    </table>

                     
                </div>
            </div>
        </div> 
        <%@ include file="../common/footer.jsp" %>
        
        <script type="text/javascript">
        $('#proReview').css('color','black');
        $('#proInfo').click(function() {
	    	location.href="<%=request.getContextPath()%>/proInfo.list?num="+<%=num%>;
		});
	    $('#proReview').click(function() {
	    	location.href="<%=request.getContextPath()%>/proReview.list?num="+<%=num%>;
		});
	    $('#proAsk').click(function() {
	    	location.href="<%=request.getContextPath()%>/proAsk.list?num="+<%=num%>;
		});
	    </script>
	    <script type="text/javascript">
	    $(function(){
	    	selectReviewList(); // 조회
	         $("#btn_con").click(function(){ //댓글 등록
	            var content = $("#replyContent").val();
	            var num = <%=num%>;
	            
	            $.ajax({
	               url:"reinsert.de",
	               type:"post",
	               data:{
	                  content:content, 
	                  num:num
	               },
	               success:function(status){
	                  if(status == "success"){ //등록이 성공하면 조회되어야한다. 
	                	  selectReviewList();
	                     $("#replyContent").val("");
	                  }
	               },
	               error:function(){
	                  console.log("ajax 통신 실패 - 댓글 등록");
	               }
	            })
	         })
	      });   
	   
	      function selectReviewList(){
	    	  var id = $('.creatorName').attr("data_id");
	         $("#reviewArea").empty(); //기존 내용 지우고 다시 불러온다. 
	         $.ajax({
	            url:"relist.de",
	            data:{num : <%=num%>}, <%--프로젝트 넘버를 넘겨서 --%>
	            type:"get",
	            success:function(list){ 
	               var value = ""
	               for(var i in list){
	            	   if(list[i].changeName==null){
	            	   value += '<tr>'+
	            		   '<td style="width:70px"><img class="imgContent" src='+"resources/images/default.PNG></td>"+
	                      '<td><h4 class="creatorName" data_id="'+list[i].memId+'">'+list[i].memId+'</h4></td>'+
	                      '<td></td>'+
		                 '</tr>'+
		                 '<tr>'+
		                     '<td></td>'+
		                      '<td><p class="text_a">'+list[i].reviewContent+'</p></td>'+
		                     '<td></td>'+
		                 '</tr>'+
		             	       '<td></td>'+
		             	       '<td></td>'+
		             	   '<td><div class="delete_btn" data_No="'+list[i].reviewNo+'">삭제</div></td>'+
		             	  '</tr>'+
		                  '<tr>'+
		                  '<td colspan="3"><hr style="width:950px"></td>'+
		                  '</tr>';
	               }else{
	            	   value += '<tr>'+
            		   '<td style="width:70px"><img class="imgContent" src='+"resources/upfiles_profile/"+list[i].changeName+'></td>'+
                      '<td><h4 class="creatorName" data_id="'+list[i].memId+'">'+list[i].memId+'</h4></td>'+
                      '<td></td>'+
	                 '</tr>'+
	                 '<tr>'+
	                     '<td></td>'+
	                      '<td><p class="text_a">'+list[i].reviewContent+'</p></td>'+
	                     '<td></td>'+
	                 '</tr>'+
	             	       '<td></td>'+
	             	       '<td></td>'+
	             	   '<td><div class="delete_btn" data_No="'+list[i].reviewNo+'">삭제</div></td>'+
	             	  '</tr>'+
	                  '<tr>'+
	                  '<td colspan="3"><hr style="width:950px"></td>'+
	                  '</tr>';
	            	   
	               }
	               }
	               	$("#reviewArea").html(value);
	            },
	            error:function(){
	                console.log("ajax 통신 실패 - 댓글 조회");
	             }
	          })
	       }
	      
        </script>
        <script type="text/javascript">
        
        $(document).on('click', '.delete_btn', function(){
         	var reNum = $(this).attr("data_No"); 
         	
	    	  console.log(reNum);
                $.ajax({
                url : "redelete.de",
                data : {
              	  reNum : reNum,
              	  num : <%=num%>
                },
                type : "post",
                success : function(status){
                    if(status == "success"){ 
                    	 selectReviewList();
                         alert("삭제 완료");
                     } else {
                    	 alert("후기는 본인만 삭제 가능합니다.");
                     }
                },
                error : function(status){
                	alert("삭제 실패");
                }
			})
		});
        </script>
</body>
</html>










