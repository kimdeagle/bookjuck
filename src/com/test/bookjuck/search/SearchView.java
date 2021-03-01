package com.test.bookjuck.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.BookDAO;
import com.test.bookjuck.dao.RealTimeSearchDAO;
import com.test.bookjuck.dto.BookDTO;
import com.test.bookjuck.dto.RealTimeSearchDTO;


@WebServlet("/common/searchview.do")
public class SearchView extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	

		
		String sv = req.getParameter("sv"); //검색창 입력값
		String sk = req.getParameter("sk");	//검색 카테고리 입력값
		
		System.out.println(sv);
		RealTimeSearchDAO dao2 = new RealTimeSearchDAO(); //실시간 검색어 
		RealTimeSearchDTO dto2 = new RealTimeSearchDTO();
		
		dto2.setSearchword(sv);
		int result = dao2.insertWord(dto2);//검색어 DB삽입
		
		if(result ==1) {
			System.out.println("DB삽입완료");
		} else {
			System.out.println("DB삽입실패");
		}
		
		
		
		HashMap<String,String> map = new HashMap<String,String>();
		if (!(sv == null || sv.equals(""))) {
			map.put("sv", sv);
			map.put("sk", sk);		
		}
		
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
				
		if (!(sv == null || sv.equals(""))) {
			BookDAO dao = new BookDAO();
			list = dao.list(map);			
			System.out.println(list);
		
		  for (BookDTO dto : list) {
			  
		  
		  //날짜에서 시간 잘라내기 
		  dto.setPubDate(dto.getPubDate().substring(0,10));
		  
		  //제목, 카피 너무 길면 자르기 
		  if (dto.getTitle().length() > 30) {
			  dto.setTitle(dto.getTitle().substring(0, 30) + ".."); }
		  
		  if (dto.getCopy().length() > 80) {
			  dto.setCopy(dto.getCopy().substring(0, 80) + ".."); }
		  
		  }
		
		
		
		req.setAttribute("sk", sk);
		req.setAttribute("sv", sv);
		
		}
		req.setAttribute("list", list);//***
		
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/common/searchview.jsp");
		dispatcher.forward(req, resp);

	}

}
