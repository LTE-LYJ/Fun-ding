
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/head.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/common.css" />
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
	<main class="main">

		<!-- 게시판 리스트 -->
		<div class="board_list_wrap">

			<table class="board_list">
				<thead>
					<tr class="table_head">
						<th class="num">번호</th>
						<th class="cate">카테고리</th>
						<th class="title">제목</th>
						<th class="writer">작성자</th>
						<th class="date">작성일</th>
						<th class="count">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${list}" begin="0" end="10">
						<tr>
							<td class="num">${b.boardNo}</td>
							<td class="cate">${b.category}</td>
							<td class="title"><a
								href="boardDetailView?boardNo=${b.boardNo}">${b.boardTitle}</a>
								<span class="rep">[${b.repCount}]</span>
								</td>
							<td class="writer">${b.boardWriter}</td>
							<td class="date"><fmt:formatDate pattern="yyyy-MM-dd"
									value="${b.createDate}" /></td>
							<td class="count">${b.count}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<!-- 페이지 -->
			<c:set var="page" value="${(empty param.p)?1:param.p}" />
			<c:set var="startNum" value="${page-(page-1)%5}" />
			<c:set var="lastNum"
				value="${fn:substringBefore(Math.ceil(count/10),'.') }" />



			<div class="paging">

				<c:if test="${startNum>1}">
					<a href="?p=${startNum-1}&t=&q=">&lt;</a>
				</c:if>
				<c:if test="${startNum<=1}">
					<a onclick="alert('이전 페이지가 없습니다.');">&lt;</a>
				</c:if>

				<c:forEach var="i" begin="0" end="4">
					<c:if test="${(startNum+i) <= lastNum }">
						<a class="num ${(page==(startNum+i))?'orange':'' } "
							href="?p=${startNum+i}&f=${param.f}&q=${param.q}">${startNum+i}</a>
					</c:if>
				</c:forEach>


				<c:if test="${startNum+4<lastNum}">
					<a href="?p=${startNum+5}&t=&q=">&gt;</a>
				</c:if>
				<c:if test="${startNum+4>=lastNum}">
					<a onclick="alert('다음 페이지가 없습니다.');">&gt;</a>
				</c:if>


			</div>
			<c:if test="${memNo != 0}">
				<div class="bt_wrap right">
					<a class="on" href="boardEnrollForm">작성하기</a>
				</div>
			</c:if>
		</div>


		<!-- 검색 -->
		<div class="search">
			<form>
				<select name="c"> 
					<option value="">전체</option>
					<c:forEach var="c" items="${cat}" begin="0" end="3" >
						<option value="${c.boardCatNo}">${c.boardCatName}</option>
					</c:forEach>
				</select> <select name="f">
					<option ${(param.f == "board_title")?"selected":""}
						value="board_title">제목</option>
					<option ${(param.f == "mem_name")?"selected":""} value="mem_name">작성자</option>
				</select> <input type="text" name="q" value="${param.q}" /> <input
					class="btn-search" type="submit" value="검색" />
			</form>
		</div>


		<div class="page">
			<span>${(empty param.p)?1:param.p}</span> / ${lastNum} pages
		</div>
		<hr>
	</main>

</body>
</html>