package com.test.bookjuck.member.fleamarket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.UsedBoardDAO;
import com.test.bookjuck.dto.UsedBoardDTO;

@WebServlet("/member/fleamarket/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//목록 or 검색
		// - 단순 목록 : list.do
		// - 검색한 결과 목록 : list.do?search=
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		String search = req.getParameter("search");
		
		if ( !(search == null || search.equals("")) ) {
			map.put("search", search);
		}		
		
		
		//1. DB 작업 -> select
		//2. 목록 반환 + JSP 전달 후 호출하기
		
		HttpSession session = req.getSession();
		
		//view.do -> 새로고침으로 생기는 조회 수 증가 방지 : flag 생성
//		session.setAttribute("read", false);
		
		
		//1.
		UsedBoardDAO dao = new UsedBoardDAO();
		
		ArrayList<UsedBoardDTO> list = dao.list(map);
		
		
		//데이터 조작은 서블릿이, 데이터 출력은 JSP가 담당한다.
		
		//1.5 데이터 조작할 것 : 날짜 (시간 자르기), 글제목 (너무 길면 자르기)
		
		//2. 
		req.setAttribute("list", list);
		req.setAttribute("search", search);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/fleamarket/list.jsp");
		dispatcher.forward(req, resp);
	}

}