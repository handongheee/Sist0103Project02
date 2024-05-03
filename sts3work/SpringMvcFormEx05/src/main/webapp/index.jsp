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
<title>index</title>
</head>
<body>
	<a href="board/form">폼 데이터 읽기_기본 result.jsp</a> <br>
	<a href="board/result02">이미지, css 페이지_result02.jsp</a> <br>
	<a href="board/list">이미지, js 테스트_list.jsp</a> <br><br>
	
	<!-- shopcontroller -->
	<a href="shop/dtoForm">폼데이터 읽기_dto_shop/formDto.jsp 포워드</a> <br>
	<a href="shop/mapForm">폼데이터 읽기_map_shop/formMap.jsp 포워드</a>
	
	<%-- c:redirect 바로 전송 
	<c:redirect url="board/form"/> --%>
</body>
</html>