package com.test.bookjuck.admin.qcategory;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.QCategoryDAO;
import com.test.bookjuck.dto.QCategoryDTO;

@WebServlet("/admin/qcategory/list.do")
public class QCategoryList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 현재 존재하는 질문카테고리를 가져온다.
		
		QCategoryDAO dao=new QCategoryDAO();
		ArrayList<QCategoryDTO> clist=dao.getList();
		
		req.setAttribute("clist", clist);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/qcategory/list.jsp");
		dispatcher.forward(req, resp);
	}

}