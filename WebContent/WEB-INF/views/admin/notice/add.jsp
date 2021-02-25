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
<link rel="stylesheet" href="/bookjuck/css/notice.css">

<style>

</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>
	
	
		<section class="contentsection">
            <h3>공지사항<small style="margin-left:15px;">작성하기</small></h3>
            
            <form method="POST" action="/bookjuck/admin/notice/addok.do">
            <table class="table tbl-md" id="addtbl">
            	<tr>
            		<td class="col-md-2">제목</td>
            		<td class="col-md-10"><input type="text" id="title" name="title" class="form-control" placeholder="제목을 입력해주세요"></td>
            	</tr>
            	<tr>
            		<td class="col-md-2">내용</td>
            		<td class="col-md-10"><textarea id="content" name="content" class="form-control"  placeholder="내용을 입력해주세요" cols="40" rows="13"></textarea></td>
            	</tr>
            
            </table>
				<div id="btn">
	                <input type="submit" class="btn btn-general inline" value="저장하기" id="save">
	                <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/admin/notice/list.do'">뒤로가기</button>
	            </div>
	            
            </form>
    	</section>
	
		<!-- 플로팅 메뉴 -->
		<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
		<%@include file="/WEB-INF/views/common/top.jsp" %>
		
		
		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->

	</div>

</body>

</html>