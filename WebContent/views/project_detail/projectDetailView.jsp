<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.project_detail.model.vo.ProjectAsk"%>
<%
ArrayList<ProjectAsk> askList = (ArrayList<ProjectAsk>)request.getAttribute("askList");

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
	            <h1 id="title">얼마나 생생하며 그들의 눈에 CD</h1>
	                <h3 id="category">음악</h3>
	                <div id="top_content">
	                    <div id="top_left_img"><img src=""></div>
	                    <div id="top_right_bar">
	                        <aside id="aside1">
	                                <div><h4 style="margin-bottom: 10px; margin-top: 00px;">모은금액</h4></div>
	                                <div style="margin-bottom: 20pxd"><h1  class="textFiled" style="display: inline;">14,686,000</h1>
	                                    <span style="display: inline-flex;"></span><h4 style="display: inline;">원</h4>
	                                        <span style="width: 100px;"></span>
	                                    <span><h4 style="color: red; display: inline">144% 달성</h4></span></div>
	                                <div style=" margin-bottom: 10px;"><h4 style="display: inline;">마감일</h4></div>
	                                <div><h2  class="textFiled">7월14일</h2><span style="display: inline-flex;"><h4>( 24일 남음 )</h4></span></div>
	                                <div><h4 style="margin-bottom: 10px; margin-top: 0px;">예상배송일</h4></div>
	                                <div><h2  class="textFiled" >8월20일</h2></div>
	                                <div style="margin-top: 30px; margin-bottom: 20px;">
	                                    <input type="button" id="btn_fd" value="펀딩하기" onclick="checkLogin();"></input>
	                                </div>
	                                <div>
	                                    <input type="button" id="btn_po" value="창작자 신고하기" onclick="location.href=''" ></input>
	                                </div>
	                            </aside>
	                        </div>
	                    </div>
	                </div>
	
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
				function checkLogin(){
						alert("로그인이 필요합니다.");
						location.href="<%=request.getContextPath()%>/paylist.pa";
			    };
	            </script>
	           
	             
</body>
</html>