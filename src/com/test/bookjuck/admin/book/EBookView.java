package com.test.bookjuck.admin.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.EBookDAO;
import com.test.bookjuck.dto.EBookDTO;


@WebServlet("/admin/book/ebookview.do")
public class EBookView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(seqSCategory)
		//2. DB 작업 -> select
		//3. 결과 + JSP 호출
		
		
		HttpSession session = req.getSession();
		
		//관리자가 아니면
		if (!"adm00".equals((String)session.getAttribute("id"))) {

			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><head><meta charset='UTF-8' /></head><body>");
			writer.print("<script>");
			writer.print("alert('접근할 수 없습니다.\\n이전 화면으로 이동합니다.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;
			
		}
		
		
		//1.
		String seq = req.getParameter("seq");
		String page = req.getParameter("page");
		String seqLCategory = req.getParameter("seqLCategory");
		
		//2.
		EBookDAO dao = new EBookDAO();
		EBookDTO dto = dao.getAdminEBookDetail(seq);
		
		
		//날짜 데이터 자르기 -> 시간 삭제
		dto.setPubDate(dto.getPubDate().substring(0, 10));
		
		dao.close();
		
		req.setAttribute("dto", dto);
		req.setAttribute("page", page);
		req.setAttribute("seqLCategory", seqLCategory);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/book/ebookview.jsp");
		dispatcher.forward(req, resp);
	}
	
}
