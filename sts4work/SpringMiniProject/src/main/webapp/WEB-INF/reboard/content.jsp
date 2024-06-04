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
<div style="margin: 100px 100px">
	<table class="table table-bordered" style="width: 600px;">
		<tr>
			<td>
				<h3><b>${dto.subject }</b></h3>
				${dto.name } (${dto.id })<br>
				
				<span style="color: #aaa; float: right;">
					<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd"/>
				</span>
			</td>
		</tr>
		
		<tr height="300" valign="middle">
			<td>
				<pre>${dto.content }</pre>
				<br><br>
				<c:if test="${dto.photo!='no' }">
					<c:forTokens var="photo" items="${dto.photo }" delims=",">
						<img alt="" src="../boardphoto/${photo }" width="100" onerror="this.style.display='none'">
					</c:forTokens>
				</c:if>
				<br><br>
				
				<div class="d-inline-flex">
					<div class="likes">
						<i class="bi bi-hand-thumbs-up-fill"></i> 좋아요 <b>${dto.likes }</b>
					</div>
					&nbsp;&nbsp;
					<i class="bi bi-chat-square-text"></i> &nbsp; <b class="banswer">0</b>
				</div>
				
			</td>
		</tr>
		
		<tr>
			<td>
				<button type="button" class="btn btn-outline-success" onclick="location.href='form'">글쓰기</button>
				<button type="button" class="btn btn-outline-primary" 
				onclick="location.href='form?num=${dto.num}&regroup=${dto.regroup }&restep=${dto.restep }&relevel=${dto.relevel }&currentPage=${currentPage }'">답글</button>
				<button type="button" class="btn btn-outline-info" onclick="location.href='list?currentPage=${currentPage}'">목록</button>
				
				<!-- 로그인중이면서 세션 아이디와 글의 아이디가 같을때만 수정/삭제 -->
				<c:if test="${sessionScope.loginok!=null && sessionScope.myid==dto.id }">
					<button type="button" class="btn btn-outline-warning" onclick="location.href='updateform?num=${dto.num}&currentPage=${currentPage }'">수정</button>
					<button type="button" class="btn btn-outline-danger" onclick="location.href='delete?num=${dto.num}&currentPage=${currentPage }'">삭제</button>
				</c:if>
			</td>
		</tr>
	</table>
	
	<script type="text/javascript">
		$("div.likes").click(function(){
			var thumbs=$(this).find("i").attr("class");
			//alert(thumbs);
			
			if(thumbs=='bi bi-hand-thumbs-up-fill'){
				$(this).find("i").attr("class","bi bi-hand-thumbs-up-fill").css("color","red");
			} else{
				$(this).find("i").attr("class","bi bi-hand-thumbs-up-fill").css("color","black");
			}
			
			// 좋아요 증가
			var num=${dto.num};
			//alert(num);
			
			$.ajax({
				type:"get",
				dataType:"json",
				url:"likes",
				data:{"num":num},
				success:function(res){
					$("div.likes").find("b").text(res.likes);
				}
			});
			
		})
	</script>
	
</div>

</body>
</html>