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
<title>boardList</title>
</head>
<body>
	<div style="margin: 100px 100px;">
		<button type="button" class="btn btn-outline-info" onclick="location.href='addform'">글쓰기</button>
		<br><br>
		<h3>총 ${count }개의 게시물이 있습니다.</h3>
		<br>
		<table class="table table-bordered">
			<tr class="table table-primary">
				<th width="60">번호</th>
				<th width="380">제목</th>
				<th width="150">작성자</th>
				<th width="280">작성일</th>
			</tr>
			
			<c:if test="${count==0 }">
				<tr>
					<td colspan="4" align="center">
						<b>등록된 게시글이 없습니다.</b>
					</td>
				</tr>
			</c:if>
			
			<c:if test="${count>0 }">
				<c:forEach var="dto" items="${list }" varStatus="i">
					<c:set var="n" value="${count-i.index }"/>
					<tr>
						<td align="center">${n }</td>
						<td>
							<a href="detail?num=${dto.num }" style="text-decoration: none; color: black;">${dto.subject }
							<c:if test="${dto.photo!='no' }">
								&nbsp;<i class="bi bi-image" style="color: #aaa"></i>
							</c:if>
						
						</a></td>
						<td>${dto.writer }</td>
						<td><fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/> </td>
					</tr>
				</c:forEach>
			</c:if>
			
		
		</table>
	</div>
</body>
</html>