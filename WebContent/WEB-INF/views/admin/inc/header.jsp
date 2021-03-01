<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <header>
        <!-- 로고 및 캐릭터 -->
        
        <a href="/bookjuck/admin/index.do"><img src="/bookjuck/image/bookjeok/logo.png" id="logo"></a>
        

        <div class="searchdiv inline">
            <input type="text" id="search" class="form-control noline large inline">
            <input type="button" id="searchbtn" value="검색" class="btn btn-general noline">
        </div>
        
        <!-- 로그인/로그아웃(임시) -->
        <c:if test="${empty id}">
			<input type="button" id="btnLogin" class="btn btn-default" value="로그인" onclick="location.href='/bookjuck/admin/login.do';">        
        </c:if>
        <c:if test="${not empty id}">
			<input type="button" id="btnLogout" class="btn btn-default" value="로그아웃" onclick="location.href='/bookjuck/admin/logout.do';">        
        </c:if>
		
    </header>

	<aside>
	    <div id="introtitle">
	        <h6 class="h6-white">Admin</h6>
	    </div>
	
	    <div id="mypagemenu">
	        <ul>
	            <li class="menuitem"><a href="/bookjuck/admin/book/booklist.do"><h6>도서 관리</h6></a></li>
	            <li class="menuitem"><a href="/bookjuck/admin/book/ebooklist.do"><h6>E-Book 관리</h6></a></li>
	            <li class="menuitem"><a href="#"><h6>주문 관리</h6></a></li>
	            	<ul class="menusubitem">
		                <li class="contents"><a href="/bookjuck/admin/order/orderlist.do">주문/배송조회</a></li>
		                <li class="contents"><a href="/bookjuck/admin/order/refundlist.do">취소/교환/환불조회</a></li>
					</ul>
	            <li class="menuitem"><a href="/bookjuck/admin/statistics/statistics.do"><h6>통계</h6></a></li>
	            <li class="menuitem"><a href="#"><h6>고객 관리</h6></a></li>
	            	<ul class="menusubitem">
		                <li class="contents">고객정보조회</a></li>
		                <li class="contents"><a href="/bookjuck/admin/curationletter/list.do">큐레이션레터</a></li>
		                <li class="contents"><a href="/bookjuck/admin/custmng/custmng.do">고객 계정 관리</a></li>
		                <li class="contents"><a href="/bookjuck/admin/custmng/dormancymng.do">휴면 계정 관리</a></li>
	            	</ul>
	            <li class="menuitem"><a href="#!"><h6>게시판 관리</h6></a></li>
		           	<ul class="menusubitem">
		                <li class="contents"><a href="/bookjuck/admin/notice/list.do">공지사항</a></li>
		                <li class="contents"><a href="/bookjuck/admin/faq/list.do">자주 하는 질문</a></li>
		                <li class="contents"><a href="/bookjuck/admin/qna/list.do">QnA</a></li>
		                <li class="contents"><a href="/bookjuck/admin/review/list.do">독후감게시판</a></li>
		                <li class="contents"><a href="/bookjuck/admin/fleamarket/list.do">중고거래게시판</a></li>
					</ul>
	        </ul>
	    </div>
	</aside>

<script>

    $(function() {
        $(".menusubitem").slideUp();
         
        $(".menuitem").click(function() {
            $(this).next(".menusubitem").slideToggle(500);
        });
    });

</script>