package com.test.bookjuck.member.review;

import java.io.IOException;
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

		String page=req.getParameter("page");
		
		req.setAttribute("page", page);
		
		// 독후감 쓸 수 있는 책 가져오기
		// 1. 배송완료이면서 2. 독후감을 아직 안 쓴 책
		// TODO 회원번호 가져오는 부분!!
//		HttpSession session=req.getSession();
//		String seq=session.getAttribute("seq").toString();
		String seq="23"; // TODO 임의로 23번으로 처리
		BookDAO bdao=new BookDAO();
		ArrayList<BookDTO> blist=bdao.getPossibleBook(seq);
		
		req.setAttribute("blist", blist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/review/add.jsp");
		dispatcher.forward(req, resp);
	}

}