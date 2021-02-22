package com.test.bookjuck.member.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8090/bookjuck/member/mypage/custinfo.do

@WebServlet("/member/mypage/custinfo.do")
public class CustInfo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/mypage/custinfo.jsp");
		dispatcher.forward(request, response);

	}

}
