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
<title>addForm</title>
</head>
<body>
	<form action="write" method="post">
		<table class="table table-bordered" style="width:400px;">
			<tr>
				<th>자동차명</th>
				<td>
					<input type="text" name="carname" style="width: 120px;" class="form-control" required="required">
				</td>
			</tr>
			
			<tr>
				<th>차량가격</th>
				<td>
					<input type="text" name="carprice" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			
			<tr>
				<th>차량색상</th>
				<td>
					<input type="color" name="carcolor" style="width: 200px;" class="form-control" required="required" value="#fff">
				</td>
			</tr>
			
			<tr>
				<th>구입일</th>
				<td>
					<input type="date" name="carguip" style="width: 200px;" class="form-control" required="required">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-success">DB저장</button>
					<button type="button" class="btn btn-outline-info" onclick="location.href='list'">목록으로</button>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>