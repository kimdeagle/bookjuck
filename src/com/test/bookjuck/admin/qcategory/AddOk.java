package com.test.bookjuck.admin.qcategory;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.QCategoryDAO;

@WebServlet("/admin/qcategory/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		
		if (!session.getAttribute("id").equals("adm00")) {
			
			// 접근 권한 없음
			PrintWriter writer=resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('access denied');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;
			
		}
		
		// 1. 인코딩
		// 2. 데이터 가져오기
		// 3. DB 작업
		
		req.setCharacterEncoding("UTF-8");
		
		String category=req.getParameter("addcategory");
		
		QCategoryDAO dao=new QCategoryDAO();
		
		int result=dao.add(category);
		
		if (result==1) {
			// 카테고리 추가 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/admin/qcategory/list.do");
		} else {
			// 카테고리 추가 실패 -> 경고 + 뒤로 가기
			PrintWriter writer=resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;
			
		}
	}

}