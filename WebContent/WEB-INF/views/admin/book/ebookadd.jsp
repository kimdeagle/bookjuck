<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::EBook추가</title>

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
	
		<h4>E-Book관리 > 추가</h4>
		
		<form method="POST" action="/bookjuck/admin/book/ebookaddok.do" enctype="multipart/form-data" id="formAdd">
			<div class="form-group">
		    	<label for="title">도서명</label>
		    	<input type="text" class="form-control" id="title" name="title" placeholder="도서명을 입력해주세요." maxlength=50 required>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="publisher">출판사</label>
		    	<input type="text" class="form-control" id="publisher" name="publisher" placeholder="출판사를 입력해주세요." maxlength=20 required>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label>카테고리</label>
					<div class="form-inline">
				    	<input type="button" class="btn btn-success" id="btnselcategory" value="카테고리 선택">
						<input type="text" class="form-control category" id="firstcategory" placeholder="1차 카테고리" readonly>
						&gt; 
						<input type="text" class="form-control category" id="secondcategory" placeholder="2차 카테고리" readonly> 
						&gt;
						<input type="text" class="form-control category" id="thirdcategory" placeholder="3차 카테고리" readonly>
						<input type="hidden" id="seqSCategory" name="seqSCategory">
							
					</div>
				</div>
		  	
			<div class="form-group">
		    	<label>작가</label>
		    	<div class="form-inline">
			    	<input type="button" class="btn btn-success" id="btnsearchauthor" value="작가 검색하기">
			    	<input type="button" class="btn btn-info" id="btnaddauthor" value="새로 추가하기">
		    	</div>	
				
		  	</div>
		  	
			<div class="form-group">
		    	<label for="authorname">작가명</label>
		    	<input type="text" class="form-control" id="authorname" name="author" placeholder="작가명을 입력해주세요." maxlength=20 readonly>
		    	<input type="hidden" id="seqAuthor" name="seqAuthor">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="authorintro">작가 소개</label>
		    	<textarea class="form-control" id="authorintro" name="authorIntro" placeholder="작가소개를 입력해주세요." rows="10" maxlength=1500 readonly></textarea>
		  	</div>

			<div class="form-group">
		    	<label for="pubdate">출간일</label>
		    	<input type="date" class="form-control" id="pubdate" name="pubDate" required>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="isbn">ISBN</label>
		    	<input type="text" class="form-control" id="isbn" name="isbn" placeholder="ISBN을 입력해주세요." maxlength=13 required>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="price">정가 (단위 : 원)</label>
		    	<input type="text" class="form-control" id="price" name="price" value="0" required>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="copy">한줄카피</label>
		    	<input type="text" class="form-control" id="copy" name="copy" placeholder="한줄카피를 입력해주세요." maxlength=50 required>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="bookintro">도서 소개</label>
		    	<textarea class="form-control" id="bookintro" name="intro" placeholder="도서소개를 입력해주세요." rows="10" maxlength=1500 required></textarea>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="index">목차</label>
		    	<textarea class="form-control" id="index" name="contents" placeholder="목차를 입력해주세요." rows="10" maxlength=1500 required></textarea>
		  	</div>
		  	
		  	<div class="form-group">
		  		<label style="display: block;">이미지</label>
		  		<label for="image" class="btn btn-info">이미지 선택</label>
		  		<input type="file" id="image" name="image" style="display: none;">
		  		<input type="text" class="form-control" id="imagename" placeholder="파일 선택" readonly>
		  		<input type="button" class="btn btn-warning" value="미리보기" id="btnpreviewimage">
		  		<p class="help-block">※하나의 이미지만 등록 가능합니다. (등록 가능한 이미지 확장자 : <mark>png</mark>, <mark>jpg</mark>, <mark>gif</mark>)</p>
		  	</div>
		  	
		  	<div class="form-group">
		  		<label style="display: block;">E-Book</label>
		  		<label for="ebook" class="btn btn-info">E-Book 선택</label>
		  		<input type="file" id="ebook" name="eFile" style="display: none;">
		  		<input type="text" class="form-control" id="ebookname" placeholder="파일 선택" readonly>
		  		<input type="button" class="btn btn-warning" value="미리보기" id="btnpreviewebook">
		  		<p class="help-block">※하나의 E-Book 파일만 등록 가능합니다. (등록 가능한 E-Book 확장자 : <mark>pdf</mark>)</p>
		  	</div>
		  	
		  	<div class="form-group actionbtns">
			  	<input type="button" class="btn btn-primary" id="btnEadd" value="추가">
			  	<c:if test="${empty seqLCategory}">
				  	<input type="button" class="btn btn-default" id="btncancel" value="취소" onclick="location.href='/bookjuck/admin/book/ebooklist.do?page=${page}';">			  	
			  	</c:if>
			  	<c:if test="${not empty seqLCategory}">
				  	<input type="button" class="btn btn-default" id="btncancel" value="취소" onclick="location.href='/bookjuck/admin/book/ebooklist.do?seqLCategory=${seqLCategory}&page=${page}';">			  	
			  	</c:if>
		  	</div>
		  	
	  	</form>
	  	
	  	
	  	<!-- modal -->
		<!-- 카테고리 선택 버튼 클릭 > 모달 -->
		<div class="modal fade" id="categorymodal" tabindex="-1" role="dialog" aria-labelledby="categoryLabel" aria-hidden="true">
			<div class="modal-dialog">
			    <div class="modal-content">
					<div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="categoryLabel">카테고리 선택</h4>
					</div>
					<div class="modal-body">
						<table class="table" id="tblcategory">
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
										</select>
									</td>
									<td>
										<select class="form-control" id="selsecondcategory">
											<option>선택</option>
										</select>
									</td>
									<td>
										<select class="form-control" id="selthirdcategory">
											<option>선택</option>
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
		<div class="modal fade" id="authormodal" tabindex="-1" role="dialog" aria-labelledby="authorLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
			    <div class="modal-content">
					<div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="authorLabel">작가 검색</h4>
					</div>
					<div class="modal-body">
					
						<div class="searchbar">
							<input type="text" class="form-control" id="searchauthorname" placeholder="작가명을 입력하세요.">
							<input type="button" class="btn btn-default" id="btnsearch" value="검색">
						</div>
						<table class="table table-hover" id="tblauthorlist">
							<thead>
								<tr>
									<th>선택</th>
									<th>작가명</th>
									<th>작가 소개</th>
								</tr>
							</thead>
							<tbody>

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
		
		<!-- 이미지 미리보기 클릭 > 모달 -->
		<div class="modal fade" id="previewimagemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			    <div class="modal-content">
					<div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">미리보기</h4>
					</div>
					<div class="modal-body" style="text-align: center;">
					
						<img id="previmg" style="width: 300px;">
						
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
						<iframe width="100%" height="600" id="prevebook"></iframe>
					</div>
					<div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
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
		
	/* 대분류 카테고리 표시 */
	<c:forEach items="${lCategoryList}" var="ldto">
		$("#selfirstcategory").append("<option>${ldto.lCategory}</option>");
	</c:forEach>

	/* 중분류 카테고리 표시 */
	$("#selfirstcategory").click(function() {
		$("#selsecondcategory").html("<option>선택</option>");
		$("#selthirdcategory").html("<option>선택</option>");
	<c:forEach items="${mCategoryList}" var="mdto">
		if ($("#selfirstcategory").val() == "${mdto.lCategory}") {
			$("#selsecondcategory").append("<option>${mdto.mCategory}</option>");
		}
	</c:forEach>
	});
	
	/* 소분류 카테고리 표시 */
	$("#selsecondcategory").click(function() {
		$("#selthirdcategory").html("<option>선택</option>");
	<c:forEach items="${sCategoryList}" var="sdto">
		if ($("#selsecondcategory").val() == "${sdto.mCategory}") {
			$("#selthirdcategory").append("<option>${sdto.sCategory}</option>");
			$("#selthirdcategory").append("<input type='hidden' value='${sdto.seqSCategory}' />");
		}
	</c:forEach>
	});
	
	/* 카테고리 모달 열기 */
	$("#btnselcategory").click(function() {
		$("#categorymodal").modal('show');
	});
	
	/* 카테고리 모달 > 카테고리 선택 버튼 클릭 */
	function selcategory() {
		
		if ($("#selthirdcategory").val() == "선택") {
			alert("카테고리를 선택해주세요.");
			return;
		}
		
		$("#firstcategory").val($("#selfirstcategory").val());
		$("#secondcategory").val($("#selsecondcategory").val());
		$("#thirdcategory").val($("#selthirdcategory").val());
		
		//소분류 카테고리 번호 넘기기
		<c:forEach items="${sCategoryList}" var="sdto">
			if ('${sdto.mCategory}' == ($("#selsecondcategory").val()) && '${sdto.sCategory}' == ($("#selthirdcategory").val())) {
				$("#seqSCategory").val(${sdto.seqSCategory});
			}
		</c:forEach>
		
		$("#categorymodal").modal("hide");
	}
	
	/* 작가검색 모달 열기 */
	$("#btnsearchauthor").click(function() {
		
		//작가 리스트 초기화
		$("#tblauthorlist tbody").html("");
		<c:forEach items="${alist}" var="adto" varStatus="status" begin="0" end="9">
			$("#tblauthorlist tbody").append("<tr><td><input type='radio' name='authorlist' id='authorlistname${status.index}'></td><td><label for='authorlistname${status.index}'>${adto.name}</label></td><td>${adto.intro}</td></tr>");
		</c:forEach>
		$("#tblauthorlist tbody").append("<tr><td colspan='3'>...</td></tr>");
		$("#authormodal").modal('show');
	});
	
	$("#searchauthorname").keyup(function() {
		if (event.keyCode == 13) {
			$("#btnsearch").click();
		}
	});
	
	// 작가선택 모달 > 작가 선택 버튼 클릭
	function selauthor() {
		
		$("#authorname").val($("#tblauthorlist input[type=radio]:checked").parent().next().text());
		$("#authorintro").val($("#tblauthorlist input[type=radio]:checked").parent().next().next().text());
		$("#authorname").attr("readonly", true);
		$("#authorintro").attr("readonly", true);
		
		//작가번호 넘기기
		<c:forEach items="${alist}" var="adto">
			if ('${adto.name}' == $("#authorname").val()) {
				$("#seqAuthor").val('${adto.seq}');
			}
		</c:forEach>
		
		$("#authormodal").modal("hide");
	}
	
	//검색 버튼 클릭
	$("#btnsearch").click(function() {
		
		if ($("#searchauthorname").val().trim() == "") {
			alert("검색어를 입력해주세요.");
			return;
		}
		
		$("#tblauthorlist tbody").html("");
		
		//검색 결과 넣기
		<c:forEach items="${alist}" var="adto" varStatus="status">

		
			if ('${adto.name.toLowerCase()}'.indexOf($("#searchauthorname").val().toLowerCase()) > -1) {
				$("#tblauthorlist tbody").append("<tr><td><input type='radio' name='authorlist' id='authorlistname${status.index}'></td><td><label for='authorlistname${status.index}'>${adto.name}</label></td><td>${adto.intro}</td></tr>");
			}
		
		</c:forEach>
		
		//검색 결과 없는 경우
		if ($("#tblauthorlist tbody").html() == "") {
			$("#tblauthorlist tbody").html("<tr><td colspan='3' style='text-align: center;'>검색 결과가 없습니다.</td></tr>");
		}		
		
	});
	
	
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
		
	</script>

</body>

</html>