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
		
		
		
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
        <section class="contentsection">
            <h3>QnA<small style="margin-left:15px;">수정하기</small></h3>
			<form method="POST" action="/bookjuck/member/qna/editok.do">
				<table class="table tbl-md" id="edittbl">
           			<tr>
           				<th class="col-md-2">질문카테고리</th>
           				<td class="col-md-10">
           					<select class="form-control selectpicker medium" id="email" name="seqQcategory">
            					<option value=${dto.seqQCategory}>${dto.qCategory}</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="vertical-align:middle;">
							<span class="glyphicon glyphicon-exclamation-sign"></span><b>주문번호를 기재해주시면 보다 정확한 답변이 가능합니다!</b>
						</td>
           			</tr>
           			<tr>
           				<th class="col-md-2">제목</th>
           				<td class="col-md-10"><input type="text" id="title" name="title" class="form-control inline" value="${dto.title}"></td>
           			</tr>
           			<tr>
           				<th>내용</th>
           				<td colspan="2">
           					<textarea id="content" name="content" class="form-control" cols="40" rows="15" style="width:100%;" placeholder="내용을 입력해주세요">${dto.content}</textarea>
           				</td>
           			</tr>
           		</table>

				<input type="hidden" id="qcategory" name="qcategory" value="${dto.seqQCategory}"> <!-- 질문카테고리 이름 다른 데이터와 같이 editOk서블릿으로 넘긴다! -->
	            <input type="hidden" id="seq" name="seq" value="${dto.seq}">
	            <div id="btn">
	                <input type="submit" class="btn btn-general inline" value="저장하기" id="save">
	                <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/member/qna/list.do'">뒤로가기</button>
	            </div>
            </form>
    	</section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>

</body>

</html>