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
<title>menu</title>
<style type="text/css">
	ul.menu{
		list-style: none;
	}
	ul.menu li {
		width: 130px;
		float: left;
		border: 1px solid mint;
		height: 60px;
		text-align: center;
		line-height: 60px;
		margin-right: 10px;
		font-size: 1.2em;
		font-family: 'Noto Sans KR';
		background-color: #ffc;
		cursor: pointer;
	}
	ul.menu li a{
		color: black;
		text-decoration: none;
	}
</style>
</head>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<body>
	<ul class="menu">
		<li>
			<a href="${root }/">HOME</a>
		</li>
		<li>
			<a href="${root }/ipgo/writeform">상품등록</a>
		</li>
		<li>
			<a href="${root }/ipgo/list">상품목록</a>
		</li>
		<li>
			<a href="${root }/member/list">회원목록</a>
		</li>
		<li>
			<a href="${root }/member/form">회원가입</a>
		</li>
		<li>
			<a href="${root }/board/list">게시판</a>
		</li>
		<li>
			<a href="${root }/load/map">오시는길</a>
		</li>
		
	</ul>

</body>
</html>