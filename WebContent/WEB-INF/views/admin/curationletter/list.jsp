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
<link rel="stylesheet" href="/bookjuck/css/curationletter.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<section class="contentsection">
            <h3>큐레이션레터</h3>

            <table class="table tbl-md">
                <tr>
                    <th>레터번호</th>
                    <th>제목</th>
                    <th>전송일</th>
                </tr>
                <tr>
                    <td>17</td>
                    <td><a href="/bookjuck/admin/curationletter/detail.do">큐레이션레터</a></td>
                    <td>2021-02-05</td>
                </tr>
                <tr>
                    <td>17</td>
                    <td><a href="/bookjuck/admin/curationletter/detail.do">큐레이션레터</a></td>
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
                <button type="button" class="btn btn-general" id="edit" onclick="location.href='/bookjuck/admin/curationletter/add.do'">작성하기</button>
                <button type="button" class="btn btn-general inline" id="back">뒤로가기</button>
            </div>
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