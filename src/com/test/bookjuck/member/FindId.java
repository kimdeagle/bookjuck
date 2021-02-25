package com.test.bookjuck.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;

@WebServlet("/member/findid.do")
public class FindId extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		/*
		 * String ssn1 = req.getParameter("ssn1"); String ssn2 =
		 */
		
		/*
		 * String tel1 = req.getParameter("tel1"); String tel2 =
		 * req.getParameter("tel2"); String tel3 = req.getParameter("tel3");
		 */
		int tel=0;
		
		String name = req.getParameter("name");
		String ssn = req.getParameter("ssn1")+"-"+req.getParameter("ssn2");
		tel =  Integer.parseInt(req.getParameter("tel1") + req.getParameter("tel2") + req.getParameter("tel3"));
		String email = req.getParameter("email1") + req.getParameter("email2");
		
		System.out.println(name);
		System.out.println(ssn);
		System.out.println(tel);
		System.out.println(email);
		
		
		MemberDAO dao = new MemberDAO();
		
		
		if(tel==0 || email.equals("")) {
			
			String ssnRes =  dao.findIdSsn(ssn, name);
			
			System.out.println(ssnRes);
			
		}
	}
}
