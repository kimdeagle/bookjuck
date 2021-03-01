<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String seq = request.getParameter("seq");
	String ssn = request.getParameter("ssn");
	String address = request.getParameter("address");
	String email = request.getParameter("email");
	String tel = request.getParameter("tel");
	String curation = request.getParameter("curation");
	String privacy = request.getParameter("privacy");
	String pw = request.getParameter("pw");
	String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp"%>
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/custmng.css">
<style type="text/css">
</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp"%>


		<section class="contentsection">
			<article>
				<h3>회원정보 조회</h3>

				<h5>아이디 정보</h5>
				<form action="" method="GET">
				<table class="createId table" id="idtbl">


					<tr>
						<th width="300">아이디:</th>
						<td colspan="1">
							<%= id%>
						</td>
						<td></td>
					</tr>
					<tr>
						<th>비밀번호:</th>
						<td>
							<%= pw%>
						</td>
						<td>
							<a>[비밀번호 보기]</a>
						</td>
					</tr>
					
				<!-- 	<tr>
						<td rowspan="3">비밀번호 안전 등급 표기 위치</td>
						<td></td>
						<td></td>
					</tr> -->
				</table>

				<h5>기본 정보</h5>
				<table class="createId table" id="test001">
			<tr>
				<th>이름:</th>
				<td><%= name %></td>
			</tr>
			<tr>
				<th>성별:</th>
				<td>남자</td>
			</tr>
			<tr>
				<th>주민번호:</th>
				<td><%= ssn%></td>
			</tr>
			<tr>
				<th>주소:</th>
				<td><%= address%></td>
			</tr>
			<tr>
				<th>E-Mail:</th>
				<td><%= email%></td>
			</tr>
			<tr>
				<th>연락처:</th>
				<td>0<%= tel%></td>
			</tr>
			<tr>
				<th>큐레이션레터 서비스:</th>
				<td><%= curation%></td>
			</tr>
			<tr>
				<th>개인정보 유효 기간</th>
				<td><%= privacy%>년</td>
			</tr>		
		</table>
			<!-- <input type="submit" class="btn btn-general" id="submit-btn" value="수정"> -->
		</form>
      		</article>
		</section>
	</div>
	<!-- container 종료 -->

	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp"%>
	<%@include file="/WEB-INF/views/common/top.jsp"%>


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<!-- ########## 하단 끝 -->




	<script>
		$(document).ready(function() {
			//최상단 체크박스 클릭
			$("#allCheck").click(function() {
				//클릭되었으면
				if ($("#allCheck").prop("checked")) {
					//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
					$("input[name=chk]").prop("checked", true);

					//클릭이 안되있으면
				} else {
					//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
					$("input[name=chk]").prop("checked", false);
				}
			})
		})
		
		
		
		
		
		
		/* $(function(){
		$("#selbox").change(function() {
				if($("#selbox").val() == "direct") {
					$("#selboxDirect").show();
				}  else {
					$("#selboxDirect").hide();
				}
			}) 
		}); */
	</script>
</body>
</html>