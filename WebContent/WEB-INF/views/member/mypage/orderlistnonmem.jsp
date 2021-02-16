<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/orderlist.css">


<style>

</style>
</head>

<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
	<!-- ########## 상단 헤더 끝 -->

	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<div class="container">
	
		<!-- 마이페이지 -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		 <!-- 주문자 정보 영역 -->
        <section class="contentsection">
            <article>
                <h3>주문/결제 조회</h3>
                
                <table class="orderer table tbl-md">
                    <tr>
                        <th>주문자</th>
                        <td>이름 | 연락처 | 이메일</td>
                    </tr>
                </table>

                <div>※ 비회원은 최대 1개월 내의 주문 내역을 확인하실 수 있습니다. &nbsp&nbsp&nbsp<a href="#" class="btn1" style="font-weight: bold;">회원가입</a></div>
                
            </article>
        </section>
        

        <!-- 주문 내역 영역-->
        <section class="contentsection">
            <article>
                <!-- 조회 기간 ol:orderList-->
                <div class="olDate">
                    <input type="text" value="yyyy-mm-dd" id="startDate" class="date read"> ~ <input type="text" value="yyyy-mm-dd" id="endDate" class="date read">까지의 주문 총 <input type="text" value="00" id="olCnt"class="orderCnt read">건
                </div>

                <!-- 조회 리스트 -->
                <div class="noOrderList">
                    <span>주문 내역이 없습니다.</span>
                    <img src="image/bookjeok/chat.png">
                </div>
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
                            <a href="#">주문번호</a><br>
                            (주문일)<br><br>
                            <a href="#" onclick="" class="btn-order">주문상세보기</a>
                        </td>
                        <td>가격</td>
                        <td>
                            <img src="/bookjuck/image/나목.png" class="book-xs">
                            <a href="#">도서명</a>
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

	</div>
	
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	

</body>

</html>