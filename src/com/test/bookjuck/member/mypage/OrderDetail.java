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

import com.test.bookjuck.dao.BookDeliveryDAO;
import com.test.bookjuck.dao.BookPayDAO;
import com.test.bookjuck.dao.OrderListDAO;
import com.test.bookjuck.dto.BookDeliveryDTO;
import com.test.bookjuck.dto.BookOrderDetailDTO;
import com.test.bookjuck.dto.BookPayDTO;

@WebServlet("/member/mypage/orderdetail.do")
public class OrderDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		OrderListDAO dao = new OrderListDAO();

		HttpSession session = req.getSession();
		//임시 회원 번호
		//String seq = "1";
		
		//ArrayList<BaroOrderDetailDTO> balist = dao.listBaro(session.getAttribute("seq").toString());
		//ArrayList<EBookOrderDetailDTO> elist = dao.listEBook(session.getAttribute("seq").toString());
		
		
		//상세 주문 조회		
		String seqBookOrder = req.getParameter("seqBookOrder");
		
		//ArrayList<BookOrderDetailDTO> blist = dao.listBookDetail(seq);
		ArrayList<BookOrderDetailDTO> blist = dao.listBookDetail(session.getAttribute("seq").toString(),seqBookOrder);

		for(BookOrderDetailDTO dto : blist) {

			//주문일 자르기,
			dto.setOrderDate(dto.getOrderDate().substring(0,10));			
		}
		
		//주문일 가져오기
		String orderDate = dao.getOrderDate(seqBookOrder,"b");
		
		orderDate = orderDate.substring(0,10);
		
		//결제 정보 조회
		BookPayDAO bpdao = new BookPayDAO();
		ArrayList<BookPayDTO> bplist = bpdao.listBookPay(seqBookOrder);
		
		//배송 정보 가져오기
		BookDeliveryDAO bddao = new BookDeliveryDAO();
		ArrayList<BookDeliveryDTO> bdlist = bddao.listBookDelivery(seqBookOrder);
		
		
		req.setAttribute("blist",blist);
		req.setAttribute("bplist", bplist);
		req.setAttribute("bdlist", bdlist);
		req.setAttribute("seqBookOrder", seqBookOrder);
		req.setAttribute("orderDate", orderDate);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/mypage/orderdetail.jsp");
		dispatcher.forward(req, resp);

	}
}