<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::Welcome</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/firstpage.css">


<!-- slick -->
<link rel="stylesheet" type="text/css" href="http://kenwheeler.github.io/slick/slick/slick.css" />
<link rel="stylesheet" type="text/css" href="http://kenwheeler.github.io/slick/slick/slick-theme.css" />
<script src="http://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g=" crossorigin="anonymous"></script>
<script type="text/javascript" src="http://kenwheeler.github.io/slick/slick/slick.min.js"></script>

<!-- 실검 slick -->

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
	
	
	<!-- 섹션 메뉴 -->
	<%@include file="/WEB-INF/views/member/inc/slick.jsp" %>
	
	<!-- 중단 추천도서, 베스트도서, 화제의신간  -->
	<%
		out.flush();
		RequestDispatcher dmainbook = request.getRequestDispatcher("/member/book/mainbook.do");
		dmainbook.include(request, response);
	%> 
	
	
	<!-- 월간베스트  -->
	<%
		out.flush();
		RequestDispatcher dmbs = request.getRequestDispatcher("/member/book/MonthlyBestSeller.do");
		dmbs.include(request, response);
	%> 


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>

	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


</body>

</html>