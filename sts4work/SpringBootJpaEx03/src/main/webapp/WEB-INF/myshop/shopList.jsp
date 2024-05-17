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
<title>shopList</title>
<style type="text/css">
	.box{
		width: 30px;
		height: 30px;
		border-radius: 100px;
	}
</style>
</head>
<body>
	<div style="margin:100px 100px; width:1000px;">
		<button type="button" class="btn btn-outline-info" onclick="location.href='writeform'">상품입력</button>
		<br><br>
		
		<h4 class="alert alert-success">
			총 ${totalCount }개의 상품이 있습니다.
		</h4>
		
		<table class="table table-bordered">
			<tr class="table-info">
				<th width="80">번호</th>
				<th width="280">상품명</th>
				<th width="180">색상</th>
				<th width="280">가격</th>
				<th width="180">입고일</th>
				<th width="250">등록일</th>
				<th width="250">편집</th>
			</tr>
			
			<c:forEach var="dto" items="${list }" varStatus="i">
				<tr>
					<td align="center">${i.count }</td>
					<td>${dto.sangname }</td>
					<td>
						<div class="box" style="background-color:${dto.sangcolor}"></div>
					</td>
					<td>
						<fmt:formatNumber value="${dto.sangprice }" type="currency"/>
					</td>
					<td>${dto.sangipgo }</td>
					<td>
						<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH시"/>
					</td>
					<td>
						<button type="button" class="btn btn-warning btn-sm" onclick="location.href='updateform?num=${dto.num }'">수정</button>
						<button type="button" class="btn btn-danger btn-sm" onclick="location.href='delete?num=${dto.num }'">삭제</button>
					</td>				
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>