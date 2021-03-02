package com.test.bookjuck.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookDTO;
import com.test.bookjuck.dto.EBookDTO;

import oracle.jdbc.OracleTypes;



/**
 * 도서와 관련된 모든 기능을 구현하기 위한 클래스
 * @author 아라, 주혁, 현우
 *
 */

public class BookDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	
	
	public BookDAO() {
		//DB 연결
		conn = DBUtil.open();
	}
	
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("BookDAO.close()");
			e.printStackTrace();
		}
	}
	
  
  //----- 현우 시작 

	/**
	 * 
	 * @param map 조회기간
	 * @return 검색결과
	 */
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
			
			
			return list;
			 
					
		} catch (Exception e) {
			System.out.println(e);
		} 
		

		return null;
	
	}
	

	/**
	 * 
	 * @param map 조회기간
	 * @return 베스트셀러 목록
	 */
	public ArrayList<BookDTO> bestSeller (HashMap<String, String> map){
		
		
		
		try {
			
			String where ="";
			String sql = "";
			String category ="";
			
			
			if (map.get("yearStart") != null && map.get("yearEnd") != null
				&& map.get("monthStart") != null && map.get("monthEnd") != null
				&& map.get("dayStart") != null && map.get("dayEnd") != null) 
			{
				String start = "'" + map.get("yearStart") + map.get("monthStart") + map.get("dayStart") +"'";
				String end = "'" + map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd") +"'";
				category = "'" + map.get("a") + "'";
				
				//where = String.format("where seq between 1 and 10 and pubdate between %s and %s", start, end);
				//sql = String.format("select * from vwbestseller %s order by salerank asc", where);
				
				where = String.format("where pubdate between %s and %s and mcategory=%s and rownum < 11", start, end, category);
				sql = String.format("select * from vwbestseller %s order by salerank asc", where);
				
			
				
				
			}
			
			
					
			
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
				
				
				
				list.add(dto);
				
				
			}
			
			return list;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return null;
		
	} 
/**
 * 
 * @param map 날짜
 * @return 카테고리 미적용 베스트셀러
 */
public ArrayList<BookDTO> NoCategorybestSeller (HashMap<String, String> map){
		
		
		
		try {
			
			String where ="";
			String sql = "";
		
			
			
			if (map.get("yearStart") != null && map.get("yearEnd") != null
				&& map.get("monthStart") != null && map.get("monthEnd") != null
				&& map.get("dayStart") != null && map.get("dayEnd") != null) 
			{
				String start = "'" + map.get("yearStart") + map.get("monthStart") + map.get("dayStart") +"'";
				String end = "'" + map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd") +"'";
				
				
				//where = String.format("where seq between 1 and 10 and pubdate between %s and %s", start, end);
				//sql = String.format("select * from vwbestseller %s order by salerank asc", where);
				
				where = String.format("where pubdate between %s and %s and rownum < 11", start, end);
				sql = String.format("select * from vwbestseller %s order by salerank asc", where);
				
				
				
				
				
			}
			
			
					
			
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
				
				
				
				list.add(dto);
				
				
			}
			
			return list;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return null;
		
	} 
	
	
		/**
		 * 
		 * @param map 조회기간
		 * @return 카테고리 적용 베스트셀러 목록
		 */
		public ArrayList<BookDTO> CategorybestSeller (HashMap<String, String> map){
			
			
			
			try {
				
				String where ="";
				String sql = "";
				String category ="";
				
				
				if (map.get("a") != null) 
				{

					category = "'" + map.get("a") + "'";
					
					//where = String.format("where seq between 1 and 10 and pubdate between %s and %s", start, end);
					//sql = String.format("select * from vwbestseller %s order by salerank asc", where);
					
					where = String.format("where mcategory=%s and rownum < 11", category);
					sql = String.format("select * from vwbestseller %s order by salerank asc", where);
					
					
					

					
					
				}
				
			
						
				
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
					
					
					
					list.add(dto);
					
					
				}
				
				return list;
						
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			
			return null;
			
		} 
	
	

	/**
	 * 
	 * @return 신간도서 목록 
	 */
	public ArrayList<BookDTO> defaultNewBook(){
		
		
		try {
			
			String sql = "select * from vwnewbook where rownum < 11 order by rank asc";
			
			
			
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
				
				
				list.add(dto);
				
				
			}
			
			return list;
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
		
		
	}
	
	
	

	/**
	 * 
	 * @param map 조회기간
	 * @return 신간도서 목록
	 */
	public ArrayList<BookDTO> newBook (HashMap<String, String> map){
		
		try {
			
			String where ="";
			String sql = "";
			String category = "";
			
			
			if (map.get("yearStart") != null && map.get("yearEnd") != null
				&& map.get("monthStart") != null && map.get("monthEnd") != null
				&& map.get("dayStart") != null && map.get("dayEnd") != null) 
			{
				String start = "'" + map.get("yearStart") + map.get("monthStart") + map.get("dayStart") +"'";
				String end = "'" + map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd") +"'";
				category = "'" + map.get("a") + "'";
				
				where = String.format("where pubdate between %s and %s and mcategory=%s and rownum < 11", start, end, category);
				sql = String.format("select * from vwnewbook %s order by rank asc", where);
				
							
			}
			
			
					
			
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
				
				
				
				list.add(dto);
				
				
			}
			
			return list;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return null;
		
	} 
	

	/**
	 * 
	 * @param map 조회기간
	 * @return 카테고리 적용 신간도서목록
	 */
	public ArrayList<BookDTO> CategroyNewBook (HashMap<String, String> map){
		
		try {
			
			String where ="";
			String sql = "";			
			String category ="";
			
			
	
			
			
			if (map.get("a") != null) 
			{
				String start = "'" + map.get("yearStart") + map.get("monthStart") + map.get("dayStart") +"'";
				String end = "'" + map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd") +"'";
				category = "'" + map.get("a") + "'";
				
				where = String.format("where mcategory=%s and rownum < 11", category);
				sql = String.format("select * from vwnewbook %s order by rank asc", where);
				
				
							
			}
			
			
					
			
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
				
				
				
				list.add(dto);
				
				
			}
			
			return list;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return null;
		
	} 
/**
 * 
 * @param map 조회기간
 * @return 카테고리 미적용 신간목록
 */
public ArrayList<BookDTO> NoCategoryNewBook (HashMap<String, String> map){
		
		
		
		try {
			
			String where ="";
			String sql = "";
		
			
			
			if (map.get("yearStart") != null && map.get("yearEnd") != null
				&& map.get("monthStart") != null && map.get("monthEnd") != null
				&& map.get("dayStart") != null && map.get("dayEnd") != null) 
			{
				String start = "'" + map.get("yearStart") + map.get("monthStart") + map.get("dayStart") +"'";
				String end = "'" + map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd") +"'";
				
				
				
				where = String.format("where pubdate between %s and %s and rownum < 11", start, end);
				sql = String.format("select * from vwnewbook %s order by rank asc", where);
				
				
				
				
				
			}
			
			
					
			
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
				
				
				
				list.add(dto);
				
				
			}
			
			return list;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return null;
		
	} 

	/**
	 * 
	 * @return 월간베스트 목록
	 */
	public ArrayList<BookDTO> monthlyBestSeller() {
		
		
		try {
			
			//String sql = "select * from vwbestseller where pubdate between trunc(sysdate, 'mm') and last_day(sysdate)"; //
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
				
							
				
				list.add(dto);
			
				
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
		
	}
	/**
	 * 
	 * @return 메인화면 베스트셀러
	 */
	public ArrayList<BookDTO> mBestSeller() {
		
		
		try {
			
			
			String sql = "select * from vwmainbestseller";
			
					
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while (rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setAmount(rs.getInt("amount"));	
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setPaydate(rs.getString("paydate"));
				
							
				
				list.add(dto);
			
				
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
		
	}

	/**
	 * 
	 * @return 메인화면 베스트셀러 목록
	 */
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
				
							
				
				list.add(dto);
				
				
			}
			
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return null;
		
		
		
	}
	
	/**
	 * 
	 * @return 메인화면 신간도서 목록
	 */
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
			
				
				
				list.add(dto);
				
				
			}
			
			return list;
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
		
		
	}
	
	
	
	/**
	 * 
	 * @param seq 회원번호
	 * @return 메인화면 추천도서 목록
	 */
	public ArrayList<BookDTO> mainRecommendBook (String seq){
		
		
		try {
			
			
			String sql = "";
			//sql = String.format("select * from vwrecommendbook where seq = %s and rank between 1 and 6 order by rank", seq);
			//sql = String.format("select * from vwrecommendbook where seq = 24 and rank between 1 and 6 order by rank");
			sql = String.format("select * from vwrecommendbook where seq = %s", seq);
			
			
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
				
				
				
				list.add(dto);
				
				
			}
			
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		return null;
		
		
	}
  
  //----- 현우 끝 
  

	//############# 주혁 시작
	
	
	/**
	 * (사용자) 도서 리스트 반환 메서드
	 * @param map 카테고리 및 페이징 관련 데이터를 담은 객체
	 * @return 도서 리스트
	 */
	public ArrayList<BookDTO> getBookList(HashMap<String, String> map) {
		
		try {
			
			String sql = "";
			String innerSql = "";
			
			if (map.get("seqSCategory") == null) {
				//도서 리스트 첫 화면
				//innerSql = String.format("select b.*, sc.sCategory as sCategory, (select name from tblAuthor where seq = b.seqAuthor) as author from tblBook b inner join tblSCategory sc on b.seqSCategory = sc.seq inner join tblMCategory mc on sc.seqMCategory = mc.seq where mc.seq = %s order by b.pubDate desc, b.title", map.get("seqMCategory"));
				innerSql = String.format("select * from viewBook where seqMCategory = %s order by pubDate desc, title asc", map.get("seqMCategory"));

			} else {
				//도서 리스트 좌측 소분류 선택
				//innerSql = String.format("select b.*, (select sCategory from tblSCategory where seq = b.seqSCategory) as sCategory, (select name from tblAuthor where seq = b.seqAuthor) as author from tblBook b where b.seqSCategory = %s order by b.pubDate desc, b.title", map.get("seqSCategory"));
				innerSql = String.format("select * from viewBook where seqSCategory = %s order by pubDate desc, title asc", map.get("seqSCategory"));
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
				
				bdto.setSeqLCategory(rs.getString("seqLCategory"));
				bdto.setlCategory(rs.getString("lCategory"));
				bdto.setSeqMCategory(rs.getString("seqMCategory"));
				bdto.setmCategory(rs.getString("mCategory"));
				bdto.setSeqSCategory(rs.getString("seqSCategory"));
				bdto.setsCategory(rs.getString("sCategory"));
				
				blist.add(bdto);
				
			}
			
			return blist;			
			
		} catch (Exception e) {
			System.out.println("BookDAO.getBookList()");
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * (사용자) 도서 상세정보 반환 메서드
	 * @param seq 도서번호
	 * @return 도서 상세정보
	 */
	public BookDTO getBookDetail(String seq) {
		
		try {
			
			String sql = "select * from viewBook where seq = ?";
			
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
				
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				
				dto.setlCategory(rs.getString("lCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				dto.setsCategory(rs.getString("sCategory"));
				
				return dto;
			}			
			
		} catch (Exception e) {
			System.out.println("BookDAO.getBookDetail()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * (사용자) 도서 수 반환 메서드
	 * @param map 카테고리 및 페이징 관련 데이터를 담은 객체
	 * @return 도서 수
	 */
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
			System.out.println("BookDAO.getBookCount()");
			e.printStackTrace();
		}
		
		return 0;
	}

	
	/**
	 * (관리자) 도서 목록 반환 메서드
	 * @param map 카테고리 및 페이징 관련 데이터를 담은 객체
	 * @return 도서 목록
	 */
	public ArrayList<BookDTO> getAdminBookList(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("seqLCategory") != null) {
				where = "where vb.seqLCategory = " + map.get("seqLCategory");
			}
			
			String sql = String.format("select * from (select a.*, rownum as rnum from (select vb.*, (select amount from tblInventory where seqBook = vb.seq) as amount from viewBook vb %s) a) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while (rs.next()) {
				BookDTO dto = new BookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setSeqAuthor(rs.getString("seqAuthor"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPubDate(rs.getString("pubDate"));
				dto.setPrice(rs.getInt("price"));
				dto.setSalePrice(rs.getInt("salePrice"));
				dto.setCopy(rs.getString("copy"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setSummary(rs.getString("summary"));
				dto.setImage(rs.getString("image"));
				dto.setPage(rs.getInt("page"));
				dto.setContents(rs.getString("contents"));
				dto.setAuthor(rs.getString("author"));
				dto.setAuthorIntro(rs.getString("authorIntro"));
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setlCategory(rs.getString("lCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				dto.setSeqSCategory(rs.getString("seqSCategory"));
				dto.setsCategory(rs.getString("sCategory"));
				dto.setAmount(rs.getInt("amount"));
				
				list.add(dto);
				
			}
			
			return list;			
			
		} catch (Exception e) {
			System.out.println("BookDAO.getAdminBookList()");
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * (관리자) 전체 도서 수 반환 메서드
	 * @return 전체 도서 수
	 */
	public int getWholeBookCount() {
		
		try {
			
			String sql = "select count(*) as cnt from viewBook";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}			
			
		} catch (Exception e) {
			System.out.println("BookDAO.getWholeBookCount()");
			e.printStackTrace();
		}
		
		return 0;
	}

	
	/**
	 * (관리자) 국내 도서 수 반환 메서드
	 * @return 국내 도서 수
	 */
	public int getInternalBookCount() {

		try {
			
			String sql = "select count(*) as cnt from viewBook where seqLCategory = 1";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}			
			
		} catch (Exception e) {
			System.out.println("BookDAO.getInternalBookCount()");
			e.printStackTrace();
		}	
		
		return 0;
	}

	
	/**
	 * (관리자) 해외 도서 수 반환 메서드
	 * @return 해외 도서 수
	 */
	public int getExternalBookCount() {

		try {
			
			String sql = "select count(*) as cnt from viewBook where seqLCategory = 2";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}			
			
		} catch (Exception e) {
			System.out.println("BookDAO.getExternalBookCount()");
			e.printStackTrace();
		}	
		
		return 0;
	}

	
	/**
	 * (관리자) 페이징에 사용할 도서 수 반환 메서드
	 * @param map 카테고리 및 페이징 관련 데이터를 담은 객체
	 * @return 도서 수
	 */
	public int getAdminBookCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("seqLCategory") != null) {
				//대분류 선택
				where = String.format("where seqLCategory = %s", map.get("seqLCategory"));
			}
			
			String sql = String.format("select count(*) as cnt from viewBook %s", where);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}			
			
		} catch (Exception e) {
			System.out.println("BookDAO.getAdminBookCount()");
			e.printStackTrace();
		}
		
		return 0;
	}

	
	/**
	 * (관리자) 도서 추가 메서드
	 * @param bdto 도서 정보를 담은 객체
	 * @return 도서 번호
	 */
	public String add(BookDTO bdto) {
		
		try {
			
			String sql = "insert into tblBook (seq, seqAuthor, seqSCategory, title, publisher, price, salePrice, pubDate, summary, isbn, copy, image, page, contents) values (seqBook.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, bdto.getSeqAuthor());
			pstat.setString(2, bdto.getSeqSCategory());
			pstat.setString(3, bdto.getTitle());
			pstat.setString(4, bdto.getPublisher());
			pstat.setInt(5, bdto.getPrice());
			pstat.setInt(6, (bdto.getPrice() / 10) * 9);
			pstat.setString(7, bdto.getPubDate());
			pstat.setString(8, bdto.getSummary());
			pstat.setString(9, bdto.getIsbn());
			pstat.setString(10, bdto.getCopy());
			pstat.setString(11, bdto.getImage());
			pstat.setInt(12, bdto.getPage());
			pstat.setString(13, bdto.getContents());
			
			int result = pstat.executeUpdate();
			
			if (result == 1) {
				sql = "select max(seq) as seq from tblBook";
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				
				if (rs.next()) {
					return rs.getString("seq");
				}
			}			
			
		} catch (Exception e) {
			System.out.println("BookDAO.add()");
			e.printStackTrace();
		}
		
		return null;
	}


	/**
	 * (관리자) 도서 상세 정보 반환 메서드
	 * @param seq 도서 번호
	 * @return 도서 상세 정보
	 */
	public BookDTO getAdminBookDetail(String seq) {
		
		try {
			
			String sql = "select vb.*, (select amount from tblInventory where seqBook = vb.seq) as amount from viewBook vb where vb.seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				BookDTO dto = new BookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setSeqAuthor(rs.getString("seqAuthor"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPubDate(rs.getString("pubDate"));
				dto.setPrice(rs.getInt("price"));
				dto.setSalePrice(rs.getInt("salePrice"));
				dto.setCopy(rs.getString("copy"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setSummary(rs.getString("summary"));
				dto.setImage(rs.getString("image"));
				dto.setPage(rs.getInt("page"));
				dto.setContents(rs.getString("contents"));
				dto.setAuthor(rs.getString("author"));
				dto.setAuthorIntro(rs.getString("authorIntro"));
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				dto.setSeqSCategory(rs.getString("seqSCategory"));
				dto.setlCategory(rs.getString("lCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				dto.setsCategory(rs.getString("sCategory"));
				dto.setAmount(rs.getInt("amount"));
				
				return dto;
				
			}			
			
		} catch (Exception e) {
			System.out.println("BookDAO.getAdminBookDetail()");
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * (관리자) 도서 수정 메서드
	 * @param bdto 수정할 도서 정보
	 */
	public void edit(BookDTO bdto) {
		
		try {
			
			String sql = "update tblBook set seqAuthor = ?, seqSCategory = ?, title = ?, publisher = ?, price = ?, salePrice = ?, pubDate = ?, summary = ?, isbn = ?, copy = ?, image = ?, page = ?, contents = ? where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, bdto.getSeqAuthor());
			pstat.setString(2, bdto.getSeqSCategory());
			pstat.setString(3, bdto.getTitle());
			pstat.setString(4, bdto.getPublisher());
			pstat.setInt(5, bdto.getPrice());
			pstat.setInt(6, (bdto.getPrice() / 10) * 9);
			pstat.setString(7, bdto.getPubDate());
			pstat.setString(8, bdto.getSummary());
			pstat.setString(9, bdto.getIsbn());
			pstat.setString(10, bdto.getCopy());
			pstat.setString(11, bdto.getImage());
			pstat.setInt(12, bdto.getPage());
			pstat.setString(13, bdto.getContents());
			
			pstat.setString(14, bdto.getSeq());
			
			pstat.executeUpdate();			
			
		} catch (Exception e) {
			System.out.println("BookDAO.edit()");
			e.printStackTrace();
		}	
		
	}
	
	
	/**
	 * (관리자) 도서 수정 시 이미지 수정 안 한 경우 이미지 파일명 반환 메서드
	 * @param seq 도서 번호
	 * @return 이미지 파일명
	 */
	public String getImageFileName(String seq) {
		
		try {
			
			String sql = "select image from tblBook where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getString("image");
			}			
			
		} catch (Exception e) {
			System.out.println("BookDAO.getImageFileName()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * (관리자) 도서 삭제 시 주문 또는 독후감 내역 확인 메서드
	 * @param seq 도서 번호
	 * @return 주문 또는 독후감 내역 존재 여부
	 */
	public boolean isOrderOrReview(String seq) {
		
		try {
			
			String sql = "select seqBook as seq from (select distinct seqBook from tblBookOrderDetail union all select distinct seqBook from tblBaroOrderDetail union all select distinct seqBook from tblReview) where seqBook = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				//종이책 상세주문 + 바로드림 상세주문 + 독후감 > 번호 있으면
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("BookDAO.isOrderOrReview()");
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	/**
	 * (관리자) 도서 삭제 메서드
	 * @param seq 도서 번호
	 * @return 도서 삭제 성공 여부
	 */
	public int del(String seq) {
		
		try {
			// - tblInventory, tblBookCart, tblBaroCart, tblBook 순차 삭제
			
			String sql = "delete from tblInventory where seqBook = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			int result = pstat.executeUpdate();
			
			if (result == 1) {
				//도서재고 테이블에서 삭제 성공
				// -> 종이책 장바구니에서 삭제 (장바구니에 없을 수도 있음)
				sql = "delete from tblBookCart where seqBook = ?";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, seq);
				
				pstat.executeUpdate();
				
				//바로드림 장바구니에서 삭제 (장바구니에 없을 수도 있음)
				sql = "delete from tblBaroCart where seqBook = ?";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, seq);
					
				pstat.executeUpdate();
					
				//도서테이블에서 삭제
				sql = "delete from tblBook where seq = ?";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, seq);
				
				return pstat.executeUpdate();

			} else {
				//삭제 실패
				return 0;
			}
			
			
		} catch (Exception e) {
			System.out.println("BookDAO.del()");
			e.printStackTrace();
		}
		
		return 0;
	}
	

	//############# 주혁 끝
	
	// ############ (조아라) 시작
	
	/**
	 * 회원의 독후감을 쓸 수 있는 도서들의 정보를 가져오는 리스트입니다.
	 * @param 회원번호입니다.
	 * @return 도서정보들의 정보인 BookDTO들의 ArrayList를 반환합니다.
	 */
	public ArrayList<BookDTO> getPossibleBook(String seq) {
		
		try {
			
			String sql="{ call procShowPossibleBook(?, ?) }";
			cstat=conn.prepareCall(sql);
			cstat.setString(1, seq);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			cstat.execute();
			
			ArrayList<BookDTO> list=new ArrayList<BookDTO>();
			
			rs=(ResultSet)cstat.getObject(2);
			
			while (rs.next()) {
				BookDTO dto=new BookDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BookDAO.getPossibleBook()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	// ############ (조아라) 끝

} //BookDAO


















