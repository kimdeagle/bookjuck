package com.test.bookjuck.search;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.member.book.BookDTO;

public class RealTimeSearchDAO {
	
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	
	
	
	public RealTimeSearchDAO() {
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
	
	public ArrayList<RealTimeSearchDTO> getSearchRank() {
		
		try {
			
			String sql = "select * from vwrealtimesearch";
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery(sql);
			
			ArrayList<RealTimeSearchDTO> list = new ArrayList<RealTimeSearchDTO>();
			
			while(rs.next()) {
				
				RealTimeSearchDTO dto = new RealTimeSearchDTO();

				dto.setSearchword(rs.getString("searchword"));
				dto.setRank(rs.getString("rank"));
				dto.setSearchcount(rs.getInt("searchcount"));
				System.out.println(rs.getString("searchword"));
				list.add(dto);
				
			}
			
			System.out.println(sql);
			System.out.println(list);
			System.out.println(list.size());
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
		
	}
	
	
	
	

}
