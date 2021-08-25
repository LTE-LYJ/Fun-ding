<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/writeProject.css">
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<main role="main">
	
		<section class="panel important">
			<h2>펀딩 계획</h2>
			<form id="insertForm" action="writeReward.pr" method="post">
				<div class="twothirds">
					목표 금액:<br>
					<input type="text" id="target" name="target" size="40" placeholder="프로젝트를 완수하기 위해 필요한 금액을 설정해주세요." onchange="printName()"/>
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
					<input type="date" name="startDate" id="startDate"><br>
					펀딩 종료일:<br>
					<input type="date" name="endDate" id="endDate"><br>
					<div class="btnsPro" align="center">
						<button type="submit" class="btnPro" name="next">다음으로</button>
						<button type="button" class="btnPro" name="previous" onclick="location.href='writeCreator.pr'">이전으로</button>
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
			  
			  document.getElementById("result1").innerHTML = "<h2>" + target + "원</h2>";
			  document.getElementById("result2").innerHTML = "<h3>" + agencyFee + "원</h3>";
			  document.getElementById("result3").innerHTML = "<h3>" + platformFee + "원</h3>";
		}
	</script>
	
	<%@ include file="../common/footer.jsp" %>

</body>
</html>