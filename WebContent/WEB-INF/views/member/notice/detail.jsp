<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::Welcome</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/notice.css">
<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">


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
	
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
		<section class="mainsection">
         	<h3>공지사항<small style="margin-left:15px;">상세조회</small></h3>
         
			<table class="table tbl-md" id="detailtbl">
				<tr>
					<th class="col-md-2">제목</th>
					<td class="col-md-4">${dto.title}</td>
					<th class="col-md-2">작성일</th>
					<td class="col-md-4"><p id="senddate">${dto.regdate.substring(0, 10)}</p></td>
				</tr>
	         	<tr>
	             	<td colspan="4"><div>${dto.content}</div></td>
	          	</tr>
			</table>
	        <div id="btn">
	            <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/member/notice/list.do'">뒤로가기</button>
	        </div>
        
    	</section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	

</body>

</html>