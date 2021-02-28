<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>


<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/faq.css">

<style>
</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<section class="contentsection">
        <h3>자주 하는 질문<small style="margin-left:15px;">작성하기</small></h3>
            	<form method="POST" action="/bookjuck/admin/faq/addok.do">
            		<table class="table tbl-md" id="addtbl">
            			<tr>
            				<th class="col-md-2">질문카테고리</th>
            				<td class="col-md-10">
            					<select class="form-control selectpicker medium" id="email" name="seqQcategory">
		            				<c:forEach items="${clist}" var="cdto">
		            					<option value=${cdto.seq}>${cdto.category}</option>
		            				</c:forEach>
								</select>
							</td>
            			</tr>
            			<tr>
            				<th class="col-md-2">제목</th>
            				<td class="col-md-10"><input type="text" id="title" name="title" class="form-control inline" placeholder="제목을 입력해주세요"></td>
            			</tr>
            			<tr>
            				<th>내용</th>
            				<td colspan="2">
            					<textarea id="content" name="content" class="form-control" cols="40" rows="15" style="width:100%;" placeholder="내용을 입력해주세요"></textarea>
            				</td>
            			</tr>
            		</table>
					<div id="btn">
					    <input type="submit" class="btn btn-general inline" value="저장하기" id="save">
					    <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/admin/faq/list.do'">뒤로가기</button>
					</div>
            	</form>
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