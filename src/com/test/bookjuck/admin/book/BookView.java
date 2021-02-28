package com.test.bookjuck.admin.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.BookDAO;
import com.test.bookjuck.dto.BookDTO;


@WebServlet("/admin/book/bookview.do")
public class BookView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(seqSCategory)
		//2. DB 작업 -> select
		//3. 결과 + JSP 호출
		
		//1.
		String seq = req.getParameter("seq");
		String page = req.getParameter("page");
		String seqLCategory = req.getParameter("seqLCategory");
		
		//2.
		BookDAO dao = new BookDAO();
		BookDTO dto = dao.getAdminBookDetail(seq);
		
		
		//날짜 데이터 자르기 -> 시간 삭제
		dto.setPubDate(dto.getPubDate().substring(0, 10));
		
		dao.close();
		
		req.setAttribute("dto", dto);
		req.setAttribute("page", page);
		req.setAttribute("seqLCategory", seqLCategory);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/book/bookview.jsp");
		dispatcher.forward(req, resp);
	}
	
}
