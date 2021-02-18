<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
<link rel="stylesheet" href="/bookjuck/css/bestseller.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<style>
</style>

</head>
<body>
	<!-- -->
	<div class="container">
	
	<form id="searchform" method="GET" action="/bookjuck/member/book/searchview.do">
   	<select name="sk"> <!-- 검색키: search key  -->
   		<option value="">전체도서</option>
   		<option value="해외도서">해외도서</option>
   		<option value="국내도서">국내도서</option>
   		<option value="EBOOK">EBOOK</option>   	
   	</select>
   	<input type="text" name="sv" value="${sv}"><!-- 검색값: search value -->
   	<input type="submit" value="검색버튼">   
   </form>
   <script>
   		$("select[name=sk]").val("${sk}"); // 검색창내 검색어 입력 유지
   </script>
	
	
	<c:if test="${not empty sv}">
    <div>
    '${sv}'에 대한 ${sk} 검색결과 총 ${list.size()}권의 도서를 검색했습니다.
    </div>
     </c:if>
     <br>
		<c:forEach items="${list}" var="dto">
			<div class="bookbox9">
				<div class="bestrank5">
					<img src="../image/${dto.image}">
					<div class="bookname">
						<strong>${dto.title}</strong>
					</div> 
					<div class="bookinfo">${dto.author} | ${dto.publisher} | ${dto.pubdate}</div>
					<div class="bookcopy">${dto.copy}</div>
					<div class="price">가격: ${dto.price}원</div>
					<div>
						<input type="button" class="btn btn-default" value="바로결제">
					</div>
					<div>
						<input type="button" class="btn btn-danger" value="바로드림">
					</div>
					<div>
						<input type="button" class="btn btn-warning" value="장바구니 담기">
					</div>
				</div>
			</div>
		</c:forEach>		
	</div>

	<script>
		
	</script>

</body>
</html>












