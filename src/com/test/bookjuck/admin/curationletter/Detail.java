package com.test.bookjuck.admin.curationletter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.LetterDAO;
import com.test.bookjuck.dto.LetterDTO;

@WebServlet("/admin/curationletter/detail.do")
public class Detail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 어떤 큐레이션 레터를 선택했는지 번호를 받아와서
		// DB에서 레터 정보 꺼내오기
		
		String seq=req.getParameter("seq");
		String page=req.getParameter("page");
		
		LetterDAO dao=new LetterDAO();
		LetterDTO dto=dao.getInfo(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("page", page);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/curationletter/detail.jsp");
		dispatcher.forward(req, resp);
	}

}