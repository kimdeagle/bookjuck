<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::주문/결제내역 리스트| MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/orderlist.css">

<!-- datepicker -->
<!-- <link rel="stylesheet" href="/bookjuck/node_modules/bootstrap/dist/css/bootstrap-datepicker.min.css"> -->
<!-- <script src="/bookjuck/node_modules/bootstrap/dist/js/bootstrap-datepicker.js"></script> -->
<!-- <script src="/bookjuck/node_modules/bootstrap/dist/js/bootstrap-datepicker.ko.min.js"></script> -->


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
		
		 
		 
		 <!-- 주문자 정보 영역 -->
        <section class="contentsection">
            <h3>주문/결제 조회</h3>
                <!-- 비회원만 보임 -->
            <article>
                
                <table class="orderer table tbl-md">
                    <tr>
                        <th>주문자</th>
                        <td>${name}&nbsp |&nbsp ${tel}&nbsp |&nbsp ${email}</td>
                    </tr>
                </table>
                <!-- 비회원일때 회원가입 유도 -->
                <c:if test="${empty id}">
                <div>※ 비회원은 최대 1개월 내의 주문 내역을 확인하실 수 있습니다. &nbsp&nbsp&nbsp<a href="/bookjuck/member/register.do" class="btn1" style="font-weight: bold;">회원가입</a></div>
                </c:if>
            </article>
            
            
            
            <article>
            	<div class="order-state-box">
            		<ul class="order-state">
            			<li class="cell1"><span><b>주문완료 (${cnt1})</b></span></li>
            			<li class="cell2"><span><b>결제완료 (${cnt2})</b></span></li>
            			<li class="cell3"><span><b> 배송중 (${cnt3})</b></span></li>
            			<li class="cell4" style="width: 100px;"><span><b>배송완료 (${cnt4})</b></span></li>
            		</ul>
            		<div class="total-order">
            			<ul>
            				<li>취소 <span>${cnt5}건</span></li>
            				<li>교환 <span>${cnt6}건</span></li>
            				<li>환불 <span>${cnt7}건</span></li>            				
            			</ul>
            		</div>
            	</div>
            </article>
        
        
        	
        
            <article>
                <!-- 조회 기간 설정 -->
                <!-- 로그인한 회원만 보임 -->
                <form method="GET" action="/bookjuck/member/mypage/orderlist.do" id="#searchForm"></form>
                <c:if test="${not empty id}">
                <div class="periodbox">
                    <table class="periodtbl table tbl-md">
                        <tr>
                        <th>기간조회</th>
                        <td class="period" colspan="2">
                            <input type="button" class="btn btn-sm" id="btn1" value="일주일">
                            <input type="button" class="btn btn-sm" id="btn2" value="1개월">
                            <input type="button" class="btn btn-sm" id="btn3" value="3개월">
                            <input type="button" class="btn btn-sm" id="btn4" value="6개월">
                        </td>
                        <td>
                            <input type="date" class="form-control" id="startDate" name="startDate" min="2019-03-01"> ~
                            <input type="date" class="form-control" id="endDate" name="endDate" min="2019-03-01">
                            <input type="button" class="btn btn-general" id="btnview" value="조회하기" onclick="$('#searchForm').submit();">
                        </td>
                    </tr>
                    </table>
                </div>
        
                <div>※ 최근1개월이 기본으로 조회 되며, 기간 변경시 기간 선택 후 조회 버튼을 클릭해 주세요.</div>
                <div>※ 최근 2년부터 조회가 가능합니다.</div>
                </c:if>

                <!-- 조회 기간 ol:orderList-->
                <div class="olDate">yyyy-mm-dd ~ yyyy-mm-dd 까지의 주문 총 00건</div>

                <!-- 조회 리스트 -->
                <!-- 주문 내역이 없으면 보이는 화면 -->

				<c:if test="${empty blist && empty balist && empty elist}">
                <div class="noOrderList">
                    <span>주문 내역이 없습니다.</span>
                    
                    <img src="/bookjuck/image/bookjeok/chat.png">
                </div>
                </c:if>

                <!-- 주문 내역 있으면 보이는 리스트 -->
                <c:if test="${not empty blist || not empty balist || not empty elist}">
                <table class="orderList table tbl-md">
                    <tr>
                        <th>주문번호</th>
                        <th>주문금액</th>
                        <th>상품정보</th>
                        <th>주문상태</th>
                        <th>취소/교환/환불</th>
                    </tr>
                    
	                <c:if test="${not empty blist}">
                    <c:forEach items="${blist}" var="bodto">
                    <tr class="olInfo">
                        <td>
                            <a href="/bookjuck/member/mypage/orderdetail.do?seqBookOrder=${bodto.seqBookOrder}">123456${bodto.seqBookOrder}</a><br>
                            (${bodto.orderDate})<br><br>
                            <a href="/bookjuck/member/mypage/orderdetail.do?seqBookOrder=${bodto.seqBookOrder}" class="btn-order">주문상세보기</a>
                        </td>
                        <td>${bodto.actualPay}</td>
                        <td>
                            <img src="/bookjuck/image/book/${bodto.image}" class="book-xs">
                            <div>
                            <a href="/bookjuck/member/book/bookdetail.do?seq=${bodto.seqBook}">${bodto.title}
                            </a>
                            </div>
                        </td>
                        <td>${bodto.orderState}</td>
                        <td>
                        	<c:if test="${not empty id}">
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/cancelapplication.do?type=1&seqOrder=${bodto.seqBookOrder}';">취 소</button>
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/returnapplication.do?type=1&seqOrder=${bodto.seqBookOrder}';">교 환</button>
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/refundapplication.do?type=1&seqOrder=${bodto.seqBookOrder}';">환 불</button>
                            </c:if>
                        </td>
                    </tr>
                    </c:forEach>
                    </c:if>
                    
                    <c:if test="${not empty balist}">
                    <c:forEach items="${balist}" var="badto">
                    <tr class="olInfo">
                        <td>
                            <a href="/bookjuck/member/mypage/baroorderdetail.do?seqBaroOrder=${badto.seq}">567891${badto.seq}</a><br>
                            (${badto.orderDate})<br><br>
                            <a href="/bookjuck/member/mypage/baroorderdetail.do?seqBaroOrder=${badto.seq}" class="btn-order">주문상세보기</a>
                        </td>
                        <td>${badto.actualPay}</td>
                        <td>
                            <img src="/bookjuck/image/book/${badto.image}" class="book-xs">
                            <a href="/bookjuck/member/book/bookdetail.do?seq=${badto.seqBook}">${badto.title}
                            
                            </a>
                        </td>
                        <td>${badto.orderState}</td>
                        <td>
                        	<c:if test="${empty not id}">
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/cancelapplication.do?type=2&seqOrder=${badto.seq}';">취 소</button>
                            </c:if>
                        </td>
                    </tr>
                    </c:forEach>
                   	</c:if>
                   	
                   	<c:if test="${not empty elist}">
                    <c:forEach items="${elist}" var="edto">
                    <tr class="olInfo">
                        <td>
                            <a href="/bookjuck/member/mypage/ebookorderdetail.do?seqEBookOrder=${edto.seq}">987654${edto.seq}</a><br>
                            (${edto.orderDate})<br><br>
                            <a href="/bookjuck/member/mypage/ebookorderdetail.do?seqEBookOrder=${edto.seq}" class="btn-order">주문상세보기</a>
                        </td>
                        <td>${edto.actualPay}</td>
                        <td>
                            <img src="/bookjuck/image/book/${edto.image}" class="book-xs">
                            <a href="/bookjuck/member/book/bookdetail.do?seq=${edto.seqBook}">${edto.title}
                            
                            </a>
                        </td>
                        <td>${edto.orderState}</td>
                        <td>
                        	<c:if test="${not empty id}">
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/refundapplication.do?type=3&seqOrder=${edto.seq}';">환 불</button>
                            </c:if>
                        </td>
                    </tr>
                    </c:forEach>
                    </c:if>
                </table>
                </c:if>   

            </article>


        </section>
		 
		 
		 
		 
		 
		 

	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->

	</div>
	
	
	

</body>


<script>

	
//date 'yyyy-mm-dd'형식으로 formating
function formatDate(date) {
   
	var month = date.getMonth() + 1;
    var day = date.getDate();
    var year = date.getFullYear();
   
    if (month < 10) 
        month = '0' + month;
    if (day < 10) 
        day = '0' + day; 

   return year + '-' + month + '-' + day;
}

var now = new Date();

//초기세팅은 과거 1개월 까지 검색
$(document).ready(function(){
	
	var nowdate = new Date();
	var beforedate = new Date();
	
	beforedate.setMonth(nowdate.getMonth() - 1);
	
	$("#startDate").val(formatDate(beforedate));
	$("#endDate").val(formatDate(now));
	
});


//분류 고정
$("#type").val("${type}").prop("selected",true);


  


//btn1 일주일 전
$("#btn1").click(function() {
	
	var nowdate = new Date();
	var beforedate = new Date();
	
	beforedate.setDate(nowdate.getDate() - 7);
	$("#startDate").val(formatDate(beforedate));
});

//btn2 한달 전
$("#btn2").click(function() {
	
	var nowdate = new Date();
	var beforedate = new Date();
	
	beforedate.setMonth(nowdate.getMonth() - 1);
	$("#startDate").val(formatDate(beforedate));
});

//btn3 세달 전
$("#btn3").click(function() {
	
	var nowdate = new Date();
	var beforedate = new Date();
	
	beforedate.setMonth(nowdate.getMonth() - 3);
	$("#startDate").val(formatDate(beforedate));
});

//btn4 여섯달 전
$("#btn4").click(function() {
	
	var nowdate = new Date();
	var beforedate = new Date();
	
	beforedate.setMonth(nowdate.getMonth() - 6);
	$("#startDate").val(formatDate(beforedate));
});



</script>

</html>