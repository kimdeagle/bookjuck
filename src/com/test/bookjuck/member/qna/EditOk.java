package com.test.bookjuck.member.qna;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.QuestionDAO;
import com.test.bookjuck.dto.QuestionDTO;

@WebServlet("/member/qna/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
			
			return;
			
		}
		
		// 인코딩
		req.setCharacterEncoding("UTF-8");
		
		String seq=req.getParameter("seq");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String seqQCategory=req.getParameter("seqQcategory");
		QuestionDAO dao=new QuestionDAO();
		QuestionDTO dto=new QuestionDTO();
		
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSeqQCategory(seqQCategory);
		
		int result=dao.edit(dto);
		
		if (result==1) {
			// 질문글 수정 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/member/qna/list.do");
		} else {
			// 질문글 수정 실패 -> 경고 + 뒤로 가기
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