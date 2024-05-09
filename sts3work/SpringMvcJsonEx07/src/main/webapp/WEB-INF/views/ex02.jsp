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
<title>ex02</title>
</head>
<body>
<h3 class="alert alert-danger">Ex02 예제</h3>
	<br>
	<button type="button" id="btn1" class="btn btn-info">foodlist2 Json 데이터 출력하기</button>
	
	<div id="out1">	</div>
	
	<script type="text/javascript">
		$("#btn1").click(function(){
			
			$.ajax({
				type:"get",
				dataType:"json",
				url:"foodlist2",
				success:function(data){
					// 누적시켜 출력
					var s="";
					$.each(data, function(i, elt){
						s+="<figure>";
						s+="<img src='upload/"+elt.photo+"' width=100>";
						s+="<figcaption><b>";
						s+=elt.foodname;
						s+="</b></figcaption>";
						s+="</figure>";
					});
					
					$("#out1").html(s);
				}
			});
			
		});
	
	</script>
	
</body>
</html>