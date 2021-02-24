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
<link rel="stylesheet" href="/bookjuck/css/qna.css">

<style>

</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>
	
	
		<section class="contentsection">
            <h3>QnA<small style="margin-left:15px;">답변 수정하기</small></h3>
            <form method="POST" action="/bookjuck/admin/qna/editok.do">
           		<table class="table tbl-md" id="edittbl">
           			<tr>
           				<th>답변내용</th>
           			</tr>
           			<tr>
           				<td>
            				<textarea id="answerContent" name="answerContent" class="form-control" cols="40" rows="15" style="width:100%;">${dto.answerContent}</textarea>
            			</td>
            		</tr>
           		</table>
           		<input type="hidden" id="seqQuestion" name="seqQuestion" value=${dto.seqQuestion}>
           		<input type="hidden" id="seq" name="seq" value=${dto.seq}>
           		<div id="btn">
               		<input type="submit" class="btn btn-general" value="저장하기">
               		<button type="button" class="btn btn-general inline" id="back" onclick="location.href='/bookjuck/admin/qna/detail.do?seq=${dto.seqQuestion}'">뒤로가기</button>
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