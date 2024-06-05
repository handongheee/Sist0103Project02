<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<!-- se2 폴더에서 js 파일 가져오기 -->
<script type="text/javascript" src="${root }/se2/js/HuskyEZCreator.js"
	charset="utf-8"></script>

<script type="text/javascript" src="${root }/se2/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js"
	charset="utf-8"></script>	
</head>
<body>
<form action="insert" method="post">
	<table style="width: 600px; margin-left: 100px;" class="table table-bordered">
	
	<!-- 스마트게시판 0605 -->
		<caption align="top"><b>상품등록</b></caption>
		<tr>
			<th class="table-light">상품명</th>
			<td colspan="3">
				<input type="text" name="sangpum" class="form-control" placeholder="상품명" required="required" style="width: 180px;">
			</td>
		</tr>
		
		<tr>
			<th class="table-light">색상</th>
			<td>
				<input type="color" name="color" class="form-control" value="#aeaeae" style="width: 120px;">
			</td>
			
			<th class="table-light">단가</th>
			<td>
				<input type="text" name="price" class="form-control" style="width: 120px;" placeholder="가격입력">
			</td>
		</tr>		
		
		<tr>
			<th class="table-light">입고일</th>
			<td colspan="4">
				<input type="date" name="ipgoday" class="form-control" value="2024-06-05" style="width: 180px;">
			</td>
		</tr>
	<!--  -->
		
		<tr>
			<td colspan="4">
				<textarea name="content" id="content"		
					required="required"			
					style="width: 100%;height: 300px;display: none;"></textarea>		
			
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button type="button" class="btn btn-success"
					style="width: 120px;"
					onclick="submitContents(this)">DB저장</button>
				
				<button type="button" class="btn btn-warning"
					style="width: 120px;"
					onclick="location.href='list'">목록</button>
			</td>
		</tr>
		
	</table>   
</form>

<!-- 스마트게시판에 대한 스크립트 코드 넣기 -->
<script type="text/javascript">
var oEditors = [];

nhn.husky.EZCreator.createInIFrame({

    oAppRef: oEditors,

    elPlaceHolder: "content",

    sSkinURI: "${root}/se2/SmartEditor2Skin.html",

    fCreator: "createSEditor2"

}); 

//‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.

function submitContents(elClickedObj) {

    // 에디터의 내용이 textarea에 적용된다.

    oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", [ ]);

 

    // 에디터의 내용에 대한 값 검증은 이곳에서

    // document.getElementById("textAreaContent").value를 이용해서 처리한다.
    try {
        elClickedObj.form.submit();
    } catch(e) { 

    }

}

// textArea에 이미지 첨부

function pasteHTML(filepath){
    var sHTML = '<img src="${root}/save/'+filepath+'">';
    oEditors.getById["content"].exec("PASTE_HTML", [sHTML]); 

}
</script>

</body>
</html>






















