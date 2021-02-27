package com.test.bookjuck.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;

@WebServlet("/member/findemailid.do")
public class FindEmailId extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
	
		
		
		String name = "";
		String email ="";
		String result = "";
		
		
		name = req.getParameter("name");
		email = req.getParameter("email1")+"@"+req.getParameter("email2");
		
		System.out.println(name);
		System.out.println(email);
		MemberDAO dao = new MemberDAO();
		

		result =  dao.findIdEmail(email, name);
			
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(result);
		
		writer.close();
		
	}
}
