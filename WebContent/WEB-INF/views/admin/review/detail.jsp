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
<link rel="stylesheet" href="/bookjuck/css/review.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<!-- 주요내용! 여기에 작성한 코드 넣을 것! -->
	<section class="contentsection">
		<h3>독후감</h3>
		<div id="qbox">
		    <h5>독후감 독후감독후감 독후감독후감<span class="label label-danger">우수</span></h5>
		    <div id="qinfo">abcd1234 &verbar; 2021-02-10</div>
		    <div>독후감 독후감 독후감 독후감 독후감</div>
		</div>
		
		<div id="btn">
		    <input type="button" class="btn btn-general" value="삭제하기" id="edit">
		    <input type="button" class="btn btn-general inline" value="우수독후감 선정하기" id="prize">
		    <button type="button" class="btn btn-general inline" id="back" onclick="location.href='/bookjuck/admin/review/list.do'">뒤로가기</button>
		</div>
	</section>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>



</body>

</html>