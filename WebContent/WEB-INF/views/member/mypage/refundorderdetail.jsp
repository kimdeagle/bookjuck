<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<td colspan="3">이름</td>
					</tr>
					<tr>
						<th>휴대폰 번호</th>
						<td>휴대폰 번호</td>
						<th style="border-left: 1px solid #DDD;">이메일</th>
						<td>이메일</td>
					</tr>
				</table>
			</article>

			<article>
				<h5>배송정보</h5>

				<!-- 일반 배송시 -->
				<div class="waybill-number">
					<span>일반 배송</span>
					<div>
						운송장 번호 : <a href="#" onclick="popup();">123456789</a>
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
						<td rowspan="2">주문번호<br> (주문일)
						</td>
						<td>가격</td>
						<td class="bookinfo"><img
							src="/bookjuck/image/달러구트 꿈 백화점.png" class="book-xs"> <a
							href="/bookjuck/member/book/bookdetail.do">도서명</a></td>
						<td>0</td>
						<td>주문상태 <!-- 주문상태가 배송 완료일 때 보임 || 비회원 안 보임 --> <a href="#"
							class="btn-report">독후감 쓰러 가기</a>
						</td>
					</tr>

					<tr class="olInfo">
						<td>가격</td>
						<td class="bookinfo"><img
							src="/bookjuck/image/달러구트 꿈 백화점.png" class="book-xs"> <a
							href="/bookjuck/member/book/bookdetail.do">도서명</a></td>
						<td>0</td>
						<td>주문상태 <!-- 주문상태가 배송 완료일 때 보임 || 비회원 안 보임 --> <a href="#"
							class="btn-report">독후감 쓰러 가기</a>
						</td>
					</tr>
				</table>

				<!-- 바로드림, 비회원 안 보임 -->
				<span>바로드림</span>
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
						<td>주문상태 <!-- 주문상태가 배송 완료일 때 보임 --> <a href="#"
							class="btn-report">독후감 쓰러 가기</a>
						</td>
					</tr>

					<tr class="olInfo">
						<td>가격</td>
						<td class="bookinfo"><img
							src="/bookjuck/image/달러구트 꿈 백화점.png" class="book-xs"> <a
							href="/bookjuck/member/book/bookdetail.do">도서명</a></td>
						<td>0</td>
						<td>주문상태 <!-- 주문상태가 배송 완료일 때 보임 --> <a href="#"
							class="btn-report">독후감 쓰러 가기</a>
						</td>
					</tr>
				</table>

				<!-- e-book 비회원 안 보임-->
				<span>E-Book</span>
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
						<td>주문상태 <!-- 주문상태가 다운로드 완료일 때 보임 --> <a href="#"
							class="btn-report">독후감 쓰러 가기</a>
						</td>
					</tr>

					<tr class="olInfo">
						<td>가격</td>
						<td class="bookinfo"><img
							src="/bookjuck/image/달러구트 꿈 백화점.png" class="book-xs"> <a
							href="/bookjuck/member/book/ebooklist.do">도서명</a></td>
						<td>1</td>
						<td>주문상태 <!-- 주문상태가 다운로드 완료일 때 보임 --> <a href="#"
							class="btn-report">독후감 쓰러 가기</a>
						</td>
					</tr>
					</tr>
				</table>


				<table class="receiver table tbl-md">
					<tr>
						<th>받으실 분</th>
						<td>이름</td>
					</tr>
					<tr>
						<th>휴대폰 번호</th>
						<td>휴대폰 번호</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>주소</td>
					</tr>
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
					<tr>
						<td>주문금액</td>
						<!-- 비회원일 경우 0 -->
						<td>사용포인트</td>
						<td><span>결제방식</span>결제금액</td>
						<!-- 비회원일 경우 0 -->
						<td>적립포인트</td>
					</tr>
				</table>
			</article>
			
			
			<!-- ######## 이 이후 다은 추가 - 교환/취소/환불 정보 -->
			<article>
				<h5>환불정보</h5>
				<table class="tbl-pay table tbl-md">
					<tr>
						<th>주문금액</th>
						<th>사용 포인트</th>
						<th>환불금액</th>
						<th>환불 포인트</th>
					</tr>
					<tr>
						<td>주문금액</td>
						<!-- 비회원일 경우 0 -->
						<td>사용포인트</td>
						<td><span>결제방식</span>- 환불금액</td>
						<!-- 비회원일 경우 0 -->
						<td>환불포인트</td>
					</tr>
				</table>
			</article>
			
			
			<article>
				<h5>취소/교환/환불 정보</h5>
                <table class="table tbl-md tbl-refundinfo">
                    <tr>
                        <th>사유</th>
                        <td>단순변심</td>
                        <th>신청일</th>
                        <td>2021-02-20</td>
                    </tr>
                    <tr>
                        <th>상세사유</th>
                        <td colspan="3"> - </td>
                    </tr>
                    <tr>
                        <th>처리상태</th>
                        <td>환불완료</td>
                        <th>처리날짜</th>
                        <td>2021-02-20</td>
                    </tr>
                </table>
			</article>



            <!-- ####### 종이책 -->
            <!-- 교환/ 환불일때만 -->
            <article>
                <h5>회수지 정보</h5>
                <table class="receiver table tbl-md">
                    <tr>
                        <th>주소</th>
                        <td>주소</td>
                    </tr>
                </table>
            </article>


            <!-- 교환일때만 -->
            <article>
                <h5>교환상품 배송정보</h5>
                <div class="waybill-number">
					<span>일반 배송</span>
					<div>
						운송장 번호 : <a href="#" onclick="popup();">123456789</a>
					</div>
				</div>
                <table class="receiver table tbl-md">
                    <tr>
                        <th>받으실 분</th>
                        <td>이름</td>
                    </tr>
                    <tr>
                        <th>휴대폰 번호</th>
                        <td>휴대폰 번호</td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>주소</td>
                    </tr>
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

	//팝업창 띄우기
	function popup(){
	    var url = "/bookjuck/member/mypage/delivery.do";
	    var name = "popup delivery";
	    var option = "width = 500, height = 500, top = 100, left = 200, location = no"
	    window.open(url, name, option);
	}

	
</script>

</html>