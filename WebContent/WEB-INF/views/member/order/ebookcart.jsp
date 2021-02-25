<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::장바구니</title>


<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/orderlist.css">
<link rel="stylesheet" href="/bookjuck/css/order.css">
<link rel="stylesheet" href="/bookjuck/css/cart.css">

<style>

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
				<div class="img-orderstate"></div>
				<div><h3>장바구니</h3>주문하실 상품을 선택해 주세요.</div>
				<div class="orderstep">
					<!-- <div><span>STEP01</span><span>STEP02</span><span>STEP03</span></div>
					<div><span>장바구니 > </span><span>주문/결제 > </span><span>주문완료</span></div>
					 -->
					<div class="on"><div>STEP01</div><div>장바구니&nbsp;&nbsp;&nbsp;></div></div>
					<div><div>STEP02</div><div>주문/결제&nbsp;&nbsp;&nbsp;></div></div>
					<div><div>STEP03</div><div>주문완료</div></div>
				</div>
			</div>
		</article>
		
		
		<article class="cartbox">
		
			<div class="cart_prod_tab">
				<ul>
					<li><a href="/bookjuck/member/order/cart.do">일반구매</a></li>
					<li><a href="/bookjuck/member/order/barocart.do">바로드림</a></li>
					<li><a href="/bookjuck/member/order/ebookcart.do" class="on">E-Book</a></li>
				</ul>
			</div>
			
			<!-- 장바구니 내역이 없으면 보이는 화면 -->
                <div class="noOrderList">
                    <span>장바구니에 담긴 상품이 없습니다.</span>
                    
                    <img src="/bookjuck/image/bookjeok/chat.png">
                </div>
                
            
			
			<div class="cart_controller">
				<label>
					<input type="checkbox" id="check_all_top" name="check_all" class="cartcheck check_all" checked><span>전체선택</span>
				</label>
				<a href="javascript:void(0);" class="btn1">삭제</a>
			</div>
			
		    <!-- 없으면 안보임 -->
		    <div class="cartlistbox">
				<h4>E-Book</h4>
				<table id="ebookcart" class="cartlist table tbl-lg">
			        <tr>
			        	<th></th>
			            <th>상품정보</th>
			            <th>정가</th>
			            <th>판매가</th>
			            <th>수량</th>
			            <th>합계</th>
			        </tr>
			        <tr class="olInfo">
			        	<td><input type="checkbox" id="" class="cartcheck" checked></td>
			            <td>
			                <img src="/bookjuck/image/달러구트 꿈 백화점.png" class="book-xs">
			                <a href="#">도서명</a>
			            </td>
			            <td>정가</td>
			            <td>판매가</td>
			            <td>
			            	1
			            </td>
			            <td>판매가x수량</td>
			        </tr>
			    </table>
		    </div>
		    
		    <div class="carttotalpaybox">
		    	<table class="carttotalpay table tbl-lg">
		    		<tr>
		    			<th>상품 금액</th>
		    			<th>배송비</th>
		    			<th>결제 예정금액</th>
		    			<th>적립예정 포인트</th>
		    		</tr>
		    		<tr>
		    			<td>원</td>
		    			<td>원</td>
		    			<td style="color: #BC4B51">원</td>
		    			<td></td>
		    		</tr>
		    	</table>
		    </div>

			
			<div class="btn-box">
				<a href="/bookjuck/member/order/orderpaymemebook.do" onclick="" class="btn-order">주문하기</a>
			</div>
		    
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

	
		$(document).ready(function(){
			
			$(".check_all").click(function() {
				if($(".check_all").prop("checked")){
					$(".cartcheck").prop("checked",true);
				}else{
					$(".cartcheck").prop("checked",false);				
				}
				
			});
			
			/* ############ length == 장바구니에 담겨있는 책 + 1 ###########*/
			$(".cartcheck").click(function name() {
				if($(".cartcheck:checked").length==2){
					$(".check_all").prop("checked",true);
				}else{
					$(".check_all").prop("checked",false);
				}
			});
			
			$(".check_all").click(function() {
				if($(".check_all").prop("checked")){
					$(".cartcheck").prop("checked",true);
				}else{
					$(".cartcheck").prop("checked",false);				
				}
				
			});
			
			
		});
	
	</script>

</body>

</html>