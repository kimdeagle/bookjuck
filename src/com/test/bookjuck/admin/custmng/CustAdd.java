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
import com.test.bookjuck.dao.MemberDAO;
import com.test.bookjuck.dto.GhostMemberDTO;
import com.test.bookjuck.dto.MemberDTO;

@WebServlet("/admin/custmng/custadd.do")
public class CustAdd extends HttpServlet{
	
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
			// 휴면-> 일반  전환 중복 확인용
			MemberDAO dao_m = new MemberDAO();
			MemberDTO dto_m = new MemberDTO();
			
			dto.setSeqMember(seq);
			dto.setRegDate(regDate);
			dto.setState("휴면");
			
			dto_m.setId(id);
			dto_m.setPw(pw);
			
			result = dao.del(dto);
			//휴면 -> 일반 중복 검사
			result_c = dao_m.check(dto_m);

//			System.out.println(result_c);
//			System.out.println(result);
			PrintWriter writer = resp.getWriter();
			if(result == 1 && result_c==0) {
				
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('Success');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();

				resp.sendRedirect("http://localhost:8090/bookjuck/admin/custmng/dormancymng.do?page=" + nowpage);
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
