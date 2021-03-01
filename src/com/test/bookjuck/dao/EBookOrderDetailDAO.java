package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.EBookOrderDetailDTO;

public class EBookOrderDetailDAO {


	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public EBookOrderDetailDAO() {
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

	public String getOrderDate(String seqEBookOrder) {
		try {
			
			String sql = "select orderDate from tblEOrder where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqEBookOrder);
			
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

	public ArrayList<EBookOrderDetailDTO> listEBookDetail(String seq, String seqEBookOrder) {
		try {

			String sql="select * from vwebookOrderList where seqMember = ? and seqebookOrder =? order by orderdate, seqebookorder, title";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.setString(2, seqEBookOrder);
			
			rs=pstat.executeQuery();
			
			
			ArrayList<EBookOrderDetailDTO> elist = new ArrayList<EBookOrderDetailDTO>();

			while (rs.next()) {

				EBookOrderDetailDTO dto = new EBookOrderDetailDTO();

				dto.setSeqEBookOrder(rs.getString("seqEBookOrder"));
				dto.setSeqMember(rs.getString("seqMember"));
				dto.setOrderDate(rs.getString("orderDate"));
				dto.setOrderState(rs.getString("orderState"));
				dto.setOrderName(rs.getString("orderName"));
				dto.setOrderTel(rs.getString("orderTel"));
				dto.setSeqEBook(rs.getString("seqEBook"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setImage(rs.getString("image"));
				dto.setTitle(rs.getString("title"));
				dto.setPayment(rs.getString("payment"));
				dto.setTotalPay(rs.getInt("totalPay"));
				dto.setUsePoint(rs.getInt("usePoint"));
				dto.setActualPay(rs.getInt("actualPay"));
				dto.setSavePoints(rs.getInt("savePoints"));
				dto.setPayDate(rs.getString("payDate"));
				
				elist.add(dto);
			}

			return elist;

		} catch (Exception e) {
			System.out.println("EOrderDetailDAO listEBookDetail : " + e);
		}
		return null;
	}
	
}
