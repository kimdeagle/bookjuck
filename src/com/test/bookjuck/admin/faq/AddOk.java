package com.test.bookjuck.admin.faq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.FAQDAO;
import com.test.bookjuck.dto.FAQDTO;

@WebServlet("/admin/faq/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 1차적으로 관리자 접속이 맞는지 확인
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
			
		// 1. add.jsp에서 보낸 데이터 받아오기
		// 2. DB와 연결해서 insert
		// 3. 결과
		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		String seq=req.getParameter("seq");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String seqQcategory=req.getParameter("seqQcategory");
		FAQDTO dto=new FAQDTO();
		FAQDAO dao=new FAQDAO();
		
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSeqQcategory(seqQcategory); // 질문카테고리번호
		
		int result=dao.add(dto);
		
		if (result==1) {
			// 자주하는 질문 추가 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/admin/faq/list.do");
		} else {
			// 자주하는 질문 실패 -> 경고 + 뒤로 가기
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
		
	}

}