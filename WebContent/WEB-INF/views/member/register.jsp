<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적_member::회원가입</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>

<link rel="stylesheet" href="/bookjuck/css/login.css">
<link rel="stylesheet" href="/bookjuck/css/register.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">

<style type="text/css">
</style>
</head>
<body>



<!-- container 시작 -->
<div id="container">

	<div id="logo">
		<img src="/bookjuck/image/bookjeok/logo.png">
	</div>
	
	<!-- form 시작 -->
	<form action="#" method="POST" id="registerForm"
		class="form-md">
		<h2>회원가입</h2>
		<hr>
		
		<!-- 회원 아이디 정보 입력  시작-->
		<h4>회원 아이디 정보</h4>

		<table class="createId table">
			<tr>
				<th>아이디:</th>
				<td><input type="text" class="log-md" required></td>
				<td><input type="button" class="btn-general" value="중복확인"></td>
			</tr>
			<tr>
				<th>비밀번호:</th>
				<td><input type="password" class="log-md" required></td>
				<td><a>[비밀번호 보기]</a></td>
			</tr>
			<tr>
				<th>비밀번호 재확인:</th>
				<td><input type="password" class="log-md" required></td>
				<td><a>[유의사항]</a></td>
			</tr>
			<tr>
				<td rowspan = "3">비밀번호 안전 등급 표기 위치</td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<!-- 회원 아이디 정보 입력  끝-->
	
		<!-- 기본 입력 사항 시작 -->
		<hr>
		<h4>기본입력 사항</h4>
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
					940123<span>- </span>1122345
				</td>
			</tr>
			<tr>
				<th>주소:</th>
				<td><input type="text" class="log-lg" placeholder="주소 API 결정되면 수정하겠습니다."></td>
			</tr>
			<tr>
				<th>E-Mail:</th>
				<td><input type="text" class="log-sm"><span>@</span><input
					type="text" class="log-md"> <!-- <select class="selectpicker">
						<option>구글</option>
						<option>네이버</option>
						<option>다음</option>
						<option>직접입력</option>
				</select> --></td>
			</tr>
			<tr>
				<th>연락처:</th>
				<td><input type="text" class="log-sm" maxlength="3"><span>-</span><input
								type="text" class="log-sm" maxlength="4"><span>-</span><input
								type="text" class="log-sm" maxlength="4"></td>
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
		<!-- 기본 입력 사항 끝 -->
		
		<input type="submit" class="btn btn-general" id="loginbtn" value="확 인">
	</form>
	<!-- form 끝 -->
	
			<div>
				<address>
					<a>고객센터</a>
					<p>
						Copyright © <b>BookJeok</b> Corp. All Rights Reserved.
					</p>
				</address>
			</div>
</div>
<!-- container 끝 -->



<script>
	//$(document).resize(function() {
	//	$("#container").height($(document).height());
	//}); 
	
	/*배경 container */
	$(window).resize(function() {
		$("#container").height($(document).height());
	});
	$("#container").height($(document).height());
	
	
</script>
</body>
</html>