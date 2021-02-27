package com.test.bookjuck.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;

@WebServlet("/member/findtelid.do")
public class FindTelId extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
	
		
		int tel=0;
		String name = "";
		String result = "";
		
		
		name = req.getParameter("name");
		tel = Integer.parseInt(req.getParameter("tel1")+req.getParameter("tel2")+req.getParameter("tel3"));
		

		MemberDAO dao = new MemberDAO();
		
		
	
		result =  dao.findIdTel(tel, name);
			
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(result);
		
		writer.close();
		
	}
}
