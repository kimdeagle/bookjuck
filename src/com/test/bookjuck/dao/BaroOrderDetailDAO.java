package com.test.bookjuck.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BaroOrderDetailDTO;
import com.test.bookjuck.dto.BookOrderDetailDTO;

import oracle.jdbc.OracleTypes;

public class BaroOrderDetailDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	private CallableStatement cstat;

	public BaroOrderDetailDAO() {
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

	// 수경 시작

	public ArrayList<BaroOrderDetailDTO> listBaroDetail(String seq, String seqBaroOrder) {
		try {

			String sql="select * from vwbaroOrderList where seqMember = ? and seqBaroOrder =? order by orderdate, seqbaroorder, title";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.setString(2, seqBaroOrder);
			
			rs=pstat.executeQuery();
			
			
			ArrayList<BaroOrderDetailDTO> balist = new ArrayList<BaroOrderDetailDTO>();

			while (rs.next()) {

				BaroOrderDetailDTO dto = new BaroOrderDetailDTO();

				dto.setSeqBaroOrder(rs.getString("seqBaroOrder"));
				dto.setSeqMember(rs.getString("seqMember"));
				dto.setOrderDate(rs.getString("orderDate"));
				dto.setOrderState(rs.getString("orderState"));
				dto.setOrderName(rs.getString("orderName"));
				dto.setOrderTel(rs.getString("orderTel"));
				dto.setSeqBook(rs.getString("seqBook"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setImage(rs.getString("image"));
				dto.setTitle(rs.getString("title"));
				dto.setAmount(rs.getInt("amount"));
				dto.setPayment(rs.getString("payment"));
				dto.setTotalPay(rs.getInt("totalPay"));
				dto.setUsePoint(rs.getInt("usePoint"));
				dto.setActualPay(rs.getInt("actualPay"));
				dto.setSavePoints(rs.getInt("savePoints"));
				dto.setPayDate(rs.getString("payDate"));
				dto.setTotal(rs.getInt("total"));

				balist.add(dto);
			}

			return balist;

		} catch (Exception e) {
			System.out.println("BaroOrderDetailDAO listBaroDetail : " + e);
		}
		return null;

	}

	public String getOrderDate(String seqBaroOrder) {
		try {
			
			String sql = "select orderDate from tblBaroOrder where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqBaroOrder);
			
			rs = pstat.executeQuery();
			String orderDate ="";
			
			if(rs.next()) {
				orderDate = rs.getString("orderDate");
			}
			
			return orderDate;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
