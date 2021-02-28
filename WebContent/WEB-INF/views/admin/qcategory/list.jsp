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
<link rel="stylesheet" href="/bookjuck/css/qcategory.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<section class="contentsection">
            <h3>자주 하는 질문<small style="margin-left:15px;">질문카테고리 관리</small></h3>
	            <table class="table tbl-md small" id="categorytbl">
	                <tr>
	                    <th colspan="2">현재 질문카테고리</th>
	                </tr>
	                <c:forEach items="${clist}" var="cdto">
	                <tr>
	                    <td>${cdto.category}</td>
	                    <td>
	                        <div id="tblbtn">
	                            <button type="button" class="btn btn-general" id="edit" data-toggle="modal" href="#editModal" data-seq=${cdto.seq} data-category=${cdto.category}>카테고리명 수정하기</button>
	                        </div>
	                    </td>
	                </tr>
	                </c:forEach>
	            </table>

            <nav class="pagebar">
                <ul class="pagination">
                    ${pagebar}
                </ul>
            </nav>

            <div id="normalbtn">
                <button type="button" class="btn btn-general" data-toggle="modal" href="#addModal" data-seq="${cdto.seq}">추가하기</button>
                <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/admin/faq/list.do'">뒤로가기</button>
            </div>
        </section>
	
	</div>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>

	<!-- 질문카테고리 추가 모달 -->
    <div class="modal fade" id="addModal" role="dialog">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">질문카테고리 추가</h4>
                </div>
                <div class="modal-body">
                    <form method="POST" action="/bookjuck/admin/qcategory/addok.do" id="form">
                        <p>추가할 질문카테고리를 입력해주세요.</p>
                        <input type="text" class="form-control large inline" id="addcategory" name="addcategory">
                        <input type="submit" class="btn btn-general inline" id="add" value="추가">
                    </form>
                </div>  
            </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
    </div>

	<!-- 질문카테고리 수정 모달 -->
    <div class="modal fade" id="editModal" role="dialog">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">질문카테고리 수정</h4>
                </div>
                <div class="modal-body">
                    <form method="POST" action="/bookjuck/admin/qcategory/editok.do" id="editform">
                        <p>수정할 질문카테고리를 입력해주세요.</p>
                        <input type="text" class="form-control large inline" id="category" name="category">
                        <input type="hidden" id="seq" name="seq">
                        <input type="submit" class="btn btn-general inline" id="edit" value="수정">
                    </form>
                </div>  
            </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
    </div>
    
    <script>
    
    	$('#tblbtn > #edit').on('click', function(){
			$('#seq').val($(this).data("seq"));
			$('#category').val($(this).data("category"));
			
		});
	
	</script>
</body>

</html>