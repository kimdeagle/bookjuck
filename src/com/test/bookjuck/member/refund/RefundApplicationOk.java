package com.test.bookjuck.member.refund;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.BookChangeDAO;
import com.test.bookjuck.dao.BookRefundDAO;

@WebServlet("/member/refund/refundapplicationok.do")
public class RefundApplicationOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		//UTF-8 한글 인코딩
		req.setCharacterEncoding("UTF-8");
		
		// 1: 일반배송
		// 3: eBook
		String type = "1";
		
		String seqOrder = req.getParameter("seqOrder");
		String refundReason = req.getParameter("refundReason");
		String refundReasonDetail = req.getParameter("refundReasonDetail");
		String returnAddress = req.getParameter("returnAddress");
		
		BookRefundDAO dao = new BookRefundDAO();
		
		int result;
		
		if (type.equals("1")) {
			//일반배송 주문환불
			result = dao.bookrefund(seqOrder, refundReason, refundReasonDetail, returnAddress); 
			
		} else {
			//E-book 주문 취소
			result = dao.ebookrefund(seqOrder, refundReason, refundReasonDetail, returnAddress); 
			
		}
		

			
		
		if (result == 1) {
			//신청 성공 -> 주문 내역 리스트로 가기
			resp.sendRedirect("/bookjuck/member/mypage/orderlist.do");
			
		} else {
			//신청 실패 -> 경고 + 뒤로가기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
		}


	}

}
