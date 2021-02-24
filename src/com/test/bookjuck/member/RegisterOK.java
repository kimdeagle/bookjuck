package com.test.bookjuck.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;
import com.test.bookjuck.dto.MemberDTO;



@WebServlet("/member/registerok.do")
public class RegisterOK extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String id = "";
		String pw = "";
		String name = "";
		/*
		 * int tel1 = 0; int tel2 = 0; int tel3 = 0;
		 */
		int tel = 0;
		String tel1 = "";
		String tel2 = "";
		String tel3 = "";
		String regDate = "";
		String address = "";
		String ssn1 = "";
		String ssn2 = "";
		String login = "";
		String email1 = "";
		String email2 = "";
		int points = 0;
		String subscript ="";
		int privacy = 0;
		String lastDate = "";
		
		
		
		int result = 0;

		try {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat ( "yy-MM-dd");
			String now = format.format(cal.getTime());
			
			
			
																
			id = req.getParameter("id");
			pw = req.getParameter("pw");
			name = req.getParameter("name");
			ssn1 = req.getParameter("ssn1");
			ssn2 = req.getParameter("ssn2");
			regDate = now;
			address = req.getParameter("address");
			login = req.getParameter("login");
			email1 = req.getParameter("email1");
			email2 = req.getParameter("email2");
			/*
			 * tel1 = Integer.parseInt(req.getParameter("tel1")); tel2 =
			 * Integer.parseInt(req.getParameter("tel2")); tel3 =
			 * Integer.parseInt(req.getParameter("tel3"));
			 */
			tel1 = req.getParameter("tel1");
			tel2 = req.getParameter("tel2");
			tel3 = req.getParameter("tel3");
			System.out.println(tel1);
			System.out.println(tel2);
			System.out.println(tel3);
			System.out.println(tel);
			/* tel = tel1 + tel2 + tel3; */
			
			lastDate = now;
			privacy = Integer.parseInt(req.getParameter("privacy"));
			subscript = req.getParameter("subscript");
			
			
			
			
			

			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();
			
			
			
			
			
			dto.setId(name);
			dto.setPw(pw);
			dto.setName(name);
			dto.setTel(tel);
			dto.setRegDate(regDate);
			dto.setAddress(address);
			dto.setSsn(ssn1+ssn2);
			dto.setLogin(login);
			dto.setEmail(email1+email2);
			dto.setPoints(points);
			dto.setPrivacy(privacy);
			dto.setLastDate(lastDate);

			System.out.println(dto.getTel());
			System.out.println(dto.getRegDate());
			
			result = dao.add(dto);

			
			
			if (result == 1) {
				resp.sendRedirect("/member/login.do");
			}
			PrintWriter writer = resp.getWriter();

			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");

			
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
