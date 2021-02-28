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

import com.test.bookjuck.dao.UsedBoardDAO;

@WebServlet("/admin/fleamarket/del.do")
public class Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		
		if (session.getAttribute("id").equals("adm00")) {
			
			// 1. 데이터 받아오기
			// 2. DB 작업
			
			String seq=req.getParameter("seq");
			
			UsedBoardDAO dao=new UsedBoardDAO();
			
			String path=req.getRealPath("/files/");
			
			int result=dao.del(seq, path);
			
			if (result==1) {
				// 중고거래글 삭제 성공 -> 게시판 목록으로 이동
				resp.sendRedirect("/bookjuck/admin/fleamarket/list.do");
			} else {
				// 중고거래글 삭제 실패 -> 경고 + 뒤로 가기
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