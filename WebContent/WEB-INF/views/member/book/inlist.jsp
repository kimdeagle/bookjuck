<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::Welcome</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/global.css">

<!-- sidemenu.css -->
<link rel="stylesheet" href="/bookjuck/css/category.css">

<!-- inlist.css -->
<link rel="stylesheet" href="/bookjuck/css/inlist.css">

<!-- inlist.js -->
<script src="/bookjuck/js/inlist.js"></script>

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
	<!-- ########## 상단 헤더 끝 -->
	
	
	<!-- ########## 카테고리 사이드 메뉴 시작 -->
    <%@include file="/WEB-INF/views/member/inc/category.jsp" %>
	<!-- ########## 카테고리 사이드 메뉴 끝 -->
	
	
	<!-- 섹션 -->
	<section class="contentsection">
		<table class="table">
			<thead>
				<tr>
					<th colspan="3"><h6>국내도서 > 소설 > 한국소설</h6></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<a href="/bookjuck/member/book/bookdetail.do">
							<img src="/bookjuck/image/바이러스 X.png" class="image">
						</a>
					</td>
					<td>
						<div><a href="/bookjuck/member/book/bookdetail.do" class="title">대체불가 라틴아메리카</a></div>
						<div class="info">장재준 | 의미와재미</div>
						<div class="subinfo">2021년 1월 20일 | 292쪽</div>
						<div class="intro">다양성과 혼종성, 식민성과 근대성이 공존하는 곳.<br />잉카, 마야, 아스텍 문명을 품은 땅에서 이민족의 오랜 야만을 인내한 사람들.</div>
						<div class="priceinfo">
							<span class="price" id="price"><s>정가 17,000원</s></span>
							<span class="saleprice" id="saleprice">판매가 <strong>15,300</strong>원</span>
						</div>
					</td>
					<td>
						<div class="form-inline amount">
							<input type="button" value="-" class="btn btn-default btn-sm" id="minus">
							<input type="text" value="1" class="form-control" id="cnt">
							<input type="button" value="+" class="btn btn-default btn-sm" id="plus">
						</div>
						<div class="btns">
							<button class="btn btn-success btn-lg btn-block cart">장바구니</button>
							<button class="btn btn-primary btn-lg btn-block buy">바로구매</button>
							<button class="btn btn-warning btn-lg btn-block baro">바로드림</button>
						</div>
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
       
	</section>


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<script>

	</script>

</body>

</html>