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


//http://localhost:8090/bookjuck/member/book/bestseller.do
@WebServlet("/member/book/bestseller.do")
public class bestSeller extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		//String aaa = request.getParameter("aaa");
		//dao.list(aaa);  //where 
	
		String yearStart = request.getParameter("yearStart");
		String monthStart = request.getParameter("monthStart");
		String dayStart = request.getParameter("dayStart");
		
		
		String yearEnd = request.getParameter("yearEnd");
		String monthEnd = request.getParameter("monthEnd");
		String dayEnd = request.getParameter("dayEnd");
		
		
		//System.out.println(yearStart + monthStart + dayStart);
		
		//System.out.println(yearEnd + monthEnd + dayEnd);
		
		HashMap<String,String> map = new HashMap<String,String>();
		/*
		if (!(yearStart == null || yearStart.equals("")) 
			&& (monthStart == null || monthStart.equals(""))
			&& (dayStart == null || dayStart.equals(""))
			&& (yearEnd == null || yearEnd.equals(""))
			&& (monthEnd == null || monthEnd.equals(""))
			&& (dayEnd == null || dayEnd.equals("")))  
		{
		
		}
		*/
			map.put("yearStart", yearStart);
			map.put("monthStart", monthStart);
			map.put("dayStart", dayStart);
			map.put("yearEnd", yearEnd);
			map.put("monthEnd", monthEnd);
			map.put("dayEnd", dayEnd);
								
		
		
		System.out.println(map.get("yearStart"));
		System.out.println(map.get("yearEnd"));
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		if (!(yearStart == null || yearStart.equals("")) 
				&& !(monthStart == null || monthStart.equals(""))
				&& !(dayStart == null || dayStart.equals(""))
				&& !(yearEnd == null || yearEnd.equals(""))
				&& !(monthEnd == null || monthEnd.equals(""))
				&& !(dayEnd == null || dayEnd.equals("")))  
		{
			
		BookDAO dao = new BookDAO();
		list = dao.bestSeller(map);
				
		
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
		 
		
		request.setAttribute("yearStart", yearStart);
		request.setAttribute("monthStart", monthStart);
		request.setAttribute("dayStart", dayStart);
		request.setAttribute("yearEnd", yearEnd);
		request.setAttribute("monthEnd", monthEnd);
		request.setAttribute("dayEnd", dayEnd);
		
				
		}
		
		request.setAttribute("list", list);
	
	
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/book/bestseller.jsp");
		dispatcher.forward(request, response);
		
	}
	
	

}
