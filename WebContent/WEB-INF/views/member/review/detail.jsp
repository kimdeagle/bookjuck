<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/review.css">

<style>

</style>
</head>

<body>



	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


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
	
	
		<!-- 마이페이지 side bar -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		
		
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
		<section class="contentsection">
		<h3>독후감<small style="margin-left:15px;">상세조회</small></h3>
		<table class="table tbl-md" id="detailtbl">
			<tr>
				<th class="col-md-1">도서명</th>
				<td class="col-md-10" colspan="3">${dto.bookTitle}
			</tr>
			<tr>
				<th class="col-md-1">글제목</th>
				<td class="col-md-6">
				${dto.reviewTitle}
				<c:if test="${dto.isPrize eq '1' }">
					<span class="label label-danger">우수</span>
				</c:if>
				</td>
				<th class="col-md-1">작성일</th>
				<td class="col-md-4">${dto.regDate}</td>
			</tr>
			<tr>
				<th class="col-md-1">내용</th>
				<td class="col-md-10" colspan="3">${dto.reviewContent}</td>
			</tr>
		</table>
		
		<div id="btn">
			<input type="button" class="btn btn-general" value="삭제하기" id="delete" data-toggle="modal" data-target="#myModal">
			<input type="button" class="btn btn-general" value="수정하기"  onclick="location.href='/bookjuck/member/review/edit.do?seq=${dto.seq}&page=${page}'">
		    <button type="button" class="btn btn-general inline" id="back" onclick="location.href='/bookjuck/member/review/list.do?page=${page}'">뒤로가기</button>
		</div>
	</section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	<!-- 삭제 확인 모달 -->
	<div class="modal fade" id="myModal" role="dialog">
       <div class="modal-dialog modal-md">
         <div class="modal-content">
           <div class="modal-header">
             <button type="button" class="close" data-dismiss="modal">&times;</button>
             <h4 class="modal-title"></h4>
           </div>
           <div class="modal-body">
            <p>정말 삭제하시겠습니까?</p>
           </div>
           <div id="btn" style="margin-bottom:20px;">
               <button type="button" class="btn btn-general inline" id="del" onclick="location.href='/bookjuck/member/review/del.do?seq=${dto.seq}'">삭제하기</button>
           </div>
       <!-- <div class="modal-footer">
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       </div> -->
       	</div>
       </div>
   </div>

</body>

</html>