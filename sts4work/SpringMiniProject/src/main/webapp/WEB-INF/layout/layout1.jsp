<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
<title>layout1</title>
<style type="text/css">
	
	
	div.layout div.title{
		position: absolute;
		top: 10px;
		left: 500px;
		height: 100px;
	}
	
	div.layout div.menu{
		position: absolute;
		top: 170px;
		left: 250px;
		height: 100px;
	}
	
	div.layout div.info{
		position: absolute;
		top: 250px;
		left: 30px;
		height: 200px;
		width: 200px;
		border: 5px solid purple;
		border-radius: 30px;
		padding: 30px 20px;
	}
	
	div.layout div.main{
		position: absolute;
		left: 300px;
		top: 280px;
		width: 1000px;
		height: 1000px;
	}
	
	
</style>
</head>
<body>
	<div class="layout">
		<!-- tiles xml 불러옴 -->
		<div class="title">
			<tiles:insertAttribute name="title"/>
		</div>
		
		<div class="menu">
			<tiles:insertAttribute name="menu"/>
		</div>
		
		<div class="info">
			<tiles:insertAttribute name="info"/>
		</div>
		
		<div class="main">
			<tiles:insertAttribute name="main"/>
		</div>
	</div>
	
</body>
</html>