package com.test.bookjuck.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/logout.do")
public class Logout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 로그아웃 > 인증 티켓 제거
		//2. 시작 페이지로 이동
		
		//1.
		HttpSession session = req.getSession();
		session.invalidate(); //세션 초기화
		
		//2.
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		writer.print("<html><head><meta charset='UTF-8' /></head><body>");
		writer.print("<script>");
		writer.print("alert('로그아웃 되었습니다.');");
		writer.print("location.href='/bookjuck/admin/login.do';");
		writer.print("</script>");
		writer.print("</body></html>");
		
		writer.close();
		
	}

}