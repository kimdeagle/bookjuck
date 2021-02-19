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

<script src="/bookjuck/js/adminbookadd.js"></script>

<style>
	
</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<div class="contentsection">
	
		<h4>도서관리 > 추가</h4>
		
		<form>
			<div class="form-group">
		    	<label for="title">도서명</label>
		    	<input type="text" class="form-control" id="title" placeholder="도서명을 입력해주세요." maxlength=20>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="publisher">출판사</label>
		    	<input type="text" class="form-control" id="publisher" placeholder="출판사를 입력해주세요." maxlength=20>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label>카테고리</label>
		    	<div class="form-inline">
			    	<input type="button" class="btn btn-success" id="btnselcategory" value="카테고리 선택" data-toggle="modal" data-target="#categorymodal">
			    	<input type="text" class="form-control category" id="firstcategory" placeholder="1차 카테고리" readonly>
			    	&gt;
			    	<input type="text" class="form-control category" id="secondcategory" placeholder="2차 카테고리" readonly>
			    	&gt;
			    	<input type="text" class="form-control category" id="thirdcategory" placeholder="3차 카테고리" readonly>
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
		    	<input type="text" class="form-control" id="authorname" placeholder="작가명을 입력해주세요." maxlength=20 readonly>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="authorintro">작가 소개</label>
		    	<textarea class="form-control" id="authorintro" placeholder="작가소개를 입력해주세요." rows="5" readonly></textarea>
		  	</div>

			<div class="form-group">
		    	<label for="pubdate">출간일</label>
		    	<input type="date" class="form-control" id="pubdate">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="isbn">ISBN</label>
		    	<input type="text" class="form-control" id="isbn" placeholder="ISBN을 입력해주세요." maxlength=13>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="price">정가</label>
		    	<input type="text" class="form-control" id="price" placeholder="정가를 입력해주세요.">
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="amount">수량</label>
		    	<input type="number" class="form-control" id="amount" min="0" max="100" value="0">
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="page">페이지 수</label>
		    	<input type="number" class="form-control" id="page" min="0" value="0">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="copy">한줄카피</label>
		    	<input type="text" class="form-control" id="copy" placeholder="한줄카피를 입력해주세요." maxlength=50>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="bookintro">도서 소개</label>
		    	<textarea class="form-control" id="bookintro" placeholder="도서소개를 입력해주세요." rows="10"></textarea>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="index">목차</label>
		    	<textarea class="form-control" id="index" placeholder="목차를 입력해주세요." rows="10"></textarea>
		  	</div>
		  	
		  	<div class="form-group">
		  		<label style="display: block;">이미지</label>
		  		<label for="image" class="btn btn-info">이미지 선택</label>
		  		<input type="file" id="image" style="display: none;">
		  		<input type="text" class="form-control" id="imagename" value="파일 선택" readonly>
		  		<p class="help-block">※하나의 이미지만 등록 가능합니다.</p>
		  	</div>
		  	
		  	<div class="form-group actionbtns">
			  	<input type="submit" class="btn btn-primary" id="btnadd" value="추가">
			  	<input type="button" class="btn btn-default" id="btncancel" value="취소">
		  	</div>
		  	
	  	</form>
	  	
	  	
	  	<!-- 카테고리 선택 버튼 클릭 > 모달 -->
		<div class="modal fade" id="categorymodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			    <div class="modal-content">
					<div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">카테고리 선택</h4>
					</div>
					<div class="modal-body">
						<table class="table tblcategory">
							<thead>
								<tr>
									<th>1차 카테고리</th>
									<th>2차 카테고리</th>
									<th>3차 카테고리</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<select class="form-control" id="selfirstcategory">
											<option>선택</option>
											<option>국내도서</option>
											<option>해외도서</option>
										</select>
									</td>
									<td>
										<select class="form-control" id="selsecondcategory">
											<option>선택</option>
											<option>소설</option>
											<option>시/에세이</option>
											<option>만화</option>
										</select>
									</td>
									<td>
										<select class="form-control" id="selthirdcategory">
											<option>선택</option>
											<option>국내소설</option>
											<option>해외소설</option>
										</select>
									</td>
								</tr>
							</tbody>
							
						</table>
					</div>
					<div class="modal-footer">
				        <button type="button" class="btn btn-primary" onclick=selcategory();>선택완료</button>
				        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
		
		
	  	<!-- 작가 검색 버튼 클릭 > 모달 -->
		<div class="modal fade" id="authormodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
			    <div class="modal-content">
					<div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">작가 검색</h4>
					</div>
					<div class="modal-body">
					
						<input type="text" class="form-control" id="searchauthor" placeholder="작가명을 입력하세요.">
						<input type="button" class="btn btn-default" id="btnsearchauthor" value="검색">
						
						<table class="table table-hover" id="tblauthorlist">
							<thead>
								<tr>
									<th>선택</th>
									<th>작가명</th>
									<th>작가 소개</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<input type="radio" name="authorlist">
									</td>
									<td>김소월</td>
									<td>유명한 시인이시다...</td>
								</tr>
								<tr>
									<td>
										<input type="radio" name="authorlist">
									</td>
									<td>덤블도어</td>
									<td>유명한 마법사이시다...</td>
								</tr>
							</tbody>
							
						</table>
					</div>
					<div class="modal-footer">
				        <button type="button" class="btn btn-primary" onclick=selauthor();>선택완료</button>
				        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
		
	
	</div>
	
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