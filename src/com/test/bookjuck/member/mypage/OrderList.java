package com.test.bookjuck.member.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.OrderListDAO;
import com.test.bookjuck.dto.BaroOrderDTO;
import com.test.bookjuck.dto.BookOrderDetailDTO;
import com.test.bookjuck.dto.EBookOrderDTO;

@WebServlet("/member/mypage/orderlist.do")
public class OrderList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. DB 작업
		//2. 결과 JSP호출
		
		OrderListDAO dao = new OrderListDAO();

		HttpSession session = req.getSession();	
		
		
		//종이책 기본 주문 조회
		//ArrayList<BookOrderDetailDTO> bolist = dao.listBookOrder(seq);
		ArrayList<BookOrderDetailDTO> blist = dao.listBookOrder(session.getAttribute("seq").toString());
		//ArrayList<BookOrderDetailDTO> bcntlist = dao.bcntlist(session.getAttribute("seq").toString());


		for(BookOrderDetailDTO dto : blist) {
			
			//주문일 자르기,
			dto.setOrderDate(dto.getOrderDate().substring(0,10));

		}
		
		
		//바로드림 기본 주문 조회
		ArrayList<BaroOrderDTO> balist = dao.listBaroOrder(session.getAttribute("seq").toString());
		for(BaroOrderDTO dto : balist) {
			
			//주문일 자르기,
			dto.setOrderDate(dto.getOrderDate().substring(0,10));

		}
		
		//이북 기본 주문 조회
		ArrayList<EBookOrderDTO> elist = dao.listEBookOrder(session.getAttribute("seq").toString());
		for(EBookOrderDTO dto : elist) {
			
			//주문일 자르기,
			dto.setOrderDate(dto.getOrderDate().substring(0,10));

		}	
		
		req.setAttribute("blist", blist);
		req.setAttribute("balist", balist);
		req.setAttribute("elist", elist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/mypage/orderlist.jsp");
		dispatcher.forward(req, resp);

	}
}