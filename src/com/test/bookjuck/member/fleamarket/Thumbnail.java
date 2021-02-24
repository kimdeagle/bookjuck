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

@WebServlet("/member/fleamarket/thumbnail.do")
public class Thumbnail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//목록 or 검색
		// - 단순 목록 : list.do
		// - 검색한 결과 목록 : list.do?search=
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		String fleamarketsearch = req.getParameter("fleamarketsearch");
		
		if ( !(fleamarketsearch == null || fleamarketsearch.equals("")) ) {
			map.put("fleamarketsearch", fleamarketsearch);
		}		
		
		
		//1. DB 작업 -> select
		//2. 목록 반환 + JSP 전달 후 호출하기
		
		
		HttpSession session = req.getSession();
		//view.do -> 새로고침으로 생기는 조회 수 증가 방지 : flag 생성
		session.setAttribute("read", false);
		
		
		//1.
		UsedBoardDAO dao = new UsedBoardDAO();
		
		ArrayList<UsedBoardDTO> list = dao.list(map);
		
		
		//데이터 조작은 서블릿이, 데이터 출력은 JSP가 담당한다.
		
		//1.5 데이터 조작할 것 : 날짜 (시간 자르기), 글제목 (너무 길면 자르기)
		for (UsedBoardDTO dto : list) {
			
			//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
			dto.setRegDate(dto.getRegDate().substring(0, 10));
			
		}
		
		//2. 
		//검색어까지
		req.setAttribute("list", list);
		req.setAttribute("fleamarketsearch", fleamarketsearch);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/fleamarket/thumbnail.jsp");
		dispatcher.forward(req, resp);

	}

}
