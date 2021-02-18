<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>북적북적_member::로그인</title>
		<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

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

						<input type="text" name="id" id="id" class="form-control noline medium inline" maxlength="15"
							placeholder="아이디를 입력해주세요">
						<input type="password" name="pw" id="pw" class="form-control noline medium inline"
							maxlength="20" placeholder="비밀번호를 입력해주세요.">

						<div id="loginsub">
							<a href="http://localhost:8090/bookjuck/member/tos.do">회원가입</a><span>|</span> <a
								href="#idFind" data-toggle="modal">아이디 찾기</a><span>|</span> <a href="">비밀번호 찾기</a>
						</div>

						<div id="socialLogin">
							<img alt="" src="/bookjuck/image/social/w_login_g.jpg">
							<img alt="" src="/bookjuck/image/social/w_login_n.jpg">
							<img alt="" src="/bookjuck/image/social/w_login_k.jpg">
						</div>

						<div id="loginBox">

							<input type="submit" class="btn btn-general" id="loginbtn" value="로그인">
						</div>
					</div>

				</form>
				<!-- 회원 로그인 Form 종료-->


				<!-- 비회원 주문 조회 -->
				<form action="nonMemberSearch.jsp" method="POST" id="nmLoginForm">
					<div id="nmLogin" style="display: none">
						<input type="text" name="id" id="id" class="form-control noline medium inline"
							placeholder="E-Mail을 입력해주세요">
						<input type="text" name="id" id="id" class="form-control noline medium inline"
							placeholder="연락처를 입력해주세요">
						<input type="text" name="id" id="id" class="form-control noline medium inline"
							placeholder="비밀번호를 입력해주세요">
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
			<!-- ######내용 종료  -->
		</div>
		<!-- ######컨테이너 종료 -->



		<!--##### 아이디 찾기 모달  -->
		<div class="modal fade" id="idFind" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">아이디찾기</h4>
						<hr>
						<table id="idFindTbl">
							<tr>
								<th>이름: </th>
								<td><input type="text"></td>
							</tr>
						</table>
					</div>

					<!-- 모달 바디 시작 -->
					<div class="modal-body relative">
						<div id="idFindSwitch">
							<div class="idFindSwitchs float-left" id="ssn">주민번호</div>
							<div class="idFindSwitchs float-left" id="tel">휴대번호</div>
							<div class="idFindSwitchs" id="email">이메일</div>
						</div>
						<div class="idFindSwitchContent relative" id="ssnContent">
							<div class="float-left">주민번호</div>
							<div><input type="text"></div>
						</div>
						<div class="idFindSwitchContent absolute" id="telContent">

						</div>
						<div class="idFindSwitchContent absolute" id="emailContent">

						</div>

					</div>
					<!-- 모달 바디 끝 -->
				</div>
			</div>
		</div>
		<!--#####관심 설정 모달 끝  -->


		<!-- 스크립트 -->
		<script>
			var memberbtn = document.getElementById('memberbtn');
			var nonMbtn = document.getElementById('nonMbtn');

			var login = document.getElementById('login');


			/* 비회원 전환 스크립트  시작*/
			nonMbtn.addEventListener('mousedown', function (e) {

				nmLogin.style.display = 'block';
				login.style.display = 'none';

			});

			memberbtn.addEventListener('mousedown', function (e) {

				nmLogin.style.display = 'none';
				login.style.display = 'block';
			});
		/* 비회원 전환 스크립트  끝*/


		</script>
	</body>

	</html>