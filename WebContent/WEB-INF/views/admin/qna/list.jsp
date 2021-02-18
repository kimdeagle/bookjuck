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
<link rel="stylesheet" href="/bookjuck/css/qna.css">

<style>

</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>
	
	
		<section class="contentsection">
            <h3>QnA</h3>

            <table class="table tbl-md qnatbl">
                <tr>
                    <th class="col-md-2 cell1">카테고리</th>
                    <th class="col-md-2 cell2">아이디</th>
                    <th class="col-md-4 cell3">제목</th>
                    <th class="col-md-2 cell4">작성일</th>
                    <th class="col-md-2 cell5">답변여부</th>
                </tr>
                <tr>
                    <td class="cell1">환불</td>
                    <td class="cell2">abcd1111</td>
                    <td class="cell3"><a href="/bookjuck/admin/qna/detail.do">환불 신청 어떻게 하나요?</a></td>
                    <td class="cell4">2021-02-05</td>
                    <td class="cell5">미답변</td>
                </tr>
                <tr>
                    <td class="cell1">교환</td>
                    <td class="cell2">abcd1111</td>
                    <td class="cell3"><a href="/bookjuck/admin/qna/detail.do">찢어져서 온 책 어떻게 하나요?</a></td>
                    <td class="cell4">2021-02-05</td>
                    <td class="cell5">미답변</td>
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
        </section>
	
		<!-- 플로팅 메뉴 -->
		<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
		<%@include file="/WEB-INF/views/common/top.jsp" %>
		
		
		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->

	</div>

</body>

</html>