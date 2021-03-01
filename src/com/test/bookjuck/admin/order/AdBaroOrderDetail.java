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

import com.test.bookjuck.dao.BaroOrderDetailDAO;
import com.test.bookjuck.dao.BaroPayDAO;
import com.test.bookjuck.dao.BookDAO;
import com.test.bookjuck.dao.BookDeliveryDAO;
import com.test.bookjuck.dao.BookOrderDetailDAO;
import com.test.bookjuck.dao.BookPayDAO;
import com.test.bookjuck.dao.OrderListDAO;
import com.test.bookjuck.dto.BaroOrderDetailDTO;
import com.test.bookjuck.dto.BaroPayDTO;
import com.test.bookjuck.dto.BookDTO;
import com.test.bookjuck.dto.BookDeliveryDTO;
import com.test.bookjuck.dto.BookOrderDetailDTO;
import com.test.bookjuck.dto.BookPayDTO;

@WebServlet("/admin/order/adbaroorderdetail.do")
public class AdBaroOrderDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		OrderListDAO dao = new OrderListDAO();

		HttpSession session = req.getSession();


		//주문 번호 + 사용자 id 및 seq 받아오기
		String seqBaroOrder = req.getParameter("seqBaroOrder");
		String id = req.getParameter("id");

		String seq = dao.getMemberSeq(id);


		//바로드림 상세주문 조회
		BaroOrderDetailDAO barodao = new BaroOrderDetailDAO();
		ArrayList<BaroOrderDetailDTO> balist = barodao.listBaroDetail(seq,seqBaroOrder);
		
		//주문일 가져오기
		String orderDate = barodao.getOrderDate(seqBaroOrder);		
		orderDate = orderDate.substring(0,10);
	
		
		//결제 정보 조회		
		BaroPayDAO pdao = new BaroPayDAO();
		ArrayList<BaroPayDTO> plist = pdao.listBookPay(seqBaroOrder);


		
		// 다은 시작) 주문 상세정보에 교/취/환 정보 추가하기
		BaroOrderDetailDAO boddao = new BaroOrderDetailDAO();
		
		//주문이 일반주문인지 교환/취소/환불인지 알아내기
		String ordertype = boddao.getType(seqBaroOrder);
		
		BaroOrderDetailDTO cancelinfo;
		
		if (ordertype.equals("cancel")) {
			//취소정보 가져오기
			cancelinfo = boddao.getCancelInfo(seqBaroOrder);	
			req.setAttribute("cancelinfo", cancelinfo);
		} 
		
		// 다은 끝
		

		req.setAttribute("balist",balist);
		req.setAttribute("plist", plist);
		req.setAttribute("seqBaroOrder", seqBaroOrder);
		req.setAttribute("orderDate", orderDate);
		
		req.setAttribute("ordertype", ordertype); // 다은) 주문 타입보내기
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/order/adbaroorderdetail.jsp");
		dispatcher.forward(req, resp);

	}
}