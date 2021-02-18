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
<link rel="stylesheet" href="/bookjuck/css/qna.css">

<style>

</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>
	
	
		<section class="contentsection">
                <h3>QnA</h3>

                <div id="subtitle">상세조회</div>

                <div id="qbox">
                    <h5>문제가 있는데 어떻게 해야할지 잘 모르겠습니다.</h5>
                    <div id="qinfo">abcd1234 &verbar; 2021-02-10</div>
                    <div>환불 신청 어떻게 하는지 궁금합니다. 알려주세요.</div>
                </div>

                <!-- 답변이 있을 경우! -->
                <div id="abox">
                    
                    <div>안녕하세요. 북적북적입니다.
                    환불은 나의 주문 내역 > 교환/환불/취소 에서 신청할 수 있습니다.</div>
                    <div id="ainfo">2021-02-10</div>
                    
                </div>
                <div id="btn">
                	<button type="button" class="btn btn-general" id="add" onclick="location.href='/bookjuck/admin/qna/add.do'">답변 작성하기</button>
                    <button type="button" class="btn btn-general" id="edit" onclick="location.href='/bookjuck/admin/qna/edit.do'">수정하기</button>
                    <button type="button" class="btn btn-general inline" id="del" onclick="location.href='/bookjuck/admin/qna/del.do'">삭제하기</button>
                    <button type="button" class="btn btn-general inline" id="back" onclick="location.href='/bookjuck/admin/qna/list.do'">뒤로가기</button>
                </div>
            
        </section>
        
	</div>
	
		<!-- 플로팅 메뉴 -->
		<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
		<%@include file="/WEB-INF/views/common/top.jsp" %>
		
		
		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->

	

</body>

</html>