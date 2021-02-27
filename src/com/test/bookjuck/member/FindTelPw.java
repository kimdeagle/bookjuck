package com.test.bookjuck.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;

@WebServlet("/member/findtelpw.do")
public class FindTelPw extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String name = "";
		String id = "";
		int tel =0;
		String result = "";
		
		name = req.getParameter("name");
		id = req.getParameter("id");
		tel = Integer.parseInt(req.getParameter("tel1")+req.getParameter("tel2")+req.getParameter("tel3"));
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(tel);
		
		
		MemberDAO dao = new MemberDAO();
		
		result =  dao.findPwTel(tel, name, id);
			
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(result);
		
		writer.close();
		
	}
}
