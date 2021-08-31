<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/head.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/common.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/write.css" />
<title>공지사항</title>
</head>
<body>
	<body>
	<%@ include file="../common/menubar.jsp"%>
	<br>
	<div class="head">
		<h2 class="list">
			<a class="in" href="noticeListView">공지사항</a> <a class="out"
				href="../project_report/projectReportListView">신고게시판</a>
		</h2>
	</div>
	<hr>


	<!-- 개시글 작성 -->
	<main class="main">
	<c:set var="contextPath" value="<%=request.getContextPath() %>"></c:set>
		<form method="post" action="${contextPath}/update.no?noticeNo=${n.noticeNo}" enctype="multipart/form-data" >
			<div class="board_write_wrap">
				<div class="board_write">
					<div class="btitle">
						<dl>
							<dt>제목</dt>
							<dd>
								<input id="title" type="text" name="title" value="${n.noticeTitle}" placeholder="제목을 입력하세요" required/>
							</dd>
						</dl>
					</div>
					<div class="btitle" id="filearea">
						<dl>
							<dt>첨부파일</dt>
							<dd>
								<input type="file" name="file" value="${n.files}" />
							</dd>
							<dt></dt>
							<dd>
								<input type="file" name="file" />
							</dd>
						</dl>
					</div>
					
					<div class="binfo">
						<dl>
							<dt></dt>
							<dd></dd>
						</dl>
					</div>
					<div class="cont">
						<textarea id="editor" name="content"  placeholder="내용을 입력하세요" >${n.noticeContent}</textarea>
					</div>
					<script>
						ClassicEditor
						.create( document.querySelector( '#editor' ),{
							removePlugins: [ 'ImageUpload' ]
						} )
						.catch( error => {
						console.error( error );
						});
					</script>
				</div>
				<div class="bt_wrap">
					<input class="on" type="submit" value="수정" onclick="check()" /> <a
						href="noticeListView">취소</a>
				</div>
				<script>
				 	function check() {
						if($("#title").val() == "")
							alert("제목을 입력하세요")
						
					}
				</script>
			</div>
		</form>
	</main>
</body>
</html>