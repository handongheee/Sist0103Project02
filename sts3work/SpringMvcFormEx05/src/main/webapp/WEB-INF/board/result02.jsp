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

<link rel="stylesheet" href="../css/style.css">
<title>result02</title>
</head>
<body>
	<h2 class="alert alert-warning">${title }</h2>
	<img alt="" src="${myimg01 }">
	
	<hr>
	
	<table style="width:200px;">
		<tr>
			<th>이름</th>
			<th>연락처</th>
		</tr>
		
		<tr>
			<td>홍길순</td><td>010-1212-2323</td>
		</tr>
		
		<tr>
			<td>이도현</td><td>010-2222-5555</td>
		</tr>
	</table>
</body>
</html>