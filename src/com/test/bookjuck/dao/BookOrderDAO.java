package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookOrderDTO;

/**
 * @author Dana
 *
 */
/**
 * @author Dana
 *
 */
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
	 * 추가) 일반배송 주문 관리자 - 주문조회 리스트를 가져올 수 있습니다.
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
				
				//관리자 - 리스트 조회시 필요한 요소
				dto.setId(rs.getString("id"));
				dto.setOrderDate(rs.getString("orderDate"));
				
				list.add(dto);
				
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	
	
	/**
	 * 관리자가 사용하는 일반배송 주문/배송 조회 리스트를 보여주는 메서드입니다.
	 * @param map
	 * @return list
	 */
	public ArrayList<BookOrderDTO> adminlist(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("refundsearch")!= null) {
				
				where = String.format(""
						, map.get("refundsearch"));
				
			}
			
			
			//String sql = String.format("select ab.* from vwAdminBookOrder ab %s order by orderdate desc", where);
			
			
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwAdminBookOrder order by orderdate desc) a) where rnum between %s and %s"
					
					, map.get("begin")
					, map.get("end"));
			
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<BookOrderDTO> list = new ArrayList<BookOrderDTO>();
			
			
			while (rs.next()) {
				
				BookOrderDTO dto = new BookOrderDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setOrderDate(rs.getString("orderDate"));
				dto.setTotalAmount(rs.getString("totalamount"));
				dto.setOrderState(rs.getString("orderstate"));
				
				list.add(dto);
				
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	

	/**
	 * 총 주문 수 를 세는 메서드
	 * @param map
	 * @return cnt : 총 주문 수
	 */
	public int getATotalCount(HashMap<String, String> map) {

		try {

			/*
			String where = "";

			if (map.get("search") != null) {
				// 검색중...
				where = String.format("where name like '%%%s%%' or subject like '%%%s%%' or content like '%%%s%%'",
						map.get("search"), map.get("search"), map.get("search"));
			}
			
			*/
			
			String sql = String.format("select count(*) as cnt from vwadminBookOrder");
			
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
	
	// (다은) 끝 ---------------------
	

}
