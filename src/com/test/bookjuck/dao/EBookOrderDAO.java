package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BaroOrderDTO;
import com.test.bookjuck.dto.BookOrderDetailDTO;
import com.test.bookjuck.dto.EBookOrderDTO;

/**
 * ebook 주문과 관련된 메서드들을 담고있는 DAO입니다.
 * @author 김다은
 *
 */
public class EBookOrderDAO {
	

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public EBookOrderDAO() {
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
	 * Ebook 주문의 교환/취소/환불 리스트를 가져오는 메서드 입니다.
	 * 추가) Ebook 주문 관리자 - 주문조회 리스트를 가져올 수 있습니다.
	 * @param map
	 * @return list
	 */
	public ArrayList<EBookOrderDTO> list(HashMap<String, String> map) {

		
		try {
			
			//refundsearch 가 null 일 때 (상품정보 검색창에 아무런 입력도 하지 않았을 때) null -> ""로 변환
			String refundsearch = map.get("refundsearch");
			
			if (map.get("refundsearch") == null) {
				refundsearch = "";
			}

			String where = String.format("where applydate between '%s' and '%s' and title like '%%%s%%' and id='%s'"
					, map.get("startDate")
					, map.get("endDate")
					, refundsearch
					, map.get("id"));
			
			//Paging
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwERefundList %s order by applydate desc) a) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<EBookOrderDTO> list = new ArrayList<EBookOrderDTO>();
			
			
			while (rs.next()) {
				
				EBookOrderDTO dto = new EBookOrderDTO();
				
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
	 * 관리자가 사용하는 바로드림 주문/배송 조회 리스트를 보여주는 메서드입니다.
	 * @param map
	 * @param isRefundList 
	 * @return list
	 */
	public ArrayList<EBookOrderDTO> adminlist(HashMap<String, String> map, String isRefundList) {
		
		
		try {
			
			//--search 가 null 일 때 (상품정보 검색창에 아무런 입력도 하지 않았을 때) null -> ""로 변환
			String idsearch = map.get("idsearch");
			String ordernumsearch = map.get("ordernumsearch");
			String booksearch = map.get("booksearch");
			String orderstate = map.get("orderstate");
			
			if (map.get("idsearch") == null) {
				idsearch = "";
			} 
			
			if (map.get("ordernumsearch") == null) {
				ordernumsearch = "";
			} 
			
			if (map.get("booksearch") == null) {
				booksearch = "";
			} 
			
			if (map.get("orderstate") == null || map.get("orderstate").equals("통합검색")) {
				orderstate = "";
			} 
			
			String where = String.format("orderdate between '%s' and '%s' and title like '%%%s%%' and seq like '%%%s%%' and id like '%%%s%%' and orderstate like '%%%s%%'"
					, map.get("startDate")
					, map.get("endDate")
					, booksearch
					, ordernumsearch
					, idsearch
					, orderstate);
			
			
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwAdminEOrder %s %s order by orderdate desc) a) where rnum between %s and %s"
					, isRefundList
					, where
					, map.get("begin")
					, map.get("end"));
			
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<EBookOrderDTO> list = new ArrayList<EBookOrderDTO>();
			
			
			while (rs.next()) {
				
				EBookOrderDTO dto = new EBookOrderDTO();
				
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
	 * 관리자가 사용하는 총 주문 수 를 세는 메서드
	 * @param map
	 * @param isRefundList 
	 * @return cnt : 총 주문 수
	 */
	public int getATotalCount(HashMap<String, String> map, String isRefundList) {

		try {
			
			//--search 가 null 일 때 (상품정보 검색창에 아무런 입력도 하지 않았을 때) null -> ""로 변환
			String idsearch = map.get("idsearch");
			String ordernumsearch = map.get("ordernumsearch");
			String booksearch = map.get("booksearch");
			String orderstate = map.get("orderstate");
			
			if (map.get("idsearch") == null) {
				idsearch = "";
			} 
			
			if (map.get("ordernumsearch") == null) {
				ordernumsearch = "";
			} 
			
			if (map.get("booksearch") == null) {
				booksearch = "";
			} 
			
			if (map.get("orderstate") == null || map.get("orderstate").equals("통합검색")) {
				orderstate = "";
			} 
			
			String where = String.format("orderdate between '%s' and '%s' and title like '%%%s%%' and seq like '%%%s%%' and id like '%%%s%%' and orderstate like '%%%s%%'"
					, map.get("startDate")
					, map.get("endDate")
					, booksearch
					, ordernumsearch
					, idsearch
					, orderstate);
			
			
			String sql = String.format("select count(*) as cnt from vwadminEOrder %s %s", isRefundList, where);
			
			System.out.println(sql);
			
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

	
	/**
	 * 사용자 측, 총 교환/환불/취소 수 를 세는 메서드
	 * @param map
	 * @return cnt : 총 교환/환불/취소 수
	 */
	public int getTotalCount(HashMap<String, String> map) {

		try {

			//refundsearch 가 null 일 때 (상품정보 검색창에 아무런 입력도 하지 않았을 때) null -> ""로 변환
			String refundsearch = map.get("refundsearch");
			
			if (map.get("refundsearch") == null) {
				refundsearch = "";
			} 
			
			String where = String.format("where applydate between '%s' and '%s' and title like '%%%s%%' and id='%s'"
					, map.get("startDate")
					, map.get("endDate")
					, refundsearch
					, map.get("id"));
			
			
			String sql = String.format("select count(*) as cnt from vwERefundList %s", where);
			
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

	
	/**
	 * 로그인한 사용자의 process(교환, 환불, 취소 처리상태)를 세어주는 메서드 입니다.
	 * @param map 세션을 담아올 map입니다.
	 * @param proceeState 각 처리상태의 컬럼값입니다.
	 * @return cnt 처리상태의 count 입니다.
	 */
	public String process(HashMap<String, String> map, String processState) {


		try {
			
			String sql = "select count(*) as cnt from vwERefundList where id = ? and process = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("id"));
			pstat.setString(2, processState);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getString("cnt");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
		
		return null;
	}

	
	/**
	 * 교환/취소/환불 신청을 위해 seqOrder입력시 주문한 책 제목과 수량을 받아오는 메서드입니다.
	 * @param seqOrder
	 * @return dto
	 */
	public BookOrderDetailDTO getOrder(String seqOrder) {

		try {
			
			String sql = String.format("select rownum, eo.seq, b.title from tbleBook b inner join tbleOrderDetail eod on eod.seqeBook = b.seq inner join tbleOrder eo on eo.seq = eod.seqeorder where eo.seq = %s and rownum = 1", seqOrder);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			if (rs.next()) {
				
				BookOrderDetailDTO dto = new BookOrderDetailDTO();
				
				dto.setTitle(rs.getString("title"));
				dto.setAmount(1);
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
		
		return null;
	}
	
	// (다은) 끝 ---------------------
	

}
