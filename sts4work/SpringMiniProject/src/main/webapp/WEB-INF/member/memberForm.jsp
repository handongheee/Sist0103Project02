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
<title>memberForm</title>
<style type="text/css">
	#showimg{
		width: 130px;
		height: 160px;
		border: 1px solid gray;
	}
</style>
<script type="text/javascript">
	$(function(){
		// 버튼 클릭 시 사진 불러오는 이벤트
		$("#btnphoto").click(function(){
			$("#myphoto").trigger("click");
		});
		
		// 사진을 불러오면 미리보기
		$("#myphoto").change(function(){
			
			if ($(this)[0].files[0]) {
		        var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
		        reader.onload = function (e) {
		        //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
		            $('#showimg').attr('src', e.target.result);
		            //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
		            //(아래 코드에서 읽어들인 dataURL형식)
		        }                   
		        reader.readAsDataURL($(this)[0].files[0]);
		        //File내용을 읽어 dataURL형식의 문자열로 저장
		    }	
		});
		
		// 중복체크 버튼 클릭 시 아이디 체크
		$("#btnidcheck").click(function(){	
			var id=$("#loginid").val();
			//alert(id);
			
			$.ajax({
				type:"get",
				url:"idcheck",
				dataType:"json",
				data:{"id":id},
				success:function(data){
					if(data.count==1){
						//alert("이미 존재하는 아이디입니다.");
						$("span.idsuccess").text("사용불가");
						$("#loginid").val('');
					} else{
						//alert("사용 가능한 아이디입니다.");
						$("span.idsuccess").text("사용가능");
					}
				}

			});
			
		});
		
		// 아이디 입력 시 idsuccess 값 지우기
		$("#loginid").keydown(function(){
			$("span.idsuccess").text("");
		});
		
		// 2번째 비밀번호 입력 시 체크
		$("#pass2").keyup(function(){
			var p1=$("#pass").val();
			var p2=$(this).val();
			
			if(p1==p2){
				$("span.passsuccess").text("비밀번호 일치");
			} else{
				$("span.passsuccess").text("비밀번호 불일치");
			}
		});		
	});
	
	// submit 전에 호출 - null값 체크
	function check(){
		// 사진
		if($("#myphoto").val()==''){
			alert("사진을 넣어주세요.");
		 	return false;
		}
		
		// 중복체크
		if($("span.idsuccess").text()!='사용가능'){
			alert("아이디 중복확인 필요");
			return false;
		}
		
		// 비밀번호
		if($("span.passsuccess").text()!='비밀번호 일치'){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
	}
	
</script>
</head>
<body>
	<div style="margin:20px 50px;">
		<form action="insert" method="post" enctype="multipart/form-data" onsubmit="return check()">
			<table class="table table-bordered" style="width: 600px;">
				<caption align="top"><b>회원가입</b></caption>
				<tr>
					<td style="width: 250px;" align="center" rowspan="4">
						<input type="file" name="myphoto" id="myphoto" style="display: none;">
						<button type="button" id="btnphoto" class="btn btn-secondary">사진선택</button>
						<br>
						<img id="showimg">
					</td>
					
					<td>
						<div class="d-inline-flex">
							<input type="text" placeholder="아이디 입력" name="id" id="loginid" class="form-control" 
							style="width: 120px;" required="required"> &nbsp;
							<button type="button" class="btn btn-danger btn-sm" id="btnidcheck">중복확인</button>
							&nbsp;
							<span class="idsuccess" style="width: 60px; color: green;"></span>
						</div>
					</td>
				</tr>
				
				<tr>
					<td>
						<div class="d-inline-flex">
							<input type="password" style="width: 130px;" name="pass" id="pass" class="form-control" 
							required="required" pattern="[0-9]{4}" placeholder="숫자 4자리" maxlength="4"> &nbsp;
							<input type="password" style="width: 130px;" id="pass2" class="form-control" 
							required="required" pattern="[0-9]{4}" placeholder="비밀번호 확인" maxlength="4">
							&nbsp;
							<span class="passsuccess" style="width: 60px; color: red;"></span>
						</div>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="text" name="name" class="form-control" style="width: 150px;"
						placeholder="이름 입력" required="required">
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="email" name="email" class="form-control" style="width: 230px;"
						placeholder="이메일 입력" required="required">
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<div class="d-inline-flex">
							<input type="text" name="hp" placeholder="전화번호 입력" class="form-control" style="width: 200px;"
							required="required">
							&nbsp;&nbsp;
							<input type="text" name="addr" placeholder="주소 입력" class="form-control" style="width: 330px;"
							required="required">
						</div>	
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-success" style="width: 200px;">회원가입</button>
					</td>
				</tr>
				
			</table>
		</form>
		
	</div>
</body>
</html>