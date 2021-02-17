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
<link rel="stylesheet" href="/bookjuck/css/notice.css">

<style>

</style>
</head>

<body>

	<!-- header ~ footer > 플로팅 메뉴(북적이, top)를 제외한 나머지 전부를 담는 컨테이너) -->
	<!-- ########## 컨테이너 시작 -->
	<div class="container">

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
	<!-- ########## 상단 헤더 끝 -->
	
	
	<!-- 섹션 메뉴 -->
	<!-- 공지사항 목록조회 -->
	<section class="mainsection">
		<h3 id="membertitle">공지사항</h3>
		<table class="table tbl-md noticetbl">
	        <tr>
	            <th class="col-md-2 cell1">번호</th>
	            <th class="col-md-6 cell2">제목</th>
	            <th class="col-md-2 cell3">작성일</th>
	        </tr>
	        <tr>
	            <td class="cell1">2</td>
	            <td class="cell2"><a href="/bookjuck/member/notice/detail.do">서점 비치도서 판매 이벤트 안내</a></td>
	            <td class="cell3">2021-02-05</td>
	        </tr>
	        <tr>
	            <td class="cell1">1</td>
	            <td class="cell2"><a href="#">폭설로 인한 남부지방 배송 지연 안내</a></td>
	            <td class="cell3">2021-02-03</td>
	        </tr>
	    </table>
	
		<ul class="pagination">
		    <li>
		    <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		    </a>
		    </li>
		    <li><a href="#">1</a></li>
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
	
	    <div id="btn">
	    	<button type="button" id="memberbtn" class="btn btn-general inline" onclick="location.href='/bookjuck/index.do'">뒤로가기</button>
	    </div>
	</section>


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->


	<!-- ########## 컨테이너 끝 -->
	</div>


	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>

	<script>
	
	</script>

</body>

</html>