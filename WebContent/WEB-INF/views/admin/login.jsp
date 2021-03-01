<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::로그인</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/adminlogin.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">

<style>

</style>
</head>
 
<body background="/bookjuck/image/background/admin_bg.jpg">
    
    <div id="logo">
        <img src="/bookjuck/image/bookjeok/logo.png">
    </div>

    <div id="login">
        <h4>관리자 로그인</h4>
        <form method="POST" action="/bookjuck/admin/loginok.do" id="loginform" onmouseover="over()">
            <input type="text" id="id" name="id" class="form-control noline small inline" placeholder="아이디를 입력해주세요.">
            <input type="password" id="pwd" name="pwd" class="form-control noline small inline" placeholder="비밀번호를 입력해주세요.">
            <input type="submit" class="btn btn-general" id="loginbtn" value="로그인">
        </form>
    </div>
    
    <div id="footer">
		<address>
			<p>
				Copyright ©
				<b>BookJuck</b>
				Corp. All Rights Reserved.
			</p>
		</address>
	</div>
    
    
    
    <script type="text/javascript">
   /*  var nowZoom = 100;
    
    	function over(){
    		   nowZoom = nowZoom + 20;
    		   if(nowZoom >= 200) nowZoom = 200;   // 화면크기 최대 확대율 200%
    		   zooms();

    		333
    		alert('라라라라');
    	}
    	
    	function zooms() {
    		   document.body.style.zoom = nowZoom + "%";
    		   if(nowZoom == 70) {
    		      alert("더 이상 축소할 수 없습니다.");   // 화면 축소율이 70% 이하일 경우 경고창
    		   }
    		   if(nowZoom == 200) {
    		      alert("더 이상 확대할 수 없습니다.");   // 화면 확대율이 200% 이상일 경우 경고창
    		   }
    		} */

    		
    </script>
</body>
</html>