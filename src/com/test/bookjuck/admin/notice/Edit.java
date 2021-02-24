package com.test.bookjuck.admin.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.NoticeDAO;
import com.test.bookjuck.dto.NoticeDTO;

@WebServlet("/admin/notice/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 쿼리스트링으로 넘어온 seq를 이용해서
		// 상세정보를 찾아
		// JSP에 넘겨준다.
		
		String seq=req.getParameter("seq");
		
		NoticeDAO dao=new NoticeDAO();
		NoticeDTO dto=dao.getInfo(seq);
		
		req.setAttribute("dto", dto);
				
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/notice/edit.jsp");
		dispatcher.forward(req, resp);
	}

}