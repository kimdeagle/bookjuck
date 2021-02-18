<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>


<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel= "stylesheet" href="/bookjuck/css/adminbook.css">

<style>
	
</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<div class="contentsection">
	
		<h4>도서관리</h4>
		
		<div class="bg-success count">전체 도서 수 : <a href="/bookjuck/admin/book/list.do" class="text-primary">2315</a></div>
		<div class="bg-success count">국내 도서 수 : <a href="/bookjuck/admin/book/list.do" class="text-primary">1315</a></div>
		<div class="bg-success count">해외 도서 수 : <a href="/bookjuck/admin/book/list.do" class="text-primary">1000</a></div>
		
		<div class="listheader">
			<h5>전체 도서 목록</h5>
			<input type="button" class="btn btn-primary btn-lg" value="도서추가" onclick="location.href='/bookjuck/admin/book/add.do'">
			<div style="clear:both;"></div>
		</div>
		<table class="table table-hover table-condensed">
			<thead>
				<tr>
					<th>도서명</th>
					<th>카테고리</th>
					<th>저자</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>해리포터와 불의 잔 1</td>
					<td>국내도서-소설-외국소설</td>
					<td>J.K.Rowling</td>
					<td>
						<input type="button" class="btn btn-warning" value="상세">
						<input type="button" class="btn btn-success" value="수정">
						<input type="button" class="btn btn-danger" value="삭제">
					</td>
				</tr>
				<tr>
					<td>해리포터와 불의 잔 2</td>
					<td>국내도서-소설-외국소설</td>
					<td>J.K.Rowling</td>
					<td>
						<input type="button" class="btn btn-warning" value="상세">
						<input type="button" class="btn btn-success" value="수정">
						<input type="button" class="btn btn-danger" value="삭제">
					</td>
				</tr>
			</tbody>
			
		</table>

		
	
	</div>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>



</body>

</html>