<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>북적북적::채팅상담 확인하기</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/chat.css">
</head>
<body>

<!-- 	<div id="main-container">
		<div id="chat-container">
			
			여기에 채팅내용이 들어간다.
			
		</div>
		<div id="bottom-container">
			<input type="text" id="message" class="form-control inline" onkeydown="return enter()">
			<input type="submit" id="btn" class="btn btn-general" value="전송" onclick="sendMessage()">
		</div>
	</div> -->
	
	
	<!-- 유저가 접속할 때마다 이 템플릿으로 채팅창을 생성한다. -->
	<div class="template" style="display:none">
		<div id="main-container">
			<div id="chat-container" class="console">
			<div class="system">고객님과 연결되었습니다.</div></div>
			<div id="bottom-container">
				<form>
					<!-- 메시지 텍스트 박스 -->
					<input type="text" class="form-control message inline" onkeydown="if(event.keyCode === 13) return false;">
					<!-- 전송 버튼 -->
					<input value="전송" type="button" class="btn btn-general sendBtn">
				</form>
			</div>
			</div>
		</div>
	</div>
	
	
	<br />
	
	</div>

	<script >
	
		// 서버의 admin의 서블릿으로 웹 소켓을 한다.
		var webSocket = new WebSocket("ws://localhost:8090/bookjuck/chat/adminchat");
		
		// 운영자에서의 open, close, error는 의미가 없어서 형태만 선언
		webSocket.onopen = function(message) { };
		webSocket.onclose = function(message) { };
		webSocket.onerror = function(message) { };
		
		// 서버로 부터 메시지가 오면
		webSocket.onmessage = function(message) {
			// 메시지의 구조는 JSON 형태로 만들었다.
			let node = JSON.parse(message.data);
			
			// 메시지의 status는 유저의 접속 형태이다.
			// visit은 유저가 접속했을 때 알리는 메시지다.
			if(node.status === "visit") {
				// 위 템플릿 div를 취득한다.
				let form = $(".template").html();
				// div를 감싸고 속성 data-key에 unique키를 넣는다.
				form = $("<div class='float-left'></div>").attr("data-key",node.key).append(form);
				// body에 추가한다.
				$("body").append(form);
			
				// message는 유저가 메시지를 보낼 때 알려주는 메시지이다.
			} else if(node.status === "message") {
				
				var date = new Date();
				var dateInfo = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
				
				// key로 해당 div영역을 찾는다.
				let $div = $("[data-key='"+node.key+"']");
				// console영역을 찾는다.
				let log = $div.find(".console").val();
				// 아래에 메시지를 추가한다.
				$div.find(".console").append('<div class="my-box"><div class="chat">'+node.message+'</div><div class="chat-info chat-box">'+dateInfo+'</div></div>');
			
				// bye는 유저가 접속을 끊었을 때 알려주는 메시지이다.
			} else if(node.status === "bye") {
				// 해당 키로 div를 찾아서 dom을 제거한다.
				$("[data-key='"+node.key+"']").remove();
			}
		};
		
		$(document).on("click", ".sendBtn", function(){
			var date = new Date();
			var dateInfo = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
			
			// div 태그를 찾는다.
			let $div = $(this).closest(".float-left");
			// 메시지 텍스트 박스를 찾아서 값을 취득한다.
			let message = $div.find(".message").val();
			// 유저 key를 취득한다.
			let key = $div.data("key");
			// console영역을 찾는다.
			let log = $div.find(".console").val();
			// 아래에 메시지를 추가한다.
			/* $div.find(".console").val(log + "(me) => " + message + "\n"); */
			$div.find(".console").append('<div class="mybox"><div class="chat mychat">'+message+'</div><div class="chat-info chat-box">'+dateInfo+'</div></div>');
			// 텍스트 박스의 값을 초기화 한다.
			$div.find(".message").val("");
			// 웹소켓으로 메시지를 보낸다.
			webSocket.send(key+"#####"+message);
		});
		
		// 텍스트 박스에서 엔터키를 누르면
		$(document).on("keydown", ".message", function(){
			// keyCode 13은 엔터이다.
			if(event.keyCode === 13) {
			// 버튼을 클릭하는 트리거를 발생한다.
			$(this).closest(".float-left").find(".sendBtn").trigger("click");
			// form에 의해 자동 submit을 막는다.
			return false;
			}
			return true;
		});
	</script>
</body>
</html>