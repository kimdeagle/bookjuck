package com.test.bookjuck.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookOrderDetailDTO;

import oracle.jdbc.OracleTypes;

public class OrderListDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	private CallableStatement cstat;

	public OrderListDAO() {
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
	
	// ###################### 오수경 ############################
	// ####################### 시작 #############################
	
	//OrderList 서블릿. 종이책 주문 상세 내역. 주문 번호를 넘기고 상세 주문 내역 담기
	public ArrayList<BookOrderDetailDTO> listBookDetail(String seq, String seqBookOrder) {
		try {
			
			String sql = "{ call procbookOrderList(?, ?, ?) }";
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, seq);
			cstat.setString(2, seqBookOrder);
			cstat.registerOutParameter(3, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			rs = (ResultSet)cstat.getObject(3);
			
			ArrayList<BookOrderDetailDTO> blist = new ArrayList<BookOrderDetailDTO>();
			
			while(rs.next()){
				
				BookOrderDetailDTO dto = new BookOrderDetailDTO();
				
				dto.setSeqBookOrder(rs.getString("seqBookOrder"));
				dto.setId(rs.getString("id"));
				dto.setSeqMember(rs.getString("seqMember"));
				dto.setOrderDate(rs.getString("orderDate"));
				dto.setOrderState(rs.getString("orderState"));
				dto.setOrderName(rs.getString("orderName"));
				dto.setOrderTel(rs.getString("orderTel"));
				dto.setDeliveryName(rs.getString("deliveryName"));
				dto.setDeliveryTel(rs.getString("deliveryTel"));
				dto.setDeliveryAddress(rs.getString("deliveryAddress"));
				dto.setDeliveryCompany(rs.getString("deliveryCompany"));
				dto.setDeliveryNumber(rs.getString("deliveryNumber"));
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
				
				blist.add(dto);
			}
			
			return blist;
			
		} catch (Exception e) {
			System.out.println("OrderListDAO listBook : "+e);
		}
		return null;
	}

	//주문 내역 조회
	public ArrayList<BookOrderDetailDTO> listBookOrder(String seq) {
		try {

			String sql2 = "select distinct(seqBookOrder) from vwbookorderlist where seqmember = ?";
			
			pstat = conn.prepareStatement(sql2);
			pstat.setString(1, seq);
			
			ArrayList<BookOrderDetailDTO> testlist = new ArrayList<BookOrderDetailDTO>();
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				BookOrderDetailDTO tdto = new BookOrderDetailDTO();
				tdto.setSeqBookOrder(rs.getString("seqBookOrder"));
				
				testlist.add(tdto);
			}
			
			ArrayList<BookOrderDetailDTO> bolist = new ArrayList<BookOrderDetailDTO>();

			for(BookOrderDetailDTO tdto2 : testlist) {
			
			
				String sql = String.format("select rownum, b.* from vwbookorderlist b where seqbookorder = %s and rownum = 1", tdto2.getSeqBookOrder());
	
				
				pstat = conn.prepareStatement(sql);
				
				rs = pstat.executeQuery();
				
				
				while(rs.next()) {
					
					BookOrderDetailDTO dto = new BookOrderDetailDTO();
					dto.setSeqBookOrder(rs.getString("seqBookOrder"));
					dto.setTitle(rs.getString("title"));
					dto.setActualPay(rs.getInt("actualPay"));
					dto.setOrderState(rs.getString("orderState"));
					dto.setOrderDate(rs.getString("orderDate"));
					dto.setImage(rs.getString("image"));
					
					
					bolist.add(dto);
				
				}
			
			}
			return bolist;
			
		} catch (Exception e) {
			System.out.println("title : "+e);
		}
		
		return null;
	}
	
	//orderdetail 서블릿. 운송장 번호 가져오기
	public String getDeliveryNumber(String seqBookOrder) {
		
		try {
			
			String sql = "select distinct(deliverynumber) from vwbookOrderList where seqBookOrder = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqBookOrder);
			
			String deliveryNumber = "";
			
			rs = pstat.executeQuery();

			if(rs.next()) {
				deliveryNumber = rs.getString("deliveryNumber");
			}
			
			return deliveryNumber;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	public String getOrderDate(String seqBookOrder, String type) {
		
		//type b - book, ba - baro, e - ebook
		
		try {
			
			String sql = "";
			
			if(type.equals("b")) {
				sql = "select orderDate from tblBookOrder where seq = ?";
			}else if(type.equals("ba")) {
				sql = "select orderDate from tblBaroOrder where seq = ?";				
			}else if(type.equals("e")) {
				sql = "select orderDate from tblEOrder where seq = ?";
			}
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqBookOrder);
			
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

	
	
	
	// ###################### 오수경 ############################
	// ####################### 끝 #############################

}
