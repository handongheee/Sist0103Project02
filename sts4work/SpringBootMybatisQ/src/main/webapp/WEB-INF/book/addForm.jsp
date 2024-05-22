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
<title>addForm</title>
</head>
<body>
<div style="margin: 100px 100px;">
		<h2>도서 정보 입력</h2>
		<form action="insert" method="post" enctype="multipart/form-data">
			<table class="table table-bordered" style="width: 500px;">
				<tr>
					<th width="100" class="table-primary">도서명</th>
					<td>
						<input type="text" name="bookname" class="form-control" style="width: 180px;" required="required"> 
					</td>	
				</tr>
				
				<tr>
					<th width="100" class="table-primary">작가명</th>
					<td>
						<input type="text" name="writer" class="form-control" style="width: 170px;" required="required"> 
					</td>	
				</tr>
				
				<tr>
					<th width="100" class="table-primary">가격</th>
					<td>
						<input type="text" name="bookprice" class="form-control" style="width: 200px;" required="required"> 
					</td>	
				</tr>
				
				<tr>
					<th width="100" class="table-primary">도서사진</th>
					<td>
						<input type="file" name="photo" class="form-control" style="width: 230px;"> 
					</td>	
				</tr>
				
				<tr>
					<th width="100" class="table-primary">출판사정보</th>
					<td>
						<input type="text" name="bookcompany" class="form-control" style="width: 200px;" required="required"> 
					</td>	
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-success">저장</button>
						<button type="button" class="btn btn-outline-info" onclick="location.href='list'">목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>