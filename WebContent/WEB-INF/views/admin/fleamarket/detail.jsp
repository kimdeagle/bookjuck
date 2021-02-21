<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
            <article class="fleamarket">

                <h3>중고도서 거래 게시판</h3>
                
                <div style="clear:both;"></div>
                
                <table class="table tbl-md table-view">
                    <tr>
                        <td colspan="2" class="subject">글제목입니다. 하하하하</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <span class="writer-id first-line">글쓴이id</span>
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
                            <p>내용</p>
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
                </table>
                
				<div id="btn">
		            <input type="submit" class="btn btn-general inline" value="삭제하기" id="del">
		            <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/admin/curationletter/list.do'">뒤로가기</button>
		        </div>

            </article>
        </section>
	
	</div>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>



</body>

</html>