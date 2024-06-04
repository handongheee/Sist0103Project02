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
	<div class="searcharea" style="width: 100%; text-align: center;">
		<!-- 검색창 -->
		<form action="list">
			<div style="width: 500px;" class="d-inline-flex">
				<select style="width: 70px;" name="searchcolumn" class="form-control">
					<option value="subject">제목</option>
					<option value="id">아이디</option>
					<option value="name">작성자</option>
					<option value="content">내용</option>
				</select>
				&nbsp;&nbsp;
				<input type="text" name="searchword" class="form-control" style="width: 300px;" placeholder="검색단어">
				&nbsp;&nbsp;
				<button type="submit" class="btn btn-success">검색</button>
			</div>
		</form>
		
		<Br>
		<div class="listarea" style="margin: 3px;">
			<h5 class="alert alert-primary">총 ${totalCount }개의 게시글이 있습니다.</h5>
			<br>
			<table class="table table-bordered">
				<tr class="table-success"> 
					<th width="50">번호</th>
					<th width="330">제목</th>
					<th width="120">작성자</th>
					<th width="180">작성일</th>
					<th width="50">조회</th>
					<th width="50">좋아요</th>
				</tr>
				
				<c:if test="${totalCount==0 }">
					<tr>
						<td colspan="6" align="center">
							<h5>등록된 게시물이 없습니다.</h5>
						</td>
					</tr>
				</c:if>
				
				<c:if test="${totalCount>0 }">
					<c:forEach var="dto" items="${list }">
						<tr>
							<td>${no }</td>
							<c:set var="no" value="${no-1 }"/>
							<td align="left">
								<!-- 답글일 경우 level 1당 2칸 띄우기 -->
								<c:forEach begin="1" end="${dto.relevel }">
									&nbsp;&nbsp;
								</c:forEach>
								<!-- 답글일 경우 답글 이미지 -->
								<c:if test="${dto.relevel>0 }">
									<img alt="" src="../image/re.png">
								</c:if>
								
								<a href="detail?num=${dto.num }&currentPage=${currentPage}" style="color: black; text-decoration: none;">
									${dto.subject }
									<c:if test="${dto.photo!='no' }">
										<i class="bi bi-image" style="color: #aaa"></i>
									</c:if>
								</a>
							</td>
							
							<td>${dto.name }</td>
							<td><fmt:formatDate value="${dto.writeday }" pattern="YYYY-MM-dd"/> </td>
							<td>${dto.readcount }</td>
							<td>${dto.likes }</td>
						</tr>					
					</c:forEach>
				</c:if>
				
				<!-- 글쓰기 버튼은 로그인을 해야만 보이게 -->
				<c:if test="${sessionScope.loginok!=null }">
					<tr>
						<td colspan="6" align="right"> 
							<button type="button" class="btn btn-outline-success" onclick="location.href='form'">글쓰기</button>
						</td>
					</tr>
				</c:if>
				
			</table>
		</div>
		
		
		<!-- 페이징 -->
	<div style="margin-top: 100px; width: 1000px; text-align: center;">
		<ul class="pagination justify-content-center">
			<!-- 이전 -->
			<c:if test="${startPage>1 }">
				<li class="page-item"><a class="page-link"
					href="list?currentPage=${startPage-1 }" style="color: black;">이전</a>
				</li>
			</c:if>

			<!-- 페이지번호 -->
			<c:forEach var="pp" begin="${startPage }" end="${endPage }">
				<c:if test="${currentPage==pp }">
					<li class="page-item active"><a class="page-link"
						href="list?currentPage=${pp }">${pp }</a></li>
				</c:if>

				<c:if test="${currentPage!=pp }">
					<li class="page-item"><a class="page-link"
						href="list?currentPage=${pp }">${pp }</a></li>
				</c:if>
			</c:forEach>

			<!-- 다음 -->
			<c:if test="${endPage<totalPage }">
				<li class="page-item"><a class="page-link"
					href="list?currentPage=${endPage+1 }" style="color: black">다음</a></li>
			</c:if>
		</ul>
	</div>
		
		
	</div>

</body>
</html>