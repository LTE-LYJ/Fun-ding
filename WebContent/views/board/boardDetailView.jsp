<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/head.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/detail.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/common.css" />

<title>커뮤니티</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<br>
	<div class="head">
		<h2 class="list">
			<a class="in" href="boardListView">커뮤니티</a>
		</h2>
	</div>
	<hr>

	<!-- 게시글 -->
	<main class="main">


		<div class="board_view_wrap">
			<div class="board_view">
				<div class="btitle">${b.boardTitle}</div>
				<div class="binfo">
					<dl>
						<dt>번호</dt>
						<dd>${b.boardNo}</dd>
					</dl>
					<dl>
						<dt>글쓴이</dt>
						<dd>${b.boardWriter}</dd>
					</dl>
					<dl>
						<dt>작성일</dt>
						<dd>${b.createDate}</dd>
					</dl>
					<dl>
						<dt>조회수</dt>
						<dd>
							<fmt:formatNumber type="number" pattern="##,####"
								value="${b.count}" />
						</dd>
					</dl>
				</div>
				<div class="binfo">
					<dl>
						<dt>첨부파일</dt>
						<c:forTokens var="fileName" items="${b.files}" delims=","
							varStatus="st">
							<c:if test="${fn:endsWith(fileName, '.zip') }">
								<c:set var="style" value="font-weight: blod;;"></c:set>
							</c:if>
							<dd>
								<a download href="/FundingPro/upload/${fileName}"
									style="${style}">${fn:toUpperCase(fileName)}</a>
							</dd>
							<c:if test="${not st.last}">/</c:if>
						</c:forTokens>
					</dl>
				</div>
				<div class="cont">${b.boardContent}</div>
			</div>
		</div>
		<c:if test="${writerNo == memNo || memNo==100}">
			<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
			<div class="bt_wrap">
				<a href="boardUpdateForm?boardNo=${b.boardNo}">수정</a> <a class="on"
					href="${contextPath}/bDelete.bo?boardNo=${b.boardNo}">삭제</a>
			</div>
		</c:if>

		<div class="reply_view">
			<c:forEach var="r" items="${reply}">
				<div class="reply_view">
					<dl>
						<dt class="reply">${r.memName}</dt>
						<dd class="reply_cont">${r.boardReplyContent}</dd>
					</dl>
					<dl class="reply_info">
						<dd>${r.createDate}${r.memName}</dd>
						<c:if test="${writerNo == memNo || memNo==100}">
							<dd>
								<a
									href="${contextPath}/replyDelete.bo?boardReplyNo=${r.boardReplyNo}&boardNo=${b.boardNo}">삭제</a>
							</dd>
						</c:if>
					</dl>
				</div>

			</c:forEach>

			<c:if test="${memNo != 0}">
				<form action="boardDetailView" method="post">
					<dl>
						<dt>${memName}</dt>
						<dd>
							<textarea class="content" id="content" name="content"
								placeholder="댓글을 남겨보세요" required></textarea>
						</dd>
						<dd class="ref_btn">
							<input class="on" type="submit" value="등록" onclick="check()">
						</dd>
					</dl>
					<input type="hidden" name="boardNo" value="${b.boardNo}">

					<script>
						function check() {
							if ($("#content").val() == "")
								alert("내용을 입력하세요")

						}
					</script>
				</form>
			</c:if>
		</div>




		<div class="margin-top">
			<table class="table border-top-default">
				<tbody>

					<tr>
						<th>다음글</th>
						<td><a id="next"
							href="boardDetailView?boardNo=${next.boardNo}">${next.boardTitle}</a>
							<c:if test="${next.boardNo == null}">다음글이 없습니다.</c:if></td>
					</tr>

					<tr>
						<th>이전글</th>
						<td><a id="prev"
							href="boardDetailView?boardNo=${prev.boardNo}">${prev.boardTitle}</a>
							<c:if test="${prev.boardNo == null}">이전글이 없습니다.</c:if></td>
					</tr>

				</tbody>
			</table>
		</div>
	</main>

</body>
</html>