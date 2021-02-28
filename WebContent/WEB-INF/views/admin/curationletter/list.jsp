<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>


<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/curationletter.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<section class="contentsection">
            <h3>큐레이션레터<small style="margin-left:15px;">전송내역</small></h3>

            <table class="table tbl-md" id="logtbl">
                <tr>
                    <th class="col-md-1">레터번호</th>
                    <th class="col-md-6">제목</th>
                    <th class="col-md-2">아이디</th>
                    <th class="col-md-3">전송일</th>
                </tr>
                <c:forEach items="${llist}" var="ldto">
                <tr>
                    <td>${ldto.seq}</td>
                    <td><a href="/bookjuck/admin/curationletter/detail.do?seq=${ldto.seqLetter}&page=${nowPage}">${ldto.title}</a></td>
                    <td>${ldto.id}</td>
                    <td>${ldto.sendDate}</td>
                </tr>
                </c:forEach>
                <tr>
                	<td colspan="4"><span class="glyphicon glyphicon-exclamation-sign"></span><b>방금 전송한 큐레이션 레터 내역이 보이는지 꼭 확인해주세요!<br>보이지 않는다면 관리자에게 문의해주세요.</b></td></td>
                </tr>
            </table>

            <nav class="pagebar">
                <ul class="pagination">
                    ${pagebar}
                </ul>
            </nav>

            <div id="btn">
                <button type="button" class="btn btn-general" id="edit" onclick="location.href='/bookjuck/admin/curationletter/add.do'">작성하기</button>
                <button type="button" class="btn btn-general inline" id="back"  onclick="location.href='/bookjuck/admin/index.do'">뒤로가기</button>
            </div>
        </section>
	
	</div>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>



</body>

</html>