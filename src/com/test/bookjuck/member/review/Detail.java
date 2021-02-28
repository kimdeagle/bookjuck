package com.test.bookjuck.member.review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.ReviewDAO;
import com.test.bookjuck.dto.ReviewDTO;

@WebServlet("/member/review/detail.do")
public class Detail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 글쓴 본인 접속이거나, 관리자 접속인지 확인
		HttpSession session=req.getSession();
		
		if (session.getAttribute("id")==null) {
			
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
		
		// 1. JSP에서 보낸 데이터 받아오고
		// 2. DB 작업으로 상세보기할 독후감 정보 가져오기
		
		String seq=req.getParameter("seq");
		String page=req.getParameter("page");
		
		ReviewDAO dao=new ReviewDAO();
		ReviewDTO dto=dao.getInfo(seq);
		
		if (dto.getSeqMember().equals(session.getAttribute("seq"))) {
			
			req.setAttribute("page", page);
			req.setAttribute("dto", dto);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/review/detail.jsp");
			dispatcher.forward(req, resp);
		
		} else {
			
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
		
		
	}

}