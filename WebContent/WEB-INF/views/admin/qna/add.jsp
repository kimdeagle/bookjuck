<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/notice.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/qna.css">

<style>

</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>
	
	
		<section class="contentsection">
            <h3>QnA</h3>

            <div id="subtitle">답변 작성하기</div>
            <form method="POST" action="/member/qna/addaok.do">
	            <div id="answerbox">
		            <textarea id="content" name="content" class="form-control" cols="40" rows="13" placeholder="내용을 입력해주세요"></textarea>
	            </div>
	            <div id="btn">
	                <input type="button" class="btn btn-general inline" value="저장하기" id="save">
	                <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/admin/qna/list.do'">뒤로가기</button>
	            </div>
            </form>
    	</section>
	
		<!-- 플로팅 메뉴 -->
		<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
		<%@include file="/WEB-INF/views/common/top.jsp" %>
		
		
		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->

	</div>

</body>

</html>