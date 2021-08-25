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
			<h2>리워드 구성</h2>
			<form id="insertForm" action="writeInfo.pr" method="post">
				<div class="twothirds">
					리워드 이름:<br>
					<input type="text" id="rname" name="rname" size="40" placeholder="이름을 입력해주세요."/><br>
					리워드 설명:<br>
					<input type="text" id="rcontent" name="rcontent" size="40" placeholder="ex) 배송비 포함, 리미티드 에디션"/><br>
					금액 설정:<br>
					<input type="text" id="rprice" name="rprice" size="40" placeholder="해당 리워드에 대한 후원 금액을 입력해주세요."/><br>
					<div class="rbtnsPro" align="right">
						<button type="button" class="rbtn" name="add" onclick="addList()">추가하기</button>
						<button type="reset" class="rbtn" name="add">초기화</button>
					</div>
					<div class="subdiv">
						<br>
						<ul id="rul" class="rul"></ul>
					</div>
					<textarea name="allReward" style="display:none" id="hiddenArea"></textarea>
					<br>
					<div class="btnsPro" align="center">
						<button type="submit" class="btnPro" name="next">다음으로</button>
						<button type="button" class="btnPro" name="previous" onclick="location.href='writeReward.pr'">이전으로</button>
					</div>
				</div>				
			</form>
		</section>	
	</main>
	
	<script>
		var index = 0;
		
		function addList() {
		  const rname = document.getElementById("rname").value;
		  const rcontent = document.getElementById("rcontent").value;
		  const rprice = document.getElementById("rprice").value;
		  
		  document.getElementById("rul").innerHTML += "<li id='rli" + index + "'><button type='button' class='minusbtn' id='minusbtn" + index + "' name='minus' onclick=deleteList(" + index + ");>-</button>" + rname + "/" + rcontent + "/" + rprice + "</li>";
		  console.log(index + " : " + rname + "/" + rcontent + "/" + rprice);
		  
		  index++;
		}
		
		function deleteList(index) {
			// 1. <ul> element 선택
			const ul = document.getElementById("rul");
			  
			// 2. <li> 목록 선택
			const items = ul.getElementsByTagName("li");
			  
			// 3. <li> 목록 중 index에 해당하는 item 삭제
			if(items.length > 0)  {
			  items[index].remove();
			}
			
		};
		
		$("#insertForm").on("submit", function(){
			const ul = document.getElementById("rul");
			const items = ul.getElementsByTagName("li");
			
			for (var i=0; i<items.length; i++){
				console.log(items[i].textContent);
				document.getElementById("hiddenArea").value += items[i].textContent;
			}
			
			$("#hiddenArea").val();
		});
	</script>
	
	<%@ include file="../common/footer.jsp" %>

</body>
</html>