package com.test.bookjuck.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8090/bookjuck/admin/login.do

@WebServlet("/admin/login.do")
public class Login extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/login.jsp");
		dispatcher.forward(request, response);
		
	}

}