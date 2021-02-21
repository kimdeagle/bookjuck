package com.test.bookjuck.member.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/book/newbook.do")
public class NewBook extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String yearStart = req.getParameter("yearStart");
		String monthStart = req.getParameter("monthStart");
		String dayStart = req.getParameter("dayStart");
		
		
		String yearEnd = req.getParameter("yearEnd");
		String monthEnd = req.getParameter("monthEnd");
		String dayEnd = req.getParameter("dayEnd");
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("yearStart", yearStart);
		map.put("monthStart", monthStart);
		map.put("dayStart", dayStart);
		map.put("yearEnd", yearEnd);
		map.put("monthEnd", monthEnd);
		map.put("dayEnd", dayEnd);
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		if (!(yearStart == null || yearStart.equals("")) 
				&& !(monthStart == null || monthStart.equals(""))
				&& !(dayStart == null || dayStart.equals(""))
				&& !(yearEnd == null || yearEnd.equals(""))
				&& !(monthEnd == null || monthEnd.equals(""))
				&& !(dayEnd == null || dayEnd.equals("")))  
		{
			
		BookDAO dao = new BookDAO();
		list = dao.newBook(map);
				
		
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
		 
		
		req.setAttribute("yearStart", yearStart);
		req.setAttribute("monthStart", monthStart);
		req.setAttribute("dayStart", dayStart);
		req.setAttribute("yearEnd", yearEnd);
		req.setAttribute("monthEnd", monthEnd);
		req.setAttribute("dayEnd", dayEnd);
		
				
		}
		
		req.setAttribute("list", list);
		
	
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/book/newbook.jsp");
		dispatcher.forward(req, resp);

	}

}