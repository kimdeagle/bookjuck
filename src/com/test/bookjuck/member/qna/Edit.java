package com.test.bookjuck.member.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.QuestionDAO;
import com.test.bookjuck.dto.QuestionDTO;

@WebServlet("/member/qna/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq=req.getParameter("seq"); // QnA 글번호
		
		// 글번호를 이용해서
		// QnA 질문글을 가져온다.
		
		// 질문
		QuestionDAO dao=new QuestionDAO();
		QuestionDTO dto=dao.getInfo(seq);
		
		req.setAttribute("dto", dto);

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/qna/edit.jsp");
		dispatcher.forward(req, resp);
	}

}