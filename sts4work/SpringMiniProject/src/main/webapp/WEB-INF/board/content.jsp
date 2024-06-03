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
<style type="text/css">
	.day{
		color:gray;
		margin-left: 100px;
		font-size: 0.9em;
	}
</style>
<script type="text/javascript">
   $(function(){
	   
	   num=$("#num").val(); //전역변수
	   loginok="${sessionScope.loginok}";
	   myid="${sessionScope.myid}";
	   
	   //alert(loginok+","+myid);
	   
	   list();
	   
	   $("#btnansweradd").click(function(){
		    var content=$("#content").val();
		    
		    if(content.trim().length==0){
		    	alert("댓글내용을 입력해주세요");
		    	return; 
		    }
		    
		    //입력하면 ajax로 insert처리
		    $.ajax({
		    	type:"post",
		    	dataType:"html",
		    	url:"ainsert",
		    	data:{"num":num,"content":content},
		    	success:function(res){
		    		//alert("성공");
		    		list();
		    		
		    		//입력값 초기화
		    		$("#content").val("");		    		
		    	}	    	
		    })
	   })	  
	   
	   
		// 0603 
		// 댓글 - 삭제
		$(document).on("click", "i.adel", function(){
			var idx=$(this).attr("idx");
			//alert(idx);
			
			var a=confirm("해당 댓글을 삭제할까요?");
			if(a){
				$.ajax({
					type:"get",
					dataType:"html",
					url:"adelete",
					data:{"idx":idx},
					success:function(){
						alert("삭제되었습니다.");
						list(); 
					}
				});
			}		
		});
	   
	   // 댓글 - 수정버튼 누르면 모달창 출력 
		$(document).on("click", "i.amod", function() {
			idx = $(this).attr("idx");
			//alert(idx);

			$.ajax({
				type : "get",
				dataType : "json",
				url : "adata",
				data : {"idx" : idx},
				success : function(data) {
					$("#ucontent").val(data.content);
				}
			});
			
			$("#myUpdateContentModal").modal("show");
		})

		// 수정
		$(document).on("click","#btnupdateok", function(){
			var content=$("#ucontent").val();
			//alert(content+","+idx);
			
			$.ajax({
				type:"post",
				dataType:"html",
				url:"aupdate",
				data:{"idx":idx, "content":content},
				success:function(data){
					alert("수정되었습니다.");
					list();
				}
			});
		});

	})

	//댓글리스트
	function list() {
		num = $("#num").val(); //전역변수
		loginok = "${sessionScope.loginok}";
		myid = "${sessionScope.myid}";

		$.ajax({
			type : "get",
			dataType : "json",
			url : "alist",
			data : {"num" : num},
				success : function(data) {
					$("span.acount").text(data.length); //댓글갯수

					var s = "";
					$.each(data,function(i, dto) {

						s += "<b>" + dto.name + "</b>: "+ dto.content;
						s += "<span class='day'>"+ dto.writeday + "</span>";

						if (loginok == 'yes' && myid == dto.myid) {
							s += "<i class='bi bi-pencil-square amod' idx='"+dto.idx+"'></i>";
							s += "&nbsp";
							s += "<i class='bi bi-trash-fill adel' idx='"+dto.idx+"'></i>";
						}

						s += "<br>";
					})

					$("div.alist").html(s);
				}
		})
	}
</script>
</head>
<body>
<div style="margin: 50px 100px;">
	<table class="table table-bordered" style="width: 600px;">
		<tr>
			<td>
				<h3><b>${dto.subject }</b>
					<span style="color: #aaa; float: right; font-size: 12pt;">
						<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
					</span>
				</h3>
				<span>작성자: ${dto.name } (${dto.myid })</span>
				
				<c:if test="${dto.uploadfile!='no' }">
					<span style="float: right;">
						<a href="download?clip=${dto.uploadfile }" style="color: gray;">
						<i class="bi bi-file-earmark-text" style="font-size: 14pt;"></i>
							<b>${dto.uploadfile }</b>
						</a>
					</span>				
				</c:if>
			</td>
		</tr>
		
		<tr>
			<td>
				<c:if test="${bupload==true }">
					<h5>업로드된 파일이 이미지입니다.</h5>
					<img alt="" src="../boardphoto/${dto.uploadfile }">
				</c:if>
				
				<br><br><br>
				
				<pre>
${dto.content }
				</pre>
				<br>
				<b>조회: ${dto.readcount }</b> &nbsp;&nbsp;
				<b>댓글: <span class="acount"></span> </b>
			</td>
		</tr>
		
		<!-- 댓글 -->
		<tr>
			<td>
				<div class="alist"></div>
				
				<input type="hidden" id="num" value="${dto.num }">
				<c:if test="${sessionScope.loginok!=null }">
					<div class="aform">
						<div class="d-inline-flex">
							<input type="text" class="form-control" style="width: 500px;" placeholder="댓글을 입력하세요." id="content"> &nbsp;
							<button type="button" class="btn btn-info" style="width: 60px;" id="btnansweradd">등록</button>
						</div>
					
					</div>
				</c:if>
			</td>	
		</tr>
		
		<!-- 버튼 -->
		<tr>
			<td align="center">
				<c:if test="${sessionScope.loginok!=null }">
					<button type="button" class="btn btn-default" style="width: 80px;" onclick="location.href='form'">글쓰기</button>
				</c:if>
				
				<button type="button" class="btn btn-outline-info" style="width: 80px;" onclick="location.href='list'">목록</button>
				
				<c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.myid }">
					<button type="button" class="btn btn-outline-warning" style="width: 80px;" onclick="location.href='updateform?num=${dto.num}&currentPage=${currentPage }'">수정</button>
					<button type="button" class="btn btn-outline-danger" style="width: 80px;" onclick="location.href='delete?num=${dto.num}&currentPage=${currentPage }'">삭제</button>
				</c:if>
				
			</td>
		</tr>
	</table>
</div>


<!-- 댓글 수정 The Modal -->
<div class="modal" id="myUpdateContentModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">댓글 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      	<input type="text" id="ucontent" class="from-control">
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="button" class="btn btn-success" data-bs-dismiss="modal" id="btnupdateok">수정</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

</body>
</html>