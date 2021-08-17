<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.project.model.vo.*"%>
<% 
	ArrayList<Project> list = (ArrayList<Project>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="container">
        <h1>모든 프로젝트 둘러보기</h1>
		<br>

		<div class="row">
			<%for(Project p : list){ %>
			<div class="col-3">
				<div class="card">
					<img src="<%=contextPath %>/resources/board_upfiles/<%= p.getAttachmentNo() %>" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title"><%=p.getPrjTitle() %></h5>
						<p class="card-text">153,013,000원</p>
						<p class="card-text"><small class="text-muted">nn일 남음</small></p>
					</div>
				</div>
			</div>
			<%} %>
		</div>
		<script>
		
			$(function(){
				$(".card").click(function(){
					var pId = $(this).children().eq(0).val();
					location.href="<%=contextPath%>/detail.pj?pId=" + pId;
				});
			});
		</script>
	</div>
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous">
    </script>
</body>
</html>