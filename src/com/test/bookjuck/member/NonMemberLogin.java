package com.test.bookjuck.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.NonMemberDAO;
import com.test.bookjuck.dto.NonMemberDTO;

@WebServlet("/member/nonmemberlogin.do")
public class NonMemberLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
		String email = req.getParameter("nmEmail");
		int tel = Integer.parseInt(req.getParameter("nmTel"));
		String pw = req.getParameter("nmPw");
		
		NonMemberDAO dao = new NonMemberDAO();
		NonMemberDTO dto = new NonMemberDTO();
		
		dto.setEmail(email);
		dto.setTel(tel);
		dto.setPw(pw);
		
		int result = dao.nmlogin(dto);
			
		if(result == 1) {
			
			HttpSession session = req.getSession();
			
			session.setAttribute("email", dto.getEmail());
						
			NonMemberDTO rdto = dao.getNonmember(email);
			
			session.setAttribute("name", rdto.getName());
			session.setAttribute("email", rdto.getEmail());
			session.setAttribute("pw", rdto.getPw());
			session.setAttribute("tel", rdto.getTel());
			session.setAttribute("seq", rdto.getSeq());
			
			
			//주문 리스트 페이지로 이동
			resp.sendRedirect("http://localhost:8090/bookjuck/member/mypage/orderlist.do");
		
		}else {
			//로그인 실패
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
