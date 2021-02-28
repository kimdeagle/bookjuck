package com.test.bookjuck.admin.review;

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

@WebServlet("/admin/review/prize.do")
public class Prize extends HttpServlet {

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
				
		// 1. 우수독후감으로 선정할 독후감의 번호를 가져온다.
		// 2. DB 작업
		
		// 1.
		String seq=req.getParameter("seq");
		
		// 2.
		ReviewDAO dao=new ReviewDAO();
		
		int result=dao.prize(seq);
		
		if (result==1) {
			// 우수독후감 선정 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/admin/review/list.do");
		} else {
			// 우수독후감 선정 실패 -> 경고 + 뒤로 가기
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