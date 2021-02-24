package com.test.bookjuck.admin.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.BookDAO;
import com.test.bookjuck.dto.BookDTO;


@WebServlet("/admin/book/booklist.do")
public class BookList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기
		//2. DB 작업 -> select
		//3. 결과 + JSP 호출
		
		//1.
		String seqLCategory = req.getParameter("seqLCategory");
		
		//2.
		BookDAO dao = new BookDAO();
		
		ArrayList<BookDTO> list = dao.getAdminBookList(seqLCategory);
		
		int wholeCnt = dao.getWholeBookCount();
		int inCnt = dao.getInternalBookCount();
		int exCnt = dao.getExternalBookCount();
		
		dao.close();
		
		//3.
		req.setAttribute("list", list);
		req.setAttribute("wholeCnt", wholeCnt);
		req.setAttribute("inCnt", inCnt);
		req.setAttribute("exCnt", exCnt);
		req.setAttribute("seqLCategory", seqLCategory);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/book/booklist.jsp");
		dispatcher.forward(req, resp);
	}
	
}
