<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
            <h3>독후감</h3>

            <table class="table tbl-md reviewtbl">
                <tr>
                    <th class="col-md-1">글번호</th>
                    <th class="col-md-3">도서명</th>
                    <th class="col-md-5">제목</th>
                    <th class="col-md-3">작성일</th>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">책읽고 글쓰기</a></td>
                    <td class="cell3"><a href="/bookjuck/member/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a><span class="label label-danger">우수</span></td>
                    <td>2021-02-05</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">책읽고 글쓰기</a></td>
                    <td class="cell3"><a href="/bookjuck/member/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a><span class="label label-danger">우수</span></td>
                    <td>2021-02-05</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">영어회화 무작정 따라하기</a></td>
                    <td class="cell3"><a href="/bookjuck/member/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a></td>
                    <td>2021-02-05</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">책읽고 글쓰기</a></td>
                    <td class="cell3"><a href="/bookjuck/member/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a></td>
                   	<td>2021-02-05</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">책읽고 글쓰기</a></td>
                    <td class="cell3"><a href="/bookjuck/member/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a></td>
                    <td>2021-02-05</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">책읽고 글쓰기</a></td>
                    <td class="cell3"><a href="/bookjuck/member/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a></td>
                    <td>2021-02-05</td>
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

            <div id="btn">
                <button type="button" class="btn btn-general inline" id="back">뒤로가기</button>
            </div>
        </section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	

</body>

</html>