package com.test.bookjuck.member.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8090/bookjuck/member/mypage/basic.do

@WebServlet("/member/mypage/orderlistnonmem.do")
public class OrderListNonMem extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/mypage/orderlistnonmem.jsp");
		dispatcher.forward(request, response);
		
	}
}
