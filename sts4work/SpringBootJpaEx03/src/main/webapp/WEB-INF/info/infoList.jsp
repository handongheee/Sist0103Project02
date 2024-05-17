<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>infoList</title>
<style type="text/css">
	.stuimg{
		width: 40px;
		height: 40px;
		border-radius: 100px;
	}
</style>
</head>
<body>
	<div style="margin:100px 100px;">
		<button type="button" class="btn btn-warning" onclick="location.href='addform'">학생정보 입력</button>
		<br><br>
		<h5 class="alert alert-warning">${totalCount }명의 학생이 존재합니다.</h5>
		
		<table class="table table-bordered" style="width: 1000px;">
			<tr class="table-primary">
				<th width="80">번호</th>
				<th width="150">학생명</th>
				<th width="180">사진</th>
				<th width="280">연락처</th>
				<th width="380">주소</th>
				<th width="180">편집</th>
			</tr>
			
			<c:forEach var="dto" items="${list }" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${dto.stuname }</td>
					<td>
						 <img alt="" src="../${dto.stuphoto }" class="stuimg">
					</td>
					<td>${dto.stuhp }</td>
					<td>${dto.stuaddr }</td>
					<td>
						<button type="button" class="btn btn-outline-success btn-sm" onclick="location.href='updateform?num=${dto.num }'">수정</button>
						<button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href='delete?num=${dto.num }'">삭제</button>
					</td>	
				</tr>
			</c:forEach>
			
		</table>
	</div>

</body>
</html>
