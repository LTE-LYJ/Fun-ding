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
	  <div id="body_content2">
        <div id="body">
                <div id="box">
                        <div id="creator">
                            <img id="rev_Img" src="resources/images/favicon.PNG">
                            <span id="name_area"><h4 id="rev_Name">창작자1s</h4></span>
                            <textarea name="contentarea" cols="110" rows="8" style="resize:none;" placeholder="--자 이내로 입력해주세요."></textarea>
                        </div>
                        <input type="button" id="btn_con" value="댓글작성"></input><br><br><br><br>
                        <hr>

                 <table id="reviewArea">
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
                        </tr>
                    </table>

                     
                </div>
            </div>
        </div> 
        <%@ include file="../common/footer.jsp" %>
        
        <script type="text/javascript">
        $('#proReview').css('color','black');
        $('#proInfo').click(function() {
	    	location.href="<%=request.getContextPath()%>/proInfo.list";
		});
	    $('#proReview').click(function() {
	    	location.href="<%=request.getContextPath()%>/proReview.list";
		});
	    $('#proAsk').click(function() {
	    	location.href="<%=request.getContextPath()%>/proAsk.list";
		});
        </script>
</body>
</html>