<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
                    <input type="button" class="btn btn-list" value="목록" style="background-color: #F4A259; color: white;">
                    <input type="button" class="btn btn-pics" value="썸네일">

                    <!-- <input type="text" class="form-control" id="search"> -->

                    <form id="searchForm" method="GET" action="/codestudy/board/list.do">
                        <div class="input-group search">
                        
                            <input type="text" class="form-control" id="search" name="search" placeholder="" aria-describedby="basic-addon2" required value="">
                            
                            <span class="input-group-addon" id="basic-addon2" style="cursor:pointer;" onclick=""><span class="glyphicon glyphicon-search"></span></span>
                        </div>
                    </form> 
                        
                    <!-- <div style="clear:both;"></div> -->


                    <input type="button" class="btn btn-general" value="새 글쓰기">
                </div>

                <table class="table tbl-md">
                    <tr style="background-color: RGBA(140,179,105,0.2)">
                        <th id="num">글번호</th>
                        <th id="title">글제목</th>
                        <th id="name">작성자</th>
                        <th id="date">작성일</th>
                        <th id="cnt">읽음</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="title"><a href="">테스트입니다. 중고도서지만 깨끗합니다.</a></td>
                        <td><a href="/bookjuck/admin/fleamarket/detail.do">테스트</a></td>
                        <td>2021-02-17</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="title"><a href="/bookjuck/admin/fleamarket/detail.do">테스트입니다. 중고도서지만 깨끗합니다.</a></td>
                        <td>테스트</td>
                        <td>2021-02-17</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="title"><a href="/bookjuck/admin/fleamarket/detail.do">테스트입니다. 중고도서지만 깨끗합니다.</a></td>
                        <td>테스트</td>
                        <td>2021-02-17</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="title"><a href="/bookjuck/admin/fleamarket/detail.do">테스트입니다. 중고도서지만 깨끗합니다.</a></td>
                        <td>테스트</td>
                        <td>2021-02-17</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="title"><a href="/bookjuck/admin/fleamarket/detail.do">테스트입니다. 중고도서지만 깨끗합니다.</a></td>
                        <td>테스트</td>
                        <td>2021-02-17</td>
                        <td>0</td>
                    </tr>                   
                </table>


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
	
	</div>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>



</body>

</html>