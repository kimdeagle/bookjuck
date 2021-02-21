<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html xmlns='http://www.w3.org/1999/xhtml'>
    <head>
        <title>Real-time Rank</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <!-- <link href="/bookjuck/css/realtimesearch.css" media="screen" rel="stylesheet" type="text/css" /> -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="/bookjuck/css/global.css">
        <%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
        </head>
    <body>
    
        <div id="content">
            <dl id="rank-list">
                <dt>실시간 급상승 검색어</dt>
                <dd>
                    <ol>
                        <c:forEach items="${list}" var="dto">
                        <li><a href="http://localhost:8090/bookjuck/common/searchview.do?sk=&sv=${dto.searchword}">${dto.searchword}</a></li>
                        </c:forEach>
                    </ol>
                </dd>
            </dl>
        </div>
       
        <script>
 /* $(function() { //실시간 검색어 순위대로 보여주기
    var count = $('#rank-list li').length;
    var height = $('#rank-list li').height();

    function step(index) {
        $('#rank-list ol').delay(2000).animate({
            top: -height * index,
        }, 500, function() {
            step((index + 1) % count);
        });
    }

    step(1);
});  */
</script>
    </body>
</html>






