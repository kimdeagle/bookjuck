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
<link rel="stylesheet" href="/bookjuck/css/faq.css">

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
	
	
		<!-- 마이페이지 side bar -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		
		
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
		<section class="contentsection">
			<h3>자주 하는 질문</h3>
				<div id="searchinfo" class="inline"><strong>주문</strong>으로 검색한 결과입니다.</div>
				<div id="faqsearch">
				    <input type="text" id="searchterm" class="form-control noline small inline">
				    <input type="button" id="searchbtn" value="질문 검색" class="btn btn-general">
				</div>
				<div style="clear:both;"></div>
			<table id="faqtbl" class="table tbl-md">
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
            
	    </section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
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
	        <!-- <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div> -->
	        </div>
		</div>
	</div>

</body>

</html>