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

            <!-- 바로드림, 비회원 안 보임 -->
            <b>바로드림</b>
            <table class="orderdetail table tbl-md">
               <tr>
                  <th>주문번호</th>
                  <th>주문금액</th>
                  <th>상품정보</th>
                  <th>수량</th>
                  <th>주문상태</th>
               </tr>
               <tr class="olInfo">
                  <td rowspan="${balist.size()}">${seqBaroOrder}<br>
                  (${orderDate.substring(0, 10)})
                  </td>
                  <c:forEach items="${balist}" var="badto">
                  <td style="vertical-align: middle;">${badto.total}</td>
                  <td class="bookinfo"><img
                     src="/bookjuck/image/book/${badto.image}" class="book-xs"> <a
                     href="/bookjuck/member/book/bookdetail.do?seq=${badto.seqBook}">${badto.title}</a></td>
                  <td>${badto.amount}</td>
                  <td>${badto.orderState}
                  </td>
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
               <c:forEach items="${plist}" var="pdto">
               <tr>
                  <td>${pdto.totalPay}</td>
                  <!-- 비회원일 경우 0 -->
                  <td>${pdto.usePoint}</td>
                  <td><span>${pdto.payment}</span>${pdto.actualPay}</td>
                  <!-- 비회원일 경우 0 -->
                  <td>${pdto.savePoints}</td>
               </tr>
               </c:forEach>
            </table>
         </article>


         <!-- ######## 이 이후 다은 추가 - 교환/취소/환불 정보 -->
         <c:if test="${ordertype != 'other'}"> 
         
         <article>
            <h5>환불정보</h5>
            <table class="tbl-pay table tbl-md">
               <tr>
                  <th>주문금액</th>
                  <th>사용 포인트</th>
                  <th>환불금액</th>
                  <th>환불 포인트</th>
               </tr>
               <c:forEach items="${plist}" var="pdto">
               <tr>
                  <td>${pdto.totalPay}</td>
                  <!-- 비회원일 경우 0 -->
                  <td>${pdto.usePoint}</td>
                  <td><span>${pdto.payment}</span>${pdto.actualPay}</td>
                  <!-- 비회원일 경우 0 -->
                  <td style="color: red;">${pdto.usePoint - pdto.savePoints}</td>
               </tr>
               </c:forEach>
            </table>
            <div style="margin-top: -16px;">
				<small>⚠ 환불 포인트가 마이너스 금액인 경우 포인트가 차감됩니다.</small>
			</div>
         </article>
         
         
			<!--
  			무통장 입금으로 결제한 고객 환불해줄 환불 계좌 정보
			<article>

                <h5>환불 계좌 정보 <small>(무통장 입금 고객)</small></h5>
                <table class="receiver table tbl-md">
                    <tr>
                        <th>예금주</th>
                        <td>예금주 이름</td>
                        <th>은행명</th>
                        <td>은행이름</td>                        
                    </tr>
                    <tr>
                        <th>계좌번호</th>

                        <td colspan="3">계좌번호적으세요</td>

                    </tr>
                </table>
                
            </article> 
            -->
         
		<c:if test="${not empty cancelinfo}">
			<article>
				<h5>주문 취소 정보</h5>
	
				<table class="table tbl-md tbl-refundinfo">
					<tr>
						<th>사유</th>
						<td>${cancelinfo.cancelReason}</td>
						<th>신청일</th>
						<td>${cancelinfo.cancelDate.substring(0,10)}</td>
					</tr>
					<tr>
						<th>상세사유</th>
						<c:if test="${empty cancelinfo.cancelReasonDetail}">
							<td colspan="3">-</td>
						</c:if>
						<c:if test="${not empty cancelinfo.cancelReasonDetail}">
							<td colspan="3">${cancelinfo.cancelReasonDetail}</td>
						</c:if>
					</tr>
					<tr>
						<th>처리상태</th>
						<td>${cancelinfo.cancelState}</td>
						<th>처리날짜</th>
						<td>
						<c:if test="${cancelinfo.cancelState == '취소완료'}">
							${cancelinfo.cancelDate.substring(0,10)}
						</c:if>
						</td>
					</tr>
				</table>
	
			</article>
		</c:if>
            
         </c:if>
         <!-- ######## 이 이전 다은 추가 - 교환/취소/환불 정보 -->

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