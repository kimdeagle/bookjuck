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
        <h3>자주 하는 질문<small>수정하기</small></h3>
           	<form method="POST" action="/bookjuck/admin/faq/editok.do">
           		<table class="table tbl-md" id="edittbl">
           			<tr>
           				<th class="col-md-2">질문카테고리</th>
           				<td class="col-md-10">
           					<select class="form-control selectpicker medium" id="seqQcategory" name="seqQcategory">
								<option value=${dto.seqQcategory}>${dto.qCategory}</option>
							</select>
						</td>
           			</tr>
           			<tr>
           				<th class="col-md-2">제목</th>
           				<td class="col-md-10"><input type="text" id="title" name="title" class="form-control inline" value="${dto.title}"></td>
           			</tr>
           			<tr>
           				<th>내용</th>
           				<td colspan="2">
           					<textarea id="content" name="content" class="form-control" cols="40" rows="15" style="width:100%;">${dto.content}</textarea>
           				</td>
           			</tr>
           		</table>
				<input type="hidden" id="seq" name="seq" value=${dto.seq}>
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

	<script>

        $('#category li > a').on('click', function() {
            // 버튼에 선택된 항목 텍스트 넣기 
            $('#selected').text($(this).text());
            // 수정할 때 카테고리 변경 반영되도록 수정
            $('#qcategory').val($(this).text());
        });

    </script>

</body>

</html>