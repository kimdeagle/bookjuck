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
<link rel="stylesheet" href="/bookjuck/css/mypagemain.css">


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
	
		<!-- 마이페이지 -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
		<section class="contentsection">
			<article>
			<div class="contentsBox">

					<h3>최근 주문/배송 조회</h3>


					<a href="#">더보기</a>
					<table class="table tbl-md" id="orderList">
						<tr>
							<th>주문일자</th>
							<th>주문번호</th>
							<th>주문내역</th>
							<th>주문상태</th>
							<th>비고</th>
						</tr>
						<tr>
							<td>2020-12-01</td>
							<td><a href="#">1</a></td>
							<td>해리포터 마법사의 돌 외 2개...</td>
							<td>배송완료</td>
							<td>E-Book</td>
						</tr>
						<tr>
							<td>2021-01-30</td>
							<td><a href="#">2</td>
							<td>해리포터 불의 잔 외 1개...</td>
							<td>수령완료</td>
							<td>Baro-Book</td>
						</tr>
					</table>
				</div>

				<div class="contentsBox">
					<h3>나의 1:1 문의</h3>
					<a href="#">더보기</a>
					<table class="table tbl-md" id="myQnA">

						<tr>
							<th>문의일자</th>
							<th>질문 분야</th>
							<th>제 목</th>
							<th>답변 여부</th>
						</tr>
						<tr>
							<td>2021-02-13</td>
							<td>환불 요청</td>
							<td><a href="#">환불 요청 어떻게 하나요?</a></td>
							<td>답변 완료</td>
						</tr>
						<tr>
							<td>2021-01-01</td>
							<td>상품 취소</td>
							<td><a href="#">상품 쉬소 어떻게 하나요?</a></td>
							<td>답변 완료</td>
						</tr>

					</table>
				</div>
				<div class="contentsBox">
					<h3>나의 관심 분야</h3>
					<a href="#myInterest" data-toggle="modal">설정하기</a>
					<table class="table tbl-md" id="interestItem">
						<tr>
							<th>내 관심 뷴야</th>
						</tr>
						<tr>
							<td>1차 관심분야:</td>
						</tr>
						<tr>
							<td>2차 관심분야:</td>
						</tr>
						<tr>
							<td>3차 관심분야:</td>
						</tr>

					</table>
				</div>
			</article>
		</section>

	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	</div>
	
	
	
	
	
	<!--########### 관심 설정 모달  -->
			<div class="modal fade" id="myInterest" role="dialog">
				<div class="modal-dialog modal-md">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">관심 분야 설정</h4>
							<table>
								<tr>
									<th><label><input type="radio" name="radio1"
											value="1차 관심 분야:">1차 관심 분야: </label></th>
									<td></td>
								</tr>
								<tr>
									<th><label><input type="radio" name="radio1"
											value="2차 관심 분야:">2차 관심 분야: </label></th>
									<td></td>
								</tr>
								<tr>
									<th><label><input type="radio" name="radio1"
											value="3차 관심 분야:">3차 관심 분야: </label></th>
									<td></td>
								</tr>
							</table>
						</div>
						<div class="modal-body">
							<table class="table thead-dark">
								<tr>
									<th>대분류</th>
									<th>중분류</th>
									<th>소분류</th>
								</tr>
								<tr>
									<td><select class="form-control">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
									</select></td>
									<td><select class="form-control">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
									</select></td>
									</td>
									<td><select class="form-control">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
									</select></td>
									</td>
								</tr>

							</table>

						</div>

					</div>
				</div>
			</div>
		<!--########### 관심 설정 모달 끝  -->
</body>

</html>