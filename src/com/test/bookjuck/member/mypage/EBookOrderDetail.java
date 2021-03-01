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

import com.test.bookjuck.dao.EBookOrderDetailDAO;
import com.test.bookjuck.dao.EBookPayDAO;
import com.test.bookjuck.dto.EBookOrderDetailDTO;
import com.test.bookjuck.dto.EBookPayDTO;

@WebServlet("/member/mypage/ebookorderdetail.do")
public class EBookOrderDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		//ArrayList<EBookOrderDetailDTO> elist = dao.listEBook(session.getAttribute("seq").toString());
		
		//수경 시작
	
//		//바로드림 상세주문 조회
		EBookOrderDetailDAO ebookdao = new EBookOrderDetailDAO();
		String seqEBookOrder = req.getParameter("seqBaroOrder");
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
		
		
		
		
		
		req.setAttribute("elist",elist);
		req.setAttribute("plist", plist);
		req.setAttribute("seqEBookOrder", seqEBookOrder);
		req.setAttribute("orderDate", orderDate);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/mypage/ebookorderdetail.jsp");
		dispatcher.forward(req, resp);

	}
}