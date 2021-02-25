<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<form action="" method="GET">
				<table class="createId table" id="idtbl">


					<tr>
						<th width="300">아이디:</th>
						<td colspan="1">
							TEST001
						</td>
						<td></td>
					</tr>
					<tr>
						<th>비밀번호:</th>
						<td>
							********
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
				<td>홍길동</td>
			</tr>
			<tr>
				<th>성별:</th>
				<td>남자</td>
			</tr>
			<tr>
				<th>주민번호:</th>
				<td>
					940123-1122345
				</td>
			</tr>
			<tr>
				<th>주소:</th>
				<td>서울특별시 강남구 역삼동 테헤란로 132</td>
			</tr>
			<tr>
				<th>E-Mail:</th>
				<td>TEST001@gmail.com</td>
			</tr>
			<tr>
				<th>연락처:</th>
				<td>010<span>-</span>1111<span>-</span>1111</td>
			</tr>
			<tr>
				<th>큐레이션레터 서비스:</th>
				<td> 구독</label></td>
			</tr>
			<tr>
				<th>개인정보 유효 기간</th>
				<td> 1년</td>
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