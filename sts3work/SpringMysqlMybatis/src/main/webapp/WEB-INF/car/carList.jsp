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
<title>carList</title>
</head>
<body>
	<div style="margin: 50px 100px; width: 800px;">
		<button type="button" class="btn btn-info"
			onclick="location.href='writeForm'">자동차 정보 입력</button>
		<c:if test="${totalCount==0 }">
			<h4 class="alert alert-info">저장된 차의 정보가 없습니다.</h4>
		</c:if>

		<c:if test="${totalCount>0 }">
			<h4>총 ${totalCount }개의 자동차 정보가 존재합니다.</h4>
			<hr>
			<table class="table table-bordered">
				<tr class="table table-success">
					<th width="80">번호</th>
					<th width="280">자동차명</th>
					<th width="120">차량색상</th>
					<th width="120">차량가격</th>
					<th width="180">구입일</th>
					<th width="180">편집</th>
				</tr>

				<c:forEach var="dto" items="${list }" varStatus="i">
					<tr>
						<td align="center">${i.count }</td>
						<td>${dto.carname }</td>
						<td align="center">
							<div style="width:20px; height:20px; background-color: ${dto.carcolor}"></div>
						</td>
						<td><fmt:formatNumber value="${dto.carprice }" type="currency" /></td>
						<td>${dto.carguip }</td>
						<td>
							<button type="button" class="btn btn-outline-info btn-sm" onclick="location.href='updateForm?num=${dto.num}'">수정</button>
							<button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href='delete?num=${dto.num}'">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>

		</c:if>
	</div>

</body>
</html>