package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookOrderDetailDTO;
import com.test.bookjuck.dto.EBookOrderDTO;

/**
 * 일반배송 주문 상세보기를 위한 DAO입니다.
 * @author 김다은
 *
 */
public class BookOrderDetailDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BookOrderDetailDAO() {
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

	
	
	/**
	 * 교환, 환불, 취소 정보를 가져오는 메서드입니다.
	 * @param seqBookOrder
	 * @return
	 */
	public ArrayList<BookOrderDetailDTO> getRefundInfo(String seqBookOrder) {

		try {
			
			String sql = String.format("select * from tblBookCancel bc inner join tblBookOrder bo on bo.seq = bc.seqbookorder where bo.seq = %S", seqBookOrder);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<BookOrderDetailDTO> list = new ArrayList<BookOrderDetailDTO>();
			
			
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
	

}
