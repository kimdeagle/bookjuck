<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>


<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/review.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<!-- 주요내용! 여기에 작성한 코드 넣을 것! -->
    <section class="contentsection">
        <h3>독후감</h3>

        <table class="table tbl-md" id="listtbl">
            <tr>
                <th class="col-md-1">글번호</th>
                <th class="col-md-3">도서명</th>
                <th class="col-md-4">제목</th>
                <th class="col-md-1">아이디</th>
                <th class="col-md-2">작성일</th>
            </tr>
            <c:forEach items="${rlist}" var="dto">
            <tr>
                <td>${dto.seq}</td>
                <td class="cell2"><a href="#">${dto.bookTitle}</a></td>
                <td class="cell3">
                	<a href="/bookjuck/admin/review/detail.do?seq=${dto.seq}&page=${nowPage}">
               		${dto.reviewTitle}
                	<c:if test="${(dto.isPrize) eq '1'}">
                		<span class="label label-danger">우수</span>
                	</c:if>
                	</a>
                </td>
                <td>${dto.id}</td>
                <td>${dto.regDate.substring(0, 10)}</td>
            </tr>
            </c:forEach>
        </table>

		<nav class="pagebar">
            <ul class="pagination">
                ${pagebar}
            </ul>
        </nav>
            
        <div id="btn">
            <button type="button" class="btn btn-general inline" id="back" onclick="location.href='/bookjuck/admin/index.do'">뒤로가기</button>
        </div>
    </section>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>

</body>

</html>