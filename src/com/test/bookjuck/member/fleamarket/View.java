package com.test.bookjuck.member.fleamarket;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.UsedBoardDAO;
import com.test.bookjuck.dto.UsedBoardDTO;

@WebServlet("/member/fleamarket/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//1. 데이터 가져오기(seq)
		//2. DB 작업 -> select
		//3. 결과 반환 -> JSP 호출하기 + 전달
		
		HttpSession session = req.getSession();
		
		//1.
		String seq = req.getParameter("seq");
		String fleamarketsearch = req.getParameter("fleamarketsearch"); //검색어
		
		//2.
		UsedBoardDAO dao = new UsedBoardDAO();
		
		//2.5. 조회수 증가시키기
		dao.updateReadcnt(seq);
		
		
		UsedBoardDTO dto = dao.get(seq);
		
		dao.close();
		
		
		//3.
		req.setAttribute("dto", dto);
		req.setAttribute("fleamarketsearch", fleamarketsearch);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/fleamarket/view.jsp");
		dispatcher.forward(req, resp);
	}

}