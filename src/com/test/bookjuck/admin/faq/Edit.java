package com.test.bookjuck.admin.faq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.FAQDAO;
import com.test.bookjuck.dao.QCategoryDAO;
import com.test.bookjuck.dto.FAQDTO;
import com.test.bookjuck.dto.QCategoryDTO;

@WebServlet("/admin/faq/edit.do")
public class Edit extends HttpServlet {

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
			
		// 모달창에서 받아온 seq로 수정할 글 찾기
		
		String seq=req.getParameter("seq");
		
		FAQDAO dao=new FAQDAO();
		FAQDTO dto=dao.getInfo(seq);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/faq/edit.jsp");
		dispatcher.forward(req, resp);
		
		
	}

}