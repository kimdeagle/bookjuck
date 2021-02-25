<%@page import="com.test.bookjuck.dao.LetterDAO"%>
<%@page import="com.test.bookjuck.dto.LetterDTO"%>
<%@page import="com.test.bookjuck.dao.LetterLogDAO"%>
<%@page import="com.test.bookjuck.dto.LetterLogDTO"%>
<%@page import="com.test.bookjuck.dao.MemberDAO"%>
<%@page import="com.test.bookjuck.dto.MemberDTO"%>
<%@page import="com.test.bookjuck.admin.curationletter.MyAuthentication"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.activation.*"%>
<%@ page import="javax.mail.*"%>
<%@ page import="javax.mail.internet.*"%>

<%

	// 1. 인코딩! (POST에 한글이므로.)
	request.setCharacterEncoding("UTF-8");

	// 2. 데이터 받기
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	String cseq=request.getParameter("seq");
	String email=request.getParameter("email");

	// 3. 큐레이션 레터를 구독하는 회원정보 가져오기
	MemberDAO dao=new MemberDAO();
	ArrayList<MemberDTO> mlist=dao.getList();


	// SMTP 서버 주소
	String smtpHost = "smtp.gmail.com";

	
	//보내는 사람의 정보
	String fromName = "북적북적";
	String fromEmail = "bookjuckbookjuck@gmail.com";
	
	
	//받는 사람의 정보
	// 원래는 고객정보(mList)로 동작시켜야하지만 더미데이터뿐이므로.
	String toName = "조아라";
	String toEmail = "joara9566@naver.com";

	
	// ===============================================================
			
			
	try {
		
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", smtpHost);
 		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.debug", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.socketFactory.fallback", "false");
	
	
		// 메일 인증
		Authenticator myauth=new MyAuthentication(); 
		Session sess=Session.getInstance(prop, myauth);
		
		
		InternetAddress addr = new InternetAddress();
		addr.setPersonal(fromName,"UTF-8");
		addr.setAddress(fromEmail);
		
		
		Message msg = new MimeMessage(sess);
		msg.setFrom(addr);         
		msg.setSubject(MimeUtility.encodeText(title, "utf-8","B"));
		
		Calendar now=Calendar.getInstance();
		
		String totalContent="<html>";
		/* totalContent+="<style>"; */
		/* totalContent+="body { font-family: 'NEXON Lv2 Gothic'; color:#555; line-height:1.5em; font-size:15px;"; */
		/* totalContent+="#qbox { width:700px; background-color:rgba(91, 142, 125, .2); margin-bottom:50px; margin-left:auto; margin-right:auto; padding:50px;}"; */
		/* totalContent+="#qbox > h5 { border-bottom:1px dashed #ccc;}"; */
		/* totalContent+="</style>"; */
		totalContent+="<body style='font-family: 'NEXON Lv2 Gothic'; line-height:1.5em; font-size:15px; color:black;'>";
		totalContent+="<div style='background-color:rgba(91, 142, 125, .2); padding:15px;'>";
        totalContent+="<h1 style='border-bottom:1px dashed #ccc;'>"+title+"</h1>";
        totalContent+="<h4 style='font-size:15px; margin-bottom:20px; color:black;'>"+now.get(Calendar.YEAR)+"년 "+(now.get(Calendar.MONTH)+1)+"월 "+now.get(Calendar.DATE)+"일"+"</h4>";
        totalContent+="<h3 style='color:black;'>"+content+"</h3>";
        totalContent+="</div>";
		totalContent+="</body></html>";
		
		
		msg.setContent(totalContent, "text/html;charset=utf-8");
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
		
		
		Transport.send(msg);

		// 전송이 성공하면
		// 1. 레터를 저장하고
		// 2. 레터전송내역을 저장한다.
		
		LetterDTO dto=new LetterDTO();
		LetterDAO ndao=new LetterDAO();
		
		dto.setTitle(title);
		dto.setContent(content);
		
		// 1. 레터 저장
		int result=ndao.add(dto);
		
		if (result==1) {
			
			// 방금 보낸 레터번호 가져오기
			String lseq=ndao.getLastSeq();
			
			// 3. 레터전송내역 저장
			LetterLogDTO ndto=new LetterLogDTO();
			LetterLogDAO ldao=new LetterLogDAO();
			
			ndto.setSeqLetter(lseq);
			ndto.setSeqMember("5"); // 고객번호 임의로 5번 넣어놓음
				
			result=ldao.add(ndto);
			
			if (result==1) {
				// 전송 및 내용 저장 성공
%>

				<script>alert("큐레이션 레터가 전송되었습니다.");</script>

<%
			} else {
				new Exception();
			}
			
		} else {
			
			new Exception();
		
		}
			
	} catch (Exception e) {
	 
		e.printStackTrace();
%>
	 	<script>alert("큐레이션 레터가 전송되지 않았습니다. 다시 시도해주세요.");</script>
<%	 	
		return;
	 	
	}

	response.sendRedirect("/bookjuck/admin/curationletter/list.do");
	
%>