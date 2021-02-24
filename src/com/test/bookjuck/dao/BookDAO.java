package com.test.bookjuck.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookDTO;
import com.test.bookjuck.dto.CategoryDTO;





public class BookDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	
	public BookDAO() {
		//DB 연결
		conn = DBUtil.open();
	}
	
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
  
  //----- 현우 시작 
	//검색구현 -- 이현우
	public ArrayList<BookDTO> list (HashMap<String, String> map){
		
		try {
			
			String where ="";
			String sql = "";
			//sk= 검색카테고리 sv=검색창
			if(map.get("sk") != null && map.get("sv") != null) { // E북을 제외한 검색
				
				//검색카테고리, 검색창 모두 값 있음
				where = String.format("where (title like '%%%s%%' or name like '%%%s%%') and lcategory like '%%%s%%'",map.get("sv"),map.get("sv"), map.get("sk"));				
				sql = String.format("select * from vwbook %s order by pubdate desc", where); //최신도서가 상단으로
								
				if(map.get("sk").equals("EBOOK") && map.get("sv") != null){ //E북 검색
					
					where = String.format("where title like '%%%s%%' or name like '%%%s%%'",map.get("sv"),map.get("sv"));						
					sql = String.format("select * from vwebook %s order by pubdate desc", where);//최신도서가 상단으로
					
				}
					
				
			} 
			
			System.out.println(where);
						
			System.out.println(sql);
		
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			//ResultSet -> ArrayList<DTO>
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while(rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPubDate(rs.getString("pubdate"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setContents(rs.getString("contents"));
				dto.setAuthor(rs.getString("name"));
				dto.setLCategory(rs.getString("lcategory"));
				
				list.add(dto);
				
				
			}
			
			System.out.println(list.size());
			return list;
			 
					
		} catch (Exception e) {
			System.out.println(e);
		} 
		

		return null;
	
	}
	
	//베스트셀러 list -- 이현우
	public ArrayList<BookDTO> bestSeller (HashMap<String, String> map){
		
		System.out.println("select");
		
		try {
			
			String where ="";
			String sql = "";
			
			
			if (map.get("yearStart") != null && map.get("yearEnd") != null
				&& map.get("monthStart") != null && map.get("monthEnd") != null
				&& map.get("dayStart") != null && map.get("dayEnd") != null) 
			{
				String start = "'" + map.get("yearStart") + map.get("monthStart") + map.get("dayStart") +"'";
				String end = "'" + map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd") +"'";
				
				where = String.format("where seq between 1 and 10 and pubdate between %s and %s", start, end);
				sql = String.format("select * from vwbestseller %s order by salerank asc", where);
				System.out.println(sql); 
				System.out.println(start);
				System.out.println(end);
				
				
			}
			
			System.out.println(where);
			System.out.println(sql);
					
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			//ResultSet -> ArrayList<DTO>
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while(rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPubDate(rs.getString("pubdate"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setTotalSale(rs.getString("totalsale"));
				dto.setSaleRank(rs.getString("salerank"));
				dto.setAuthor(rs.getString("author"));
				System.out.println(rs.getString("title"));
				
				
				list.add(dto);
				
				
			}
			
			return list;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return null;
		
	} 
	
	
	//(날짜 입력 전)신간도서 list --이현우 
	public ArrayList<BookDTO> defaultNewBook(){
		
		
		try {
			
			String sql = "select * from vwnewbook where rank between 1 and 10";
			
			
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while(rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPubDate(rs.getString("pubdate"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setAuthor(rs.getString("author"));
				dto.setRank(rs.getString("rank"));
				System.out.println(rs.getString("title"));
				
				
				list.add(dto);
				
				
			}
			
			return list;
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
		
		
	}
	
	
	
	//(날짜 입력 후)신간도서 list -- 이현우
	public ArrayList<BookDTO> newBook (HashMap<String, String> map){
		
		try {
			
			String where ="";
			String sql = "";
			
			
			if (map.get("yearStart") != null && map.get("yearEnd") != null
				&& map.get("monthStart") != null && map.get("monthEnd") != null
				&& map.get("dayStart") != null && map.get("dayEnd") != null) 
			{
				String start = "'" + map.get("yearStart") + map.get("monthStart") + map.get("dayStart") +"'";
				String end = "'" + map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd") +"'";
				
				where = String.format("where rank between 1 and 10 and pubdate between %s and %s", start, end);
				sql = String.format("select * from vwnewbook %s", where);
				System.out.println(sql); 
				System.out.println(start);
				System.out.println(end);
							
			}
			
			System.out.println(where);
			System.out.println(sql);
					
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			//ResultSet -> ArrayList<DTO>
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while(rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPubDate(rs.getString("pubdate"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setAuthor(rs.getString("author"));
				dto.setRank(rs.getString("rank"));
				System.out.println(rs.getString("title"));
				
				
				list.add(dto);
				
				
			}
			
			return list;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return null;
		
	} 
	//월간베스트 -- 이현우
	public ArrayList<BookDTO> monthlyBestSeller() {
		
		
		try {
			
			//String sql = "select * from vwbestseller where pubdate between trunc(sysdate, 'mm') and last_day(sysdate)";
			String sql = "select * from vwbestseller";
			
					
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while (rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPubDate(rs.getString("pubdate"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setTotalSale(rs.getString("totalsale"));
				dto.setSaleRank(rs.getString("salerank"));
				dto.setAuthor(rs.getString("author"));
				System.out.println(rs.getString("title"));
							
				
				list.add(dto);
				System.out.println(list);
				System.out.println(list.size());
				
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
		
	}
	//메인 베스트셀러 --이현우
	public ArrayList<BookDTO> mainBestSeller(){
		
		try {
			
			String sql = "select * from vwbestseller where salerank between 1 and 6";
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while (rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPubDate(rs.getString("pubdate"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setTotalSale(rs.getString("totalsale"));
				dto.setSaleRank(rs.getString("salerank"));
				dto.setAuthor(rs.getString("author"));
				dto.setSaleRank(rs.getString("salerank"));
				System.out.println(rs.getString("title"));
							
				
				list.add(dto);
				System.out.println(list);
				System.out.println(list.size());
				
			}
			
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return null;
		
		
		
	}
	// 메인 신간도서 -- 이현우
	public ArrayList<BookDTO> mainNewBook(){
		
		
		try {
			
			String sql = "select * from vwnewbook where rank between 1 and 6";
			
			
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while(rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPubDate(rs.getString("pubdate"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setAuthor(rs.getString("author"));
				dto.setRank(rs.getString("rank"));
				System.out.println(rs.getString("title"));
				
				
				list.add(dto);
				
				
			}
			
			return list;
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
		
		
	}
	
	//메인 추천도서--이현우
	public ArrayList<BookDTO> mainRecommendBook (String seq){
		
		
		try {
			
			
			String sql = "";
			sql = String.format("select * from vwrecommendbook where seq = %s and rank between 1 and 6 order by rank", seq);
			//sql = String.format("select * from vwrecommendbook where seq = 24 and rank between 1 and 6 order by rank");
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			//ResultSet -> ArrayList<DTO>
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while(rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				//dto.setPublisher(rs.getString("publisher"));
				//dto.setPrice(rs.getInt("price"));
				//dto.setPubDate(rs.getString("pubdate"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				//dto.setAuthor(rs.getString("author"));
				dto.setRank(rs.getString("rank"));
				System.out.println(rs.getString("title"));
				
				
				list.add(dto);
				System.out.println(list);
				
			}
			
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		return null;
		
		
	}
  
  //----- 현우 끝 
  

	//주혁 시작
	
	//BookList 서블릿 -> 도서 리스트 반환
	public ArrayList<BookDTO> getBookList(HashMap<String, String> map) {
		
		try {
			
			String sql = "";
			String innerSql = "";
			
			if (map.get("seqSCategory") == null) {
				//도서 리스트 첫 화면
				innerSql = String.format("select b.*, mc.seq as seqMCategory, (select name from tblAuthor where seq = b.seqAuthor) as author from tblBook b inner join tblSCategory sc on b.seqSCategory = sc.seq inner join tblMCategory mc on sc.seqMCategory = mc.seq where mc.seq = %s order by b.pubDate desc, b.title", map.get("seqMCategory"));

			} else {
				//도서 리스트 좌측 소분류 선택
				innerSql = String.format("select b.*, (select name from tblAuthor where seq = b.seqAuthor) as author from tblBook b where seqSCategory = %s order by b.pubDate desc, b.title", map.get("seqSCategory"));
			}
			
			sql = String.format("select * from (select a.*, rownum as rnum from (%s) a) where rnum between %s and %s", innerSql, map.get("begin"), map.get("end"));
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<BookDTO> blist = new ArrayList<BookDTO>();
			
			while (rs.next()) {
				BookDTO bdto = new BookDTO();
				
				bdto.setImage(rs.getString("image"));
				bdto.setTitle(rs.getString("title"));
				bdto.setAuthor(rs.getString("author"));
				bdto.setPublisher(rs.getString("publisher"));
				bdto.setPubDate(rs.getString("pubDate"));
				bdto.setPage(rs.getInt("page"));
				bdto.setSummary(rs.getString("summary"));
				bdto.setPrice(rs.getInt("price"));
				bdto.setSalePrice(rs.getInt("salePrice"));
				bdto.setSeq(rs.getString("seq"));
				
				blist.add(bdto);
				
			}
			
			return blist;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	//BookDetail 서블릿 -> 도서 상세정보 호출
	public BookDTO getBookDetail(String seq) {
		
		try {
			
			String sql = "select b.*, (select name from tblAuthor where seq = b.seqAuthor) as author, (select intro from tblAuthor where seq = b.seqAuthor) as authorIntro, (select sCategory from tblSCategory where seq = b.seqSCategory) as sCategory from tblBook b where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			BookDTO dto = new BookDTO();
			
			if (rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setSeqAuthor(rs.getString("seqAuthor"));
				dto.setSeqSCategory(rs.getString("seqSCategory"));
				dto.setTitle(rs.getString("title"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setSalePrice(rs.getInt("salePrice"));
				dto.setPubDate(rs.getString("pubDate"));
				dto.setSummary(rs.getString("summary"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setPage(rs.getInt("page"));
				dto.setContents(rs.getString("contents"));
				
				dto.setAuthor(rs.getString("author"));
				dto.setAuthorIntro(rs.getString("authorIntro"));
				
				dto.setsCategory(rs.getString("sCategory"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
	//BookList 서블릿 -> 도서 수 반환
	public int getBookCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("seqSCategory") != null) {
				//소분류 선택
				where = String.format("where b.seqSCategory = %s", map.get("seqSCategory"));
			} else {
				where = String.format("where mc.seq = %s", map.get("seqMCategory"));
			}
			
			String sql = String.format("select count(*) as cnt from tblBook b inner join tblSCategory sc on b.seqSCategory = sc.seq inner join tblMCategory mc on sc.seqMCategory = mc.seq %s", where);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	
	//주혁 끝

} //BookDAO

















