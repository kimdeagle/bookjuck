package com.test.bookjuck.search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.RealTimeSearchDAO;
import com.test.bookjuck.dto.RealTimeSearchDTO;

@WebServlet("/common/realtimesearch.do")
public class RealTimeSearch extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		
		
		
		ArrayList<RealTimeSearchDTO> list7 = new ArrayList<RealTimeSearchDTO>();
		
		RealTimeSearchDAO dao = new RealTimeSearchDAO();
		list7 = dao.getSearchRank();
		
		
		

		req.setAttribute("list7", list7);
		
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/common/realtimesearch.jsp");
		//dispatcher.forward(req, resp);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/common/realtimesearch.jsp");
		dispatcher.include(req, resp);
		
	}

}