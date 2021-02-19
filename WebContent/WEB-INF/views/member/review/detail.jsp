<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/review.css">

<style>

</style>
</head>

<body>



	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<div class="container">
	
		<!-- ########## 상단 헤더 시작 -->
		<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
		<!-- ########## 상단 헤더 끝 -->
	
	
		<!-- 마이페이지 side bar -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		
		
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
		<section class="contentsection">
			<h3>독후감</h3>
			<div id="qbox">
			    <h5>독후감 독후감독후감 독후감독후감<span class="label label-danger">우수</span></h5>
			    <div id="qinfo">abcd1234 &verbar; 2021-02-10</div>
			    <div>독후감 독후감 독후감 독후감 독후감</div>
			</div>
			
			<div id="btn">
				<button type="button" class="btn btn-general" id="edit" onclick="location.href='/bookjuck/member/review/edit.do'">수정하기</button>
			    <button type="button" class="btn btn-general" id="del" onclick="location.href='/bookjuck/member/review/del.do'">삭제하기</button>
			    <button type="button" class="btn btn-general inline" id="back" onclick="location.href='/bookjuck/member/review/list.do'">뒤로가기</button>
			</div>
		</section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	

</body>

</html>