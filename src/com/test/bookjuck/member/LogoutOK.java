package com.test.bookjuck.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logoutok.do")
public class LogoutOK extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		// session.removeAttribute("id"); //로그아웃
		session.invalidate(); // 세션 초기화

		// 2.
		response.sendRedirect("http://localhost:8090/bookjuck/index.do");
	}

}
