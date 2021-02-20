<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html xmlns='http://www.w3.org/1999/xhtml'>
    <head>
        <title>Real-time Rank</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <link href="stylesheet.css" media="screen" rel="stylesheet" type="text/css" />
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
                        <li><a href="#">1 순위</a></li>
                        <li><a href="#">2 순위</a></li>
                        <li><a href="#">3 순위</a></li>
                        <li><a href="#">4 순위</a></li>
                        <li><a href="#">5 순위</a></li>
                        <li><a href="#">6 순위</a></li>
                        <li><a href="#">7 순위</a></li>
                        <li><a href="#">8 순위</a></li>
                        <li><a href="#">9 순위</a></li>
                        <li><a href="#">10 순위</a></li>
                    </ol>
                </dd>
            </dl>
        </div>
        <script>
$(function() {
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
});
</script>
    </body>
</html>






