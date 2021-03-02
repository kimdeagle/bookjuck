<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- header -->
    <header>

        <!-- 상단메뉴 -->
		<c:if test="${empty id}">
        <div id="headerlink">
            <a href="/bookjuck/member/login.do" class="headerlink-item">마이페이지</a>
            <a href="/bookjuck/member/login.do" class="headerlink-item">로그인</a>
            <a href="/bookjuck/member/tos.do" class="headerlink-item">회원가입</a>
            <a href="/bookjuck/member/login.do" class="headerlink-item">장바구니</a>
            <a href="/bookjuck/member/login.do" class="headerlink-item">주문/배송조회</a>
            <a href="/bookjuck/memeber/login.do" class="headerlink-item">QnA</a>
            <a href="/bookjuck/member/notice/list.do" class="headerlink-item">공지사항</a>
        </div>
		</c:if>
		
		<c:if test="${not empty id}">
        <div id="headerlink">
            <a href="/bookjuck/member/mypage.do" class="headerlink-item">마이페이지</a>
            <a href="/bookjuck/member/logoutok.do" class="headerlink-item">로그아웃</a>
            <a href="/bookjuck/member/order/cart.do" class="headerlink-item">장바구니</a>
            <a href="/bookjuck/member/mypage/orderlist.do" class="headerlink-item">주문/배송조회</a>
            <a href="/bookjuck/member/qna/list.do" class="headerlink-item">QnA</a>
            <a href="/bookjuck/member/notice/list.do" class="headerlink-item">공지사항</a>
        </div>
		</c:if>
		


        <!-- 로고, 캐릭터, 검색창 -->
		
        <div id="searchmenu">

            <!-- 로고 및 캐릭터 -->
            <a href="/bookjuck/index.do"><img src="/bookjuck/image/bookjeok/logo.png" class="logo"></a>
            <!-- <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">통합검색<span class="caret"></span></a> --> 
       
             <form id="searchform" method="GET" action="/bookjuck/common/searchview.do" style="display:inline;">
            <!-- 통합검색창(검색분류선택창) -->
            <select name="sk" class="form-control noline small inline" style="width:100px"> <!-- 검색키: search key  -->
		   		<option value="">전체도서</option>
		   		<option value="해외도서">해외도서</option>
		   		<option value="국내도서">국내도서</option>
		   		<option value="EBOOK">EBOOK</option>   	
   			</select>
   			
   			       	   	
		   	<input type="text" id ="searchBox" name="sv" class="form-control noline small inline" value="${sv}" placeholder ="2021년 3월 해리포터 신작출간"><!-- 검색값: search value -->
		   	<input type="submit" id="searchButton" value="검색" class="btn btn-general noline">   
		   </form>


            <!-- <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">통합검색<span class="caret"></span></a> -->
             
            
            <!-- <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
                <li class="divider"></li>
                <li><a href="#">One more separated link</a></li>
            </ul> -->

           <!--  <div class="searchdiv inline">
                <input type="text" id="search" class="form-control noline small inline">
                <input type="button" id="searchbtn" value="검색" class="btn btn-general noline">
            </div> -->

            <!-- 실시간검색어(현우님이 나중에 수정해주셔야 함! id랑 class는 CSS때문에 주의!) -->
        	<!-- <div id="realtime" class="inline">
            	
            </div>   -->
            

           
            <%
			      out.flush();
			       RequestDispatcher drealtime = request.getRequestDispatcher("/common/realtimesearch.do");
			       drealtime.include(request, response);
			   %>
       
            
            
            
            

        </div>
		<!--검색영여  -->
        <!-- 도서분류메뉴(navbar) -->
        <nav class="navbar">
            <div class="container-fluid">
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="http://localhost:8090/bookjuck/member/book/bestseller.do" class="nav-item">베스트도서</a></li>
                        <li><a href="http://localhost:8090/bookjuck/member/book/newbook.do" class="nav-item">신간도서</a></li>
                        <li><a href="#!" class="nav-item" id="internalbook">국내도서</a></li>
                        <li><a href="#!" class="nav-item" id="externalbook">해외도서</a></li>
                        <li><a href="/bookjuck/member/book/ebooklist.do" class="nav-item">E-Book</a></li>
                        <li><a href="/bookjuck/member/fleamarket/list.do" class="nav-item">중고게시판</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <!-- 국내도서 중분류 -->
		<div id="internalmenu">
		
			<c:forEach var="dto" items="${mCategoryList}">
				<c:if test="${dto.seqLCategory == 1}">
					<a href="/bookjuck/member/book/booklist.do?seqLCategory=${dto.seqLCategory}&seqMCategory=${dto.seqMCategory}">${dto.mCategory}</a>
				</c:if>
			</c:forEach>
		
		</div>
		
		<!-- 해외도서 중분류 -->
		<div id="externalmenu">
		
			<c:forEach var="dto" items="${mCategoryList}">
				<c:if test="${dto.seqLCategory == 2}">
					<a href="/bookjuck/member/book/booklist.do?seqLCategory=${dto.seqLCategory}&seqMCategory=${dto.seqMCategory}">${dto.mCategory}</a>
				</c:if>
			</c:forEach>
			
		</div>
		
    </header>