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

import com.test.bookjuck.dao.AnswerDAO;
import com.test.bookjuck.dto.AnswerDTO;

@WebServlet("/admin/qna/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
				
		// 1. 인코딩
		// 2. 데이터 받아오기
		// 3. DB 처리
		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		String seq=req.getParameter("editseq");
		String seqQuestion=req.getParameter("editseqQuestion");
		String answerContent=req.getParameter("editanswerContent");
		
		AnswerDTO dto=new AnswerDTO();
		
		dto.setSeq(seq);
		dto.setAnswerContent(answerContent);
		AnswerDAO dao=new AnswerDAO();
		
		int result=dao.edit(dto);
		
		if (result==1) {
			// 답변 작성 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/admin/qna/detail.do?seq="+seqQuestion);
		} else {
			// 답변 작성 실패 -> 경고 + 뒤로 가기
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