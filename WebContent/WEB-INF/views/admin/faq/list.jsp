<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>


<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/faq.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<section class="contentsection">
    	<h3>자주 하는 질문</h3>
            <table class="table tbl-md qnatbl">
                <tr>
                    <th>카테고리</th>
                    <th>결제</th>
                </tr>
                <tr>
                    <td>주문결제</td>
                    <td class="cell2"><a data-toggle="modal" href="#myModal">온라인 송금으로 주문했을 때 주문자와 입금자가 같아야 하나요?</a></td>
                </tr>
                <tr>
                    <td>수령일안내</td>
                    <td class="cell2"><a data-toggle="modal" href="#myModal">주문한 상품이 아직 안 왔어요.</a></td>
                </tr>
                <tr>
                    <td>반품</td>
                    <td class="cell2"><a data-toggle="modal" href="#myModal">반품시 마일리지 환원되나요?</a></td>
                </tr>
                <tr>
                    <td>교환</td>
                    <td class="cell2"><a data-toggle="modal" href="#myModal">배송받은 제품을 교환하고 싶어요</a></td>
                </tr>
                <tr>
                    <td>환불</td>
                    <td class="cell2"><a data-toggle="modal" href="#myModal">결함품 환불가능한가요?</a></td>
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

            <div id="btn">
                <button type="button" class="btn btn-general" id="qcategory">질문카테고리 관리하기</button>
                <button type="button" class="btn btn-general inline" id="add" onclick="location.href='/bookjuck/admin/faq/add.do'">작성하기</button>
            </div>
        </section>
	
	</div>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>

	    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog modal-md">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">자주 하는 질문</h4>
            </div>
            <div class="modal-body">
	            <p>Q. 온라인 송금으로 주문했을 때 주문자와 입금자가 같아야 하나요?</p>
	            <p>A. 네 같아야 합니다.</p>
            </div>
            <div id="btn">
                <button type="button" class="btn btn-general" id="edit">수정하기</button>
                <button type="button" class="btn btn-general inline" id="back">삭제하기</button>
            </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
        </div>
    </div>

</body>

</html>