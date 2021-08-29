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
<title>Insert title here</title>
</head>
<body>
	<body>
	<%@ include file="../common/menubar.jsp"%>
	<br>
	<div class="head">
		<h2 class="list">
			<a class="in" href="boardListView">커뮤니티</a> 
		</h2>
	</div>
	<hr>


	<!-- 개시글 작성 -->
	<main class="main">
	<c:set var="contextPath" value="<%=request.getContextPath() %>"></c:set>
		<form method="post" action="${contextPath}/bUpdate.bo?boardNo=${b.boardNo}" enctype="multipart/form-data" >
				<div class="board_write">
					<div class="btitle">
						<dl>
							<dt>제목</dt>
							<dd>
								<input id="title" type="text" name="title" value="${b.boardTitle}" placeholder="제목을 입력하세요" required/>
							</dd>
						</dl>
					</div>
					<div class="btitle">
						<dl>
							<dt>카테고리</dt>
							<dd>
								<select name="cate" class="cate">
									<c:forEach var="b" items="${cat}" begin="0" end="3">
										<option value="${index*10+10}">${b.boardCatName}</option>
									</c:forEach>
								</select>
							</dd>
						</dl>
					<div class="btitle" id="filearea">
						<dl>
							<dt>첨부파일</dt>
							<dd>
								<input type="file" name="file" value="${b.files}" />
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
						<textarea id="editor" name="content"  placeholder="내용을 입력하세요" >${b.boardContent}</textarea>
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
						href="boardListView">취소</a>
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