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
<link rel="stylesheet" href="/bookjuck/css/ebookcategory.css">

<!-- ebookcategory.js -->
<script src="/bookjuck/js/ebookcategory.js"></script>

<!-- ebookdetail.css -->
<link rel="stylesheet" href="/bookjuck/css/ebookdetail.css">


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
		RequestDispatcher dcategory = request.getRequestDispatcher("/member/inc/ebookcategory.do");
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
						<div class="subinfo">${dto.pubDate}</div>
						<div class="efileinfo">E-Book 구매 안내 (<span class="text-danger">아래 내용을 꼭 읽어주세요!</span>)</div>
						<div class="readtimeinfo" style="font-size: 0.8em;">(E-Book의 경우 수량을 선택할 수 없으며, 미리보기는 제공하지 않습니다.<br>결제 완료 후 E-Book 읽기가 가능합니다.)</div>
						<div class="priceinfo">
							<span class="price" id="price"><s>정가 ${String.format('%,d원', dto.price)}</s></span>
							<span class="saleprice" id="saleprice">판매가 <strong>${String.format('%,d', dto.salePrice)}</strong>원</span>
							<fmt:parseNumber var="salePrice" value="${dto.salePrice / 20}" integerOnly="true" />
							<span class="savepoint">(적립금 ${String.format('%,d원', salePrice)})</span>
						</div>
					</td>
					<td>
						<div class="btns">
							<button class="btn btn-success btn-lg btn-block cart">장바구니</button>
							<button class="btn btn-primary btn-lg btn-block buy">바로구매</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<h5>도서 소개</h5>
						<div class="intro">
							<p>
							
								<c:if test="${dto.intro.indexOf('<br><br>') > -1}">
									<b>${dto.intro.substring(0, dto.intro.indexOf("<br><br>"))}</b>
									${dto.intro.substring(dto.intro.indexOf("<br><br>"))}
								</c:if>
								
								<c:if test="${dto.intro.indexOf('<br><br>') == -1}">
									${dto.intro}
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

	</script>

</body>

</html>