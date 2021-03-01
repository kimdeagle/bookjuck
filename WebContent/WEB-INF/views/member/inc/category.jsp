<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside>
<!-- 카테고리 좌측메뉴 -->
    <div id="categorytitle">
    	<c:forEach items="${mCategoryList}" var="mcdto">
	    	<c:if test="${seqMCategory.equals(mcdto.seqMCategory)}">
		        <h5 class="h5-white">${mcdto.lCategory}</h5>
		        <h6 class="h6-white">${mcdto.mCategory}</h6>
	        </c:if>
        </c:forEach>
    </div>

    <div id="categorylist">
        <c:forEach items="${sCategoryList}" var="dto">
        	<a href="/bookjuck/member/book/booklist.do?seqLCategory=${seqLCategory}&seqMCategory=${seqMCategory}&seqSCategory=${dto.seqSCategory}">${dto.sCategory}</a>
        </c:forEach>
        
    </div>

</aside>