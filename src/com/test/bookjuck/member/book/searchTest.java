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




//http://localhost:8090/bookjuck/member/book/searchTest.do
@WebServlet("/member/book/searchTest.do")
public class searchTest extends HttpServlet {
		
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, String> map = new HashMap<String,String>();
		
		String sk = request.getParameter("sk");	//검색카테고리 입력값
		String sv = request.getParameter("sv"); //검색창입력값
		
		System.out.println(sk);
		System.out.println(sv);
		System.out.println(map);
		
		//검색 카테고리에 선택되어도, 검색창 입력값이 없으면 반환값이 없도록 함
		if (!(sv == null || sv.equals(""))) {
			map.put("sv", sv);
			map.put("sk", sk);
		}
		
			
		BookDAO dao = new BookDAO();
		
		ArrayList<BookDTO> list = dao.list(map);
		/*
		for (BookDTO dto : list) {
			
			//날짜에서 시간 잘라내기
			dto.setPubdate(dto.getPubdate().substring(0,10));
			
			//제목, 카피 너무 길면 자르기
			if (dto.getTitle().length() > 20) {
				dto.setTitle(dto.getTitle().substring(0, 20) + "..");
			}
			
		
			if (dto.getCopy().length() > 10) {
				dto.setCopy(dto.getCopy().substring(0, 5) + "..");
			}
			
		}
		*/
		request.setAttribute("list", list);
		request.setAttribute("sk", sk);
		request.setAttribute("sv", sv);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/book/searchtest.jsp");
		dispatcher.forward(request, response);
		
	}
	
	

}
