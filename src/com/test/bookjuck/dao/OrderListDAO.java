package com.test.bookjuck.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BaroOrderDTO;
import com.test.bookjuck.dto.BookOrderDetailDTO;
import com.test.bookjuck.dto.EBookOrderDTO;

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
			
//			String sql = "{ call procbookOrderList(?, ?, ?) }";
//			cstat = conn.prepareCall(sql);
//			
//			cstat.setString(1, seq);
//			cstat.setString(2, seqBookOrder);
//			cstat.registerOutParameter(3, OracleTypes.CURSOR);
//			
//			cstat.executeQuery();
//			
//			rs = (ResultSet)cstat.getObject(3);
			
			
			String sql="select * from vwbookOrderList where seqMember = ? and seqBookOrder =? order by orderdate, seqbookorder, title";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.setString(2, seqBookOrder);
			
			rs=pstat.executeQuery();
			
			
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
					dto.setSeqBook(rs.getString("seqBook"));
					
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

	public String getOrderDate(String seqBookOrder) {
		
		try {
			
			String sql = "select orderDate from tblBookOrder where seq = ?";
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

	public ArrayList<BookOrderDetailDTO> bcntlist(String seq) {
		try {
			
			String sql = "select count(*) as cnt from vwBookOrderList where seqMember = ? group by seqBookOrder";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			ArrayList<BookOrderDetailDTO> list = new ArrayList<BookOrderDetailDTO>();
			
			while(rs.next()) {
				
				BookOrderDetailDTO dto = new BookOrderDetailDTO();
				dto.setCnt(rs.getInt("cnt"));
				
				list.add(dto);
				
			}
			
			return list; 
			
		} catch (Exception e) {
			System.out.println("OrderListDAO getBCnt : "+e);
		}
		return null;
	}

	public ArrayList<BaroOrderDTO> listBaroOrder(String seq) {
		try {

			String sql2 = "select distinct(seqBaroOrder) from vwbaroorderlist where seqmember = ?";
			
			pstat = conn.prepareStatement(sql2);
			pstat.setString(1, seq);
			
			ArrayList<BaroOrderDTO> testlist = new ArrayList<BaroOrderDTO>();
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				BaroOrderDTO tdto = new BaroOrderDTO();
				tdto.setSeq(rs.getString("seqBaroOrder"));
				
				testlist.add(tdto);
			}
			
			ArrayList<BaroOrderDTO> balist = new ArrayList<BaroOrderDTO>();

			for(BaroOrderDTO tdto2 : testlist) {
			
			
				String sql = String.format("select rownum, b.* from vwbaroorderlist b where seqbaroorder = %s and rownum = 1", tdto2.getSeq());
				
				
				pstat = conn.prepareStatement(sql);
				
				rs = pstat.executeQuery();
				
				
				while(rs.next()) {
					
					BaroOrderDTO dto = new BaroOrderDTO();
					dto.setSeq(rs.getString("seqBaroOrder"));
					dto.setTitle(rs.getString("title"));
					dto.setActualPay(rs.getInt("actualPay"));
					dto.setOrderState(rs.getString("orderState"));
					dto.setOrderDate(rs.getString("orderDate"));
					dto.setImage(rs.getString("image"));
					dto.setSeqBook(rs.getString("seqBook"));
					
					balist.add(dto);
				
				}
			
			}
			return balist;
			
		} catch (Exception e) {
			System.out.println("OrderListDAO listBaroOrder : "+e);
		}
		
		return null;
	}

	public ArrayList<EBookOrderDTO> listEBookOrder(String seq) {
		try {

			String sql2 = "select distinct(seqEBookOrder) from vwEBookorderlist where seqmember = ?";
			
			pstat = conn.prepareStatement(sql2);
			pstat.setString(1, seq);
			
			ArrayList<EBookOrderDTO> testlist = new ArrayList<EBookOrderDTO>();
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				EBookOrderDTO tdto = new EBookOrderDTO();
				tdto.setSeq(rs.getString("seqEBookOrder"));
				
				testlist.add(tdto);
			}
			
			ArrayList<EBookOrderDTO> elist = new ArrayList<EBookOrderDTO>();

			for(EBookOrderDTO tdto2 : testlist) {
			
			
				String sql = String.format("select rownum, b.* from vwEBookorderlist b where seqEBookorder = %s and rownum = 1", tdto2.getSeq());
				
				
				pstat = conn.prepareStatement(sql);
				
				rs = pstat.executeQuery();
				
				
				while(rs.next()) {
					
					EBookOrderDTO dto = new EBookOrderDTO();
					dto.setSeq(rs.getString("seqEBookOrder"));
					dto.setTitle(rs.getString("title"));
					dto.setActualPay(rs.getInt("ActualPay"));
					dto.setOrderState(rs.getString("orderState"));
					dto.setOrderDate(rs.getString("orderDate"));
					dto.setImage(rs.getString("image"));
					dto.setSeqBook(rs.getString("seqEBook"));
					
					elist.add(dto);
				
				}
			
			}
			return elist;
			
		} catch (Exception e) {
			System.out.println("OrderListDAO listEBookOrder : "+e);
		}
		
		return null;
	}

	//컬럼명 as cnt로 바꿨는데 안 가져와짐, 주문상태에 따라 카운트하기
	public int getCount(String seq, String orderState) {
				
		try {
			
			String sql = "select count(*) as cnt from vwBookorderlist where seqMember = ? and orderState = '?'";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.setString(2, orderState);
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");				
			}
			
			
		} catch (Exception e) {
			System.out.println("orderlistDAO getcount : "+e);
		}
		
		return 0;
	}


	
	
	
	// ###################### 오수경 ############################
	// ####################### 끝 #############################

}
