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

@WebServlet("/admin/notice/detail.do")
public class Detail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 쿼리스트링으로 넘어온 seq를 이용해서
		// 상세정보를 찾아
		// JSP에 넘겨준다.
		
		String seq=req.getParameter("seq");
		String page=req.getParameter("page");
		System.out.println(page);
		NoticeDAO dao=new NoticeDAO();
		NoticeDTO dto=dao.getInfo(seq);
		
		
		// 공지사항의 내용같은 경우는 \r\n을 <br>로 바꿔줘야 한다.
		dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		
		req.setAttribute("dto", dto);
		req.setAttribute("page", page);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/notice/detail.jsp");
		dispatcher.forward(req, resp);
	}

}