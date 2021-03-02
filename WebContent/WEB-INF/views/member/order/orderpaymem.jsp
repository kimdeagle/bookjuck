<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::주문결제</title>


<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>

<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/order.css">
<link rel="stylesheet" href="/bookjuck/css/cart.css">
<link rel="stylesheet" href="/bookjuck/css/orderpaymem.css">

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<style>
</style>
</head>

<body>

	<!-- header ~ footer > 플로팅 메뉴(북적이, top)를 제외한 나머지 전부를 담는 컨테이너) -->
	<!-- ########## 컨테이너 시작 -->
	<div class="container">

		<!-- ########## 상단 헤더 시작 -->
		<%@include file="/WEB-INF/views/member/inc/header.jsp"%>
		<!-- ########## 상단 헤더 끝 -->


		<!-- 섹션 메뉴 -->

		<section class="mainsection">


			<article>
				<div class="statebox">
					<div class="img-orderstate"></div>
					<div>
						<h3>주문/결제</h3>
						주문정보 확인 후 결제해 주세요.
					</div>
					<div class="orderstep">
						<div>
							<div>STEP01</div>
							<div>장바구니&nbsp;&nbsp;&nbsp;></div>
						</div>
						<div class="on">
							<div>STEP02</div>
							<div>주문/결제&nbsp;&nbsp;&nbsp;></div>
						</div>
						<div>
							<div>STEP03</div>
							<div>주문완료</div>
						</div>
					</div>
				</div>
			</article>


			<form method="POST" name="payform" action="bookjuck/member/order/orderpaymemok.do">
			<article class="mem-orderder-infobox">
				<h4>주문자 정보</h4>
				<table class="tbl-mem-orderer table tbl-lg">
					<tr>
						<td>주문자</td>
						<td>${name}&nbsp; |&nbsp; ${tel}</td>
					</tr>

				</table>
			</article>


			<article>
				<h4>배송 정보</h4>
				<div class="delivery-type-tab">
					<ul>
						<li><a href="#deliery-type1" class="on"
							onclick="typeChange('delivery-type1')">일반배송</a></li>
						<li><a href="#deliery-type2"
							onclick="typeChange('delivery-type2')">편의점배송</a></li>
					</ul>
				</div>

				<div class="delivery-type-box">
					<div id="delivery-type1">

						<!-- 종이책 일반 배송일경우 -->
						<!-- 최근 배송지 -->
						<div class="book">

							<div class="latest-address" style="display: block;">
								<div class="default-info">
									<c:forEach items="${dlist}" var="ddto">
									<div>
										<strong>[최근 배송지]</strong> ${ddto.name} <a href="javascript:void(0);"
											onclick="changeAddress()" class="btn1">배송지 변경</a>
									</div>
									<div name="deliveryAddress">${ddto.address}</div>
									<div name="deliveryTel">${ddto.tel}</div>
									</c:forEach>
								</div>
							</div>

							<!-- 배송지 변경 -->
							<div class="change-address" style="display: none">
								<table class="tbl-receiver table tbl-lg">
									<tr>
										<td>이름 *</td>
										<td><input type="text" placeholder="10자리 내 입력"
											maxlength="10" id="receiverName" name="receiverName">
										</td>
									</tr>
									<tr>
										<td>휴대폰 *</td>
										<td><input type="text" id="receiverPhone"
											name="receiverPhone"
											onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"
											maxlength="11" style="width: 200px;"></td>
									</tr>
									<tr>
										<td>주소 *</td>
										<td><input type="text" id="sample6_postcode"
											placeholder="우편번호" readonly="readonly" style="width: 110px;">
											<input type="button" onclick="sample6_execDaumPostcode()"
											value="주소 찾기"><br> <input type="text"
											id="sample6_address" placeholder="주소" readonly="readonly"
											style="width: 400px;"><br> <input type="text"
											id="sample6_detailAddress" placeholder="상세주소"
											style="width: 400px;"> <input type="text"
											id="sample6_extraAddress" placeholder="참고항목"
											readonly="readonly" style="width: 200px;"></td>
									</tr>
								</table>
								<a href="javascript:void(0);" onclick="changeAddress()">< 최근배송지로 변경</a>
							</div>
						</div>


					</div>

					<!-- 편의점 택배 -->
					<div id="delivery-type2" style="display: none">
						<table class="tbl-receiver table tbl-lg">
							<tr>
								<td>이름 *</td>
								<td><input type="text" placeholder="10자리 내 입력"
									id="convReceiverName" name="convReceiverName" maxlength="10">
									<label><input type="checkbox"
										onclick="infoConvChange()"> 주문자와 동일</label></td>
							</tr>
							<tr>
								<td>휴대폰 *</td>
								<td><input type="text" id="convReceiverPhone"
									name="convReceiverPhone"
									onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"
									style="width: 200px;"></td>
							</tr>
							<tr>
								<td>주소 *</td>
								<td><input type="text" id="sample6_postcode"
									placeholder="편의점 이름" readonly="readonly" style="width: 200px;">
									<input type="button" onclick="sample6_execDaumPostcode()"
									value="GS25검색"> <input type="button"
									onclick="sample6_execDaumPostcode()" value="CU검색"><br>
									<input type="text" id="sample6_address" placeholder="주소"
									readonly="readonly" style="width: 400px;"><br> <input
									type="text" id="sample6_detailAddress" placeholder="상세주소"
									style="width: 400px;"></td>
							</tr>
							<tr>
								<td>편의점 연락처</td>
								<td><input type="text" id="convPhone" name="convPhone"
									maxlength="11"
									onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"
									style="width: 200px;"></td>
							</tr>
						</table>
					</div>

				</div>

			</article>


			<article class="orderpaylistbox">

				<h4>주문상품</h4>
				<!-- 주문 신청한 장바구니 정보 가져오기 -->
				<table class="tbl-orderpaylist table tbl-lg">
					<tr>
						<th>상품명</th>
						<th>가격</th>
					</tr>
					<tr>
						<td>
							<div>
								<img src="/bookjuck/image/박기당 컬렉션.png" class="book-xs">
								<a href="/bookjuck/member/book/bookdetail.do">박기당 컬렉션</a>
							</div>
						</td>
						<td>81000 | 3<br>27000
						</td>
					</tr>
				</table>

			</article>


			<article>
				
				<div class="paymentbox">
				<h4>결제 정보</h4>
					<table class="tbl-payment table tbl-sm">
						<tr>
							<td>상품금액</td>
							<td>81000원</td>
						</tr>
						<tr>
							<td>배송비</td>
							<td>0원</td>
						</tr>
						<tr>
							<td>할인금액</td>
							<td>1000원</td>
						</tr>
						<tr>
							<th>최종금액</th>
							<td style="color: #BC4B51"><span name="actualpay">80000원</span></td>
						</tr>
						<tr>
							<td>적립예정 포인트</td>
							<td>4000원</td>
						</tr>
					</table>
					
					
					
				</div>
				
				
				<div class="pointbox">
				<h4>할인/적립</h4>
					<div>보유 포인트 : ${points}</div>
					<div><input type="text" id="point" name="point" value="0" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"> 원<a href="javascript:void(0);" class="btn1" onclick="" style="margin-left: 10px;">사용</a></div>
				
				
					<div class="pay-tab">
						<label><input type="radio" name="paytype" id="card-type"
							checked="checked" onclick="payChange()">카드결제</label> <label><input
							type="radio" name="paytype" id="bank-type" onclick="payChange()">무통장
							입금</label>
					</div>
					
					<div style="display: none" class="account">
						입금 계좌 : 1111222233334<br>예금주 명 : (주)북적북적
					</div>
					
					<div class="btn-pay-box">
						<div id="btn-card-type">
							<a href="/bookjuck/member/order/cart.do" class="btn-back"
								onclick="">장바구니 가기</a> <a href="javascript:void(0);"
								onclick="orderpay()" class="btn-pay" id="btn-card-type">결제하기</a>
						</div>
						<div id="btn-account-type" style="display: none">
							<a href="/bookjuck/member/order/cart.do" class="btn-back"
								onclick="">장바구니 가기</a> <a href="#" onclick="javascripts:document.payform.submit();"
								class="btn-pay">결제하기</a>
						</div>
					</div>
				</div>
				</form>
				<div style="clear: both;"></div>
			</article>




		</section>







		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- ########## 하단 끝 -->


		<!-- ########## 컨테이너 끝 -->
	</div>


	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp"%>


	<script>
		function typeChange(evt) {
			$(".delivery-type-box input[type=text]").val('');
			$(".delivery-type-tab li a").attr('class', '');
			$(event.target).attr('class', 'on');
			$("#delivery-type1,#delivery-type2").css('display', 'none');
			$("#" + evt).css('display', 'block');
		}

		function changeAddress() {

			if ($(".latest-address").css('display') == 'block') {
				$(".latest-address").css('display', 'none');
				$(".change-address").css('display', 'block');
			} else {
				$(".change-address").css('display', 'none');
				$(".latest-address").css('display', 'block');
			}
		}

		function infoConvChange() {
			if (event.target.checked) {
				$("#convReceiverName").val($("#nonOrdererName").val());
				$("#convReceiverPhone").val($("#nonOrdererPhone").val());
			} else {
				$("#convReceiverName").val('');
				$("#convReceiverPhone").val('');
			}
		}

		function payChange() {
			if ($("#card-type").is(':checked')) {
				$(".account").css('display', 'none');
				$("#btn-account-type").css('display', 'none');
				$("#btn-card-type").css('display', 'block');
			} else {
				$(".account").css('display', 'block');
				$("#btn-card-type").css('display', 'none');
				$("#btn-account-type").css('display', 'block');
			}
		}

		function sample6_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
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
							if (data.userSelectedType === 'R') {
								// 법정동명이 있을 경우 추가한다. (법정리는 제외)
								// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								if (extraAddr !== '') {
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
							document.getElementById("sample6_detailAddress")
									.focus();
						}
					}).open();

		}

		function orderpay() {
			var IMP = window.IMP; // 생략가능

			IMP.init('imp75630130'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용

			IMP.request_pay({
				pg : 'inicis', // version 1.1.0부터 지원.
				pay_method : 'card',
				merchant_uid : 'merchant_' + new Date().getTime(),
				name : '박기량 컬렉션', //구매한 도서명
				amount : 80000,
				buyer_email : 'iamport@siot.do',
				buyer_name : '채원희',
				buyer_tel : '010-3640-0075',
				buyer_addr : '서울시 성북구 삼선동 국원대로 66번길 66',
				buyer_postcode : '123-456'
			}, function(rsp) {
				if (rsp.success) {
					var msg = '결제가 완료되었습니다.';
					msg += '고유ID : ' + rsp.imp_uid;
					msg += '상점 거래ID : ' + rsp.merchant_uid;
					msg += '결제 금액 : ' + rsp.paid_amount;
					msg += '카드 승인번호 : ' + rsp.apply_num;
				} else {
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
				}
				alert(msg);

				if (rsp.success) {
					location.href = "/bookjuck/member/order/orderfinish.do";
				} else {
				}
			});
		}
	</script>

</body>

</html>