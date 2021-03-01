package com.test.bookjuck.member.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.BookCartDAO;
import com.test.bookjuck.dto.BookCartDTO;

@WebServlet("/member/order/cartaddok.do")
public class CartAddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
		
		req.setCharacterEncoding("UTF-8");

		BookCartDTO dto = new BookCartDTO();
		
		String seqBook=req.getParameter("seqBook");
		String amount = req.getParameter("amount");
		
		dto.setSeqBook(seqBook);
		dto.setAmount(amount);
		dto.setSeqMember(session.getAttribute("seq").toString());
		
		BookCartDAO dao = new BookCartDAO();
		
		int result = dao.add(dto);
		
		if(result == 1) {
			//장바구니 담기 성공
			
		}else {
			//장바구니 담기 실패
			PrintWriter writer=resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;
		}
		
		
		
	}
}
