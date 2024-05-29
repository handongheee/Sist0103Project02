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
<title>memberInfo</title>
<script type="text/javascript">
	$(function(){
		$(".btnnewphoto").click(function(){
			$("#newphoto").trigger("click");
		});
		
		$("#newphoto").change(function(){
			var num=$(this).attr("num");
			//alert(num);
			
			var form=new FormData();
			
			form.append("photo", $("#newphoto")[0].files[0]); // 선택한 한개만 로직으로 추가하겠다.
			form.append("num",num);
			
			console.dir(form);
			
			$.ajax({
				type:"post",
				dataType:"text",
				url:"updatephoto",
				processData:false,
				contentType:false,
				data:form,
				success:function(){
					location.reload();
				}
			})
		});
	});
</script>
</head>
<body>
<div style="margin: 50px 100px; width: 700px;">
	<table class="table table-bordered">
		<c:forEach var="dto" items="${list }">
		<!-- 로그인한 아이디와 동일할 경우 해당 계정 정보 출력 -->
		<c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.id }">
			<tr>
				<td style="width: 250px;" align="center" rowspan="5">
					<img alt="" src="../memberphoto/${dto.photo }" width="200" height="220" border="1">
					
					<br><br>
					
					<input type="file" id="newphoto" num="${dto.num }" style="display: none;">
					<button type="button" class="btn btn-info btn-sm btnnewphoto">사진수정</button>
				</td>
				
				<td>
					회원명: ${dto.name }
				</td>
				
				<td rowspan="5" align="center" valign="middle" style="width:200px;">
					<button type="button" class="btn btn-outline-warning" num="${dto.num}">수정</button>
					<button type="button" class="btn btn-outline-danger" num="${dto.num}">삭제</button>
				</td>
			</tr>
			
			<tr>
				<td>
					아이디: ${dto.id }
				</td>
			</tr>
			
			<tr>
				<td>
					이메일: ${dto.email }
				</td>
			</tr>
			
			<tr>
				<td>
					핸드폰: ${dto.hp }
				</td>
			</tr>
			
			<tr>
				<td>
					주소: ${dto.addr }
				</td>
			</tr>
		</c:if>
		</c:forEach>
	</table>
</div>
</body>
</html>