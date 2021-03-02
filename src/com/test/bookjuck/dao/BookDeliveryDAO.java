package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookDeliveryDTO;

/**
 * 오수경
 * 
 * @author 오수경
 *
 */
public class BookDeliveryDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BookDeliveryDAO() {
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

//################# 오수경 ####################
//################# 시작 ####################
	/**
	 * 종이책 배달 내역
	 * 
	 * @param seqBookOrder 종이책 주문 번호
	 * @return list 배달 목록 반환
	 */
	public ArrayList<BookDeliveryDTO> listBookDelivery(String seqBookOrder) {

		try {

			String sql = "select * from tblBookDelivery where seqBookOrder = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqBookOrder);

			rs = pstat.executeQuery();

			ArrayList<BookDeliveryDTO> list = new ArrayList<BookDeliveryDTO>();

			while (rs.next()) {
				BookDeliveryDTO dto = new BookDeliveryDTO();

				dto.setAddress(rs.getString("address"));
				dto.setDeliveryNumber(rs.getString("deliveryNumber"));
				dto.setDeliveryCompany(rs.getString("deliveryCompany"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));

				list.add(dto);

			}

			return list;

		} catch (Exception e) {
			System.out.println("BookDeliveryDAO listBookDelivery()" + e);
		}

		return null;
	}
	
	/**
	 * 최근 배달 내역
	 * @param seq 회원 번호
	 * @return list 최근 배달 내역 반환
	 */
	public ArrayList<BookDeliveryDTO> getLatestDelivery(String seq) {
		try {

			String sql = "select * from vwBookOrderList where seqMember = ? and rownum = 1 order by orderDate desc";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			ArrayList<BookDeliveryDTO> list = new ArrayList<BookDeliveryDTO>();

			while (rs.next()) {

				BookDeliveryDTO dto = new BookDeliveryDTO();

				dto.setName(rs.getString("deliveryname"));
				dto.setAddress(rs.getString("deliveryaddress"));
				dto.setTel(rs.getString("deliverytel"));

				list.add(dto);

			}

			return list;

		} catch (Exception e) {
			System.out.println("BookDeliveryDAO getLastestDelivery : " + e);
		}
		return null;
	}

//################# 오수경 ####################
//################# 끝 ####################

}
