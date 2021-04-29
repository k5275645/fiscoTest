<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="../resources/css/bootstrap.css?after">
	<title>fisco.GG에 오신걸 환영합니다.</title>
</head>
<body>
	<nav class="navbar sticky-top navbar-dark bg-dark">
		<a class="navbar-brand" href="/goYou">fisco.gg</a>
			<form action="search/do" method="get">
				<div class="nav-embed-submit-field">
					<input type="text" placeholder="당신의 아이디를 검색하세요!" name="title">
					<button type="submit">검색!</button>			
				</div>
			</form>
	</nav>
	<div class="container p-5 shadow-lg p-3 mb-5 bg-white rounded" >
		<div class="row h-100 justify-content-center align-items-center">
			<form action="search/do" method="get">
				<div class="embed-submit-field">
					<input type="text" placeholder="id..." name="title">
					<button type="submit">검색!</button>	
				</div>
			</form>
		</div>
	</div>
</body>
</html>