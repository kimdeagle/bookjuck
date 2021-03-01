package com.test.bookjuck.admin.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.bookjuck.dao.AuthorDAO;
import com.test.bookjuck.dao.BookDAO;
import com.test.bookjuck.dao.BookInventoryDAO;
import com.test.bookjuck.dto.AuthorDTO;
import com.test.bookjuck.dto.BookDTO;
import com.test.bookjuck.dto.BookInventoryDTO;

@WebServlet("/admin/book/bookaddok.do")
public class BookAddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기
		//2. 파일 업로드 처리
		//3. DB 작업 > insert
		//4. 결과 반환 + 처리
		
		//1. + 2.
		req.setCharacterEncoding("UTF-8");
		
		String title = "";
		String publisher = "";
		String seqSCategory = "";
		String seqAuthor = "";
		String author = "";
		String authorIntro = "";
		String pubDate = "";
		String isbn = "";
		int price = 0;
		String amount = "";
		int page = 0;
		String copy = "";
		String summary = "";
		String contents = "";
		String image = "";
		String seq = "";
		
		int result = 0; //업무 결과
		
		try {
			
			MultipartRequest multi = new MultipartRequest(
					req,
					req.getRealPath("/image/book"),
					1024 * 1024 * 10, //10MB
					"UTF-8",
					new DefaultFileRenamePolicy()
					);
			
			//System.out.println(req.getRealPath("/image/book"));
			title = multi.getParameter("title");
			publisher = multi.getParameter("publisher");
			seqSCategory = multi.getParameter("seqSCategory");
			seqAuthor = multi.getParameter("seqAuthor");
			author = multi.getParameter("author");
			authorIntro = multi.getParameter("authorIntro");
			pubDate = multi.getParameter("pubDate");
			isbn = multi.getParameter("isbn");
			price = Integer.parseInt(multi.getParameter("price"));
			amount = multi.getParameter("amount");
			page = Integer.parseInt(multi.getParameter("page"));
			copy = multi.getParameter("copy");
			summary = multi.getParameter("summary");
			contents = multi.getParameter("contents");
			image = multi.getFilesystemName("image");
			
			//3.
			
			//작가 있는지 검사 -> 있으면 ok, 없으면 작가 테이블에 먼저 추가
			//seqAuthor null 또는 빈문자열이면 새로 추가
			if (seqAuthor == null || seqAuthor.equals("")) {
				AuthorDAO adao = new AuthorDAO();
				AuthorDTO adto = new AuthorDTO();
				
				adto.setName(author);
				adto.setIntro(authorIntro);
				
				seqAuthor = adao.add(adto); //작가 추가 후 추가한 작가 seq 반환
				
			}
			
			BookDAO bdao = new BookDAO();
			BookDTO bdto = new BookDTO();
			
			bdto.setTitle(title);
			bdto.setPublisher(publisher);
			bdto.setSeqSCategory(seqSCategory);
			bdto.setSeqAuthor(seqAuthor);
			bdto.setPubDate(pubDate);
			bdto.setIsbn(isbn);
			bdto.setPrice(price);
			bdto.setPage(page);
			bdto.setCopy(copy);
			bdto.setSummary(summary);
			bdto.setContents(contents);
			bdto.setImage(image);
			
			seq = bdao.add(bdto); //도서 추가 후 추가한 도서의 seq 반환
			
			
			//도서 추가 후 도서재고 테이블에 추가
			BookInventoryDAO bidao = new BookInventoryDAO();
			BookInventoryDTO bidto = new BookInventoryDTO();
			
			bidto.setSeqBook(seq);
			bidto.setAmount(amount);
			
			result = bidao.add(bidto); //도서재고 추가
			
			if (result == 1) {
				resp.setCharacterEncoding("UTF-8");
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><head><meta charset='UTF-8' /></head><body>");
				writer.print("<script>");
				writer.print("alert('도서 추가 성공!\\n도서 리스트로 이동합니다.');");
				writer.print("location.href='/bookjuck/admin/book/booklist.do';");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();
			} else {
				resp.setCharacterEncoding("UTF-8");
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><head><meta charset='UTF-8' /></head><body>");
				writer.print("<script>");
				writer.print("alert('도서 추가 실패..\\n이전 화면으로 이동합니다.');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}