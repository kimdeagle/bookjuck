<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


<style>

</style>
</head>

<body>


	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<div class="container">
	
	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
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
                <div>※ 비회원은 최대 1개월 내의 주문 내역을 확인하실 수 있습니다. &nbsp&nbsp&nbsp<a href="#" class="btn1" style="font-weight: bold;">회원가입</a></div>
            </article>
        
        
        <!-- 주문 내역 영역-->  
        
            <article>

                <!-- 조회 기간 설정 -->
                <!-- 로그인한 회원만 보임 -->
                <div class="periodbox">
                    <table class="periodtbl table tbl-md">
                        <tr>
                            <th style="padding-top:16px;">기간 조회</th>
                            <td>
                                <span class="sort_option">
                                <a id="period_1week"             href="javascript:;" onclick="" >1주일</a>
                                <a id="period_1month"            href="javascript:;" onclick="" class="on">1개월</a>
                                <a id="period_3month"            href="javascript:;" onclick="" >3개월</a>
                                <a id="period_3month"            href="javascript:;" onclick="" >6개월</a>
                                </a>
                                </span>
                                
                                <input type="date" id="strDate" class="form-control" value="">
                                ~
                                <input type="date" id="endDate" class="form-control" value="">
                                <a href="#" id="periodbtn" class="btn-order" onclick="" >조 회</a>
                            </td>
                        </tr>
                    </table>
                </div>
        
                <div>※ 최근1개월이 기본으로 조회 되며, 기간 변경시 기간 선택 후 조회 버튼을 클릭해 주세요.</div>
                <div>※ 최근 2년부터 조회가 가능합니다.</div>
          

                <!-- 조회 기간 ol:orderList-->
                <div class="olDate">yyyy-mm-dd ~ yyyy-mm-dd 까지의 주문 총 00건</div>

                <!-- 조회 리스트 -->
                <!-- 주문 내역이 없으면 보이는 화면 -->
                <div class="noOrderList">
                    <span>주문 내역이 없습니다.</span>
                    
                    <img src="/bookjuck/image/bookjeok/chat.png">
                </div>

                
                <!-- 주문 내역 있으면 보이는 리스트 -->
                
                <table class="orderList table tbl-md">
                    <tr>
                        <th>주문번호</th>
                        <th>주문금액</th>
                        <th>상품정보</th>
                        <th>수량</th>
                        <th>주문상태</th>
                        <th>취소/교환/환불</th>
                    </tr>
                    <tr class="olInfo">
                        <td>
                            <a href="/bookjuck/member/mypage/orderdetail.do">주문번호</a><br>
                            (주문일)<br><br>
                            <a href="/bookjuck/member/mypage/orderdetail.do" onclick="" class="btn-order">주문상세보기</a>
                        </td>
                        <td>가격</td>
                        <td>
                            <img src="/bookjuck/image/달러구트 꿈 백화점.png" class="book-xs">
                            <a href="/bookjuck/member/book/bookdetail.do">도서명</a>
                        </td>
                        <td>0</td>
                        <td>주문상태</td>
                        <td>
                            <button type="submit" class="btn" onclick="location.href='';">취 소</button>
                            <button type="submit" class="btn" onclick="location.href='';">교 환</button>
                            <button type="submit" class="btn" onclick="location.href='';">환 불</button>
                        </td>
                    </tr>
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
	</script>

</html>