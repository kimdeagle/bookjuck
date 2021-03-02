<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::EBook관리</title>

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
	
		<h4>E-Book관리</h4>
		
		<table class="table tblebookcount">
			<thead>
				<tr class="success">
					<th>전체 E-Book</th>
					<th>국내 E-Book</th>
					<th>해외 E-Book</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a href="/bookjuck/admin/book/ebooklist.do"><span class="label label-success">${wholeCnt}</span></a></td>
					<td><a href="/bookjuck/admin/book/ebooklist.do?seqLCategory=1"><span class="label label-success">${inCnt}</span></a></td>
					<td><a href="/bookjuck/admin/book/ebooklist.do?seqLCategory=2"><span class="label label-success">${exCnt}</span></a></td>

				</tr>
			</tbody>
		</table>
		
		<div class="listheader">
			<h5>
			<c:if test="${empty seqLCategory}">
				전체
			</c:if>
			<c:if test="${seqLCategory == 1}">
				국내
			</c:if>
			<c:if test="${seqLCategory == 2}">
				해외
			</c:if>
			E-Book 목록
			</h5>
			<c:if test="${empty seqLCategory}">
				<input type="button" class="btn btn-primary btn-lg" value="추가" onclick="location.href='/bookjuck/admin/book/ebookadd.do?page=${nowPage}';">
			</c:if>
			<c:if test="${not empty seqLCategory}">
				<input type="button" class="btn btn-primary btn-lg" value="추가" onclick="location.href='/bookjuck/admin/book/ebookadd.do?seqLCategory=${seqLCategory}&page=${nowPage}';">
			</c:if>
			
			<div style="clear:both;"></div>
		</div>
		<table class="table table-hover table-condensed tblebooklist">
			<thead>
				<tr>
					<th>도서명</th>
					<th>카테고리</th>
					<th>저자</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.title}</td>
					<td>${dto.lCategory} > ${dto.mCategory} > ${dto.sCategory}</td>
					<td>${dto.author}</td>
					<td>
						<c:if test="${empty seqLCategory}">
							<input type="button" class="btn btn-warning" value="상세" onclick="location.href='/bookjuck/admin/book/ebookview.do?seq=${dto.seq}&page=${nowPage}';">
							<input type="button" class="btn btn-success" value="수정" onclick="location.href='/bookjuck/admin/book/ebookedit.do?seq=${dto.seq}&page=${nowPage}';">						
						</c:if>
						<c:if test="${not empty seqLCategory}">
							<input type="button" class="btn btn-warning" value="상세" onclick="location.href='/bookjuck/admin/book/ebookview.do?seqLCategory=${seqLCategory}&page=${nowPage}&seq=${dto.seq}';">
							<input type="button" class="btn btn-success" value="수정" onclick="location.href='/bookjuck/admin/book/ebookedit.do?seqLCategory=${seqLCategory}&page=${nowPage}&seq=${dto.seq}';">						
						</c:if>
						<button type="button" class="btn btn-danger btnDel" value="${dto.seq}">삭제</button>
						
					</td>
				</tr>
				</c:forEach>
			</tbody>
			
		</table>

		<!-- paging -->
		<c:if test="${not empty list}">
		<nav class="pagebar">
			<ul class="pagination">${pagebar}
			</ul>
		</nav>
		</c:if>
		
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
	
		var seq;
		
		//도서 리스트 -> 삭제 버튼 클릭
		$(".btnDel").click(function() {
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