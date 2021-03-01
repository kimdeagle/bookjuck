package com.test.bookjuck.admin.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.BookDAO;
import com.test.bookjuck.dto.BookDTO;


@WebServlet("/admin/book/booklist.do")
public class BookList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기
		//2. DB 작업 -> select
		//3. 결과 + JSP 호출
		
		
		HttpSession session = req.getSession();
		
		//관리자가 아니면
		if (!"adm00".equals((String)session.getAttribute("id"))) {

			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><head><meta charset='UTF-8' /></head><body>");
			writer.print("<script>");
			writer.print("alert('접근할 수 없습니다.\\n이전 화면으로 이동합니다.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;
			
		}
		
		
		//1.
		String seqLCategory = req.getParameter("seqLCategory");
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		//페이징
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 20;		//한페이지 당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작 번호
		int end = 0;			//rnum 끝 번호
		int n = 0;				//페이지바 관련 변수
		int loop = 0;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수
		
		String page = req.getParameter("page");
		
		if (page == null || page == "") {
			//기본 -> page = 1
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		map.put("seqLCategory", seqLCategory);
		
		//2.
		BookDAO dao = new BookDAO();
		
		ArrayList<BookDTO> list = dao.getAdminBookList(map);
		
		//날짜 데이터 자르기 -> 년 월 일로 변환
		for (BookDTO dto : list) {
			dto.setPubDate(dto.getPubDate().substring(0, 10));
			String temp = "";
			temp = dto.getPubDate().substring(0, 4) + "년 " + dto.getPubDate().substring(5, 7) + "월 " + dto.getPubDate().substring(8) + "일";
			dto.setPubDate(temp);
		}
		
		//총 페이지 수 계산하기
		
		//총 게시물 수 가져오기
		totalCount = dao.getAdminBookCount(map);
		
		//총 페이지 수
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		String pagebar = "";
		loop = 1;
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
		//이전 10페이지
		if (n == 1) {
			pagebar += String.format("<li class='disabled'>" + 
					"		    <a href=\"#!\" aria-label=\"Previous\">" + 
					"		        <span aria-hidden=\"true\">&laquo;</span>" + 
					"		    </a>" + 
					"		</li>");			
		} else {
			if (seqLCategory != null) {
				pagebar += String.format("<li>" + 
						"		    <a href=\"/bookjuck/admin/book/booklist.do?seqLCategory=%s&page=%d\" aria-label=\"Previous\">" + 
						"		        <span aria-hidden=\"true\">&laquo;</span>" + 
						"		    </a>" + 
						"		</li>"
						, seqLCategory
						, n - 1);
			} else {
				pagebar += String.format("<li>" + 
						"		    <a href=\"/bookjuck/admin/book/booklist.do?page=%d\" aria-label=\"Previous\">" + 
						"		        <span aria-hidden=\"true\">&laquo;</span>" + 
						"		    </a>" + 
						"		</li>"
						, n - 1);			

			}
		}
		
		
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (nowPage == n) {
				pagebar += "<li class='active'>";
			} else {
				pagebar += "<li>";
				
			}
			if (seqLCategory != null) {
				pagebar += String.format("<a href=\"/bookjuck/admin/book/booklist.do?seqLCategory=%s&page=%d\">%d</a></li> "
						, seqLCategory
						, n
						, n);
				
			} else {
				pagebar += String.format("<a href=\"/bookjuck/admin/book/booklist.do?page=%d\">%d</a></li> "
						, n
						, n);

			}
			
			loop++;
			n++;
		}
		
		//다음 10페이지로 이동
		if (n > totalPage) {
			pagebar += String.format("<li class='disabled'>" + 
					"		    <a href=\"#!\" aria-label=\"Next\">" + 
					"		        <span aria-hidden=\"true\">&raquo;</span>" + 
					"		    </a>" + 
					"		</li>");			
		} else {
			if (seqLCategory != null) {
				pagebar += String.format("<li>" + 
						"		    <a href=\"/bookjuck/admin/book/booklist.do?seqLCategory=%s&page=%d\" aria-label=\"Next\">" + 
						"		        <span aria-hidden=\"true\">&raquo;</span>" + 
						"		    </a>" + 
						"		</li>"
						, seqLCategory
						, n);			
				
			} else {
				pagebar += String.format("<li>" + 
						"		    <a href=\"/bookjuck/admin/book/booklist.do?page=%d\" aria-label=\"Next\">" + 
						"		        <span aria-hidden=\"true\">&raquo;</span>" + 
						"		    </a>" + 
						"		</li>"
						, n);			

			}
		}
		
		
		
		int wholeCnt = dao.getWholeBookCount();
		int inCnt = dao.getInternalBookCount();
		int exCnt = dao.getExternalBookCount();
		
		dao.close();
		
		//3.
		req.setAttribute("list", list);
		req.setAttribute("wholeCnt", wholeCnt);
		req.setAttribute("inCnt", inCnt);
		req.setAttribute("exCnt", exCnt);
		req.setAttribute("seqLCategory", seqLCategory);
		
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("nowPage", nowPage);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/book/booklist.jsp");
		dispatcher.forward(req, resp);
	}
	
}
