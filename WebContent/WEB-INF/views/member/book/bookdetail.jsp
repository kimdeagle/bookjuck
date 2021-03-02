<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::${dto.title}</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/global.css">

<!-- sidemenu.css -->
<link rel="stylesheet" href="/bookjuck/css/category.css">

<!-- bookdetail.css -->
<link rel="stylesheet" href="/bookjuck/css/bookdetail.css">

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
				<tr>
					<th colspan="3"><h6>${dto.lCategory} > ${dto.mCategory} > ${dto.sCategory}</h6></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<img src="/bookjuck/image/book/${dto.image}" class="image">
					</td>
					<td>
						<div class="title">${dto.title}</div>
						<div class="copy">${dto.copy}</div>
						<div class="info">${dto.author} | ${dto.publisher}</div>
						<div class="subinfo">${dto.pubDate} | ${dto.page}쪽</div>
						<div class="readtime">완독 예상 시간 : <fmt:parseNumber integerOnly="true" value="${dto.page * 2 / 60}" />시간 ${dto.page * 2 % 60}분</div>
						<div class="readtimeinfo" style="font-size: 0.8em;">(완독 예상 시간은 소개, 목차 등 전체 페이지를 기준으로 측정된 시간이며, 실제 완독 시간과 오차가 있을 수 있습니다.)</div>
						<div class="priceinfo">
							<span class="price"><s>정가 ${String.format('%,d원', dto.price)}</s></span>
							<span class="saleprice">판매가 <strong>${String.format('%,d', dto.salePrice)}</strong>원</span>
							<fmt:parseNumber var="salePrice" value="${dto.salePrice / 20}" integerOnly="true" />
							<span class="savepoint">(적립금 ${String.format('%,d원', salePrice)})</span>
						</div>
					</td>
					<td>
						<div class="form-inline amount">
							<input type="button" value="-" class="minus btn btn-default btn-sm">
							<input type="text" value="1" class="form-control">
							<input type="button" value="+" class="plus btn btn-default btn-sm">
						</div>
						<div class="btns">
							<button class="btn btn-success btn-lg btn-block cart" onclick="">장바구니</button>
							<button class="btn btn-primary btn-lg btn-block buy">바로구매</button>
							<button class="btn btn-warning btn-lg btn-block baro">바로드림</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<h5>도서 소개</h5>
						<div class="intro">
							<p>
								
								<c:if test="${dto.summary.indexOf('<br><br>') > -1}">
									<b>${dto.summary.substring(0, dto.summary.indexOf("<br><br>"))}</b>
									${dto.summary.substring(dto.summary.indexOf("<br><br>"))}
								</c:if>
								
								<c:if test="${dto.summary.indexOf('<br><br>') == -1}">
									${dto.summary}
								</c:if>
								
							</p>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<h5>목차</h5>
						<div class="index">
							<p>${dto.contents}</p>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<h5>작가 소개</h5>
						<blockquote>
							<mark>${dto.author}</mark>
							<p>${dto.authorIntro}</p>
						</blockquote>
					</td>
				</tr>
			</tbody>
		</table>
       
	</section>


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<script>
	
	// 수경
	
	

	
	
	</script>

</body>

</html>