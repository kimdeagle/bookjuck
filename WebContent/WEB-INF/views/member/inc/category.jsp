<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside>
<!-- 카테고리 좌측메뉴 -->
    <div id="categorytitle">
        <h5 class="h5-white">${lCategory}</h5>
        <h6 class="h6-white">${mCategory}</h6>
    </div>

    <div id="categorylist">
        <c:forEach items="${sCategoryList}" var="dto">
        	<a href="/bookjuck/member/book/booklist.do?seqLCategory=${seqLCategory}&lCategory=${lCategory}&seqMCategory=${seqMCategory}&mCategory=${mCategory}&seqSCategory=${dto.seqSCategory}&sCategory=${dto.sCategory}">${dto.sCategory}</a>
        </c:forEach>
        
    </div>

</aside>