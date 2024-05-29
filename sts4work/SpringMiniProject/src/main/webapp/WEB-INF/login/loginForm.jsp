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
<title>loginForm</title>
</head>
<body>
	<div style="margin: 100px 200px;">
		<form action="loginprocess" method="post">
			<table class="table table-bordered" style="width:250px;">
				<caption align="top"><b>회원 로그인</b></caption>
				<tr>
					<td align="left">
						<input type="text" name="id" class="form-control" required="required" placeholder="아이디 입력" style="width:200px;" value="${sessionScope.saveok==null?"":sessionScope.myid }">
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="password" name="pass" class="form-control" required="required" placeholder="비밀번호 입력" style="width:200px;">
					</td>
				</tr>
				
				<tr>
					<td>
						<!-- 아이디 저장이 null이면 비체크 -->
						<input type="checkbox" name="cbsave" ${sessionScope.saveok==null?"":"checked" }>아이디저장
					</td>
				</tr>
				
				<tr>
					<td>
						<button type="submit" class="btn btn-success btn-lg" style="width:200px;">로그인</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>