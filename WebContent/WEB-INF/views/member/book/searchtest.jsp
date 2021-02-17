<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search test v1</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
<style>
</style>

</head>
<body>
   <form id="searchform" method="GET" action="/bookjuck/searchlist.jsp">
   	<select name="sk"> <!-- 검색키: search key  -->
   		<option value="seq">도서번호</option>
   		<option value="title">책제목</option>
   		<option value="saleprice">가격</option>
   		<option value="seqAuthor">작가번호</option>   	
   	</select>
   	<input type="text" name="sv"><!-- 검색값: search value -->
   	<input type="submit" value="검색버튼">   
   </form>
   
</body>
</html>