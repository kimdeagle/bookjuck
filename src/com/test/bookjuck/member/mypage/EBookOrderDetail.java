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
import com.test.bookjuck.dao.EBookOrderDetailDAO;
import com.test.bookjuck.dao.EBookPayDAO;
import com.test.bookjuck.dto.BaroOrderDetailDTO;
import com.test.bookjuck.dto.EBookOrderDetailDTO;
import com.test.bookjuck.dto.EBookPayDTO;

@WebServlet("/member/mypage/ebookorderdetail.do")
public class EBookOrderDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		//ArrayList<EBookOrderDetailDTO> elist = dao.listEBook(session.getAttribute("seq").toString());
		
		//수경 시작
	
//		//이북 상세주문 조회
		EBookOrderDetailDAO ebookdao = new EBookOrderDetailDAO();
		String seqEBookOrder = req.getParameter("seqEBookOrder");
		ArrayList<EBookOrderDetailDTO> elist = ebookdao.listEBookDetail(session.getAttribute("seq").toString(),seqEBookOrder);
//		
		//주문일 가져오기
		String orderDate = ebookdao.getOrderDate(seqEBookOrder);		
		orderDate = orderDate.substring(0,10);
	
		
		//결제 정보 조회		
		EBookPayDAO pdao = new EBookPayDAO();
		ArrayList<EBookPayDTO> plist = pdao.listEBookPay(seqEBookOrder);
//		
		// 수경 끝
		
		
		// 다은 시작) 주문 상세정보에 교/취/환 정보 추가하기
		EBookOrderDetailDAO eoddao = new EBookOrderDetailDAO();
		
		//주문이 일반주문인지 교환/취소/환불인지 알아내기
		String ordertype = eoddao.getType(seqEBookOrder);
		
		EBookOrderDetailDTO refundinfo;
		
		if (ordertype.equals("refund")) {
			//환불정보 가져오기
			refundinfo = eoddao.getRefundInfo(seqEBookOrder);	
			req.setAttribute("refundinfo", refundinfo);
		
		}
		
		// 다은 끝
		
		
		req.setAttribute("elist",elist);
		req.setAttribute("plist", plist);
		req.setAttribute("seqEBookOrder", seqEBookOrder);
		req.setAttribute("orderDate", orderDate);
		
		req.setAttribute("ordertype", ordertype); // 다은) 주문 타입보내기
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/mypage/ebookorderdetail.jsp");
		dispatcher.forward(req, resp);

	}
}