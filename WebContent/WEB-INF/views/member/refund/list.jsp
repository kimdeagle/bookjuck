<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::교환/환불/취소내역 조회</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">

<link rel="stylesheet" href="/bookjuck/css/refund.css">


<style>

</style>
</head>

<body>



	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<div class="container">
	
		<!-- ########## 상단 헤더 시작 -->
		<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
		<!-- ########## 상단 헤더 끝 -->
	
	
		<!-- 마이페이지 side bar -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		
		
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
        <section class="contentsection">
            <article class="list-form">

                <h3>교환/환불/취소 조회</h3>

                <table class="table tbl-md tbl-process">
                    <tr>
                        <th class="outline-l">교환신청<b>(0)</b></th>
                        <th rowspan="2" class="next">
                            <span class="glyphicon glyphicon-menu-right"></span>
                        </th>
                        <th>교환접수중<b>(0)</b></th>
                        <th rowspan="2" class="next">
                            <span class="glyphicon glyphicon-menu-right"></span>
                        </th>
                        <th >교환완료<b>(0)</b></th>

                        <th rowspan="2" class="line"></th>

                        <th>반품신청<b>(0)</b></th>
                        <th rowspan="2" class="next">
                            <span class="glyphicon glyphicon-menu-right"></span>
                        </th>
                        <th>반품회수중<b>(0)</b></th>
                        <th rowspan="2" class="next">
                            <span class="glyphicon glyphicon-menu-right"></span>
                        </th>
                        <th class="outline-r">반품완료<b>(0)</b></th>
                    </tr>
                    <tr>
                        <td class="outline-l">
                            <div class="crop"><img src="/bookjuck/image/orderprocess/return.jpg" class="order-process"></div>
                        </td>
                        <td>
                            <div class="crop"><img src="/bookjuck/image/orderprocess/retrieve.jpg" class="order-process"></div>
                        </td>
                        <td>
                            <div class="crop"><img src="/bookjuck/image/orderprocess/complete.jpg" class="order-process"></div>
                        </td>


                        <td>
                            <div class="crop"><img src="/bookjuck/image/orderprocess/refund.jpg" class="order-process"></div>
                        </td>
                        <td>
                            <div class="crop"><img src="/bookjuck/image/orderprocess/retrieve.jpg" class="order-process"></div>
                        </td>
                        <td class="outline-r">
                            <div class="crop"><img src="/bookjuck/image/orderprocess/complete.jpg" class="order-process"></div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5"></td>
                        <td class="line line-bottom"></td>
                        <td colspan="5"></td>
                    </tr>
                </table>

                <!-- style="background-color: RGBA(140,179,105,0.2)" -->
                <table class="table tbl-md search-type">
                    <tr>
                        <th>기간조회</th>
                        <td class="period">
                            <input type="button" class="btn btn-sm" value="일주일">
                            <input type="button" class="btn btn-sm" value="1개월">
                            <input type="button" class="btn btn-sm" value="3개월">
                            <input type="button" class="btn btn-sm" value="6개월">
                        </td>
                        <td>
                            <input type="date"class="form-control" id="date_before_month"> ~
                            <input type="date"class="form-control" id="now_date">
                        </td>
                        <td rowspan="2">
                            <input type="button" class="btn btn-general" id="btnview" value="조회하기">
                        </td>
                    </tr>
                    <tr>
                        <th>상품조회</th>
                        <td colspan="2">
                            <input type="text" class="form-control" placeholder="상품명을 입력하세요.">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4"></td>
                    </tr>
                </table>

				<ul id="searchrule">
					<li>최근 1개월이 기본으로 조회 되며, 기간 변경시 기간 선택한 후 조회버튼을 클릭해 주세요.</li>
					<li>한번에 조회 가능한 기간은 최대 6개월이며, 최근 2년부터 조회 가능합니다.</li>
					<li>배송완료 된 주문건은 <a href="/bookjuck/member/mypage/orderlist.do">구매내역</a>에서도 확인 하실 수 있습니다.</li>
				</ul>


                <table class="table tbl-md list">
                    <tr style="background-color: RGBA(140,179,105,0.2)">
                        <th id="ctg">구분</th>
                        <th id="orderN">주문번호</th>
                        <th id="date">접수일자</th>
                        <th id="bookinfo">상품정보</th>
                        <th id="totalamount">수량</th>
                        <th id="process">상태</th>
                    </tr>
                    <tr>
                        <td>환불</td>
                        <td><a href="/bookjuck/member/mypage/refundorderdetail.do" class="ordernumber">00000000</a></td>
                        <td>2021-02-17</td>
                        <td class="book">자바의 정석<span class="amount">외 3</span></td>
                        <td>4</td>
                        <td>환불완료</td>
                    </tr>
                    <tr>
                        <td>환불</td>
                        <td><a href="/bookjuck/member/mypage/refundorderdetail.do" class="ordernumber">00000000</a></td>
                        <td>2021-02-17</td>
                        <td class="book">자바의 정석<span class="amount">외 3</span></td>
                        <td>4</td>
                        <td>환불완료</td>
                    </tr>
                    <tr>
                        <td>환불</td>
                        <td><a href="/bookjuck/member/mypage/refundorderdetail.do" class="ordernumber">00000000</a></td>
                        <td>2021-02-17</td>
                        <td class="book">자바의 정석<span class="amount">외 3</span></td>
                        <td>4</td>
                        <td>환불완료</td>
                    </tr>
                    <tr>
                        <td>환불</td>
                        <td><a href="/bookjuck/member/mypage/refundorderdetail.do" class="ordernumber">00000000</a></td>
                        <td>2021-02-17</td>
                        <td class="book">자바의 정석<span class="amount">외 3</span></td>
                        <td>4</td>
                        <td>환불완료</td>
                    </tr>

                </table>


                <ul class="pagination">
	                <li>
	                <a href="#" aria-label="Previous">
	                    <span aria-hidden="true">&laquo;</span>
	                </a>
	                </li>
	                <li><a href="#">1</a></li>
	                <li><a href="#">2</a></li>
	                <li><a href="#">3</a></li>
	                <li><a href="#">4</a></li>
	                <li><a href="#">5</a></li>
	                <li>
	                <a href="#" aria-label="Next">
	                    <span aria-hidden="true">&raquo;</span>
	                </a>
	                </li>
            	</ul>

            </article>

            
            <!-- datepicker 현재 날짜로 기본값 설정 -->
            <script>
                document.getElementById('date_before_month').valueAsDate = new Date();
                document.getElementById('now_date').valueAsDate = new Date();
            </script>



            <div class="refund-info">
                <h5>안내사항</h5>
                <ul>
                    <li>교환신청은 상품의 결함 및 계약내용과 다를 경우 문제점 발견 후 30일 이내 가능합니다.</li>
                    <li>변심반품의 경우 수령 후 7일 이내, 상품의 결함 및 계약내용과 다를 경우 문제점 발견 후 30일 이내 가능합니다.</li>
                    <li>오픈마켓, 기프트, 중고장터, 해외배송주문, 바로드림주문건은 <b>[1:1 상담]</b>으로 문의 바랍니다. <a href="/bookjuck/member/mypage/servicecenter.do"><input type="button" class="btn btn-xs btn-general" value="1:1 상담 문의"></a></li>
                    <li><b>반품처리 절차 : 반품신청 > 접수 > 반품회수 > 회수완료 > 반품완료</b></li>
                    <li><b>교환처리 절차 : 교환신청 > 접수 > 처리중 > 교환완료</b></li>
                    <li>반품/교환신청건은 접수 이전 상태에서 신청취소가 가능합니다.
                </ul>
            </div>
            
        </section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	

</body>

</html>