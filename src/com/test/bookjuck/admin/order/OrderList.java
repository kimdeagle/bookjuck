package com.test.bookjuck.admin.order;

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

import com.test.bookjuck.dao.BaroOrderDAO;
import com.test.bookjuck.dao.BookOrderDAO;
import com.test.bookjuck.dao.EBookOrderDAO;
import com.test.bookjuck.dto.BaroOrderDTO;
import com.test.bookjuck.dto.BookOrderDTO;
import com.test.bookjuck.dto.EBookOrderDTO;

@WebServlet("/admin/order/orderlist.do")
public class OrderList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		String ordernumsearch = req.getParameter("ordernumsearch");	//검색하려는 주문번호
		String idsearch = req.getParameter("idsearch");				//검색하려는 주문자id
		String booksearch = req.getParameter("booksearch");			//검색하려는 주문상품명 (책 제목)
		
		String type = "1";
		
		if (req.getParameter("type") != null) {
			type = req.getParameter("type");
		}
		
		
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
	
		System.out.println(type + startDate  + endDate );
		
		
		
		//1. DB 작업 -> select
		//2. 목록 반환 + JSP 전달 후 호출하기
		
		HttpSession session = req.getSession();
		
		//1.
		ArrayList<BookOrderDTO> blist = new ArrayList<BookOrderDTO>();
		ArrayList<BaroOrderDTO> balist = new ArrayList<BaroOrderDTO>();
		ArrayList<EBookOrderDTO> elist = new ArrayList<EBookOrderDTO>();
		
		
		if (type.equals("1")) {
			
			BookOrderDAO dao = new BookOrderDAO();	
			blist = dao.list(map);	
			
			//1.5 데이터 조작할 것
			for (BookOrderDTO dto : blist) {
				
				//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
				dto.setApplyDate(dto.getApplyDate().substring(0, 10));
				
			}
			
		} else if (type.equals("2")) {
			
			BaroOrderDAO dao = new BaroOrderDAO();	
			balist = dao.list(map);	
			
			//1.5 데이터 조작할 것
			for (BaroOrderDTO dto : balist) {
				
				//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
				dto.setApplyDate(dto.getApplyDate().substring(0, 10));
				
			}
			
			
		} else {
			
			EBookOrderDAO dao = new EBookOrderDAO();	
			elist = dao.list(map);	
			
			//1.5 데이터 조작할 것
			for (EBookOrderDTO dto : elist) {
				
				//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
				dto.setApplyDate(dto.getApplyDate().substring(0, 10));
				
			}
		}
		
		
		
		//2.
		req.setAttribute("blist", blist);
		req.setAttribute("balist", balist);
		req.setAttribute("elist", elist);
		
		req.setAttribute("type", type);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/order/orderlist.jsp");
		dispatcher.forward(req, resp);
	}

}