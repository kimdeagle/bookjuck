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
		<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
		<!-- ########## 상단 헤더 끝 -->
	
	
		<!-- 마이페이지 side bar -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		
		
		<section class="contentsection">
            <h3>QnA</h3>

            <table class="table tbl-md" id="listtbl">
                <tr>
                    <th class="col-md-2 cell1">카테고리</th>
                    <th class="col-md-6 cell3">제목</th>
                    <th class="col-md-2 cell4">작성일</th>
                    <th class="col-md-2 cell5">답변여부</th>
                </tr>
                <c:forEach items="${qlist}" var="qdto">
                <tr>
                    <td class="cell1">${qdto.qCategory}</td>
                    <td class="cell3"><a href="/bookjuck/member/qna/detail.do?seq=${qdto.seq}&page=${nowPage}">${qdto.title}</a></td>
                    <td class="cell4">${qdto.regDate.substring(0, 10)}</td>
                    <td class="cell5">
                    	<c:if test="${qdto.isDone.substring(0, 10).equals('1900-01-01')}">
                    		<span>답변대기중</span>
                    	</c:if>
                    	<c:if test="${!qdto.isDone.substring(0, 10).equals('1900-01-01')}">
                    		<span>답변완료</span>
                    	</c:if>
                    </td>
                </tr>
                </c:forEach>
            </table>

            <nav class="pagebar">
                <ul class="pagination">
                    ${pagebar}
                </ul>
            </nav>
            
            <div id="btn">
                <button type="submit" class="btn btn-general inline" id="add" onclick="location.href='/bookjuck/member/qna/add.do'">작성하기</button>
                <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/member/mypage.do'">뒤로가기</button>
            </div>
        </section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	<script>

        $('#category li > a').on('click', function() {
            // 버튼에 선택된 항목 텍스트 넣기 
            $('#category').text($(this).text());
        });

        $('#ordernum li > a').on('click', function() {
            // 버튼에 선택된 항목 텍스트 넣기 
            $('#ordernum').text($(this).text());
        });

    </script>

</body>

</html>