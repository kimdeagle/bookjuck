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

@WebServlet("/member/review/del.do")
public class Del extends HttpServlet {

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
			
			return;
			
		}
		
		// 쿼리스트링으로 넘어온 seq를 이용해서
		// 삭제
		
		String seq=req.getParameter("seq");
		ReviewDTO dto=new ReviewDTO();
		ReviewDAO dao=new ReviewDAO();
		
		// 상세정보를 찾아
		// 글쓴 회원과 일치하는지 확인
		dto=dao.getInfo(seq);
		
		// 일치하지 않으면 접근 못하게 한다.
		if (dto.getSeqMember().equals(session.getAttribute("seq"))) {
			
			int result=dao.del(seq);
			
			if (result==1) {
				// 독후감 삭제 성공 -> 게시판 목록으로 이동
				resp.sendRedirect("/bookjuck/member/review/list.do");
			} else {
				// 독후감 삭제 실패 -> 경고 + 뒤로 가기
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