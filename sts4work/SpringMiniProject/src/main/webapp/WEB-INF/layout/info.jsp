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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>info</title>
</head>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<body>
	<i class="bi bi-envelope"></i> &nbsp; 코카콜라코리아 <br>
	<i class="bi bi-telephone"></i> &nbsp; 080-024-5999 <br>
	<i class="bi bi-building"></i> &nbsp; 서울시 종로구 새문안로 68 흥국생명빌딩 18층 한국 코카-콜라 <br>
	<i class="bi bi-youtube"></i> &nbsp; 
	<i class="bi bi-instagram"></i>
	
	<!-- 로그아웃 상태는 기본이미지, 로그인 상태는 로그인한 이미지 나오게 -->
	<c:if test="${sessionScope.loginok==null }">
		<img alt="" src="${root }/image/roundLogo.png" width="130" height="130" style="border-radius: 100px;">
	</c:if>
	<!-- 로그인 상태 -->
	<c:if test="${sessionScope.loginok!=null }">
		<img alt="" src="${root }/memberphoto/${sessionScope.loginphoto}" width="130" height="130" style="border-radius: 100px;">
	</c:if>
</body>
</html>