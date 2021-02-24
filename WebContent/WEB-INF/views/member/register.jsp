<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String ssn1 = request.getParameter("ssn1");
	String ssn2 = request.getParameter("ssn2");
	
		
%>
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
	
	<!-- <form action="/bookjuck/member/registerok.do" method="POST" id="registerForm" enctype="multipart/form-data" class="form-md"> -->
	<form action="/bookjuck/member/registerok.do" method="POST" id="registerForm"  class="form-md">
		<h2>회원가입</h2>
		<hr>
		
		<!-- 회원 아이디 정보 입력  시작-->
		<h4>회원 아이디 정보</h4>

		<table class="createId table">
			<tr>
				<th>아이디:</th>
				<td><input type="text" class="log-md" name="id" required></td>
				<td><input type="button" class="btn-general" value="중복확인"></td>
			</tr>
			<tr>
				<th>비밀번호:</th>
				<td><input type="password" class="log-md" id="pw" name="pw" required></td>
				<td><a>[비밀번호 보기]</a></td>
			</tr>
			<tr>
				<th>비밀번호 재확인:</th>
				<td><input type="password" class="log-md" id="cpw" name="cpw" required></td>
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
				<td><%= name%></td>
			</tr>
			<tr>
				<th>성별:</th>
				<td>남자</td>
			</tr>
			<tr>
				<th>주민번호:</th>
				<td>
					<%=ssn1%><span>- </span><%=ssn2%>
				</td>
			</tr>
			<tr>
				<th>주소:</th>
				<td><input type="text" class="log-lg" placeholder="주소 API 결정되면 수정하겠습니다." id="address" name="address"></td>
			</tr>
			<tr>
				<th>E-Mail:</th>
				<td><input type="text" class="log-sm" id="email1" name="email1"><span>@</span><input type="text" class="log-md" id="email2" name="email2"> <!-- <select class="selectpicker">
						<option>구글</option>
						<option>네이버</option>
						<option>다음</option>
						<option>직접입력</option>
				</select> --></td>
			</tr>
			<tr>
				<th>연락처:</th>
				<td>	
					<input type="text" class="log-sm" id="tel1" name="tel1" maxlength="3">
					<span>-</span>
					<input type="text" class="log-sm" id="tel2" name="tel2" maxlength="4">
					<span>-</span>
					<input type="text" class="log-sm" id="tel3" name="tel3" maxlength="4">
				</td>
			</tr>
			<tr>
				<th>큐레이션레터 서비스:</th>
				<td> 
					 <label>구독<input type="radio" name="subscript" value="on" checked></label>
					 <label>비구독<input type="radio" name="subscript" value="off"></label>
				</td>
			</tr>
			<tr>
				<th>개인정보 유효 기간</th>
				<td> 
					<label>1년<input type="radio" name="privacy"  value="1" checked></label>
					<label>2년<input type="radio" name="privacy"  value="2"></label>
					<label>5년<input type="radio" name="privacy"  value="5"></label>
					<label>10년<input type="radio" name="privacy" value="10"></label>
				</td>
			</tr>		
		</table>
		<!-- 기본 입력 사항 끝 -->
		
		<input type="submit" class="btn btn-general" id="loginbtn" value="확 인">
		
		<input type="hidden" name="ssn1" value="<%=ssn1%>">
		<input type="hidden" name="ssn2" value="<%=ssn2%>">
		<input type="hidden" name="name" value="<%=name%>">
		
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