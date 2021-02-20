<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>

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
	
	        <h3>취소/교환/환불 조회</h3>
	
	            
	        <table class="table tbl-md search-type">
	            <tr>
	                <th>분류</th>
	                <td colspan="2">
	                    <select name="category" class="form-control">
	                        <option value="자사배송">자사배송</option>
	                        <option value="E-Book">E-Book</option>
	                        <option value="바로드림">바로드림</option>
	                    </select>
	                </td>
	                <th>주문상태</th>
	                <td>
	                    <select name="orderstate" class="form-control">
	                        <option value="통합검색">통합검색</option>
	                        <option value="주문취소">주문취소</option>
	                        <option value="주문교환">주문교환</option>
	                        <option value="주문환불">주문환불</option>
	                    </select>
	                </td>
	                <td rowspan="4">
	                    <input type="button" class="btn btn-general" id="btnview" value="조회하기">
	                </td>
	            </tr>
	            <tr>
	                <th>주문기간</th>
	                <td class="period" colspan="2">
	                    <input type="button" class="btn btn-sm" value="일주일">
	                    <input type="button" class="btn btn-sm" value="1개월">
	                    <input type="button" class="btn btn-sm" value="3개월">
	                    <input type="button" class="btn btn-sm" value="6개월">
	                </td>
	                <td colspan="2">
	                    <input type="date"class="form-control" id="date_before_month"> ~
	                    <input type="date"class="form-control" id="now_date">
	                </td>
	            </tr>
	            <tr>
	                <th>주문번호</th>
	                <td colspan="2">
	                    <input type="text" class="form-control" placeholder="주문번호를 입력하세요.">
	                </td>
	                <th>주문자ID</th>
	                <td>
	                    <input type="text" class="form-control" placeholder="주문자ID를 입력하세요.">
	                </td>
	            </tr>
	            <tr>
	                <th>주문상품</th>
	                <td colspan="4">
	                    <input type="text" class="form-control" placeholder="상품명을 입력하세요.">
	                </td>
	            </tr>
	            <tr>
	                <td colspan="6"></td>
	            </tr>
	        </table>
	
	        <b class="subtitle">취소/교환/환불 조회 결과</b>
	        <table class="table tbl-md tbl-result">
	            <tr>
	                <th>분류</th>
	                <th>주문번호</th>
	                <th>주문자ID</th>
	                <th>상품정보</th>
	                <th>주문일자</th>
	                <th>주문상태</th>
	            </tr>
	            <tr>
	                <td>자사배송</td>
	                <td><a href>00002222</a></td>
	                <td>test0123</td>
	                <td>자바의 정석<span class="amount">외 3</span></td>
	                <td>2021-02-20</td>
	                <td>주문교환</td>
	            </tr>
	            <tr>
	                <td>자사배송</td>
	                <td><a href>00003333</a></td>
	                <td>test0123</td>
	                <td>자바의 정석</td>
	                <td>2021-02-20</td>
	                <td>주문환불</td>
	            </tr>
	            <tr>
	                <td>E-Book</td>
	                <td><a href>00004444</a></td>
	                <td>test0123</td>
	                <td>개인주의자 선언</td>
	                <td>2021-02-20</td>
	                <td>주문취소</td>
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
	    </section>


		<!-- datepicker 현재 날짜로 기본값 설정 -->
		<script>
        document.getElementById('date_before_month').valueAsDate = new Date();
        document.getElementById('now_date').valueAsDate = new Date();
    	</script>



		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- ########## 하단 끝 -->

	</div>


	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp"%>
	<%@include file="/WEB-INF/views/common/top.jsp"%>
		
		
</body>

</html>