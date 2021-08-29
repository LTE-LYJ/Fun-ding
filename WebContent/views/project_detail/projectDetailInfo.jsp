<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.project_detail.controller.projectDetailAskPageServlet"%>
<%@page  import="java.util.ArrayList,com.kh.project.model.vo.*, java.util.Date,com.kh.attachment.model.vo.*, 
com.kh.project_detail.model.vo.*, java.text.SimpleDateFormat"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
Project project = (Project)request.getAttribute("project");
Creator creator = (Creator)request.getAttribute("creator");
ProjectCat projectCat = (ProjectCat)request.getAttribute("projectCat");
ArrayList<ProjectAttachment> prjAttList = (ArrayList<ProjectAttachment>)request.getAttribute("prjAttList");
ProfileAttachment createrPro = (ProfileAttachment)request.getAttribute("createrPro");
int num= project.getPrjNo();
ArrayList<Reward> rewordList = (ArrayList<Reward>)request.getAttribute("rewordList");
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
	                <h3 id="category"><%=projectCat.getPrjCatName() %></h3>
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
	                                    <input type="button" id="btn_fd" value="펀딩하기" onclick="checkLogin();"></input>
	                                   <%}else{%>
	                                   <input type="button" id="btn_fd2" value="재펀딩요청하기 <%=project.getPrjRecount() %>"></input>
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
	            
	            
	          
 <!---                         프로젝트 관련 내용 sub1 부분                -->
	                <div id="body_content2">
	
	                    <div id="bottom_content">
	                <div id="bottom_left_content" style="height: 100%; margin-top: 0px">
	                    <%=project.getPrjContent() %>
	                    <%for(int i =0; i<prjAttList.size();i++){ %>
	                   	<img src="resources/upfiles_project/<%=prjAttList.get(i).getChangeName()%>" style="width: 725px;">
	                	<%}%>
	                </div>
	
	                <aside id="aside2">
	                <%--<div id="bottom_right_button1" class="option">
	                        <a href ="#" class="b_btn">
	                            <div>
	                                <div><h2>1000  (10코인)</h2></div>
	                                <div>선물없이 후원하기</div>
	                            </div>
	                        </a>
	                </div>
	                <div id="bottom_right_button2" class="option">
	                <a href="#" class="b_btn">
	                    <div>
	                        <div><h2>15800원 (158코인)</h2></div>
	                        <div>옵션.1</div>
	                        <div>배송비 미포함<br>
	                            * 쿠로의 아름다운 개소리. CD<br>
	                            * 쿠로의 10살 기념 포토카드 ver 3-랜덤발송</div>
	                    </div>
	                </a>
	                </div>
	                <div id="bottom_right_button3" class="option">
	                <a href="#" class="b_btn">
	                    <div>
	                        <div><h2>27000원 (270코인)</h2></div>
	                        <div>배송비 포함</div>
	                        <div>* 쿠로의 아름다운 개소리. CD <br>
	                            * 쿠로의 10살 기념 포토카드 ver 3-랜덤발송<br>
	                            * 포스터 4종 중 랜덤 1종 <br>
	                            * 스티커 2 SET</div>
	                    </div>
	                </a>
	                </div> --%>
	                <%if(rewordList.isEmpty()){ %>
				
					<div id="bottom_right_button3" class="option">
		                <a href="#" class="b_btn">
		                	조회된 리워드가 없습니다.
		                </a>
	                </div>
				</tr>
				<%}else{ %>
					<% for( int i=0; i<rewordList.size();i++){ %>
					<div id="bottom_right_button<%=i+1%>" class="option">
	                <a href="#" class="b_btn">
	                    <input type="radio" style="display: none" value="<%=i%>" name="ReName"></input>
	                       <div><h2 id="rePrice"><%=rewordList.get(i).getRwPrice() %> 원 (<%=rewordList.get(i).getRwPrice()/100%>코인)</h2></div>
	                        <div id="reName"><%=rewordList.get(i).getRwName() %></div>
	                        <div id="reContent"><%=rewordList.get(i).getReContent() %></div> 
	                </a>
	                </div>
					<%} %>
				<%} %>
				
	                <div id="creator_content">
	                 <%if(createrPro.getChangeName() == null){ %>
	                 <div><img class="profile" src="<%=request.getContextPath()%>/resources/images/default.PNG" style="width: 40px; height: 40px; border-radius: 70%; vertical-align: middle; float:none; margin-bottom:10px; clear: both;">
							<%} else { %>
							<div><img class="profile" src="resources/upfiles_profile/<%=createrPro.getChangeName() %>" style="width: 40px; height: 40px; border-radius: 70%; vertical-align: middle; float:none; margin-bottom:10px; clear: both;">
							<%} %>
	                    <span><h4 id="creatorName" style="display: inline-flex; margin-left: 10px; margin-top:20px"><%=creator.getCreName() %></h4></span></div><br>
	                    <br><div><%=creator.getCreContent() %></div><br><br>
	                    <div><h4 style="display: inline;">진행한 프로젝트 : </h4> <span><h4 style="display: inline;"><%=creator.getPrjCountNo() %></h4></span></div>
	                </div>
	            </aside>
	        </div>
	
	    </div>
			    <%@ include file="../common/footer.jsp" %>
			    
	    <script>
	    $('#proInfo').css('color','black');
	    $('#proInfo').click(function() {
	    	location.href="<%=request.getContextPath()%>/proInfo.list?num="+<%=num%>;
		});
	    $('#proReview').click(function() {
	    	location.href="<%=request.getContextPath()%>/proReview.list?num="+<%=num%>;
		});
	    $('#proAsk').click(function() {
	    	location.href="<%=request.getContextPath()%>/proAsk.list?num="+<%=num%>;
		});
	    var opt = "";
	    $('.option').each(function(index){
	        $(this).attr('option-index', index);
	            }).click(function(){
	            	opt = "";
	                var index = $(this).attr('option-index');
	                $('.option[option-index=' + index + ']').addClass('clicked_option'); 
	                $('.option[option-index!=' + index + ']').removeClass('clicked_option');
	                $("input[type='radio']").prop('checked', true);
	                opt+=$(this).find('input').val();
	                console.log(opt);
	    });
	    function checkLogin(){
			<%if(loginUser!=null){%>
				if(opt!=""){
			location.href="<%=request.getContextPath()%>/paylist.pa?opt="+opt +"&num="+<%=num%>;
			}else{
				alert("리워드를 선택해주세요!");
				}
			<%}else{%>
				alert("로그인 후 이용 가능합니다.")
				location.href="<%=request.getContextPath()%>/loginform.me";
			<%}%>
			
	    };
	    $('a[href="#"]').click(function(e) {
		e.preventDefault();
	    });
	    
	    </script>
	   
</body>
</html>