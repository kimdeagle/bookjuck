package com.test.bookjuck.admin.curationletter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.MemberDAO;
import com.test.bookjuck.dto.MemberDTO;

@WebServlet("/admin/curationletter/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Add로 넘어가기 전, 고객정보 가져오기
		
		MemberDAO dao=new MemberDAO();
		ArrayList<MemberDTO> mlist=dao.getList();
		
		req.setAttribute("mlist", mlist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/curationletter/add.jsp");
		dispatcher.forward(req, resp);
	}

}