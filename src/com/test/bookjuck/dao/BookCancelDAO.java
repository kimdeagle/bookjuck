package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.bookjuck.DBUtil;

public class BookCancelDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BookCancelDAO() {
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
	 * 일반 배송 주문 취소를 담당하는 메서드입니다.
	 * 
	 * @param seqOrder           주문번호
	 * @param cancelReason       취소사유
	 * @param cancelReasonDetail 취소 상세사유
	 * @return
	 */
	public int bookcancel(String seqOrder, String cancelReason, String cancelReasonDetail) {

		try {
			

			String sql = "insert into tblBookCancel (seq, seqBookOrder, cancelReason, cancelReasonDetail, cancelState, cancelDate) values (seqBookCancel.nextVal, ?, ?, ?, '취소신청', sysdate)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqOrder);
			pstat.setString(2, cancelReason);
			pstat.setString(3, cancelReasonDetail);

			return pstat.executeUpdate(); // 1 or 0

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}

	
	/**
	 * 바로드림 주문 취소를 담당하는 메서드입니다.
	 * 
	 * @param seqOrder           주문번호
	 * @param cancelReason       취소사유
	 * @param cancelReasonDetail 취소 상세사유
	 * @return
	 */
	public int barocancel(String seqOrder, String cancelReason, String cancelReasonDetail) {


		try {

			String sql = "insert into tblBaroCancel (seq, seqBaroOrder, cancelReason, cancelReasonDetail, cancelState, cancelDate) values (seqBaroCancel.nextVal, ?, ?, ?, '취소신청', sysdate)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqOrder);
			pstat.setString(2, cancelReason);
			pstat.setString(3, cancelReasonDetail);

			return pstat.executeUpdate(); // 1 or 0

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}


	

}
