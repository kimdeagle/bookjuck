package com.test.bookjuck.admin.custmng;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;
import com.test.bookjuck.dto.MemberDTO;

@WebServlet("/admin/custmng/custdel.do")
public class CustDel extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = "";
		String nowpage="";
		
		int result = 0;
		try {
			
			seq = req.getParameter("seq");
			nowpage = req.getParameter("nowpage");
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();
			
			
			dto.setSeq(seq);
			result= dao.del(dto);
		
			
			if(result == 1) {
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('Success');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();

				resp.sendRedirect("http://localhost:8090/bookjuck/admin/custmng/custmng.do?page=" + nowpage);
				
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
