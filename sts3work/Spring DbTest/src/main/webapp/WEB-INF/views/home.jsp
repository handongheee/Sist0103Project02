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
<title>home</title>
</head>
<body>
	<div style="margin: 30px 50px;">
		<h3 class="alert alert-danger">Myshop 목록</h3>
		<br>
		<h3 class="alert alert-danger">총 ${totalCount } 개의 상품이 입고되었습니다.</h3>
		
		<table class="table table-bordered" style="width:800px;">
			<tr>
				<th width="80">상품번호</th>
				<th width="300">상품명</th>
				<th width="200">가격</th>
				<th width="180">입고일</th>
				<th width="180">비고</th>
			</tr>
			
			<c:if test="${totalCount==0 }">
				<tr>
					<td colspan="5" align="center">
						<b>등록된 상품이 없습니다.</b>
					</td>
				</tr>
			</c:if>
			
			<c:if test="${totalCount>0 }">
				<c:forEach var="dto" items="${list }" varStatus="i">
					<tr>
						<td align="center">${i.count }</td>
						<td>
							<img alt="" src="res/image2/${dto.photo }" width="80">
							<b>${dto.sangpum }</b>
						</td>
						
						<td align="center">
							<fmt:formatNumber value="${dto.price }" type="currency"/>
						</td>
						
						<td align="center">${dto.ipgoday }</td>
						
						<td>
							<button class="btn btn-info btn-sm">수정</button>
							<button class="btn btn-danger btn-sm">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			
		</table>
	</div>
</body>
</html>