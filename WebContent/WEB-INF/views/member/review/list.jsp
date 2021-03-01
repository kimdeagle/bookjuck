<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/review.css">

<style>

</style>
</head>

<body>



	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


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
	
	
		<!-- 마이페이지 side bar -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		
		
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
		<section class="contentsection">
            <h3>독후감</h3>

            <table class="table tbl-md" id="listtbl">
                <tr>
                    <th class="col-md-1">글번호</th>
                    <th class="col-md-3">도서명</th>
                    <th class="col-md-5">제목</th>
                    <th class="col-md-3">작성일</th>
                </tr>
                
                <c:if test="${rlist.size()==0}">
			        <tr>
			        	<td colspan="4" style="text-align:center;">게시물이 없습니다.</td>
			        </tr>
			    </c:if>
			    
                <c:forEach items="${rlist}" var="rdto">
                <tr>
                    <td>${rdto.seq}</td>
                    <td class="cell2"><a href="/bookjuck/member/book/bookdetail.do?seq=${rdto.seqBook}">${rdto.bookTitle}</a></td>
                    <td class="cell3"><a href="/bookjuck/member/review/detail.do?seq=${rdto.seq}&page=${nowPage}">${rdto.reviewTitle}</a>
                    	<c:if test="${rdto.isPrize eq '1' }">
                    		<span class="label label-danger">우수</span>
                    	</c:if>
                    </td>
                    <td>${rdto.regDate.substring(0, 10)}</td>
                </tr>
                </c:forEach>
            </table>

            <nav class="pagebar">
				<ul class="pagination">
					${pagebar}
				</ul>
			</nav>

            <div id="btn">
            	<c:if test="${write==true }">
            	<button type="button" class="btn btn-general inline" id="add" onclick="location.href='/bookjuck/member/review/add.do'">작성하기</button>
            	</c:if>
                <button type="button" class="btn btn-general inline" id="back" onclick="location.href='/bookjuck/member/mypage.do'">뒤로가기</button>
            </div>
        </section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	

</body>

</html>