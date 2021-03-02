package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookOrderDetailDTO;
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

	/**
	 * 이북 주문일
	 * @param seqEBookOrder 이북 주문 번호
	 * @return orderDate 이분 주문일 반환
	 */
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

	/**
	 * 이북 상세 주문 내역
	 * @param seq 회원 번호
	 * @param seqEBookOrder 이북 주문 번호
	 * @return elist 이북 주문 내역 반환
	 */
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

	
	
	// ################### 다은 시작
	
	
	/**
	 * 해당 주문번호를 가지고 일반 주문인지 또는 취소 주문인지를 알아내는 메서드입니다. 
	 * @param seqBaroOrder
	 * @return ordertype
	 */
	public String getType(String seqEBookOrder) {
		
		try {
			
			String sql = String.format("select case when er.seq is not null then 'refund' when er.seq is null then 'other' end as ordertype from tblEOrder o left outer join tblErefund er on o.seq = er.seqEorder where o.seq = %s", seqEBookOrder);
			
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
	 * 환불 정보를 가져오는 메서드입니다.
	 * @param seqBookOrder
	 * @return dto
	 */
	public EBookOrderDetailDTO getRefundInfo(String seqEBookOrder) {

		try {
			
			String sql = String.format("select * from tbleRefund br inner join tbleOrder bo on bo.seq = br.seqeorder where bo.seq = %s", seqEBookOrder);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			if (rs.next()) {
				
				EBookOrderDetailDTO dto = new EBookOrderDetailDTO();
				
				dto.setRefundReason(rs.getString("refundReason"));
				dto.setRefundDate(rs.getString("refundDate"));
				dto.setRefundReasonDetail(rs.getString("refundReasonDetail"));
				dto.setRefundState(rs.getString("refundState"));
				
				dto.setEndDate(rs.getString("endDate")); 
				
				return dto;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
	
	
	
	// ################### 다은 끝
	
}
