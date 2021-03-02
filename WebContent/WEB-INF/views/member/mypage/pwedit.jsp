<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/pwedit.css">


<style>

</style>
</head>

<body>



	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


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
			<h3>비밀번호 변경</h3>
				<!-- <div id="contentBox"> -->
					<form action="/bookjuck/member/mypage/pweditok.do" id="pwEditForm">
						<table class="table table" id="tbl1">
							<tr>
								<th>현재 비밀번호: </th>
								<td><input type="password" id="npw" name="npw" maxlength="20" class="medium"></td>
							</tr>
							<tr>
								<th>변경 비밀번호: </th>
								<td><input type="password" id="pw" name="pw" maxlength="20" class="medium"></td>
							</tr>
							<tr>
								<th>재확인 비밀번호: </th>
								<td><input type="password" id="cpw" name="cpw" maxlength="20" class="medium"></td>
							</tr>
						</table>
							
							<input type="button" class="btn-general" value="취 소" onclick="home()">						
							<input type="submit" class="btn-general" value="수 정">						
							
							<input type="hidden" name="id" value="${id}">
					</form>
				<!-- </div> -->			
      		</article>
		</section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	
	
	
<script type="text/javascript">
	
/*비밀번호 중복 검사*/
$("#pwEditForm").submit(function(evt) {
	
	//계정 비밀번호
	var rpw = "${pw}";
	
	//비밀번호 재확인 중복 검사
	if ($("#pw").val() != $("#cpw").val()) {
		alert("암호가 일치하지 않습니다.");
		evt.preventDefault();
		return false; 
	//계정 비밀번호 검사
	}else if($("#npw").val() != rpw){
		alert("현재 비밀번호가 틀렸습니다.");
		evt.preventDefault();
		return false;
		
	}		
});	
	
	
	
function home(){
	location.href="http://localhost:8090/bookjuck/member/mypage.do";
}

</script>

</body>

</html>