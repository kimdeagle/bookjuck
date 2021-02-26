package com.test.bookjuck.member.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.ReviewDAO;
import com.test.bookjuck.dto.ReviewDTO;

@WebServlet("/member/review/detail.do")
public class Detail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. JSP에서 보낸 데이터 받아오고
		// 2. DB 작업으로 상세보기할 독후감 정보 가져오기
		
		String seq=req.getParameter("seq");
		String page=req.getParameter("page");
		
		ReviewDAO dao=new ReviewDAO();
		ReviewDTO dto=dao.getInfo(seq);
		
		req.setAttribute("page", page);
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/review/detail.jsp");
			dispatcher.forward(req, resp);
}

}