<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적_Admin::일반 계정관리</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp"%>
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/custmng.css">
<style type="text/css">
</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp"%>


		<section class="contentsection">
			<h3>고객 계정 관리</h3>
		<form action="" method="get" id="searchForm">
			<!-- 검색 테이블  시작-->
			<table class="table table-bordered" id="tbl1">
				<tr>
					<th width="110">검색어</th>
					<td>

						<select id="selbox1" name="selbox1">
							<option value="">선택</option>
							<option value="1">이름</option>
							<option value="2">아이디</option>
							<option value="3">번호</option>
							<option value="4">연락처</option>
						</select>
						<input type="text" name="selboxDirect">
					</td>
					<th width="130">개인정보 유효기간</th>
					<td>
						<label>전체<input type="radio" id="term1" name="term" value="" checked></label>
						<label>1년<input type="radio" id="term2" name="term" value="1"></label>
						<label>2년<input type="radio" id="term3" name="term" value="2"></label>
						<label>5년<input type="radio" id="term4" name="term" value="5"></label>
						<label>10년<input type="radio" id="term5" name="term" value="10"></label>
					</td>
				</tr>
				<tr>
					<th>회원구분</th>
					<td><label>전체<input type="radio" id="socail1" name="socail" value="" checked></label>
						<label>일반<input type="radio" id="socail2" name="socail" value="일반"></label>
						<label>구글<input type="radio" id="socail3" name="socail" value="구글">	</label>
						<label>네이버<input type="radio" id="socai4" name="socail" value="네이버"></label>
						<label>카카오<input type="radio" id="socail5" name="socail" value="카카오"></label>
					</td>
					<th>큐레이션 구독 여부</th>
					<td>
						<label>전체<input type="radio" id="curation1" name="curation" value="" checked></label>
						<label>구독<input type="radio" id="curation2" name="curation" value="구독"></label>
						<label>비구독<input type="radio" id="curation3" name="curation" value="비구독"></label>
					</td>
				</tr>
				<tr>
					<th>회원가입 기간</th>
					<td>
						<input type="date" class="form-control">
						<span>~</span>
						<input type="date" class="form-control">
					</td>
					<th>최근 접속일</th>
					<td>
						<input type="date" class="form-control">
						<span>~</span>
						<input type="date" class="form-control">
					</td>
				</tr>
			</table>
			<!-- 검색 테이블  종료-->

			<input type="button" class="btn-general" id="listbtn" value="검  색">
		</form>

			<hr>
			<select id="selbox2" name="selbox2" onchange="chageLangSelect()">
				<option value="">개수</option>
				<option value="20">20</option>
				<option value="40">40</option>
				<option value="50">50</option>
			</select>

			<!-- 리스트 테이블 시작 -->			
			<table class="talbe table tbl-md" id="tbl2">
				<thead>
					<tr>
						<!-- <th>
							<input type="checkbox" id="allCheck" name="chk">
						</th> -->
						<th width="50">번호</th>
						<th width="70">이름</th>
						<th>아이디</th>
						<th>연락처</th>
						<th width="120">가입일</th>
						<th width="70">회원</th>
						<th width="80">큐레이션</th>
						<th width="80">개인정보</th>
						<th width="120">최근 접속일</th>
						<th width="170"></th>
					</tr>
				</thead>
				<c:if test="${mlist.size() == 0 }">
					<tr>
						<td colspan="5" style="text-align: center;">게시물이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${mlist}" var="dto">
					<tr>
						<!-- <td>
							<input type="checkbox" id="Check1" name="chk">
						</td> -->
						<td>${dto.seq}</td>
						<td>${dto.name}</td>
						<td>${dto.id}</td>
						<td>0${dto.tel}</td>
						<td>${dto.regDate}</td>
						<td>${dto.login}</td>
						<td>${dto.curation}</td>
						<td>${dto.privacy}년</td>
						<td>${dto.lastDate}</td>
						<td>							
							<a href="/bookjuck/admin/custmng/custview.do?seq=${dto.seq}&name=${dto.name}&ssn=${dto.ssn}&address=${dto.address}&email=${dto.email}&tel=${dto.tel}&curation=${dto.curation}&privacy=${dto.privacy}&seq=${dto.seq}&id=${dto.id}&pw=${dto.pw}&nowpage=${nowPage}"><b>[조회]</b> </a>
							<a id="search1" href="/bookjuck/admin/custmng/dormancyadd.do?seq=${dto.seq}&name=${dto.name}&ssn=${dto.ssn}&address=${dto.address}&email=${dto.email}&tel=${dto.tel}&curation=${dto.curation}&privacy=${dto.privacy}&seq=${dto.seq}&id=${dto.id}&pw=${dto.pw}&nowpage=${nowPage}"><b>[휴면]</b></a>
							<a href="/bookjuck/admin/custmng/custdel.do?seq=${dto.seq}&name=${dto.name}&ssn=${dto.ssn}&address=${dto.address}&email=${dto.email}&tel=${dto.tel}&curation=${dto.curation}&privacy=${dto.privacy}&seq=${dto.seq}&id=${dto.id}&pw=${dto.pw}&nowpage=${nowPage}"><b>[탈퇴]</b></a>
							
							<%-- <form action="http://localhost:8090/bookjuck/admin/custmng/custview.do" method="get" >
								<input type="hidden" id="name" value="${dto.name}">
								<input type="submit" value="조횡">
							</form>
							<input type="button" value="조회2" id="123" onclick="location.href='http://localhost:8090/bookjuck/admin/custmng/custview.do?name=${dto.name}'" data-toggle="modal"> 
							<input type="button" value="탈퇴" id="#custWithdrawal" href="#custWithdrawal" data-toggle="modal">
							<input type="button" value="휴면" id="#custdormancy" href="#custdormancy" data-toggle="modal">--%>
						</td>
					</tr>
     		   </c:forEach>

			</table>
			<nav class="pagebar">
				<ul class="pagination">${pagebar}</ul>
			</nav>




		</section>
	</div>
	<!-- container 종료 -->

	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp"%>
	<%@include file="/WEB-INF/views/common/top.jsp"%>


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<!-- ########## 하단 끝 -->
 



	<!--########### 회원 탈퇴 모달 시작  -->
	<div class="modal fade" id="custWithdrawal" role="dialog">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<!-- 모달 해더 시작 -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3>회원 탈퇴</h3>
				</div>
				<!-- 모달 해더 끝 -->

				<!-- 모달 보디 시작 -->
				<div class="modal-body">
					<p>회원 번호: 1</p>
					<p>
						'홍길동'님의 계정을
						<b>삭제하시겠습니까?</b>
					</p>
					<input type="button" id="withdrawalbtn" class="mdalbtn" value="확인">
				</div>
				<!-- 모달 보디 끝 -->
			</div>
		</div>
	</div>
	<!--########### 회원 정보 조회 모달 끝 -->

	<!--########### 회원 휴면 전환 모달 시작  -->
	<div class="modal fade" id="custdormancy" role="dialog">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<!-- 모달 해더 시작 -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3>휴면 계정 전환</h3>
				</div>
				<!-- 모달 해더 끝 -->

				<!-- 모달 보디 시작 -->
				<div class="modal-body">
					<p>회원 번호: 1</p>
					<p>
						'홍길동'님의 계정을
						<b>휴면계정으로 전환하시겠습니까?</b>
					</p>
					<input type="button" id="withdrawalbtn" class="mdalbtn" value="확인">
				</div>
				<!-- 모달 보디 끝 -->
			</div>
		</div>
	</div>
	<!--########### 회원 휴면 전환 모달 끝 -->









	<script>
		$(document).ready(function() {
			//최상단 체크박스 클릭
			$("#allCheck").click(function() {
				//클릭되었으면
				if ($("#allCheck").prop("checked")) {
					//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
					$("input[name=chk]").prop("checked", true);

					//클릭이 안되있으면
				} else {
					//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
					$("input[name=chk]").prop("checked", false);
				}
			})
		})
		
		
		function chageLangSelect(){
			
		    var langSelect = document.getElementById("selbox2");
		     
		    // select element에서 선택된 option의 value가 저장된다.
		    var selectValue = langSelect.options[langSelect.selectedIndex].value;
		 
		    // select element에서 선택된 option의 text가 저장된다.
		    var selectText = langSelect.options[langSelect.selectedIndex].text;
		    location.href="/bookjuck/admin/custmng/custchanelangsel.do?nowpage=1&pageSize="+selectValue; 
		}
		
		$('#search1').click(function() {
			alert('새로고침');
			location.reload();
		});
		
		
		/* $(function(){
		$("#selbox").change(function() {
				if($("#selbox").val() == "direct") {
					$("#selboxDirect").show();
				}  else {
					$("#selboxDirect").hide();
				}
			}) 
		}); */
	</script>
</body>
</html>