package com.test.bookjuck.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



	@WebServlet("/member/register_s.do")
	public class register_s extends HttpServlet{

		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/register_s.jsp");
			dispatcher.forward(request, response);
			
		}

		
	}
