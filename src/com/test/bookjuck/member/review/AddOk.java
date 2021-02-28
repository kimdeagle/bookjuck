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

@WebServlet("/member/review/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 인코딩처리
		// 2. 데이터가져오기
		// 3. DB 작업
		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		// 2.
		ReviewDTO dto=new ReviewDTO();
		
		String seqBook=req.getParameter("seqbook");
		String reviewTitle=req.getParameter("reviewTitle");
		String reviewContent=req.getParameter("reviewContent");	
		
		dto.setSeqBook(seqBook);
		dto.setReviewTitle(reviewTitle);
		dto.setReviewContent(reviewContent);
		
		// 회원번호 가져와서 같이 넣기
//		HttpSession session=req.getSession();
//		String mseq=session.getAttribute("seq").toString();
//		dto.setSeqMember(mseq);
		// TODO 현재는 임의로 23번으로 넣는다.
		dto.setSeqMember("23");
		
		ReviewDAO dao=new ReviewDAO();
		
		int result=dao.add(dto);
		
		if (result==1) {
			// 독후감 추가 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/member/review/list.do");
		} else {
			// 독후감 추가 실패 -> 경고 + 뒤로 가기
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