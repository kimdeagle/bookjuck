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

                <div id="topbox2">
                    <input type="button" class="btn btn-list" value="목록"  onclick="location.href='/bookjuck/member/fleamarket/list.do';">
                    <input type="button" class="btn btn-pics" value="썸네일" style="background-color: #F4A259; color: white;">

                    <!-- <input type="text" class="form-control" id="search"> -->

                    <form id="searchForm" method="GET" action="/bookjuck/member/fleamarket/thumbnail.do">
                        <div class="input-group fleamarketsearch">
                        
                            <input type="text" class="form-control" id="fleamarketsearch" name="fleamarketsearch" placeholder="" aria-describedby="basic-addon2" required value="${fleamarketsearch}">
                            
                            <span class="input-group-addon" id="basic-addon2" style="cursor:pointer;" onclick="$('#searchForm').submit();"><span class="glyphicon glyphicon-search"></span></span>
                        </div>
                    </form> 
                        
                    <!-- <div style="clear:both;"></div> -->


                    <input type="button" class="btn btn-general" value="새 글쓰기" onclick="location.href='/bookjuck/member/fleamarket/write.do';">
                </div><!-- topbox -->
                

                <!-- 썸네일형 리스트 -->
                <div class="thumbnail-box">
                
                	<c:if test="${list.size() == 0 }">
                		<div style="text-align:center;">게시물이 없습니다.</div>
                	</c:if>
                	
                	<c:forEach items="${list}" var="dto">
                    <div class="thumbnail-list" onclick="location.href='/bookjuck/member/fleamarket/view.do?seq=${dto.seq}&fleamarketsearch=${fleamarketsearch}';">
                        <div class="seq">${dto.seq}</div>
                        <c:if test="${not empty dto.image}">
                        <div class="attach"><img src="/bookjuck/files/${dto.image }" class="book-sm"></div>
                        </c:if>
                        <c:if test="${dto.image == null}">
                        <div class="attach"><img src="/bookjuck/image/nopic.png" class="book-sm"></div>
                        </c:if>
                        <div class="subject">${dto.title}</div>
                        <div class="id">${dto.id}</div>
                        <div class="regdate">${dto.regDate}</div>
                        <c:if test="${dto.ccount > 0}">
                        <div class="cnt">${dto.ccount}</div>
                        </c:if>
                        <c:if test="${dto.ccount == 0 ||dto.ccount == null}">
                        <div class="cnt">0</div>
                        </c:if>
                    </div>
					</c:forEach>
					
                   
                </div>

                <div style="clear: both;"></div>


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