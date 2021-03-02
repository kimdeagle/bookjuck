<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::EBook상세</title>

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
	
		<h4>E-Book관리 > 상세</h4>
		
			<div class="form-group">
		    	<label for="title">도서명</label>
		    	<input type="text" class="form-control" id="title" name="title" placeholder="도서명을 입력해주세요." maxlength=50 readonly value="${dto.title}">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="publisher">출판사</label>
		    	<input type="text" class="form-control" id="publisher" name="publisher" placeholder="출판사를 입력해주세요." maxlength=20 readonly value="${dto.publisher}">
		  	</div>
		  	
		  	<div class="form-group">
		    	<label>카테고리</label>
					<div class="form-inline">
						<input type="text" class="form-control category" id="firstcategory" placeholder="1차 카테고리" readonly value="${dto.lCategory}">
						&gt; 
						<input type="text" class="form-control category" id="secondcategory" placeholder="2차 카테고리" readonly value="${dto.mCategory}"> 
						&gt;
						<input type="text" class="form-control category" id="thirdcategory" placeholder="3차 카테고리" readonly value="${dto.sCategory}">
							
					</div>
			</div>
		  	
			<div class="form-group">
		    	<label for="authorname">작가명</label>
		    	<input type="text" class="form-control" id="authorname" name="author" placeholder="작가명을 입력해주세요." maxlength=20 readonly value="${dto.author}">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="authorintro">작가 소개</label>
		    	<textarea class="form-control" id="authorintro" name="authorIntro" placeholder="작가소개를 입력해주세요." rows="10" maxlength=1500 readonly>${dto.authorIntro}</textarea>
		  	</div>

			<div class="form-group">
		    	<label for="pubdate">출간일</label>
		    	<input type="date" class="form-control" id="pubdate" name="pubDate" readonly value="${dto.pubDate}">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="isbn">ISBN</label>
		    	<input type="text" class="form-control" id="isbn" name="isbn" placeholder="ISBN을 입력해주세요." maxlength=13 readonly value="${dto.isbn}">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="price">정가 (단위 : 원)</label>
		    	<input type="text" class="form-control" id="price" name="price" value="0" readonly value="${dto.price}">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="copy">한줄카피</label>
		    	<input type="text" class="form-control" id="copy" name="copy" placeholder="한줄카피를 입력해주세요." maxlength=50 readonly value="${dto.copy}">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="bookintro">도서 소개</label>
		    	<textarea class="form-control" id="bookintro" name="intro" placeholder="도서소개를 입력해주세요." rows="10" maxlength=1500 readonly>${dto.intro}</textarea>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="index">목차</label>
		    	<textarea class="form-control" id="index" name="contents" placeholder="목차를 입력해주세요." rows="10" maxlength=1500 readonly>${dto.contents}</textarea>
		  	</div>
		  	
		  	<div class="form-group">
		  		<label style="display: block;">이미지</label>
		  		<input type="text" class="form-control" id="imagename" placeholder="파일 선택" readonly value="${dto.image}">
		  		<input type="button" class="btn btn-warning" value="미리보기" id="btnpreviewimage">
		  	</div>
		  	
		  	<div class="form-group">
		  		<label style="display: block;">E-Book</label>
		  		<input type="text" class="form-control" id="ebookname" placeholder="파일 선택" readonly value="${dto.eFile}">
		  		<input type="button" class="btn btn-warning" value="미리보기" id="btnpreviewebook">
		  	</div>
		  	
		  	<div class="form-group actionbtns">
		  		<c:if test="${empty seqLCategory}">
				  	<input type="button" class="btn btn-success" id="btneditpage" value="수정" onclick="location.href='/bookjuck/admin/book/ebookedit.do?page=${page}&seq=${dto.seq}';">
				  	<button type="button" class="btn btn-danger" id="btndel" value="${dto.seq}">삭제</button>
				  	<input type="button" class="btn btn-default" id="btnlist" value="목록" onclick="location.href='/bookjuck/admin/book/ebooklist.do?page=${page}';">
		  		</c:if>
		  		<c:if test="${not empty seqLCategory}">
				  	<input type="button" class="btn btn-success" id="btneditpage" value="수정" onclick="location.href='/bookjuck/admin/book/ebookedit.do?seqLCategory=${seqLCategory}&page=${page}&seq=${dto.seq}';">
				  	<button type="button" class="btn btn-danger" id="btndel" value="${dto.seq}">삭제</button>
				  	<input type="button" class="btn btn-default" id="btnlist" value="목록" onclick="location.href='/bookjuck/admin/book/ebooklist.do?seqLCategory=${seqLCategory}&page=${page}';">
		  		</c:if>
		  	</div>
		
		<!-- 이미지 미리보기 클릭 > 모달 -->
		<div class="modal fade" id="previewimagemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			    <div class="modal-content">
					<div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">미리보기</h4>
					</div>
					<div class="modal-body" style="text-align: center;">
					
						<img src="/bookjuck/image/book/${dto.image}" id="previmg" style="width: 300px;">
						
					</div>
					<div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- E-Book 미리보기 클릭 > 모달 -->
		<div class="modal fade" id="previewebookmodal" tabindex="-1" role="dialog" aria-labelledby="previewEBookLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
			    <div class="modal-content">
					<div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="previewEBookLabel">미리보기</h4>
					</div>
					<div class="modal-body" style="text-align: center;">
						<iframe src="/bookjuck/file/ebook/${dto.eFile}" width="100%" height="600" id="prevebook"></iframe>
					</div>
					<div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 삭제 클릭 > 모달 -->
		<div class="modal fade" id="deletemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			    <div class="modal-content">
					<div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">삭제하시겠습니까?</h4>
					</div>
					<div class="modal-body" style="text-align: center;">
					
						<button type="button" class="btn btn-danger" id="delok">예</button>
				        <button type="button" class="btn btn-default" data-dismiss="modal">아니오</button>
						
					</div>
				</div>
			</div>
		</div>			
		
	
	</section>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<script>
	
	/* 이미지 미리보기 모달 열기 */
	$("#btnpreviewimage").click(function() {

		//파일을 선택하지 않은 경우
		if ($("#previmg").attr("src") == null) {
			alert("파일을 선택해주세요.");
			return;
		}
		
		//이미지가 아니면
		if (!($("#imagename").val().toLowerCase().endsWith("jpg") || $("#imagename").val().toLowerCase().endsWith("gif") || $("#imagename").val().toLowerCase().endsWith("png"))) {
			alert("이미지 파일을 선택해주세요.");
			return;
		}
		
		$("#previewimagemodal").modal('show');	
	});
	
	//이미지 미리보기
	$('#image').change(function() {
	    setImageFromFile(this, '#previmg');
	});

	function setImageFromFile(input, expression) {
	    if (input.files && input.files[0]) {
	        var imgreader = new FileReader();
	        imgreader.onload = function (e) {
	            $(expression).attr('src', e.target.result);
	        }
	        imgreader.readAsDataURL(input.files[0]);
	    }
	}
	
	
	//E-Book 미리보기 모달 열기
	$("#btnpreviewebook").click(function() {
		
		//파일을 선택하지 않은 경우
		if ($("#prevebook").attr("src") == null) {
			alert("파일을 선택해주세요.");
			return;
		}
		
		//pdf가 아니면
		if (!($("#ebookname").val().toLowerCase().endsWith("pdf"))) {
			alert("PDF 파일을 선택해주세요.");
			return;
		}		
		
		$("#previewebookmodal").modal('show');
	});

	//PDF 미리보기
	$('#ebook').change(function() {
	    setPdfFromFile(this, '#prevebook');
	});

	function setPdfFromFile(input, expression) {
	    if (input.files && input.files[0]) {
	        var pdfreader = new FileReader();
	        pdfreader.onload = function (e) {
	            $(expression).attr('src', e.target.result);
	        }
	        pdfreader.readAsDataURL(input.files[0]);
	    }
	}
	
	var seq;
	
	//상세 -> 삭제 버튼 클릭
	$("#btndel").click(function() {
		seq = $(this).val();
		$("#deletemodal").modal('show');
		
	});
	
	//삭제 모달 -> 삭제 버튼 클릭
	$("#delok").click(function() {
		location.href = "/bookjuck/admin/book/ebookdelok.do?seq=" + seq;
	});		
		
	</script>

</body>

</html>