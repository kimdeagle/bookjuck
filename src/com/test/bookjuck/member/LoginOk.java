package com.test.bookjuck.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.GhostMemberDAO;
import com.test.bookjuck.dao.MemberDAO;
import com.test.bookjuck.dto.MemberDTO;

@WebServlet("/member/loginok.do")
public class LoginOk extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		// 1.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		
		//일반 회원 
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		//휴면 회원 
		GhostMemberDAO dao_h = new GhostMemberDAO();
		
		
		
		dto.setId(id);
		dto.setPw(pw);
		
		//로그인 
		int result = dao.login(dto);
		//휴면계정 찾기
		int result_h = dao_h.check(dto);
		
		System.out.println(result_h);
		
		
		if (result == 1 && result_h == 0) {

			HttpSession session = req.getSession();
			
			session.setAttribute("id", dto.getId());
			
			MemberDTO rdto = dao.getMember(id);
			
			//사이트 전역을 계속 들고 다녀야 하는 정보
			//session DATA
			session.setAttribute("seq", rdto.getSeq());
			session.setAttribute("id", rdto.getId());
			session.setAttribute("pw", rdto.getPw());
			session.setAttribute("name", rdto.getName());
			session.setAttribute("tel", rdto.getTel());
			session.setAttribute("regDate", rdto.getRegDate());
			session.setAttribute("address", rdto.getAddress());
			session.setAttribute("ssn", rdto.getSsn());
			session.setAttribute("login", rdto.getLogin());
			session.setAttribute("email", rdto.getEmail());
			session.setAttribute("points", rdto.getPoints());
			session.setAttribute("privacy", rdto.getPrivacy());
			session.setAttribute("lastDate", rdto.getLastDate());
			
			session.setAttribute("curation", rdto.getCuration());
			
			
			//시작 페이지로 이동
			resp.sendRedirect("http://localhost:8090/bookjuck/index.do");
		}else if(result_h > 0) {
			//휴면 계정 로그인 실패
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><head><meta charset='utf-8'></head><body>");			
			writer.print("<script>");
			writer.print("alert('Dormancy ID');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		}else {
			//로그인 실패
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><head><meta charset='utf-8'></head><body>");
			writer.print("<script>");
			writer.print("alert('Login Failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
		}
	}
	
}
