<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.project.model.vo.*, com.kh.attachment.model.vo.ProjectAttachment"%>    
<%
	Project project = (Project)request.getAttribute("project");
	ProjectAttachment prjat = (ProjectAttachment)request.getAttribute("at");
	int pno = (int)request.getAttribute("pno");
	
	String category = project.getPrjCatName();
	
	String[] selected = new String[8];
	
	switch(category){
		case "게임": selected[0] = "selected"; break;
		case "디자인": selected[1] = "selected"; break;
		case "공예": selected[2] = "selected"; break;
		case "영화": selected[3] = "selected"; break;
		case "음악": selected[4] = "selected"; break;
		case "출판": selected[5] = "selected"; break;
		case "패션": selected[6] = "selected"; break;
		case "기타": selected[6] = "selected"; break;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/writeProject.css">
<link rel="stylesheet" href="https://cdn.quilljs.com/1.3.6/quill.snow.css">
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<main role="main">
	
		<section class="panel important">
			<h2>프로젝트 정보</h2>
			<form id="insertForm" action="update.pr" method="post" enctype="multipart/form-data">
				<div class="twothirds">
					<input type="hidden" name="pno" value="<%= pno %>">
					프로젝트 카테고리:<br>
					<select name="category" size="1" width="50%">
						<option value="10" <%= selected[0] %>>게임</option>
						<option value="20" <%= selected[1] %>>디자인</option>
						<option value="30" <%= selected[2] %>>공예</option>
						<option value="40" <%= selected[3] %>>영화</option>
						<option value="50" <%= selected[4] %>>음악</option>
						<option value="60" <%= selected[5] %>>출판</option>
						<option value="70" <%= selected[6] %>>패션</option>
						<option value="80" <%= selected[7] %>>기타</option>
					</select><br>
					프로젝트 제목:<br>
					<input type="text" name="title" size="40" placeholder="프로젝트 제목을 입력해주세요." value="<%= project.getPrjTitle() %>"/><br>
					프로젝트 소개:<br>
					<div id="editor-container"></div>
					<textarea name="content" style="display:none" id="hiddenArea"></textarea>
					<br>
					대표 이미지:<br>
					<% if(prjat != null){ %> <!-- 기존의 첨부파일이 있었을 경우 -->
						<%= prjat.getOriginName() %> <br>
						<input type='hidden' name='originFile' value='<%=prjat.getChangeName()%>'>
						<input type='hidden' name='originFileNo' value='<%=prjat.getFileNo()%>'>
					<% }%>
					<input type="file" name="upFile">
					<div class="btnsPro" align="center">
						<button type="submit" class="btnPro" name="submit">등록하기</button>
						<button type="button" class="btnPro" name="previous" onclick="location.href='updateReward.pr'">이전으로</button>
					</div>
				</div>				
			</form>
		</section>	
	</main>
	
	<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>

	<script>
		// Initialize QUill editor
		var quill = new Quill('#editor-container', {
		  modules: {
		    toolbar: [
		      [{ header: [1, 2, 3, 4, 5, 6,  false] }],
		      ['bold', 'italic', 'underline','strike'],
		      ['image', 'code-block'],
		      ['link'],
		      [{ 'script': 'sub'}, { 'script': 'super' }],
		      [{ 'list': 'ordered'}, { 'list': 'bullet' }],
		      ['clean']
		    ]
		  },
		  placeholder: '프로젝트 내용을 입력해주세요.',
		  theme: 'snow',  // or 'bubble',
		  value: '<%= project.getPrjContent() %>'
		});
		
		$("#insertForm").on("submit", function(){
			$("#hiddenArea").val($("#editor-container .ql-editor").html());
		});
	</script>

	<%@ include file="../common/footer.jsp" %>

</body>
</html>