<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>북적북적_member::로그인</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>

<link rel="stylesheet" href="/bookjuck/css/login.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">

<style type="text/css">
</style>
</head>

<body>

	<!-- container 시작 -->
	<div id="container">

		<!-- 로고  -->
		<div id="logo">
			<img src="/bookjuck/image/bookjeok/logo.png">
		</div>


		<!-- content 시작 -->
		<div id="content">

			<div id="switchBox">

				<!-- 회원 로그인  버튼 -->
				<div id="memberbtn" class="switchBoxs float-left">
					<h5>회원로그인</h5>
				</div>

				<!-- 비회원 주문 조회 버튼 -->
				<div id="nonMbtn" class="switchBoxs float-left">
					<h5>비회원 주문 조회</h5>
				</div>
			</div>


			<!-- 회원 로그인 Form -->
			<form action="loginok.jsp" method="POST" id="loginForm">

				<div id="login">

					<input type="text" name="id" id="id" class="form-control noline medium inline" maxlength="15" placeholder="아이디를 입력해주세요"> 
					<input type="password" name="pw" id="pw" class="form-control noline medium inline" maxlength="20" placeholder="비밀번호를 입력해주세요.">

					<div id="loginsub">
						<a href="http://localhost:8090/bookjuck/member/tos.do">회원가입</a> <span>|</span>
						<a href="#idFind" data-toggle="modal">아이디 찾기</a> 
						<span>|</span> 
						<a href="#pwFind" data-toggle="modal">비밀번호 찾기</a>
					</div>

					<div id="socialLogin">
						<img alt="" src="/bookjuck/image/social/w_login_g.jpg"> 
						<img alt="" src="/bookjuck/image/social/w_login_n.jpg"> 
						<img alt="" src="/bookjuck/image/social/w_login_k.jpg">
					</div>

					<div id="loginBox">

						<input type="submit" class="btn btn-general" id="loginbtn"
							value="로그인">
					</div>
				</div>

			</form>
			<!-- 회원 로그인 Form 종료-->


			<!-- 비회원 주문 조회 -->
			<form action="nonMemberSearch.jsp" method="POST" id="nmLoginForm">
				<div id="nmLogin" style="display: none">
					<input type="text" name="id" id="id" class="form-control noline medium inline" placeholder="E-Mail을 입력해주세요"> 
					<input type="text" name="id" id="id" class="form-control noline medium inline" placeholder="연락처를 입력해주세요"> 
					<input type="text" name="id" id="id" class="form-control noline medium inline" placeholder="비밀번호를 입력해주세요"> 
					<input type="submit" class="btn btn-general" id="loginbtn" value="주문 조회">
				</div>
			</form>
			<!-- 비회원 주문 조회 종료-->

			<div>
				<address>
					<a>고객센터</a>
					<p>
						Copyright © <b>BookJeok</b> Corp. All Rights Reserved.
					</p>
				</address>
			</div>
			

		</div>
		<!-- ######content 종료  -->
	</div>
	<!-- ######container 종료 -->



	<!--##### 아이디 찾기 모달  -->
	<div class="modal fade" id="idFind" role="dialog">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<!-- 모달 해더 시작 -->			
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">아이디찾기</h4>
					<hr>
					<table id="idFindTbl">
						<tr>
							<th>이름:</th>
							<td><input type="text"></td>
						</tr>
					</table>
				</div>
				<!-- 모달 해더 끝 -->

				<!-- 모달 바디 시작 -->
				<div class="modal-body relative">
					<div id="idFindSwitch">
						<div class="idFindSwitchs float-left" id="ssn">주민번호</div>
						<div class="idFindSwitchs float-left" id="tel">휴대번호</div>
						<div class="idFindSwitchs" id="email">이메일</div>
					</div>
					<div class="idFindSwitchContent relative" id="ssnContent">
						<div class="float-left">
							주민번호: <input type="text" class="log-md"><span>-</span><input
								type="text" class="log-md">
						</div>
						<div>
							<input type="button" class="btn-general" value="확    인">
						</div>
					</div>
					<div class="idFindSwitchContent relative" id="telContent">
						<div class="float-left">
							연락처: <input type="text" class="log-sm" maxlength="3"><span>-</span><input
								type="text" class="log-sm" maxlength="4"><span>-</span><input
								type="text" class="log-sm" maxlength="4">
						</div>
						<div>
							<input type="button" class="btn-general" value="확    인">
						</div>
					</div>
					<div class="idFindSwitchContent relative" id="emailContent">
						<div class="float-left">
							E-Mail: <input type="text" class="log-sm"><span>@</span><input
								type="text" class="log-md"> <select class="selectpicker">
								<option>구글</option>
								<option>네이버</option>
								<option>다음</option>
								<option>직접입력</option>
							</select>
						</div>
						<input type="button" class="btn-general" value="확    인">
					</div>

				</div>
				<!-- 모달 바디 끝 -->
			</div>
		</div>
	</div>
	<!--##### 아이디 찾기 모달 끝  -->



	<!--##### 비밀번호 찾기 모달  -->
	<div class="modal fade" id="pwFind" role="dialog">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<!-- 모달 해더 시작 -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">비밀번호 찾기</h4>
					<hr>
					<table id="pwFindTbl">
						<tr>
							<th>이름:</th>
							<td><input type="text"></td>
						</tr>
						<tr>
							<th>아이디:</th>
							<td><input type="text"></td>
						</tr>
					</table>
				</div>
				<!-- 모달 해더 끝 -->


				<!-- 모달 바디 시작 -->
				<div class="modal-body relative">
					<div id="idFindSwitch">
						<div class="idFindSwitchs float-left" id="ssnPw">주민번호</div>
						<div class="idFindSwitchs float-left" id="telPw">휴대번호</div>
						<div class="idFindSwitchs" id="emailPw">이메일</div>
					</div>
					<div class="idFindSwitchContent relative" id="ssnContentPw">
						<div class="float-left">
							주민번호: <input type="text" class="log-md"><span>-</span><input
								type="text" class="log-md">
						</div>
						<div>
							<input type="button" class="btn-general" value="확    인">
						</div>
					</div>
					<div class="idFindSwitchContent relative" id="telContentPw">
						<div class="float-left">
							연락처: <input type="text" class="log-sm" maxlength="3"><span>-</span><input
								type="text" class="log-sm" maxlength="4"><span>-</span><input
								type="text" class="log-sm" maxlength="4">
						</div>
						<div>
						<input type="button" class="btn-general" value="확    인">
						</div>
					</div>
					<div class="idFindSwitchContent relative" id="emailContentPw">
						<div class="float-left">
							E-Mail: <input type="text" class="log-sm"><span>@</span><input
								type="text" class="log-md"> <select class="selectpicker">
								<option>구글</option>
								<option>네이버</option>
								<option>다음</option>
								<option>직접입력</option>
							</select>
						</div>
						<input type="button" class="btn-general" value="확    인">
					</div>

				</div>
				<!-- 모달 바디 끝 -->
			</div>
		</div>
	</div>
	<!--##### 비밀번호 찾기 모달 끝  -->


	<!-- 스크립트 -->
	<script>
		/* 회원,비회원 전환 스크립트  시작*/
		var memberbtn = document.getElementById('memberbtn');
		var nonMbtn = document.getElementById('nonMbtn');

		var login = document.getElementById('login');
		var nmlogin = document.getElementById('nmlogin');

		nonMbtn.addEventListener('mousedown', function(e) {

			nmLogin.style.display = 'block';
			login.style.display = 'none';

		});

		memberbtn.addEventListener('mousedown', function(e) {

			nmLogin.style.display = 'none';
			login.style.display = 'block';
		});
		/* 회원,비회원 전환 스크립트  끝*/

		/* 아이디 찾기  전환 스크립트 시작  */
		var ssn = document.getElementById('ssn');
		var tel = document.getElementById('tel');
		var email = document.getElementById('email');

		var ssnContent = document.getElementById('ssnContent');
		var telContent = document.getElementById('telContent');
		var emailContent = document.getElementById('emailContent');
	
		ssn.addEventListener('mousedown', function(e) {
			
			ssnContent.style.display = 'block';
			telContent.style.display = 'none';
			emailContent.style.display = 'none';
			
		});

		tel.addEventListener('mousedown', function(e) {

			ssnContent.style.display = 'none';
			telContent.style.display = 'block';
			emailContent.style.display = 'none';

		});

		email.addEventListener('mousedown', function(e) {

			ssnContent.style.display = 'none';
			telContent.style.display = 'none';
			emailContent.style.display = 'block';

		});
		/* 아이디 찾기  전환 스크립트 끝  */
		
		
		
		
		/*비밀번호 찾기 전화 스크립트 시작*/
		var ssnPw = document.getElementById('ssnPw');
		var telPw = document.getElementById('telPw');
		var emailPw = document.getElementById('emailPw');

		var ssnContentPw = document.getElementById('ssnContentPw');
		var telContentPw = document.getElementById('telContentPw');
		var emailContentPw = document.getElementById('emailContentPw');
	
		ssnPw.addEventListener('mousedown', function(e) {
			
			ssnContentPw.style.display = 'block';
			telContentPw.style.display = 'none';
			emailContentPw.style.display = 'none';
			
		});

		telPw.addEventListener('mousedown', function(e) {

			ssnContentPw.style.display = 'none';
			telContentPw.style.display = 'block';
			emailContentPw.style.display = 'none';

		});

		emailPw.addEventListener('mousedown', function(e) {

			ssnContentPw.style.display = 'none';
			telContentPw.style.display = 'none';
			emailContentPw.style.display = 'block';

		});
		
		/*비밀번호 찾기 전화 스크립트 끝*/
		
		
		/*배경 container */
		$(window).resize(function() {
		$("#container").height($(document).height());
	});
	$("#container").height($(document).height());
	</script>
</body>

</html>