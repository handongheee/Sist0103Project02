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
<title>updateForm</title>
</head>
<body>
<div style="margin: 50px 100px; width: 500px;">
	<form action="update" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${dto.num }">
		<table class="table table-bordered">
			<tr>
				<th class="table-light">상품명</th>
				<td>
					<input type="text" name="sangpum" class="form-control" style="width: 180px;" required="required" value="${dto.sangpum }">
				</td>
			</tr>
			
			<tr>
				<th class="table-light">가격</th>
				<td>
					<input type="text" name="price" class="form-control" style="width: 150px;" required="required" value="${dto.price }">
				</td>
			</tr>
			
			<tr>
				<th class="table-light">상품이미지</th>
				<td>
					<input type="file" name="upload" class="form-control" style="width: 230px;" multiple="multiple">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-warning">수정</button>
					<button type="button" class="btn btn-info" onclick="location.href='list'">목록</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>