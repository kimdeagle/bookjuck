<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>
<script src="/bookjuck/js/highcharts.js"></script>
<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/statistics.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">

<style>

	#

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	
	<form id="searchform" method="GET" action="/bookjuck/admin/statistics/statistics.do">
					<div id="choicedate">
						<!-- 기간 선택 -->
						<input type="text" name="yearStart" id="yearStart" style="width: 50px;" placeholder="YYYY" class="datebtn" value="${yearStart}">
						<input type="text" name="monthStart" id="monthStart" style="width: 50px;" placeholder="MM" class="datebtn" value="${monthStart}">
						<input type="text" name="dayStart" id="dayStart" style="width: 50px;" placeholder="DD" class="datebtn" value="${dayStart}"> 
						~ 
						<input type="text" name="yearEnd" id="yearEnd" style="width: 50px;" placeholder="YYYY" class="datebtn" value="${yearEnd}">
						<input type="text" name="monthEnd" id="monthEnd" style="width: 50px;" placeholder="MM" class="datebtn" value="${monthEnd}"> 
						<input type="text" name="dayEnd" id="dayEnd" style="width: 50px;" placeholder="DD" class="datebtn" value="${dayEnd}">
						<input type="submit" value="기간검색" class="dateselect">
					</div>
				</form>
				<br>
				<c:if test="${not empty yearStart}"> 
				<div>
    			'${yearStart}-${monthStart}-${dayStart} ~ ${yearEnd}-${monthEnd}-${dayEnd}' 기간의 매출조회 결과입니다.
    			</div>
    			</c:if>
    			<c:if test="${empty yearStart}"> 
    			전체기간 매출조회 결과입니다.
    			</c:if>
    			<br>
    			<table class="table table-bordered" style="width:500px;">
						<tr style="background-color:#5B8E7D;" >
							<th style="text-align: center; color:white;">구분</th>
							<th style="text-align: center; color:white;">종이책</th>
							<th style="text-align: center; color:white;">E-BOOK</th>
							<th style="text-align: center; color:white;">바로드림</th>
							<th style="text-align: center; color:white;">TOTAL</th>
						</tr>
    					<tr>
    						<td>매출액</td>
							<td id="bookcn"></td>
							<td id="ebookcn"></td>
							<td id="barobookcn"></td>
							<td id="booktotal" style="font-weight:bold;"></td>
						</tr>
						<tr>
    						<td>매출비중</td>
							<td id="mgbookcn"></td>
							<td id="mgebookcn"></td>
							<td id="mgbarobookcn"></td>
							<td style="font-weight:bold;">100%</td>
						</tr>
    			</table>
    			 			
	
				<hr>
					
				<div id="chart1" style="width: 400px; height: 400px; margin: 0 auto; position:relative; left:-250px; top:100px;"></div>
				<div id="chart2" style="width: 400px; height: 400px; margin: 0 auto; position:relative; left:200px; top:-400px;"></div>
				<div id="chart3" style="width: 400px; height: 400px; margin: 0 auto; position:relative; left:200px; top:-400px;"></div>
				
				<hr>
				

				
	
	
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>
	

<script>
	
	let n1 = <c:forEach items="${list1}" var="dto">${dto.sales}</c:forEach> //list1 배열 매출 꺼내기
	let cn1 = n1.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ","); //숫자 3자리마다 콤마붙이기
	document.getElementById('bookcn').innerHTML=cn1; //해당 태그에 cn1 삽입
	
	let n2 = <c:forEach items="${list2}" var="dto">${dto.sales}</c:forEach>
	let cn2 = n2.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	document.getElementById('ebookcn').innerHTML=cn2;
	
	let n3 = <c:forEach items="${list3}" var="dto">${dto.sales}</c:forEach>
	let cn3 = n3.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	document.getElementById('barobookcn').innerHTML=cn3;
	
	let totaln = parseInt(n1) + parseInt(n2) + parseInt(n3);
	let totalcn = totaln.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	document.getElementById('booktotal').innerHTML=totalcn;
	
	
	document.getElementById('mgbookcn').innerHTML=Math.round((parseInt(n1)/totaln)*100)+"%"
	document.getElementById('mgebookcn').innerHTML=Math.round((parseInt(n2)/totaln)*100)+"%"
	document.getElementById('mgbarobookcn').innerHTML=Math.round((parseInt(n3)/totaln)*100)+"%"
	

	
		

	//세로막대차트
	Highcharts.chart('chart1',{
	   chart: {
	      type: 'column'
	   },
	   title: {
	      text: '[매출 Data]'   
	   },
	   subtitle: {
	      
	   },
	   xAxis: {
	      categories: ['BOOK','E-BOOK','BARO-BOOK','TOTAL'],
	      crosshair: true
	   },
	   yAxis: {
	      min: 0,
	      title: {
	         text: '매출 (원)'         
	      }      
	   },
	   tooltip: {
	      headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	      pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	         '<td style="padding:0"><b>{point.y:1f} 원</b></td></tr>',
	      footerFormat: '</table>',
	      shared: true,
	      useHTML: true
	   },
	   plotOptions: {
	      column: {
	         pointPadding: 0.2,
	         borderWidth: 0
	      }
	   },  
	   series: [
		   {
	        name: '종이책',
	        data: [
	            	<c:forEach items="${list1}" var="dto">
	            	${dto.sales}
	            	</c:forEach>,	            		            	
	              ]
	        	   
	        },
		   
		   {
		        name: 'E-BOOK',
		        data: [
		            	<c:forEach items="${list2}" var="dto">
		            	${dto.sales}
		            	</c:forEach>	            		            	
		              ]
		        	   
		        },
		   {
		        name: '바로드림',
		        data: [
		            	<c:forEach items="${list3}" var="dto">
		            	${dto.sales}
		            	</c:forEach>	            		            	
		              ]
		        	   
		        },
		   {
		        name: '매출총액',
		        data: [
		               totaln		            	
		              ]
		        	   
		        }
		   
		   
		   
		   ]     
	    	
	});
	
	
	
	//파이 차트
	Highcharts.chart('chart2', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: '[연령대별 주문건수]'
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.y:.0f}건</b>'
	    },
	    accessibility: {
	        point: {
	            valueSuffix: '%'
	        }
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {y:.0f}건'
	            }
	        }
	    },
	    series: [{
	        name: '연령대',
	        colorByPoint: true,
	        data: [
	        	
	        <c:forEach items="${list4}" var="dto">	
	        {
	            name: '${dto.age}대',
	            y: ${dto.agecnt}    
	        }
	        	        
	        ,
	        
	        </c:forEach>	        
	        
	        ]
	    }]
	});
	
	
	
	  Highcharts.chart('chart3', {
		  colors: ['yellow','orange'],
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: '[고객 성별 비중]'
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.y:.0f}건</b>'
	    },
	    accessibility: {
	        point: {
	            valueSuffix: '%'
	        }
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {y:.0f}명'
	            }
	        }
	    },
	    series: [{
	        name: '성별',
	        colorByPoint: true,
	        data: [
	        	
	        <c:forEach items="${list5}" var="dto">	
	        {
	            name: '${dto.gender}',
	            y: ${dto.gendercnt}    
	        }
	        	        
	        ,
	        
	        </c:forEach>	        
	        
	        ]
	    }]
	});  

</script>

</body>

</html>