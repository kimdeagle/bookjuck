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
<link rel="stylesheet" href="/bookjuck/css/qna.css">

<style>

</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>
	
	
		<section class="contentsection">
                <h3>QnA<small style="margin-left:15px;">상세조회</small></h3>
				
				<table class="table tbl-md" id="qnatbl">
					<tr>
						<th class="col-md-2">질문제목</th>
						<td class="col-md-4">${qdto.title}</td>
						<th class="col-md-2">질문등록일</th>
						<td class="col-md-4">${qdto.regDate.substring(0, 10)}</td>
					</tr>
					<tr>
						<th class="col-md-2">아이디</th>
						<td class="col-md-4">${qdto.id}</td>
						<th class="col-md-2">답변등록일</th>
						<td class="col-md-4">
							<c:if test="${empty adto.answerDate}">
							<span>답변대기중</span>
							</c:if>
							<c:if test="${not empty adto.answerDate}">
							<span>${adto.answerDate.substring(0, 10)}</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<th class="col-md-2">질문내용</th>
						<td colspan="3">${qdto.content}</td>
					</tr>
					<tr>
						<th class="col-md-2">답변내용</th>
						<c:if test="${empty adto.answerDate}">
						<td><span>현재 답변 대기중입니다.</span></td>
						</c:if>
						
						<c:if test="${not empty adto.answerDate}">
						<td colspan="3">${adto.answerContent}</td>
						</c:if>
					</tr>
				</table>
			
                <div id="btn">
                	<c:if test="${empty adto.answerDate}">
					<button type="button" class="btn btn-general" id="addModalbtn" data-toggle="modal" href="#addModal" data-seq="${qdto.seq}">답변 작성하기</button>
                    <button type="button" class="btn btn-general inline" id="delModalbtn" data-toggle="modal" data-target="#delModal">삭제하기</button>
                	<button type="button" class="btn btn-general inline" id="back" onclick="location.href='/bookjuck/admin/qna/list.do?page=${page}'">뒤로가기</button>
                	</c:if>
                	<c:if test="${not empty adto.answerDate}">
                	<button type="button" class="btn btn-general" id="editModalbtn" data-toggle="modal" href="#editModal" data-seq="${adto.seq}" data-answercontent="${adto.answerContent}" data-seqquestion="${qdto.seq}">답변 수정하기</button>
                    <button type="button" class="btn btn-general inline" id="delModalbtn" data-toggle="modal" data-target="#delModal">삭제하기</button>
                    <button type="button" class="btn btn-general inline" id="back" onclick="location.href='/bookjuck/admin/qna/list.do?page=${page}'">뒤로가기</button>
                	</c:if>
                </div>
            
        </section>
        
	</div>
	
		<!-- 플로팅 메뉴 -->
		<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
		<%@include file="/WEB-INF/views/common/top.jsp" %>
		
		
		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	<!-- 답변 작성 모달 -->
    <div class="modal fade" id="addModal" role="dialog">
        <div class="modal-dialog modal-md">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
            	<form method="POST" action="/bookjuck/admin/qna/addok.do">
            		<table class="table tbl-md" id="modaltbl">
            			<tr>
            				<th>답변내용</th>
            			</tr>
            			<tr>
            				<td>
	            				<textarea id="addanswerContent" name="addanswerContent" class="form-control" cols="40" rows="15" style="width:100%;"></textarea>
	            			</td>
	            		</tr>
            		</table>
            		<input type="hidden" id="addseqQuestion" name="addseqQuestion">
            		<div id="btn">
                		<input type="submit" class="btn btn-general" value="저장하기">
            		</div>
            	</form>
            </div>
            
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
        </div>
    </div>
    
    <!-- 답변 수정 모달 -->
    <div class="modal fade" id="editModal" role="dialog">
        <div class="modal-dialog modal-md">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
            	<form method="POST" action="/bookjuck/admin/qna/editok.do">
            		<table class="table tbl-md" id="modaltbl">
            			<tr>
            				<th>답변내용</th>
            			</tr>
            			<tr>
            				<td>
	            				<textarea id="editanswerContent" name="editanswerContent" class="form-control" cols="40" rows="15" style="width:100%;"></textarea>
	            			</td>
	            		</tr>
            		</table>
            		<input type="hidden" id="editseqQuestion" name="editseqQuestion">
            		<input type="hidden" id="editseq" name="editseq">
            		<div id="btn">
                		<input type="submit" class="btn btn-general" value="저장하기">
            		</div>
            	</form>
            </div>
            
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
        </div>
    </div>
    
    <!-- 삭제 확인 모달 -->
	<div class="modal fade" id="delModal" role="dialog">
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
               	<button type="button" class="btn btn-general inline" id="modaldel">삭제하기</button>
            </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
        </div>
    </div>

	<script>
	
		// 답변 추가
		$('#addModalbtn').on('click', function(){
			$('#addseqQuestion').val($(this).data("seq"));
			
		});
		
		// 답변 수정
		$('#editModalbtn').on('click', function(){
			$('#editseqQuestion').val($(this).data("seqquestion"));
			$('#editanswerContent').val($(this).data("answercontent"));
			$('#editseq').val($(this).data("seq"));
		});
		
		// 질문글 삭제 확인
		$("#modaldel").click(function(){
    	<c:if test="${empty adto.answerDate}">
			location.href="/bookjuck/admin/qna/del.do?seq=${qdto.seq}&isdone=n";
		</c:if>
    	
    	<c:if test="${not empty adto.answerDate}">
    		location.href="/bookjuck/admin/qna/del.do?seq=${qdto.seq}&isdone=n";
    	</c:if>
    	});
		
	</script>

</body>

</html>