package com.test.bookjuck.member.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.EBookDAO;
import com.test.bookjuck.dto.CategoryDTO;
import com.test.bookjuck.dto.EBookDTO;

@WebServlet("/member/book/ebooklist.do")
public class EbookList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 데이터 가져오기
		//1. DB 작업 -> select
		//2. 결과 + JSP 호출
		
		//0.
		String seqLCategory = request.getParameter("seqLCategory");
		String seqMCategory = request.getParameter("seqMCategory");
		String seqSCategory = request.getParameter("seqSCategory");
		
		String lCategory = request.getParameter("lCategory");
		String mCategory = request.getParameter("mCategory");
		String sCategory = request.getParameter("sCategory");
		
		//1.
		EBookDAO dao = new EBookDAO();
		CategoryDTO cdto = new CategoryDTO();
		
		cdto.setSeqLCategory(seqLCategory);
		cdto.setSeqMCategory(seqMCategory);
		cdto.setSeqSCategory(seqSCategory);
		
		ArrayList<EBookDTO> eblist = dao.getEBookList(cdto);
		
		
		//2.
		request.setAttribute("eblist", eblist);
		
		request.setAttribute("seqLCategory", seqLCategory);
		request.setAttribute("seqMCategory", seqMCategory);
		request.setAttribute("seqSCategory", seqSCategory);
		
		request.setAttribute("lCategory", lCategory);
		request.setAttribute("mCategory", mCategory);
		request.setAttribute("sCategory", sCategory);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/book/ebooklist.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
