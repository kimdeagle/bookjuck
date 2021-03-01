<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::MyPage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/faq.css">

<style>

</style>
</head>

<body>



	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<div class="container">
	
		<!-- ########## 상단 헤더 시작 -->
		<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
		<!-- ########## 상단 헤더 끝 -->
	
	
		<!-- 마이페이지 side bar -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		
		
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
		<section class="contentsection">
    	<h3>자주 하는 질문</h3>
    	
    			<%-- <c:if test="${not empty search}">
        	        <div class="message well well-sm">
                    '${search}'(으)로 ${list.size()}건의 게시물을 검색했습니다.
                	</div>
                </c:if> --%>
                
                
            <!-- 검색창 -->
            <form id="searchForm" method="GET" action="/bookjuck/member/faq/list.do">
            <div class="input-group search">
            
                <input type="text" class="form-control" placeholder="검색어를 입력해주세요." aria-describedby="basic-addon2" id="search" name="search" required value="${search}">
                
                <span class="input-group-addon" id="basic-addon2" style="cursor:pointer;" onclick="$('#searchForm').submit();"><span class="glyphicon glyphicon-search"></span></span>
            </div>
            </form>
            <div style="clear:both;"></div>
            <table class="table tbl-md" id="listtbl">
                <tr>
                    <th>카테고리</th>
                    <th>결제</th>
                </tr>
                
                <c:if test="${flist.size()==0}">
			        <tr>
			        	<td colspan="3" style="text-align:center;">게시물이 없습니다.</td>
			        </tr>
			    </c:if>
			    
		        <c:forEach items="${flist}" var="fdto">
		        
                <tr>
                    <td>${fdto.qCategory}</td>
                    <td class="cell2"><a id="openModal" data-toggle="modal" href="#myModal" data-seq="${fdto.seq}" data-title="${fdto.title}" data-content="${fdto.content}">${fdto.title}</a></td>
                </tr>
                </c:forEach>
            </table>
            
            <nav class="pagebar">
                <ul class="pagination">
                    ${pagebar}
                </ul>
            </nav>
            
            <div id="btn">
                <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/member/mypage.do'">뒤로가기</button>
            </div>
            
        </section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	<!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog modal-md">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
            	<span class="glyphicon glyphicon-question-sign"></span><p id="modaltitle"></p>
	            <br>
	            <span class="glyphicon glyphicon-ok-sign"></span><p id="modalcontent"></p>
	            <input type="hidden" id="modalseq">
            </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
        </div>
    </div>

	<script>
	
		var seq="";
		var title="";
		var content="";
	
		$('.cell2 > a').on('click', function(){
			$('#modalseq').val($(this).data("seq"));
			$('#modaltitle').text($(this).data("title"));
			$('#modalcontent').text($(this).data("content"));
			
		});
		
		$('#edit').on('click', function(){
			location.href="/bookjuck/admin/faq/edit.do?seq="+$('#modalseq').val();
		});
		
		$('#del').on('click', function(){
			location.href="/bookjuck/admin/faq/del.do?seq="+$('#modalseq').val();
		});
	
	</script>

</body>

</html>