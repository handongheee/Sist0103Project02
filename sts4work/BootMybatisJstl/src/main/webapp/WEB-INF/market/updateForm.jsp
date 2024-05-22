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
	<div style="margin: 100px 100px;">
		<h2>Market 정보 수정</h2>
		<form action="update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value=${dto.num }>
			<table class="table table-bordered" style="width: 500px;">
				<tr>
					<th width="100" class="table-primary">상품명</th>
					<td>
						<input type="text" name="sang" class="form-control" style="width: 150px;" required="required" value="${dto.sang }"> 
					</td>	
				</tr>
				
				<tr>
					<th width="100" class="table-primary">단가</th>
					<td>
						<input type="text" name="dan" class="form-control" style="width: 200px;" required="required" value="${dto.dan }"> 
					</td>	
				</tr>
				
				<tr>
					<th width="100" class="table-primary">상품사진</th>
					<td>
						<input type="file" name="photo" class="form-control" style="width: 230px;"> 
					</td>	
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-warning">수정</button>
						<button type="button" class="btn btn-outline-info" onclick="location.href='list'">목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>