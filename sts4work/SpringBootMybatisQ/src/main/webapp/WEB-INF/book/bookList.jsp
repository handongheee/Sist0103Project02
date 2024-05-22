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
<title>bookList</title>
</head>
<body>
	<div style="margin: 100px 100px;">
		<h4 class="alert alert-primary">총 ${total } 권의 도서가 판매중입니다.</h4>
		
		<button type="button" class="btn btn-success" onclick="location.href='form'">도서등록</button>
		<br><br>
		<c:forEach var="book" items="${list }" varStatus="i">
			<div style="float: left; margin-right: 10px;">
				<table>
					<tr>
						<td width="250px;">
							<img alt="" src="../bookphoto/${book.bookimage }" style="width: 200px;"> <br>
						</td>
					</tr>
					
					<tr>
						<td>
						<b>${book.bookname }</b> <br>
						<fmt:formatNumber value="${book.bookprice }" type="currency"/>
						 <br>
						저자: ${book.writer } <br>
						출판사: ${book.bookcompany } <br>
						</td>
					</tr>		
				</table>		
			</div>
			
			
		</c:forEach>
	</div>
	
</body>
</html>