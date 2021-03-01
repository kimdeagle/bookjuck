<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::회원탈퇴| MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/withdrawal.css">
										   

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
			<h3>회원탈퇴</h3>
			<div id="box1">
				<b>회원정보 및 계좌내역 삭제</b><br>
회원탈퇴 즉시 회원정보는 모두 삭제되며, 재가입시에도 복원되지 않습니다.<br>

 삭제되는 정보 : 구매하신 eBook, 개인정보, 북적 포인트 판매관리 계정<br>
 회원탈퇴 시 구매하신 eBook도 모두 삭제됩니다. 회원탈퇴 후 타 ID로 사용 권한을 양도하실 수 없습니다.<br>
상품리뷰, 독후감은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.<br>
 게시판형 서비스에 등록한 게시물은 삭제되지 않고 유지됩니다.<br>
<hr>
<b>회원정보 영구 삭제</b><br>
회원탈퇴 후,  탈퇴 계정의 개인정보는 영구 삭제합니다.<br>
<hr>
<b>탈퇴 후 정보보관</b><br>
전자상거래 등에서의 소비자보호에 관한 법률 제6조에 의거 성명, 주소 등 거래의 주체를 식별할 수 있는 정보에 한하여 서비스<br>
이용에 관한 동의를 철회한 경우에도 이를 보존할 수 있으며, 동법 시행령 제6조에 의거 다음과 같이 거래 기록을 보관합니다.<br>
 표시, 광고에 관한 기록 : 6개월<br>
 계약 또는 청약철회 등에 관한 기록 : 5년<br>
 대금결제 및 재화등의 공급에 관한 기록 : 5년<br>
 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년<br>
본인인증을 위해 탈퇴를 하시려면 1:1 문의를 이용해 주세요.<br>
본인인증 문의 없이 탈퇴할 경우, 30일 이내 재가입(인증)이 불가능합니다.<br>
			</div>
			<div id="pwBox">
				<form action="/bookjuck/member/mypage/withdrawalok.do" method="get" id="withDrawalForm">
				<table id="pwtable">
					<tr height="50">
						<th width="130">비밀번호:</th>
						<td>
							<input type="password" id="pw" name="pw" placeholder="비밀번호를 입력해주세요">
						</td>
					</tr>
					<tr>
						<th>비밀번호 재확인: </th>
						<td>
							
							<input type="password" id="cpw" name="cpw" placeholder="비밀번호를 입력해주세요">
						</td>
					</tr>
				</table>
				<input type="submit" class="btn-general" value=" 회원탈퇴 ">
				<input type="hidden" name="id" value="${id}">
				<input type="hidden" name="seq" value="${seq}">
				</form>
			</div>
      </article>
		</section>
	

		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	<script type="text/javascript">
	
	/*비밀번호 중복 검사*/
	$("#withDrawalForm").submit(function(evt) {
		
		//계정 비밀번호
		var rpw = "${pw}";
		
		//비밀번호 재확인 중복 검사
		if ($("#pw").val() != $("#cpw").val()) {
			alert("암호가 일치하지 않습니다.");
			evt.preventDefault();
			return false; 
		//계정 비밀번호 검사
		}else if($("#pw").val() != rpw){
			alert("현재 비밀번호가 틀렸습니다.");
			evt.preventDefault();
			return false;
			
		}		
	});	
	
	</script>

</body>

</html>