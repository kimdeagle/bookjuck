package com.test.bookjuck.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.AdminDAO;
import com.test.bookjuck.dto.AdminDTO;




@WebServlet("/admin/loginok.do")
public class LoginOK extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
				// 1.
				String id = req.getParameter("id");
				String pw = req.getParameter("pwd");
				
				AdminDAO dao = new AdminDAO();
				AdminDTO dto = new AdminDTO();
				
				dto.setId(id);
				dto.setPw(pw);
				
				//로그인 
				int result = dao.login(dto);
				
			
				
				if (result == 1) {
					
					HttpSession session = req.getSession();
					
					session.setAttribute("id", dto.getId());
					
					AdminDTO rdto = dao.getMember(id);
					
					session.setAttribute("seq", rdto.getSeq());
					session.setAttribute("id", rdto.getId());
					session.setAttribute("pw", rdto.getPw());
					
					resp.sendRedirect("http://localhost:8090/bookjuck/admin/index.do");
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