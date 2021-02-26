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

@WebServlet("/member/review/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 쿼리스트링으로 넘어온 독후감번호, 페이지 받기
		// 2. DB 작업
		// 3. JSP에 데이터 넘겨주기
		
		String seq=req.getParameter("seq");
		String page=req.getParameter("page");
		
		ReviewDAO dao=new ReviewDAO();
		ReviewDTO dto=new ReviewDTO();
		
		dto=dao.getInfo(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("page", page);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/review/edit.jsp");
		dispatcher.forward(req, resp);
	}

}