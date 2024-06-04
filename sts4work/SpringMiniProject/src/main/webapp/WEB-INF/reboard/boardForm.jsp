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
<title>boardForm(re)</title>
</head>
<body>
<div style="margin: 50px 100px; width: 500px;">
	<form action="insert" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${sessionScope.myid }">
		<input type="hidden" name="name" value="${sessionScope.loginname }">
		<input type="hidden" name="num" value="${num }">
		<input type="hidden" name="regroup" value="${regroup }">
		<input type="hidden" name="restep" value="${restep }">
		<input type="hidden" name="relevel" value="${relevel }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		
		<table class="table table-bordered">
			<tr>
				<th class="table-light" width="100">제목</th>
				<td>
					<input type="text" name="subject" class="form-control" required="required" value="${subject }">
				</td>
			</tr>
			
			<tr>
				<th class="table-light" width="100">사진</th>
				<td>
					<input type="file" name="upload" class="form-control" multiple="multiple">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<textarea style="width: 500px; height: 150px;" name="content" class="form-control" required="required"></textarea>		
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-secondary">게시글 저장</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>