<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BookjuckBookjuck::Mypage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/footer.css">
<link rel="stylesheet" href="/bookjuck/css/header.css">
<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/firstpage.css">


<style>

</style>
</head>

<body>

	<!-- ########## 상단 헤더 시작 -->
	<%
		out.flush();
	    RequestDispatcher dheader = request.getRequestDispatcher("/inc/header.do");
	    dheader.include(request, response);
	%>
	<!-- ########## 상단 헤더 끝 -->

	<!-- 마이페이지 -->
	<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>


	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/member/inc/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/member/inc/top.jsp" %>
	
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/member/inc/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	

</body>

</html>