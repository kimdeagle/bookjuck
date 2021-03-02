<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::주문완료</title>


<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/orderlist.css">
<link rel="stylesheet" href="/bookjuck/css/order.css">

<style>


table td:last-child {
	border-right: 0;
	vertical-align: middle;
}


table tr td>button{
    
    width: 80px;
}


</style>
</head>

<body>

	<!-- header ~ footer > 플로팅 메뉴(북적이, top)를 제외한 나머지 전부를 담는 컨테이너) -->
	<!-- ########## 컨테이너 시작 -->
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
	
	
	<!-- 섹션 메뉴 -->
	
	<section class="mainsection">
	
		<article>
			<div class="statebox">
				<div class="img-orderstate" style="background-image: url(/bookjuck/image/clipboard1.png);"></div>
				<div><h3>주문완료</h3>주문 내역을 확인해주세요.</div>
				<div class="orderstep">
					<div><div>STEP01</div><div>장바구니&nbsp;&nbsp;&nbsp;></div></div>
					<div><div>STEP02</div><div>주문/결제&nbsp;&nbsp;&nbsp;></div></div>
					<div class="on"><div>STEP03</div><div>주문완료</div></div>
				</div>
			</div>
		</article>
		
		
		<article class="orderlistbox" style="margin: 0 auto; width:1000px; margin-bottom: 300px;">
			<h3>주문 내역</h3>
			<table class="orderList table tbl-lg">
		        <tr>
		            <th>주문번호</th>
		            <th>주문금액</th>
		            <th>상품정보</th>
		            <th>수량</th>
		            <th style="border-right: 1px solid #DDD;">주문상태</th>
		            <th style="border-right: 0;">취소/교환/환불</th>
		        </tr>
		        <tr class="olInfo">
		            <td>
		                <a href="/bookjuck/member/mypage/orderdetail.do">1398451</a><br>
		                (2021-03-02)<br><br>
		                <a href="/bookjuck/member/mypage/orderdetail.do" onclick="" class="btn-order">주문상세보기</a>
		            </td>
		            <td>80000</td>
		            <td>
		                <img src="/bookjuck/image/박기당 컬렉션.png" class="book-xs">
		                <a href="#">박기당 컬렉션</a>
		            </td>
		            <td>3</td>
		            <td style="border-right: 1px solid #DDD; vertical-align: middle">결제완료</td>
		            <td>
		                <button type="submit" class="btn" onclick="location.href='';" style="margin-top:11px; margin-bottom: 5px;">취 소</button>
		                <button type="submit" class="btn" onclick="location.href='';" style="margin-bottom: 5px;">교 환</button>
		                <button type="submit" class="btn" onclick="location.href='';" style="margin-bottom: 5px;">환 불</button>
		            </td>
		        </tr>
		    </table>
		    
		    
	    </article>
	
	</section>
	
	
	
	



	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->


	<!-- ########## 컨테이너 끝 -->
	</div>


	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>

	<script>
	
	</script>

</body>

</html>