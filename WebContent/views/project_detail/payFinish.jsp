<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.project.model.vo.*, 
com.kh.project_detail.model.vo.*, com.kh.attachment.model.vo.*, java.util.Date, java.text.SimpleDateFormat"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
Project project = (Project)request.getAttribute("project");
Reward reword = (Reward)request.getAttribute("reword");
Order orderde = (Order)request.getAttribute("orderde");
ArrayList<ProjectAttachment> prjAttList = (ArrayList<ProjectAttachment>)request.getAttribute("prjAttList");
int coin = (Integer)session.getAttribute("coin");
Date date = new Date();
SimpleDateFormat sdFormat = new SimpleDateFormat("yy/MM/dd");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제완료</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/pay.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<div id="body_content1">
        <div id="content">
            <div id="content_in">
                <h3>펀딩 완료</h3>
                <h1 id="title"><%=project.getPrjTitle()%></h1>
                    <div id="pro">
                        <img id="proimage" src="resources/upfiles_project/<%=prjAttList.get(0).getChangeName()%>"  style="width: 236px; height: 145px;">
                            <div id="pro_ab">
                                <p id="pro_sub"  style="height:69px; width:810px; overflow: hidden; text-overflow: ellipsis;"><%=project.getPrjContent() %></p>
                                <h3 id="percent"><fmt:formatNumber value="<%=(float)project.getPrjCurrent()/project.getPrjTarget()%>" type="percent"/> 달성</h3>
                                    <div id="much">
                                        <h4>총 금액 : <fmt:formatNumber value="<%=project.getPrjCurrent()%>" groupingUsed="true"/> 원</h4>
                                        <h4>마감일 : <fmt:formatDate value="<%=sdFormat.parse(project.getPrjEndDate())%>" type="date" pattern="MM월 dd일"/> 
                                        ( <%=(sdFormat.parse(project.getPrjEndDate()).getTime()-(date.getTime()))/(24*60*60*1000)%> 일 남음 )</h4>
                                    </div>
                            </div>
                    </div>
                    <br><br><hr><br><br><br>
                    	<h1 id="finish">결제 완료 </h1>
                    	<h2 id="finishsub">결제되었습니다. 결제 내역은 마이페이지에서 확인 가능합니다.</h2>
                     <br><br><br><br><hr><br>
                <h3>펀딩 정보</h3>
                <form>
                    <table>
                        <tr>
                            <th><h3>펀딩 구성</h3></th>
                            <td><%=reword.getReContent() %></td>
                        </tr>
                        <tr>
                            <th><h3>펀딩 금액</h3></th>
                            <td colspan="2"><%=reword.getRwPrice() %> ( <%=reword.getRwPrice()/100 %>  코인 )</td>
                        </tr>
                        <tr>
                            <th><h3>마감일</h3></th>
                            <td colspan="2"><fmt:formatDate value="<%=sdFormat.parse(project.getPrjEndDate())%>" type="date" pattern="MM월 dd일"/></td>
                        </tr>
                    </table>
                </form>
                <br><br><hr><br>

                <h3>배송 정보</h3>
                <form>
                    <table>
                        <tr>
                            <th><h3>구매자</h3></th>
                            <td colspan="2"><%=orderde.getMemName()%></td>
                        </tr>
                        <tr>
                            <th><h3>연락처</h3></th>
                            <td colspan="2"><%=orderde.getPhone()%></td>
                        </tr>
                        <tr>
                            <th><h3>받는 사람</h3></th>
                            <td colspan="2"><%=orderde.getReceiverName()%></td>
                        </tr>
                        <tr>
                        <th><h3>배송지</h3></th>
                            <td><%=orderde.getShippingAddr() %></td>
                        </tr>
                    </table>
                </form>
				</script>
                <br><br><hr><br>
                <h3>결제</h3>
                <form>
                    <table>
                        <tr>
                            <th><h3>최종 금액</h3></th>
                            <td><h2 id="howMuch"><%=reword.getRwPrice()/100 %>  코인</h2></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th><h3>잔여 코인</h3></th>
                            <td class="count" id="haveCoin"><%=coin %> 코인</td>
                            <td></td>
                        </tr>
                    </table>
                </form>
                <br><br><br>
                <div id="btn">
                <input type="button" id="btn_back" value="이전 페이지로" onclick="history.go(-2)" ></input>
                <input type="button" id="btn_fini" value="홈으로 이동" onclick="goHome()"></input>
                </div>
            </div>
        </div>
    </div>
	<script type="text/javascript">
	function goHome() {
		 location.href="<%=request.getContextPath()%>";
	}
	</script>
	

<%@ include file="../common/footer.jsp" %>
</body>
</html>