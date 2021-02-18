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

	label[for=publisher] {
		margin-left: 30px;
	}
	
	#title {
		width: 300px;
		margin-left: 10px;
	}
	
	#publisher {
		width: 250px;
		margin-left: 10px;
	}
	
	#category {
		margin-left: 10px;
	}
</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<div class="contentsection">
	
		<h4>도서관리 > 추가</h4>
		
		<form>
			<div class="form-group form-inline">
		    	<label for="title">도서명</label>
		    	<input type="text" class="form-control" id="title" placeholder="도서명을 입력해주세요." maxlength=20>
		    	<label for="publisher">출판사</label>
		    	<input type="text" class="form-control" id="publisher" placeholder="출판사를 입력해주세요." maxlength=20>
		  	</div>
		  	
		  	<div class="form-inline">
		    	<label>카테고리</label>
		    	<input type="button" class="btn btn-success" id="category" value="카테고리 선택">
		    	<input type="text" class="form-control" placeholder="1차 카테고리" readonly>
		    	&gt;
		    	<input type="text" class="form-control" placeholder="2차 카테고리" readonly>
		    	&gt;
		    	<input type="text" class="form-control" placeholder="3차 카테고리" readonly>	
		  	</div>
	  	</form>
		  	

		

		
	
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