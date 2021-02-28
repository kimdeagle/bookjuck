package com.test.bookjuck.admin.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
import com.test.bookjuck.dto.BaroOrderDTO;
import com.test.bookjuck.dto.BookOrderDTO;
import com.test.bookjuck.dto.EBookOrderDTO;

@WebServlet("/admin/order/orderlist.do")
public class OrderList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		String ordernumsearch = req.getParameter("ordernumsearch");	//검색하려는 주문번호
		String idsearch = req.getParameter("idsearch");				//검색하려는 주문자id
		String booksearch = req.getParameter("booksearch");			//검색하려는 주문상품명 (책 제목)
		
				
				
		String type = "1";
		
		if (req.getParameter("type") != null) {
			type = req.getParameter("type");
		}
		
		
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
	
		System.out.println(type + startDate  + endDate );
		
		
		
		//1. DB 작업 -> select
		//2. 목록 반환 + JSP 전달 후 호출하기
		
		HttpSession session = req.getSession();
		
		
		//페이징
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수 
		int pageSize = 20;		//한 페이지당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작번호
		int end = 0;			//rnum 끝번호
		int n = 0;				//페이지바 관련 변수
		int loop = 0;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수
		
		//list.do
		//list.do -> list.do?page=1 : 1페이지 보여줘
		//list.do -> list.do?page=2 : 2페이지 보여줘
		
		String page = req.getParameter("page");
		
		if (page == null || page == "") {
			//기본 -> page = 1
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		// 이 이후로는 nowPage가 현재 보려는 페이지 번호다!!
		//1page -> where rnum between 1 and 10
		//2page -> where rnum between 11 and 20
		//3page -> where rnum between 21 and 30
		
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		//HashMap에 정보를 넘겨
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		
		String pagebar = "";
		
		//1.
		ArrayList<BookOrderDTO> blist = new ArrayList<BookOrderDTO>();
		ArrayList<BaroOrderDTO> balist = new ArrayList<BaroOrderDTO>();
		ArrayList<EBookOrderDTO> elist = new ArrayList<EBookOrderDTO>();
		
		
		
		if (type.equals("1")) {
			
			BookOrderDAO dao = new BookOrderDAO();	
			blist = dao.adminlist(map);	
			
			//1.5 데이터 조작할 것
			for (BookOrderDTO dto : blist) {
				
				//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
				dto.setOrderDate(dto.getOrderDate().substring(0, 10));
				
				//글 제목이 너무 길면 자르기
				if (dto.getTitle().length() > 32) {
					dto.setTitle(dto.getTitle().substring(0, 32) + "...");
				}
				
			}
			
			//페이징
			totalCount = dao.getATotalCount(map); //총 게시물 수
			System.out.println(totalCount);		//269개
			
			//totalPage = totalCount / pageSize + 1; //총 페이지 수
			totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수
			System.out.println(totalPage);		//26페이지 -(ceil)-> 27페이지
			
			
			
			
			loop = 1;
			n = ((nowPage - 1) / blockSize) * blockSize + 1;
			
			
			//이전 10페이지로
			if(n == 1) {
				pagebar += String.format("<li class='disabled'>"
							+ "            <a href=\"#!\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>");
			} else {
				pagebar += String.format("<li>"
							+ "            <a href=\"/bookjuck/admin/order/orderlist.do?page=%d\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>", n - 1);			
			}
			
			
			
			while (!(loop > blockSize || n > totalPage)) {

				if (nowPage == n) {
					pagebar += "<li class='active'>";
				} else {
					pagebar += "<li>";
				}
				pagebar += String.format("<a href=\"/bookjuck/admin/order/orderlist.do?page=%d\">%d</a></li> ", n, n);

				loop++;
				n++;

			}
			
			
			//다음 10페이지로 이동
			if (n > totalPage) {
				pagebar += String.format("<li class='disabled'>"
							+ "            <a href=\"#!\" aria-label=\"Next\">"
							+ "                <span aria-hidden=\"true\">&raquo;</span>"
							+ "            </a>"
							+ "          </li> ");
				//a href = "#" 본인 페이지 항상 위, "#!" 위로 올라가는 현상 사라짐
			} else {
				pagebar += String.format("<li>"
						+ "            <a href=\"/bookjuck/admin/order/orderlist.do?page=%d\" aria-label=\"Next\">"
						+ "                <span aria-hidden=\"true\">&raquo;</span>"
						+ "            </a>"
						+ "          </li> ", n);
			}
			
			

			req.setAttribute("pagebar", pagebar);
			req.setAttribute("nowPage", nowPage);
			
			
		} else if (type.equals("2")) {
			
			BaroOrderDAO dao = new BaroOrderDAO();	
			balist = dao.adminlist(map);	
			
			//1.5 데이터 조작할 것
			for (BaroOrderDTO dto : balist) {
				
				//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
				dto.setOrderDate(dto.getOrderDate().substring(0, 10));
				
				//글 제목이 너무 길면 자르기
				if (dto.getTitle().length() > 32) {
					dto.setTitle(dto.getTitle().substring(0, 32) + "...");
				}
			}
			
			
			//페이징
			totalCount = dao.getATotalCount(map); //총 게시물 수
			System.out.println(totalCount);		//269개
			
			//totalPage = totalCount / pageSize + 1; //총 페이지 수
			totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수
			System.out.println(totalPage);		//26페이지 -(ceil)-> 27페이지
			
			
			//String pagebar = "";
			
			loop = 1;
			n = ((nowPage - 1) / blockSize) * blockSize + 1;
			
			//이전 10페이지로
			if(n == 1) {
				pagebar += String.format("<li class='disabled'>"
							+ "            <a href=\"#!\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>");
			} else {
				pagebar += String.format("<li>"
							+ "            <a href=\"/codestudy/board/list.do?page=%d\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>", n - 1);			
			}
			
			
			
			while (!(loop > blockSize || n > totalPage)) {

				if (nowPage == n) {
					pagebar += "<li class='active'>";
				} else {
					pagebar += "<li>";
				}
				pagebar += String.format("<a href=\"/codestudy/board/list.do?page=%d\">%d</a></li> ", n, n);

				loop++;
				n++;

			}
			
			
			//다음 10페이지로 이동
			if (n > totalPage) {
				pagebar += String.format("<li class='disabled'>"
							+ "            <a href=\"#!\" aria-label=\"Next\">"
							+ "                <span aria-hidden=\"true\">&raquo;</span>"
							+ "            </a>"
							+ "          </li> ");
				//a href = "#" 본인 페이지 항상 위, "#!" 위로 올라가는 현상 사라짐
			} else {
				pagebar += String.format("<li>"
						+ "            <a href=\"/codestudy/board/list.do?page=%d\" aria-label=\"Next\">"
						+ "                <span aria-hidden=\"true\">&raquo;</span>"
						+ "            </a>"
						+ "          </li> ", n);
			}
			
			
			
			
		} else {
			
			EBookOrderDAO dao = new EBookOrderDAO();	
			elist = dao.adminlist(map);	
			
			//1.5 데이터 조작할 것
			for (EBookOrderDTO dto : elist) {
				
				//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
				dto.setOrderDate(dto.getOrderDate().substring(0, 10));
				
				//글 제목이 너무 길면 자르기
				if (dto.getTitle().length() > 30) {
					dto.setTitle(dto.getTitle().substring(0, 30) + "...");
				}
			}
			
			//페이징
			totalCount = dao.getATotalCount(map); //총 게시물 수
			System.out.println(totalCount);		//269개
			
			//totalPage = totalCount / pageSize + 1; //총 페이지 수
			totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수
			System.out.println(totalPage);		//26페이지 -(ceil)-> 27페이지
			
			
			//String pagebar = "";
			
			
			loop = 1;
			n = ((nowPage - 1) / blockSize) * blockSize + 1;
			
			
			//이전 10페이지로
			if(n == 1) {
				pagebar += String.format("<li class='disabled'>"
							+ "            <a href=\"#!\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>");
			} else {
				pagebar += String.format("<li>"
							+ "            <a href=\"/codestudy/board/list.do?page=%d\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>", n - 1);			
			}
			
			
			
			while (!(loop > blockSize || n > totalPage)) {

				if (nowPage == n) {
					pagebar += "<li class='active'>";
				} else {
					pagebar += "<li>";
				}
				pagebar += String.format("<a href=\"/codestudy/board/list.do?page=%d\">%d</a></li> ", n, n);

				loop++;
				n++;

			}
			
			
			//다음 10페이지로 이동
			if (n > totalPage) {
				pagebar += String.format("<li class='disabled'>"
							+ "            <a href=\"#!\" aria-label=\"Next\">"
							+ "                <span aria-hidden=\"true\">&raquo;</span>"
							+ "            </a>"
							+ "          </li> ");
				//a href = "#" 본인 페이지 항상 위, "#!" 위로 올라가는 현상 사라짐
			} else {
				pagebar += String.format("<li>"
						+ "            <a href=\"/codestudy/board/list.do?page=%d\" aria-label=\"Next\">"
						+ "                <span aria-hidden=\"true\">&raquo;</span>"
						+ "            </a>"
						+ "          </li> ", n);
			}
			
			
			
		}
		
		
		
		
		
		//2.
		req.setAttribute("blist", blist);
		req.setAttribute("balist", balist);
		req.setAttribute("elist", elist);
		
		req.setAttribute("type", type);
		


		
		System.out.println(pagebar + nowPage);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/order/orderlist.jsp");
		dispatcher.forward(req, resp);
	}

}