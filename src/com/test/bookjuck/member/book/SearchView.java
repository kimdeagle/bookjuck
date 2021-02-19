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


@WebServlet("/member/book/searchview.do")
public class SearchView extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String sv = req.getParameter("sv"); //검색창 입력값
		String sk = req.getParameter("sk");	//검색 카테고리 입력값
		
		
		HashMap<String,String> map = new HashMap<String,String>();
		if (!(sv == null || sv.equals(""))) {
		map.put("sv", sv);
		map.put("sk", sk);
		}
		
		BookDAO dao = new BookDAO();
		ArrayList<BookDTO> list = dao.list(map);
		System.out.println(list);
		
		/* list null 뜸..? 수정필요
		 * for (BookDTO dto : list) {
		 * 
		 * //날짜에서 시간 잘라내기 dto.setPubdate(dto.getPubdate().substring(0,10));
		 * 
		 * //제목, 카피 너무 길면 자르기 if (dto.getTitle().length() > 30) {
		 * dto.setTitle(dto.getTitle().substring(0, 30) + ".."); }
		 * 
		 * if (dto.getCopy().length() > 40) { dto.setCopy(dto.getCopy().substring(0, 40)
		 * + ".."); }
		 * 
		 * }
		 */
		
		
		req.setAttribute("sk", sk);
		req.setAttribute("sv", sv);
		
		req.setAttribute("list", list);//***
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/book/searchview.jsp");
		dispatcher.forward(req, resp);

	}

}
