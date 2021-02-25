package com.test.bookjuck.admin.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.AuthorDAO;
import com.test.bookjuck.dao.CategoryDAO;
import com.test.bookjuck.dto.AuthorDTO;
import com.test.bookjuck.dto.CategoryDTO;


@WebServlet("/admin/book/bookadd.do")
public class BookAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기
		//2. DB 작업 -> select
		//3. 결과 + JSP호출
		
		//2.
		//카테고리별 번호, 카테고리명
		CategoryDAO cdao = new CategoryDAO();
		ArrayList<CategoryDTO> lCategoryList = cdao.getLCategoryList();
		ArrayList<CategoryDTO> mCategoryList = cdao.getMCategoryList();
		ArrayList<CategoryDTO> sCategoryList = cdao.getSCategoryList();
		
		
		//작가번호, 작가명, 작가소개
		AuthorDAO adao = new AuthorDAO();
		ArrayList<AuthorDTO> alist = adao.getAuthorList();
		
		for (AuthorDTO adto : alist) {
			adto.setIntro(adto.getIntro().replace("\r\n", "<br>"));
			adto.setIntro(adto.getIntro().replace("\n", "<br>"));
		}
		
		cdao.close();
		adao.close();
		
		//3.
		req.setAttribute("lCategoryList", lCategoryList);
		req.setAttribute("mCategoryList", mCategoryList);
		req.setAttribute("sCategoryList", sCategoryList);
		req.setAttribute("alist", alist);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/book/bookadd.jsp");
		dispatcher.forward(req, resp);
	}
	
}
