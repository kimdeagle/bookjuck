package com.test.bookjuck.member;

import java.io.IOException;
import java.io.PrintWriter;
//  page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8 ;
//  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core ;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.admin.curationletter.MyAuthentication ;
@WebServlet("/member/mailauth.do")
public class MailAuth extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		
		// 1. 인코딩! (POST에 한글이므로.)
		request.setCharacterEncoding("UTF-8");	
		
		// 2. 데이터 받기
		String content = request.getParameter("name") + "님의 인증 번호는 " + request.getParameter("rnd") + " 입니다.";
		String name = request.getParameter("name");
		String email = request.getParameter("email1")+"@"+request.getParameter("email2");
		String title = "북적북적 이메일 인증번호";
		
		// SMTP 서버 주소
		String smtpHost = "smtp.gmail.com";

		
		//보내는 사람의 정보
		String fromName = "북적북적";
		String fromEmail = "bookjuckbookjuck@gmail.com";
		
		
		//받는 사람의 정보
		// 원래는 고객정보(mList)로 동작시켜야하지만 더미데이터뿐이므로.
		String toName = name;
		String toEmail = email;
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(content);
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
			Authenticator myauth = new MyAuthentication(); 
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
			
			PrintWriter writer = respons.getWriter();
			
			/*이메일 전송 (성공 =1) (실패=0)*/
			int result = 1;
			
			writer.print(result);
			
			writer.close();
			
		} catch (Exception e) {
			 
			e.printStackTrace();
	
			/* <script>alert("인증번호가 전송되지 않았습니다. 다시 시도해주세요.");</script> */
		 	
			return;
		 	
		}
			
	}

}