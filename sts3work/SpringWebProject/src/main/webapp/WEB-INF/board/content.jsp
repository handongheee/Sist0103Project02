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
<title>content</title>
</head>
<body>
<div style="margin:100px 100px; width:600px;">
	<table class="table table-bordered">
		<caption align="top"><b>내용보기</b></caption>
		<tr>
			<td>
				<b style="font-size: 1.5em;">${dto.subject }</b>
				<span style="color:#aaa; float: right;">
					<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
				</span>
			</td>
		</tr>
		
		<tr>
			<td>
				<b>${dto.writer }</b>
				<span style="float: right;">조회수 ${dto.readcount }</span>
				
				<div>
					<c:if test="${dto.photo!='no' }">
						<c:forTokens var="f" items="${dto.photo }" delims=",">
							<div style="float: right;">
								<a href="download?clip=${f }">
									<i class="bi bi-file-earmark-arrow-down"></i>
									<span>${f }</span>
								</a>
							</div>
						</c:forTokens>
					</c:if>
				</div>
			</td>
		</tr>
		
		<tr>
			<td>
				<pre>${dto.content }</pre>
				<br>
				<c:if test="${dto.photo!='no' }">
					<c:forTokens var="im" items="${dto.photo }" delims=",">
						<img alt="" src="../photo/${im }" class="img-thumbnail" style="width: 130px; ">&nbsp;&nbsp;
					</c:forTokens>
				</c:if>
			</td>
		</tr>
		
		<tr>
			<td>
				<button type="button" class="btn btn-outline-success" onclick="location.href='addform'">글쓰기</button>
				<button type="button" class="btn btn-outline-info" onclick="location.href='list?currentPage=${currentPage }'">목록</button>
				<button type="button" class="btn btn-outline-warning" onclick="location.href='updateform?num=${dto.num}&currentPage=${currentPage }'">수정</button>
				<button type="button" class="btn btn-outline-danger" onclick="location.href='delete?num=${dto.num}&currentPage=${currentPage }'">삭제</button>
			</td>
		</tr>
	</table>
</div>
	
</body>
</html>