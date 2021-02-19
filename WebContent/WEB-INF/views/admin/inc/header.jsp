<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <header>
        <!-- 로고 및 캐릭터 -->
        <img src="/bookjuck/image/bookjeok/logo.png" id="logo">

        <div class="searchdiv inline">
            <input type="text" id="search" class="form-control noline large inline">
            <input type="button" id="searchbtn" value="검색" class="btn btn-general noline">
        </div>
    </header>

	<aside>
	    <div id="introtitle">
	        <h6 class="h6-white">Admin</h6>
	    </div>
	
	    <div id="mypagemenu">
	        <ul>
	            <li class="menuitem"><a href="/bookjuck/admin/book/list.do"><h6>도서 관리</h6></a></li>
	            <li class="menuitem"><a href="#"><h6>E-Book 관리</h6></a></li>
	            <li class="menuitem"><a href="#"><h6>주문 관리</h6></a></li>
	            <li class="menuitem"><a href="#"><h6>통계</h6></a></li>
	            <li class="menuitem"><a href="#"><h6>고객 관리</h6></a></li>
	            <li class="menuitem"><a href="#!"><h6>게시판 관리</h6></a></li>
		           	<ul class="menusubitem">
		                <li class="contents"><a href="/bookjuck/admin/notice/list.do">공지사항</a></li>
		                <li class="contents"><a href="/bookjuck/admin/faq/list.do">자주 하는 질문</a></li>
		                <li class="contents"><a href="/bookjuck/admin/qna/list.do">1대1문의글</a></li>
		                <li class="contents"><a href="/bookjuck/admin/review/list.do">독후감게시판</a></li>
		                <li class="contents"><a href="#">중고거래게시판</a></li>
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