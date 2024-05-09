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
<title>addForm</title>
<script type="text/javascript">
	$(function(){
		$("#btncheck").click(function(){
			// id 읽기
			var id=$("#id").val();
			//alert(id);
			
			$.ajax({
				type:"get",
				url:"idcheck",
				dataType:"json",
				data:{"id":id},
				success:function(res){
					if(res.count==1){
						alert("이미 가입된 아이디입니다.\n다시 입력해주세요.");
						$("#id").val('');
					} else{
						alert("가입이 가능한 아이디입니다.");
					}
				}
			});	
			
		});
	});
</script>
</head>
<body>
<div style="margin:100px 100px; width: 500px;">
	<form action="insert" method="post">
		<table class="table table-bordered">
			<caption align="top"><b>회원가입</b></caption>
			<tr>
				<th>회원명</th>
				<td>
					<input type="text" name="name" required="required" style="width: 130px;">
				</td>
			</tr>
			
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" required="required" style="width: 130px;" id="id">
					<button type="button" class="btn btn-danger" id="btncheck">중복체크</button>
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="text" name="pass" required="required" style="width: 130px;">
				</td>
			</tr>
			
			<tr>
				<th>연락처</th>
				<td>
					<input type="text" name="hp" required="required" style="width: 130px;">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-success">회원가입</button>
					<button type="button" class="btn btn-info" onclick="location.href='memlist'">회원목록</button>
				</td>
			</tr>
		</table>
	</form>
	
</div>
	
</body>
</html>