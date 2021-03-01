package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.bookjuck.DBUtil;

public class BookChangeDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BookChangeDAO() {
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
	 * 일반배송 주문 교환 신청을 담당하는 메서드입니다.
	 * @param seqOrder
	 * @param changeReason
	 * @param changeReasonDetail
	 * @param returnAddress
	 * @return
	 */
	public int bookreturn(String seqOrder, String changeReason, String changeReasonDetail, String returnAddress) {
		
		
		try {

			String sql = "insert into tblBookChange (seq, seqBookOrder, changeDate, changeReason, changeReasonDetail, returnaddress, changeState, endDate) values (seqBookChange.nextVal, ?, sysdate, ?, ?, ?, '교환신청', null)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqOrder);
			pstat.setString(2, changeReason);
			pstat.setString(3, changeReasonDetail);
			pstat.setString(4, returnAddress);
			
			return pstat.executeUpdate(); // 1 or 0

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}



}
