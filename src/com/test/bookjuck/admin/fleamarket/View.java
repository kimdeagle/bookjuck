package com.test.bookjuck.admin.fleamarket;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.CommentDAO;
import com.test.bookjuck.dao.UsedBoardDAO;
import com.test.bookjuck.dto.CommentDTO;
import com.test.bookjuck.dto.UsedBoardDTO;

@WebServlet("/admin/fleamarket/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		
		if (session.getAttribute("id").equals("adm00")) {
			// 1. 쿼리스트링으로 넘어온 데이터 받기
			// 2. DB에서 데이터 가져오기
			
			// 1.
			String seq=req.getParameter("seq"); // 중고게시판 글번호
			String page=req.getParameter("page"); // 몇번째 페이지에서 들어왔는지
			String fleamarketsearch=req.getParameter("fleamarketsearch");
			
			// 2-1. 글정보 가져오기
			UsedBoardDAO dao=new UsedBoardDAO();
			UsedBoardDTO dto=dao.get(seq);
			
			// 2-2. 글번호에 따른 코멘트정보 가져오기
			CommentDAO cdao=new CommentDAO();
			ArrayList<CommentDTO> clist=cdao.getList(seq);
			
			req.setAttribute("dto", dto);
			req.setAttribute("clist", clist);
			req.setAttribute("page", page);
			req.setAttribute("fleamarketsearch", fleamarketsearch);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/fleamarket/view.jsp");
			dispatcher.forward(req, resp);
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