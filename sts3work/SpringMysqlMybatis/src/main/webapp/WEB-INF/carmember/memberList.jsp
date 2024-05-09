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
<title>memberList</title>
</head>
<body>
	<div style="margin: 50px 100px; width: 800px;">
		<button type="button" class="btn btn-success" style="width: 100px;" onclick="location.href='writeform'">고객등록</button>

		<button type="button" class="btn btn-info" style="width: 100px;" onclick="location.href='../samsung/list'">자동차 목록</button>

		<br>
		<br>
		<c:if test="${count==0}">
			<h2>등록된 고객정보가 없습니다</h2>
		</c:if>
		<c:if test="${count>0}">
			<h2>총 ${count}명의 고객이 있습니다</h2>
			<hr>
			<table class="table table-bordered">
				<tr class="table-primary">
					<th width="60">번호</th>
					<th width="100">고객명</th>
					<th width="120">핸드폰</th>
					<th width="150">주소</th>
					<th width="150">가입일</th>
					<th width="120">편집</th>
				</tr>
				
				<c:forEach var="dto" items="${list}" varStatus="i">
					<tr align="center">
						<td>${i.count}</td>
						<td>${dto.name}</td>
						<td>${dto.hp}</td>
						<td align="left">${dto.addr}</td>
						<td>
							<fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd HH:mm" />
						</td>
						<td>
							<button type="button" class="btn btn-outline-warning btn-sm" onclick="location.href='updateForm?num=${dto.num}'">수정</button>
							<button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href='delete?num=${dto.num}'">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>

		</c:if>
	</div>
</body>
</html>