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

import com.test.bookjuck.dao.AnswerDAO;
import com.test.bookjuck.dao.QuestionDAO;
import com.test.bookjuck.dto.AnswerDTO;
import com.test.bookjuck.dto.QuestionDTO;

@WebServlet("/member/qna/detail.do")
public class Detail extends HttpServlet {

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
		
		// 나머지 데이터 가져오기
		String seq=req.getParameter("seq"); // QnA 글번호
		String page=req.getParameter("page");
		
		// 글번호를 이용해서
		// QnA 질문, 답변을 가져온다. (질문, 답변 따로)
		
		// 질문
		QuestionDAO qdao=new QuestionDAO();
		QuestionDTO qdto=qdao.getInfo(seq);
		
		// 본인이 작성한 질문이라면
		if (qdto.getSeqMember().equals(session.getAttribute("seq"))) {
			
			// 답변
			AnswerDAO adao=new AnswerDAO();
			AnswerDTO adto=adao.getInfo(seq);
			
			req.setAttribute("adto", adto);
			req.setAttribute("qdto", qdto);
			req.setAttribute("page", page);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/qna/detail.jsp");
			dispatcher.forward(req, resp);
			
		
		// 본인이 작성한 질문이 아니라면
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