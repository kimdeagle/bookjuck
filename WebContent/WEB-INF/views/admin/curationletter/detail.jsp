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
        <h3>큐레이션레터<small style="margin-left:15px;">상세조회</small></h3>

		<table class="table tbl-md" id="lettertbl">
			<tr>
				<th class="col-md-2">제목</th>
				<td class="col-md-10">${dto.title}</td>
			</tr>
			<tr>
				<th class="col-md-2">전송일</th>
				<td class="col-md-10">${dto.regDate}</td>
			</tr>
			<tr>
				<th class="col-md-2">내용</th>
				<td class="col-md-10">${dto.content}</td>
			</tr>
		</table>

        <div id="btn">
            <input type="submit" class="btn btn-general inline" value="삭제하기" id="del">
            <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/admin/curationletter/list.do?page=${page}'">뒤로가기</button>
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