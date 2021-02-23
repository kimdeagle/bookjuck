<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::중고게시판</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">

<link rel="stylesheet" href="/bookjuck/css/fleamarket.css">


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
            <article class="fleamarket">

                <h3 style="display: inline-block;">중고도서 거래 게시판</h3>

                <button type="button" class="btn btn-general btn-preview" onclick="location.href='';">
                    미리보기
                </button>
                <form method="POST" action="/bookjuck/member/fleamarket/writeok.do" enctype="multipart/form-data">
                
                <table class="table tbl-md table-view">
                    <tr>
                        <td colspan="2" class="subject">
                            <input type="text" class="form-control" placeholder="제목을 입력해주세요." id="title" name="title" required>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p>
                                <textarea class="form-control content" placeholder="내용을 입력하세요." id="content" name="content" required></textarea>    
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="file" class="form-control" id="file" name="attach">
                        </td>
                    </tr>
                </table>

             

                <div class="btns btn-group">
                    <button type="button" class="btn btn-default" onclick="location.href='/bookjuck/member/fleamarket/list.do';">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                        뒤로
                    </button>
                    <button type="submit" class="btn btn-default" >
                        <span class="glyphicon glyphicon-plus"></span>
                        쓰기
                    </button>
                </div>  <!-- ### 버튼 그룹 끝 -->
                
                </form>
                <div style="clear:both;"></div>



            </article>
        </section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	

</body>

</html>