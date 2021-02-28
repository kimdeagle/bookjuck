<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::주문/결제내역 상세| MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/order.css">
<link rel="stylesheet" href="/bookjuck/css/orderlist.css">
<link rel="stylesheet" href="/bookjuck/css/orderdetail.css">


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

		<!-- 마이페이지 -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp"%>



		<!-- 주문자 정보 영역 -->
		<section class="contentsection">
			<h3>
				주문/결제 조회<span style="font-size: 18px;"> | 상세 조회</span>
			</h3>
			<article>
				<h5>주문자 정보</h5>
				<table class="orderer table tbl-md">
					<tr>
						<th>주문하신 분</th>
						<td colspan="3">${name}</td>
					</tr>
					<tr>
						<th>휴대폰 번호</th>
						<td>${tel}</td>
						<th style="border-left: 1px solid #DDD;">이메일</th>
						<td>${email}</td>
					</tr>
				</table>
			</article>

			<article>
				<h5>주문/배송정보</h5>

				<!-- 일반 배송시 -->
				<div class="waybill-number">
					<b>일반배송</b>
					<div>
						운송장 번호 : <c:forEach items="${bdlist}" var="bddto"><a href="#">${bddto.deliveryNumber}</a></c:forEach>
					</div>
				</div>

				<table class="orderdetail table tbl-md">
					<tr>
						<th>주문번호</th>
						<th>주문금액</th>
						<th>상품정보</th>
						<th>수량</th>
						<th>주문상태</th>
					</tr>
					<tr class="olInfo">
						<td rowspan="${blist.size()}">${seqBookOrder}<br> 
						(${orderDate})
						</td>
					<c:forEach items="${blist}" var="bdto">
						<td style="vertical-align: middle;">${bdto.total}</td>
						<td class="bookinfo"><img
							src="/bookjuck/image/book/${bdto.image}" class="book-xs"> <a
							href="/bookjuck/member/book/bookdetail.do?seq=${bdto.seqBook}">${bdto.title}</a></td>
						<td style="vertical-align: middle;">${bdto.amount}</td>
						<td style="vertical-align: middle;">${bdto.orderState}
						 <!-- 주문상태가 배송 완료일 때 보임 || 비회원 안 보임 --> 
						 <c:if test="">
						 	<a href="#" class="btn-report">독후감 쓰러 가기</a>
						 </c:if>
						</td>
					</tr>
					</c:forEach>
				</table>

				<!-- 바로드림, 비회원 안 보임 -->
<!-- 				<b>바로드림</b>
				<table class="orderdetail table tbl-md">
					<tr>
						<th>주문번호</th>
						<th>주문금액</th>
						<th>상품정보</th>
						<th>수량</th>
						<th>주문상태</th>
					</tr>
					<tr class="olInfo">
						<td rowspan="2">주문번호<br> (주문일)
						</td>
						<td>가격</td>
						<td class="bookinfo"><img
							src="/bookjuck/image/달러구트 꿈 백화점.png" class="book-xs"> <a
							href="/bookjuck/member/book/bookdetail.do">도서명</a></td>
						<td>0</td>
						<td>주문상태 주문상태가 배송 완료일 때 보임 <a href="#"
							class="btn-report">독후감 쓰러 가기</a>
						</td>
					</tr>

					<tr class="olInfo">
						<td>가격</td>
						<td class="bookinfo"><img
							src="/bookjuck/image/달러구트 꿈 백화점.png" class="book-xs"> <a
							href="/bookjuck/member/book/bookdetail.do">도서명</a></td>
						<td>0</td>
						<td>주문상태 주문상태가 배송 완료일 때 보임 <a href="#"
							class="btn-report">독후감 쓰러 가기</a>
						</td>
					</tr>
				</table> -->

				<!-- e-book 비회원 안 보임-->
<!-- 				<b>E-Book</b>
				<table class="orderdetail table tbl-md">
					<tr>
						<th>주문번호</th>
						<th>주문금액</th>
						<th>상품정보</th>
						<th>수량</th>
						<th>주문상태</th>
					</tr>
					<tr class="olInfo">
						<td rowspan="2">주문번호<br> (주문일)
						</td>
						<td>가격</td>
						<td class="bookinfo"><img
							src="/bookjuck/image/달러구트 꿈 백화점.png" class="book-xs"> <a
							href="/bookjuck/member/book/ebooklist.do">도서명</a></td>
						<td>1</td>
						<td>주문상태</td>
					</tr>

					<tr class="olInfo">
						<td>가격</td>
						<td class="bookinfo"><img
							src="/bookjuck/image/달러구트 꿈 백화점.png" class="book-xs"> <a
							href="/bookjuck/member/book/ebooklist.do">도서명</a></td>
						<td>1</td>
						<td>주문상태</td>
					</tr>
				</table> -->


				<table class="receiver table tbl-md">
					<c:forEach items="${bdlist}" var="bddto">
					<tr>
						<th>받으실 분</th>
						<td>${bddto.name}</td>
					</tr>
					<tr>
						<th>휴대폰 번호</th>
						<td>${bddto.tel}</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${bddto.address}</td>
					</tr>
					</c:forEach>
				</table>



			</article>


			<article>
				<h5>결제정보</h5>
				<table class="tbl-pay table tbl-md">
					<tr>
						<th>주문금액</th>
						<th>사용 포인트</th>
						<th>결제금액</th>
						<th>적립 포인트</th>
					</tr>
					<c:forEach items="${bplist}" var="bpdto">
					<tr>
						<td>${bpdto.totalPay}</td>
						<!-- 비회원일 경우 0 -->
						<td>${bpdto.usePoint}</td>
						<td><span>${bpdto.payment}</span>${bpdto.actualPay}</td>
						<!-- 비회원일 경우 0 -->
						<td>${bpdto.savePoints}</td>
					</tr>
					</c:forEach>
				</table>
			</article>

			<div class="orderlistback"><a href="/bookjuck/member/mypage/orderlist.do" class="btn-order">주문/배송조회 가기</a></div>

		</section>







		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- ########## 하단 끝 -->

	</div>




</body>

<script>
	
</script>

</html>