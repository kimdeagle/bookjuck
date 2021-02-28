package com.test.bookjuck.member.review;

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
import com.test.bookjuck.dao.NoticeDAO;
import com.test.bookjuck.dao.ReviewDAO;
import com.test.bookjuck.dto.NoticeDTO;
import com.test.bookjuck.dto.ReviewDTO;

@WebServlet("/member/review/list.do")
public class ReviewList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		
		if (session.getAttribute("id")==null) {
			
			// 접근 권한 없음
			PrintWriter writer=resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('access denied');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
		}
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		//페이징
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 6;		//한페이지 당 출력 개수
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
		
		// 1. DB 작업
		// 2. JSP에게 넘겨주기
		
		// 1.
		// 회원의 독후감을 가져온다.
		String seq=session.getAttribute("seq").toString(); // 회원번호를 세션에서 가져온다.
		map.put("seq", seq);
		
		ReviewDAO rdao=new ReviewDAO();
		ArrayList<ReviewDTO> rlist=rdao.getList(map);
		
		// 1.5 페이징
		totalCount = rdao.getTotalCount(map); //총 게시물 수
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수
		
		
		String pagebar = "";
		
		loop=1;
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
		if (n == 1) {
			pagebar += String.format("<li class='disabled'>"
					+ "            <a href=\"#!\" aria-label=\"Previous\">"
					+ "                <span aria-hidden=\"true\">&laquo;</span>"
					+ "            </a>"
					+ "        </li>");
		} else {				
			pagebar += String.format("<li>"
					+ "            <a href=\"/bookjuck/member/review/list.do?page=%d\" aria-label=\"Previous\">"
					+ "                <span aria-hidden=\"true\">&laquo;</span>"
					+ "            </a>"
					+ "        </li>", n - 1);
		}
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (nowPage == n) {
				pagebar += "<li class='active'>";
			} else {
				pagebar += "<li>";
			}
			
			pagebar += String.format("<a href=\"/bookjuck/member/review/list.do?page=%d\">%d</a></li>", n, n);
			
			loop++;
			n++;
		}
		
		//다음 10페이지로 이동
		if (n > totalPage) {
			pagebar += String.format("<li class='disabled'>"
					+ "            <a href=\"#!\" aria-label=\"Next\">"
					+ "                <span aria-hidden=\"true\">&raquo;</span>"
					+ "            </a>"
					+ "        </li>");
		} else {
			pagebar += String.format("<li>"
					+ "            <a href=\"/bookjuck/member/review/list.do?page=%d\" aria-label=\"Next\">"
					+ "                <span aria-hidden=\"true\">&raquo;</span>"
					+ "            </a>"
					+ "        </li>", n);
		}
		
		// 독후감 작성할 책이 있는지 확인
		BookDAO dao=new BookDAO();
		boolean write;
		if (dao.getPossibleBook(seq).size()==0) { // 독후감 작성할 책이 없다면
			write=false;
		} else {
			write=true;
		}
		
		// 2.
		req.setAttribute("rlist", rlist);
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("write", write);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/review/list.jsp");
		dispatcher.forward(req, resp);
	}

}