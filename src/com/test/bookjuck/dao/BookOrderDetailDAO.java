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


	
	// ################################### 다은 시작  
	
	/**
	 * 해당 주문번호를 가지고 일반 주문인지 또는 교환/ 취소/ 환불 중 어떤 주문인지를 알아내는 메서드입니다. 
	 * @param seqBookOrder
	 * @return orderType
	 */
	public String getType(String seqBookOrder) {
		
		try {
			
			String sql = String.format("select * from vwOrderType where seqOrder = %s", seqBookOrder);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			if (rs.next()) {
				
				return rs.getString("orderType");
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
	/**
	 * 취소 정보를 가져오는 메서드입니다.
	 * @param seqBookOrder
	 * @return dto
	 */
	public BookOrderDetailDTO getCancelInfo(String seqBookOrder) {

		try {
			
			String sql = String.format("select * from tblBookCancel bc inner join tblBookOrder bo on bo.seq = bc.seqbookorder where bo.seq = %s", seqBookOrder);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			if (rs.next()) {
				
				BookOrderDetailDTO dto = new BookOrderDetailDTO();
				
				dto.setCancelReason(rs.getString("cancelReason"));
				dto.setCancelDate(rs.getString("cancelDate"));
				dto.setCancelReasonDetail(rs.getString("cancelReasonDetail"));
				dto.setCancelState(rs.getString("cancelState"));
				
				//주문취소는 주문취소날짜가 처리날짜가 된다.
				//dto.setEndDate(rs.getString("endDate")); 
				
				return dto;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}


	

	/**
	 * 교환 정보를 가져오는 메서드입니다.
	 * @param seqBookOrder
	 * @return dto
	 */
	public BookOrderDetailDTO getReturnInfo(String seqBookOrder) {

		try {
			
			String sql = String.format("select * from tblBookChange bc inner join tblBookOrder bo on bo.seq = bc.seqbookorder inner join tblNewDelivery nd on nd.seqBookChange = bc.seq where bo.seq = %s", seqBookOrder);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			if (rs.next()) {
				
				BookOrderDetailDTO dto = new BookOrderDetailDTO();
				
				dto.setChangeReason(rs.getString("changeReason"));
				dto.setChangeDate(rs.getString("changeDate"));
				dto.setChangeReasonDetail(rs.getString("changeReasonDetail"));
				dto.setChangeState(rs.getString("changeState"));
				
				dto.setEndDate(rs.getString("endDate")); 
				dto.setReturnAddress(rs.getString("returnAddress"));
				
				dto.setName(rs.getString("name"));		//교환배송 수취인
				dto.setTel(rs.getString("tel"));		//교환배송 수취인번호
				dto.setAddress(rs.getString("address"));//교환배송 주소
				dto.setDeliveryCom(rs.getString("deliveryCompany"));//교환배송 배송회사 
				dto.setDeliveryNum(rs.getString("deliveryNumber"));	//교환배송 운송장번호
				
				return dto;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	
	
	/**
	 * 환불 정보를 가져오는 메서드입니다.
	 * @param seqBookOrder
	 * @return dto
	 */
	public BookOrderDetailDTO getRefundInfo(String seqBookOrder) {

		try {
			
			String sql = String.format("select * from tblBookRefund br inner join tblBookOrder bo on bo.seq = br.seqbookorder where bo.seq = %s", seqBookOrder);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			if (rs.next()) {
				
				BookOrderDetailDTO dto = new BookOrderDetailDTO();
				
				dto.setRefundReason(rs.getString("refundReason"));
				dto.setRefundDate(rs.getString("refundDate"));
				dto.setRefundReasonDetail(rs.getString("refundReasonDetail"));
				dto.setRefundState(rs.getString("refundState"));
				
				dto.setEndDate(rs.getString("endDate")); 
				dto.setReturnAddress(rs.getString("returnAddress"));
				
				return dto;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
	// ################################### 다은 끝  
	

}
