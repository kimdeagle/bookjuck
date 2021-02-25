package com.test.bookjuck.admin.faq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.FAQDAO;

@WebServlet("/admin/faq/del.do")
public class Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq=req.getParameter("seq");
		FAQDAO dao=new FAQDAO();
		
		int result=dao.del(seq);
		
		if (result==1) {
			// 자주하는 질문 추가 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/admin/faq/list.do");
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
	}

}