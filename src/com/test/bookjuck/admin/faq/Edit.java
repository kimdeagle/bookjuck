package com.test.bookjuck.admin.faq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.FAQDAO;
import com.test.bookjuck.dao.QCategoryDAO;
import com.test.bookjuck.dto.FAQDTO;
import com.test.bookjuck.dto.QCategoryDTO;

@WebServlet("/admin/faq/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// edit으로 넘어가기 전에
		// edit에서 사용할 질문카테고리 데이터를 받아와야 한다.
		
		QCategoryDAO cdao=new QCategoryDAO();
		ArrayList<QCategoryDTO> clist=cdao.getList();
		
		req.setAttribute("clist", clist);
		
		// 모달창에서 받아온 seq로 수정할 글 찾기
		
		String seq=req.getParameter("seq");
		
		FAQDAO dao=new FAQDAO();
		FAQDTO dto=dao.getInfo(seq);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/faq/edit.jsp");
		dispatcher.forward(req, resp);
	}

}