<%@page import="java.lang.reflect.Executable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>공지사항</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<br>
	<br>
	<br>
	
	<div class="container">
		<h1>고객지원</h1>
		<br>
		<div class="row">
			<div class="col-3"><a class="text-body" href=""><h3>공지사항</h3></a></div>
			<div class="col-3"><a class="text-secondary" href="" ><h3>신고게시판</h3></a></div>
			
		</div>
		<a></a>
		<hr>
		<table class="table table-bordered table-sm">
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<% for(int i=0; i<10; i++){  %>
				<tr class="dataRow">
					<td><%= i+1 %></td>
					<td>제목</td>
					<td>2021.08.13</td>
					<td>1</td>
				</tr>
				<%} %>
			</tbody>
		</table>
		
		<p align="center">< 1 2 3 4 5 6 ></p>
		<form align="center" action="search.bo">
			<input type="text"/>
			<input type="submit" value="검색">
		</form>
	</div>
</body>
</html>