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
<title>ex03</title>
</head>
<body>
	<h3 class="alert alert-success">Ex03 예제</h3>
	<br>
	<h4>메뉴 이름을 입력 후 엔터를 누르세요.</h4>
	<input type="text" id="search" class="form-control" style="width:150px;">
	<br><br>
	<h2 id="fname"></h2>
	<img alt="" src="" id="photo">
	
	<script type="text/javascript">
		$("#search").keyup(function(e){
			if(e.keyCode==13){
				var foodname=$(this).val();
				
				$.ajax({
	    			type:"get",
	    			dataType:"json",
	    			url:"foodlist3",
	    			data:{"foodname":foodname},
	    			success:function(res){
	    				$("#fname").text(res.foodname);
	    				$("#photo").attr("src","upload/"+res.photo);
	    				$("#search").val('');
	    			}
	    		});
				
				
			}
		});
	</script>
</body>
</html>