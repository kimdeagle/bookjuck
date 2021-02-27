package com.test.bookjuck.member.fleamarket;

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

@WebServlet("/member/fleamarket/deleteok.do")
public class DeleteOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		HttpSession session = req.getSession();
		
		//1.
		req.setCharacterEncoding("UTF-8");
		String path=req.getRealPath("/files/");
		
		String seq = req.getParameter("seq");	// 삭제할 글 번호
		
		
		//2.
		UsedBoardDAO dao = new UsedBoardDAO();

		
		int result = dao.del(seq, path); // 글삭제하기
		
		
		if (result == 1) {
			
			//글삭제 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/member/fleamarket/list.do");
			
			
		} else {
			//글삭제 실패 -> 경고 + 뒤로가기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
		}

		
	}

}
