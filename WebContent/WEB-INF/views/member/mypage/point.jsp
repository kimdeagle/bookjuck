<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::My포인트| MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>


<link rel="stylesheet" href="/bookjuck/css/point.css">
<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">


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
				<h3>포인트 내역</h3>
				<hr>
				<div class="pointContents" id="box1">
					<ul>
						<li>- 적립금은 회원 결제 시 적립 또는 사용이 가능한 북적 포인트입니다.</li>
						<li>- 적립금은 예치금으로 전환되지 않으면, 상품 구매 시 사용할 수 있습니다.</li>
						<li>- 먼저 적립된 적립 금부터 순차적으로 사용됩니다.</li>
					</ul>
				</div>


				<div class="pointContents" id="box2">

					<table class="table table tbl-md" id="searchDateTbl">
						<tr>
							<td>
								<input type="button" value="1개월">
								<input type="button" value="3개월">
								<input type="button" value="6개월">
							</td>

							<td>
								<input type="date" class="form-control">
							</td>
							<td>~</td>
							<td>
								<input type="date" class="form-control">
							</td>
						</tr>
						<tr>
							<td>
								<select name="totalSearch">
									<option value="">통합검색</option>
									<option value="TEST01">TEST01</option>
									<option value="TEST02">TEST02</option>
									<option value="TEST03">TEST03</option>
								</select>
							</td>
							<td>
								<input type="text" class="medium">
							</td>
							<td colspan="2">
								<input type="button" value="검 색" class="btn-general">
							</td>

						</tr>
					</table>
				</div>
				<div class="pointContents" id="box3">
					<table class="table table tbl-md ">
						<tr>
							<th width="100">적립일</th>
							<th>내용</th>
							<th width="120">적립금액</th>
							<th width="120">적립금 사용 금액</th>
							<th width="120">적립금 누적 금액</th>
						</tr>
						<tr>
							<td>2020.01.15</td>
							<td>주문 내용[주문번호]</td>
							<td>2,000</td>
							<td>0</td>
							<td>200,000</td>
						</tr>
						<tr>
							<td>2020.12.30</td>
							<td>우수 독후감</td>
							<td>500</td>
							<td>0</td>
							<td>198,000</td>
						</tr>


					</table>
				</div>

				<div>
					<ul class="pagination">
						<li>
							<a href="#" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
						<li>
							<a href="#">1</a>
						</li>
						<li>
							<a href="#">2</a>
						</li>
						<li>
							<a href="#">3</a>
						</li>
						<li>
							<a href="#">4</a>
						</li>
						<li>
							<a href="#">5</a>
						</li>
						<li>
							<a href="#" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</ul>
				</div>
			</article>
		</section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- ########## 하단 끝 -->

	</div>


	<script>
		
	</script>

</body>

</html>