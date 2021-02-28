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
<link rel="stylesheet" href="/bookjuck/css/qna.css">

<style>

</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>
	
	
		<section class="contentsection">
            <h3>QnA</h3>

            <table class="table tbl-md" id="listtbl">
                <tr>
                    <th class="col-md-2 cell1">카테고리</th>
                    <th class="col-md-2 cell2">아이디</th>
                    <th class="col-md-4 cell3">제목</th>
                    <th class="col-md-2 cell4">작성일</th>
                    <th class="col-md-2 cell5">답변여부</th>
                </tr>
                <c:forEach items="${qlist}" var="qdto">
                <tr>
                    <td class="cell1">${qdto.qCategory}</td>
                    <td class="cell2">${qdto.id}</td>
                    <td class="cell3"><a href="/bookjuck/admin/qna/detail.do?seq=${qdto.seq}&page=${nowPage}">${qdto.title}</a></td>
                    <td class="cell4">${qdto.regDate.substring(0, 10)}</td>
                    <td class="cell5">
                    	<c:if test="${qdto.isDone.substring(0, 10).equals('1900-01-01')}">
                    		<span>답변대기중</span>
                    	</c:if>
                    	<c:if test="${!qdto.isDone.substring(0, 10).equals('1900-01-01')}">
                    		<span>답변완료</span>
                    	</c:if>
                    </td>
                </tr>
                </c:forEach>
            </table>

            <nav class="pagebar">
                <ul class="pagination">
                    ${pagebar}
                </ul>
            </nav>
            <div id="btn">
            	<button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/admin/index.do'">뒤로가기</button>
            </div>
        </section>
	
		

	</div>
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>
	
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->

</body>

</html>