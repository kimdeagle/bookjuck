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


@WebServlet("/member/mypage/custinfoeditok.do")
public class CustInfoEditOK extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = "";
		String pw = "";		
		int tel = 0;
		String address = "";
		String email = "";
		String curation ="";
		int privacy =0;
		
		//수정 결과
		int result = 0;
		//큐레이션 삭제 결과
		int result_c = 0; 
		
		try {
			id = req.getParameter("id");
			pw = req.getParameter("pw");
			tel = Integer.parseInt(req.getParameter("tel"));
			address = req.getParameter("address");
			email = req.getParameter("email");
			curation = req.getParameter("subscriptBtn");
			privacy = Integer.parseInt(req.getParameter("term"));
					
			System.out.println(id);
			System.out.println(pw);
			System.out.println(tel);
			System.out.println(address);
			System.out.println(email);
			System.out.println(curation);
			System.out.println(privacy);
			
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();
			
			dto.setId(id);
			dto.setPw(pw);
			dto.setTel(tel);
			dto.setAddress(address);
			dto.setPrivacy(privacy);
			dto.setEmail(email);
			dto.setCuration(curation);
			
			result = dao.edit(dto);
			System.out.println(result);
			
			
			if(dto.getCuration().equals("비구독")) {
				//구독 삭제
				result_c = dao.del_c(dto);
			}else {
				//구독 추가				
			}
			
			
			PrintWriter writer = resp.getWriter();

			if (result == 1) {
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('success');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");

				resp.sendRedirect("http://localhost:8090/bookjuck/member/custinfo.do");
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
