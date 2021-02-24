<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
<link rel="stylesheet" href="/bookjuck/css/searchview.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<style>
</style>

</head>
<body>
<div class="container">
<header>
	
        <!-- 상단메뉴 -->

         <div id="headerlink">
            <a href="#" class="headerlink-item">마이페이지</a>
            <a href="#" class="headerlink-item">로그인</a>
            <a href="#" class="headerlink-item">회원가입</a>
            <a href="#" class="headerlink-item">장바구니</a>
            <a href="#" class="headerlink-item">주문/배송조회</a>
            <a href="#" class="headerlink-item">고객센터</a>
        </div> 

        <!-- 로고, 캐릭터, 검색창 -->

        <div id="searchmenu">

            <!-- 로고 및 캐릭터 -->
            <img src="/bookjuck/image/bookjeok/logo.png" class="logo">
            
            
            <form id="searchform" method="GET" action="/bookjuck/common/searchview.do">
            <!-- 통합검색창(검색분류선택창) -->
            <select name="sk" class="form-control noline small inline" style="width:100px"> <!-- 검색키: search key  -->
		   		<option value="">전체도서</option>
		   		<option value="해외도서">해외도서</option>
		   		<option value="국내도서">국내도서</option>
		   		<option value="EBOOK">EBOOK</option>   	
   			</select>
   			
   			       	   	
		   	<input type="text" id ="searchBox"name="sv" class="form-control noline small inline" value="${sv}" placeholder ="2021년 3월 해리포터 신작출간"><!-- 검색값: search value -->
		   	<input type="submit" id="searchButton" value="검색" class="btn btn-general noline">   
		   </form>
		  

            <!-- 실시간검색어(현우님이 나중에 수정해주셔야 함! id랑 class는 CSS때문에 주의!) -->
            <!-- <div id="realtime" class="inline">실시간검색어</div> -->
            <br>

        </div>

        <!-- 도서분류메뉴(navbar) -->
         <nav class="navbar">
            <div class="container-fluid">
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="#" class="nav-item">베스트도서</a></li>
                        <li><a href="#" class="nav-item">신간도서</a></li>
                        <li><a href="#" class="nav-item" id="internalbook">국내도서</a></li>
                        <li><a href="#" class="nav-item" id="externalbook">해외도서</a></li>
                        <li><a href="#" class="nav-item">E-Book</a></li>
                        <li><a href="#" class="nav-item">중고게시판</a></li>
                    </ul>
                </div>
            </div>
        </nav> 
        
        <!-- 국내도서 중분류 -->
<!-- 		<div id="internalmenu">
			<a href="/bookjuck/member/book/inlist.do" class="">소설</a>
			<a href="#" class="">시/에세이</a>
			<a href="#" class="">경제/경영</a>
			<a href="#" class="">인문</a>
			<a href="#" class="">역사/문화</a>
			<a href="#" class="">종교</a>
			<a href="#" class="">정치/사회</a>
			<a href="#" class="">예술/대중문화</a>
			<a href="#" class="">과학</a>
			<a href="#" class="">기술/공학</a>
			<a href="#" class="">컴퓨터/IT</a>
			<a href="#" class="">유아/어린이/청소년</a>
			<a href="#" class="">참고서/교재</a>
			<a href="#" class="">취업/수험서</a>
			<a href="#" class="">외국어</a>
		</div> -->
		
		<!-- 해외도서 중분류 -->
		<div id="externalmenu">
			<a href="/bookjuck/member/book/exlist.do" class="">서양도서</a>
			<a href="" class="">어린이/청소년</a>
			<a href="" class="">일본도서</a>
			<a href="" class="">기타언어권</a>
		</div>
    </header>
	
	<c:if test="${not empty sv}">
    <div>
    '${sv}'에 대한 ${sk} 검색결과 총 ${list.size()}권의 도서를 검색했습니다.
    </div>
     </c:if>
     <br>
		<c:forEach items="${list}" var="dto">
			<div class="bookbox9" id="booklist" style="left:50%; margin:auto;">
				<div class="bestrank5">
					<img src="/bookjuck/image/${dto.image}" style="width:100px; height:160px; float:left; margin:10px;">
					<div class="bookname">
						<strong>${dto.title}</strong>
					</div> 
					<div class="bookinfo">${dto.author} | ${dto.publisher} | ${dto.pubDate}</div>
					<div class="bookcopy">${dto.copy}</div>
					<div class="price">가격: ${dto.price}원</div>
					<div>
						<input type="button" class="btn btn-default" value="바로결제">
					</div>
					<div>
						<input type="button" class="btn btn-danger" value="바로드림">
					</div>
					<div>
						<input type="button" class="btn btn-warning" value="장바구니 담기">
					</div>
				</div>
			</div>
		</c:forEach>	
		<!-- 하단 -->
	<%-- <%@include file="/WEB-INF/views/common/footer.jsp" %>	 --%>
</div>

<!-- 플로팅 -->
	<%-- <%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp"%> --%>
	<script>
		
		
		// 검색창 입력안하고 검색하기 눌렀을경우, alert처리
		$(document).ready(function() {
			$("#searchButton").click(function() {
				var searchCheck = 0;
				if ($("#searchBox").val() == "") {
					alert("검색어를 입력해 주세요.")

					$("#searchBox").focus();//커서입력
					return false;
				}

			})
		})
		
		/*
		
		$("#searchform").submit(function(evt) {
			
			if ($("#searchBox").val().trim() != "") {
				alert("검색어를 입력해 주세요.");
				evt.preventDefault();
				return false;				
			}
		});
		*/
		
	</script>

</body>
</html>












