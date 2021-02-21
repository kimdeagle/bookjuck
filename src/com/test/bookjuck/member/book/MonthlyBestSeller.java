package com.test.bookjuck.member.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/book/MonthlyBestSeller.do")
public class MonthlyBestSeller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		
		BookDAO dao = new BookDAO();
		list = dao.monthlyBestSeller();

		for (BookDTO dto : list) {

			// 날짜에서 시간 잘라내기
			dto.setPubdate(dto.getPubdate().substring(0, 10));

			// 제목, 카피 너무 길면 자르기
			if (dto.getTitle().length() > 30) {
				dto.setTitle(dto.getTitle().substring(0, 30) + "..");
			}

			if (dto.getCopy().length() > 40) {
				dto.setCopy(dto.getCopy().substring(0, 40) + "..");
			}

		}
		
		
		req.setAttribute("list", list);
		System.out.println(list +"mbs");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/book/monthlybestseller.jsp");
		dispatcher.forward(req, resp);

	}

}
