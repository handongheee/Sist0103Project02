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
<title>form1</title>
</head>
<body>
	<h2>폼 데이터 각각 읽기</h2>
	
	<form action="read1" method="post">
		<table class="table table-bordered" style="width:350px;">
			<tr>
				<th>학생명</th>
				<td>
					<input type="text" name="name" class="form-control" required="required">
				</td>
			</tr>
			
			<tr>
				<th>java 점수</th>
				<td>
					<input type="text" name="java" class="form-control" required="required">
				</td>
			</tr>
			
			<tr>
				<th>spring 점수</th>
				<td>
					<input type="text" name="spring" class="form-control" required="required">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-success">서버에 전송</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>