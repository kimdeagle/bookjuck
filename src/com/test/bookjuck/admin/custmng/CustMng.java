package com.test.bookjuck.admin.custmng;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8090/bookjuck/admin/custmng/custmng.do
@WebServlet("/admin/custmng/custmng.do")
public class CustMng extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/custmng/custmng.jsp");
		dispatcher.forward(request, response);
		
	}

}
