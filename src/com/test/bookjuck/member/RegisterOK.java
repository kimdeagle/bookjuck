package com.test.bookjuck.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/mypage/registerOk.do")
public class RegisterOK extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/path.jsp");
		dispatcher.forward(req, resp);

	}
}
