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
<link rel="stylesheet" href="/bookjuck/css/servicecenter.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">


<style>

</style>
</head>

<body>

	<!-- header ~ footer > 플로팅 메뉴(북적이, top)를 제외한 나머지 전부를 담는 컨테이너) -->
	<!-- ########## 컨테이너 시작 -->
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
	
	<!-- 마이페이지 -->
	<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
	
	<!-- 로그인한 본인이 작성한 QnA -->
	<section class="contentsection">
    	<h3>QnA</h3>

	    <table class="table tbl-md">
	        <tr>
	            <th>작성일</th>
	            <th>제목</th>
	            <th>답변여부</th>
	        </tr>
	        <tr>
	            <td>2021-02-10</td>
	            <td><a href="/bookjuck/member/qna/detail.do">환불신청 어떻게 하나요?</a></td>
	            <td>답변완료</td>
	        </tr>
	        <tr>
	            <td>2021-02-07</td>
	            <td><a href="/bookjuck/member/qna/detail.do">배송 관련해서 문의사항이 있습니다.</a></td>
	            <td>답변완료</td>
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
	    	<button type="button" class="btn btn-general inline" onclick="location.href='/bookjuck/member/qna/add.do'">작성하기</button>
	    </div>
        
	</section>

	<!-- 자주 하는 질문 -->
	<section class="contentsection">
	    <h3>자주 하는 질문</h3>
	
	    <div id="faqsearch">
	        <input type="text" id="faqsearch" class="form-control noline small inline">
	        <input type="button" id="searchbtn" value="질문 검색" class="btn btn-general noline">
	    </div>
	    
	    <table class="table tbl-md">
	        <tr>
	            <th>카테고리</th>
	            <th>결제</th>
	        </tr>
	        <tr>
	            <td>주문결제</td>
	            <td><a data-toggle="modal" href="#myModal">온라인 송금으로 주문했을 때 주문자와 입금자가 같아야 하나요?</a></td>
	        </tr>
	        <tr>
	            <td>수령일안내</td>
	            <td><a data-toggle="modal" href="#myModal">주문한 상품이 아직 안 왔어요.</a></td>
	        </tr>
	        <tr>
	            <td>반품</td>
	            <td><a data-toggle="modal" href="#myModal">반품시 마일리지 환원되나요?</a></td>
	        </tr>
	        <tr>
	            <td>교환</td>
	            <td><a data-toggle="modal" href="#myModal">배송받은 제품을 교환하고 싶어요</a></td>
	        </tr>
	        <tr>
	            <td>환불</td>
	            <td><a data-toggle="modal" href="#myModal">결함품 환불가능한가요?</a></td>
	        </tr>
	    </table>
	    
	</section>

	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->


	<!-- ########## 컨테이너 끝 -->
	</div>


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
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
        </div>
    </div>

</body>

</html>