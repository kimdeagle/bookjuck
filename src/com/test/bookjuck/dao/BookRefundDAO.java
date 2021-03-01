package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.bookjuck.DBUtil;

public class BookRefundDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BookRefundDAO() {
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
	 * 일반배송 주문환불을 하는 메서드입니다.
	 * @param seqOrder
	 * @param refundReason
	 * @param refundReasonDetail
	 * @param returnAddress
	 * @return
	 */
	public int bookrefund(String seqOrder, String refundReason, String refundReasonDetail, String returnAddress) {
		
		try {

			String sql = "insert into tblBookRefund (seq, seqBookOrder, refundDate, refundReason, refundReasonDetail, returnaddress, refundState, endDate) values (seqBookrefund.nextVal, ?, sysdate, ?, ?, ?, '환불신청', null)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqOrder);
			pstat.setString(2, refundReason);
			pstat.setString(3, refundReasonDetail);
			pstat.setString(4, returnAddress);
			
			return pstat.executeUpdate(); // 1 or 0

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	
	}

	
	
	/**
	 * e-book 주문환불을 하는 메서드입니다.
	 * @param seqOrder
	 * @param refundReason
	 * @param refundReasonDetail
	 * @param returnAddress
	 * @return
	 */
	public int ebookrefund(String seqOrder, String refundReason, String refundReasonDetail, String returnAddress) {
		
		try {

			String sql = "insert into tblERefund (seq, seqEOrder, refundDate, refundReason, refundReasonDetail, returnaddress, refundState, endDate) values (seqErefund.nextVal, ?, sysdate, ?, ?, ?, '환불신청', null)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqOrder);
			pstat.setString(2, refundReason);
			pstat.setString(3, refundReasonDetail);
			pstat.setString(4, returnAddress);
			
			return pstat.executeUpdate(); // 1 or 0

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	
	}

}
