package com.test.bookjuck.member.fleamarket;

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

import com.test.bookjuck.dao.UsedBoardDAO;
import com.test.bookjuck.dto.UsedBoardDTO;

@WebServlet("/member/fleamarket/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//목록 or 검색
		// - 단순 목록 : list.do
		// - 검색한 결과 목록 : list.do?search=
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		String fleamarketsearch = req.getParameter("fleamarketsearch");
		
		if ( !(fleamarketsearch == null || fleamarketsearch.equals("")) ) {
			map.put("fleamarketsearch", fleamarketsearch);
		}		
		
		//1. DB 작업 -> select
		//2. 목록 반환 + JSP 전달 후 호출하기
		
		HttpSession session = req.getSession();
		
		//view.do -> 새로고침으로 생기는 조회 수 증가 방지 : flag 생성
		session.setAttribute("read", false);
		
		
		//페이징------------------------------------------------------------
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수 
		int pageSize = 10;		//한 페이지당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작번호
		int end = 0;			//rnum 끝번호
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
		
		//HashMap에 정보를 넘겨
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		
		
		//1.
		UsedBoardDAO dao = new UsedBoardDAO();
		
		ArrayList<UsedBoardDTO> list = dao.list(map);
		
		
		//데이터 조작은 서블릿이, 데이터 출력은 JSP가 담당한다.
		
		//1.5 데이터 조작할 것 : 날짜 (시간 자르기), 글제목 (너무 길면 자르기)
		for (UsedBoardDTO dto : list) {
			
			//날짜에서 시간 잘라내기 yyyy-mm-dd로 표기 
			dto.setRegDate(dto.getRegDate().substring(0, 10));
			
			//글 제목이 너무 길면 자르기
			if (dto.getTitle().length() > 34) {
				
				dto.setTitle(dto.getTitle().substring(0, 34) + " ...");
			}
			
		}
		
		
		//총 페이지 수 계산하기
		//총 게시물 수 = 269개
		//총 페이지 수 = 269 / 10 -> 26.9페이지 -올림-> 28페이지 (무조건 올림 : ceiling함수)
		
		totalCount = dao.getTotalCount(map); //총 게시물 수
		System.out.println(totalCount);		//269개
		
		//totalPage = totalCount / pageSize + 1; //총 페이지 수
		totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수
		System.out.println(totalPage);		//26페이지 -(ceil)-> 27페이지
		
		
		String pagebar = "";
		
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
						+ "            <a href=\"/bookjuck/member/fleamarket/list.do?page=%d\" aria-label=\"Previous\">"
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
			pagebar += String.format("<a href=\"/bookjuck/member/fleamarket/list.do?page=%d\">%d</a></li> ", n, n);

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
					+ "            <a href=\"/bookjuck/member/fleamarket/list.do?page=%d\" aria-label=\"Next\">"
					+ "                <span aria-hidden=\"true\">&raquo;</span>"
					+ "            </a>"
					+ "          </li> ", n);
		}
		
		
		//2. 
		//검색어까지
		req.setAttribute("list", list);
		req.setAttribute("fleamarketsearch", fleamarketsearch);
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("nowPage", nowPage);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/fleamarket/list.jsp");
		dispatcher.forward(req, resp);
	}

}