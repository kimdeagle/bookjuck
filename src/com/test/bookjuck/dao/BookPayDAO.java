package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookPayDTO;

public class BookPayDAO {
	

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BookPayDAO() {
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
	
	
	//############################ 오수경 ##############################
	//############################ 시작 ##############################
	/**
	 * 종이책 결제 내역
	 * @param seqBookOrder 종이책 주문 번호
	 * @return list 종이책 결제 내역 반환
	 */
	// orderdetail 서블릿. 
	public ArrayList<BookPayDTO> listBookPay(String seqBookOrder) {
		try {
			
			String sql = "select * from tblBookPay where seqBookOrder = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqBookOrder);
			
			rs = pstat.executeQuery();
			
			ArrayList<BookPayDTO> list = new ArrayList<BookPayDTO>();
			
			while(rs.next()) {
				BookPayDTO dto = new BookPayDTO();
				
				dto.setPayment(rs.getString("payment"));
				dto.setActualPay(rs.getInt("actualPay"));
				dto.setTotalPay(rs.getInt("totalPay"));
				dto.setSavePoints(rs.getInt("savePoints"));
				dto.setUsePoint(rs.getInt("usePoint"));
				
				list.add(dto);
			}
			
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println("BookPayDAO listBookPay()" + e);
		}
		return null;
	}

	//############################ 끝 ##############################
	//############################ 오수경 ##############################
	
	
}
