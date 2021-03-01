package com.test.bookjuck.admin.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.BookDAO;

@WebServlet("/admin/book/bookdelok.do")
public class BookDelOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 받아오기(seq)
		//2. DB 작업 -> delete
		//3. 결과
		
		//1.
		String seq = req.getParameter("seq");
		
		//2.
		//주문내역, 독후감이 있는지?
		//tblBookOrderDetail
		//tblBaroOrderDetail
		//tblReview
		//있으면 삭제X
		//없으면 삭제O
		// - tblInventory, tblBookCart, tblBaroCart, tblBook 순차 삭제
		
		BookDAO dao = new BookDAO();
		
		boolean isOrderOrReview = dao.isOrderOrReview(seq);
		
		if (!isOrderOrReview) {
			//주문,독후감X -> 삭제O
			// - tblInventory, tblBookCart, tblBaroCart, tblBook 순차 삭제
			int result = dao.del(seq);
			
			if (result == 1) {
				resp.setCharacterEncoding("UTF-8");
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><head><meta charset='UTF-8' /></head><body>");
				writer.print("<script>");
				writer.print("alert('도서 삭제 성공!\\n도서 리스트로 이동합니다.');");
				writer.print("location.href='/bookjuck/admin/book/booklist.do';");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();
				
			} else {
				resp.setCharacterEncoding("UTF-8");
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><head><meta charset='UTF-8' /></head><body>");
				writer.print("<script>");
				writer.print("alert('도서 삭제 실패..\\n이전 화면으로 이동합니다.');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();
				
			}
			
		} else {
			//주문, 독후감O -> 삭제X
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><head><meta charset='UTF-8' /></head><body>");
			writer.print("<script>");
			writer.print("alert('도서 삭제 실패..\\n이전 화면으로 이동합니다.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
		}

	}

}