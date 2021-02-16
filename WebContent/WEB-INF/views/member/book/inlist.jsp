<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::Welcome</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/global.css">

<!-- sidemenu.css -->
<link rel="stylesheet" href="/bookjuck/css/category.css">


<style>

	/* 이미지 셀 */
	table td:nth-child(1) {
		height: 200px;
	}
	
	/* 텍스트 셀 */
	table td:nth-child(2) {
		width: 500px;
		height: 200px;
	}
	
	/* 텍스트 margin */
	table td:nth-child(2) div {
		margin: 5px 15px;
	}
	
	/* 수량 및 버튼 셀 */
	table td:nth-child(3) {
		width: 200px;
		height: 200px;
		text-align: right;
	}

	/* 이미지 */
	table td .image {
		height: 200px;
	}
	
	/* 텍스트 > 제목 */
	table td .title {
		font-size: 2em;
	}
	
	table td .info {
		
	}
	
	table td .subinfo {
	
	}
	
	/* 도서 소개 */
	table td .intro {
		height: 45px;
		overflow: hidden;
	}
	
	table td .priceinfo {
	
	}
	
	/* 텍스트 > 정가 + 가격 */
	table td .priceinfo .price {
		font-size: 0.9em;
	}
	
	/* 텍스트 > 판매가 */
	table td .priceinfo .saleprice {
		font-size: 1.3em;
		margin-left: 50px;
	}
	
	/* 텍스트 > 판매가격 */
	table td .priceinfo .saleprice strong {
		color: red;
		font-size: 1.5em;
	}
	
	/* 수량 > + , - 버튼 */
	table td .amount input[type=button] {
		outline: none !important;
	}
	
	/* 수량 > 텍스트박스 */
	table td .amount input[type=text] {
		width: 50px;
		height: 30px;
		text-align: right;
	}
	
	/* 버튼 */
	table td .btns button {
		display: inline-block;
		width: 57%;
		margin-top: 7px;
		outline:none !important;
	}

</style>
</head>

<body>

	<div class="container">

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
	<!-- ########## 상단 헤더 끝 -->
	
	
	<!-- ########## 카테고리 사이드 메뉴 시작 -->
    <%@include file="/WEB-INF/views/member/inc/category.jsp" %>
	<!-- ########## 카테고리 사이드 메뉴 끝 -->
	
	
	<!-- 섹션 메뉴 -->
	<section class="contentsection">
       <h6>국내도서 > 소설 > 한국소설</h6>
       <table class="tblbooklist">
       	<tbody>
       		<tr>
       			<td>
       				<img src="/bookjuck/image/바이러스 X.png" id="image1" class="image">
       			</td>
       			<td>
       				<div class="title">대체불가 라틴아메리카</div>
       				<div class="info">장재준 | 의미와재미</div>
       				<div class="subinfo">2021년 1월 20일 | 292쪽</div>
       				<div class="intro">다양성과 혼종성, 식민성과 근대성이 공존하는 곳.<br />잉카, 마야, 아스텍 문명을 품은 땅에서 이민족의 오랜 야만을 인내한 사람들.</div>
       				<div class="priceinfo">
       					<span class="price" id="price"><s>정가 17,000원</s></span>
       					<span class="saleprice" id="saleprice">판매가 <strong>15,300</strong>원</span>
       				</div>
       			</td>
       			<td>
       				<div class="form-inline amount">
       					<input type="button" value="-" class="btn btn-default btn-sm">
       					<input type="text" value="1" class="form-control">
       					<input type="button" value="+" class="btn btn-default btn-sm">
       				</div>
       				<div class="btns">
        				<button class="btn btn-success btn-lg cart">장바구니</button>
        				<button class="btn btn-primary btn-lg buy">바로구매</button>
        				<button class="btn btn-warning btn-lg baro">바로드림</button>
       				</div>
       			</td>
       		</tr>        		
       	</tbody>
       </table>
       <hr>
       
       </section>


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<script>
	
	</script>

</body>

</html>