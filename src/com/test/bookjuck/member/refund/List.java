package com.test.bookjuck.member.refund;

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

import com.test.bookjuck.dao.BookOrderDAO;
import com.test.bookjuck.dto.BookOrderDTO;
import com.test.bookjuck.dto.UsedBoardDTO;



@WebServlet("/member/refund/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//목록 or 검색
		// - 단순 목록 : list.do
		// - 검색한 결과 목록 : list.do?search=
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		String refundsearch = req.getParameter("refundsearch");
		
		if ( !(refundsearch == null || refundsearch.equals("")) ) {
			map.put("refundsearch", refundsearch);
		}	
		
		String refundperiod = req.getParameter("refundperiod");
		
		if ( !(refundperiod == null || refundperiod.equals("")) ) {
			map.put("refundperiod", refundperiod);
		}	
		
		//1. DB 작업 -> select
		//2. 목록 반환 + JSP 전달 후 호출하기
		
		HttpSession session = req.getSession();
		
		
		//1.
		BookOrderDAO dao = new BookOrderDAO();	
		
		ArrayList<BookOrderDTO> list = dao.list(map);	
		
		
		//1.5 데이터 조작할 것 : 날짜 (시간 자르기), 글제목 (너무 길면 자르기)
		for (BookOrderDTO dto : list) {
			
			//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
			dto.setApplyDate(dto.getApplyDate().substring(0, 10));
			
			
		}
		
		
		//2.
		req.setAttribute("list", list);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/refund/list.jsp");
		dispatcher.forward(req, resp);

	}

}

