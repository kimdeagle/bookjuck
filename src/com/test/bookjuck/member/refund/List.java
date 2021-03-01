package com.test.bookjuck.member.refund;

import java.io.IOException;
import java.io.PrintWriter;
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



@WebServlet("/member/refund/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//목록 or 검색
		// - 단순 목록 : list.do
		// - 검색한 결과 목록 : list.do?search=
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("id", id);
		
		String refundsearch = req.getParameter("refundsearch");
		String type = "1";	//일반배송 : 1, 바로드림 : 2, eBook : 3 
		
		if (req.getParameter("type") != null) {
			type = req.getParameter("type");
		}
				
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		
		//초기검색 상태 기간 조회 : 1달전 ~ 현재 까지로 만들기
		if (startDate == null) {
			Date date = new Date();
			Date caldate = new Date();
			caldate.setMonth(date.getMonth() - 1); 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-MM-dd HH:mm:ss 
			startDate = formatter.format(caldate);
		}
		
		if (endDate == null) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-MM-dd HH:mm:ss 
			endDate = formatter.format(date);
		}
		
		
		
		if ( !(startDate == null || startDate.equals("")) ) {
			map.put("startDate", startDate);
		}
		
		if ( !(endDate == null || endDate.equals("")) ) {
			map.put("endDate", endDate);
		}	
		
		if ( !(refundsearch == null || refundsearch.equals("")) ) {
			map.put("refundsearch", refundsearch);
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
		
		
		//1.
		ArrayList<BookOrderDTO> blist = new ArrayList<BookOrderDTO>();
		ArrayList<BaroOrderDTO> balist = new ArrayList<BaroOrderDTO>();
		ArrayList<EBookOrderDTO> elist = new ArrayList<EBookOrderDTO>();
		
		
		
		String pagebar = "";
		
		
		if (type.equals("1")) {
			
			BookOrderDAO dao = new BookOrderDAO();	
			
			String cnt1 = dao.process(map,"교환신청");
			String cnt2 = dao.process(map,"교환처리중");
			String cnt3 = dao.process(map,"교환완료");
			String cnt4 = dao.process(map,"환불신청");
			String cnt5 = dao.process(map,"환불처리중");
			String cnt6 = dao.process(map,"환불완료");
			
			
			blist = dao.list(map);	
			
			//1.5 데이터 조작할 것
			for (BookOrderDTO dto : blist) {
				
				//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
				dto.setApplyDate(dto.getApplyDate().substring(0, 10));
				
			}
			
			
			totalCount = dao.getTotalCount(map); //총 게시물 수
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
							+ "            <a href=\"/bookjuck/member/refund/list.do?type=%d&page=%d&refundsearch=%s&startDate=%s&endDate=%s\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>", 1, n - 1, refundsearch, startDate, endDate);			
			}
			
			
			
			while (!(loop > blockSize || n > totalPage)) {

				if (nowPage == n) {
					pagebar += "<li class='active'>";
				} else {
					pagebar += "<li>";
				}
				pagebar += String.format("<a href=\"/bookjuck/member/refund/list.do?type=%d&page=%d&refundsearch=%s&startDate=%s&endDate=%s\">%d</a></li> ", 1, n, refundsearch, startDate, endDate, n);

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
						+ "            <a href=\"/bookjuck/member/refund/list.do?type=%d&page=%d&refundsearch=%s&startDate=%s&endDate=%s\" aria-label=\"Next\">"
						+ "                <span aria-hidden=\"true\">&raquo;</span>"
						+ "            </a>"
						+ "          </li> ", 1, n, refundsearch, startDate, endDate);
			}
			
			
			
			req.setAttribute("pagebar", pagebar);
			req.setAttribute("nowPage", nowPage);
			
			req.setAttribute("cnt1", cnt1); //교환신청
			req.setAttribute("cnt2", cnt2); //처리중
			req.setAttribute("cnt3", cnt3); //교환완료
			req.setAttribute("cnt4", cnt4); //환불신청
			req.setAttribute("cnt5", cnt5); //처리중
			req.setAttribute("cnt6", cnt6); //환불완료
			
			
		} else if (type.equals("2")) {
			
			BaroOrderDAO dao = new BaroOrderDAO();	
			
			String cnt1 = dao.process(map,"교환신청");
			String cnt2 = dao.process(map,"교환처리중");
			String cnt3 = dao.process(map,"교환완료");
			String cnt4 = dao.process(map,"환불신청");
			String cnt5 = dao.process(map,"환불처리중");
			String cnt6 = dao.process(map,"환불완료");
			
			
			balist = dao.list(map);	
			
			//1.5 데이터 조작할 것
			for (BaroOrderDTO dto : balist) {
				
				//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
				dto.setApplyDate(dto.getApplyDate().substring(0, 10));
				
			}
			
			
			totalCount = dao.getTotalCount(map); //총 게시물 수
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
							+ "            <a href=\"/bookjuck/member/refund/list.do?type=%d&page=%d&refundsearch=%s&startDate=%s&endDate=%s\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>", 2, n - 1, refundsearch, startDate, endDate);			
			}
			
			
			
			while (!(loop > blockSize || n > totalPage)) {

				if (nowPage == n) {
					pagebar += "<li class='active'>";
				} else {
					pagebar += "<li>";
				}
				pagebar += String.format("<a href=\"/bookjuck/member/refund/list.do?type=%d&page=%d&refundsearch=%s&startDate=%s&endDate=%s\">%d</a></li> ", 2, n, refundsearch, startDate, endDate, n);

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
						+ "            <a href=\"/bookjuck/member/refund/list.do?type=%d&page=%d&refundsearch=%s&startDate=%s&endDate=%s\" aria-label=\"Next\">"
						+ "                <span aria-hidden=\"true\">&raquo;</span>"
						+ "            </a>"
						+ "          </li> ", 2, n, refundsearch, startDate, endDate);
			}
			
			
			
			req.setAttribute("pagebar", pagebar);
			req.setAttribute("nowPage", nowPage);
			
			req.setAttribute("cnt1", cnt1); //교환신청
			req.setAttribute("cnt2", cnt2); //처리중
			req.setAttribute("cnt3", cnt3); //교환완료
			req.setAttribute("cnt4", cnt4); //환불신청
			req.setAttribute("cnt5", cnt5); //처리중
			req.setAttribute("cnt6", cnt6); //환불완료
			
			
		} else {
			
			EBookOrderDAO dao = new EBookOrderDAO();	
			
			String cnt1 = dao.process(map,"교환신청");
			String cnt2 = dao.process(map,"교환처리중");
			String cnt3 = dao.process(map,"교환완료");
			String cnt4 = dao.process(map,"환불신청");
			String cnt5 = dao.process(map,"환불처리중");
			String cnt6 = dao.process(map,"환불완료");
			
			elist = dao.list(map);	
			
			//1.5 데이터 조작할 것
			for (EBookOrderDTO dto : elist) {
				
				//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
				dto.setApplyDate(dto.getApplyDate().substring(0, 10));
				
			}
			
			
			
			totalCount = dao.getTotalCount(map); //총 게시물 수
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
							+ "            <a href=\"/bookjuck/member/refund/list.do?type=%d&page=%d&refundsearch=%s&startDate=%s&endDate=%s\" aria-label=\"Previous\">"
							+ "                <span aria-hidden=\"true\">&laquo;</span>"
							+ "            </a>"
							+ "         </li>", 3, n - 1, refundsearch, startDate, endDate);			
			}
			
			
			
			while (!(loop > blockSize || n > totalPage)) {

				if (nowPage == n) {
					pagebar += "<li class='active'>";
				} else {
					pagebar += "<li>";
				}
				pagebar += String.format("<a href=\"/bookjuck/member/refund/list.do?type=%d&page=%d&refundsearch=%s&startDate=%s&endDate=%s\">%d</a></li> ", 3, n, refundsearch, startDate, endDate, n);

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
						+ "            <a href=\"/bookjuck/member/refund/list.do?type=%d&page=%d&refundsearch=%s&startDate=%s&endDate=%s\" aria-label=\"Next\">"
						+ "                <span aria-hidden=\"true\">&raquo;</span>"
						+ "            </a>"
						+ "          </li> ", 3, n, refundsearch, startDate, endDate);
			}
			
			
			
			req.setAttribute("pagebar", pagebar);
			req.setAttribute("nowPage", nowPage);
			
			req.setAttribute("cnt1", cnt1); //교환신청
			req.setAttribute("cnt2", cnt2); //처리중
			req.setAttribute("cnt3", cnt3); //교환완료
			req.setAttribute("cnt4", cnt4); //환불신청
			req.setAttribute("cnt5", cnt5); //처리중
			req.setAttribute("cnt6", cnt6); //환불완료
			
			
			
		}
		
		
		
		
		
		//2.
		req.setAttribute("blist", blist);
		req.setAttribute("balist", balist);
		req.setAttribute("elist", elist);
		
		req.setAttribute("refundsearch", refundsearch);
		
		req.setAttribute("type", type);

		
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate", endDate);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/refund/list.jsp");
		dispatcher.forward(req, resp);

	}

	


}

