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
<style>
</style>

</head>
<body>
   
   
   <section class="mainsection">
    <h3 id="bestmonthtitle">월간베스트</h3>
    <c:forEach items="${list}" var="dto" begin="0" end="0" step="1">
    <table id="bestmonth">
        <tr>
            <td>
                <div class="monthitem">
                    <img src="image/${dto.image}" class="book-sm">
                    <h6>${dto.title}</h6>
                    <p>${dto.copy}</p>
                </div>
            </td>
            <td>
                <div class="monthitem">
                    <img src="image/${dto.image}" class="book-sm">
                    <h6>${dto.title}</h6>
                    <p>${dto.copy}</p>
                </div>
            </td>
            <td>
                <div class="monthitem">
                    <img src="image/${dto.image}" class="book-sm">
                    <h6>${dto.title}</h6>
                    <p>${dto.copy}</p>
                </div>
            </td>
            <td>
                <div class="monthitem">
                    <img src="image/${dto.image}" class="book-sm">
                    <h6>${dto.title}</h6>
                    <p>${dto.copy}</p>
                </div>
            </td>
            <td>
                <div class="monthitem">
                    <img src="image/${dto.image}" class="book-sm">
                    <h6>${dto.title}</h6>
                    <p>${dto.copy}</p>
                </div>
            </td>
        </tr>
    </table>
    </c:forEach>
</section>
   
   
   
   
   
   
   

   <script>
      
   </script>

</body>
</html>