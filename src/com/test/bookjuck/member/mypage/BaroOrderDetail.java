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

import com.test.bookjuck.dao.BaroOrderDetailDAO;
import com.test.bookjuck.dao.BaroPayDAO;
import com.test.bookjuck.dao.OrderListDAO;
import com.test.bookjuck.dto.BaroOrderDetailDTO;
import com.test.bookjuck.dto.BaroPayDTO;

@WebServlet("/member/mypage/baroorderdetail.do")
public class BaroOrderDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		//ArrayList<EBookOrderDetailDTO> elist = dao.listEBook(session.getAttribute("seq").toString());
		
		//수경 시작
	
//		//바로드림 상세주문 조회
		BaroOrderDetailDAO barodao = new BaroOrderDetailDAO();
		String seqBaroOrder = req.getParameter("seqBaroOrder");
		ArrayList<BaroOrderDetailDTO> balist = barodao.listBaroDetail(session.getAttribute("seq").toString(),seqBaroOrder);
//		
		//주문일 가져오기
		String orderDate = barodao.getOrderDate(seqBaroOrder);		
		orderDate = orderDate.substring(0,10);
	
		
		//결제 정보 조회		
		BaroPayDAO pdao = new BaroPayDAO();
		ArrayList<BaroPayDTO> plist = pdao.listBookPay(seqBaroOrder);
//		
		// 수경 끝
		
		
		
		
		
		req.setAttribute("balist",balist);
		req.setAttribute("plist", plist);
		req.setAttribute("seqBaroOrder", seqBaroOrder);
		req.setAttribute("orderDate", orderDate);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/mypage/baroorderdetail.jsp");
		dispatcher.forward(req, resp);

	}
}