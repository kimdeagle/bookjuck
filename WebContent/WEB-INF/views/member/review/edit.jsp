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
            <h3>독후감<small>수정하기</small></h3>

            
			<form method="POST" action="/bookjuck/member/review/editok.do">
	            <table class="table tbl-md" id="edittbl">
	            	<tr>
	            		<th>도서명</th>
	            		<td>
		                    <select class="form-control selectpicker medium" id="seqbook" name="seqbook">
								<option>${dto.bookTitle}</option>
							</select>
	                    </td>
					</tr>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" id="reviewTitle" name="reviewTitle" class="form-control" value="${dto.reviewTitle}">
                    	</td>
                    </tr>
                    <tr>
                    	<th>내용</th>
                    	<td>
							<textarea id="reviewContent" name="reviewContent" class="form-control" cols="40" rows="15">${dto.reviewContent}</textarea>
            			</td>
            		<tr>
            	</table>
            	<input type="hidden" id="seq" name="seq" value=${dto.seq}>
	            <div id="btn">
	                <input type="submit" class="btn btn-general inline" value="저장하기" id="save">
	                <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/member/review/list.do'">뒤로가기</button>
	            </div>
            </form>
    	</section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
    <script>

       $('#book li > a').on('click', function() {
           // 버튼에 선택된 항목 텍스트 넣기 
           $('#book').text($(this).text());
       });

    </script>

</body>

</html>