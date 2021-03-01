<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::주문관리</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp"%>


<link rel="stylesheet" href="/bookjuck/css/global.css">

<link rel="stylesheet" href="/bookjuck/css/adminorder.css">

<style>
</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp"%>


		<!-- 관리자 페이지 contentsection -->
		<section class="contentsection">
			<article class="list-form">

				<h3>주문/배송 조회</h3>

				
				<form method="GET" action="/bookjuck/admin/order/orderlist.do" id="searchForm">
				<table class="table tbl-md search-type">
					<tr>
						<th>분류</th>
						<td colspan="4">
							<select name="type" id="type" class="form-control">
									<option value="1">일반배송</option>
									<option value="2">바로드림</option>
									<option value="3">E-Book</option>
							</select>
						</td>
						<td rowspan="4"><input type="button" class="btn btn-general"
							id="btnview" value="조회하기" onclick="$('#searchForm').submit();"></td>
					</tr>
					<tr>
						<th>주문기간</th>
						<td class="period" colspan="2">
                            <input type="button" class="btn btn-sm" id="btn1" value="일주일">
                            <input type="button" class="btn btn-sm" id="btn2" value="1개월">
                            <input type="button" class="btn btn-sm" id="btn3" value="3개월">
                            <input type="button" class="btn btn-sm" id="btn4" value="6개월">
						</td>
						<td colspan="2">
						    <input type="date" class="form-control" id="startDate" name="startDate" min="2019-03-01"> ~
                            <input type="date" class="form-control" id="endDate" name="endDate" min="2019-03-01">
						</td>
					</tr>
					<tr>
						<th>주문번호</th>
						<td colspan="2"><input type="text" class="form-control"
							placeholder="주문번호를 입력하세요." id="ordernumsearch" name="ordernumsearch" value="${ordernumsearch}"></td>
						<th>주문자ID</th>
						<td><input type="text" class="form-control"
							placeholder="주문자ID를 입력하세요." id="idsearch" name="idsearch" value="${idsearch}"></td>
					</tr>
					<tr>
						<th>주문상품</th>
						<td colspan="4"><input type="text" class="form-control"
							placeholder="상품명을 입력하세요." id="booksearch" name="booksearch" value="${booksearch}" ></td>
					</tr>
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				</form>

				<b class="subtitle">주문 내역 조회 결과</b>
				
				<table class="table tbl-md tbl-result">
					<tr>
						<th>주문번호</th>
						<th>주문자ID</th>
						<th>상품정보</th>
						<th>주문일자</th>
						<th>수량</th>
						<th>주문상태</th>
					</tr>
					
					
					<c:if test="${not empty blist }">
					<c:forEach items="${blist}" var="dto">
					<tr>
						<td><a href="/bookjuck/admin/order/adorderdetail.do?seqBookOrder=${dto.seq}&id=${dto.id}">123456${dto.seq}</a></td>
						<td>${dto.id}</td>
						<td>${dto.title}
							<c:if test="${dto.totalAmount > 1}">
							<span class="amount">외 ${dto.totalAmount - 1}</span>
							</c:if>
						</td>
						<td>${dto.orderDate}</td>
						<td>${dto.totalAmount}</td>
						<td>${dto.orderState}</td>
					</tr>
					</c:forEach>
					</c:if>
					
					<c:if test="${not empty balist }">
					<c:forEach items="${balist}" var="dto">
					<tr>
						<td><a href="/bookjuck/admin/order/adbaroorderdetail.do?seqBaroOrder=${dto.seq}&id=${dto.id}">567891${dto.seq}</a></td>
						<td>${dto.id}</td>
						<td>${dto.title}
							<c:if test="${dto.totalAmount > 1}">
							<span class="amount">외 ${dto.totalAmount - 1}</span>
							</c:if>
						</td>
						<td>${dto.orderDate}</td>
						<td>${dto.totalAmount}</td>
						<td>${dto.orderState}</td>
					</tr>
					</c:forEach>
					</c:if>
					
					<c:if test="${not empty elist }">
					<c:forEach items="${elist}" var="dto">
					<tr>
						<td><a href="/bookjuck/admin/order/adebookorderdetail.do?seqEBookOrder=${dto.seq}&id=${dto.id}">987654${dto.seq}</a></td>
						<td>${dto.id}</td>
						<td>${dto.title}</td>
						<td>${dto.orderDate}</td>
						<td>${dto.totalAmount}</td>
						<td>${dto.orderState}</td>
					</tr>
					</c:forEach>
					</c:if>
					

				</table>


                <nav class="pagebar">
                    <ul class="pagination">
                        ${pagebar}
                    </ul>
                </nav>
                

			</article>
		</section>




		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- ########## 하단 끝 -->

	</div>


	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp"%>
	
	
	
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
	    
	    //초기세팅은 과거 3개월 까지 검색
	    $(document).ready(function(){
			
			var nowdate = new Date();
			var beforedate = new Date();
			
			beforedate.setMonth(nowdate.getMonth() - 3);
			
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
		
		
</body>

</html>