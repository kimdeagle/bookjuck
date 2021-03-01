package com.test.bookjuck.admin.custmng;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.GhostMemberDAO;
import com.test.bookjuck.dto.GhostMemberDTO;

@WebServlet("/admin/custmng/dormancyadd.do")
public class DormancyAdd extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = "";
		String regDate ="";
		String nowpage ="";
		int result = 0;
		
		String id ="";
		String pw ="";
		int result_c = 0; // 중복 확인
		
		try {
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String now = format.format(cal.getTime());
			
			seq = req.getParameter("seq");
			regDate = now;
			
			id = req.getParameter("id");
			pw = req.getParameter("pw");
			
			GhostMemberDAO dao = new GhostMemberDAO();
			GhostMemberDTO dto = new GhostMemberDTO();
			
			dto.setSeqMember(seq);
			dto.setRegDate(regDate);
			dto.setState("휴면");
			
			dto.setId(id);
			dto.setPw(pw);
//			System.out.println(dto.getId());
//			System.out.println(dto.getPw());
			result = dao.add(dto);
			result_c = dao.check(id, pw);
//			System.out.println("c:" + result_c);
			PrintWriter writer = resp.getWriter();
			if(result == 1 && result_c==0) {
				
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('Success');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();

				resp.sendRedirect("http://localhost:8090/bookjuck/admin/custmng/custmng.do?page=" + nowpage);
			}else if(result == 1 && result_c>0){
				
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('overlap');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();
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
			System.out.println(e);
		}
	}
}
