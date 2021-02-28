<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>


<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/fleamarket.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<section class="contentsection">
		<article class="fleamarket">
			<h3>중고거래게시판<small style="margin-left:15px;">상세조회</small></h3>
				<table class="table tbl-md" id="admindetailtbl">
					<tr>
						<th class="col-md-2">제목</th>
	                 	<td class="col-md-6">${dto.title}</td>
	                 	<th class="col-md-1">조회수</th>
	                 	<td class="col-md-3">${dto.readcnt}</td>
					</tr>
					<tr>
	                 	<th>작성자</th>
	                 	<td>${dto.id}<button class="btn btn-xs" onclick="location.href='/bookjuck/admin/fleamarket/list.do?fleamarketsearch=${dto.id}'">게시물더보기</button></td>
	                 	<th>작성일</th>
	                 	<td>${dto.regDate}</td>
					</tr>
					<tr>
                        <td colspan="4">
							<c:if test="${dto.image.toLowerCase().endsWith('jpg') || dto.image.toLowerCase().endsWith('gif') || dto.image.toLowerCase().endsWith('png') }">
	                            <img src="/bookjuck/files/${dto.image}" class="attach" style="display: block; margin: 20px auto;">
	                        </c:if>
                            <p>${dto.content}</p>
                        </td>
                    </tr>
                </table>

				<small>댓글(${clist.size()}) <span class="glyphicon glyphicon-comment"></span></small>
				<table class="table tbl-md" id="cmttbl">
					<c:if test="${clist.size()==0}">
						<tr>
							<td style="text-align:center;">댓글이 없습니다.</td>
						</tr>
					</c:if>
					<c:if test="${clist.size()!=0}">
						<c:forEach items="${clist}" var="cdto">
							<tr>
		                  		<td class="tbl-sm-1">${cdto.id}<br><small style="font-size:0.8em;">${cdto.regdate}</small></td>
		                  		<td class="tbl-sm-11">${cdto.ccontent}
		                  		<button class="btn btn-xs" data-toggle="modal" id="cmtdelbtn" name="cmtdelbtn" data-target="#cmdelModal" data-seq=${dto.seq} data-cseq=${cdto.seq}>삭제</button></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>

            	<div id="btn">
				    <input type="button" class="btn btn-general" value="삭제하기" id="delete" data-toggle="modal" data-target="#ubdelModal" data-image=${dto.image}>
				    <button type="button" class="btn btn-general inline" id="back" onclick="location.href='/bookjuck/admin/fleamarket/list.do?page=${page}&fleamarketsearch=${fleamarketsearch}'">뒤로가기</button>
				</div>

            </article>
        </section>
	
	</div>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>

	<!-- 중고거래글 삭제 확인 모달 -->
	<div class="modal fade" id="ubdelModal" role="dialog">
        <div class="modal-dialog modal-md">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
	            <p>정말 삭제하시겠습니까?</p>
            </div>
            <div id="btn">
               	<button type="button" class="btn btn-general inline" id="modaldel" onclick="location.href='/bookjuck/admin/fleamarket/del.do?seq=${dto.seq}'">삭제하기</button>
            </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
        </div>
    </div>
    
    <!-- 댓글 삭제 확인 모달 -->
	<div class="modal fade" id="cmdelModal" role="dialog">
       <div class="modal-dialog modal-md">
         <div class="modal-content">
           <div class="modal-header">
             <button type="button" class="close" data-dismiss="modal">&times;</button>
             <h4 class="modal-title"></h4>
           </div>
           <div class="modal-body">
	           <form method="GET" action="/bookjuck/admin/fleamarket/commentdel.do">
		           <p>정말 삭제하시겠습니까?</p>
		           <input type="hidden" id="seq" name="seq">
		           <input type="hidden" id="cseq" name="cseq">
		           <div id="btn">
		               <input type="submit" class="btn btn-general inline" id="del" value="삭제하기">
		           </div>
	           </form>
           </div>
       <!-- <div class="modal-footer">
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       </div> -->
       	</div>
       </div>
   </div>
   
	<script>
	
   		$("#cmtdelbtn").click(function(){
   			$("#seq").val($(this).data("seq"));
   			$("#cseq").val($(this).data("cseq"));
   		});
   		
	</script>
	
	$('.cell2 > a').on('click', function(){

</body>

</html>