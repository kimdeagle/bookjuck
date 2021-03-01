package com.test.bookjuck.member.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.BookDAO;
import com.test.bookjuck.dto.BookDTO;

@WebServlet("/member/book/mainbook.do")
public class MainBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq ="";
		
		seq = req.getParameter("seq");
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		
		
		//session.setAttribute("id", "test004"); // 추천도서 비회원 접근 제한 테스트용 세션
		session.setAttribute("seq", "24"); // 추천도서 적용여부 테스트용 세션
		
		ArrayList<BookDTO> list1 = new ArrayList<BookDTO>(); //추천도서
		ArrayList<BookDTO> list2 = new ArrayList<BookDTO>(); //베스트도서
		ArrayList<BookDTO> list3 = new ArrayList<BookDTO>(); //화제의신간
		
		
		if (session.getAttribute("seq") == null) {
			
			
			
			System.out.println("아이디없는상태");
			
			BookDAO dao = new BookDAO();
			
			list2 = dao.mainNewBook();//메인신간도서
			list3 = dao.mainBestSeller();//메인베스트셀러
			
			
			//메인신간도서
			for (BookDTO dto : list2) {
				
				// 날짜에서 시간 잘라내기
				dto.setPubDate(dto.getPubDate().substring(0, 10));
	
				// 제목, 카피 너무 길면 자르기
				if (dto.getTitle().length() > 30) {
					dto.setTitle(dto.getTitle().substring(0, 30) + "..");
				}
				
				if (dto.getCopy().length() > 80) {
					dto.setCopy(dto.getCopy().substring(0, 80) + "..");
				}
	
			}
				//메인베스트셀러
				for (BookDTO dto : list3) {
				
				// 날짜에서 시간 잘라내기
				dto.setPubDate(dto.getPubDate().substring(0, 10));
	
				// 제목, 카피 너무 길면 자르기
				if (dto.getTitle().length() > 30) {
					dto.setTitle(dto.getTitle().substring(0, 30) + "..");
				}
	
				if (dto.getCopy().length() > 80) {
					dto.setCopy(dto.getCopy().substring(0, 80) + "..");
				}
	
			}
				

				req.setAttribute("list2", list2);
				req.setAttribute("list3", list3);
				
				
		
			
			
		} else {
			
			BookDAO dao = new BookDAO();
			list1 = dao.mainRecommendBook(session.getAttribute("seq").toString());
			list2 = dao.mainNewBook();
			list3 = dao.mainBestSeller();
			
			System.out.println(list1.size());
			
					//메인추천도서
					for (BookDTO dto : list1) {
						
					// 날짜에서 시간 잘라내기
					//dto.setPubDate(dto.getPubDate().substring(0, 10));
	
					// 제목, 카피 너무 길면 자르기
				if (dto.getTitle().length() > 30) {
					dto.setTitle(dto.getTitle().substring(0, 30) + "..");
					}
	
						if (dto.getCopy().length() > 80) {
					dto.setCopy(dto.getCopy().substring(0, 80) + "..");
					}
	
			}
					//메인신간도서
				for (BookDTO dto : list2) {
						
					// 날짜에서 시간 잘라내기
					//dto.setPubDate(dto.getPubDate().substring(0, 10));
		
					// 제목, 카피 너무 길면 자르기
					if (dto.getTitle().length() > 30) {
						dto.setTitle(dto.getTitle().substring(0, 30) + "..");
					}
		
					if (dto.getCopy().length() > 80) {
						dto.setCopy(dto.getCopy().substring(0, 80) + "..");
					}
		
				}
					//메인베스트셀러
					for (BookDTO dto : list3) {
					
					// 날짜에서 시간 잘라내기
					//dto.setPubDate(dto.getPubDate().substring(0, 10));
		
					// 제목, 카피 너무 길면 자르기
					if (dto.getTitle().length() > 30) {
						dto.setTitle(dto.getTitle().substring(0, 30) + "..");
					}
		
					if (dto.getCopy().length() > 80) {
						dto.setCopy(dto.getCopy().substring(0, 80) + "..");
					}
		
				}
					
					req.setAttribute("list1", list1);
					req.setAttribute("list2", list2);
					req.setAttribute("list3", list3);
					
							
			
		}
		
		
		
		
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/book/mainbook.jsp");
		dispatcher.include(req, resp);

	}

}
