<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제창</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/pay.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
 <div id="body_content1">
        <div id="content">
            <div id="content_in">
                <h3>펀딩 하기</h3>
                <h1 id="title">얼마나 생생하며 그들의 눈에 CD</h1>
                    <div id="pro">
                        <img id="proimage" src="">
                            <div id="pro_ab">
                                <p id="pro_sub">동산에는 사랑의 풀이 돋고 이상의 꽃이 피고 또 다시 동산에는 사랑의 풀이 돋고 
                                    이상의 꽃이 피고 희망의 놀이 뜨고 열락의 새가 운다사랑의 풀이 없으면 인간은 
                                    사막이다 오아이스도 없는 거친 모래뿐일 것이다. -- 간단한 프로젝트 설명</p>
                                <h3 id="percent">144% 달성</h3>
                                    <div id="much">
                                        <h4>총 금액 : 14,400,600 원</h4>
                                        <h4>마감 :  7월14일 ( 24일 남음 )</h4>
                                    </div>
                            </div>
                    </div>
                    <br><br><hr><br>
                <h3>펀딩 정보</h3>
                <form>
                    <table>
                        <tr>
                            <th><h3>펀딩 구성</h3></th>
                            <td>배송비 미포함
                                * 쿠로의 아름다운 개소리. CD
                                * 쿠로의 10살 기념 포토카드 Ver 3-랜덤 발송</td>
                            <td><button type="button" class="paybt" onclick="checkLogin();">수정하기</button></td>
                        </tr>
                        <tr>
                            <th><h3>펀딩 구성</h3></th>
                            <td colspan="2">15,800원 ( 158  코인 )</td>
                        </tr>
                        <tr>
                            <th><h3>배송일(예상)</h3></th>
                            <td colspan="2">2021년 8월 20일</td>
                        </tr>
                    </table>
                </form>
                <br><br><hr><br>
                <h3>내 정보 확인</h3>
                <form>
                    <table>
                        <tr>
                            <th><h3>구매자</h3></th>
                            <td colspan="2" id="userName">이주연</td>
                        </tr>
                        <tr>
                            <th><h3>연락처</h3></th>
                            <td colspan="2" id="userPhone">010 - 4888 - 1234</td>
                        </tr>
                        <tr>
                            <th><h3>이메일</h3></th>
                            <td colspan="2" id="userMail">jydu@naver.com</td>
                        </tr>
                        <tr>
                        <th><h3>배송지</h3></th>
                            <td id="userAddr">서울시 강남구 도산대로 12길 24 꽃님빌딩 302호</td>
                        <td><button type="button" class="paybt"onclick="checkLogin();">수정하기</button></td>
                        </tr>
                    </table>
                </form>
                <br><br><hr><br>
                <h3>배송 정보</h3>
                <form>
                    <table>
                        <tr>
                            <th><h3>구매자</h3></th>
                            <td colspan="2"><textarea cols="50" rows="1" id="userNameNew"></textarea></td>
                        </tr>
                        <tr>
                            <th><h3>연락처</h3></th>
                            <td colspan="2"><textarea cols="50" rows="1" id="userPhoneNew"></textarea></td>
                        </tr>
                        <tr>
                            <th><h3>받는 사람</h3></th>
                            <td colspan="2"><textarea cols="50" rows="1"></textarea></td>
                        </tr>
                        <tr>
                        <th><h3>배송지</h3></th>
                            <td><textarea cols="50" rows="1" id="userAddrNew"></textarea></td>
                        </tr>
                        <tr>
                            <th><h3>상세주소</h3></th>
                            <td><textarea cols="50" rows="1"></textarea></td>
                            <td><button type="button" id="search_button" class="paybt"onclick="address();">주소검색</button></td>
                            <td><button type="button" class="btn_di"onclick="takeMy();">내정보 등록</button></td>
                        </tr>
                    </table>
                </form>
                <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
				<script>
					$(function(){
						$("#search_button").postcodifyPopUp();
					});
				</script>
                <br><br><hr><br>
                <h3>결제</h3>
                <form>
                    <table>
                        <tr>
                            <th><h3>배송비</h3></th>
                            <td colspan="2" class="count">20  코인</td>
                        </tr>
                        <tr>
                            <th><h3>최종 금액</h3></th>
                            <td class="count">158 + 20  =</td>
                            <td><h2 id="howMuch">178 코인</h2></td>
                            <td id="coinerr" >보유 코인이 부족합니다.</td>
                        </tr>
                        <tr>
                            <th><h3>보유 코인</h3></th>
                            <td class="count">150  코인</td>
                        </tr>
                        <tr>
                        <th><h3>코인 충전하기</h3></th>
                            <td colspan="2"><textarea cols="50" rows="1" placeholder="충전할 금액을 입력해주세요"></textarea></td>
                            <td><button type="button" class="paybt"onclick="checkCoin();">충전하기</button></td>
                        </tr>
                        <tr>
                            <th><h3>잔여 코인</h3></th>
                            <td class="count">150 코인</td>
                        </tr>
                    </table>
                </form>
                <br><br><hr><br>
                <h3>약관 동의</h3>
                <form>
                    <table>
                        <tr>
                            <th class="checkbox"><input type="checkbox" id="check_all"></th>
                            <td ><h4><label for="check_all">전체 동의 하기</label></h4></td>
                        </tr>
                        <tr>
                            <th  class="checkbox"><input type="checkbox" id="check_1" class="normal"></th>
                            <td ><h4><label for="check_1">제3 자에 대한 개인 정보 제공 동의 (필수)</label></h4></td>
                            <td><a>보기</a></td>
                        </tr>
                        <tr>
                            <th  class="checkbox"><input type="checkbox" id="check_2" class="normal"></th>
                            <td ><h4><label for="check_2">펀딩  유의 사항 확인 (필수)</label></h4></td>
                            <td><a>보기</a></td>
                        </tr>
                    </table>
                </form>
                <br><br><br>
                <div id="btn">
                <input type="button" id="btn_back" value="이전 페이지로" onclick="history.back()" ></input>
                <input type="button" id="btn_fini" value="결제 완료" onclick="payFinish();"></input>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../common/footer.jsp" %>
    <script>
    $('#check_all').click(function() {
    	$('.normal').prop('checked');
	})
    
	function payFinish() {
    	location.href="<%=request.getContextPath()%>/payFinish.pa";
		
	}
    function takeMy() {
		$("#userNameNew").val($('#userName').text());
		$("#userPhoneNew").val($('#userPhone').text());
		$("#userAddrNew").val($('#userAddr').text());
	}
    </script>
</body>
</html>