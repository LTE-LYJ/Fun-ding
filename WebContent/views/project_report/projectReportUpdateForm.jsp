<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/head.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/common.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/write.css" />
</head>

<body>
	<%@ include file="../common/menubar.jsp"%>
	<br>
	<div class="head">
		<h2 class="list">
			<a class="out" href="../notice/noticeListView">공지사항</a> <a class="in"
				href="../project_report/projectReportListView">신고게시판</a>
		</h2>
	</div>
	<hr>
	<!-- 개시글 작성 -->
	<main class="main">
	<c:set var="contextPath" value="<%=request.getContextPath() %>"></c:set>
		<form method="post" action="${contextPath}/pinsert.pr?prjReportNo=${pr.prjReportNo}" enctype="multipart/form-data">
			<div class="board_write_wrap">
				<div class="board_write">
					<div class="btitle">
						<dl>
							<dt>제목</dt>
							<dd>
								<input id="title" type="text" name="title" placeholder="제목을 입력하세요" value="${pr.prjReportTitle }" required/>
							</dd>
						</dl>
					</div>
					<div class="btitle" id="filearea">
						<dl>
							<dt>첨부파일</dt>
							<dd>
								<input type="file" name="file"/>
							</dd>
							<dt></dt>
							<dd>
								<input type="file" name="file" />
							</dd>
						</dl>
					</div>
					<div class="btitle" >
						<dl>
							<dt>프로젝트번호</dt>
							<dd>
								<input type="number" name="prjNo" value="${pr.prjNo}"/>
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
						<textarea id="editor" name="content" placeholder="내용을 입력하세요" >${pr.prjReportContent}</textarea>
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
					<input class="on" type="submit" value="등록" onclick="check()" /> <a
						href=projectReportListView>취소</a>
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