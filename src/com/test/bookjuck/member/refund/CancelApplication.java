package com.test.bookjuck.member.refund;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.BookOrderDAO;
import com.test.bookjuck.dto.BookOrderDetailDTO;

import sun.awt.RepaintArea;

@WebServlet("/member/refund/cancelapplication.do")
public class CancelApplication extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//type - 1 : 일반배송, 2 : 바로드림, 3 : E-book
		String type = req.getParameter("type");
		String seqOrder = req.getParameter("seqOrder");
		
		BookOrderDAO dao = new BookOrderDAO();
		BookOrderDetailDTO dto = dao.getOrder(seqOrder); 
		

		//로그인 안한 사람이 접근할 때 내 쫓기
		HttpSession session = req.getSession();
		
		if (session.getAttribute("id") == null) {

			
			//경고(JavaScript) 후 내쫓기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("location.href='/bookjuck/index.do';");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			
		}
		
		req.setAttribute("dto", dto);
		req.setAttribute("type", type);
		req.setAttribute("seqOrder", seqOrder);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/refund/cancelapplication.jsp");
		dispatcher.forward(req, resp);

	}

}
