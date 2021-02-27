package com.test.bookjuck.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;

@WebServlet("/member/findemailpw.do")
public class FindEmailPw extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String name = "";
		String id = "";
		String email ="";
		String result = "";
		
		name = req.getParameter("name");
		id = req.getParameter("id");
		email = req.getParameter("email1")+"@"+req.getParameter("email2");
		
		MemberDAO dao = new MemberDAO();
		
		result =  dao.findPwEmail(email, name, id);
			
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(result);
		
		writer.close();
		
	}
}
