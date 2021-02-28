<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>


<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/notice.css">

<style>

</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>
	
	
		<section class="contentsection">
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
		            <td class="cell2"><a href="/bookjuck/admin/notice/detail.do?seq=${dto.seq}&page=${nowPage}">${dto.title}</a></td>
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
		        <button type="button" class="btn btn-general" id="add" onclick="location.href='/bookjuck/admin/notice/add.do'">작성하기</button>
		        <button type="button" class="btn btn-general inline" id="back"  onclick="location.href='/bookjuck/admin/index.do'">뒤로가기</button>
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