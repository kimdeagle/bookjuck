package com.test.bookjuck.admin.book;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
import com.test.bookjuck.dao.AuthorDAO;
import com.test.bookjuck.dao.BookInventoryDAO;
import com.test.bookjuck.dao.EBookDAO;
import com.test.bookjuck.dto.AuthorDTO;
import com.test.bookjuck.dto.BookInventoryDTO;
import com.test.bookjuck.dto.EBookDTO;

@WebServlet("/admin/book/ebookeditok.do")
public class EBookEditOk extends HttpServlet {

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
		String copy = "";
		String intro = "";
		String contents = "";
		String image = "";
		String eFile = "";
		String seq = "";
		String nowPage = "";
		
		int result = 0; //업무 결과
		
		try {
			
			Part part = null;
			
			HashMap<String, String> map = new HashMap<String, String>();
			
			MultipartParser parser = new MultipartParser(req, 1024 * 1024 * 100);
			parser.setEncoding("UTF-8");
			
			while ((part = parser.readNextPart()) != null) {
				String name = part.getName();
				
				if (part.isParam()) {
					//파일이 아닐 때
					String value = "";
					ParamPart paramPart = (ParamPart) part;
					value = paramPart.getStringValue();
					if (!name.equals("")) {
						map.put(name, value);
					}
				} else if (part.isFile()) {
					//파일일 때
					FilePart filePart = (FilePart) part;
					String orgFileName = filePart.getFileName();
					
					filePart.setRenamePolicy(new DefaultFileRenamePolicy());
					
					if (orgFileName != null) {
						String savePath = "";
						if (name.equals("image")) {
							savePath = req.getRealPath("/image/book");
							map.put(name, filePart.getFileName());
						} else if (name.equals("eFile")) {
							savePath = req.getRealPath("/file/ebook");
							map.put(name, filePart.getFileName());
						}
						
						File filePath = new File(savePath);
						long size = filePart.writeTo(filePath);
						
					}			
					
				}
				
			}
			
			
			title = map.get("title");
			publisher = map.get("publisher");
			seqSCategory = map.get("seqSCategory");
			seqAuthor = map.get("seqAuthor");
			author = map.get("author");
			authorIntro = map.get("authorIntro");
			pubDate = map.get("pubDate");
			isbn = map.get("isbn");
			price = Integer.parseInt(map.get("price"));
			copy = map.get("copy");
			intro = map.get("intro");
			contents = map.get("contents");
			image = map.get("image");
			eFile = map.get("eFile");
			nowPage = map.get("nowPage");
			
			seq = map.get("seq"); //수정할 도서번호
			
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
			
			EBookDAO ebdao = new EBookDAO();
			EBookDTO ebdto = new EBookDTO();
			
			if (map.get("image") == null || map.get("image").equals("")) {
				image = ebdao.getImageFileName(seq);
			}
			
			if (map.get("eFile") == null || map.get("eFile").equals("")) {
				eFile = ebdao.getEBookFileName(seq);
			}
			
			
			
			ebdto.setTitle(title);
			ebdto.setPublisher(publisher);
			ebdto.setSeqSCategory(seqSCategory);
			ebdto.setSeqAuthor(seqAuthor);
			ebdto.setPubDate(pubDate);
			ebdto.setIsbn(isbn);
			ebdto.setPrice(price);
			ebdto.seteFile(eFile);
			ebdto.setCopy(copy);
			ebdto.setIntro(intro);
			ebdto.setContents(contents);
			ebdto.setImage(image);
			
			ebdto.setSeq(seq);
			
			result = ebdao.edit(ebdto); //도서 수정

			
			if (result == 1) {
				resp.setCharacterEncoding("UTF-8");
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><head><meta charset='UTF-8' /></head><body>");
				writer.print("<script>");
				writer.print("alert('E-Book 수정 성공!\\nE-Book 상세로 이동합니다.');");
				writer.print(String.format("location.href='/bookjuck/admin/book/ebookview.do?seq=%s&page=%s'", seq, nowPage));
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();
			} else {
				resp.setCharacterEncoding("UTF-8");
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><head><meta charset='UTF-8' /></head><body>");
				writer.print("<script>");
				writer.print("alert('E-Book 수정 실패..\\n이전 화면으로 이동합니다.');");
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