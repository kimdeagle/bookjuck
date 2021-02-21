<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<div class="container">
	
		<!-- ########## 상단 헤더 시작 -->
		<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
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

                    <form id="searchForm" method="GET" action="">
                        <div class="input-group search">
                        
                            <input type="text" class="form-control" id="fleamarket-search" name="fleamarket-search" placeholder="" aria-describedby="basic-addon2" required value="">
                            
                            <span class="input-group-addon" id="basic-addon2" style="cursor:pointer;" onclick=""><span class="glyphicon glyphicon-search"></span></span>
                        </div>
                    </form> 
                        
                    <!-- <div style="clear:both;"></div> -->


                    <input type="button" class="btn btn-general" value="새 글쓰기" onclick="location.href='/bookjuck/member/fleamarket/write.do';">
                </div><!-- topbox -->
                

                <!-- 썸네일형 리스트 -->
                <div class="thumbnail-box">
                    <div class="thumbnail-list" onclick="location.href='/bookjuck/member/fleamarket/view.do';">
                        <div class="seq">1.</div>
                        <div class="attach"><img src="/bookjuck/image/바이러스 X.png" class="book-sm"></div>
                        <div class="subject">글 제목</div>
                        <div class="id">글쓴사람 id</div>
                        <div class="regdate">글 작성날짜</div>
                        <div class="cnt">0</div>
                    </div>

                    <div class="thumbnail-list">
                        <div class="seq">1.</div>
                        <div class="attach"><img src="/bookjuck/image/마법천자문 1.png" class="book-sm"></div>
                        <div class="subject">제 추억이 담긴 소중</div>
                        <div class="id">ddarong2</div>
                        <div class="regdate">2021-02-20</div>
                        <div class="cnt">99</div>
                    </div>

                    <div class="thumbnail-list">
                        <div class="seq">1.</div>
                        <div class="attach"><img src="/bookjuck/image/우리가 사랑한 고흐.png" class="book-sm"></div>
                        <div class="subject">팔기 싫은데 팝니다</div>
                        <div class="id">durrup2</div>
                        <div class="regdate">2021-02-20</div>
                        <div class="cnt">2</div>
                    </div>

                    <div class="thumbnail-list">
                        <div class="seq">1.</div>
                        <div class="attach"><img src="/bookjuck/image/우리가 사랑한 고흐.png" class="book-sm"></div>
                        <div class="subject">팔기 싫은데 팝니다</div>
                        <div class="id">durrup2</div>
                        <div class="regdate">2021-02-20</div>
                        <div class="cnt">2</div>
                    </div>

                    <div class="thumbnail-list">
                        <div class="seq">1.</div>
                        <div class="attach"><img src="/bookjuck/image/우리가 사랑한 고흐.png" class="book-sm"></div>
                        <div class="subject">팔기 싫은데 팝니다</div>
                        <div class="id">durrup2</div>
                        <div class="regdate">2021-02-20</div>
                        <div class="cnt">2</div>
                    </div>

                    <div class="thumbnail-list">
                        <div class="seq">1.</div>
                        <div class="attach"><img src="/bookjuck/image/우리가 사랑한 고흐.png" class="book-sm"></div>
                        <div class="subject">팔기 싫은데 팝니다</div>
                        <div class="id">durrup2</div>
                        <div class="regdate">2021-02-20</div>
                        <div class="cnt">2</div>
                    </div>

                    <div class="thumbnail-list">
                        <div class="seq">1.</div>
                        <div class="attach"><img src="/bookjuck/image/우리가 사랑한 고흐.png" class="book-sm"></div>
                        <div class="subject">팔기 싫은데 팝니다</div>
                        <div class="id">durrup2</div>
                        <div class="regdate">2021-02-20</div>
                        <div class="cnt">2</div>
                    </div>

                    <div class="thumbnail-list">
                        <div class="seq">1.</div>
                        <div class="attach"><img src="/bookjuck/image/우리가 사랑한 고흐.png" class="book-sm"></div>
                        <div class="subject">팔기 싫은데 팝니다</div>
                        <div class="id">durrup2</div>
                        <div class="regdate">2021-02-20</div>
                        <div class="cnt">2</div>
                    </div>

                    <div class="thumbnail-list">
                        <div class="seq">1.</div>
                        <div class="attach"><img src="/bookjuck/image/해리포터와 마법사의 돌 2.png" class="book-sm"></div>
                        <div class="subject">제 자서전입니다.</div>
                        <div class="id">dumbledore</div>
                        <div class="regdate">2021-02-20</div>
                        <div class="cnt">88</div>
                    </div>

                    <div class="thumbnail-list">
                        <div class="seq">1.</div>
                        <div class="attach"><img src="/bookjuck/image/우리가 사랑한 고흐.png" class="book-sm"></div>
                        <div class="subject">팔기 싫은데 팝니다</div>
                        <div class="id">durrup2</div>
                        <div class="regdate">2021-02-20</div>
                        <div class="cnt">2</div>
                    </div>

                </div>

                <div style="clear: both;"></div>


                <ul class="pagination">
                    <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                    </li>
                </ul>

            </article>
        </section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	

</body>

</html>