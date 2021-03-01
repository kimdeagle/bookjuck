package com.test.bookjuck.member.fleamarket;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.bookjuck.dao.UsedBoardDAO;
import com.test.bookjuck.dto.UsedBoardDTO;

@WebServlet("/member/fleamarket/writeok.do")
public class WriteOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//1. 데이터 가져오기 
		//2. DB 작업 > insert
		//3. 결과처리
		
		HttpSession session = req.getSession();
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		String title = "";
		String content = "";
		String image = "";
		String orgimage = "";	
		
		String seqMember = session.getAttribute("seq").toString();
		
		try {
			
			MultipartRequest multi = new MultipartRequest(
										req,
										req.getRealPath("/files"),
										1024 * 1024 * 100,
										"UTF-8",
										new DefaultFileRenamePolicy()
									);
			System.out.println(req.getRealPath("/files"));
			
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			image = multi.getFilesystemName("attach");
			orgimage = multi.getFilesystemName("attach");
			
			System.out.println(image);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		//2.
		UsedBoardDAO dao = new UsedBoardDAO();
		UsedBoardDTO dto = new UsedBoardDTO();	
		
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSeqMember(seqMember);
		
		//파일 업로드
		dto.setImage(image);
		dto.setOrgimage(orgimage);
		
		
		int result = dao.write(dto); //글쓰기
		
		
		
		if (result == 1) {
			//글쓰기 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/member/fleamarket/list.do");
		} else {
			//글쓰기 실패 -> 경고 + 뒤로가기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
		}
		
		
	}

}
