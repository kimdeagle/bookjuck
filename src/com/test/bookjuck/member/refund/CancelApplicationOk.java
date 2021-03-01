package com.test.bookjuck.member.refund;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.BookCancelDAO;

@WebServlet("/member/refund/cancelapplicationok.do")
public class CancelApplicationOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		//UTF-8 한글 인코딩
		req.setCharacterEncoding("UTF-8");
		
		// 1: 일반배송
		// 2: 바로드림
		String type = "1";
		
		String seqOrder = req.getParameter("seqOrder");
		String cancelReason = req.getParameter("cancelReason");
		String cancelReasonDetail = req.getParameter("cancelReasonDetail");

		BookCancelDAO dao = new BookCancelDAO();
		
		int result;
		
		if (type.equals("1")) {
			// 일반배송 주문 취소
			result = dao.bookcancel(seqOrder, cancelReason, cancelReasonDetail); 
			
		} else {
			// 바로드림 주문 취소
			result = dao.barocancel(seqOrder, cancelReason, cancelReasonDetail);
			
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
