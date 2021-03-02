package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BaroPayDTO;
import com.test.bookjuck.dto.BookPayDTO;

public class BaroPayDAO {
	

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BaroPayDAO() {
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
	 * 바로드림 결제 내역
	 * @param seqBaroOrder 바로드림 주문번호
	 * @return list 바로드림 결제 내역
	 */
	public ArrayList<BaroPayDTO> listBookPay(String seqBaroOrder) {
		
		try {
			
			String sql = "select * from tblBaroPay where seqBaroOrder = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqBaroOrder);
			
			rs = pstat.executeQuery();
			
			ArrayList<BaroPayDTO> list = new ArrayList<BaroPayDTO>();
			
			while(rs.next()) {
				BaroPayDTO dto = new BaroPayDTO();
				
				dto.setPayment(rs.getString("payment"));
				dto.setActualPay(rs.getInt("actualPay"));
				dto.setTotalPay(rs.getInt("totalPay"));
				dto.setSavePoints(rs.getInt("savePoints"));
				dto.setUsePoint(rs.getInt("usePoint"));
				
				list.add(dto);
			}
			
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println("BaroPayDAO listBaroPay()" + e);
		}
		return null;
		
	}


}
