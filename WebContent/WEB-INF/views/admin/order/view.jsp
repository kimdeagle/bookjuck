<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	        <article class="view-form">
	
	        <h3 style="margin-bottom: 20px;">주문내역 상세조회</h3>
	
	        <b class="subtitle">주문자 정보</b>
	        <table class="table tbl-md customerinfo">
	        <c:forEach items="${blist}" var="dto">
	            <tr>
	                <th>주문자</th>
	                <td>${dto.orderName}</td>
	                <th>주문자ID</th>
	                <td>${dto.id}</td>
	            </tr>
	            <tr>
	                <th>연락처</th>
	                <td>${dto.orderName}</td>
	                <th>e-mail</th>
	                <td>이메일</td>
	            </tr>
	            <tr>
	                <td colspan="4"></td>
	            </tr>
	        </c:forEach>
	        </table>
	
	        <!-- ##### 자사배송 주문정보 ##### -->
	        <!-- 바로드림과 이북은 배송현황 td에 - 표기하기 -->
	        <b class="subtitle">주문 정보</b>
	        <table class="table tbl-md orderinfo">
	            <tr>
	            	<c:forEach items="${blist}" var="dto">
	                <th>주문번호</th>
	                <td>
	                    123456${seqBookOrder}
	                </td>
	                <th>주문날짜</th>
	                <td>${dto.orderDate}</td>
	                <th>주문상태</th>
	                <td>
	                    ${dto.orderState}
	                    <button class="btn btn-general btn-sm"  data-toggle="modal" data-target="#orderstate">
	                        상태수정
	                    </button>
	                </td>
	                </c:forEach>
	                <th>배송정보</th>
	                <td>
	                    <c:forEach items="${bdlist}" var="bddto">
	                    ${bddto.deliveryCompany}
	                    <div>(${bddto.deliveryNumber})</div>
	                    </c:forEach>
	                </td>
	            </tr>
	            <tr>
	                <td colspan="8"></td>
	            </tr>
	        </table>
	
	
	        <!-- 주문 상품 정보 -->
	        <table class="table tbl-md detailinfo">
	            <tr>
	                <th>도서명</th>
	                <th>작가</th>
	                <th>출판사</th>
	                <th>수량</th>
	                <th>판매가</th>
	            </tr>
	            <c:forEach items="${blist}" var="bdto">
	            <tr>
	                <td>
	                    <img src="/bookjuck/image/book/${bdto.image}">
	                    <span>${bdto.title}</span>
	                </td>
	                <td>작가명</td>
	                <td>출판사명</td>
	                <td>
	                    ${bdto.amount}
	                </td>
	                <td>
	                    8,550
	                </td>
	            </tr>
	            </c:forEach>
	            <tr>
	                <td colspan="5"></td>
	            </tr>
	        </table>
	
	
	        <b class="subtitle">배송 정보</b>
	        <table class="table tbl-md deliveryinfo">
	            <c:forEach items="${bdlist}" var="bddto">
	            <tr>
	                <th>받으시는 분</th>
	                <td>${bddto.name}</td>
	                <th>연락처</th>
	                <td>${bddto.tel}</td>
	                <th>운송장번호</th>
	                <td>
	                    <a href>${bddto.deliveryCompany}(${bddto.deliveryNumber})</a>
	                </td>
	            </tr>
	            <tr>
	                <th>주소</th>
	                <td colspan="5">${bddto.address}</td>
	            </tr>
	            <tr>
	                <td colspan="5"></td>
	            </tr>
	            </c:forEach>
	        </table>
	
	
	        <!-- 결제 + 환불 정보 -->
	        <div class="pay">
	            <b class="subtitle">결제 정보</b>
	            <table class="table tbl-xs">
	            <c:forEach items="${bplist}" var="bpdto">
	                <tr>
	                    <th>상품합계</th>
	                    <td>${bpdto.totalPay}</td>
	                </tr>
	                <tr>
	                    <th>사용포인트</th>
	                    <td>${bpdto.usePoint}</td>
	                </tr>
	                <tr>
	                    <th>최종결제금액</th>
	                    <td>${bpdto.actualPay}</td>
	                </tr>
	                <tr>
	                    <th>적립포인트</th>
	                    <td>${bpdto.savePoints}</td>
	                </tr>
	                <tr>
	                    <th>결제수단</th>
	                    <td>${bpdto.payment}</td>
	                </tr>
	                <tr>
	                    <td colspan="2"></td>
	                </tr>
	            </c:forEach>
	            </table>
	        </div>
	
	        <!-- 취소/교환/환불일때만 보여주기 -->
	        <c:if test="${ordertype != 'other'}"> <!-- other:일반주문 -->
	        
	        <div class="pay-refund">
	            <b class="subtitle">환불 정보</b>
	            <table class="table tbl-xs">
	                <tr>
	                    <th>환불금액</th>
	                    <td>8,550원</td>
	                </tr>
	                <tr>
	                    <th>환불포인트</th>
	                    <td>850P</td>
	                </tr>	                
	                <tr>
	                    <th>환불수단</th>
	                    <td>카드+적립금</td>
	                </tr>
	                <tr>
	                    <td colspan="2"></td>
	                </tr>
	            </table>
	        </div>
	        <!-- ^ 취소/교환/환불일때만 보여주기 -->
	        <div style="clear: both;"></div>
	
	
			<!-- 무통장 입금으로 결제한 고객 환불해줄 환불 계좌 정보 -->
			<b class="subtitle">환불 계좌 정보 <small>(무통장 입금 고객)</small></b>
            <table class="receiver table tbl-md">
                <tr>
                    <th>예금주</th>
                    <td>예금주 이름</td>
                    <th>은행명</th>
                    <td>은행이름</td>                        
                </tr>
                <tr>
                    <th>계좌번호</th>
                    <td colspan="3">계조ㅏ번호적으세요</td>
                </tr>
                <tr>
                	<td colspan="4"></td>
                </tr>
            </table>
                
	
	
	        <!-- 취소/교환/환불 정보 -->
	        <b class="subtitle">취소/교환/환불 정보</b>
	        <button class="btn btn-general process btn-sm"  data-toggle="modal" data-target="#processstate">
	            처리상태 수정
	        </button>
	        <table class="table tbl-md refundinfo">
	            <tr>
	                <th>사유</th>
	                <td>단순변심</td>
	                <th>신청일</th>
	                <td>2021-02-20</td>
	            </tr>
	            <tr>
	                <th>상세사유</th>
	                <td colspan="3"> - </td>
	            </tr>
	            <tr>
	                <th>처리상태</th>
	                <td>환불완료</td>
	                <th>처리날짜</th>
	                <td>2021-02-20</td>
	            </tr>
	            <tr>
	                <td colspan="4"></td>
	            </tr>
	        </table>
	
	
	        <!-- 회수지 정보 (교환/환불일때만 보여주기) -->
	        <b class="subtitle">회수지 정보</b>
	        <table class="table tbl-md">
	            <tr>
	                <th>주소</th>
	                <td>서울특별시 강남구 역삼동 한독빌딩</td>
	            </tr>
	            <tr>
	                <td colspan="2"></td>
	            </tr>
	        </table>
	
	        <!-- 교환 배송지 정보 (교환일때만 보여주기) -->
	        <b class="subtitle">교환상품 배송 정보</b>
	        <table class="table tbl-md deliveryinfo">
	            <tr>
	                <th>받으시는 분</th>
	                <td>테스트</td>
	                <th>연락처</th>
	                <td>010-1111-1111</td>
	                <th>운송장번호</th>
	                <td>
	                    <a href>한진택배 01010239</a>
	                </td>
	            </tr>
	            <tr>
	                <th>주소</th>
	                <td colspan="5">서울특별시 강남구 역삼동 한독빌딩</td>
	            </tr>
	            <tr>
	                <td colspan="5"></td>
	            </tr>
	        </table>
	
			</c:if>
			
	        <!-- 주문 상세보기 하단 (라인 + 버튼) -->
	        <hr>
	        <div class="btns"> 
	        	<!-- 목록으로 버튼 링크 연결 시 주의할 것 -->
	            <input type="button" value="목록으로" class="btn back" onclick="location.href='/bookjuck/admin/order/orderlist.do';">
	            <button class="btn btn-general"  data-toggle="modal" data-target="#ordercancel">
	                주문취소
	            </button>
	        </div>
	
	       </article>
	    </section>
		


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- ########## 하단 끝 -->

	</div>


	<!-- ######### Modal 자사배송 도서 주문상태 모달 -->
    <div class="modal fade" id="orderstate" role="dialog" aria-labelledby="orderstateHeader" aria-hidden="true" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">주문 상태 수정</h5>
                </div>
                <div class="modal-body">
                    <div>
                        <table class="table">
                            <tr>
                                <th>주문번호</th>
                                <td>00000000</td>
                            </tr>
                            <tr>
                                <th>주문상태</th>
                                <td>
                                    <select class="form-control">
                                        <option value="주문완료">주문완료</option>
                                        <option value="결제완료">결제완료</option>
                                        <option value="배송중">배송중</option>
                                        <option value="배송완료">배송완료</option>
                                        <option value="주문취소">주문취소</option>
                                        <option value="주문교환">주문교환</option>
                                        <option value="주문환불">주문환불</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-general" data-dismiss="modal">수정</button>
                </div>
            </div>
        </div>
    </div>


	<!-- ######### Modal 바로드림 주문상태 모달 -->
	<!-- 
    <div class="modal fade" id="orderstate" role="dialog" aria-labelledby="orderstateHeader" aria-hidden="true" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">주문 상태 수정</h5>
                </div>
                <div class="modal-body">
                    <div>
                        <table class="table">
                            <tr>
                                <th>주문번호</th>
                                <td>00000000</td>
                            </tr>
                            <tr>
                                <th>주문상태</th>
                                <td>
                                    <select class="form-control">
                                        <option value="주문완료">주문완료</option>
                                        <option value="결제완료">결제완료</option>
                                        <option value="픽업대기">픽업대기</option>
                                        <option value="픽업완료">픽업완료</option>
                                        <option value="주문취소">주문취소</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-general" data-dismiss="modal">수정</button>
                </div>
            </div>
        </div>
    </div>
	 -->


	<!-- ######### Modal eBook 주문상태 모달 -->
	<!-- 
    <div class="modal fade" id="orderstate" role="dialog" aria-labelledby="orderstateHeader" aria-hidden="true" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">주문 상태 수정</h5>
                </div>
                <div class="modal-body">
                    <div>
                        <table class="table">
                            <tr>
                                <th>주문번호</th>
                                <td>00000000</td>
                            </tr>
                            <tr>
                                <th>주문상태</th>
                                <td>
                                    <select class="form-control">
                                        <option value="주문완료">주문완료</option>
                                        <option value="결제완료">결제완료</option>
                                        <option value="다운로드대기">다운로드대기</option>
                                        <option value="다운로드완료">다운로드완료</option>
                                        <option value="주문환불">주문환불</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-general" data-dismiss="modal">수정</button>
                </div>
            </div>
        </div>
    </div>
	 -->
	 
	
	<!-- 처리상태 수정 모달 창 --> 
    <!-- 주문 취소일 경우 -->
    <div class="modal fade" id="processstate" role="dialog" aria-labelledby="processstateHeader" aria-hidden="true" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">처리상태 수정</h5>
                </div>
                <div class="modal-body">
                    <div>
                        <table class="table">
                            <tr>
                                <th>주문번호</th>
                                <td>00000000</td>
                            </tr>
                            <tr>
                                <th>처리상태</th>
                                <td>
                                    <select class="form-control">
                                        <option value="취소신청">취소신청</option>
                                        <option value="취소완료">취소완료</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-general" data-dismiss="modal">수정</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 주문 교환일 경우 -->
    <!-- 
    <div class="modal fade" id="processstate" role="dialog" aria-labelledby="processstateHeader" aria-hidden="true" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">처리상태 수정</h5>
                </div>
                <div class="modal-body">
                    <div>
                        <table class="table">
                            <tr>
                                <th>주문번호</th>
                                <td>00000000</td>
                            </tr>
                            <tr>
                                <th>처리상태</th>
                                <td>
                                    <select class="form-control">
                                        <option value="교환신청">환불신청</option>
                                        <option value="처리중">처리중</option>
                                        <option value="교환완료">교환완료</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-general" data-dismiss="modal">수정</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 주문 환불일 경우 -->
    <!-- 
    <div class="modal fade" id="processstate" role="dialog" aria-labelledby="processstateHeader" aria-hidden="true" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">처리상태 수정</h5>
                </div>
                <div class="modal-body">
                    <div>
                        <table class="table">
                            <tr>
                                <th>주문번호</th>
                                <td>00000000</td>
                            </tr>
                            <tr>
                                <th>처리상태</th>
                                <td>
                                    <select class="form-control">
                                        <option value="환불신청">환불신청</option>
                                        <option value="처리중">처리중</option>
                                        <option value="환불완료">환불완료</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-general" data-dismiss="modal">수정</button>
                </div>
            </div>
        </div>
    </div>	
	-->


	<!-- 주문 취소 모달창 (하단 오른쪽 관리자 주문취소 버튼 누를 때) -->
    <div class="modal fade" id="ordercancel" role="dialog" aria-labelledby="ordercancelHeader" aria-hidden="true" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">주문 취소</h5>
                </div>
                <div class="modal-body">
                    <div>
                        <table class="table">
                            <tr>
                                <th>주문번호</th>
                                <td>00000000</td>
                            </tr>
                            <tr>
                                <th colspan="2" style="text-align: center; font-size: 1.7em;">해당 주문을 취소하시겠습니까?</th>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-general" data-dismiss="modal">주문취소</button>
                </div>
            </div>
        </div>
    </div>




	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp"%>
		
		
</body>

</html>