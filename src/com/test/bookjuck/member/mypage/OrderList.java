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
import com.test.bookjuck.dto.BaroOrderDetailDTO;
import com.test.bookjuck.dto.BookOrderDetailDTO;
import com.test.bookjuck.dto.EBookOrderDetailDTO;

@WebServlet("/member/mypage/orderlist.do")
public class OrderList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. DB 작업
		//2. 결과 JSP호출
		
		OrderListDAO dao = new OrderListDAO();

		HttpSession session = req.getSession();
		
		//임시 회원 번호
		//String seq = "1";
				
		
		//ArrayList<BaroOrderDetailDTO> balist = dao.listBaro(session.getAttribute("seq").toString());
		//ArrayList<EBookOrderDetailDTO> elist = dao.listEBook(session.getAttribute("seq").toString());
		
		
		
		//기본 주문 조회
		//ArrayList<BookOrderDetailDTO> bolist = dao.listBookOrder(seq);
		ArrayList<BookOrderDetailDTO> bolist = dao.listBookOrder(session.getAttribute("seq").toString());

		

		for(BookOrderDetailDTO dto : bolist) {
			
			//주문일 자르기,
			dto.setOrderDate(dto.getOrderDate().substring(0,10));			
		}
		
		
		
		req.setAttribute("bolist", bolist);
		//req.setAttribute("balist", blist);
		//req.setAttribute("elist", blist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/mypage/orderlist.jsp");
		dispatcher.forward(req, resp);

	}
}