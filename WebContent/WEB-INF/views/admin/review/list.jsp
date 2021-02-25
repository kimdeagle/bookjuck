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
<link rel="stylesheet" href="/bookjuck/css/review.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<!-- 주요내용! 여기에 작성한 코드 넣을 것! -->
        <section class="contentsection">
            <h3>독후감</h3>

            <table class="table tbl-md reviewtbl">
                <tr>
                    <th class="col-md-1">글번호</th>
                    <th class="col-md-3">도서명</th>
                    <th class="col-md-4">제목</th>
                    <th class="col-md-1">아이디</th>
                    <th class="col-md-2">작성일</th>
                    <th class="col-md-1">우수</th>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">책읽고 글쓰기</a></td>
                    <td class="cell3"><a href="/bookjuck/admin/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a></td>
                    <td>aaa111</td>
                    <td>2021-02-05</td>
                    <td><input type="checkbox"></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">책읽고 글쓰기</a></td>
                    <td class="cell3"><a href="/bookjuck/admin/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a></td>
                    <td>aaa111</td>
                    <td>2021-02-05</td>
                    <td><input type="checkbox"></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">영어회화 무작정 따라하기</a></td>
                    <td class="cell3"><a href="/bookjuck/admin/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a></td>
                    <td>aaa111</td>
                    <td>2021-02-05</td>
                    <td><input type="checkbox"></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">책읽고 글쓰기</a></td>
                    <td class="cell3"><a href="/bookjuck/admin/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a></td>
                    <td>aaa111</td>
                    <td>2021-02-05</td>
                    <td><input type="checkbox"></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">책읽고 글쓰기</a></td>
                    <td class="cell3"><a href="/bookjuck/admin/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a></td>
                    <td>aaa111</td>
                    <td>2021-02-05</td>
                    <td><input type="checkbox"></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="cell2"><a href="#">책읽고 글쓰기</a></td>
                    <td class="cell3"><a href="/bookjuck/admin/review/detail.do">초보 서평러를 위한 최고의 글쓰기 실전 가이드</a></td>
                    <td>aaa111</td>
                    <td>2021-02-05</td>
                    <td><input type="checkbox"></td>
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
                <button type="button" class="btn btn-general" id="edit">작성하기</button>
                <button type="button" class="btn btn-general inline" id="prize">우수독후감 선정하기</button>
                <button type="button" class="btn btn-general inline" id="back">뒤로가기</button>
            </div>
        </section>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>



</body>

</html>