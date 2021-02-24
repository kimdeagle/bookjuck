package com.test.bookjuck.member.inc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.CategoryDAO;
import com.test.bookjuck.dto.CategoryDTO;

@WebServlet("/member/inc/header.do")
public class Header extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. DB 작업 -> select
		//2. 결과 + JSP 호출
		
		//1.
		CategoryDAO dao = new CategoryDAO();
		
		ArrayList<CategoryDTO> mCategoryList = dao.mCategoryList();
		
		request.setAttribute("mCategoryList", mCategoryList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/inc/header.jsp");
		dispatcher.include(request, response);
		
	}

}
