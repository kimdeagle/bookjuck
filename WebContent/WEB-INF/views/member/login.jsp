<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>북적북적_member::로그인</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>

<link rel="stylesheet" href="/bookjuck/css/login.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<!-- 구글 -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="743921267192-oka0vtqtlbvgk911f5d4eth8kgur8nvl.apps.googleusercontent.com">
<!-- 카카오 -->
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<!-- 네이버 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>


<style type="text/css">
</style>
</head>

<body>

	<!-- container 시작 -->
	<div id="container">

		<!-- 로고  -->
		<div id="logo">
			<img src="/bookjuck/image/bookjeok/logo.png" onclick="home()">
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
			<div id="login">

				<form action="/bookjuck/member/loginok.do" method="POST" id="loginForm">
					<input type="text" name="id" id="id" class="form-control noline medium inline" maxlength="15" placeholder="아이디를 입력해주세요">
					<input type="password" name="pw" id="pw" class="form-control noline medium inline" maxlength="20" placeholder="비밀번호를 입력해주세요.">

					<div id="loginsub">
						<a href="http://localhost:8090/bookjuck/member/tos.do">회원가입</a>
						<span>|</span>
						<a href="#idFind" data-toggle="modal">아이디 찾기</a>
						<span>|</span>
						<a href="#pwFind" data-toggle="modal">비밀번호 찾기</a>
					</div>

					<div id="socialLogin">
					

						<!-- 구글 로그인 버튼 -->
						<!-- <div class="g-signin2" data-onsuccess="onSignIn"></div> --> 
						
						
						<!-- <img src="/bookjuck/image/social/w_login_g.jpg"  class="socialBtn" onClick="onSignIn(googleUser)"> -->
						<img src="/bookjuck/image/social/w_login_g.jpg"  class="socialBtn" onClick="google()">
						<!-- 카카오 로그인 버튼 -->
						<img src="/bookjuck/image/social/w_login_k.jpg" class="socialBtn" id="kakao-login-btn" onClick="kakao()">
						<!-- <a href="http://developers.kakao.com/logout">카카오 로그아웃</a> -->
						
						<!-- 네이버 로그인 버튼 -->
						<img src="/bookjuck/image/social/w_login_n.jpg" class="socialBtn" onclick="document.getElementByID(naver_id_login').click;">
						<!-- <div class="socialBtn" onclick="document.getElementByID(naver_id_login').click;"></div> -->
						<div id="naver_id_login"></div>
						
						<!-- <input type="button" value="로그아웃" onclick="location.href='/logout'"> -->

					</div>

					<div id="loginBox">
						<input type="submit" class="btn btn-general" id="loginbtn" value="로그인">
					</div>
				</form>
			</div>

			<!-- 회원 로그인 Form 종료-->


			<!-- 비회원 주문 조회 -->
			<form action="/bookjuck/member/nonmemberlogin.do" method="POST" id="nmLoginForm">
				<div id="nmLogin" style="display: none">
					<input type="text" name="nmEmail" id="nmEmail" class="nmiput form-control noline medium inline" placeholder="E-Mail을 입력해주세요" required>
					<input type="text" name="nmTel" id="nmTel" class="nmiput form-control noline medium inline" placeholder="연락처를 입력해주세요" required>
					<input type="password" name="nmPw" id="nmPw" class="nmiput form-control noline medium inline" placeholder="비밀번호를 입력해주세요" required>
					<input type="submit" class="nmiput btn btn-general" id="loginbtn" value="주문 조회">
				</div>
			</form>
			<!-- 비회원 주문 조회 종료-->

			<div id="foot">
				<address>
					<a href="/bookjuck/member/notice/list.do">고객센터</a>
					<p>
						Copyright ©
						<b>BookJuck</b>
						Corp. All Rights Reserved.
					</p>
				</address>
			</div>


		</div>
		<!-- ######content 종료  -->
	</div>
	<!-- ######container 종료 -->

ㅋ

	<!--##### 아이디 찾기 모달  -->
	
	<div class="modal fade" id="idFind" role="dialog">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<!-- 모달 해더 시작 -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">아이디찾기</h4>			
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
						<table class="idFindTbl table table">
							<tr>
								<th>이름: </th>
								<td><input type="text" id="name" name="name"></td>
							</tr>
							<tr>
								<th>주민번호: </th>
								<td>
									<input type="text" class="log-md" maxlength="6" id="ssn1" name="ssn1">
									<span>-</span>
									<input type="text" class="log-md" maxlength="7" id="ssn2" name="ssn2"><br>
									<span id="result1"></span>
								</td>
							</tr>							
						</table>
						<input type="button"  class="btn-general" id="idFindSsn" value="확    인">
					</div>
						
						
					<div class="idFindSwitchContent relative" id="telContent">
						<table class="idFindTbl table table">
							<tr>
								<th>이름: </th>
								<td><input type="text" id="name2" name="name2"></td>
							</tr>
							<tr>
								<th>연락처</th>
								<td>
									<input type="text" class="log-sm" maxlength="3" id="tel1" name="tel1">
									<span>-</span>
									<input type="text" class="log-sm" maxlength="4" id="tel2" name="tel2">
									<span>-</span>
									<input type="text" class="log-sm" maxlength="4" id="tel3" name="tel3"><br>
									<span id="result2"></span>
								</td>
							</tr>
						</table>
							<input type="button" class="btn-general" id="idFindTel" value="확    인">						
					</div>
					
					
					<div class="idFindSwitchContent relative" id="emailContent">
						<table class="idFindTbl table table">
							<tr>
								<th>이름: </th>
								<td><input type="text" id="name3" name="name3"></td>
							</tr>
							<tr>
								<th>E-Mail:</th>
								<td>
									<input type="text" class="log-sm" id="email1" name="email1">
									<span>@</span>
									<input type="text" class="log-md" id="email2" name="email2"><br>
									<span id="result3"></span>
								</td>
							</tr>
						</table>
						<input type="button" class="btn-general" id="idFindEmail" value="확    인">
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
						<table class="pwFindTbl table table">
							<tr>
								<th>이름: </th>
								<td><input type="text" id="name4" name="name4"></td>
							</tr>
							<tr>
								<th>아이디: </th>
								<td><input type="text" id="pwFindId1" name="pwFindId1"></td>
							</tr>
							<tr>
								<th>주민번호: </th>
								<td>
									<input type="text" class="log-md" maxlength="6" id="pwSsn1" name="PwSsn1">
									<span>-</span>
									<input type="text" class="log-md" maxlength="7" id="pwSsn2" name="pwSsn2"><br>
									<span id="result4"></span>
								</td>
							</tr>							
						</table>
						<input type="button"  class="btn-general" id="pwFindSsn" value="확    인">
					</div>
					<div class="idFindSwitchContent relative" id="telContentPw">
						<table class="pwFindTbl table table">
							<tr>
								<th>이름: </th>
								<td><input type="text" id="name5" name="name5"></td>
							</tr>
							<tr>
								<th>아이디: </th>
								<td><input type="text" id="pwFindId2" name="pwFindId2"></td>
							</tr>
							<tr>
								<th>연락처: </th>
								<td>
									<input type="text" class="log-sm" maxlength="3" id="pwTel1" name="pwTel1">
									<span>-</span>
									<input type="text" class="log-sm" maxlength="4" id="pwTel2" name="pwTel2">
									<span>-</span>
									<input type="text" class="log-sm" maxlength="4" id="pwTel3" name="pwTel3"><br>
									<span id="result5"></span>
								</td>
							</tr>							
						</table>
						<input type="button"  class="btn-general" id="pwFindTel" value="확    인">					
					</div>
					<div class="idFindSwitchContent relative" id="emailContentPw">
						<table class="pwFindTbl table table">
							<tr>
								<th>이름: </th>
								<td><input type="text" id="name6" name="name6"></td>
							</tr>
							<tr>
								<th>아이디: </th>
								<td><input type="text" id="pwFindId3" name="pwFindId3"></td>
							</tr>
							<tr>
								<th>E-Mail:</th>
								<td>
									<input type="text" class="log-sm" id="pwEmail1" name="pwEmail1">
									<span>@</span>
									<input type="text" class="log-md" id="pwEmail2" name="pwEmail2"><br>									
									<span id="result6"></span>									
								</td>
							</tr>							
						</table>
						<input type="button"  class="btn-general" id="pwFindEmail" value="확    인">
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
			memberbtn.style.backgroundColor = '#ccc';
			nonMbtn.style.backgroundColor = 'white';
		});

		memberbtn.addEventListener('mousedown', function(e) {

			nmLogin.style.display = 'none';
			login.style.display = 'block';
			memberbtn.style.backgroundColor = 'white';
			nonMbtn.style.backgroundColor = '#ccc';
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
			ssn.style.backgroundColor = 'white';
			tel.style.backgroundColor = '#ccc';
			email.style.backgroundColor = '#ccc';
			
			
		});

		tel.addEventListener('mousedown', function(e) {

			ssnContent.style.display = 'none';
			telContent.style.display = 'block';
			emailContent.style.display = 'none';
			ssn.style.backgroundColor = '#ccc';
			tel.style.backgroundColor = 'white';
			email.style.backgroundColor = '#ccc';
		});

		email.addEventListener('mousedown', function(e) {

			ssnContent.style.display = 'none';
			telContent.style.display = 'none';
			emailContent.style.display = 'block';
			ssn.style.backgroundColor = '#ccc';
			tel.style.backgroundColor = '#ccc';
			email.style.backgroundColor = 'white';
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
			ssnPw.style.backgroundColor = 'white';
			telPw.style.backgroundColor = '#ccc';
			emailPw.style.backgroundColor = '#ccc';
		});

		telPw.addEventListener('mousedown', function(e) {

			ssnContentPw.style.display = 'none';
			telContentPw.style.display = 'block';
			emailContentPw.style.display = 'none';
			ssnPw.style.backgroundColor = '#ccc';
			telPw.style.backgroundColor = 'white';
			emailPw.style.backgroundColor = '#ccc';
		});

		emailPw.addEventListener('mousedown', function(e) {

			ssnContentPw.style.display = 'none';
			telContentPw.style.display = 'none';
			emailContentPw.style.display = 'block';
			ssnPw.style.backgroundColor = '#ccc';
			telPw.style.backgroundColor = '#ccc';
			emailPw.style.backgroundColor = 'white';
		});
		
		/*비밀번호 찾기 전화 스크립트 끝*/
		
		
	/*배경 container */
	$(window).resize(function() {
		$("#container").height($(document).height());
	});
	$("#container").height($(document).height());
	
	/*로고 HOME으로*/
	function home(){
		location.href="http://localhost:8090/bookjuck/index.do";
	}
	
	
	/* 구글 로그인  */
	function google() {
		alert(" - 정검중 - ")
		
	function onSignIn(googleUser) {
		
	  		var profile = googleUser.getBasicProfile();
	  		alert(profile.getName())
	  		alert(profile.getEmail())
	  		
		  	 $("form").attr("method","GET").attr("action","/bookjuck/member/register.do?name="+profile.getId()).attr("target","_parent").submit();
	  		console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  		console.log('Name: ' + profile.getName());
		  	console.log('Image URL: ' + profile.getImageUrl());
		  	console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
		  	
		}
	
	}
	
	
	/* 카카오 로그인*/
	Kakao.init('a81cc7fa3bef4c7a26700b30cae18152'); 
	/* Kakao.isInitialized(); */
	console.log(Kakao.isInitialized());
		
   	function kakao() {
	 
	  Kakao.Auth.createLoginButton({
		    container: '#kakao-login-btn',
		    success: function(authObj) {
		      Kakao.API.request({
			        url: '/v2/user/me',
			        success: function(res) {
			       	 /* alert(res.properties.nickname);
			        	alert(res.id);
			        	alert(res.kakao_account.birthday); */
			        	
			        	
			        	/* alert(res.kako-account.email); */
			        	/* alert(res.profile.gender);  */
			        	/* alert(res.has_email.email_needs_agreement); */
			        	 alert(JSON.stringify(res)) 
			        	 
			        	 location.href = "/bookjuck/member/register.do?name="+res.properties.nickname;
			        },
			        fail: function(error) {
			          alert('login success, but failed to request user information: ' + JSON.stringify(error))
			        },
		      })
		    },
		    fail: function(err) {
		      alert('failed to login: ' + JSON.stringify(err))
		    },
	 })
   }
   

   
	/* 네이버 로그인 */
	function name() {
		
		alert(" - 정검중 - ")
		
	  	var state = naver_id_login.getUniqState();
	  	naver_id_login.setButton("white", 2,40);
	  	naver_id_login.setDomain("http://localhost:8090/bookjuck/member/login.do");
	  	naver_id_login.setState(state);
	  	naver_id_login.setPopup();
	  	naver_id_login.init_naver_id_login();
		var naver_id_login = new naver_id_login("5FotIk_OVojgU5ZwiCBF","http://localhost:8090/bookjuck/member/register.do");
	}
	
		
	/*아이디 찾기 ssn*/
	$("#idFindSsn").click(function() {					
			$.ajax({
				type: "GET",
				url: "/bookjuck/member/findssnid.do",
				data: { 
					    name: $("#name").val(),
						ssn1: $("#ssn1").val(),
						ssn2: $("#ssn2").val(),
				      },
				success: function(result) {
				
 					if(result=="null"){
						$("#result1").css("color", "red");
						$("#result1").text("일치하는 정보가 없습니다.");
					}else{
						$("#result1").css("color", "blue");
						$("#result1").text("'"+$("#name").val()+"'님의 ID는 "+result+"입니다.");
					}
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
	});
	
	/*아이디 찾기 tel*/
	$("#idFindTel").click(function() {					
			$.ajax({
				type: "GET",
				url: "/bookjuck/member/findtelid.do",
				data: { 
					    name: $("#name2").val(),
						tel1: $("#tel1").val(),
						tel2: $("#tel2").val(),
						tel3: $("#tel3").val(),
				      },
				success: function(result) {
				
 					if(result=="null"){
						$("#result2").css("color", "red");
						$("#result2").text("일치하는 정보가 없습니다.");
					}else{
						$("#result2").css("color", "blue");
						$("#result2").text("'"+$("#name2").val()+"'님의 ID는 ["+result+"]입니다.");
					}
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
	});
	
	/*아이디 찾기 Email*/
	$("#idFindEmail").click(function() {					
			$.ajax({
				type: "GET",
				url: "/bookjuck/member/findemailid.do",
				data: { 
					    name: $("#name3").val(),
						email1: $("#email1").val(),
						email2: $("#email2").val(),

				      },
				success: function(result) {
				
 					if(result=="null"){
						$("#result3").css("color", "red");
						$("#result3").text("일치하는 정보가 없습니다.");
					}else{
						$("#result3").css("color", "blue");
						$("#result3").text("'"+$("#name3").val()+"'님의 ID는 ["+result+"]입니다.");
					}
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
	}); 
	
	
	/*비밀번호 찾기 Ssn*/
	$("#pwFindSsn").click(function() {					
			$.ajax({
				type: "GET",
				url: "/bookjuck/member/findssnpw.do",
				data: { 
					    name: $("#name4").val(),
					    id: $("#pwFindId1").val(),
						ssn1: $("#pwSsn1").val(),
						ssn2: $("#pwSsn2").val(),

				      },
				success: function(result) {
				
 					if(result=="null"){
						$("#result4").css("color", "red");
						$("#result4").text("일치하는 정보가 없습니다.");
					}else{
						$("#result4").css("color", "blue");
						$("#result4").text("'"+$("#name4").val()+"'님의 PW는 ["+result+"]입니다.");
					}
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
	}); 
	
	/*비밀번호 찾기 Tel*/
	$("#pwFindTel").click(function() {					
			$.ajax({
				type: "GET",
				url: "/bookjuck/member/findtelpw.do",
				data: { 
					    name: $("#name5").val(),
					    id: $("#pwFindId2").val(),
						tel1: $("#pwTel1").val(),
						tel2: $("#pwTel2").val(),
						tel3: $("#pwTel3").val(),

				      },
				success: function(result) {
				
 					if(result=="null"){
						$("#result5").css("color", "red");
						$("#result5").text("일치하는 정보가 없습니다.");
					}else{
						$("#result5").css("color", "blue");
						$("#result5").text("'"+$("#name5").val()+"'님의 PW는 ["+result+"]입니다.");
					}
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
	}); 
	
	
	/*비밀번호 찾기 Email*/
	$("#pwFindEmail").click(function() {					
			$.ajax({
				type: "GET",
				url: "/bookjuck/member/findemailpw.do",
				data: { 
					    name: $("#name6").val(),
					    id: $("#pwFindId3").val(),
						email1: $("#pwEmail1").val(),
						email2: $("#pwEmail2").val(),
							
				      },
				success: function(result) {
					/* location.href: "#idFind"; */
 					if(result=="null"){
						$("#result6").css("color", "red");
						$("#result6").text("일치하는 정보가 없습니다.");
					}else{
						$("#result6").css("color", "blue");
						$("#result6").text("'"+$("#name6").val()+"'님의 PW는 ["+result+"]입니다.");
					}
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
	}); 
	
	
	</script>


	


</body>

</html>