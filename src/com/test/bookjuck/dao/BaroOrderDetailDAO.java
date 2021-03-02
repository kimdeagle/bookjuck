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
	/**
	 * 바로드림 상세 주문 내역.
	 * @param seq 회원번호
	 * @param seqBaroOrder 바로드림 주문 번호
	 * @return balist 바로드림 상세 주문 리스트
	 */
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

	/**
	 * 바로드림 주문일
	 * @param seqBaroOrder 바로드림 주문 번호
	 * @return orderDate 바로드림 주문일
	 */
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

	// 수경 끝
	
	
	// ####################################### 다은 시작
	
	/**
	 * 해당 주문번호를 가지고 일반 주문인지 또는 취소 주문인지를 알아내는 메서드입니다. 
	 * @param seqBaroOrder
	 * @return ordertype
	 */
	public String getType(String seqBaroOrder) {
		
		try {
			
			String sql = String.format("select case when bc.seq is not null then 'cancel' when bc.seq is null then 'other' end as ordertype from tblBaroOrder o left outer join tblBaroCancel bc on o.seq = bc.seqbaroorder where o.seq = %s", seqBaroOrder);
			
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
	public BaroOrderDetailDTO getCancelInfo(String seqBaroOrder) {
		

		try {
			
			String sql = String.format("select * from tblBaroCancel bc inner join tblBaroOrder bo on bo.seq = bc.seqbaroorder where bo.seq = %s", seqBaroOrder);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			if (rs.next()) {
				
				BaroOrderDetailDTO dto = new BaroOrderDetailDTO();
				
				dto.setCancelReason(rs.getString("cancelReason"));
				dto.setCancelDate(rs.getString("cancelDate"));
				dto.setCancelReasonDetail(rs.getString("cancelReasonDetail"));
				dto.setCancelState(rs.getString("cancelState"));
				
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}
	
	// ###################################### 다은 끝
}
