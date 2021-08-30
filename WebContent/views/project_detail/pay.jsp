<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.kh.project.model.vo.Project, com.kh.project.model.vo.Reward, 
com.kh.project.model.vo.Creator, com.kh.project.model.vo.ProjectCat, java.util.Date, com.kh.attachment.model.vo.*
, com.kh.project_detail.model.vo.*,  java.text.SimpleDateFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
Project project = (Project)request.getAttribute("project");
ProjectCat projectCat = (ProjectCat)request.getAttribute("projectCat");
ArrayList<ProjectAttachment> prjAttList = (ArrayList<ProjectAttachment>)request.getAttribute("prjAttList");
int num= project.getPrjNo();
ArrayList<Reward> rewordList = (ArrayList<Reward>)request.getAttribute("rewordList");
ArrayList<Pay> payList = (ArrayList<Pay>)request.getAttribute("payList");
Reward re = (Reward)request.getAttribute("re");
int coin = (Integer)session.getAttribute("coin");
Date date = new Date();
SimpleDateFormat sdFormat = new SimpleDateFormat("yy/MM/dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제창</title>
<style type="text/css">
 .outer, .outer2, .outer3, .outer4, .outer5, .outer6{
		 	margin-top: 50px;
		  	padding-top: 30px;
            padding-bottom: 30px;
        	background-color:lightgray;
        	display:flex;
        	justify-content: center;
        	align-items: center;

        }
        .box_1{
            border: lightgray 3px solid;
            background-color: white;
            border-radius: 15px;
            width: 100%;
            max-width:498px;
            height:100%;
            padding: 25px;
        }
        #Ask_creater{
            margin-top: 0px;
        }
        .modal_n{
            margin-top: 0px;
            margin-bottom: 10px;
            width: 115px;
        }
        .modal_con{
        	resize: none; 
            min-height: 20px;
            margin-bottom: 10px;
            vertical-align: middle;
        }
        #AskBtn, #AskBtn0, .AskBtn, .payCash, .plusPayMeth1{
            float: right;
            background-color: lightgray;
            color: white;
            border: none;
            border-radius: 5px;
            font-weight: 800;
            font-size: 15px;
            width: 80px;
            height: 35px;
            margin-top: 17px;
            cursor: pointer;
		}
		th{
		vertical-align: top;
		}
		th :nth-child(1) {
		text-align: left;
		}
		th :nth-child(2) {
		text-align: right;
		}
		.AskBtn{
            float: right;
            background-color: lightgray;
            color: white;
            border: none;
            border-radius: 5px;
            font-weight: 800;
            font-size: 15px;
            width: 80px;
            height: 35px;
            margin-top: 17px;
            cursor: pointer;
		}
		#AskDetail{
			vertical-align: top;
		}
		 #bottom_right_button1, #bottom_right_button2, #bottom_right_button3, #creator_content, #bottom_right_button0,  #right_button0, #right_button1, #right_button2, #right_button3{
            width: 470px;
            margin-bottom: 3%;
            text-align: left;
            padding: 10px;
            word-break: break-all;
            color: black;
            border-radius: 10px;
            border: 3px solid lightgray;
            
        }
        #bottom_right_button1:hover, #bottom_right_button2:hover, #bottom_right_button3:hover, #bottom_right_button4:hover, #bottom_right_button0:hover, #right_button0:hover, #right_button1:hover, #right_button2:hover, #right_button3:hover, #right_button4:hover{
            background-color: orange;
            color: white; 
        }
        #bottom_right_button1:hover a, #bottom_right_button2:hover a, #bottom_right_button3:hover a, #bottom_right_button4:hover a , #bottom_right_button0:hover a, #right_button1:hover a, #right_button2:hover a, #right_button3:hover a, #right_button4:hover a{
            background-color: orange;
            color: white; 
        }
        .clicked_option, .clicked_option a{
            background-color: orange;
            color: white !important; 
        }
        #rePrice{
        	margin-top: 5px;
        	margin-bottom: 5px;
        }
        .b_btn4{
        	text-align: center;
        }
        .b_btn2, #right_button0 h2, #right_button1 h2, #right_button2 h2, #right_button3 h2,  #right_button4 h2,  #right_button5 h2{
        	margin-bottom: 5px;
        	margin-top: 5px;
        }
        #myInfo:hover, #myIn:hover, #mydeli:hover, #delivery:hover, #payCash:hover, #cashPay:hover, #plus_payM:hover, #Ask_change:hover  {
			color: black;
		}
		#myInfo, #myIn, #mydeli, #delivery, #payCash, #cashPay, #plus_payM, #Ask_change {
			color: black;
		}
		.clicked_optiontwo, .clicked_optiontwo a{
            background-color: orange;
            color: white !important; 
        }
        #cardInfo textarea, #cardInfo select, #doPayCheck textarea{
         margin-bottom: 15px;
        }
        #cardAgree{
        	width: 20px;
        	height: 20px;
        	margin-right: 10px;
        	vertical-align: middle;
        }
        #cardInfo input[type=number] {
         margin-bottom: 15px;
        }
        #agree{
        	margin-top: 5px;
        	vertical-align: middle;
        }
        #right_button0:hover{
        	color: white;
        }
        .outer5 td{
        	font-size: 10px;
			padding-bottom: 15px;    	
        }
         .outer6 td{
         	font-size: 10px;
         }
         button{
         cursor: pointer;
         }
</style>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/pay.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
 <div id="body_content1" style="background: white;">
        <div id="content">
            <div id="content_in">
                <h3>펀딩 하기</h3>
                <h1 id="title"><%=project.getPrjTitle()%></h1>
                    <div id="pro">
                        <img id="proimage" src="resources/upfiles_project/<%=prjAttList.get(0).getChangeName()%>" style="width: 236px; height: 145px;">
                            <div id="pro_ab">
                                <p id="pro_sub" style="min-height:0px; max-height:73px; width:810px; overflow: hidden; text-overflow: ellipsis; display: -webkit-box; -webkit-line-clamp: 3;-webkit-box-orient: vertical; word-wrap:break-word; line-height: 1.5em;" ><%=project.getPrjContent() %></p>
                                <h3 id="percent"><fmt:formatNumber value="<%=(float)project.getPrjCurrent()/project.getPrjTarget()%>" type="percent"/> 달성</h3>
                                    <div id="much">
                                        <h4>총 금액 : <fmt:formatNumber value="<%=project.getPrjCurrent()%>" groupingUsed="true"/> 원</h4>
                                        <h4>마감일 : <fmt:formatDate value="<%=sdFormat.parse(project.getPrjEndDate())%>" type="date" pattern="MM월 dd일"/> 
                                        ( <%=(sdFormat.parse(project.getPrjEndDate()).getTime()-(date.getTime()))/(24*60*60*1000)%> 일 남음 )</h4>
                                    </div>
                            </div>
                    </div>
                    <br><br><hr><br>
                <h3>펀딩 정보</h3>
                <form>
                    <table id="fundingChoice">
                        <tr>
                            <th><h3>펀딩 구성</h3></th>
                            <td id="contentFund"><%=re.getReContent() %></td>
                            <td><button type="button" class="paybt" onclick="changReword();">수정하기</button></td>
                        </tr>
                        <tr>
                            <th><h3>펀딩 금액</h3></th>
                            <td colspan="2" id="price"><%=re.getRwPrice() %> ( <%=re.getRwPrice()/100 %>  코인 )</td>
                        </tr>
                        <tr>
                            <th><h3>마감일</h3></th>
                            <td colspan="2"> <fmt:formatDate value="<%=sdFormat.parse(project.getPrjEndDate())%>" type="date" pattern="MM월 dd일"/></td>
                        </tr>
                    </table>
                </form>
                
                <script type="text/javascript">
                $(function() {
                	 $('.outer').hide();
                	 $(".outer2").hide();	
                	 $(".outer3").hide();	
                	 $(".outer4").hide();
                	 $(".outer5").hide();
                	 $(".outer6").hide();
				})
                </script>
                
     <div class="outer">
		<div class="box_1">
        <h3 id="Ask_creater">리워드 변경하기</h3>
        <br>
        <form id="reChangForm" action="<%=request.getContextPath()%>" method="post" onsubmit="return false;">
        <table>
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
	                    <input type="radio" style="display: none" value="<%=i%>" name="opt"></input>
	                       <div><h2 id="rePrice"><%=rewordList.get(i).getRwPrice() %> 원 (<%=rewordList.get(i).getRwPrice()/100%>코인)</h2></div>
	                        <div id="reName"><%=rewordList.get(i).getRwName() %></div>
	                        <div id="reContent"><%=rewordList.get(i).getReContent() %></div> 
	                </a>
	                </div>
					<%} %>
				<%} %>
        </table>
		<button id="AskBtn0" style="cursor: pointer;">수정완료</button>
        </form>
    </div>
    </div>
    
                <br><br><hr><br>
                <h3 id="myIn">내 정보 확인</h3>
                <form>
                    <table id="myInfo">
                        <tr>
                            <th><h3>구매자</h3></th>
                            <td colspan="2" id="userName"><%=loginUser.getMemName() %></td>
                        </tr>
                        <tr>
                            <th><h3>연락처</h3></th>
                            <td colspan="2" id="userPhone"><%=loginUser.getPhone() %></td>
                        </tr>
                        <tr>
                            <th><h3>이메일</h3></th>
                            <td colspan="2" id="userMail"><%=loginUser.getEmail() %></td>
                        </tr>
                        <tr>
                        <th><h3>배송지</h3></th>
                            <td id="userAddr"><%=loginUser.getAddress() %></td>
                        <td></td>
                        </tr>
                    </table>
                </form>
                <br><br><hr><br>
                <h3 id="mydeli">배송 정보</h3>
                <form id="finishform" name="finishform" action="<%=request.getContextPath()%>/payInsert.pay" method="post">
                    <table id="delivery">
                    	<tr>
                    	 <th><input type="hidden" id="prjNum" name="prjNum" value="<%=num%>"></th>
                         <td> <input type="hidden" id="reNum" name="reNum" value="<%=re.getRwNo()%>"></td>
                         <td>  <input type="hidden" id="rePrice" name="rePrice" value="<%=re.getRwPrice()%>"></td>
                    	</tr>
                        <tr>
                            <th><h3>구매자</h3></th>
                            <td colspan="2"><textarea cols="50" rows="1" id="userNameNew" name="userNameNew" placeholder="ex)홍길동" onKeyPress="hangul();"></textarea></td>
                        </tr>
                        <tr>
                            <th><h3>연락처</h3></th>
                            <td colspan="2"><textarea cols="50" rows="1" id="userPhoneNew" name="userPhoneNew" placeholder="ex)010-1111-2222"></textarea></td>
                        </tr>
                        <tr>
                            <th><h3>받는 사람</h3></th>
                            <td colspan="2"><textarea cols="50" rows="1" id="receiver" name="receiver" placeholder="ex)홍길동" onKeyPress="hangul();"></textarea></td>
                        </tr>
                        <tr>
                        <th><h3>배송지</h3></th>
                           <td> <input type="text" style="width: 415px; height: 21px" id="userAddrNew" name="address1" class="form-control postcodify_address" value="${ address1 }"  placeholder="ex) 서울시 강남구 역삼동"></input></td>
                        </tr>
                        <tr>
                            <th><h3>상세주소</h3></th>
                            <td><textarea cols="50" rows="1" id="userAddrsub" placeholder="ex)301호"></textarea></td>
                            <td><input type="hidden" id="deliAddr" name="deliAddr" value=""></td>
                            <td><button type="button" id="search_button" class="paybt">주소검색</button></td>
                            <td style="margin-left: 10px; width: 110px"><button type="button" class="btn_di"onclick="takeMy();">내정보 등록</button></td>
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
                <h3 id="cashPay">결제</h3>
                <form id="payCash">
                    <table id="finalCash">
                        <tr>
                            <th><h3>최종 금액</h3></th>
                            <td class="count" id="howMuch1"><%=re.getRwPrice()/100 %> 코인 &nbsp;&nbsp;=</td>
                            <input type="number" style="display: none" value="<%=re.getRwPrice()/100 %>" id="hoMuch11"></input>
                            <td><h2 id="howMuch2" style="display:inline; color: red;"><%=re.getRwPrice()/100 %></h2> <h2 style="display:inline; color: red;">코인</h2></td>
                            <td id="coinerr" style="width: 200px" >보유 코인이 부족합니다.</td>
                        </tr>
                        <tr>
                            <th><h3>보유 코인</h3></th>
                            <td class="count" id="howHave"><p style="display: inline;"><%=coin %></p><span> 코인</span></td>
                             <td ><input type="hidden" id="hidd" value=""></input></td>
                        </tr>
                        <tr>
                            <th><h3>부족한 코인</h3></th>
                            <%if((loginUser.getCoin())-(re.getRwPrice()/100)<0) {%>
                           <td colspan="2" class="count" id="lessCoin" style="color: red;"><%=Math.abs(loginUser.getCoin()-(re.getRwPrice()/100))%> 코인</td>
                            <%}else{ %>
                             <td colspan="2" class="count" id="lessCoin" style="color: red;">0 코인</td>
                            <%}%>
                        </tr>
                        <tr>
                        <th><h3>코인 충전하기</h3></th>
                            <td colspan="2"><textarea cols="50" rows="1" placeholder="충전할 금액을 숫자로 입력해주세요" id="getHowCoin" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></textarea></td>
                            <td><button type="button" class="paybt"onclick="checkCoin();">충전하기</button></td>
                        </tr>
                        <tr>
                            <th><h3>잔여 코인</h3></th>
                            <%if(loginUser.getCoin()-(re.getRwPrice()/100)>=0) {%>
                            <td class="count" id="leftCoin"><%=Math.abs(re.getRwPrice()/100-loginUser.getCoin())%> 코인</td>
                            <%}else{ %>
                             <td class="count" id="leftCoin">0 코인</td>
                            <%}%>
                        </tr>
                    </table>
                </form>
        <div class="outer2">
		<div class="box_1">
        <h3 id="Ask_change">충전하기</h3>
        <br>
        <form id="payMthList" action="<%=request.getContextPath()%>/" method="post" onsubmit="return false;">
        <table id="putPayM">
	             <%if(payList.isEmpty()){ %>
				
					<div id="right_button1" class="option">
		                <a href="#" class="b_btn2">
		                	조회된 결제 수단이 없습니다.
		                </a>
	                </div>
				<%}else{ %>
				<% for( int i=0; i<payList.size();i++){ %>
					<div id="right_button<%=i+1%>" class="option">
	                <a href="#" class="b_btn3">
	                    <input type="radio" style="display: none" value="<%=i%>" name="index"></input>
	                    <input type="radio" style="display: none" value="<%=payList.get(i).getBank() %>" name="bankhidden"></input>
	                    <input type="radio" style="display: none" value="<%=payList.get(i).getCardNo() %>" name="CardNohidden"></input>
	                    <input type="radio" style="display: none" value="<%=payList.get(i).getPayDate() %>" name="PayDatehidden"></input>
	                       <div><h2 id="bank<%=i%>"><%=payList.get(i).getBank() %></h2></div>
	                        <div id="cardNum<%=i%>"><%=payList.get(i).getCardNo() %></div>
	                        <div id="cardDate<%=i%>"><%=payList.get(i).getPayDate() %></div> 
	                </a>
	                </div>
					<%} %>
				<%} %>
        </table>
        </form>
        <h3 id="plus_payM">+ 결제 수단 추가</h3>
        <div id="bottom_right_button0" class="plusPayMethod">
	                <a href="#" class="b_btn4">
	                    <div>
	                        <div><h2>신용/체크카드등록</h2></div>    
	                    </div>
	                </a>
	                </div>
       <button id="AskBtn" onclick="deletePlus()">취소하기</button>
		<button id="AskBtn2" style="margin-right: 10px">충전하기</button>
    </div>
    </div>
    <div class="outer3">
		<div class="box_1">
        <h3 id="doPay">결제하기</h3>
        <br>
        <form id="doPayCheck" action="<%= request.getContextPath()%>/" method="post" onsubmit="return false;">
        <table>
	             <tr>
	             <th colspan="14">카드 비밀번호</th>
	             </tr><tr>
	             <th colspan="14"><textarea name="cardPwdCheck" id="cardPwdCheck" rows="1" cols="50" placeholder="비밀번호 숫자 4자리 입력해주세요" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></textarea></th>
	             </tr> <tr>
	              <th colspan="14">카드 유효기간</th>
	             </tr><tr>
	               <td colspan="14"><textarea  name="cardBirthCheck" id="cardBirthCheck" rows="10" cols="50" style="margin-bottom: 15px" placeholder="ex)202105" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></textarea></td>
	             </tr>
        </table>
       <button class="AskBtn" onclick="deletePlus()">취소하기</button>
		<button class="payCash" onclick="checkcardPwdnDate()" style="margin-right: 10px">결제하기</button>
        </form>
    </div>
    </div>
     <div class="outer4">
		<div class="box_1">
        <br>
        <form id="cardInfo" name="cardInfo" action="<%=request.getContextPath() %>/" method="post" onsubmit="return false">
        <table>
        		 <tr>
	             <th colspan="8"><h3 id="Ask_change" style="width: 300px; margin-bottom: 30px;"">신용/체크 카드 등록</h3></th>
	             </tr><tr>
	             <th colspan="8">은행명</th>
	             </tr><tr>
	              <td colspan="8"><select name="cardName" id="cardName" style="height: 26px" placeholder="슷지민 입력해 주세요">
						    <option value="신한">신한</option>
						    <option value="농협">농협</option>
						    <option value="우리">우리</option>
						    <option value="KB국민">KB국민</option>
						    <option value="하나">하나</option>
						    <option value="카카오뱅크">카카오뱅크</option>
	              </select></td>
	             </tr><tr>
	             <th colspan="8" title="-를 제외한 총 16자리의 숫자를 입력해주세요">카드번호</th>
	             </tr><tr >
	              <td style="width: 55px; "><textarea  name="cardN1" id="cardN1" rows="1" cols="7" title="-를 제외한 총 16자리의 숫자를 입력해주세요" placeholder=" 0 0 0 0" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></textarea></td>
	              <td style="width: 7px; padding-bottom: 25px">-</td>
	              <td style="width: 55px"><textarea  name="cardN2" id="cardN2" rows="1" cols="7" placeholder=" 0 0 0 0" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></textarea></td>
	               <td style="width: 7px; padding-bottom: 25px"">-</td>
	              <td style="width: 55px"><textarea  name="cardN3" id="cardN3" rows="1" cols="7" placeholder=" 0 0 0 0" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></textarea></td>
	               <td style="width: 7px;padding-bottom: 25px"">-</td>
	              <td style="width: 55px"><textarea  name="cardN4" id="cardN4" rows="1" cols="7" placeholder=" 0 0 0 0" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></textarea></td>
	              <td style="width: 100px"></td>
	             </tr><tr>
	             <th colspan="8">카드 유효기간</th>
	             </tr><tr>
	            <td colspan="2"><select name="cardYe" id="cardYe" style="height: 29px; width: 80px"></select></td>
	            <td><select name="cardMo" id="cardMo" style="height: 29px; width: 80px"></select></td>
	             </tr><tr>
	             <th colspan="8">결제 비밀번호</th>
	             </tr><tr>
	             <td colspan="8"><textarea name="cardPwd" id="cardPwd" rows="10" cols="50" style="margin-bottom: 15px" placeholder="비밀번호 숫자 4자리 입력해주세요" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></textarea></td>
	             </tr><tr>
	              <th colspan="8">생년월일</th>
	             </tr><tr>
	               <td colspan="8"><textarea  name="cardBirth" id="cardBirth" rows="10" cols="50" style="margin-bottom: 15px" placeholder="ex)19920101" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></textarea></td>
	             </tr>   
	             <tr>
	             <td colspan="8"><input type="checkbox" id="cardAgree"></input><label for="cardAgree">결제시 정보 제공 동의</label></td>
	             </tr>     
	             </table>
       <button class="AskBtn" onclick="goBack()">취소하기</button>
		<button class="plusPayMeth1" style="margin-right: 10px">카드등록</button>
        </form>
    </div>
    </div>
    <script type="text/javascript">
    	function goBack() {
    		$(".outer2").slideDown();
			$(".outer3").hide();
			$(".outer4").hide();
			$(".outer5").hide();
			$(".outer6").hide();
		}
    	function deletePlus() {
			$('.outer2').hide();
			$(".outer3").hide();
			$(".outer4").hide();
			$(".outer5").hide();
			$(".outer6").hide();
			return false;
		}
    	$(document).on("click", ".plusPayMethod", function(){
    		$(".outer4").slideDown();
    		$(".outer2").slideUp();
    		$(".outer3").hide();
    		$(".outer5").hide();
    		$(".outer6").hide();
		});
    </script>
                <br><br><hr><br>
                <h3>약관 동의</h3>
                <form>
                    <table class="checkbox_group">
                        <tr>
                            <th class="checkbox"><input type="checkbox" id="check_all"></th>
                            <td ><h4><label for="check_all">전체 동의 하기</label></h4></td>
                        </tr>
                        <tr>
                            <th  class="checkbox"><input type="checkbox" id="check_1" class="normal"></th>
                            <td ><h4><label for="check_1">제3 자에 대한 개인 정보 제공 동의 (필수)</label></h4></td>
                            <td><a onclick="threeAgree()" style="cursor: pointer;">보기</a></td>
                        </tr>
                        <tr>
                            <th  class="checkbox"><input type="checkbox" id="check_2" class="normal"></th>
                            <td ><h4><label for="check_2">펀딩  유의 사항 확인 (필수)</label></h4></td>
                            <td><a onclick="FundsAgree()" style="cursor: pointer;">보기</a></td>
                        </tr>
                    </table>
                </form>
     <div class="outer5">
		<div class="box_1">
        <table id="cardInfo" name="cardInfo">		
        		<tr>
        		<th colspan="3"><h3 style="width: 400px">제3 자에 대한 개인 정보 제공 동의 (필수)</h3></th>
        		</tr>
        		 <tr>
	             <th >정보 제공</th>
	             </tr><tr>
	              <td colspan="3" id="threeAgree"><p>회원의 개인정보는 당사의 개인정보 취급방침에 따라 안전하게 보호됩니다. '회사'는 이용자들의 
	              개인정보를 개인정보 취급방침의 '제 2조 수집하는 개인정보의 항목, 수집방법 및 이용목적'에서 고지한 범위 내에서 사용하며, 
	              이용자의 사전 동의 없이는 동 범위를 초과하여 이용하거나 원칙적으로 이용자의 개인정보를 외부에 공개하지 않습니다.<p>
						    </td>
	             </tr><tr>
	             <td >제공 받는자</td>
	             <td colspan="2">후원 프로젝트의 창작자</td>
	             </tr><tr>
	             <td >제공 목적</td>
	             <td colspan="2">선물 전달 및 배송과 관련된 상담 및 민원처리</td>
	             </tr><tr>
	              <td>제공 정보</td>
	              <td colspan="2" >수취인 성명, 휴대전화번호, 배송 주소</td>
	             </tr> 
	             <td >보유 및 이용기간</td>
	              <td colspan="2" >재화 또는 서비스의 제공이 완료된 즉시 파기(단, 관계법령에 정해진 규정에 따라 법정기간 동안 보관)</td>
	             <tr>
	             <td colspan="3">* 동의 거부권 등에 대한 고지</td>
	             </tr>   
	             <tr>
	             <td colspan="3">개인정보 제공은 서비스 이용을 위해 꼭 필요합니다. 개인정보 제공을 거부하실 수 있으나, 이 경우 서비스 이용이 제한될 수 있습니다.</td>
	             </tr>   
	             <tr>
	             <td colspan="3"><input type="checkbox" id="threeAgreech" style="width: 15px; height: 15px"></input><label for="threeAgreech" style="font-size: 15px">정보에 제공 동의합니다.</label></td>
	             </tr>    
	             </table>
    </div>
    </div>
    <div class="outer6">
		<div class="box_1">
        <table id="mustCheck" name="mustCheck" >		
        		<tr>
        		<th ><h3 style="width: 400px">펀딩 유의사항 확인</h3></th>
        		</tr>
				<tr>
	              <td id="mustCheckA"><p>후원은 구매가 아닌 창의적인 계획에 자금을 지원하는 일입니다.
	              Fun-ding에서의 후원은 아직 실현되지 않은 프로젝트가 실현될 수 있도록 제작비를 후원하는 과정으로, 기존의 
	              상품 또는 용역을 거래의 대상으로 하는 매매와는 차이가 있습니다. 따라서 전자상거래법상 청약철회 등의 규정이 적용되지 않습니다.<p>
						    </td>
	             </tr><tr>
	             <td ><p>프로젝트는 계획과 달리 진행될 수 있습니다.
	             예상을 뛰어넘는 멋진 결과가 나올 수 있지만 진행 과정에서 계획이 지연, 변경되거나 무산될 수도 있습니다. 
	             본 프로젝트를 완수할 책임과 권리는 창작자에게 있습니다.<p></td>
	             </tr><tr>
	             <td><p>펀딩 후 리워드를 제작・준비하는 크라우드펀딩 특성상 품질 이슈가 발생할 수 있습니다.
					리워드는 즉시 배송되지 않고, 메이커가 약속한 발송시작일에 발송됩니다. 때문에 품질 이슈가 발생할 수 있습니다. 
					만일 수령한 리워드에 하자가 존재하거나 메이커가 약속한 발송시작일에 발송이 이루어지지 않은 경우 펀딩금 반환 신청이 가능합니다.<p></td>
	             </tr>
	             <td >* 단, 아래 어느 하나에 해당될 경우 펀딩금 반환은 불가합니다.</td>
	             </tr>   
	             <tr>
	             <td ><p>메이커가 프로젝트 페이지 내에 명시적으로 고지한 하자 불인정 사유에 해당하는 경우
								(예) 공장 제작 과정상 벌어짐 방지를 위해 봉제되어 제공되는 포켓은 하자 사유가 되지 않습니다.
								1. 서포터의 귀책 사유로 리워드의 일부 혹은 전체가 분실/파손/고장/오염/훼손이 발생된 경우, 
								2. 모니터 해상도의 차이로 인해 색상이나 이미지가 실제와 다른 경우 3. 공연, 디지털컨텐츠, 
								여행 패키지 상품, 무형 서비스 및 컨텐츠의 제공이 완료되었을 경우</p></td>
	             </tr>   
	             <tr>
	             <td colspan="3"><input type="checkbox" id="mustCheckAbout"  style="width: 15px; height: 15px"></input><label for="mustCheckAbout" style="font-size: 15px">펀딩 유의사항에 제공 동의합니다.</label></td>
	             </tr>    
	             </table>
    </div>
    </div>
                <br><br><br>
                <div id="btn">
                <input type="button" id="btn_back" value="이전 페이지로" onclick="history.back()" ></input>
                <input type="button" id="btn_fini" value="결제 완료" onclick="payFinish();"></input>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../common/footer.jsp" %>
    
    <script type="text/javascript">
    var gogo;
    
    $(document).on('click', "#check_1", function(){
			if($("#threeAgreech").is(':checked')){
 			$("#threeAgreech").prop('checked', false);
 		}else{
 			$("#threeAgreech").prop('checked', true);
 		}
    	
     });
    $(document).on('click', "#check_2", function(){
		if($("#mustCheckAbout").is(':checked')){
			$("#mustCheckAbout").prop('checked', false);
		}else{
			$("#mustCheckAbout").prop('checked', true);
		}
	
	 });
	    $(document).on('click', "#threeAgreech", function(){
			if($("#check_1").is(':checked')){
				$("#check_1").prop('checked', false);
			}else{
				$("#check_1").prop('checked', true);
			}
		
	 });
	$(document).on('click', "#mustCheckAbout", function(){
		if($("#check_2").is(':checked')){
			$("#check_2").prop('checked', false);
		}else{
			$("#check_2").prop('checked', true);
		}
	
	});
	$(document).on('click', "#check_all", function(){
		if($("#check_all").is(':checked')){
			$("#threeAgreech").prop('checked', true);
			$("#mustCheckAbout").prop('checked', true);
		}else{
			$("#threeAgreech").prop('checked', false);
			$("#mustCheckAbout").prop('checked', false);
		}
	
	});
	    
    </script>
     <script type="text/javascript">
     $(document).ready(function(){            
    	    var now = new Date();
    	    var year = now.getFullYear();
    	    var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
    	    for(var i = year ; i <= year+20 ; i++) {
    	        $('#cardYe').append('<option value="' + i + '">' + i + '년</option>');    
    	    }
    	    for(var i=1; i <= 12; i++) {
    	        var mm = i > 9 ? i : "0"+i ;            
    	        $('#cardMo').append('<option value="' + mm + '">' + mm + '월</option>');    
    	    }
    	    $("#cardYe  > option[value="+year+"]").attr("selected", "true");        
    	    $("#cardMo  > option[value="+mon+"]").attr("selected", "true");    
    	  
    	})
     
     	function threeAgree() {
     		$(".outer5").slideToggle();
    		$(".outer6").hide();
		}
     	function FundsAgree() {
     		$(".outer6").slideToggle();
    		$(".outer5").hide();
		}
     
	    var opt = "";
	    var opt2="";
	    var opt3="";
	    var opt4="";
	    $('.option').each(function(index){
	        $(this).attr('option-index', index);
	            }).click(function(){
	            	opt = "";
	            	opt2="";
	            	opt3="";
	            	opt4="";
	                var index = $(this).attr('option-index');
	                $('.option[option-index=' + index + ']').addClass('clicked_option'); 
	                $('.option[option-index!=' + index + ']').removeClass('clicked_option');
	                $("input[name='rewordNum']").prop('checked', true);
	                opt+=$(this).find('input').val();
	                opt2+=$(this).find('input[name="bankhidden"]').val();
	                opt3+=$(this).find('input[name="CardNohidden"]').val();
	                opt4+=$(this).find('input[name="PayDatehidden"]').val();
	    });
	    
	    $(document).on('click', "#AskBtn0", function(){
	    	location.href="<%=request.getContextPath()%>/paylist.pa?opt="+opt +"&num="+<%=num%>;
	    	
         });
	    $(document).ready(function() { 
	    	$.ajax({
	               url:"getCoin.pay",
	               type:"post",
	               async:false,
	               data:{ writer : <%=loginUser.getMemNo()%>},
	               success:function(getCoin){
	            	   var v = "";
	            	   var les="";
	            	   var lef="";
       	   			   getCoin*=1;
	            	   v= getCoin +' 코인';
	            	   les = <%=re.getRwPrice()/100 %>-getCoin
               	   if(les<0){
               		les="0 코인";
               		$("#coinerr").hide();
               	   }else if(les=0){
               		les="0 코인";       
               		$("#coinerr").hide();
               	   }else{
               		les = <%=re.getRwPrice()/100 %>-getCoin +' 코인'
               		$("#coinerr").show();
               	   }
			       	   	var lef ="";
			       	 lef= getCoin-<%=re.getRwPrice()/100 %>
            	   if(lef<0){
            		   lef="0 코인";
            		   $("#coinerr").show();
            	   }else if(lef=0){
            		   lef="0 코인";
            		   $("#coinerr").hide();
            	   }else{
            		   lef= Math.abs(getCoin-<%=re.getRwPrice()/100 %>)+' 코인'
            		   $("#coinerr").hide();
            	   }
 	            	  $("#howHave").empty();
                      $("#lessCoin").empty();
                      $("#leftCoin").empty();
 	               	  $("#howHave").html(v);
	 	              $("#lessCoin").html(les);
	                  $("#leftCoin").html(lef);
	                  gogo=v
		            },
	               error:function(){
	                  console.log("ajax 통신 실패 - 댓글 등록");
	               }
	            });
	    });
	    
	    $(document).on("click", "#AskBtn2", function(){
   		 if($("#getHowCoin").val().trim().length==0){
       		 alert("결제할 금액을 입력해주세요");
       		$("#getHowCoin").focus();
       		 return false;
       	 } else if(opt2==""){
       		alert("결제 수단을 선택해주세요");
      		 return false;
       	 }
			$(".outer3").show();
			$(".outer2").hide();
			$(".outer4").hide();
		});
	    
          $(document).on('click', ".plusPayMeth1", function(){
        	  var cardName = $("#cardName").val().trim();
        	  var cardN1 = $("#cardN1").val().trim();
        	  var cardN2 = $("#cardN2").val().trim();
        	  var cardN3 = $("#cardN3").val().trim();
        	  var cardN4 = $("#cardN4").val().trim();
        	  var cardMo = $("#cardMo").val().trim();
        	  var cardYe = $("#cardYe").val().trim();
        	  var cardPwd = $("#cardPwd").val().trim();
        	  var cardBirth = $("#cardBirth").val().trim();
        	  var birthA= /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;

        	  if(cardN1.trim().length!=4||cardN2.trim().length!=4||cardN3.trim().length!=4||cardN4.trim().length!=4){
        		  alert("잘못된 카드번호를 입력하였습니다.");
        		  return false;
        	  } else if(cardPwd.trim().length!=4){
        		  alert("비밀번호를 확인해주세요");
        		  cardPwd.focus();
        		  return false;
        	  } else if(cardBirth.trim().length!=8||!birthA.test($("#cardBirth").val())){
        		  alert("생년월일을 확인해주세요");
        		  return false;
        	  }else if($("#cardAgree").is(":checked") == false){
        		  alert("약관에 동의해주세요");
        		  return false;
        	  }
        	  
            $.ajax({
               url:"insert.payM",
               type:"post",
               data:{
            	   cardName : cardName,
            	   cardN1 : cardN1,
            	   cardN2 : cardN2,
            	   cardN3 : cardN3,
            	   cardN4 : cardN4,
            	   cardMo : cardMo,
            	   cardYe : cardYe,
            	   cardPwd : cardPwd,
            	   cardBirth : cardBirth
            	   },
               success:function(list){
            		   	var valueTwo = ""
            		   	$(".outer4").hide();
            		   	$(".outer2").show();
            		   	$("#payMthList").empty(); 
            			   for(var i in list){
            				   i*=1;
            				   valueTwo+= 
            					   '<div id="right_button'+(i+1)+'" class="option">'+
			 	                	'<a class="b_btn3">'+
			 	                    '<input type="radio" style="display: none" value="'+i+'" name="index"></input>'+
			 	                   '<input type="radio" style="display: none" value="'+list[i].bank+'" name="bankhidden"></input>'+
				                    '<input type="radio" style="display: none" value="'+list[i].cardNo+'" name="CardNohidden"></input>'+
				                    '<input type="radio" style="display: none" value="'+list[i].payDate+'" name="PayDatehidden"></input>'+
			 	                       '<div><h2 id="bank"'+i+'>'+list[i].bank+'</h2></div>'+
			 	                        '<div id="cardNum"'+i+'>'+list[i].cardNo+'</div>'+
			 	                        '<div id="cardDate"'+i+'>'+list[i].payDate+'</div>'+ 
			 	                	'</a>'+
			 	                	'</div>'
            			   }
            			$("#payMthList").append('<table id="putPayM"></table>');
    	               	$("#putPayM").html(valueTwo);
    	                  $("#cardN1").val("")
	    	          	  $("#cardN2").val("")
	    	          	  $("#cardN3").val("")
	    	          	  $("#cardN4").val("")
	    	          	  $("#cardPwd").val("")
	        	  		  $("#cardBirth").val("")
	            },
               error:function(){
                  console.log("ajax 통신 실패 - 댓글 등록");
               }
            })
         });
          $('a[href="#"]').click(function(e) {
  			e.preventDefault();
  		    });

        </script>
        <script type="text/javascript">
        function checkcardPwdnDate() {
	    	var cardP = $("#cardPwdCheck").val().trim();
	    	var cardD = $("#cardBirthCheck").val().trim();

	    	$.ajax({
	               url:"checkPwdnDate.pay",
	               type:"post",
	               data:{cardP : cardP,
	            	   	cardD : cardD, 
	            	   	opt3:opt3
	            	   },
	               success:function(status){
	            	   if(status=="success"){
	            		   insertPayCoin();
	            	   } else {
	            		   alert("카드 정보가 일치 하지 않습니다.")
	            	   }
	            	   $("#cardPwdCheck").val("");
	            	   $("#cardBirthCheck").val("");
		            },
	               error:function(){
	                  console.log("ajax 통신 실패 - 댓글 등록");
	               }
	            });
		}
		
		function insertPayCoin() {
			var coin = $("#getHowCoin").val();
			$.ajax({
	               url:"plusCoin.pay",
	               type:"post",
	               async:false,
	               data:{coin : coin},
	               success:function(getCoin){
	            	   getCoin*=1;
	            	   var value = ""
    	            	   value= getCoin+' 코인'
    	            	var less ="";
	            	   			less = <%=re.getRwPrice()/100 %>-getCoin
                        	   if(less<0){
                        		   less="0 코인";
                        		   $("#coinerr").hide();
                        	   }else if(less=0){
                        		   less="0 코인";
                        		   $("#coinerr").hide();
                        	   }else{
                        		   less = <%=re.getRwPrice()/100 %>-getCoin +' 코인'
                        		   $("#coinerr").show();
                        	   }
	            	   	var left ="";
	            	   		left= getCoin-<%=re.getRwPrice()/100 %>
	                 	   if(left<0){
	                 		  left="0 코인";
	                 		  $("#coinerr").show();
	                 	   }else if(left=0){
	                 		  left="0 코인";
	                 		 $("#coinerr").hide();
	                 	   }else{
	                 		 left= Math.abs(getCoin-<%=re.getRwPrice()/100 %>)+' 코인'
	                 		$("#coinerr").hide();
	                 	   }
	            	   			
                        $("#howHave").empty();
                        $("#lessCoin").empty();
                        $("#leftCoin").empty();
                        $("#howHave").html(value);
    	               	$("#lessCoin").html(less);
    	               	$("#leftCoin").html(left);
	            	    $(".outer3").slideUp();
	            	    $("#getHowCoin").val("");
	            	    gogo=value;
		            },
	               error:function(){
	                  console.log("ajax 통신 실패 - 댓글 등록");
	               }
	            });
		}
        
        </script>
        
    <script>
    $('#check_all').click(function() {
    	$('.normal').prop('checked');
	})
    
	$(document).on("keyup", "#userPhoneNew", function() { 
		$(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") ); 
	});
	
	var phonerules= /^(0(2|3[1-3]|4[1-4]|5[1-5]|6[1-4]))-(\d{3,4})-(\d{4})$/;
	var phonerules2 =/^(?:(010-\d{4})|(01[1|6|7|8|9]-\d{3,4}))-(\d{4})$/;
	
	function payFinish() {
    	if($('#userNameNew').val().trim().length==0||$('#userPhoneNew').val().trim().length==0||$('#receiver').
    			val().trim().length==0||$('#userAddrNew').val().trim().length==0){
    		alert("모두 입력해주세요");
    	}else if($("#check_all").is(":checked") == false||$("#check_1").is(":checked") == false||$("#check_2").is(":checked") == false){
    		alert("약관 동의를 체크해 주세요");
    	}else if(!phonerules.test($("#userPhoneNew").val())&&!phonerules2.test($("#userPhoneNew").val())){
    		alert("배송지 연락처를 확인해주세요");
    	}else if(gogo<<%=re.getRwPrice()/100 %>){
    		alert("결제 가능한 금액이 부족합니다.");
    	}else if($('#userNameNew').val().length>10||$('#receiver').val().length>10){
    		alert("배송지 이름으로 가능한 글자수를 초과했습니다.");
    	}else{
    		
    		$("#deliAddr").val($("#userAddrNew").val()+" "+$("#userAddrsub").val())
    		
    		$("#finishform").submit();
     	}
    	
	}
	
	function hangul(){ 
		if((event.keyCode < 12592) || (event.keyCode > 12687)){ 
			alert("한글만 입력이 가능합니다."); 
			event.returnValue = false 
			} 
		}

    
    function takeMy() {
		$("#userNameNew").val($('#userName').text());
		$("#userPhoneNew").val($('#userPhone').text());
		$("#userAddrNew").val($('#userAddr').text());
	}
    </script>
    <script type="text/javascript">
    function changReword() {
    	$(".outer").slideToggle();	
    	$(".outer").show();	
	}
    function checkCoin() {
    	$(".outer2").slideToggle();	
    	$(".outer2").show();	
    	$(".outer3").hide();	
    	$(".outer4").hide();	
    	$(".outer5").hide();
    	$(".outer6").hide();
    }
    
    $(".checkbox_group").on("click", "#check_all", function () {
        $(this).parents(".checkbox_group").find('input').prop("checked", $(this).is(":checked"));
    });
    
    $(".checkbox_group").on("click", ".normal", function() {
        var is_checked = true;
        
        $(".checkbox_group .normal").each(function(){
            is_checked = is_checked && $(this).is(":checked");
        });
        
        $("#check_all").prop("checked", is_checked);
    });
    
    
    </script>
</body>
</html>