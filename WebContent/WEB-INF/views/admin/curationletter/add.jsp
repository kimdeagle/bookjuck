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
<link rel="stylesheet" href="/bookjuck/css/curationletter.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<section class="contentsection">
        <h3>큐레이션레터<small style="margin-left:15px;">작성하기</small></h3>
            <form method="POST" action="/bookjuck/admin/curationletter/send.do">
            	<table class="table tbl-md">
            		<tr>
            			<th>받을 회원</th>
            			<td>
	            			<select class="form-control selectpicker" id="email" name="email">
	            				<c:forEach items="${mlist}" var="mdto">
	            					<option value=${mdto.email}>${mdto.id}</option>
	            				</c:forEach>
							</select>
						</td>
            		</tr>
            		<tr>
            			<th>제목</th>
            			<td><input type="text" id="title" name="title" class="form-control" placeholder="제목을 입력해주세요"></td>
            		</tr>
            		<tr>
            			<th>내용</th>
            			<td><textarea id="content" name="content" class="form-control"  placeholder="내용을 입력해주세요" cols="40" rows="13"></textarea></td>
            		</tr>
            		<tr>
            			<td colspan="2" style="vertical-align:middle;">
							<span class="glyphicon glyphicon-exclamation-sign"></span><b>큐레이션 레터는 즉시전송만 가능합니다!</b></td>
						</td>
					</tr>
            	</table>
	            <div id="btn">
	                <input type="submit" class="btn btn-general inline" value="전송하기" id="send">
	                <button type="button" class="btn btn-general inline" id="preview" data-toggle="modal" href="#myModal">미리보기</button>
	                <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/admin/curationletter/list.do'">뒤로가기</button>
	            </div>
            </form>
    </section>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>

	<!-- 큐레이션 레터 미리보기 모달 -->
	<div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog modal-md">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
                <div id="example">
                    <h5 id="modaltitle"></h5>
                    <p id="modalsenddate"></p>
                    <div id="modalcontent"></div>
                    
                </div>
            </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
        </div>
    </div>
    
    <script>
    
	    $('#preview').on('click', function(){
	    	var date = new Date();
			var dateInfo = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate();
			
			$('#modaltitle').html($('#title').val());
			$('#modalsenddate').val(dateInfo);
			$('#modalcontent').html($('#content').val());
				
		});
	    
    </script>

</body>

</html>