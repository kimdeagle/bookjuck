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
import com.test.bookjuck.dto.UsedBoardDTO;

@WebServlet("/member/fleamarket/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String dealState = req.getParameter("dealState");
		
		String seq = req.getParameter("seq"); //수정할 글 번호
		
		
		//2.
		UsedBoardDAO dao = new UsedBoardDAO();
		UsedBoardDTO dto = new UsedBoardDTO();
		
		dto.setTitle(title);
		dto.setContent(content);
		dto.setDealState(dealState);
		dto.setSeq(seq);	//글 번호
		
		int result = dao.edit(dto);
		
		if (result == 1) {
			
			resp.sendRedirect("/bookjuck/member/fleamarket/view.do?seq=" + seq);
		} else {
			//글수정 실패 -> 경고 + 뒤로가기
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
