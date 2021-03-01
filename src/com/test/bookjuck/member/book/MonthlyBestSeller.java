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



@WebServlet("/member/book/MonthlyBestSeller.do")
public class MonthlyBestSeller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		
		BookDAO dao = new BookDAO();
		list = dao.mBestSeller();
	
		for (BookDTO dto : list) {

		

			// 제목, 카피 너무 길면 자르기
			if (dto.getTitle().length() > 15) {
				dto.setTitle(dto.getTitle().substring(0, 15) + "..");
			}

			if (dto.getCopy().length() > 20) {
				dto.setCopy(dto.getCopy().substring(0, 20) + "..");
			}

		}
		
		
		req.setAttribute("list", list);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/book/monthlybestseller.jsp");
		dispatcher.include(req, resp);

	}

}
