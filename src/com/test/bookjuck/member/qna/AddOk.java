package com.test.bookjuck.member.qna;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.QuestionDAO;
import com.test.bookjuck.dto.QuestionDTO;

@WebServlet("/member/qna/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 인코딩처리
		// 2. DB 작업
		// 3. 결과처리
		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		String seqQcategory=req.getParameter("seqQcategory");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		QuestionDAO dao=new QuestionDAO();
		QuestionDTO dto=new QuestionDTO();
		
		dto.setSeqQCategory(seqQcategory);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSeqMember("21"); // TODO 세션에서 얻어올 회원번호
		
		int result=dao.add(dto);
		
		if (result==1) {
			// 답변글 추가 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/member/qna/list.do");
		} else {
			// 답변글 추가 실패 -> 경고 + 뒤로 가기
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