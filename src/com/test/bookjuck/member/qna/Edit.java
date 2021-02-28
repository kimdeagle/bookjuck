package com.test.bookjuck.member.qna;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.QuestionDAO;
import com.test.bookjuck.dto.QuestionDTO;

@WebServlet("/member/qna/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 로그인했는지 확인
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
			
		}
		
		String seq=req.getParameter("seq"); // QnA 글번호
		
		// 글번호를 이용해서
		// QnA 질문글을 가져온다.
		
		// 질문
		QuestionDAO dao=new QuestionDAO();
		QuestionDTO dto=dao.getInfo(seq);
		
		if (dto.getSeqMember().equals(session.getAttribute("seq"))) {
			
			req.setAttribute("dto", dto);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/qna/edit.jsp");
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
			
		}
		
		
	}

}