<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Fisco git&API practice  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<!-- <a href="goSungHwan">gogo</a> -->

<button onclick="goYou()">유 API</button>
<button onclick="goSon()">손 API</button>
<button onclick="goKim()">김 API new clone test</button>

<script>
function goSungHwan(){
	location.href = "goYou";
}

function goSon(){
	  location.href = "goSon";
	}
	
function goKim(){
	  location.href = "goKim";
	}
</script>
</body>
</html>
