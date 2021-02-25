package com.test.bookjuck.member.fleamarket;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.UsedBoardDAO;
import com.test.bookjuck.dto.CommentDTO;
import com.test.bookjuck.dto.UsedBoardDTO;

@WebServlet("/member/fleamarket/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//1. 데이터 가져오기(seq)
		//2. DB 작업 -> select
		//3. 결과 반환 -> JSP 호출하기 + 전달
		
		HttpSession session = req.getSession();
		
		//1.
		String seq = req.getParameter("seq");
		String fleamarketsearch = req.getParameter("fleamarketsearch"); //검색어
		
		String page = req.getParameter("page"); //왜받았냐??? view.jsp 한테 넘기기 위해!
		
		//2.
		UsedBoardDAO dao = new UsedBoardDAO();
		
		//2.5. 조회수 증가시키기
		//2.3. 조회수 증가 + 글 view에서 f5(새로고침)눌렀을 때 조회수 증가하는것을 방지 + 북마크로 오는사람들
		if (session.getAttribute("read") == null || (boolean)session.getAttribute("read") == false) {
			dao.updateReadcnt(seq);
			session.setAttribute("read", true);
		}
		
		
		UsedBoardDTO dto = dao.get(seq);
		
		//댓글 목록 가져오기
		//현재 보고 있는 글에 달려있는 댓글 목록 가져오기
		ArrayList<CommentDTO> clist = dao.listComment(seq); 
		
		
		
		dao.close();
		
		
		//2.5. 데이터 조작
		//개행 문자 출력하기
		dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		
		
		//3.
		req.setAttribute("dto", dto);
		req.setAttribute("fleamarketsearch", fleamarketsearch);
		
		req.setAttribute("page", page); //페이지 번호 view.jsp한테 넘겨주자
		
		req.setAttribute("clist", clist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/fleamarket/view.jsp");
		dispatcher.forward(req, resp);
	}

}