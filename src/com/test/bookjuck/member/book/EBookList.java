package com.test.bookjuck.member.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.EBookDAO;
import com.test.bookjuck.dto.BookDTO;
import com.test.bookjuck.dto.EBookDTO;


@WebServlet("/member/book/ebooklist.do")
public class EBookList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 데이터 가져오기
		//2. DB 작업 -> select
		//3. 결과 + JSP 호출
		
		//1.
		String seqLCategory = request.getParameter("seqLCategory");
		String seqMCategory = request.getParameter("seqMCategory");
		String seqSCategory = request.getParameter("seqSCategory");
		
		//String lCategory = request.getParameter("lCategory");
		//String mCategory = request.getParameter("mCategory");
		//String sCategory = request.getParameter("sCategory");
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		//페이징
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 10;		//한페이지 당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작 번호
		int end = 0;			//rnum 끝 번호
		int n = 0;				//페이지바 관련 변수
		int loop = 0;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수
		
		
		String page = request.getParameter("page");
		
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
		map.put("seqMCategory", seqMCategory);
		map.put("seqSCategory", seqSCategory);
		
		
		//2.
		EBookDAO dao = new EBookDAO();
		
		ArrayList<EBookDTO> eblist = dao.getEBookList(map);
		
		
		//날짜 데이터 자르기 -> 년 월 일로 변환
		for (EBookDTO ebdto : eblist) {
			ebdto.setPubDate(ebdto.getPubDate().substring(0, 10));
			String temp = "";
			temp = ebdto.getPubDate().substring(0, 4) + "년 " + ebdto.getPubDate().substring(5, 7) + "월 " + ebdto.getPubDate().substring(8) + "일";
			ebdto.setPubDate(temp);
		}
		
		//intro 데이터 자르기
		for (EBookDTO ebdto : eblist) {
			if (ebdto.getIntro().length() > 100) {
				ebdto.setIntro(ebdto.getIntro().substring(0, 100));
			}
		}
		
		
		//총 페이지 수 계산하기
		
		//총 게시물 수 가져오기
		totalCount = dao.getEBookCount(map);
		
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
			if (seqSCategory != null) {
				pagebar += String.format("<li>" + 
						"		    <a href=\"/bookjuck/member/book/ebooklist.do?seqLCategory=%s&seqMCategory=%s&seqSCategory=%s&page=%d\" aria-label=\"Previous\">" + 
						"		        <span aria-hidden=\"true\">&laquo;</span>" + 
						"		    </a>" + 
						"		</li>"
						, seqLCategory
						, seqMCategory
						, seqSCategory
						, n - 1);
			} else {
				pagebar += String.format("<li>" + 
						"		    <a href=\"/bookjuck/member/book/ebooklist.do?page=%d\" aria-label=\"Previous\">" + 
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
			if (seqSCategory != null) {
				pagebar += String.format("<a href=\"/bookjuck/member/book/ebooklist.do?seqLCategory=%s&seqMCategory=%s&seqSCategory=%s&page=%d\">%d</a></li> "
						, seqLCategory
						, seqMCategory
						, seqSCategory
						, n
						, n);
				
			} else {
				pagebar += String.format("<a href=\"/bookjuck/member/book/ebooklist.do?page=%d\">%d</a></li> "
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
			if (seqSCategory != null) {
				pagebar += String.format("<li>" + 
						"		    <a href=\"/bookjuck/member/book/ebooklist.do?seqLCategory=%s&seqMCategory=%s&seqSCategory=%s&page=%d\" aria-label=\"Next\">" + 
						"		        <span aria-hidden=\"true\">&raquo;</span>" + 
						"		    </a>" + 
						"		</li>"
						, seqLCategory
						, seqMCategory
						, seqSCategory
						, n);			
				
			} else {
				pagebar += String.format("<li>" + 
						"		    <a href=\"/bookjuck/member/book/ebooklist.do?page=%d\" aria-label=\"Next\">" + 
						"		        <span aria-hidden=\"true\">&raquo;</span>" + 
						"		    </a>" + 
						"		</li>"
						, n);			

			}
		}
		
		dao.close();
		
		//3.
		
		request.setAttribute("seqLCategory", seqLCategory);
		request.setAttribute("seqMCategory", seqMCategory);
		request.setAttribute("seqSCategory", seqSCategory);
		
		//request.setAttribute("lCategory", lCategory);
		//request.setAttribute("mCategory", mCategory);
		//request.setAttribute("sCategory", sCategory);
		
		request.setAttribute("eblist", eblist);
		
		request.setAttribute("pagebar", pagebar);
		request.setAttribute("nowPage", nowPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/book/ebooklist.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
