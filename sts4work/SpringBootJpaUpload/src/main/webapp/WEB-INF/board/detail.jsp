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
<title>detail</title>
</head>
<body>
	<div style="margin: 100px 100px;">
		<table class="table table-bordered" style="width: 500px;">
			<tr>
				<td>
					<h3>${dto.subject }</h3>
					
					<i class="bi bi-person-circle" style="color: gray"></i> &nbsp;${dto.writer }
					<div style="float: right; color: gray;"><fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/> </div>
				</td>
			</tr>
			
			<tr>
				<td>
					${dto.content } <br>
					
					<c:if test="${dto.photo!='no' }">
						<img alt="" src="../save/${dto.photo }" style="width: 250px;">
					</c:if>			
				</td>
			</tr>
			
			<tr>
				<td align="center">
					<button type="button" class="btn btn-outline-success" onclick="location.href='addform'">글쓰기</button>
					<button type="button" class="btn btn-outline-info" onclick="location.href='list'">목록</button>
					<button type="button" class="btn btn-outline-warning" onclick="location.href='updateform?num=${dto.num}'">수정</button>
					<button type="button" class="btn btn-outline-danger" onclick="location.href='delete?num=${dto.num}'">삭제</button>
				</td>
			</tr>
		</table>
	</div>


</body>
</html>