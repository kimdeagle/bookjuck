<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.DriverManager" %>   
<%@ page import = "java.sql.Connection" %>   
<%@ page import = "java.sql.PreparedStatement" %>   
<%@ page import = "java.sql.ResultSet" %>   
<%@ page import = "java.sql.SQLException" %>
 
<%

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
<style>
</style>

</head>
<body>
  <h4>도서 리스트</h4>
  <table width="100%" border="1">
  <tr>
  	<th>도서명</th>
  	<th>가격</th>
  	<th>작가번호</th>
  	<th>출판사명</th>
  	<th>발행일</th>
  	<th>줄거리</th>
  </tr>
  
  
  <%
  
  request.setCharacterEncoding("utf-8");
  Connection conn = null;
  PreparedStatement pstat = null;
  ResultSet rs = null;
  
  //드라이버 로딩
  Class.forName("oracle.jdbc.driver.OracleDriver");
  String sk = request.getParameter("sk");
  String sv = request.getParameter("sv");
  System.out.println(sk + "<-- sk searchlist.jsp");
  System.out.println(sv + "<-- sv searchlist.jsp");
  
  try{
	  String url = "jdbc:oracle:thin:@localhost:1521:xe";
	  String id = "zeratull1004";
	  String pw = "java1234";
	  conn = DriverManager.getConnection(url, id, pw);
	  if(sk == null & sv == null){
		  out.println("01 sk null, sv null인 조건");
		  pstat = conn.prepareStatement("select title, salePrice, seqAuthor, publisher, pubDate, summary from tblBook");
	  }else if (sk != null & sv.equals("")){
		  out.println("02 sk 값o, sv null인 조건");
		  pstat = conn.prepareStatement("select title, salePrice, seqAuthor, publisher, pubDate, summary from tblBook");
		  pstat.setString(1, sv);
	  }else if (sk != null & sv != null){
		  out.println("03 sk, sv 둘다 값 있음");
		  pstat = conn.prepareStatement("select * from tblbook where "+sk+"=?");
		  pstat.setString(1, sv);
	  }
	  
	  rs = pstat.executeQuery();
	  
	  while(rs.next()){	  
	%>
		<tr>
			<td><%=rs.getString("title") %></td>
			<td><%=rs.getInt("salePrice") %></td>
			<td><%=rs.getInt("seqAuthor") %></td>
			<td><%=rs.getString("publisher") %></td>
			<td><%=rs.getString("pubDate") %></td>
			<td><%=rs.getString("summary") %></td>
		</tr>	
	<%
		  
	  }
	  
  }catch(Exception e){
	  
	  System.out.println(e);
  } finally {
	  //6 사용한 Statement 종료
	  if (rs != null) try {rs.close();} catch (Exception e){}
	  if (pstat != null) try{pstat.close();} catch(SQLException ex){}
	  
	  //7. 커넥션 종료
	  if (conn != null) try { conn.close();} catch(Exception e){}
  } 
	%>
  </table>
</body>
</html>