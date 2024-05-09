<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Gowun+Dodum&family=IBM+Plex+Sans+KR&family=Noto+Sans+KR:wght@100..900&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>memberForm</title>
</head>
<body>
	<div style="margin: 50px 100px; width: 400px;">
		<form action="write" method="post">
			<table class="table table-bordered">
				<caption align="top">
					<b>고객 정보 입력</b>
				</caption>
				<tr>
					<th width="100" class="table-light">고객명</th>
					<td width="200"><input type="text" name="name" style="width: 120px;" required="required" class="form-control">
					</td>
				</tr>
				<tr>
					<th class="table-light" width="100">연락처</th>
					<td width="200"><input type="text" name="hp" style="width: 150px;" required="required" class="form-control">
					</td>
				</tr>
				<tr>
					<th class="table-light" width="100">주소</th>
					<td width="200"><input type="text" name="addr" style="width: 250px;" required="required" class="form-control">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-success">DB저장</button>
						<button type="button" class="btn btn-outline-info" onclick="location.href='list'">고객목록</button>
					</td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>