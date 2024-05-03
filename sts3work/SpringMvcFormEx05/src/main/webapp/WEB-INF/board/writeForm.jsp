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
<title>writeForm</title>
</head>
<body>
	<div style="margin:50px 100px;">
		<form action="process" method="post">
			작성자: <input type="text" name="name"> <br>
			날짜: <input type="date" name="date"> <br>
			성별: <input type="radio" name="gender" value="여자" checked="checked">여자
			<input type="radio" name="gender" value="남자">남자 <br>
			<input type="submit" value="서버에 전송">
			
		</form>
			
	</div>
	
</body>
</html>