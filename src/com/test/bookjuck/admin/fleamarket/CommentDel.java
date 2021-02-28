package com.test.bookjuck.admin.fleamarket;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.CommentDAO;

@WebServlet("/admin/fleamarket/commentdel.do")
public class CommentDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		
		if (session.getAttribute("id").equals("adm00")) {
			
			// 1. 데이터 받아오기
			// 2. DB 작업
			
			// 1.
			String cseq=req.getParameter("cseq");
			String seq=req.getParameter("seq");
			
			// 2.
			CommentDAO dao=new CommentDAO();
			
			int result=dao.del(cseq);
			
			if (result==1) {
				// 댓글 삭제 성공 -> 게시판 목록으로 이동
				resp.sendRedirect("/bookjuck/admin/fleamarket/view.do?seq="+seq);
			} else {
				// 자주하는 질문 실패 -> 경고 + 뒤로 가기
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
			
		}
	}

}