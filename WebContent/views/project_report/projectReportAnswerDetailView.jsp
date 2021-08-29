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

<title>공지사항</title>
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

	<!-- 게시글 -->
	<main class="main">


		<div class="board_view_wrap">
			<div class="board_view">
				<div class="btitle">${p.prjReportTitle}</div>
				<div class="binfo">
					<dl>
						<dt>번호</dt>
						<dd>${p.prjReportNo}</dd>
					</dl>
					<dl>
						<dt>글쓴이</dt>
						<dd>${p.writerName}</dd>
					</dl>
					<dl>
						<dt>작성일</dt>
						<dd>${p.createDate}</dd>
					</dl>
					<dl>
						<dt>조회수</dt>
						<dd>
							<fmt:formatNumber type="number" pattern="##,####"
								value="${p.count}" />
						</dd>
					</dl>
				</div>
				<div class="binfo">
					<dl>
						<dt>첨부파일</dt>
						<c:forTokens var="fileName" items="${p.files}" delims=","
							varStatus="st">
							<c:if test="${fn:endsWith(fileName, '.zip') }">
								<c:set var="style" value="font-weight: blod;;"></c:set>
							</c:if>
							<dd>
							<a download href="/FundingPro/upload/${fileName}" style="${style}">${fn:toUpperCase(fileName)}</a>
							</dd>
							<c:if test="${not st.last}">/</c:if>
						</c:forTokens>
					</dl>
				</div>
				<div class="cont">${p.prjReportContent}</div>
			</div>
		</div>
		<c:if test="${memNo==100}">
		<c:set var="contextPath" value="<%=request.getContextPath() %>"></c:set>
		<div class="bt_wrap">
			<a class="on"
				href="${contextPath}/answerDelete.pr?prjReportNo=${p.prjReportNo}">삭제</a>
		</div>
		</c:if>

		



		
	</main>

</body>
</html>