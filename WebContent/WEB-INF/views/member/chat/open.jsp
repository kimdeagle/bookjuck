<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>북적북적::북적이에게 문의하기</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/chat.css">
</head>
<body onresize="parent.resizeTo(450,775)" onload="parent.resizeTo(450,775)">

	<div id="main-container">
		<div id="chat-container">
			
			<!-- 여기에 채팅내용이 들어간다. -->
			
		</div>
		<div id="bottom-container">
			<input type="text" id="message" class="form-control inline" onkeydown="return enter()">
			<input type="submit" id="btn" class="btn btn-general" value="전송" onclick="sendMessage()">
		</div>
	</div>
	
<br />
	<script type="text/javascript">

	// 서버의 broadsocket의 서블릿으로 웹 소켓을 한다.
	var webSocket = new WebSocket("ws://localhost:8090/bookjuck/chat/memberchat");
	
	// 콘솔 텍스트 영역
	var messageTextArea = document.getElementById("messageTextArea");
	
	// 내꺼
	var chatContainer=document.getElementById("chat-container");
	
	// 접속이 완료되면
	webSocket.onopen = function(message) {
		// 연결되었다는 문구 출력
		$('#chat-container').append('<div class="system">북적이에게 연결되었습니다.</div>');
		$('#chat-container').append('<div class="chat-box"><div class="chat">안녕하세요. 고객님, 북적이입니다.<br>무엇을 도와드릴까요?</div><div class="chat-info chat-box">'+dateInfo+'</div></div>');
		
	};
	
	// 접속이 끝기는 경우는 브라우저를 닫는 경우이기 떄문에 이 이벤트는 의미가 없음.
	webSocket.onclose = function(message) { };
	
	// 에러가 발생하면
	webSocket.onerror = function(message) {
		// 연결할 수 없다는 메시지를 남긴다.
		$('#chat-container').append('<div class="system">북적이에게 연결할 수 없습니다.</div>');
	};
	
	// 서버로부터 메시지가 도착하면 콘솔 화면에 메시지를 남긴다.
	webSocket.onmessage = function(message) {
		var date = new Date();
		var dateInfo = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
		
		$('#chat-container').append('<div class="chat-box"><div class="chat">'+message.data+'</div><div class="chat-info chat-box">'+dateInfo+'</div></div>');
	};
	
	// 서버로 메시지를 발송하는 함수
	// Send 버튼을 누르거나 텍스트 박스에서 엔터를 치면 실행
	function sendMessage() {
		var date = new Date();
		var dateInfo = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
		
		// 텍스트 박스의 객체를 가져옴
		let message = document.getElementById("message");
		// 채팅창에 메세지를 남긴다.
		$('#chat-container').append('<div class="mybox"><div class="chat mychat">'+message.value+'</div><div class="chat-info">'+dateInfo+'</div></div>');
		// 소켓으로 보낸다.
		webSocket.send(message.value);
		// 텍스트 박스 추기화
		message.value = "";
	}
	
	// 텍스트 박스에서 엔터를 누르면
	function enter() {
		// keyCode 13은 엔터이다.
		if(event.keyCode === 13) {
		// 서버로 메시지 전송
		sendMessage();
		// form에 의해 자동 submit을 막는다.
		return false;
		}
		return true;
	}
	</script>
</body>
</html>