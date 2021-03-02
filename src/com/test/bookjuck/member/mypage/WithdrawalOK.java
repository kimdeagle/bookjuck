package com.test.bookjuck.member.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.MemberDAO;
import com.test.bookjuck.dto.MemberDTO;

@WebServlet("/member/mypage/withdrawalok.do")
public class WithdrawalOK extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String id="";
		String seq = "";
		int result = 0;
		
		try {
			
			id = req.getParameter("id");
			seq = req.getParameter("seq");
			
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();
			
			dto.setId(id);
			dto.setSeq(seq);
			
			session.invalidate(); // 세션 초기화

			result = dao.del(dto);
			
			

			

			if (result == 1) {
				PrintWriter writer = resp.getWriter();
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('success');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");
				writer.close();
				resp.sendRedirect("http://localhost:8090/bookjuck/index.do");
			}else {
				PrintWriter writer = resp.getWriter();
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('failed');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");

			writer.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
