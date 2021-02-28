package com.test.bookjuck.member.review;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.BookDAO;
import com.test.bookjuck.dao.ReviewDAO;
import com.test.bookjuck.dto.BookDTO;
import com.test.bookjuck.dto.ReviewDTO;

@WebServlet("/member/review/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 1차적으로 로그인 접속이 맞는지 확인
		HttpSession session=req.getSession();
		
		if (session.getAttribute("id")==null) {
			
			// 접근 권한 없음
			PrintWriter writer=resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('access denied');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
		}
		
		String page=req.getParameter("page");
		
		req.setAttribute("page", page);
		
		// 독후감 쓸 수 있는 책 가져오기
		// 1. 배송완료이면서 2. 독후감을 아직 안 쓴 책

		// 현재 로그인한 고객의 번호로 독후감 쓸 수 있는 책들을 가져온다.
		String seq=session.getAttribute("seq").toString();
		BookDAO bdao=new BookDAO();
		ArrayList<BookDTO> blist=bdao.getPossibleBook(seq);
		
		req.setAttribute("blist", blist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/review/add.jsp");
		dispatcher.forward(req, resp);
	}

}