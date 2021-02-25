<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>


<style>

</style>
</head>

<body>



	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<div class="container">
	

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

                <h3>중고도서 거래 게시판</h3>

                <div class="btns btn-group">
                    <button type="button" class="btn btn-default " onclick="location.href='/bookjuck/member/fleamarket/list.do?fleamarketsearch=${fleamarketsearch}';">
                        <span class="glyphicon glyphicon-th-list"></span>
                        목록
                    </button>
                    
                    <c:if test="${dto.id.equals(id)}">
                    
                    <button type="button" class="btn btn-default" onclick="location.href='/bookjuck/member/fleamarket/edit.do?seq=${dto.seq}';">
                        <span class="glyphicon glyphicon-minus"></span>
                        수정
                    </button>
                    
                    <button type="button" class="btn btn-default" onclick="location.href='/bookjuck/member/fleamarket/delete.do?seq=${dto.seq}';">
                        <span class="glyphicon glyphicon-remove"></span>
                        삭제
                    </button>
                    
                    </c:if>
                    
                </div>
                <div style="clear:both;"></div>
                
                <table class="table tbl-md table-view">
                    <tr>
                        <td colspan="2" class="subject">
	                        <span class="seq">${dto.seq}.</span>
	                        <span>${dto.title}</span>
	                        <c:if test="${dto.dealState.equals('판매완료')}">
	                        	<span class="dealstate label label-default">${dto.dealState }</span>	
	                        </c:if>
	                        <c:if test="${dto.dealState.equals('판매중')}">
	                        	<span class="dealstate label label-success">${dto.dealState }</span>
	                        </c:if>
	                        <c:if test="${dto.dealState.equals('예약중')}">
	                        	<span class="dealstate label label-danger">${dto.dealState }</span>
	                        </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <span class="writer-id first-line">${dto.id}</span>
                            <a href="">
                                <input type="button" class="btn btn-xs btn-mail" value="메일보내기" onclick="location.href='mailto:${dto.email}';">
                            </a>
                            <div class="second-line">
                                <div style="float: left; width: 730px;">
                                    <span class="regdate">${dto.regDate}</span>
                                    <span class="read-cnt">조회 (${dto.readcnt})</span>
                                </div>
                                <div>
                                    <span class="commment">댓글 ${dto.ccount}</span>
                                    <input type="button" class="btn btn-xs btn-url" value="URL복사" data-toggle="modal" data-target="#url">
                                </div>
                                <div style="clear: both;"></div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                        
	                        <c:if test="${dto.image.toLowerCase().endsWith('jpg') || dto.image.toLowerCase().endsWith('gif') || dto.image.toLowerCase().endsWith('png') }">
	                            <img src="/bookjuck/files/${dto.image}" class="attach" style="display: block; margin: 20px auto;">
	                        </c:if>
                            <p>${dto.content}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="more">
                                <a href="/bookjuck/member/fleamarket/list.do?fleamarketsearch=${dto.id}"><span class="writer-id">${dto.id}</span>님의 게시물 더 보기
                                    <span class="glyphicon glyphicon-menu-right"></span></a>
                            </span>
                        </td>
                        <td class="second-col">
                            <span>댓글 ${dto.ccount }</span>
                            <input type="button" class="btn btn-xs btn-url" value="URL복사" data-toggle="modal" data-target="#url">
                        </td>
                    </tr>
                </table>



                <table class="table tbl-md table-comment table-view">
                    <c:forEach items="${clist}" var="cdto">
                    <tr>
                        <td>
                            <span class="comment">${cdto.ccontent }</span>
                            <span class="date text-right">${cdto.regdate }</span>
                            <span class="name text-right">${cdto.id }</span>
                            
                            <c:if test="${cdto.seqMember == seq}">
                            <span class="delete text-right" onclick=""><a href="/bookjuck/member/fleamarket/deletecommentok.do?seq=${cdto.seq}&seqUsedBoard=${dto.seq}';">[삭제]</a></span>
                            </c:if>
                        </td>
                    </tr>
                    </c:forEach>
                    <tr>
                   		<c:if test="${not empty id}">
                        <td>
                            <div>
                                댓글<b class="user-id">${id}</b>
                            </div>
                            <form method="POST" action="/bookjuck/member/fleamarket/commentok.do">
	                            <div class="cmt-container">
	                                <div class="comment-area">
	                                    <textarea class="form-control comment-area" id="ccontent" name="ccontent" required placeholder="댓글을 남겨보세요." cols="30"
	                                        rows="10"></textarea>
	                                    <div id="comment_cnt">(0 / 100)</div>
	                                </div>
	                                <button type="submit" class="btn btn-sm btn-comment" >등록</button>
	                                <div clear:both;></div>
	                            </div>
	                            <input type="hidden" name="seqUsedBoard" value="${dto.seq}">
                            </form>
                        </td>
                        </c:if>
                    </tr>
                </table>


            </article>
        </section>




	    <!-- ######### Modal -->
	    <div class="modal fade" id="url" role="dialog" aria-labelledby="urlHeader" aria-hidden="true" tabindex="-1">
	        <div class="modal-dialog">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <h5 class="modal-title">현재 게시글 URL 복사</h5>
	                </div>
	                <div class="modal-body">
	                    <div>
	                        <form name="clipboard"><input name="url" type="text" class="form-control"></form>
	                    </div>
	                </div>
	                <div class="modal-footer">                 
	                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	
	                    <a href="javascript:urlClipCopy()"><button class="btn btn-general">URL복사</button></a>
	                </div>
	            </div>
	        </div>
	    </div>
	    
	    
	    <!-- ######## JavaScript -->
	    <script>
	    
	    	/* 댓글 수 제한 */
	        $(document).ready(function () {
	            $('#comment').on('keyup', function () {
	                $('#comment_cnt').html("(" + $(this).val().length + " / 100)");
	
	                if ($(this).val().length > 100) {
	                    $(this).val($(this).val().substring(0, 100));
	                    $('#comment_cnt').html("(100 / 100)");
	                }
	            });
	        });
	    
	    
	    
	        /* url 링크 가져오기 */
	        function urlClipCopy() {
	            var f = document.clipboard.url;
	            f.value = document.location.href;
	            f.select() ;
	            therange=f.createTextRange() ;
	            therange.execCommand("Copy");
	            alert("클립보드로 URL이 복사되었습니다. 원하시는 곳에 붙여넣기 해 주세요.");
	        }
	        
	    </script>

		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	

</body>

</html>