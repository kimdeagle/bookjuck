package com.test.bookjuck.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;

@WebServlet("/member/findssnpw.do")
public class FindSsnPw extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String name = "";
		String id = "";
		String ssn ="";
		String result = "";
		
		name = req.getParameter("name");
		id = req.getParameter("id");
		ssn = req.getParameter("ssn1")+"-"+req.getParameter("ssn2");
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(ssn);
		
		MemberDAO dao = new MemberDAO();
		
		result =  dao.findPwSsn(ssn, name, id);	
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(result);
		
		writer.close();
		
	}
}
