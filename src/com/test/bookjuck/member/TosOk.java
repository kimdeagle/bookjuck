package com.test.bookjuck.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;
import com.test.bookjuck.dto.MemberDTO;

public class TosOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		
		String id = "";
		String pw = "";
		String name = "";
		int tel = 0;
		String regDate = "";
		String address = "";
		String ssn = "";
		String login = "";
		String email = "";
		int points = 0;
		int privacy = 0;
		String lastDate = "";

		int result = 0;

		try {
			
			
			
			id = req.getParameter("id");
			pw = req.getParameter("pw");
			name = req.getParameter("name");
			/* tel = req.getParameterValues(tel); */
			regDate = req.getParameter("regDate");
			address = req.getParameter("address");
			ssn = req.getParameter("ssn");
			login = req.getParameter("login");
			email = req.getParameter("email");
			/*
			 * points = req.getParameterValues(points); privacy = req.getParameter(privacy);
			 */
			lastDate = req.getParameter("lastDate");

			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();

			
			dto.setId(name);
			dto.setPw(pw);
			dto.setName(name);
			dto.setTel(tel);
			dto.setRegDate(regDate);
			dto.setAddress(address);
			dto.setSsn(ssn);
			dto.setLogin(login);
			dto.setEmail(email);
			dto.setPoints(points);
			dto.setPrivacy(privacy);
			dto.setLastDate(lastDate);

			result = dao.Tosadd(dto);

			if (result == 1) {
				resp.sendRedirect("/member/mypage/mypage.do");
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
