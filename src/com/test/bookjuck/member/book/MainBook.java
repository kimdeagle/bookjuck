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

		//session.setAttribute("seq", "24"); // 추천도서 적용여부 테스트용 세션

		

		ArrayList<BookDTO> list1 = new ArrayList<BookDTO>(); //추천도서
		ArrayList<BookDTO> list2 = new ArrayList<BookDTO>(); //베스트도서
		ArrayList<BookDTO> list3 = new ArrayList<BookDTO>(); //화제의신간
	
		
		
		if (session.getAttribute("seq") == null) {
			
			
			
			
			
			BookDAO dao = new BookDAO();
			
			list3 = dao.mainNewBook();//메인신간도서
			list2 = dao.mainBestSeller();//메인베스트셀러
			
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
				
			
				ArrayList<BookDTO> list33 = new ArrayList<BookDTO>(); 
				ArrayList<BookDTO> list44 = new ArrayList<BookDTO>(); //베스트도서 -두번째줄
				ArrayList<BookDTO> list55 = new ArrayList<BookDTO>(); 
				ArrayList<BookDTO> list66 = new ArrayList<BookDTO>(); //화제의신간 -두번째줄
				
				
				for (int i = 0; i <= 2; i++) {
					list33.add(list2.get(i));
				}

				for (int i = 3; i <= 5; i++) {
					list44.add(list2.get(i));
					
					
				}
				
				for (int i = 0; i <= 2; i++) {
					list55.add(list3.get(i));
				}

				for (int i = 3; i <= 5; i++) {
					list66.add(list3.get(i));
				}
				

				req.setAttribute("list33", list33);
				req.setAttribute("list44", list44);
				req.setAttribute("list55", list55);
				req.setAttribute("list66", list66);
				
		
			
			
		} else {
			
			BookDAO dao = new BookDAO();
			list1 = dao.mainRecommendBook(session.getAttribute("seq").toString());
			list3 = dao.mainNewBook();
			list2 = dao.mainBestSeller();
			System.out.println(session.getAttribute("seq").toString());
			
			
					//메인추천도서
				for (BookDTO dto : list1) {
					
					if (dto.getTitle() != null) {
						// 날짜에서 시간 잘라내기
						//dto.setPubDate(dto.getPubDate().substring(0, 10));
						
						// 제목, 카피 너무 길면 자르기
						if (dto.getTitle().length() > 30) {
							dto.setTitle(dto.getTitle().substring(0, 30) + "..");
						}
						
						if (dto.getCopy().length() > 80) {
							dto.setCopy(dto.getCopy().substring(0, 80) + "..");
						}						
					} else {
						
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
					
					 
					ArrayList<BookDTO> list11 = new ArrayList<BookDTO>();
					ArrayList<BookDTO> list22 = new ArrayList<BookDTO>(); 
					ArrayList<BookDTO> list33 = new ArrayList<BookDTO>(); 
					ArrayList<BookDTO> list44 = new ArrayList<BookDTO>(); 
					ArrayList<BookDTO> list55 = new ArrayList<BookDTO>(); 
					ArrayList<BookDTO> list66 = new ArrayList<BookDTO>();
					

					/*
					for (int i = 0; i<list1.size(); i++) {
						if (list1.get(i).getTitle() != null) {
							list11.add(list1.get(i));
						}
					}

					for (int i = 3; i<list1.size(); i++) {
						list22.add(list1.get(i));
			
					}
					*/
					
					for (int i = 0; i <= 2; i++) {
						list11.add(list1.get(i));
					}
					
					for (int i = 3; i <= 5; i++) {
						list22.add(list1.get(i));
												
					}
					for (int i = 0; i <= 2; i++) {
						list33.add(list2.get(i));
					}

					for (int i = 3; i <= 5; i++) {
						list44.add(list2.get(i));
						
						
					}
					
					for (int i = 0; i <= 2; i++) {
						list55.add(list3.get(i));
					}

					for (int i = 3; i <= 5; i++) {
						list66.add(list3.get(i));
					}
					
					
					
					req.setAttribute("list11", list11);
					req.setAttribute("list22", list22);
					req.setAttribute("list33", list33);
					req.setAttribute("list44", list44);
					req.setAttribute("list55", list55);
					req.setAttribute("list66", list66);
					
							
			
		}
		
		
		
		
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/book/mainbook.jsp");
		dispatcher.include(req, resp);

	}

}
