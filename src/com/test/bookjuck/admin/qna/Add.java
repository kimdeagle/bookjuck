package com.test.bookjuck.admin.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.AnswerDAO;

@WebServlet("/admin/qna/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq=req.getParameter("seq");
		
		req.setAttribute("qseq", req.getParameter(seq));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/qna/add.jsp");
		dispatcher.forward(req, resp);
	}

}