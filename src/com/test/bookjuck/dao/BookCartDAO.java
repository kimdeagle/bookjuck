package com.test.bookjuck.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookCartDTO;

import oracle.jdbc.OracleTypes;

public class BookCartDAO {


	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	private CallableStatement cstat;

	public BookCartDAO() {
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
	 * 
	 * @param seqMember 회원번호
	 * @return list 장바구니 내역
	 */
	//Cart 서블릿 -> 글목록 달라고 위임
	public ArrayList<BookCartDTO> list(String seqMember) {
		
		try {
			
			String sql = "{call procCartList(?,?)}";
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, seqMember);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			
			cstat.executeQuery();
			
			rs = (ResultSet)cstat.getObject(2);
			
			ArrayList<BookCartDTO> list = new ArrayList<BookCartDTO>();
			
			while(rs.next()) {
				
				BookCartDTO dto = new BookCartDTO();
				
				dto.setSeqMember(rs.getString("seqMember"));
				dto.setSeqBook(rs.getString("seqBook"));
				dto.setImage(rs.getString("image"));
				dto.setTitle(rs.getString("title"));
				dto.setPrice(rs.getInt("price"));
				dto.setSalePrice(rs.getInt("salePrice"));
				dto.setAmount(rs.getString("amount"));
				dto.setTotal(rs.getInt("total"));
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("list: " + e);
		}
		
		return null;
	}

	/**
	 * 장바구니 담기
	 * @param dto 장바구니에 담을 상품 내역
	 * @return 성공시 1, 실패시 0 반환
	 */
	public int add(BookCartDTO dto) {
		try {
			
			String sql = "insert into tblBookCart(seq, seqMember, seqBook, amount) values (SEQBOOKCART.nextval, ?, ?, ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqMember());
			pstat.setString(2, dto.getSeqBook());
			pstat.setString(3, dto.getAmount());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BookCartDAO add : "+e);
		}
		return 0;
	}

	/**
	 * 장바구니 총 금액
	 * @param seqMember 회원번호
	 * @return total 장바구니에 담긴 총 상품 금액
	 */
	public int getPrice(String seqMember) {
		try {
			
			String sql = "select sum(total) as total from vwbookcart where seqMember =?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqMember);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("total");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
}
