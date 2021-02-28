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
<link rel="stylesheet" href="/bookjuck/css/fleamarket.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

		<section class="contentsection">
            <article class="fleamarket">

                <h3>중고도서 거래 게시판</h3>

                <div id="topbox1">
                    <!-- <input type="text" class="form-control" id="search"> -->

                    <form id="searchForm" method="GET" action="/bookjuck/admin/fleamarket/list.do">
                        <div class="input-group search">
                        
                            <input type="text" class="form-control" id="fleamarketsearch" name="fleamarketsearch" placeholder="검색어를 입력해주세요." aria-describedby="basic-addon2" required value="${fleamarketsearch}">
                            
                            <span class="input-group-addon" id="basic-addon2" style="cursor:pointer;" onclick=""><span class="glyphicon glyphicon-search"></span></span>
                        </div>
                    </form> 
                        
                    <!-- <div style="clear:both;"></div> -->


               </div>
                    <!-- 썸네일형 리스트 -->
                <div class="thumbnail-box">
                
                	<c:if test="${list.size() == 0 }">
                		<div style="text-align:center;">게시물이 없습니다.</div>
                	</c:if>
                	
                	<c:forEach items="${ulist}" var="dto">
                    <div class="thumbnail-list" onclick="location.href='/bookjuck/admin/fleamarket/view.do?seq=${dto.seq}&fleamarketsearch=${fleamarketsearch}&page=${nowPage}';">
                        <div class="seq">${dto.seq}</div>
                        
                        <c:if test="${not empty dto.image}">
                        <div class="attach"><img src="/bookjuck/file/${dto.image}" class="book-sm"></div>
                        </c:if>
                        
                        <c:if test="${dto.image == null}">
                        <div class="attach"><img src="/bookjuck/image/nopic.png" class="book-sm"></div>
                        </c:if>
                        
                        <div class="subject">${dto.title}</div>
                        <div class="id">${dto.id}</div>
                        <div class="regdate">${dto.regDate.substring(0, 10)}</div>
                        
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

                <nav class="pagebar">
	                <ul class="pagination">
	                    ${pagebar}
	                </ul>
            	</nav>
	
				<div id="btn">
            		<button type="button" class="btn btn-general inline" id="back" onclick="location.href='/bookjuck/admin/index.do'">뒤로가기</button>
        		</div>
        
            </article>
        </section>
	
	</div>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>



</body>

</html>