package com.test.bookjuck.member.book;

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
import com.test.bookjuck.dto.CategoryDTO;


@WebServlet("/member/book/booklist.do")
public class BookList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 데이터 가져오기
		//2. DB 작업 -> select
		//3. 결과 + JSP 호출
		
		//1.
		String seqLCategory = request.getParameter("seqLCategory");
		String seqMCategory = request.getParameter("seqMCategory");
		
		String seqSCategory = request.getParameter("seqSCategory");
		
		String lCategory = request.getParameter("lCategory");
		String mCategory = request.getParameter("mCategory");

		String sCategory = request.getParameter("sCategory");
		
		
		//2.
		BookDAO dao = new BookDAO();
		CategoryDTO cdto = new CategoryDTO();
		cdto.setSeqMCategory(seqMCategory);
		cdto.setSeqSCategory(seqSCategory);
				
		ArrayList<BookDTO> blist = dao.getBookList(cdto);
		
		//3.
		request.setAttribute("seqLCategory", seqLCategory);
		request.setAttribute("seqMCategory", seqMCategory);
		
		request.setAttribute("seqSCategory", seqSCategory);
		
		request.setAttribute("lCategory", lCategory);
		request.setAttribute("mCategory", mCategory);
		
		request.setAttribute("sCategory", sCategory);
		
		request.setAttribute("blist", blist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/book/booklist.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
