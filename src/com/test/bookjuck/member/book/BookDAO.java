package com.test.bookjuck.member.book;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dtosave.BookDTO;




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
	
	//검색구현
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
				dto.setPubdate(rs.getString("pubdate"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setContents(rs.getString("contents"));
				dto.setAuthor(rs.getString("name"));
				dto.setLcategory(rs.getString("lcategory"));
				
				list.add(dto);
				
				
			}
			
			System.out.println(list.size());
			return list;
			 
					
		} catch (Exception e) {
			System.out.println(e);
		} 
		

		return null;
	
	}
	
	//베스트셀러 list
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
				dto.setPubdate(rs.getString("pubdate"));
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
	
	//신간도서 list
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
				dto.setPubdate(rs.getString("pubdate"));
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
		
	public ArrayList<BookDTO> monthlyBestSeller() {
		
		
		try {
			
			String sql = "select * from vwbestseller where pubdate between trunc(sysdate, 'mm') and last_day(sysdate)";
			
			
					
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while (rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setImage(rs.getString("image"));
				dto.setTitle(rs.getString("title"));
				dto.setCopy(rs.getString("copy"));
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
	
	

}


















