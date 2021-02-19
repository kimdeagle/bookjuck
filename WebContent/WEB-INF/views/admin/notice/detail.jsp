<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/notice.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/adminheader.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<section class="contentsection">
            <h3>공지사항</h3>

            <div id="subtitle">상세조회</div>

            <div id="detailbox">
                <h5>채팅상담 연결 안내</h5>
                <p id="senddate">2021-02-07</p>
                <div>안녕하세요. 북적북적입니다. 많은 채팅상담 연결로 인하여 채팅상담의 연결이 원활하지 못했던 점 사과말씀드립니다. 현재 장애는 복구되어 정상적으로 이용 가능합니다. 보다 친절하고 기분 좋은 상담 서비스가 될 수 있도록 노력하는 북적북적이 되겠습니다. 감사합니다.</div>
                
            </div>

            <div id="btn">
                <button type="button" class="btn btn-general inline" id="edit" onclick="location.href='/bookjuck/admin/notice/edit.do'">수정하기</button>
                <button type="button" class="btn btn-general inline" id="delete" onclick="location.href='/bookjuck/admin/notice/del.do'">삭제하기</button>
                <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/admin/notice/list.do'">뒤로가기</button>
            </div>
        
    </section>
	
	</div>
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>
	
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->

	

</body>

</html>