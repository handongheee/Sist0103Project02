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
<title>memberList</title>
<script type="text/javascript">
	$(function(){
		// 전체선택하면 박스선택 해제
		$("#allcheck").click(function(){
			var chk=$(this).is(":checked");
			
			// 전체 체크값을 모든 체크에 일괄 전달
			$(".del").prop("checked",chk);
		});
		
		$("#btnmemberdel").click(function(){
			var cnt=$(".del:checked").length;
			//alert(cnt);
			
			if(cnt==0){
				alert("삭제할 회원을 선택해 주세요.");
				return;
			}
			
			$(".del:checked").each(function(i, elt){
				var num=$(this).attr("num");
				console.log(num); // 선택한 num만 나오나 확인!
				
				// 선택한 것 모두 삭제
				$.ajax({
					type:"get",
					url:"delete",
					dataType:"html",
					data:{"num":num},
					success:function(){
						alert("삭제되었습니다.");
						location.reload();
					}
					
				});
				
				
			})
		});
	});
</script>
</head>
<body>
<h3>${mcount }명의 회원이 있습니다.</h3>
<br>
<table class="table table-bordered" style="width: 1000px;">
	<caption align="top"><b>전체 회원 명단</b></caption>
	
	<tr class="table-secondary">
		<th width="50">번호</th>
		<th width="130">회원명</th>
		<th width="120">아이디</th>
		<th width="160">핸드폰</th>
		<th width="250">주소</th>
		<th width="250">이메일</th>
		<th width="90">
			<input type="checkbox" id="allcheck"> 삭제
		</th>	
	</tr>
	
	<c:forEach var="dto" items="${list }" varStatus="i">
		<tr>
			<td>${i.count }</td>
			<td>
				<img alt="" src="../memberphoto/${dto.photo }" style="width: 30px; height: 30px;">
				${dto.name }
			</td>
			<td>${dto.id }</td>
			<td>${dto.hp }</td>
			<td>${dto.addr }</td>
			<td>${dto.email }</td>
			<td align="center">
				<input type="checkbox" num="${dto.num }" class="del"> 
			</td>
		</tr>
	</c:forEach>
</table>

<button type="button" class="btn btn-danger btn-smxs" style="margin-left: 650px;" id="btnmemberdel">Delete</button>
</body>
</html>