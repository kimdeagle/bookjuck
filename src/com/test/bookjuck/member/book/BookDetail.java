package com.test.bookjuck.member.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.BookDAO;
import com.test.bookjuck.dto.BookDTO;

@WebServlet("/member/book/bookdetail.do")
public class BookDetail extends HttpServlet {

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
		String seq = request.getParameter("seq");
		
		//2.
		BookDAO dao = new BookDAO();
		BookDTO dto = dao.getBookDetail(seq);
		
		dao.close();
		
		sCategory = dto.getsCategory();
		
		dto.setSummary(dto.getSummary().replace("\r\n", "<br>"));
		dto.setSummary(dto.getSummary().replace("\n", "<br>"));
		
		dto.setContents(dto.getContents().replace("\r\n", "<br>"));
		dto.setContents(dto.getContents().replace("\n", "<br>"));
		
		request.setAttribute("seqLCategory", seqLCategory);
		request.setAttribute("seqMCategory", seqMCategory);
		request.setAttribute("seqSCategory", seqSCategory);
		request.setAttribute("lCategory", lCategory);
		request.setAttribute("mCategory", mCategory);
		request.setAttribute("sCategory", sCategory);
		
		request.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/book/bookdetail.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
