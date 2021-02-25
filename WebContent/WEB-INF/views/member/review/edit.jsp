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

            
			<form method="POST" action="">
	            <table class="table tbl-md" id="reviewtbl">
	            	<tr>
	            		<td>
		                    <div class="dropdown">
		                        <button class="btn btn-default dropdown-toggle selected" type="button" data-toggle="dropdown" aria-expanded="true" id="book">
		                          도서명
		                          <span class="caret"></span>
		                        </button>
		                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" id="book">
		                          <li role="presentation"><a role="menuitem" tabindex="-1">책읽고 글쓰기</a></li>
		                          <li role="presentation"><a role="menuitem" tabindex="-1">일인칭 단수</a></li>
		                          <li role="presentation"><a role="menuitem" tabindex="-1">어떻게 살 것인가</a></li>
		                          <li role="presentation"><a role="menuitem" tabindex="-1">정의란 무엇인가</a></li>
		                        </ul>
		                    </div>
	                    </td>
					</tr>
					<tr>
						<td>
							<input type="text" id="title" name="title" class="form-control" placeholder="제목을 입력해주세요">
                    	</td>
                    </tr>
                    <tr>
                    	<td>
							<textarea id="content" name="content" class="form-control" cols="40" rows="15" placeholder="내용을 입력해주세요"></textarea>
            			</td>
            		<tr>
            	</table>
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