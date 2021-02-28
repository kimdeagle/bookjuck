package com.test.bookjuck.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;

@WebServlet("/member/findssnid.do")
public class FindSsnId extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
	
		
		
		String name = "";
		String ssn ="";
		String result = "";
		
		
		name = req.getParameter("name");
		ssn = req.getParameter("ssn1")+"-"+req.getParameter("ssn2");
		
		

		MemberDAO dao = new MemberDAO();
		
	
			
		result =  dao.findIdSsn(ssn, name);
			
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(result);
		
		writer.close();
		
	}
}
