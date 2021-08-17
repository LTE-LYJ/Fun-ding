<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
				<jsp:include page="projectDetailView.jsp"/>
 <!---                         프로젝트 관련 내용 sub1 부분                -->
	                <div id="body_content2">
	
	                    <div id="bottom_content">
	                <div id="bottom_left_content">
	                    프로젝트 관련 내용
	                </div>
	
	
	                <aside id="aside2">
	                <div id="bottom_right_button1" class="option">
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
	                </div>
	                <div id="creator_content">
	                    <div><img class="profile" src="resources/images/favicon.PNG" style="width: 40px; height: 40px; border-radius: 70%; vertical-align: middle;">
	                    <span><h4 style="display: inline-flex; margin-left: 10px; margin-top:20px">창작자1</span></div><br>
	                    <div>보이는 끝까지 찾아다녀도 목숨이 있는 때까지 방황하여도 보이는 것은 거친 모래뿐일 것이다 
	                        이상의 꽃이 없으면 쓸쓸한 인간에 남는 것은 영락과 부패 있다.</div><br><br>
	                    <div><h4 style="display: inline;">진행한 프로젝트</h4> <span><h4 style="display: inline;">5건</h4></span></div>
	                </div>
	            </aside>
	        </div>
	
	    </div>
			    <%@ include file="../common/footer.jsp" %>
			    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
	    <script>
	    $('#proInfo').css('color','black');
	    $('#proInfo').click(function() {
	    	location.href="<%=request.getContextPath()%>/proInfo.list";
		});
	    $('#proReview').click(function() {
	    	location.href="<%=request.getContextPath()%>/proReview.list";
		});
	    $('#proAsk').click(function() {
	    	location.href="<%=request.getContextPath()%>/proAsk.list";
		});
	    $('.option').each(function(index){
	        $(this).attr('option-index', index);
	            }).click(function(){
	                var index = $(this).attr('option-index');
	                $('.option[option-index=' + index + ']').addClass('clicked_option'); 
	                $('.option[option-index!=' + index + ']').removeClass('clicked_option');
	    });
	
	    $('a[href="#"]').click(function(e) {
		e.preventDefault();
	    });
	    </script>
</body>
</html>