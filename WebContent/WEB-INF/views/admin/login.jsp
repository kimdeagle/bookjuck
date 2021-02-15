<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BookjuckBookjuck::Admin::Login</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/adminlogin.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">

<style>

</style>
</head>
 
<body>
    <div id="logo">
        <img src="/bookjuck/image/bookjeok/logo.png">
    </div>

    <div id="login">
        <h6>관리자 로그인</h6>
        <form method="POST" action="#" id="loginform">
            <input type="text" id="id" class="form-control noline small inline" placeholder="아이디를 입력해주세요.">
            <input type="text" id="pwd" class="form-control noline small inline" placeholder="비밀번호를 입력해주세요.">
            <input type="button" class="btn btn-general" id="loginbtn" value="로그인">
        </form>
    </div>
</body>
</html>