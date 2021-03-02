<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 다음 주소 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String ssn1 = request.getParameter("ssn1");
	String ssn2 = request.getParameter("ssn2");
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
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
		<img src="/bookjuck/image/bookjeok/logo.png" onclick="home()">
	</div>
	
	<!-- form 시작 -->
	
	
	<form action="/bookjuck/member/registerok.do" method="POST" id="registerForm"  class="form-md">
		<h2>회원가입</h2>
		<hr>
		
		<!-- 회원 아이디 정보 입력  시작-->
		<h4>회원 아이디 정보</h4>

		<table class="createId table">
			<tr>
				<th style="width: 60px;"><br>아이디:</th>
				<td>
					<input type="text" class="log-md" id="id" name="id" maxlength="15" required><br>
					<span id="result" style="color: red;"></span>
				</td>
				<td><input type="button" class="btn-general" id="idCheck" value="중복확인"></td>
				
			</tr>
			<tr>
				<th>비밀번호:</th>
				<td><input type="password" class="log-md" id="pw" name="pw" maxlength="20" required></td>
				<td><a>[비밀번호 보기]</a></td>
			</tr>
			<tr>
				<th>비밀번호 재확인:</th>
				<td><input type="password" class="log-md" id="cpw" name="cpw" maxlength="20" required></td>
				<td><a>[유의사항]</a></td>
			</tr>
			
		</table>
		<!-- 회원 아이디 정보 입력  끝-->
	
		<!-- 기본 입력 사항 시작 -->
		<hr>
		<h4>기본입력 사항</h4>
		<table class="createId table" id="test001">
			<tr>
				<th>이름:</th>
				<td><input type="text" class="log-md"></td>
			</tr>
			<tr>
				<th>성별:</th>
				<td>
					<label>여자<input type="radio" name="gender"  value="1" checked></label>
					<label>남자<input type="radio" name="gender"  value="2"></label>
				</td>
			</tr>
			<tr>
				<th>주민번호:</th>
				<td>
					<input type="text" class="log-sm"><span>- </span><input type="text" class="log-sm">
				</td>
			</tr>
			<tr>
				<th>주소:</th>
				<td>
					<input type="text" id="sample6_postcode" name="sample6_postcode" placeholder="우편번호" required>
					<input type="button" onclick="sample6_execDaumPostcode()" value="찾기"><br>
					<input type="text" id="sample6_address" name="sample6_address" placeholder="주소" required><br>
					<input type="text" id="sample6_detailAddress" name="sample6_detailAddress" placeholder="상세주소" required>
					<input type="text" id="sample6_extraAddress" name="sample6_extraAddress" placeholder="참고항목" required>
				</td>
			</tr>
			<tr>
				<th>E-Mail:</th>
				<td><input type="text" class="log-sm"><span>@</span><input type="text" class="log-md"></td>
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
					 <label>구독<input type="radio" name="subscript" value="1" checked></label>
					 <label>비구독<input type="radio" name="subscript" value="0"></label>
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
		<input type="hidden" name="email1" value="<%=email1%>">
		<input type="hidden" name="email2" value="<%=email2%>">
		
	</form>
	<!-- form 끝 -->
	
			<div id="footer">
				<a href="/bookjuck/member/notice/list.do">고객센터</a>
					<p>
						Copyright ©
						<b>BookJuck</b>
						Corp. All Rights Reserved.
					</p>
				
			</div>
</div>
<!-- container 끝 -->



<script>
	
	/*배경 container 시작*/
	$(window).resize(function() {
		$("#container").height($(document).height());
	});
	$("#container").height($(document).height());
	/*배경 container 종료*/
	
	
	/*중복검사 시작*/
	$("#idCheck").click(function() {
	
		$.ajax({
			type: "GET",
			url: "/bookjuck/member/idcheckok.do",
			data: "id=" + $("#id").val(),
			success: function(result) {
				console.log('test');
				if (result == 1) {
					$("#result").css("color", "red");
					$("#result").text("이미 사용중인 아이디입니다.");
				} else {
					$("#result").css("color", "blue");
					$("#result").text("사용 가능한 아이디입니다.");
				}
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
		
	});
	/*중복검사 종료*/
	
	
	/*로고 HOME으로*/
	function home(){
		location.href="http://localhost:8090/bookjuck/index.do";
	}
	
	/*다음 주소 */
	function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
	
	
	/*비밀번호 중복 검사*/
	$("#registerForm").submit(function(evt) {
			
		if ($("#pw").val() != $("#cpw").val()) {
			alert("암호가 일치하지 않습니다.");
			
			evt.preventDefault();
			return false; 
		}
		
	});
</script>
</body>
</html>