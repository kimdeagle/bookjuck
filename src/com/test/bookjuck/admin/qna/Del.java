package com.test.bookjuck.admin.qna;

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

@WebServlet("/admin/qna/del.do")
public class Del extends HttpServlet {

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
				
		String seq=req.getParameter("seq");
		String isDone=req.getParameter("isdone");
		
		QuestionDAO dao=new QuestionDAO();
		QuestionDTO dto=new QuestionDTO();
		
		dto.setSeq(seq);
		dto.setIsDone(isDone);
		
		int result=dao.del(dto);
		
		if (result==1) {
			// 질문글 삭제 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/admin/qna/list.do");
		} else {
			// 질문글 삭제 실패 -> 경고 + 뒤로 가기
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