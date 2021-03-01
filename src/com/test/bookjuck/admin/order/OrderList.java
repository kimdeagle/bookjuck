package com.test.bookjuck.admin.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		HashMap<String,String> map = new HashMap<String,String>();

		map.put("id", id);		//session id 담기
		
		String ordernumsearch = req.getParameter("ordernumsearch");	//검색하려는 주문번호
		String idsearch = req.getParameter("idsearch");				//검색하려는 주문자id
		String booksearch = req.getParameter("booksearch");			//검색하려는 주문상품명 (책 제목)
		
				
		String type = "1";
		
		if (req.getParameter("type") != null) {
			type = req.getParameter("type");
		}
		
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
	

		//관리자] 초기검색 상태 기간 조회 : 3달전 ~ 현재 까지로 만들기
		if (startDate == null) {
			Date date = new Date();
			Date caldate = new Date();
			caldate.setMonth(date.getMonth() - 3); 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-MM-dd HH:mm:ss 
			startDate = formatter.format(caldate);
		}
		
		if (endDate == null) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-MM-dd HH:mm:ss 
			endDate = formatter.format(date);
		}
		
		
		//where절을 구성할 검색어들 map에 넣기
		if ( !(startDate == null || startDate.equals("")) ) {
			map.put("startDate", startDate);
		}
		
		if ( !(endDate == null || endDate.equals("")) ) {
			map.put("endDate", endDate);
		}	
		
		if ( !(ordernumsearch == null || ordernumsearch.equals("")) ) {
			map.put("ordernumsearch", ordernumsearch);
		}	
		
		if ( !(idsearch == null || idsearch.equals("")) ) {
			map.put("idsearch", idsearch);
		}	
		
		if ( !(booksearch == null || booksearch.equals("")) ) {
			map.put("booksearch", booksearch);
		}	
		
		
		
		
		//1. DB 작업 -> select
		//2. 목록 반환 + JSP 전달 후 호출하기
		
		
		
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
			
			String isRefundList = "where ";
			
			blist = dao.adminlist(map, isRefundList);	
			
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
			totalCount = dao.getATotalCount(map, isRefundList); //총 게시물 수
			totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수

			
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
							+ "            <a href=\"/bookjuck/admin/order/orderlist.do?type=%d&page=%d&startDate=%s&endDate=%s&ordernumsearch=%s&idsearch=%s&booksearch=%s\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>", 1, n - 1, startDate, endDate, ordernumsearch, idsearch, booksearch);
				
			}
			
			
			
			while (!(loop > blockSize || n > totalPage)) {

				if (nowPage == n) {
					pagebar += "<li class='active'>";
				} else {
					pagebar += "<li>";
				}
				pagebar += String.format("<a href=\"/bookjuck/admin/order/orderlist.do?type=%d&page=%d&startDate=%s&endDate=%s&ordernumsearch=%s&idsearch=%s&booksearch=%s\">%d</a></li> ", 1, n, startDate, endDate, ordernumsearch, idsearch, booksearch, n);
				
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
						+ "            <a href=\"/bookjuck/admin/order/orderlist.do?type=%d&page=%d&startDate=%s&endDate=%s&ordernumsearch=%s&idsearch=%s&booksearch=%s\" aria-label=\"Next\">"
						+ "                <span aria-hidden=\"true\">&raquo;</span>"
						+ "            </a>"
						+ "          </li> ", 1, n, startDate, endDate, ordernumsearch, idsearch, booksearch);
			}
			
			

			req.setAttribute("pagebar", pagebar);
			req.setAttribute("nowPage", nowPage);
			
			
		} else if (type.equals("2")) {
			
			BaroOrderDAO dao = new BaroOrderDAO();
			
			String isRefundList = "where ";
			
			balist = dao.adminlist(map, isRefundList);	
			
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
			totalCount = dao.getATotalCount(map, isRefundList); //총 게시물 수

			//totalPage = totalCount / pageSize + 1; //총 페이지 수
			totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수

			
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
							+ "            <a href=\"/bookjuck/admin/order/orderlist.do?type=%d&page=%d&startDate=%s&endDate=%s&ordernumsearch=%s&idsearch=%s&booksearch=%s\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>", 2, n - 1, startDate, endDate, ordernumsearch, idsearch, booksearch);
				
			}
			
			
			
			while (!(loop > blockSize || n > totalPage)) {

				if (nowPage == n) {
					pagebar += "<li class='active'>";
				} else {
					pagebar += "<li>";
				}
				pagebar += String.format("<a href=\"/bookjuck/admin/order/orderlist.do?type=%d&page=%d&startDate=%s&endDate=%s&ordernumsearch=%s&idsearch=%s&booksearch=%s\">%d</a></li> ", 2, n, startDate, endDate, ordernumsearch, idsearch, booksearch, n);
				
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
						+ "            <a href=\"/bookjuck/admin/order/orderlist.do?type=%d&page=%d&startDate=%s&endDate=%s&ordernumsearch=%s&idsearch=%s&booksearch=%s\" aria-label=\"Next\">"
						+ "                <span aria-hidden=\"true\">&raquo;</span>"
						+ "            </a>"
						+ "          </li> ", 2, n, startDate, endDate, ordernumsearch, idsearch, booksearch);
			}
			
			req.setAttribute("pagebar", pagebar);
			req.setAttribute("nowPage", nowPage);
			
			
			
		} else {
			
			EBookOrderDAO dao = new EBookOrderDAO();	
			
			String isRefundList = "where ";
			
			elist = dao.adminlist(map, isRefundList);	
			
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
			totalCount = dao.getATotalCount(map, isRefundList); //총 게시물 수
			
			//totalPage = totalCount / pageSize + 1; //총 페이지 수
			totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수
			
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
							+ "            <a href=\"/bookjuck/admin/order/orderlist.do?type=%d&page=%d&startDate=%s&endDate=%s&ordernumsearch=%s&idsearch=%s&booksearch=%s\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>", 3, n - 1, startDate, endDate, ordernumsearch, idsearch, booksearch);
				
			}
			
			
			
			while (!(loop > blockSize || n > totalPage)) {

				if (nowPage == n) {
					pagebar += "<li class='active'>";
				} else {
					pagebar += "<li>";
				}
				pagebar += String.format("<a href=\"/bookjuck/admin/order/orderlist.do?type=%d&page=%d&startDate=%s&endDate=%s&ordernumsearch=%s&idsearch=%s&booksearch=%s\">%d</a></li> ", 3, n, startDate, endDate, ordernumsearch, idsearch, booksearch, n);
				
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
						+ "            <a href=\"/bookjuck/admin/order/orderlist.do?type=%d&page=%d&startDate=%s&endDate=%s&ordernumsearch=%s&idsearch=%s&booksearch=%s\" aria-label=\"Next\">"
						+ "                <span aria-hidden=\"true\">&raquo;</span>"
						+ "            </a>"
						+ "          </li> ", 3, n, startDate, endDate, ordernumsearch, idsearch, booksearch);
			}
			

			req.setAttribute("pagebar", pagebar);
			req.setAttribute("nowPage", nowPage);
			
			
		}
		
		
		
		
		
		//2.
		req.setAttribute("blist", blist);
		req.setAttribute("balist", balist);
		req.setAttribute("elist", elist);
		
		req.setAttribute("type", type);
		
		req.setAttribute("booksearch", booksearch);
		req.setAttribute("idsearch", idsearch);
		req.setAttribute("ordernumsearch", ordernumsearch);
		
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate", endDate);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/order/orderlist.jsp");
		dispatcher.forward(req, resp);
	}

}