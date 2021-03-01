package com.test.bookjuck.member.refund;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/refund/cancelapplication.do")
public class CancelApplication extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		//로그인 안한 사람이 접근할 때 내 쫓기
		HttpSession session = req.getSession();
		
		if (session.getAttribute("id") == null) {

			
			//경고(JavaScript) 후 내쫓기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("location.href='/bookjuck/index.do';");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			
		}
		*/
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/refund/cancelapplication.jsp");
		dispatcher.forward(req, resp);

	}

}
