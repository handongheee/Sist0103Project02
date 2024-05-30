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
				dataType:"html",
				url:"updatephoto",
				processData:false,
				contentType:false,
				data:form, // 생성된 폼데이터 넣기
				success:function(){
					location.reload();
				}
			})
		});
		
		// 0530 수정버튼 클릭 시 모달 다이얼로그에 데이터 넣기
		$(".btnupdate").click(function(){
			updatenum=$(this).attr("num"); // 전역으로 생성
			//alert(updatenum);
			
			$.ajax({
				type:"get",
				dataType:"json",
				url:"updateform",
				data:{"num":updatenum},
				success:function(res){
					console.dir(res);
					$("#updatename").val(res.name);
					$("#updatehp").val(res.hp);
					$("#updateemail").val(res.email);
					$("#updateaddr").val(res.addr);
				}
			});
		});
		
		// 수정처리
		$("#btnupdateok").click(function(){
			//var unum=$(".btnupdate").attr("num"); => updatenum으로 활용
			var uname=$("#updatename").val();
			var uhp=$("#updatehp").val();
			var uemail=$("#updateemail").val();
			var uaddr=$("#updateaddr").val();
			
			var data="num="+updatenum+"&name="+uname+"&hp="+uhp+"&email="+uemail+"&addr="+uaddr;
			//alert(uname);
			
			$.ajax({
				type:"post",
				dataType:"html",
				url:"update",
				//data:{"num":updatenum, "name":uname, "hp":uhp, "email":uemail, "addr":uaddr},
				data:data,
				success:function(){
					location.reload();
				}
			});
		});
		
		// 탈퇴
		$(".btndelete").click(function(){
			var num=$(this).attr("num");
			//alert(num);
			
			var a=confirm("정말 탈퇴하시겠습니까?");
			
			if(a){
				$.ajax({
					type:"get",
					dataType:"html",
					url:"deleteme",
					data:{"num":num},
					success:function(){
						alert("탈퇴하셨습니다.");
						location.reload();
					}
				});
			}
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
					<button type="button" class="btn btn-outline-warning btnupdate" num="${dto.num}" data-bs-toggle="modal" data-bs-target="#myUpdateModal">수정</button>
					<button type="button" class="btn btn-outline-danger btndelete" num="${dto.num}">삭제</button>
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

<!-- The Modal -->
<div class="modal" id="myUpdateModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">회원정보 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="d-inline-flex" style="margin-bottom: 10px;">
        	<label style="width: 80px;">이름: </label> &nbsp;&nbsp;
        	<input type="text" class="form-control" id="updatename">
        </div>
        
        <div class="d-inline-flex" style="margin-bottom: 10px;">
        	<label style="width: 80px;">연락처: </label>&nbsp;&nbsp;
        	<input type="text" class="form-control" id="updatehp">
        </div>
        
        <div class="d-inline-flex" style="margin-bottom: 10px;">
        	<label style="width: 80px;">이메일: </label>&nbsp;&nbsp;
        	<input type="text" class="form-control" id="updateemail">
        </div>
        
        <div class="d-inline-flex" style="margin-bottom: 10px;">
        	<label style="width: 80px;">주소: </label>&nbsp;&nbsp;
        	<input type="text" class="form-control" id="updateaddr">
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="button" class="btn btn-warning" data-bs-dismiss="modal" id="btnupdateok">수정</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소</button>
      </div>

    </div>
  </div>
</div>

</body>
</html>