package com.test.bookjuck.admin.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.BookDAO;
import com.test.bookjuck.dao.BookDeliveryDAO;
import com.test.bookjuck.dao.BookOrderDetailDAO;
import com.test.bookjuck.dao.BookPayDAO;
import com.test.bookjuck.dao.OrderListDAO;
import com.test.bookjuck.dto.BookDTO;
import com.test.bookjuck.dto.BookDeliveryDTO;
import com.test.bookjuck.dto.BookOrderDetailDTO;
import com.test.bookjuck.dto.BookPayDTO;

@WebServlet("/admin/order/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		OrderListDAO dao = new OrderListDAO();

		HttpSession session = req.getSession();

		// 수경 시작
		// 종이책 상세 주문 조회
		String seqBookOrder = req.getParameter("seqBookOrder");
		String id = req.getParameter("id");
		
		String seq = dao.getMemberSeq(id);


		ArrayList<BookOrderDetailDTO> blist = dao.listBookDetail(seq, seqBookOrder);

		// 주문일 가져오기
		String orderDate = dao.getOrderDate(seqBookOrder);

		
		//결제 정보 조회

		BookPayDAO bpdao = new BookPayDAO();
		ArrayList<BookPayDTO> bplist = bpdao.listBookPay(seqBookOrder);

		// 배송 정보 가져오기
		BookDeliveryDAO bddao = new BookDeliveryDAO();
		ArrayList<BookDeliveryDTO> bdlist = bddao.listBookDelivery(seqBookOrder);

		// 수경 끝

		// 조아라 시작) 주문상세 페이지에서 독후감 쓸 수 있는 책은 독후감 작성하기 버튼이 보이도록 하는 기능 추가
		// 독후감 쓸 수 있는 책 가져오기
		// 1. 배송완료이면서 2. 독후감을 아직 안 쓴 책
		BookDAO pdao = new BookDAO();
		ArrayList<BookDTO> plist = pdao.getPossibleBook(session.getAttribute("seq").toString());
		// 조아라 끝)
		
		
		// 다은 시작) 주문 상세정보에 교/취/환 정보 추가하기
		BookOrderDetailDAO boddao = new BookOrderDetailDAO();
		
		//주문이 일반주문인지 교환/취소/환불인지 알아내기
		String ordertype = boddao.getType(seqBookOrder);
		
		BookOrderDetailDTO cancelinfo;
		BookOrderDetailDTO returninfo;
		BookOrderDetailDTO refundinfo;
		
		
		if (ordertype.equals("cancel")) {
			//취소정보 가져오기
			cancelinfo = boddao.getCancelInfo(seqBookOrder);	
			req.setAttribute("cancelinfo", cancelinfo);
			
		} else if (ordertype.equals("return")) {
			//교환정보 가져오기
			returninfo = boddao.getReturnInfo(seqBookOrder);	
			req.setAttribute("returninfo", returninfo);
			
		} else if (ordertype.equals("refund")) {
			//환불정보 가져오기
			refundinfo = boddao.getRefundInfo(seqBookOrder);	
			req.setAttribute("refundinfo", refundinfo);
		
		}
		
		// 다은 끝
		

		req.setAttribute("blist", blist);		
		req.setAttribute("bdlist", bdlist);
		req.setAttribute("bplist", bplist);
		req.setAttribute("seqBookOrder", seqBookOrder);
		req.setAttribute("orderDate", orderDate);
		req.setAttribute("plist", plist); // 조아라) 독후감쓸 수 있는 책 리스트도 보내기
		
		req.setAttribute("ordertype", ordertype); // 다은) 주문 타입보내기
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/order/view.jsp");
		dispatcher.forward(req, resp);

	}

}
