<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::회원정보 조회| MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/custinfo.css">



<style>
</style>
</head>

<body>



	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>

	<!-- container 시작 -->
	<div class="container">
	
		<!-- ########## 상단 헤더 시작 -->
		<!-- 변경 전 -->
	<%-- <%@include file="/WEB-INF/views/member/inc/header.jsp" %> --%>

	<!-- 변경 후 -->
	<%
		out.flush();
		RequestDispatcher dheader = request.getRequestDispatcher("/member/inc/header.do");
		dheader.include(request, response);
	%>
		<!-- ########## 상단 헤더 끝 -->
	
	
		<!-- 마이페이지 side bar -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		
		
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
		<section class="contentsection">
			<article>
				<h3>회원정보 조회</h3>

				<h5>아이디 정보</h5>
				<form action="/bookjuck/member/mypage/custinfoedit.do" method="GET">
				<table class="createId table tbl-md" id="idtbl">


					<tr>
						<th width="300">아이디:</th>
						<td colspan="1">${id}</td>
						<td></td>
					</tr>
					<tr>
						<th>비밀번호:</th>
						<td>${pw}</td>
						<td></td>
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
				<td>${name}</td>
			</tr>
			<tr>
				<th>성별:</th>
				<td>
					
					<c:if test="${ssn.substring(7,8) eq '1'}">
						남자
					</c:if>
					
					<c:if test="${ssn.substring(7,8) eq '2'}">
						여자
					</c:if> 
				</td>
			</tr>
			<tr>
				<th>주민번호:</th>
				<td>${ssn}</td>
			</tr>
			<tr>
				<th>주소:</th>
				<td>${address}</td>
			</tr>
			<tr>
				<th>E-Mail:</th>
				<td>${email}</td>
			</tr>
			<tr>
				<th>연락처:</th>
				<td>0${tel}</td>
			</tr>
			<tr>
				<th>큐레이션레터 서비스:</th>
				<td>${curation}</label></td>
			</tr>
			<tr>
				<th>개인정보 유효 기간</th>
				<td>${privacy}년</td>
			</tr>		
		</table>
		<input type="submit" class="btn btn-general" id="submit-btn" value="수정">
		</form>
      		</article>
		</section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	<!-- container 종료 -->
	
	

</body>

</html>