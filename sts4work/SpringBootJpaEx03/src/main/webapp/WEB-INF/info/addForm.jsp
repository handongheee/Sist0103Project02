<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>addForm</title>
</head>
<body>
<div style="margin:100px 100px; width: 500px;">
		<form action="insert" method="post">	
			<table class="table table-bordered">
				<caption align="top"><b>학생정보</b></caption>
				<tr>
					<th>학생명</th>
					<td>
						<input type="text" name="stuname" class="form-control" style="width:150px;" required="required">
					</td>
				</tr>
				
				<tr>
					<th>연락처</th>
					<td>
						<input type="text" name="stuhp" class="form-control" style="width:150px;" required="required">
					</td>
				</tr>
				
				<tr>
					<th>주소</th>
					<td>
						<input type="text" name="stuaddr" class="form-control" style="width:150px;" required="required">
					</td>
				</tr>
				
				<tr>
					<th>사진 등록</th>
					<td>
						<select name="stuphoto">
							<option value="10.jpg" selected="selected">이미지10</option>
							<option value="11.jpg">이미지11</option>
							<option value="12.jpg">이미지12</option>
							<option value="8.jpg">이미지8</option>
							<option value="14.jpg">이미지14</option>
							<option value="15.jpg">이미지15</option>
							<option value="16.jpg">이미지16</option>
							<option value="17.jpg">이미지17</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"> 
						<input type="submit" class="btn btn-success" value="저장">
						<input type="button" class="btn btn-info" value="목록" onclick="location.href='list'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>