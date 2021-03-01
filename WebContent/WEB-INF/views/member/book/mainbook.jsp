<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
   
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/mainbook.css">


<style>

</style>

</head>
<body>

	<section style="width:700px;"> 
			<div class="btns">
                <input type="button" class="btn btn-default btn-lg btn-general" value="추천도서" id="rec">
                <input type="button" class="btn btn-default btn-lg btn-general" value="베스트도서" id="best">
                <input type="button" class="btn btn-default btn-lg btn-general" value="화제의 신간" id="new">
            </div>
            
  			<div id="recbook" style="display:none;"> <!-- default는 베스트도서  -->
   			<table id="booktable">
   				<c:forEach items="${list1}" var="dto"> <!--추천도서 비회원 사용불가 -->
                    <td>
                        <div class="tblitem">
                            <a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><img src="/bookjuck/image/${dto.image}" class="book-sm"></a>
                            <a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><h6>${dto.title}</h6></a>
                            <p>${dto.copy}</p>
                        </div>
                    </td>
            </c:forEach>
            </table>
            </div>
           <div id="bestbook" style="width:600px;">
            <table id="booktable">
			  	<c:forEach items="${list3}" var="dto"> <!-- 베스트도서 -->
                    <td style="width:400px;">
                        <div class="tblitem">
                            <a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><img src="/bookjuck/image/${dto.image}" class="book-sm"></a>
                            <a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><h6>${dto.title}</h6></a>
                            <p>${dto.copy}</p>
                        </div>
                    </td>
                 </c:forEach>
            </table>
           </div>
           
            <div id="newbook" style="display:none;"> <!-- default는 베스트도서  -->
            	<table id="booktable">           	
					<c:forEach items="${list2}" var="dto"> <!--화제의신간 -->					
                    <td>
                        <div class="tblitem">
                            <a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><img src="/bookjuck/image/${dto.image}" class="book-sm"></a>
                            <a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><h6>${dto.title}</h6></a>
                            <p>${dto.copy}</p>
                        </div>
                    </td>
                    </c:forEach>                
            </table>
            </div>
         
            
   	</section>

   <script>
   

   $(document).ready(function() {
	   
	   var recbook = document.getElementById('recbook');
	   var bestbook = document.getElementById('bestbook');
	   var newbook = document.getElementById('newbook');
	   
	   <c:if test="${empty id}">
		$("#rec").click(function() {			
				alert("회원이 되시면 북적북적의 관심사 추천도서를 보실 수 있습니다.")
		})
		</c:if>
		
		<c:if test="${not empty id}">
		$("#rec").click(function() {
			recbook.style.display = 'block';
			bestbook.style.display = 'none';
			newbook.style.display = 'none';
		})
		</c:if>
		
		$("#best").click(function() {
			bestbook.style.display = 'block';
			recbook.style.display = 'none';
			newbook.style.display = 'none';
			
		})
		
		$("#new").click(function(){
			newbook.style.display = 'block';
			recbook.style.display = 'none';
			bestbook.style.display = 'none';
	
			
			
		})  
	
	})
   
   
   	
      
   </script>

</body>
</html>