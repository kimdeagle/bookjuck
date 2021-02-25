<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::중고게시판</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">

<link rel="stylesheet" href="/bookjuck/css/fleamarket.css">


<style>

</style>
</head>

<body>



	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<div class="container">
	
		<!-- ########## 상단 헤더 시작 -->
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
            <article class="fleamarket">

                <h3>중고도서 거래 게시판</h3>

                <div id="topbox1">
                    <input type="button" class="btn btn-list" value="목록" style="background-color: #F4A259; color: white;">
                    <input type="button" class="btn btn-pics" value="썸네일"  onclick="location.href='/bookjuck/member/fleamarket/thumbnail.do';">

                    <!-- <input type="text" class="form-control" id="search"> -->


                    <form id="searchForm" method="GET" action="/bookjuck/member/fleamarket/list.do">
                        <div class="input-group fleamarketsearch">
                        
                            <input type="text" class="form-control" id="fleamarketsearch" name="fleamarketsearch" placeholder="" aria-describedby="basic-addon2" required value="${fleamarketsearch}">
                            
                            <span class="input-group-addon" id="basic-addon2" style="cursor:pointer;" onclick="$('#searchForm').submit();"><span class="glyphicon glyphicon-search"></span></span>
                        </div>
                    </form> 
                        
                    <!-- <div style="clear:both;"></div> -->


                    <input type="button" class="btn btn-general" value="새 글쓰기" onclick="location.href='/bookjuck/member/fleamarket/write.do';">
                </div>

                <table class="table tbl-md">
                
                	<thead>
	                    <tr style="background-color: RGBA(140,179,105,0.2)">
	                        <th id="num">글번호</th>
	                        <th id="title">글제목</th>
	                        <th id="state">거래상태</th>
	                        <th id="name">작성자</th>
	                        <th id="date">작성일</th>
	                        <th id="cnt">읽음</th>
	                    </tr>
                    </thead>
                    
                    <tbody>
                    	<c:if test="${list.size() == 0 }">
	                    	<tr>
	                    		<td colspan="5" style="text-align:center;">게시물이 없습니다.</td>
	                    	</tr>
                    	</c:if>
                    	
                    	<c:forEach items="${list}" var="dto">
	                    <tr>
	                        <td>${dto.seq}</td>
	                        <td class="title">
	                        
		                        <a href="/bookjuck/member/fleamarket/view.do?seq=${dto.seq}&fleamarketsearch=${fleamarketsearch}">
		                        ${dto.title}
		                        </a>
		                        

								 
								<!-- 최신글 글쓴지 하루 이하는 new 뱃지 표기 -->
	                           	<c:if test="${dto.gap < 24}">
	                           		<span class="label label-danger">new</span>
	                           	</c:if>
	                        
	                        </td>

							
							<c:if test="${dto.dealState.equals('판매완료')}">
		                    	<td style="color: #BBB; font-weight: bold;">${dto.dealState }</td>
	                        </c:if>
							<c:if test="${dto.dealState.equals('판매중')}">
		                    	<td style="color: #3eaf7a; font-weight: bold;">${dto.dealState }</td>
	                        </c:if>
							<c:if test="${dto.dealState.equals('예약중')}">
		                    	<td style="color: #df484f; font-weight: bold;">${dto.dealState }</td>
	                        </c:if>
							
	                        <td>${dto.id }</td>
	                        <td>${dto.regDate }</td>
	                        <td>${dto.readcnt }</td>
	                    </tr>
	                    </c:forEach>
    				</tbody>
    				
                </table>


                <ul class="pagination">
                    ${pagebar}
                </ul>

            </article>
        </section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	

</body>

</html>