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

<title>title</title>
<style type="text/css">
	div.login{
		position: absolute;
		left: 800px;
		top: 30px;
		width: 350px;
	}
	
	#btnlogin, #btnlogout{
		margin-left: 700px;
	}
</style>
</head>
<body>
	<c:set var="root" value="<%=request.getContextPath() %>"/>
	<a href="/">
		<img alt="" src="${root }/image/logo.png" style="width: 400px;">
		<b>SpringBoot + Mybatis + Tiles3</b>
	</a>
	
	<div class="login">
	
		<c:if test="${sessionScope.loginok==null }">
			<button type="button" class="btn btn-success" style="width:100px" 
			onclick="location.href='${root}/login/main'">login</button>
		</c:if>
		
		<c:if test="${sessionScope.loginok!=null }">
			<b>${sessionScope.myid }님이 로그인중</b>
			<button type="button" class="btn btn-danger" style="width:100px" 
			onclick="location.href='${root}/login/logoutprocess'" id="btnlogout">logout</button>
		</c:if>
	</div>

	<!-- ajax 로그인 모달 폼 -->
	<div class="container mt-3">
		<c:if test="${sessionScope.loginok==null }">
			<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal" id="btnlogin">Ajax login</button>
		</c:if>
		
		<c:if test="${sessionScope.loginok!=null }">
			<b>${sessionScope.loginname } 님..</b>
			<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal" id="btnlogout">로그아웃</button>
		</c:if>
	</div>

	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">회원 로그인</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<i class="bi bi-person-circle"></i> 
					<input type="text" class="form-control" id="loginid" placeholder="아이디">
				</div>

				<div class="modal-body">
					<i class="bi bi-lock-fill"></i> 
					<input type="text" class="form-control" id="loginpass" placeholder="비밀번호">
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal" id="btnloginok">Login</button>
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<!-- ajax 로그인 이벤트 -->
	<script type="text/javascript">
		// 팝업창에 있는 로그인 버튼
		$("#btnloginok").click(function() {
			// 아이디와 비번 읽기
			var id = $("#loginid").val();
			var pass = $("#loginpass").val();
			var root = "${root}"; // 경로에 루트 붙이기 위함

			$.ajax({
				type : "get",
				url : root + "/member/login",
				dataType : "json",
				data : {"id" : id, "pass" : pass},
				success : function(res) {
					if (res.result == 'fail') {
						alert("아이디가 비밀번호가 틀립니다.");
						$("#loginid").val('');
						$("#loginpass").val('');
					} else {
						location.reload();
					}
				}
			})
		});

		// 로그아웃
		$("#btnlogout").click(function() {
			var root = "${root}";

			$.ajax({
				type : "get",
				url : root + "/member/login",
				dataType : "html",
				success : function(res) {
					location.reload();
				}
			})
		});
	</script>
</body>
</html>