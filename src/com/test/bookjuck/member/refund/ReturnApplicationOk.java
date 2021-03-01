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

@WebServlet("/member/refund/returnapplicationok.do")
public class ReturnApplicationOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		//UTF-8 한글 인코딩
		req.setCharacterEncoding("UTF-8");
		

		
		String seqOrder = req.getParameter("seqOrder");
		String changeReason = req.getParameter("changeReason");
		String changeReasonDetail = req.getParameter("changeReasonDetail");
		String returnAddress = req.getParameter("returnAddress");
		
		
		BookChangeDAO dao = new BookChangeDAO();
		
		//주문 교환은 일반배송만 가능함
		int result = dao.bookreturn(seqOrder, changeReason, changeReasonDetail, returnAddress); 
			
		
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
