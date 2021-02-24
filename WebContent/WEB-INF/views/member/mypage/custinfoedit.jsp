<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::회원정보 수정| MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/custinfo.css">


<style>

</style>
</head>

<body>



	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp"%>


	<div class="container">

		<!-- ########## 상단 헤더 시작 -->
		<%@include file="/WEB-INF/views/member/inc/header.jsp"%>
		<!-- ########## 상단 헤더 끝 -->


		<!-- 마이페이지 side bar -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp"%>



		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
		<section class="contentsection">
			<article>
				<h3>회원정보 수정</h3>

				<h5>아이디 정보</h5>
				<form action="" method="GET">
				<table class="table table tbl-md" id="editidtbl">
					<tr>
						<th width="250">아이디:</th>
						<td colspan="1">
							TEST001
						</td>
						<td></td>
					</tr>
					<tr>
						<th>비밀번호:</th>
						<td>
							<input type="password" class="info-md" maxlength="20" required>
						</td>
						<td>
							<a>[비밀번호 보기]</a>
						</td>
					</tr>
					<tr>
						<th>비밀번호 재확인:</th>
						<td>
							<input type="password" class="info-md" maxlength="20" required>
							<p>비밀번호 안전 등급 표기 위치</p>
						</td>
						<td>
							<a>[유의사항]</a>
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
				<td><input type="text" class="info-lg" placeholder="" required></td>
			</tr>
			<tr>
				<th>E-Mail:</th>
				<td><input type="text" class="info-sm" required><span>@</span><input
					type="text" class="info-md" required> <select class="selectpicker">
						<option>구글</option>
						<option>네이버</option>
						<option>다음</option>
						<option>직접입력</option>
				</select></td>
			</tr>
			<tr>
				<th>연락처:</th>
				<td><input type="text" class="info-sm" maxlength="3" required><span>-</span><input
								type="text" class="info-sm" maxlength="4" required><span>-</span><input
								type="text" class="info-sm" maxlength="4" required></td>
			</tr>
			<tr>
				<th>큐레이션레터 서비스:</th>
				<td> <label>구독<input type="radio" name="subscriptBtn" checked></label><label>비구독<input type="radio" name="subscriptBtn"></label></td>
			</tr>
			<tr>
				<th>개인정보 유효 기간</th>
				<td> <label>1년<input type="radio" name="term" checked></label><label>2년<input type="radio" name="term" cheked value="3"></label><label>5년<input type="radio" name="term" cheked value="3"></label><label>10년<input type="radio" name="term" cheked value="3"></label></td>
			</tr>		
		</table>
		<input type="submit" class="btn btn-general" id="submit-btn" value="수 정">
		</form>
	
			</article>
		</section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- ########## 하단 끝 -->

	</div>



</body>

</html>