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
<link rel="stylesheet" href="/bookjuck/node_modules/bootstrap/dist/css/bootstrap-datepicker.min.css">
<script src="/bookjuck/node_modules/bootstrap/dist/js/bootstrap-datepicker.js"></script>
<script src="/bookjuck/node_modules/bootstrap/dist/js/bootstrap-datepicker.ko.min.js"></script>


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
                        <td>이름 | 연락처 | 이메일</td>
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
            			<li class="cell1"><b>주문완료 0</b></li>
            			<li class="cell2"><b>결제완료 0</b></li>
            			<li class="cell3"> <b> 배송중 0</b></li>
            			<li class="cell4" style="width: 80px;"><b>배송완료 0</b></li>
            		</ul>
            		<div class="total-order">
            			<ul>
            				<li>취소 <span>0건</span></li>
            				<li>교환 <span>0건</span></li>
            				<li>환불 <span>0건</span></li>            				
            			</ul>
            		</div>
            	</div>
            </article>
        
        
        	
        
            <article>
                <!-- 조회 기간 설정 -->
                <!-- 로그인한 회원만 보임 -->
                <c:if test="${not empty id}">
                <div class="periodbox">
                    <table class="periodtbl table tbl-md">
                        <tr>
                            <th style="padding-top:16px;">기간 조회</th>
                            <td>
                                <span class="sort_option">
                                <a id="period_1week"             href="javascript:;" onclick="periodChange(id)" >1주일</a>
                                <a id="period_1month"            href="javascript:;" onclick="periodChange(id)" class="on">1개월</a>
                                <a id="period_3month"            href="javascript:;" onclick="periodChange(id)" >3개월</a>
                                <a id="period_6month"            href="javascript:;" onclick="periodChange(id)" >6개월</a>
                                </span>
                                
                                <input id="strDate" class="form-control" readonly="readonly" style="margin-left: 20px;">
                                ~
                                <input id="endDate" class="form-control" readonly="readonly">
                                <a href="javascript:void(0);" id="periodbtn" class="btn-order" onclick="" >조 회</a>
                                
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

				<c:if test="${blist.size() == 0&&balist.size() == 0}">
                <div class="noOrderList">
                    <span>주문 내역이 없습니다.</span>
                    
                    <img src="/bookjuck/image/bookjeok/chat.png">
                </div>
                </c:if>

                <c:if test="${blist.size() > 0 || balist.size() > 0}">
                <!-- 주문 내역 있으면 보이는 리스트 -->
                <table class="orderList table tbl-md">
                    <tr>
                        <th>주문번호</th>
                        <th>주문금액</th>
                        <th>상품정보</th>
                        <th>주문상태</th>
                        <th>취소/교환/환불</th>
                    </tr>
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
                            <a href="/bookjuck/member/book/bookdetail.do?seq=${bodto.seqBook}">${bodto.title}
                            
                            </a>
                        </td>
                        <td>${bodto.orderState}</td>
                        <td>
                        	<c:if test="${empty not id}">
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/cancelapplication.do';">취 소</button>
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/returnapplication.do';">교 환</button>
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/refundapplication.do';">환 불</button>
                            </c:if>
                        </td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${balist}" var="badto">
                    <tr class="olInfo">
                        <td>
                            <a href="/bookjuck/member/mypage/orderdetail.do?seqBookOrder=${badto.seq}">567891${badto.seq}</a><br>
                            (${badto.orderDate})<br><br>
                            <a href="/bookjuck/member/mypage/orderdetail.do?seqBookOrder=${badto.seq}" class="btn-order">주문상세보기</a>
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
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/cancelapplication.do';">취 소</button>
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/returnapplication.do';">교 환</button>
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/refundapplication.do';">환 불</button>
                            </c:if>
                        </td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${elist}" var="edto">
                    <tr class="olInfo">
                        <td>
                            <a href="/bookjuck/member/mypage/orderdetail.do?seqBookOrder=${edto.seq}">987654${edto.seq}</a><br>
                            (${edto.orderDate})<br><br>
                            <a href="/bookjuck/member/mypage/orderdetail.do?seqBookOrder=${edto.seq}" class="btn-order">주문상세보기</a>
                        </td>
                        <td>${edto.actualPay}</td>
                        <td>
                            <img src="/bookjuck/image/book/${edto.image}" class="book-xs">
                            <a href="/bookjuck/member/book/bookdetail.do?seq=${edto.seqBook}">${edto.title}
                            
                            </a>
                        </td>
                        <td>${edto.orderState}</td>
                        <td>
                        	<c:if test="${empty not id}">
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/cancelapplication.do';">취 소</button>
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/returnapplication.do';">교 환</button>
                            <button type="submit" class="btn" onclick="location.href='/bookjuck/member/refund/refundapplication.do';">환 불</button>
                            </c:if>
                        </td>
                    </tr>
                    </c:forEach>
                </table>

                <!-- 페이지 바 -->
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
                </c:if>
                              

            </article>


        </section>
		 
		 
		 
		 
		 
		 

	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->

	</div>
	
	
	

</body>


<script>

	
		$(function(){
			   $("#strDate").datepicker({
			      format:'yyyy-mm-dd',
			      startDate:'-2y',
			      endDate : '0',
			      language: "ko"
			   
			   })
			});
		
		$(function(){
			   $("#endDate").datepicker({
			      format:'yyyy-mm-dd',
			      defaultDate:'2021-02-23',
			      startDate:'-2y',
			      endDate : '0',
			      language: "ko"
			   })
			});

		
		
		
	
	
	function periodChange(id) {
		console.log($(id));
		$(".sort_option a").attr('class','');
		$("#"+id).attr('class','on');
	}

</script>

</html>