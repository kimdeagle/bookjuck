package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookOrderDTO;

public class BookOrderDAO {
	

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BookOrderDAO() {
		// DB 연결
		conn = DBUtil.open();
	}

	public void close() {
      
		try {
         
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

   }

	
	
	// (다은) 시작 ---------------------
	
	/**
	 * 일반배송 주문의 교환/취소/환불 리스트를 가져오는 메서드 입니다.
	 * @param map
	 * @return list
	 */
	public ArrayList<BookOrderDTO> list(HashMap<String, String> map) {

		
		try {
			
			String where = "";
			
			if (map.get("refundsearch")!= null) {
				
				where = String.format(""
						, map.get("refundsearch"));
				
			}
			

			
			String sql = String.format("select * from vwBookRefundList %s order by applydate desc", where);
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<BookOrderDTO> list = new ArrayList<BookOrderDTO>();
			
			
			while (rs.next()) {
				
				BookOrderDTO dto = new BookOrderDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setApplyDate(rs.getString("applyDate"));
				dto.setTitle(rs.getString("title"));
				dto.setTotalAmount(rs.getString("totalAmount"));
				dto.setOrderState(rs.getString("orderState"));
				dto.setSeqMember(rs.getString("seqMember"));
				
				list.add(dto);
				
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	// (다은) 끝 ---------------------
	

}
