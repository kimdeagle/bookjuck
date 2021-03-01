package com.test.bookjuck.admin.custmng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.LetterLogDAO;
import com.test.bookjuck.dao.MemberDAO;
import com.test.bookjuck.dto.LetterLogDTO;
import com.test.bookjuck.dto.MemberDTO;

//http://localhost:8090/bookjuck/admin/custmng/custview.do
@WebServlet("/admin/custmng/custview.do")
public class CustView extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/custmng/custview.jsp");
		dispatcher.forward(req, resp);
		
	}

}
