package com.test.bookjuck.admin.curationletter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.LetterDAO;
import com.test.bookjuck.dto.LetterDTO;

@WebServlet("/admin/curationletter/detail.do")
public class Detail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 1차적으로 관리자 접속이 맞는지 확인
		HttpSession session=req.getSession();
		
		if (!session.getAttribute("id").equals("adm00")) {
			
			// 접근 권한 없음
			PrintWriter writer=resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('access denied');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;
			
		}
			
		// 어떤 큐레이션 레터를 선택했는지 번호를 받아와서
		// DB에서 레터 정보 꺼내오기
		
		String seq=req.getParameter("seq");
		String page=req.getParameter("page");
		
		LetterDAO dao=new LetterDAO();
		LetterDTO dto=dao.getInfo(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("page", page);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/curationletter/detail.jsp");
		dispatcher.forward(req, resp);
			
	}

}