package com.test.bookjuck.member.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;
import com.test.bookjuck.dto.MemberDTO;



@WebServlet("/member/mypage/pweditok.do")
public class PwEditOK extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pw="";
		String id="";
		
		int result = 0;
		
		try {
			
			pw = req.getParameter("pw");
			id = req.getParameter("id");
			
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();
			
			dto.setPw(pw);
			dto.setId(id);
			
			result = dao.pwEdit(dto);
			
			PrintWriter writer = resp.getWriter();
			
			if (result == 1) {
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('success');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");

				resp.sendRedirect("http://localhost:8090/bookjuck/member/mypage.do");
			}else {

				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('failed');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");

			writer.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
