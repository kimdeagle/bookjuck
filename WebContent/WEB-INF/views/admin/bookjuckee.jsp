<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
<link rel="stylesheet" href="/bookjuck/css/global.css">
    
<!-- 채팅상담 확인하기 -->

<div id="bookjeok">
    <label for="character">
    <a onclick="openChat()" style="cursor:pointer"><img src="/bookjuck/image/bookjeok/chatbtn.png" id="chatbtn"></a>
    <h6>채팅상담</h6>
    <h6>확인하기</h6>
    </label>
</div>

	<script>
	
	function openChat(){
		window.open("/bookjuck/admin/chat/open.do","chat", "toolbar=no, menubar=no");
	};
	
	</script>