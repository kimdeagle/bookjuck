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

<script src="/bookjuck/js/adminbook.js"></script>

<style>
	
</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<section class="contentsection">
	
		<h4>E-Book관리 > 수정</h4>
		
		<form>
			<div class="form-group">
		    	<label for="title">도서명</label>
		    	<input type="text" class="form-control" id="title" placeholder="도서명을 입력해주세요." maxlength=50  required value="해리포터와 불의 잔 1">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="publisher">출판사</label>
		    	<input type="text" class="form-control" id="publisher" placeholder="출판사를 입력해주세요." maxlength=20  required value="호그와트">
		  	</div>
		  	
		  	<div class="form-group">
		    	<label>카테고리</label>
		    	<div class="form-inline">
			    	<input type="button" class="btn btn-success" id="btnselcategory" value="카테고리 선택" data-toggle="modal" data-target="#categorymodal">
			    	<input type="text" class="form-control category" id="firstcategory" placeholder="1차 카테고리" value="국내도서" readonly>
			    	&gt;
			    	<input type="text" class="form-control category" id="secondcategory" placeholder="2차 카테고리" value="소설" readonly>
			    	&gt;
			    	<input type="text" class="form-control category" id="thirdcategory" placeholder="3차 카테고리" value="외국소설" readonly>
		    	</div>	
		  	</div>
		  	
			<div class="form-group">
		    	<label>작가</label>
		    	<div class="form-inline">
			    	<input type="button" class="btn btn-success" id="btnsearchauthor" value="작가 검색하기" data-toggle="modal" data-target="#authormodal">
			    	<input type="button" class="btn btn-info" id="btnaddauthor" value="새로 추가하기">
		    	</div>	
				
		  	</div>
		  	
			<div class="form-group">
		    	<label for="authorname">작가명</label>
		    	<input type="text" class="form-control" id="authorname" placeholder="작가명을 입력해주세요." maxlength=20 value="덤블도어" readonly>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="authorintro">작가 소개</label>
		    	<textarea class="form-control" id="authorintro" placeholder="작가소개를 입력해주세요." rows="5" readonly>유명한 마법사이시다...</textarea>
		  	</div>

			<div class="form-group">
		    	<label for="pubdate">출간일</label>
		    	<input type="date" class="form-control" id="pubdate" required value="2021-02-07">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="isbn">ISBN</label>
		    	<input type="text" class="form-control" id="isbn" placeholder="ISBN을 입력해주세요." maxlength=13 required value="1234561234567">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="price">정가</label>
		    	<input type="text" class="form-control" id="price" value="20000" required>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="page">페이지 수</label>
		    	<input type="number" class="form-control" id="page" min="0" value="200" required>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="copy">한줄카피</label>
		    	<input type="text" class="form-control" id="copy" placeholder="한줄카피를 입력해주세요." maxlength=50 required value="해리포터는 과연 불의 잔에 쪽지를 넣었을까?">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="bookintro">도서 소개</label>
		    	<textarea class="form-control" id="bookintro" placeholder="도서소개를 입력해주세요." rows="10" required>해리포터 시리즈 중 5번째인 '해리포터와 불의 잔' 1부.
해리포터는 자신이 불의 잔에 쪽지를 넣지 않았지만 어떤 이유로 자신의 이름이 적힌 쪽지가 불의 잔에 들어갔는지 모른다.</textarea>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="index">목차</label>
		    	<textarea class="form-control" id="index" placeholder="목차를 입력해주세요." rows="10" required>1. 소개
2. 누가 쪽지를 넣었을까?
3. 어둠을 먹는자
4. 포트키를 집어선 안 돼!</textarea>
		  	</div>
		  	
		  	<div class="form-group">
		  		<label style="display: block;">이미지</label>
		  		<label for="image" class="btn btn-info">이미지 선택</label>
		  		<input type="file" id="image" style="display: none;">
		  		<input type="text" class="form-control" id="imagename" placeholder="파일 선택" readonly value="해리포터와 혼혈 왕자 1.png">
		  		<input type="button" class="btn btn-warning" value="미리보기" data-toggle="modal" data-target="#previewimagemodal">
		  		<p class="help-block">※하나의 이미지만 등록 가능합니다.</p>
		  	</div>
		  	
		  	<div class="form-group">
		  		<label style="display: block;">E-Book</label>
		  		<label for="ebook" class="btn btn-info">E-Book 선택</label>
		  		<input type="file" id="ebook" style="display: none;">
		  		<input type="text" class="form-control" id="ebookname" placeholder="파일 선택" readonly value="test.pdf">
		  		<input type="button" class="btn btn-warning" value="미리보기" data-toggle="modal" data-target="#previewebookmodal">
		  		<p class="help-block">※하나의 E-Book 파일만 등록 가능합니다.</p>
		  	</div>
		  	
		  	<div class="form-group actionbtns">
			  	<input type="submit" class="btn btn-success" id="btnedit" value="수정">
			  	<input type="button" class="btn btn-default" id="btncancel" value="취소" onclick="location.href='/bookjuck/admin/book/ebooklist.do';">
		  	</div>
		  	
	  	</form>
	  	
	  	<!-- modal -->
		<%@include file="/WEB-INF/views/admin/book/bookmodal.jsp" %>
		
		
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