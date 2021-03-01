<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적_Admin::휴면 계정관리</title>
<%@include file="/WEB-INF/views/admin/inc/asset.jsp"%>
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/dormancymng.css">
<style type="text/css">
</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp"%>


		<section class="contentsection">
			<h3>휴면 계정 관리</h3>

			<!-- 검색 테이블  시작-->
			<table class="table table-bordered" id="tbl1">
				<tr>
					<th width="150">검색어</th>
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
					<th width="150">개인정보 유효기간</th>
					<td>
						<input type="text">일 이상
					</td>
				</tr>
				<tr>
					<th>회원구분</th>
					<td>
						<label>전체<input  type="radio" name="socail" checked></label>
						<label>일반<input  type="radio" name="socail" ></label>
						<label>구글<input  type="radio" name="socail" ></label>
						<label>네이버<input type="radio" name="socail" ></label>
						<label>카카오<input  type="radio" name="socail" ></label>
					</td>
					<th>큐레이션 구독 여부</th>
					<td>
						<label>전체<input  type="radio" name="curation" checked></label>
						<label>구독<input  type="radio" name="curation" ></label>
						<label>비구독<input  type="radio" name="curation" ></label>
					</td>
				</tr>
				<tr>
					<th>회원가입 기간</th>
					<td>
						<input type="date" class="form-control">
						<span>~</span>
						<input type="date" class="form-control">
					</td>
					<th>휴면 전환일</th>
					<td>
						<input type="date" class="form-control">
						<span>~</span>
						<input type="date" class="form-control">
					</td>
				</tr>
			</table>
			<!-- 검색 테이블  종료-->
			
			<input type="button" class="btn-general" id="listbtn" value="검  색">
			
			
			<hr>
			<select id="selbox2" name="selbox2" onchange="chageLangSelect()">
							<option value="">개수</option>
							<option value="10">10</option>
							<option value="20">20</option>
							<option value="30">30</option>
			</select>
			
			<!-- 리스트 테이블 시작 -->
			<table class="talbe table tbl-md" id="tbl2">
			<tr>
				<!-- <th><input  type="checkbox" id="allCheck" name="chk"></th> -->
				<th width="50">번호</th>
				<th width="80">이름</th>
				<th>아이디</th>
				<th>연락처</th>
				<th width="120">가입일</th>
				<th>회원구분</th>
				<th>휴면 전환일</th>
				<th>전환 경과일</th>
				<th width="150"></th>
			</tr>
			<c:forEach items="${dlist}" var="dto">
				<tr>
					<!-- <td><input  type="checkbox" id="Check1" name="chk"></td> -->
					<td>${dto.seq}</td>
					<td>${dto.name}</td>
					<td>${dto.id}</td>
					<td>0${dto.tel}</td>
					<td>${dto.regDate}</td>
					<td>${dto.login}</td>
					<td>${dto.trsdate}</td>
					<td>${dto.regdate_d}일</td>
					<td>
						<a href="/bookjuck/admin/custmng/custview.do?seq=${dto.seq}&name=${dto.name}&ssn=${dto.ssn}&address=${dto.address}&email=${dto.email}&tel=${dto.tel}&curation=${dto.curation}&privacy=${dto.privacy}&seq=${dto.seq}&id=${dto.id}&pw=${dto.pw}&nowpage=${nowPage}"><b>[조회]</b> </a>
						<a href="/bookjuck/admin/custmng/custadd.do?seq=${dto.seq}&name=${dto.name}&ssn=${dto.ssn}&address=${dto.address}&email=${dto.email}&tel=${dto.tel}&curation=${dto.curation}&privacy=${dto.privacy}&seq=${dto.seq}&id=${dto.id}&pw=${dto.pw}&nowpage=${nowPage}"><b>[일반]</b></a>
						<a href="/bookjuck/admin/custmng/custdel.do?seq=${dto.seq}&name=${dto.name}&ssn=${dto.ssn}&address=${dto.address}&email=${dto.email}&tel=${dto.tel}&curation=${dto.curation}&privacy=${dto.privacy}&seq=${dto.seq}&id=${dto.id}&pw=${dto.pw}&nowpage=${nowPage}"><b>[탈퇴]</b></a>
						<!-- <input type="button" value="조회" id="#custSearch" href="#custSearch" data-toggle="modal">
						<input type="button" value="탈퇴">
						<input type="button" value="휴면"> -->
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
		<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
		<%@include file="/WEB-INF/views/common/top.jsp"%>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- ########## 하단 끝 -->



		<!--########### 회원 정보 조회 모달 시작  -->
			<div class="modal fade" id="custSearch" role="dialog">
				<div class="modal-dialog modal-md">
					<div class="modal-content">
						<!-- 모달 해더 시작 -->
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h3>회원정보 조회</h3>
						</div>
						<!-- 모달 해더 끝 -->
						
						<!-- 모달 보디 시작 -->
						<div class="modal-body">

				<h5>아이디 정보</h5>
				
				<table class="createId table" id="idtbl">


					<tr>
						<th width="205">아이디:</th>
						<td colspan="1" width="240">
							TEST001
						</td>
						<td></td>
					</tr>
					<tr>
						<th >비밀번호:</th>
						<td>
							********
						</td>
						<td>
							<a>[비밀번호 보기]</a>
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
				<td>홍길동</td>
			</tr>
			<tr>
				<th>성별:</th>
				<td>남자</td>
			</tr>
			<tr>
				<th>주민번호:</th>
				<td>
					940123-1122345
				</td>
			</tr>
			<tr>
				<th>주소:</th>
				<td>서울특별시 강남구 역삼동 테헤란로 132</td>
			</tr>
			<tr>
				<th>E-Mail:</th>
				<td>TEST001@gmail.com</td>
			</tr>
			<tr>
				<th>연락처:</th>
				<td>010<span>-</span>1111<span>-</span>1111</td>
			</tr>
			<tr>
				<th>큐레이션레터 서비스:</th>
				<td> 구독</label></td>
			</tr>
			<tr>
				<th>개인정보 유효 기간</th>
				<td> 1년</td>
			</tr>		
		</table>
				
						</div>
						<!-- 모달 보디 끝 -->
					</div>
				</div>
			</div>
		<!--########### 회원 정보 조회 모달 끝 -->



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
							<p>'홍길동'님의 계정을 <b>삭제하시겠습니까?</b></p>
							<input type="button" id="withdrawalbtn" class="mdalbtn" value="확인">
						</div>
						<!-- 모달 보디 끝 -->
					</div>
				</div>
			</div>
		<!--########### 회원 정보 조회 모달 끝 -->
		
		<!--########### 회원 일반 전환 모달 시작  -->
			<div class="modal fade" id="custdormancy" role="dialog">
				<div class="modal-dialog modal-md">
					<div class="modal-content">
						<!-- 모달 해더 시작 -->
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h3>일반 계정 전환</h3>
						</div>
						<!-- 모달 해더 끝 -->
							
						<!-- 모달 보디 시작 -->
						<div class="modal-body">
							<p>회원 번호: 1</p>
							<p>'홍길동'님의 계정을 <b>일반계정으로 전환하시겠습니까?</b></p>
							<input type="button" id="withdrawalbtn" class="mdalbtn" value="확인">
						</div>
						<!-- 모달 보디 끝 -->
					</div>
				</div>
			</div>
		<!--########### 회원 일반 전환 모달 끝 -->
	
	
	
	
	
	
	
	
	
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
		
		
		//페이지 리스트 개수
		function chageLangSelect(){
			
		    var langSelect = document.getElementById("selbox2");
		     
		    // select element에서 선택된 option의 value가 저장된다.
		    var selectValue = langSelect.options[langSelect.selectedIndex].value;
		 
		    // select element에서 선택된 option의 text가 저장된다.
		    var selectText = langSelect.options[langSelect.selectedIndex].text;
		    location.href="/bookjuck/admin/custmng/dmcchagelangsel.do?nowpage=1&pageSize="+selectValue; 
		}
		
		$('#search1').click(function() {
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