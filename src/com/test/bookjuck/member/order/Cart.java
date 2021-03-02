package com.test.bookjuck.member.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.BookCartDAO;
import com.test.bookjuck.dto.BookCartDTO;

@WebServlet("/member/order/cart.do")
public class Cart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String seqMember = (String)session.getAttribute("seq");
		
		BookCartDAO dao = new BookCartDAO();
		
		//장바구니 리스트
		ArrayList<BookCartDTO> list = dao.list(seqMember);
		
		//장바구니 금액 리스트
		int price = dao.getPrice(seqMember);
		
		
		req.setAttribute("list", list);
		req.setAttribute("price", price);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/order/cart.jsp");
		dispatcher.forward(req, resp);

	}
}