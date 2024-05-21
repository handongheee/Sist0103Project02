<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div style="margin:100px 100px; width: 500px;">
		<form action="update" method="post">	
			<input type="hidden" name="num" value="${dto.num }">
			<table class="table table-bordered">
				<caption align="top"><b>상품정보 수정</b></caption>
				<tr>
					<th>상품명</th>
					<td>
						<input type="text" name="sangname" class="form-control" style="width:150px;" required="required" value="${dto.sangname }">
					</td>
				</tr>
				
				<tr>
					<th>가격</th>
					<td>
						<input type="text" name="sangprice" class="form-control" style="width:150px;" required="required" value="${dto.sangprice }">
					</td>
				</tr>
				
				<tr>
					<th>색상</th>
					<td>
						<input type="color" name="sangcolor" class="form-control" style="width:150px;" required="required" value="${dto.sangcolor }">
					</td>
				</tr>
				
				<tr>
					<th>입고일</th>
					<td>
						<input type="date" name="sangipgo" class="form-control" style="width:150px;" required="required" value="${dto.sangipgo }">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"> 
						<input type="submit" class="btn btn-success" value="수정">
						<input type="button" class="btn btn-info" value="목록" onclick="location.href='list'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>