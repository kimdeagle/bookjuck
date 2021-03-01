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
	public BookOrderDetailDTO getCancelInfo(String seqBookOrder) {

		try {
			
			String sql = String.format("select * from tblBookCancel bc inner join tblBookOrder bo on bo.seq = bc.seqbookorder where bo.seq = %S", seqBookOrder);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			if (rs.next()) {
				
				BookOrderDetailDTO dto = new BookOrderDetailDTO();
				
				dto.setCancelReason(rs.getString("cancelReason"));
				dto.setCancelDate(rs.getString("cancelDate"));
				dto.setCancelReasonDetail(rs.getString("cancelReasonDetail"));
				dto.setCancelState(rs.getString("cancelState"));
				dto.setEndDate(rs.getString("endDate"));
				
				return dto;
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}
	

}
