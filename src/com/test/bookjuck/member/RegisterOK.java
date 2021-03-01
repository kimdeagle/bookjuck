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
		int tel = 0;
		String tel1 = "";
		String tel2 = "";
		String tel3 = "";
		String regDate = "";
		String address = "";
		String sample6_postcode = "";
		String sample6_address = "";
		String sample6_detailAddress = "";
		String sample6_extraAddress = "";
		String ssn1 = "";
		String ssn2 = "";
		String login = "일반";
		String email1 = "";
		String email2 = "";
		int points = 0;
		int subscript = 0;
		int privacy = 0;
		String lastDate = "";

		int result = 0;
		int result_c = 0;// 큐레이션

		try {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String now = format.format(cal.getTime());

			id = req.getParameter("id");
			pw = req.getParameter("pw");
			name = req.getParameter("name");
			ssn1 = req.getParameter("ssn1");
			ssn2 = req.getParameter("ssn2");
			regDate = now;
			address = "("+req.getParameter("sample6_postcode")+")"+req.getParameter("sample6_address")+req.getParameter("sample6_detailAddress")+req.getParameter("sample6_extraAddress");
			email1 = req.getParameter("email1");
			email2 = req.getParameter("email2");
			tel1 = req.getParameter("tel1");
			tel2 = req.getParameter("tel2");
			tel3 = req.getParameter("tel3");
			tel = Integer.parseInt(req.getParameter("tel1") + req.getParameter("tel2") + req.getParameter("tel3"));

			lastDate = now;
			privacy = Integer.parseInt(req.getParameter("privacy"));

			subscript = Integer.parseInt(req.getParameter("subscript"));

			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();

			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setTel(tel);
			dto.setRegDate(regDate);
			dto.setAddress(address);
			dto.setSsn(ssn1 + '-' + ssn2);
			dto.setLogin(login);
			dto.setEmail(email1 + '@' + email2);
			dto.setPoints(points);
			dto.setPrivacy(privacy);
			dto.setLastDate(lastDate);

			dto.setSubscript(subscript);

			result = dao.add(dto);

			//큐레이션 구독
			if (subscript == 1) {
				result_c = dao.add_c(dto);
			}
			
			
			PrintWriter writer = resp.getWriter();

			if (result == 1) {
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('success');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");

				resp.sendRedirect("http://localhost:8090/bookjuck/member/login.do");
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
