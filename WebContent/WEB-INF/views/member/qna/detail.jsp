<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/qna.css">


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
		
		<section class="contentsection">
			<h3>QnA<small style="margin-left:15px;">상세조회</small></h3>
			
			<table class="table tbl-md" id="qnatbl">
					<tr>
						<th class="col-md-2">질문제목</th>
						<td class="col-md-4">${qdto.title}</td>
						<th class="col-md-2">질문등록일</th>
						<td class="col-md-4">${qdto.regDate.substring(0, 10)}</td>
					</tr>
					<tr>
						<th class="col-md-2">아이디</th>
						<td class="col-md-4">${qdto.id}</td>
						<th class="col-md-2">답변등록일</th>
						<td class="col-md-4">
							<c:if test="${empty adto.answerDate}">
							<span>답변대기중</span>
							</c:if>
							<c:if test="${not empty adto.answerDate}">
							<span>${adto.answerDate.substring(0, 10)}</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<th class="col-md-2">질문내용</th>
						<td colspan="3">${qdto.content}</td>
					</tr>
					<tr>
						<th class="col-md-2">답변내용</th>
						<c:if test="${empty adto.answerDate}">
						<td><span>현재 답변 대기중입니다.</span></td>
						</c:if>
						
						<c:if test="${not empty adto.answerDate}">
						<td colspan="3">${adto.answerContent}</td>
						</c:if>
					</tr>
				</table>
			
			<div id="btn">
                <button type="button" class="btn btn-general inline" id="edit" onclick="location.href='/bookjuck/member/qna/edit.do?seq=${qdto.seq}'">수정하기</button>
                <button type="button" class="btn btn-general inline" id="del" data-toggle="modal" data-target="#myModal">삭제하기</button>
                <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/member/qna/list.do?page=${page}'">뒤로가기</button>
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
            <div id="btn">
                	<button type="button" class="btn btn-general inline" id="modaldel">삭제하기</button>
            </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
        </div>
    </div>
    
    <script>
    
    function format() {
    	var args = Array.prototype.slice.call (arguments, 1);
    	return arguments[0].replace (/\{(\d+)\}/g,
    			function (match, index) { return args[index]; }); }
    
    // 답변이 달려있는 질문글일 때와 달려있지 않은 질문글일 때의 쿼리스트링은 달라야 한다.
 
    $("#modaldel").click(function(){
    	<c:if test="${empty adto.answerDate}">
    	location.href=format("/bookjuck/member/qna/del.do?seq={0}&isdone=n", ${qdto.seq});
    	</c:if>
    	
    	<c:if test="${not empty adto.answerDate}">
    	location.href=format("/bookjuck/member/qna/del.do?seq={0}&isdone=y", ${qdto.seq});
    	</c:if>
    });
    
    </script>
	
</body>

</html>