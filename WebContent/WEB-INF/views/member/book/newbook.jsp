<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
   
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>
<link rel="stylesheet" href="/bookjuck/css/bestseller.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">

<style>
</style>

</head>
<body>

	<div class="container">
		<%@include file="/WEB-INF/views/common/searchview.jsp"%>
		<div class="bestSellerList">
			<div id="menuname1">신간도서</div>
			<nav id="leftmenu">
				<div>
					<a href="" ; class="list1"><strong>종합</strong></a></strong>
				</div>
				<div>
					<a href="" ; class="list1">소설종합</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?aaa=111" class="list1">국내소설</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?aaa=222" class="list1">외국소설</a>
				</div>
				<div>
					<a href="/bookjuck/member/book/bestseller.do?aaa=333" class="list1">비소설</a>
				</div>
				<div>
					<a href="" ; class="list1">시</a>
				</div>
				<div>
					<a href="" ; class="list1">경제경영</a>
				</div>
				<div>
					<a href="" ; class="list1">인문과학</a>
				</div>
				<div>
					<a href="" ; class="list1">어린이</a>
				</div>
				<div>
					<a href="" ; class="list1">외국어</a>
				</div>
				<div>
					<a href="" ; class="list1">컴퓨터</a>
				</div>
				<div>
					<a href="" ; class="list1">여성,취미</a>
				</div>
				<div>
					<a href="" ; class="list1">예술</a>
				</div>
				<div>
					<a href="" ; class="list1">자연</a>
				</div>
				<div>
					<a href="" ; class="list1">정치법률</a>
				</div>
				<div>
					<a href="" ; class="list1">자기계발</a>
				</div>
				<div>
					<a href="" ; class="list1">역사문화</a>
				</div>
				<div>
					<a href="" ; class="list1">유아</a>
				</div>
				<div>
					<a href="" ; class="list1">가정생활</a>
				</div>
				<div>
					<a href="" ; class="list1">건강</a>
				</div>
				<div>
					<a href="" ; class="list1">취미레져</a>
				</div>
				<div>
					<a href="" ; class="list1">여행</a>
				</div>
				<div>
					<a href="" ; class="list1">청소년</a>
				</div>
				<div>
					<a href="" ; class="list1">학습서</a>
				</div>
				<div>
					<a href="" ; class="list1">수험서</a>
				</div>
				<div>
					<a href="" ; class="list1">만화</a>
				</div>
			</nav>
			
		
			<div class="bestSellerListRight">
			<span class="intro" style="font-weight: bold;">북적북적의 신간도서를
					소개합니다.</span>
				<br>
				<form id="searchform" method="GET" action="/bookjuck/member/book/newbook.do">
					<div id="choicedate">
						<!-- 기간 선택 -->
						<input type="text" name="yearStart" id="yearStart" style="width: 50px;" placeholder="YYYY" class="datebtn" value="${yearStart}">
						<input type="text" name="monthStart" id="monthStart" style="width: 50px;" placeholder="MM" class="datebtn" value="${monthStart}">
						<input type="text" name="dayStart" id="dayStart" style="width: 50px;" placeholder="DD" class="datebtn" value="${dayStart}"> 
						~ 
						<input type="text" name="yearEnd" id="yearEnd" style="width: 50px;" placeholder="YYYY" class="datebtn" value="${yearEnd}">
						<input type="text" name="monthEnd" id="monthEnd" style="width: 50px;" placeholder="MM" class="datebtn" value="${monthEnd}"> 
						<input type="text" name="dayEnd" id="dayEnd" style="width: 50px;" placeholder="DD" class="datebtn" value="${dayEnd}">
						<input type="submit" value="기간검색" class="dateselect">
					</div>
				</form>
				<br>
				<c:if test="${not empty yearStart}">
				<div>
    			'${yearStart}-${monthStart}-${dayStart} ~ ${yearEnd}-${monthEnd}-${dayEnd}' 기간의 신간도서 조회결과 입니다.
    			</div>
    			</c:if>
				<br>
				<c:forEach items="${list}" var="dto" begin="0" end="0" step="1">
				<div class="bookbox">
					<div class="bestrank1">
						<img src="../image/${dto.image}">
						<div class="bookname">
							<strong>${dto.title}</strong>
						</div>
						<div class="bookinfo">${dto.author}| ${dto.publisher} |
							${dto.pubdate}</div>
						<div class="bookcopy">${dto.copy}</div>
						<div class="price">가격: ${dto.price}원</div>
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
				<div id="rank2to4">
					<div class="bookbox2">
						<div class="bestrank2">
							<img src="../image/${dto.image}">
							<div class="bookname">
								<strong>${dto.title}</strong>
							</div>
							<div class="bookinfo">${dto.author}| ${dto.publisher} |
								${dto.pubdate}</div>
							<div class="bookcopy">${dto.copy}</div>
							<div class="price">가격: ${dto.price}원</div>
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
					<div class="bookbox3">
						<div class="bestrank3">
							<img src="../image/${dto.image}">
							<div class="bookname">
								<strong>${dto.title}</strong>
							</div>
							<div class="bookinfo">${dto.author}| ${dto.publisher} |
								${dto.pubdate}</div>
							<div class="bookcopy">${dto.copy}</div>
							<div class="price">가격: ${dto.price}원</div>
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
					<div class="bookbox4">
						<div class="bestrank4">
							<img src="../image/${dto.image}">
							<div class="bookname">
								<strong>${dto.title}</strong>
							</div>
							<div class="bookinfo">${dto.author}| ${dto.publisher} |
								${dto.pubdate}</div>
							<div class="bookcopy">${dto.copy}</div>
							<div class="price">가격: ${dto.price}원</div>
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
				</div>
				<div id="rank5to10" style="clear: both;">
					<div class="bookbox5">
						<div class="bestrank5">
							<img src="../image/${dto.image}">
							<div class="bookname">
								<strong>${dto.title}</strong>
							</div>
							<div class="bookinfo">${dto.author}| ${dto.publisher} |
								${dto.pubdate}</div>
							<div class="bookcopy">${dto.copy}</div>
							<div class="price">가격: ${dto.price}원</div>
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
					<div class="bookbox6">
						<div class="bestrank5">
							<img src="../image/${dto.image}">
							<div class="bookname">
								<strong>${dto.title}</strong>
							</div>
							<div class="bookinfo">${dto.author}| ${dto.publisher} |
								${dto.pubdate}</div>
							<div class="bookcopy">${dto.copy}</div>
							<div class="price">가격: ${dto.price}원</div>
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
					<div class="bookbox7">
						<div class="bestrank5">
							<img src="../image/${dto.image}">
							<div class="bookname">
								<strong>${dto.title}</strong>
							</div>
							<div class="bookinfo">${dto.author}| ${dto.publisher} |
								${dto.pubdate}</div>
							<div class="bookcopy">${dto.copy}</div>
							<div class="price">가격: ${dto.price}원</div>
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
					<div class="bookbox8">
						<div class="bestrank5">
							<img src="../image/${dto.image}">
							<div class="bookname">
								<strong>${dto.title}</strong>
							</div>
							<div class="bookinfo">${dto.author}| ${dto.publisher} |
								${dto.pubdate}</div>
							<div class="bookcopy">${dto.copy}</div>
							<div class="price">가격: ${dto.price}원</div>
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
					<div class="bookbox9">
						<div class="bestrank5">
							<img src="../image/${dto.image}">
							<div class="bookname">
								<strong>${dto.title}</strong>
							</div>
							<div class="bookinfo">${dto.author}| ${dto.publisher} |
								${dto.pubdate}</div>
							<div class="bookcopy">${dto.copy}</div>
							<div class="price">가격: ${dto.price}원</div>
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
					<div class="bookbox10">
						<div class="bestrank5">
							<img src="../image/${dto.image}">
							<div class="bookname">
								<strong>${dto.title}</strong>
							</div>
							<div class="bookinfo">${dto.author}|${dto.publisher} |
								${dto.pubdate}</div>
							<div class="bookcopy">${dto.copy}</div>
							<div class="price">가격: ${dto.price}원</div>
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
				</div>
			</div>
		</div>
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
	</div>
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp"%>
	<%@include file="/WEB-INF/views/common/top.jsp"%>


	<script>
      
   </script>

</body>
</html>