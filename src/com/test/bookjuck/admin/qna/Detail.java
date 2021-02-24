package com.test.bookjuck.admin.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.AnswerDAO;
import com.test.bookjuck.dao.QuestionDAO;
import com.test.bookjuck.dto.AnswerDTO;
import com.test.bookjuck.dto.QuestionDTO;

@WebServlet("/admin/qna/detail.do")
public class Detail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq=req.getParameter("seq"); // QnA 글번호
		
		// 글번호를 이용해서
		// QnA 질문, 답변을 가져온다. (질문, 답변 따로)
		
		// 질문
		QuestionDAO qdao=new QuestionDAO();
		QuestionDTO qdto=qdao.getInfo(seq);
		
		// 답변
		AnswerDAO adao=new AnswerDAO();
		AnswerDTO adto=adao.getInfo(seq);
		
		req.setAttribute("adto", adto);
		req.setAttribute("qdto", qdto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/qna/detail.jsp");
		dispatcher.forward(req, resp);
	}

}