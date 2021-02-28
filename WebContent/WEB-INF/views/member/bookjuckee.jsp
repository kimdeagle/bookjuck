<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/bookjuck/css/global.css">
    
<!-- 북적이에게 문의하기 -->

<div id="bookjeok">
    <label for="character">
    <a onclick="openChat()" style="cursor:pointer"><img src="/bookjuck/image/bookjeok/chatbtn.png" id="chatbtn"></a>
    <h6>북적이에게</h6>
    <h6>문의하기</h6>
    </label>
</div>

	<script>
	
	function openChat(){
		window.open("/bookjuck/member/chat/open.do","chat", "width=450, height=775, toolbar=no, menubar=no, scrollbars=no, resizable=no");
	};
	
	</script>