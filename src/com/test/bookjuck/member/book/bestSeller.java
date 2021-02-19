package com.test.bookjuck.member.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//http://localhost:8090/bookjuck/member/book/bestseller.do
@WebServlet("/member/book/bestseller.do")
public class bestSeller extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		//String aaa = request.getParameter("aaa");
		
		//dao.list(aaa);  //where 
	
	
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/book/bestseller.jsp");
		dispatcher.forward(request, response);
		
	}
	
	

}
