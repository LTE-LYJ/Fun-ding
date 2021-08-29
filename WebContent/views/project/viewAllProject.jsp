<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList, com.kh.project.model.vo.*" %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<% 
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	Date startDate, endDate;
	String todayStr = sdf.format(date);
	Date today = sdf.parse(todayStr);
	
	ArrayList<Project> list = (ArrayList<Project>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int allListCount = (int)request.getAttribute("allListCount");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>모든 프로젝트</title>
<style>
div, span, applet, object, iframes, h1, h2, h3, h4, h5, h6,
p, blockquote, pre, a, abbr, acronym, address, big, quotes, code, del,
dfn, em, img, ins, kbd, q, s, samp, small, strike, sub, sup, tt, var, u,
i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table,
caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	do: inherit;
	vertical-align: baseline;
}

article, aside, details, figcaption, figure, hgroup,
menu, nav, section {
	display: block;
}

blockquote, q {
	quotes: none;
}

blockquote : before, blockquote : after, q : before, q : after {
	content: '';
	content: none;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

/*css 초기화*/

.card {
	height: 400px;
	width: 350px;
	order-radius: 15px;
	display: inline-block;
	margin-top: 30px;
	margin-left: 30px;
	margin-bottom: 30px;
	position: relative;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	overflow: hidden;
}

.card-header {
	-webkit-transition: 0.5s; /*사파리 & 크롬*/
    -moz-transition: 0.5s;  /*파이어폭스*/
    -ms-transition: 0.5s;	/*인터넷 익스플로러*/
    -o-transition: 0.5s;  /*오페라*/
    transition: 0.5s;
	width: 100%;
	height: 270px;
	border-radius: 15px 15px 0 0;
	background-image: url("images/korea.jpeg");
	background-size: 100% 280px;
	background-repeat: no-repeat;
	positon :relative;	
}
.card-header-is_closed{
    background-color: #EF5A31 ;
    color: #FFF ;
    font-weight: bold ;
    text-align: center ;
    float: right;
    margin: 15px 15px 0 0;
    border-radius: 50%;
    font-weight: bold;
    padding: 10px 10px;
    line-height: 20px;
	position: absolute;
	right: 0;
}

h1 {
    font-size: 22px;
    font-weight: bold;
}

.card-body {

}

.card-body-header{
	line-height: 25px;
	margin: 10px 20px 0px 20px;
}

.card-body-hashtag {
	color: #2478FF;
	font-style: italic;
}

.card-body-footer {
  	position: absolute; 
  	margin-top: 15px;
  	margin-bottom: 6px;
    bottom: 0; 
    width: 314px;
    font-size: 14px;
    color: #9FA5A8;
    padding: 0 15px;
}

.icon {
    display: inline-block;
    vertical-align: middle;
    margin-right: 2px;
}

.icon-count_text {
    width: 25px;
    height: 17px;
	background: url("images/eye.jpg") no-repeat;
}

.icon-count_view {
	margin-left: 5px;
	width: 25px;
    height: 17px;
	background: url("images/comment.jpg") no-repeat;	
}

.count_rate {
	float: right;
}

.outer {

}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
    <div class="outer">
        <h1 style="margin-left:10px">모든 프로젝트 둘러보기</h1>
        <h3 style="margin-left:10px; margin-bottom:10px"><%= allListCount %>개의 프로젝트가 있습니다.</h3>
		<hr>

		<div class="listArea" align="center">
			<%if(list.isEmpty()){ %>
				<h3>조회된 리스트가 없습니다.</h3>
			<%}else{ %>
				<%for(Project p : list){ 
					startDate = sdf.parse(p.getPrjStartDate());
		            endDate = sdf.parse(p.getPrjEndDate());
		            
		            if(today.getTime() < startDate.getTime()) {
		        %>
		        <a href=""> <!-- 클릭 시 링크 설정 -->
		        <% } else { %>
		        <a href="proInfo.list?num=<%= p.getPrjNo() %>"> <!-- 클릭 시 링크 설정 -->
		        <% } %>
		
		            <div class="card">
		
		                <!-- 카드 헤더 -->
		                <div class="card-header">
		                    <div class="card-header-is_closed">
		                        <% if(today.getTime() < startDate.getTime()) { %>
		                        	<div class="card-header-text">공개 예정</div>
		                        	<div class="card-header-number">D-<%= (startDate.getTime() - today.getTime()) / (24*60*60*1000) %></div>
		                        <% } else { %>
		                        <div class="card-header-text">남은 기간 </div>
		                        <div class="card-header-number"><%= (endDate.getTime() - startDate.getTime()) / (24*60*60*1000) %>일 </div>
		                        <% } %> 
		                    </div>
		                    <img src="resources/upfiles_project/<%= p.getAttachmentName() %>" width="100%" height="100%">
		                </div>
		
		                <!--  카드 바디 -->
		                <div class="card-body">
		
		                    <!--  카드 바디 헤더 -->
		                    <div class="card-body-header">
		                        <h1><%= p.getPrjTitle() %></h1>
		                        <p class="card-body-hashtag">#<%= p.getPrjCatName() %></p>
		                        <p class = "card-body-nickname"><%= p.getCreName() %></p>
		                    </div>
		
		                    <!--  카드 바디 본문 -->
		
		                    <!--  카드 바디 푸터 -->
		                    <div class="card-body-footer">
		                        <hr style="margin-bottom: 8px; opacity: 0.5; border-color: #EF5A31">
		                        <i class="icon icon-count_text"></i>모인 금액
		                        <i class="icon icon-count_view"></i><%= (int) p.getPrjCurrent() %>원
		                        <i class="count_rate"><%= (int) (p.getPrjCurrent() / p.getPrjTarget() * 100) %>% </i>
		                    </div>
		
		                </div>
		
		            </div>
		
		        </a>
		        <%} %>
			<%} %>
	    </div>
	    
	    <br><br>
		
		<!-- 페이징바 만들기 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%= request.getContextPath() %>/viewAll.pr?currentPage=1'"> &lt;&lt; </button>
		
			<!-- 이전페이지로(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/viewAll.pr?currentPage=<%= currentPage-1 %>'"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currentPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/viewAll.pr?currentPage=<%= p %>'"> <%= p %> </button>
				<%} %>
				
			<%} %>
			
			<!-- 다음페이지로(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%= request.getContextPath() %>/viewAll.pr?currentPage=<%= currentPage+1 %>'"> &gt; </button>
			<%} %>
		
			<!-- 맨 끝으로 (>>) -->
			<button onclick="location.href='<%= request.getContextPath() %>/viewAll.pr?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div> 
	</div>
	
	<br><br>
    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>