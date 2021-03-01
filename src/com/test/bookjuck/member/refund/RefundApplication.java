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

import com.test.bookjuck.dao.BaroOrderDAO;
import com.test.bookjuck.dao.BookOrderDAO;
import com.test.bookjuck.dao.EBookOrderDAO;
import com.test.bookjuck.dto.BookOrderDetailDTO;

@WebServlet("/member/refund/refundapplication.do")
public class RefundApplication extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//type - 1 : 일반배송, 2 : 바로드림, 3 : E-book
		String type = req.getParameter("type");
		String seqOrder = req.getParameter("seqOrder");
		
		
		BookOrderDetailDTO dto;
		
		if (type.equals("1")) {
			BookOrderDAO bdao = new BookOrderDAO();
			dto = bdao.getOrder(seqOrder); 
			
		} else if (type.equals("2")) {
			BaroOrderDAO badao = new BaroOrderDAO();
			dto = badao.getOrder(seqOrder); 
			
		} else {
			EBookOrderDAO edao = new EBookOrderDAO();
			dto = edao.getOrder(seqOrder); 
		}
		
		

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
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/refund/refundapplication.jsp");
		dispatcher.forward(req, resp);

	}

}

