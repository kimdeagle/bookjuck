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

@WebServlet("/member/inc/category.do")
public class Category extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 데이터 가져오기(seqLCategory, seqMCategory, seqSCategory)
		//2. DB 작업 -> select
		//3. 결과 + JSP 호출
		
		//1.
		String seqLCategory = request.getParameter("seqLCategory");
		String seqMCategory = request.getParameter("seqMCategory");
		
		//String lCategory = request.getParameter("lCategory");
		//String mCategory = request.getParameter("mCategory");
		
		//2.
		CategoryDAO dao = new CategoryDAO();
		
		ArrayList<CategoryDTO> mCategoryList = dao.mCategoryList();
		ArrayList<CategoryDTO> sCategoryList = dao.sCategoryList(seqLCategory, seqMCategory);
		
		
		request.setAttribute("seqLCategory", seqLCategory);
		request.setAttribute("seqMCategory", seqMCategory);
		
		//request.setAttribute("lCategory", lCategory);
		//request.setAttribute("mCategory", mCategory);
		
		request.setAttribute("mCategoryList", mCategoryList);
		request.setAttribute("sCategoryList", sCategoryList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/inc/category.jsp");
		dispatcher.include(request, response);
		
	}

}
