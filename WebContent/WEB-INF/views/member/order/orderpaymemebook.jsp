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


			<article class="mem-orderder-infobox">
				<h4>주문자 정보</h4>
				<table class="tbl-mem-orderer table tbl-lg">
					<tr>
						<td>주문자</td>
						<td>이름 | 전화번호</td>
					</tr>

				</table>
			</article>
			
			<article class="ebooknotice">
				<div>
				※ <b>잠깐!</b> 전자책 주문이 맞는지 확인해주세요.<br>전자책 상품은 배송되지 않으며,<br>구매 후 지원기기(스마트폰/태블릿/PC)에서 다운로드 후 열람 가능합니다.
				</div>
			</article>


			<article class="orderpaylistbox">

				<h4>주문상품</h4>
				<!-- 주문 신청한 장바구니 정보 가져오기 -->
				<table class="tbl-orderpaylist table tbl-lg">
					<tr>
						<th>상품정보</th>
						<th>판매가</th>
					</tr>
					<tr>
						<td>
							<div>
								<img src="/bookjuck/image/달러구트 꿈 백화점.png" class="book-xs">
								<a href="/bookjuck/member/book/bookdetail.do">도서명</a>
							</div>
						</td>
						<td>판매가x수량 | 수량<br>판매가
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
							<td>원</td>
						</tr>
						<tr>
							<td>배송비</td>
							<td>원</td>
						</tr>
						<tr>
							<td>할인금액</td>
							<td>원</td>
						</tr>
						<tr>
							<th>최종금액</th>
							<td style="color: #BC4B51">원</td>
						</tr>
						<tr>
							<td>적립예정 포인트</td>
							<td>원</td>
						</tr>
					</table>
					
					
					
				</div>
				
				
				<div class="pointbox">
				<h4>할인/적립</h4>
					<div>보유 포인트 : </div>
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
							<a href="/bookjuck/member/order/ebookcart.do" class="btn-back"
								onclick="">장바구니 가기</a> <a href="javascript:void(0);"
								onclick="orderpay()" class="btn-pay" id="btn-card-type">결제하기</a>
						</div>
						<div id="btn-account-type" style="display: none">
							<a href="/bookjuck/member/order/ebookcart.do" class="btn-back"
								onclick="">장바구니 가기</a> <a
								href="/bookjuck/member/order/orderfinish.do" onclick=""
								class="btn-pay">결제하기</a>
						</div>
					</div>
				</div>
				
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
		
		function changeBaroType() {
			$(".baro-type1").css('display','none');
			$(".baro-type2").css('display','block');
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
				name : '북적북적', //구매한 도서명
				amount : 10,
				buyer_email : 'iamport@siot.do',
				buyer_name : '구매자이름',
				buyer_tel : '010-1234-5678',
				buyer_addr : '서울특별시 강남구 삼성동',
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