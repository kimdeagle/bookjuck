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

	<section class="contentsection">
	
		<h4>도서관리</h4>
		
		<table class="table tblbookcount">
			<thead>
				<tr class="success">
					<th>전체 도서</th>
					<th>국내 도서</th>
					<th>해외 도서</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a href="/bookjuck/admin/book/list.do"><span class="label label-success">2315</span></a></td>
					<td><a href="/bookjuck/admin/book/list.do"><span class="label label-success">1315</span></a></td>
					<td><a href="/bookjuck/admin/book/list.do"><span class="label label-success">1000</span></a></td>

				</tr>
			</tbody>
		</table>
		
		<div class="listheader">
			<h5>전체 도서 목록</h5>
			<input type="button" class="btn btn-primary btn-lg" value="도서추가" onclick="location.href='/bookjuck/admin/book/add.do';">
			<div style="clear:both;"></div>
		</div>
		<table class="table table-hover table-condensed tblbooklist">
			<thead>
				<tr>
					<th>도서명</th>
					<th>카테고리</th>
					<th>저자</th>
					<th>수량</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>해리포터와 불의 잔 1</td>
					<td>국내도서-소설-외국소설</td>
					<td>J.K.Rowling</td>
					<td>2</td>
					<td>
						<input type="button" class="btn btn-warning" value="상세" onclick="location.href='/bookjuck/admin/book/view.do';">
						<input type="button" class="btn btn-success" value="수정" onclick="location.href='/bookjuck/admin/book/edit.do';">
						<input type="button" class="btn btn-danger" value="삭제" data-toggle="modal" data-target="#deletemodal">
					</td>
				</tr>
				<tr>
					<td>해리포터와 불의 잔 2</td>
					<td>국내도서-소설-외국소설</td>
					<td>J.K.Rowling</td>
					<td>10</td>
					<td>
						<input type="button" class="btn btn-warning" value="상세">
						<input type="button" class="btn btn-success" value="수정">
						<input type="button" class="btn btn-danger" value="삭제">
					</td>
				</tr>
			</tbody>
			
		</table>

		<!-- paging -->
		<nav>
		  <ul class="pagination">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li class="active"><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">5</a></li>
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
		
	  	<!-- modal -->
		<%@include file="/WEB-INF/views/admin/book/bookmodal.jsp" %>
	
	</section>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>



</body>

</html>