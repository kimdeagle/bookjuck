package com.test.bookjuck.member.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.BookDeliveryDAO;
import com.test.bookjuck.dao.MemberDAO;
import com.test.bookjuck.dto.BookDeliveryDTO;

@WebServlet("/member/order/orderpaymem.do")
public class OrderPayMem extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 1차적으로 로그인 접속이 맞는지 확인
		HttpSession session=req.getSession();
		
		if (session.getAttribute("id")==null) {
			
			// 접근 권한 없음
			PrintWriter writer=resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('access denied');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
		}
		
		//책제목 가져오기
		//String seqBook = session.getAttribute("seqBook").toString();
		//String title = session.getAttribute("title").toString();
		
		
		//보유 포인트 잔액 가져오기
		MemberDAO mdao = new MemberDAO();
		int points = mdao.getPoint(session.getAttribute("id").toString());
		
		
		
		//최근 배송지 가져오기
		BookDeliveryDAO dao = new BookDeliveryDAO();
		ArrayList<BookDeliveryDTO> dlist = dao.getLatestDelivery(session.getAttribute("seq").toString());
		
		
		req.setAttribute("dlist", dlist);
		req.setAttribute("points", points);
		//req.setAttribute("title", title);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/order/orderpaymem.jsp");
		dispatcher.forward(req, resp);

	}
}