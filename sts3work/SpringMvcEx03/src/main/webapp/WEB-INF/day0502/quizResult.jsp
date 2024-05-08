<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link
href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Gowun+Dodum&family=IBM+Plex+Sans+KR&family=Noto+Sans+KR:wght@100..900&display=swap"
rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>quizResult</title>
</head>
<body>
	<h2>${quiz_title }_res 2개, WEB-INF의 image에 있는거 2개 출력할 것</h2>
	
	<h2>리소스 폴더</h2>
	<img alt="" src="../../res/01.png">
	<img alt="" src="../../res/image01/image_01.png">
	
	<h2>WEB-INF 폴더</h2>
	<img alt="" src="../../image/image_03.png">
	<img alt="" src="../../image/shopImage/bag02.png">
	
</body>
</html>