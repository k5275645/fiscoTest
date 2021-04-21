<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>fisco.GG에 오신걸 환영합니다.</title>
</head>
<body>
	<form action="/search" method="get">
		<div>
			<input type="text" placeholder="당신의 아이디를 검색하세요!" name="title">
			<button type="submit">검색 !</button>
		</div>
	</form>
</body>
</html>