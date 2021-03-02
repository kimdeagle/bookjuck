package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookPayDTO;
import com.test.bookjuck.dto.EBookPayDTO;

public class EBookPayDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public EBookPayDAO() {
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
	 * 이북 결제 내역
	 * @param seqEBookOrder 이북 주문 번호
	 * @return list 이북 결제 내역 반환
	 */
	public ArrayList<EBookPayDTO> listEBookPay(String seqEBookOrder) {
		try {

			String sql = "select * from tblEPay where seqEOrder = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqEBookOrder);

			rs = pstat.executeQuery();

			ArrayList<EBookPayDTO> list = new ArrayList<EBookPayDTO>();

			while (rs.next()) {
				EBookPayDTO dto = new EBookPayDTO();

				dto.setPayment(rs.getString("payment"));
				dto.setTotalPay(rs.getInt("totalPay"));
				dto.setActualPay(rs.getInt("actualPay"));
				dto.setSavePoints(rs.getInt("savePoints"));
				dto.setUsePoint(rs.getInt("usePoint"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			System.out.println("EBookPayDAO listEBookPay()" + e);
		}
		return null;

	}
}
