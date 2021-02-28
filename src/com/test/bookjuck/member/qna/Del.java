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

@WebServlet("/member/qna/del.do")
public class Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
			
		// 로그인했는지 안했는지 확인
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
		
		// 쿼리스트링으로 넘어온 seq를 이용해서
		// 상세정보를 찾아
		// JSP에 넘겨준다.
		
		String seq=req.getParameter("seq");
		String isDone=req.getParameter("isdone");
		QuestionDAO dao=new QuestionDAO();
		QuestionDTO dto=new QuestionDTO();
		
		// 상세정보를 찾아
		// 글쓴 회원과 일치하는지 확인
		dto=dao.getInfo(seq);
		
		// 일치하지 않으면 접근 못하게 한다.
		if (!dto.getSeqMember().equals(session.getAttribute("seq"))) {
			
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
		
		
		dto.setSeq(seq);
		dto.setIsDone(isDone);
		
		int result=dao.del(dto);
		if (result==1) {
			// 질문글 삭제 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/member/qna/list.do");
		} else {
			// 글 삭제 실패 -> 경고 + 뒤로 가기
			PrintWriter writer=resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;
			
		}
	}

}