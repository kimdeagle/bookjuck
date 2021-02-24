<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::Welcome</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/global.css">

<!-- sidemenu.css -->
<link rel="stylesheet" href="/bookjuck/css/category.css">

<!-- booklist.css -->
<link rel="stylesheet" href="/bookjuck/css/booklist.css">

<!-- booklist.js -->
<script src="/bookjuck/js/booklist.js"></script>

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- ########## 상단 헤더 시작 -->
	<!-- 변경 전 -->
	<%-- <%@include file="/WEB-INF/views/member/inc/header.jsp" %> --%>

	<!-- 변경 후 -->
	<%
		out.flush();
		RequestDispatcher dheader = request.getRequestDispatcher("/member/inc/header.do");
		dheader.include(request, response);
	%>
	<!-- ########## 상단 헤더 끝 -->
	
	
	<!-- ########## 카테고리 사이드 메뉴 시작 -->
   	<%
		out.flush();
		RequestDispatcher dcategory = request.getRequestDispatcher("/member/inc/category.do");
		dcategory.include(request, response);
	%>
	<!-- ########## 카테고리 사이드 메뉴 끝 -->
	
	
	<!-- 섹션 -->
	<section class="contentsection">
		<table class="table">
			<thead>
				<c:if test="${not empty seqSCategory}">
				<tr>
					<th colspan="3"><h6>${lCategory} > ${mCategory} > ${sCategory}</h6></th>
				</tr>
				</c:if>
				
				<c:if test="${empty seqSCategory}">
				<tr>
					<th colspan="3"><h6>${lCategory} > ${mCategory}</h6></th>
				</tr>
				</c:if>
				
			</thead>
			<tbody>
				<c:if test="${blist.size() == 0}">
					<tr>
						<td colspan="3" style="text-align: center; padding-top: 50px;"><b style="font-size: 1.5em;">도서 목록이 없습니다.</b></td>
					</tr>
				</c:if>
			
				<c:forEach items="${blist}" var="dto">
				<tr>
					<td>
						<a href="/bookjuck/member/book/bookdetail.do?seqLCategory=${seqLCategory}&lCategory=${lCategory}&seqMCategory=${seqMCategory}&mCategory=${mCategory}&seqSCategory=${seqSCategory}&sCategory=${sCategory}&seq=${dto.seq}">
							<img src="/bookjuck/image/book/${dto.image}" class="image">
						</a>
					</td>
					<td>
						<div><a href="/bookjuck/member/book/bookdetail.do?seqLCategory=${seqLCategory}&lCategory=${lCategory}&seqMCategory=${seqMCategory}&mCategory=${mCategory}&seqSCategory=${seqSCategory}&sCategory=${sCategory}&seq=${dto.seq}" class="title">${dto.title}</a></div>
						<div class="info">${dto.author} | ${dto.publisher}</div>
						<div class="subinfo">${String.format('%s년 %s월 %s일', dto.pubDate.substring(0, 4), dto.pubDate.substring(5, 7), dto.pubDate.substring(8, 10))} | ${dto.page}쪽</div>
						<div class="intro">${dto.summary.substring(0, 100)}</div>
						<div class="priceinfo">
							<span class="price"><s>정가 ${String.format('%,d원', dto.price)}</s></span>
							<span class="saleprice">판매가 <strong>${String.format('%,d', dto.salePrice)}</strong>원</span>
						</div>
					</td>
					<td>
						<div class="form-inline amount">
							<input type="button" value="-" class="minus btn btn-default btn-sm">
							<input type="text" value="1" class="cnt form-control">
							<input type="button" value="+" class="plus btn btn-default btn-sm">
						</div>
						<div class="btns">
							<button class="btn btn-success btn-lg btn-block cart">장바구니</button>
							<button class="btn btn-primary btn-lg btn-block buy">바로구매</button>
							<button class="btn btn-warning btn-lg btn-block baro">바로드림</button>
						</div>
					</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
		
		<!-- paging -->
		<c:if test="${not empty blist}">
		<nav class="pagebar">
			<ul class="pagination">${pagebar}
			</ul>
		</nav>
		</c:if>

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