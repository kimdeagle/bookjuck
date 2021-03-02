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
				<form action="/bookjuck/member/mypage/custinfoeditok.do" method="GET" id="custinfo">
				<table class="table table tbl-md" id="editidtbl">
					<tr>
						<th width="290">아이디:</th>
						<td colspan="1">
							${id }
						</td>
						<td></td>
					</tr>
					<tr>
						<th>비밀번호:</th>
						<td >
							<input type="password" id ="pw" name="pw" class="info-md" maxlength="20" required>
						</td>
						<td>
							<a id="pwview" onmouseover="over()">[비밀번호 보기]</a>
						</td>
					</tr>
					<tr>
						<th>비밀번호 재확인:</th>
						<td>
							<input type="password" id ="cpw" name="cpw" class="info-md" maxlength="20" required>
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
				<td><input type="text" id="address" name="address" class="info-lg" placeholder="${address}" required></td>
			</tr>
			<tr>
				<th>E-Mail:</th>
				<td><input type="email" id="email" name="email" class="info-lg" placeholder="${email}" required>					
			</tr>
			<tr>
				<th>연락처:</th>
				<td><input type="text" id="tel" name="tel" class="info-lg" maxlength="11" placeholder="0${tel}" required></td>
			</tr>
			<tr>
				<th>큐레이션레터 서비스:</th>
				<td> 
					 <label>구독<input type="radio" name="subscriptBtn" value="구독" checked></label>
					 <label>비구독<input type="radio" name="subscriptBtn" value="비구독"></label>
			    </td>
			</tr>
			<tr>
				<th>개인정보 유효 기간</th>
				<td> 
					<label>1년<input type="radio" name="term"  value="1" checked></label>
				    <label>2년<input type="radio" name="term"  value="2"></label>
				    <label>5년<input type="radio" name="term"  value="5"></label>
				    <label>10년<input type="radio" name="term" value="10"></label>
				</td>
			</tr>		
		</table>
		<input type="submit" class="btn btn-general" id="submit-btn" value="확   인">
		
		<input type="hidden" name="id" value="${id}">
		
		</form>
	
			</article>
		</section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- ########## 하단 끝 -->

	</div>


<script type="text/javascript">
	
	/*비밀번호 중복 검사*/
	$("#custinfo").submit(function(evt) {
		
		//계정 비밀번호
		var rpw = "${pw}";
		
		//비밀번호 재확인 중복 검사
		if ($("#pw").val() != $("#cpw").val()) {
			alert("암호가 일치하지 않습니다.");
			evt.preventDefault();
			return false; 
		//계정 비밀번호 검사
		}else if($("#pw").val() != rpw){
			alert("계정 비밀번호가 틀렸습니다.");
			evt.preventDefault();
			return false;
			
		}		
	});

	/*비밀번호 보기*/
	/* function over(){
		alert('test');
   	 	$("#pwview").prop("type", "text");
    } */
</script>


</body>

</html>