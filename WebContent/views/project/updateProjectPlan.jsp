<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.project.model.vo.*"%>    
<%
	Project project = (Project)request.getAttribute("project");
	int pno = (int)request.getAttribute("pno");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 수정</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/writeProject.css">
<style>
	body{
		background: white;
	}
	main[role="main"] {
    margin: 20px 0 40px 200px;
  	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<main role="main">
	
		<section class="panel important">
			<h2>펀딩 계획</h2>
			<form id="insertForm" action="updateReward.pr" method="post">
				<div class="twothirds">
					<input type="hidden" name="pno" value="<%= pno %>">
					목표 금액:<br>
					<input type="text" id="target" name="target" size="40" placeholder="프로젝트를 완수하기 위해 필요한 금액을 설정해주세요." value="<%= (int) project.getPrjTarget() %>" onchange="printName()"/>
					<div class="subdiv">
						<br>
						목표 금액 달성 시 예상 수령액<br>
						<div id="result1"></div><br>
						<div class="psubdiv">
							결제대행 수수료 (총 결제액의 3% + VAT)<br>
							<div id="result2"></div><br>
							플랫폼 수수료(총 모금액의 5% + VAT)<br>
							<div id="result3"></div><br>
						</div>
					</div>
					<br>
					펀딩 시작일:<br>
					<input type="date" name="startDate" id="startDate" value=<%= project.getPrjStartDate() %>><br>
					펀딩 종료일:<br>
					<input type="date" name="endDate" id="endDate" value=<%= project.getPrjEndDate() %>><br>
					<div class="btnsPro" align="center">
						<button type="submit" class="btnPro" name="next" onclick="return check()">다음으로</button>
						<button type="button" class="btnPro" name="previous" onclick="location.href='updateCreator.pr'">이전으로</button>
					</div>
				</div>				
			</form>
		</section>	
	</main>

	<script>
		function printName()  {
			  const target = document.getElementById("target").value;
			  var agencyFee = target * 3 / 100;
			  agencyFee += agencyFee * 10 / 100;
			  var platformFee = target * 5 / 100;
			  platformFee += platformFee * 10 / 100;
			  
			  document.getElementById("result1").innerHTML = "<h2>" + (target - agencyFee - platformFee) + "원</h2>";
			  document.getElementById("result2").innerHTML = "<h3>" + agencyFee + "원</h3>";
			  document.getElementById("result3").innerHTML = "<h3>" + platformFee + "원</h3>";
}
		
		function leadingZeros(n, digits) {
		    var zero = '';
		    n = n.toString();

		    if (n.length < digits) {
		        for (i = 0; i < digits - n.length; i++)
		            zero += '0';
		    }
		    return zero + n;
		}
		
		function isUseDayStart(){
			var startDate = document.getElementById("startDate").value;
			var now = new Date();

			if(startDate){
			  now = leadingZeros(now.getFullYear(), 4) + '-' +
			    	leadingZeros(now.getMonth() + 1, 2) + '-' +
			    	leadingZeros(now.getDate(), 2);
			  
			  console.log("startDate : " + startDate);
			  console.log("now : " + now);
			  
			  if(startDate < now){
				return false;
			  }
			}
		}
		
		function isUseDayEnd(){
			var endDate = document.getElementById("endDate").value;
			var now = new Date();

			if(endDate){
			  now = leadingZeros(now.getFullYear(), 4) + '-' +
			    	leadingZeros(now.getMonth() + 1, 2) + '-' +
			    	leadingZeros(now.getDate(), 2);
			  
			  console.log("endDate : " + endDate);
			  console.log("now : " + now);
			  
			  if(endDate < now){
				return false;
			  }
			}
		}
		
		function check(){
	        const target = document.getElementById("target");
	        const startDate = document.getElementById("startDate");
	        const endDate = document.getElementById("endDate");

	        if(target.value == "" || target.value.length == 0){
                alert("목표 금액은 필수 항목입니다.");
                target.focus();
                return false;
            } else if(startDate.value == "" || startDate.value.length == 0){
                alert("펀딩 시작일은 필수 항목입니다.");
                startDate.focus();
                return false;
            } else if(endDate.value == "" || endDate.value.length == 0){
                alert("펀딩 종료일은 필수 항목입니다.");
                endDate.focus();
                return false;
            } else if(isUseDayStart() == false){
            	alert("펀딩 시작일이 현재 날짜보다 빠를 수 없습니다.");
            	startDate.focus();
                return false;
            } else if(isUseDayEnd() == false){
            	alert("펀딩 종료일이 현재 날짜보다 빠를 수 없습니다.");
            	endDate.focus();
                return false;
            } else{
            	return true;
            }
	    }
	</script>
	
	<%@ include file="../common/footer.jsp" %>

</body>
</html>