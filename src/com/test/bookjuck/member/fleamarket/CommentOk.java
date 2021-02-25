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
import com.test.bookjuck.dto.CommentDTO;


@WebServlet("/member/fleamarket/commentok.do")
public class CommentOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		
		//1.
		String seqUsedBoard = req.getParameter("seqUsedBoard");
		String ccontent = req.getParameter("ccontent");
		
		System.out.println(seqUsedBoard);
		System.out.println(ccontent);
		System.out.println((String)session.getAttribute("seq"));
		
		//2.
		UsedBoardDAO dao = new UsedBoardDAO();
		CommentDTO dto = new CommentDTO();
		
		dto.setCcontent(ccontent);
		dto.setSeqUsedBoard(seqUsedBoard);
		dto.setSeqMember((String)session.getAttribute("seq"));
		
		int result = dao.writeComment(dto);
		
		//3.
		if (result == 1) {
			//글쓰기 성공
			resp.sendRedirect("/bookjuck/member/fleamarket/view.do?seq=" + seqUsedBoard);
			
		} else {
			//글쓰기 실패 -> 경고 + 뒤로 가기
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
