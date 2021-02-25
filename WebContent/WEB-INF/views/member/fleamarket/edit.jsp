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
            <article class="fleamarket">
                
                <h3 style="display: inline-block;">중고도서 거래 게시판</h3>

                <button type="button" class="btn btn-general btn-preview" onclick="location.href='';">
                    미리보기
                </button>
                
                <form method="POST" action="/bookjuck/member/fleamarket/editok.do">
                
                <table class="table tbl-md table-view">
                    <tr>
                        <td class="subject">
                            <input type="text" class="form-control" placeholder="제목을 입력해주세요." style="width: 700px;" id="title" name="title" required value='${dto.title.replace("\"", "&quot;")}'>
                        </td>
                        <td>
                            <select name="dealState" id="dealState" class="form-control">
                                <option value="판매중">판매중</option>
                                <option value="예약중">예약중</option>
                                <option value="판매완료">판매완료</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p>
                                <textarea class="form-control content" placeholder="내용을 입력하세요." id="content" name="content">${dto.content}</textarea>
                            </p>
                        </td>
                    </tr>
                    <!-- 
                    <tr>
                        <td colspan="2">
                            <input type="file" class="form-control">
                        </td>
                    </tr>
                     -->
                </table>

                


                <div class="btns btn-group">
                    <button type="button" class="btn btn-default" onclick="location.href='/bookjuck/member/fleamarket/list.do';">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                        뒤로
                    </button>
                    <button type="submit" class="btn btn-default" >
                        <span class="glyphicon glyphicon-minus"></span>
                        수정
                    </button>
                </div>
                
                <input type="hidden" name="seq" value="${dto.seq}">
                
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