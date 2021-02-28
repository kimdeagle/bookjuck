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

@WebServlet("/member/review/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
		
		// 1. 인코딩처리
		// 2. 데이터 가져오기
		// 3. DB 작업
		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		// 2.
		String seq=req.getParameter("seq");
		String reviewTitle=req.getParameter("reviewTitle");
		String reviewContent=req.getParameter("reviewContent");
		
		ReviewDTO dto=new ReviewDTO();
		ReviewDAO dao=new ReviewDAO();
		
		dto.setSeq(seq);
		dto.setReviewTitle(reviewTitle);
		dto.setReviewContent(reviewContent);
		
		int result=dao.edit(dto);
		
		if (result==1) {
			// 독후감 수정 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/member/review/list.do");
		} else {
			// 독후감 수정 실패 -> 경고 + 뒤로 가기
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