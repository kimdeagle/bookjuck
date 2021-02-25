<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::Welcome</title>


<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/notice.css">

<style>

</style>
</head>

<body>

	<!-- header ~ footer > 플로팅 메뉴(북적이, top)를 제외한 나머지 전부를 담는 컨테이너) -->
	<!-- ########## 컨테이너 시작 -->
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
	<!-- 공지사항 목록조회 -->
	<section class="mainsection" id="noticelistsection">
	    <h3 class="membertitle">공지사항</h3>
	
	    <table class="table tbl-md" id="listtbl">
	        <tr>
	            <th class="col-md-2 cell1">번호</th>
	            <th class="col-md-6 cell2">제목</th>
	            <th class="col-md-2 cell3">작성일</th>
	        </tr>
	        
	        <c:if test="${nlist.size()==0}">
			<tr>
			<td colspan="3" style="text-align:center;">게시물이 없습니다.</td>
			</tr>
			</c:if>
			
	        <c:forEach items="${nlist}" var="dto">
	        <tr>
			<td class="cell1">${dto.seq}</td>
			<td class="cell2"><a href="/bookjuck/member/notice/detail.do?seq=${dto.seq}&page=${nowPage}">${dto.title}</a></td>
			<td class="cell3">${dto.regdate.substring(0, 10)}</td>
			</tr>
			</c:forEach>
		</table>
	    
	    <nav class="pagebar">
			<ul class="pagination">
			${pagebar}
			</ul>
		</nav>
	    
	    <div id="btn">
	    	<button type="button" id="memberbtn" class="btn btn-general inline" onclick="location.href='/bookjuck/index.do'">뒤로가기</button>
	    </div>
		
	</section>


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->


	<!-- ########## 컨테이너 끝 -->
	</div>


	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>

	<script>
	
	</script>

</body>

</html>