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
<title>deletePassForm</title>
</head>
<body>
	<div style="margin: 100px 100px;">
		<form action="delete" method="post">
			<!-- hidden - num, currentPage -->
			<input type="hidden" name="num"	value="${num }">
			<input type="hidden" name="currentPage" value="${currentPage }">
			
			<div class="alert alert-info" style="font-size: 1.3em; width: 350px;">	
				<b>비밀번호를 입력해주세요.</b>				
			</div>		
			
			<div class="d-inline-flex">
				<input type="password" name="pass" class="form-control" style="width: 130px;" required="required">
				<br>
				<button type="submit" class="btn btn-danger" style="margin-left: 10px;">삭제하기</button>
				<button type="button" class="btn btn-info" onclick="history.back()" style="margin-left: 6px;">이전으로</button>
			</div>
		</form>
	</div>
</body>
</html>