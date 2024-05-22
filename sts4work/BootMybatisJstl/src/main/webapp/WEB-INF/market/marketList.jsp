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
<title>marketList</title>
</head>
<body>
	<div style="margin: 100px 100px;">
		<button type="button" class="btn btn-success" onclick="location.href='addform'">상품등록</button>
		
		<br><br>

		<c:if test="${totalCount==0 }">
			<div class="alert alert-info">
				<b>저장된 정보가 없습니다.</b>
			</div>
		</c:if>
		
		<c:if test="${totalCount>0 }">
			<div class="alert alert-danger">
				<b>총 ${totalCount }개의 상품정보가 존재합니다.</b>
			</div>
		</c:if>


		<c:forEach var="dto" items="${list }" varStatus="i">
			<table class="table table-bordered" style="width: 800px;">
				<tr>
					<td width="200px" align="center">
						<c:if test="${dto.photoname==null }">
							<img alt="" src="../photo/noimage.png" style="width: 120px; margin: 10px;">
						</c:if> 
						
						<c:if test="${dto.photoname!=null }">
							<img alt="" src="../photo/${dto.photoname }" style="width: 150px; margin: 10px;">
						</c:if>
					</td>

					<td valign="middle">
						<div style="margin: 10px 20px;">
							<h6>상품명: ${dto.sang }</h6>
							<h6>단가: <fmt:formatNumber value="${dto.dan }" type="currency" /></h6>
							<h7>입고일: <fmt:formatDate value="${dto.ipgoday }" pattern="yyyy-MM-dd HH:mm"/> </h7> <br><br>
							<button type="button" class="btn btn-outline-warning btn-sm" onclick="location.href='updateform?num=${dto.num}'">수정</button>
							<button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href='delete?num=${dto.num}'">삭제</button>
						</div>
					</td>
				</tr>
			</table>
		</c:forEach>

	</div>
</body>
</html>