package com.test.bookjuck.member.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.EBookDAO;
import com.test.bookjuck.dto.EBookDTO;


@WebServlet("/member/book/ebookdetail.do")
public class EBookDetail extends HttpServlet {

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
		String seq = request.getParameter("seq");
		
		//2.
		EBookDAO dao = new EBookDAO();
		EBookDTO dto = dao.getEBookDetail(seq);
		
		//날짜 데이터 자르기 -> 년 월 일로 변환
		dto.setPubDate(dto.getPubDate().substring(0, 10));
		String temp = "";
		temp = dto.getPubDate().substring(0, 4) + "년 " + dto.getPubDate().substring(5, 7) + "월 " + dto.getPubDate().substring(8) + "일";
		dto.setPubDate(temp);
		
		
		
		//줄거리, 목차, 작가 소개 엔터 -> <br> 변환
		dto.setIntro(dto.getIntro().replace("\r\n", "<br>"));
		dto.setIntro(dto.getIntro().replace("\n", "<br>"));
		
		dto.setContents(dto.getContents().replace("\r\n", "<br>"));
		dto.setContents(dto.getContents().replace("\n", "<br>"));
		
		dto.setAuthorIntro(dto.getAuthorIntro().replace("\r\n", "<br>"));
		dto.setAuthorIntro(dto.getAuthorIntro().replace("\n", "<br>"));
		
		dao.close();
		
		request.setAttribute("seqLCategory", seqLCategory);
		request.setAttribute("seqMCategory", seqMCategory);
		request.setAttribute("seqSCategory", seqSCategory);
		//request.setAttribute("lCategory", lCategory);
		//request.setAttribute("mCategory", mCategory);
		//request.setAttribute("sCategory", sCategory);
		
		request.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/book/ebookdetail.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
