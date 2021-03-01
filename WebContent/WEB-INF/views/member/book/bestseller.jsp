<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
   
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적::Welcome</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>
<link rel="stylesheet" href="/bookjuck/css/bestseller.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">

<style>
</style>

</head>
<body>

	<div class="container">
	<%	
		out.flush();
		RequestDispatcher dheader = request.getRequestDispatcher("/member/inc/header.do");
		dheader.include(request, response);
	%>
		<%-- <%@include file="/WEB-INF/views/common/searchview.jsp"%> --%>
		<div class="bestSellerList">
			<div id="menuname1">베스트도서</div>
			<nav id="leftmenu">
				<div>
					<a href="/bookjuck/member/book/bestseller.do" class="list1"><strong>종합</strong></a></strong>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=소설" class="list1">소설</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=시/에세이" class="list1">시/에세이</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=경제/경영" class="list1">경제/경영</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=인문" class="list1">인문</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=역사/문화" class="list1">역사/문화</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=종교" class="list1">종교</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=정치/사회" class="list1">정치/사회</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=예술/대중문화" class="list1">예술/대중문화</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=과학" class="list1">과학</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=기술/공학" class="list1">기술/공학</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=컴퓨터/IT" class="list1">컴퓨터/IT</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=유아/어린이/청소년" class="list1">유아/어린이/청소년</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=참고서/교재" class="list1">참고서/교재</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=취업/수험서" class="list1">취업/수험서</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?a=외국어" class="list1">외국어</a>
				</div>
			</nav>
			
		
			<div class="bestSellerListRight">
			<span class="intro" style="font-weight: bold; position:absolute; left:200px; top:30px;">북적북적의 베스트셀러를
					소개합니다.</span>
				<br>
				<form id="searchform" method="GET" action="/bookjuck/member/book/bestseller.do" style="position:absolute; left:200px;">
					<div id="choicedate">
						<!-- 기간 선택 -->
						<input type="text" name="yearStart" id="yearStart" style="width: 50px;" placeholder="YYYY" class="datebtn" value="${yearStart}">
						<input type="text" name="monthStart" id="monthStart" style="width: 50px;" placeholder="MM" class="datebtn" value="${monthStart}">
						<input type="text" name="dayStart" id="dayStart" style="width: 50px;" placeholder="DD" class="datebtn" value="${dayStart}"> 
						~ 
						<input type="text" name="yearEnd" id="yearEnd" style="width: 50px;" placeholder="YYYY" class="datebtn" value="${yearEnd}">
						<input type="text" name="monthEnd" id="monthEnd" style="width: 50px;" placeholder="MM" class="datebtn" value="${monthEnd}"> 
						<input type="text" name="dayEnd" id="dayEnd" style="width: 50px;" placeholder="DD" class="datebtn" value="${dayEnd}">
						<input type="submit" value="기간검색" class="dateselect" id="searchbutton">
					</div>
					<c:if test="${not empty a}">
					<input type="hidden" name="a" id="a" value="${a}">
					</c:if>
				</form>
				<br>
				<c:if test="${not empty yearStart}">
				<div style="font-weight: bold; position:absolute; left:200px; top:120px;">
    			'${yearStart}-${monthStart}-${dayStart}' ~ '${yearEnd}-${monthEnd}-${dayEnd}' 기간의 베스트셀러 조회결과 입니다.
				
    			</div>
    			<br>
    			</c:if>
				<br>
				<br>
				<c:if test="${list3.size() == 0}">

						<div style="position:absolute; left:200px; top:150px;"><b style="font-size: 1.5em;">해당 기간의 도서 목록이 없습니다.</b></div>

				</c:if>
				
				
				
				
				<c:forEach items="${list1}" var="dto">
				<div class="bookbox">
					<div class="bestrank1">
						<a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><img src="/bookjuck/image/${dto.image}"></a>
						<div class="bookname">
							<a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><strong style="font-size: 1.3em;">${dto.title}</strong></a>
						</div>
						<div class="bookinfo">${dto.author}| ${dto.publisher} |
							${dto.pubDate}</div>
						<div class="bookcopy">${dto.copy}</div>
						<div class="price">가격:${String.format('%,d', dto.price)}원</div>
						<div class="rank1btn">
							<div>
								<input type="button" class="btn btn-default" value="바로결제">
							</div>
							<div>
								<input type="button" class="btn btn-danger" value="바로드림">
							</div>
							<div>
								<input type="button" class="btn btn-warning" value="장바구니 담기">
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				
				
				<div id="rank2to4">
					<div id="rank2to4">
					<c:if test="${not empty list2}">
					<c:forEach items="${list2}" var="dto">
					<div class="bookbox2">
						<div class="bestrank2">
							<a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><img src="/bookjuck/image/${dto.image}"></a>
							<div class="bookname">
								<a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><strong style="font-size: 1.3em;">${dto.title}</strong></a>
							</div>
							<div class="bookinfo">${dto.author}| ${dto.publisher} |
								<br>${dto.pubDate}</div>
							<div class="bookcopy">${dto.copy}</div>
							<div class="price">가격:${String.format('%,d', dto.price)}원</div>
							<div class="rank2to4">
								<div>
									<input type="button" class="btn btn-default" value="바로결제">
								</div>
								<div>
									<input type="button" class="btn btn-danger" value="바로드림">
								</div>
								<div>
									<input type="button" class="btn btn-warning" value="장바구니 담기">
								</div>
							</div>
						</div>
					</div>

					</c:forEach>
					</c:if>
				</div>
			</div>
			
			
			
				<div id="rank5to10" style="clear: both;">
					<c:if test="${not empty list3}"> 
					<c:forEach items="${list3}" var="dto">
					<div class="bookbox5">
						<div class="bestrank5">
							<a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><img src="/bookjuck/image/${dto.image}"></a>
							<div class="bookname">
								<a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><strong style="font-size: 1.3em;">${dto.title}</strong></a>
							</div>
							<div class="bookinfo">${dto.author}| ${dto.publisher} |
								${dto.pubDate}</div>
							<div class="bookcopy">${dto.copy}</div>
							<div class="price">가격: ${String.format('%,d', dto.price)}원</div>
							<div>
								<input type="button" class="btn btn-default" value="바로결제">
							</div>
							<div>
								<input type="button" class="btn btn-danger" value="바로드림">
							</div>
							<div>
								<input type="button" class="btn btn-warning" value="장바구니 담기">
							</div>
						</div>
					</div>

					</c:forEach>
					</c:if>			
				</div>
			
			</div>
		</div>
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
	</div>
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp"%>
	<%@include file="/WEB-INF/views/common/top.jsp"%> --%>


	<script>
	$(document).ready(function(){
		<c:if test="${empty list3}"> 
		$("#searchbutton").click(function(){
			
			alert("해당기간의 검색결과가 없습니다.")
			
		})
		</c:if>		
		
		})
   </script>

</body>
</html>