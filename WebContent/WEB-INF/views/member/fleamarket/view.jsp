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

    
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>


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

                <h3>중고도서 거래 게시판</h3>

                <div class="btns btn-group">
                    <button type="button" class="btn btn-default " onclick="location.href='';">
                        <span class="glyphicon glyphicon-th-list"></span>
                        목록
                    </button>
                    
                    <button type="button" class="btn btn-default" onclick="location.href='';">
                        <span class="glyphicon glyphicon-minus"></span>
                        수정
                    </button>
                    
                    <button type="button" class="btn btn-default" onclick="location.href='';">
                        <span class="glyphicon glyphicon-remove"></span>
                        삭제
                    </button>
                </div>
                <div style="clear:both;"></div>
                
                <table class="table tbl-md table-view">
                    <tr>
                        <td colspan="2" class="subject">글제목입니다. 하하하하</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <span class="writer-id first-line">글쓴이id</span>
                            <a href>
                                <input type="button" class="btn btn-xs btn-mail" value="메일보내기">
                            </a>
                            <div class="second-line">
                                <div style="float: left; width: 730px;">
                                    <span class="regdate">2021-02-18 14:56:00</span>
                                    <span class="read-cnt">조회 (0)</span>
                                </div>
                                <div>
                                    <span class="commment">댓글 5</span>
                                    <input type="button" class="btn btn-xs btn-url" value="URL복사">
                                </div>
                                <div style="clear: both;"></div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <img src="/bookjuck/image/빛의 과거.png" class="attach" style="display: block; margin: 20px auto;">
                            <p>이게 바로 내용입니다.</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="more">
                                <a href=""><span class="writer-id">글쓴이id</span>님의 게시물 더 보기
                                    <span class="glyphicon glyphicon-menu-right"></span></a>
                            </span>
                        </td>
                        <td class="second-col">
                            <span>댓글 5</span>
                            <input type="button" class="btn btn-xs  btn-url" value="URL복사">
                        </td>
                    </tr>
                </table>


                <script>
                    $(document).ready(function () {
                        $('#comment').on('keyup', function () {
                            $('#comment_cnt').html("(" + $(this).val().length + " / 100)");

                            if ($(this).val().length > 100) {
                                $(this).val($(this).val().substring(0, 100));
                                $('#comment_cnt').html("(100 / 100)");
                            }
                        });
                    });

                </script>



                <table class="table tbl-md table-comment table-view">
                    <tr>
                        <td>
                            <span class="comment">코멘트입니다.</span>
                            <span class="date">2021-02-19</span>
                            <span class="name">hong1234</span>
                            
                            <span class="delete" onclick=""><a href>[삭제]</a></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div>
                                댓글<b class="user-id">로그인한 유저id</b>
                            </div>
                            <div class="cmt-container">
                                <div class="comment-area">
                                    <textarea class="form-control comment-area" id="comment" placeholder="댓글을 남겨보세요." cols="30"
                                        rows="10"></textarea>
                                    <div id="comment_cnt">(0 / 100)</div>
                                </div>
                                <input type="button" class="btn btn-sm btn-comment" value="등록">
                                <div clear:both;></div>
                            </div>
                        </td>
                    </tr>
                </table>


            </article>
        </section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	

</body>

</html>