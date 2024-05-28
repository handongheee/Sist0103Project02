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
<title>title</title>
<style type="text/css">
	div.login{
		position: absolute;
		left: 800px;
		top: 30px;
		width: 350px;
	}
</style>
</head>
<body>
	<c:set var="root" value="<%=request.getContextPath() %>"/>
	<a href="/">
		<img alt="" src="${root }/image/logo.png" style="width: 400px;">
		<b>SpringBoot + Mybatis + Tiles3</b>
	</a>
	
	<div class="login">
		<button type="button" class="btn btn-success" style="width:100px" 
		onclick="location.href='${root}/login/loginform'">login</button>
		
	</div>
</body>
</html>