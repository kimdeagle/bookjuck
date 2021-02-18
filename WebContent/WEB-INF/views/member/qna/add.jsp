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
<link rel="stylesheet" href="/bookjuck/css/qna.css">


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
            <h3>QnA</h3>

            <div id="subtitle">작성하기</div>
			<form method="POST" action="">
	            <div id="letterbox">
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle selected" type="button" data-toggle="dropdown" aria-expanded="true" id="category">
                          질문카테고리
                          <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" id="category">
                          <li role="presentation"><a role="menuitem" tabindex="-1">반품</a></li>
                          <li role="presentation"><a role="menuitem" tabindex="-1">환불</a></li>
                          <li role="presentation"><a role="menuitem" tabindex="-1">교환</a></li>
                          <li role="presentation"><a role="menuitem" tabindex="-1">배송</a></li>
                        </ul>
                    </div>
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle selected" type="button" data-toggle="dropdown" aria-expanded="true" id="ordernum">
                          주문번호
                          <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" id="ordernum">
                          <li role="presentation"><a role="menuitem" tabindex="-1">1232342</a></li>
                          <li role="presentation"><a role="menuitem" tabindex="-1">1232342</a></li>
                          <li role="presentation"><a role="menuitem" tabindex="-1">1232342</a></li>
                          <li role="presentation"><a role="menuitem" tabindex="-1">1232342</a></li>
                        </ul>
                    </div>
                    <input type="text" id="title" name="title" class="form-control inline" placeholder="제목을 입력해주세요">
                    <textarea id="content" name="content" class="form-control" cols="40" rows="15" placeholder="내용을 입력해주세요"></textarea>
            	</div>
	            <div id="btn">
	                <input type="submit" class="btn btn-general inline" value="저장하기" id="save">
	                <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/member/mypage/servicecenter.do'">뒤로가기</button>
	            </div>
            </form>
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