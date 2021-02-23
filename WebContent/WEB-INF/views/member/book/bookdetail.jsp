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

<!-- bookdetail.css -->
<link rel="stylesheet" href="/bookjuck/css/bookdetail.css">

<!-- booklist.js -->
<script src="/bookjuck/js/booklist.js"></script>


<style>

</style>
</head>

<body>

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
	
	
	<!-- ########## 카테고리 사이드 메뉴 시작 -->
    <%@include file="/WEB-INF/views/member/inc/category.jsp" %>
	<!-- ########## 카테고리 사이드 메뉴 끝 -->
	
	
	<!-- 섹션 -->
	<section class="contentsection">
		<table class="table">
			<thead>
				<tr>
					<th colspan="3"><h6>국내도서 > 소설 > 한국소설</h6></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<img src="/bookjuck/image/바이러스 X.png" class="image">
					</td>
					<td>
						<div class="title">대체불가 라틴아메리카</div>
						<div class="copy">물음표에서 시작되어, 느낌표로 돌아오는 라틴아메리카!</div>
						<div class="info">장재준 | 의미와재미</div>
						<div class="subinfo">2021년 1월 20일 | 292쪽</div>
						<div class="readtime">완독 예상 시간 : 2시간 50분</div>
						<div class="readtimeinfo" style="font-size: 0.8em;">(완독 예상 시간은 소개, 목차 등 전체 페이지를 기준으로 측정된 시간이며, 실제 완독 시간과 오차가 있을 수 있습니다.)</div>
						<div class="priceinfo">
							<span class="price" id="price"><s>정가 17,000원</s></span>
							<span class="saleprice" id="saleprice">판매가 <strong>15,300</strong>원</span>
							<span class="savepoint">(적립금 1,530원)</span>
						</div>
					</td>
					<td>
						<div class="form-inline amount">
							<input type="button" value="-" class="btn btn-default btn-sm" id="minus">
							<input type="text" value="1" class="form-control" id="cnt">
							<input type="button" value="+" class="btn btn-default btn-sm" id="plus">
						</div>
						<div class="btns">
							<button class="btn btn-success btn-lg btn-block cart">장바구니</button>
							<button class="btn btn-primary btn-lg btn-block buy">바로구매</button>
							<button class="btn btn-warning btn-lg btn-block baro">바로드림</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<h5>도서 소개</h5>
						<div class="intro">
							<p><strong>다양성과 혼종성, 식민성과 근대성이 공존하는 곳.<br>잉카, 마야, 아스텍 문명을 품은 땅에서 이민족의 오랜 야만을 인내한 사람들.<br>혁명과 저항, 희망과 열정이 층위를 이루는 대륙, 라틴아메리카!</strong></p>
							<p>“자연으로부터 축복 받은 라틴아메리카는 왜 역사로부터 저주를 받았을까?<br>프로축구 수원삼성 서포터스는 대관절 무슨 생각으로 체 게바라 깃발을 흔드는 걸까?<br>새들은 왜 페루에 가서 죽고, 어떻게 조류의 배설물이 중남미 지도를 바꿔놨을까?<br>정말이지 좁힐 수 없는 다리 사이의 거리 때문에 탱고는 에로틱한 걸까?<br>화려한 골반문화로 발산되는 쿠바의 낙천성은 그저<br>어금니 깨문 자들의 이빨 빠진 웃음에 불과할까?”</p>
							<p>이 책은 이런 질문들로부터 시작되었다고, 저자는 밝히고 있다. 나열되는 다수의 질문 가운데는 책 안에서 답을 찾은 것도 있고, 여전히 물음표 상태로 남은 것들도 있다. 33개국에 6억이 넘는 인구가 사는 곳, 잉카, 마야, 아스텍 등 화려한 고대문명을 꽃피운 곳, 남북의 길이만 1만2,000㎞에 달하는 광대한 대륙. 다채롭고 풍요로운 땅이지만, 생각해보면 라틴아메리카는 늘 우리의 관심 또는 지적 우선순위에서 벗어나 있던 땅이었다. 급기야 21세기 지구의 역사에서는 변방으로 밀려나버린 대륙. “자연으로부터 축복 받은 라틴아메리카는 왜 역사로부터 저주 받았을까?”라는 첫 번째 질문이 책장을 넘기는 내내 목구멍에 걸린 가시처럼 아리다.</p>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<h5>목차</h5>
						<div class="index">
							<strong>1 경계_길 위에 핀 꽃</strong>
							국가의 바깥에 버려진 경계인(질)들<br>달달한 자본주의<br>그래, 우리는 식인종이다!<br>왕실을 뒷배로 거느린 로열해적<br>국경에 매달린 관<br>자유무역이 낳은 보호 장벽: 트럼프와 흉노족<br>천 년의 미소를 머금은 신라 여인과 안데스 사내<br>모체(Moche)의 후손(?) 폴 고갱에 대한 단상<br>짚신 신고 라틴아메리카로<br>쿠바의 애니깽들
							<strong>2 아바나_음악의 섬</strong>
							웃음도 문화일까<br>피아노에 갇힌 건반<br>가장 낮은 옥타브는 눈물이다<br>누가 그들의 골반을 단속할 수 있을까<br>〈쿠바의 연인〉; 인터뷰, 사이에서 보기(inter-view)
							<strong>3 혁명_총알처럼 시를 품고</strong>
							길이 체 게바라를 만들었고 체 게바라는 길이 되었다<br>체 게바라도 걷지 못한 길: 알베르토 그라나도의 ‘My Way’<br>총알처럼 시를 품고 게릴라와 함께 했던 시인들<br>전사 그리스도에서부터 빳빳한 남근 이미지까지<br>주걱을 든 페트라가 아니라 총을 쥔 페드로<br>미완을 그린 프리다<br>아멜리아에서 아멜리오로<br>아델리타 : 기억과 해석 투쟁<br>판초 비야와 벌거벗은 여자 사이
							<strong>4 차스키_발바닥이 날개였던 잉카의 파발꾼</strong>
							달리는 인간, 호모 쿠란스<br>발바닥으로 이룩한 네트워크 혁명<br>머물 수는 있어도 멈출 수는 없다<br>잉카의 헤르메스<br>잉카의 다기능 복합 센터, 탐보<br>진흙 문명을 품은 돌의 문명
							<strong>5 슈거노믹스_설탕으로 빚은 땅</strong>
							설탕으로 빚은 섬<br>바다 위의 사탕수수밭, 바베이도스<br>신대륙 발견 & 사탕수수 재배지의 발견<br>햄버거에 조롱당한 음식천국 멕시코<br>여전히, 초콜릿은 쓰다<br>부패하는 화폐, 카카오 머니<br>옥수수 없이는 나라도 없다
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<h5>작가 소개</h5>
						<blockquote>
							<mark>장재준</mark>
							<p>서울대학교 서어서문학과를 졸업하고, 멕시코 과달라하라 대학교와 미국 코넬 대학교에서 중남미문학을 전공했다. 현재 서울대학교 외래교수 겸 한국외국어대학교 특임교수로 재직 중이다. 저서로는 &lt;스페인어권 명작의 이해&gt;(공저), &lt;리듬으로 사유하기&gt;(공저), &lt;디코딩 라틴아메리카&gt;(공저) 등이 있다.</p>
						</blockquote>
					</td>
				</tr>
			</tbody>
		</table>
       
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