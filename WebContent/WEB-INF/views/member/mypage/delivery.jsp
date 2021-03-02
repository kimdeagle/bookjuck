<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>북적북적::배송조회</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
<link rel="stylesheet" href="/bookjuck/css/global.css">

<style>

	.delivery {
	    width: 450px;
	    margin: 40px 0px 0px 20px;
	}
	
	.delivery label {
	    float: left;
	    margin-right: 10px;
	    margin-top: 5px;
	}
	
	.delivery #t_invoice {
	    float: left;
	    width: 280px;
	    margin-right: 10px;
	}
	
	.body {
		margin: auto;
	}

</style>

</head>
<body onresize="parent.resizeTo(500,700)" onload="parent.resizeTo(500,700)">

	<h3 style="width: 450px; margin: 50px 0px 0px 20px;">배송 조회하기</h3>

    <div class="delivery">
        <form action="http://info.sweettracker.co.kr/tracking/3" method="GET">
            <div class="form-group">
            <input type="hidden" class="form-control" id="t_key" name="t_key" value="L9BSPPCImhVbYsYrWTr6fg">
            </div>
            <div class="form-group">
            <input type="hidden" class="form-control" name="t_code" id="t_code" value="04">
            </div>
            <div class="form-group">
            <label for="t_invoice">운송장 번호</label>
            <input type="text" class="form-control" name="t_invoice" id="t_invoice" value="운송장 번호">
            </div>
            <button type="submit" class="btn btn-default btn-general" onclick="popup();">조회하기</button>
            <div style="clear: both;"></div>
        </form>
    </div>
    
	<script>
	
	</script>
</body>
</html>