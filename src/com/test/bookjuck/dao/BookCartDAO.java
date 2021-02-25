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

	//Cart 서블릿 -> 글목록 달라고 위임
	//seq는 임시로 지정(회원번호 21번)
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
				dto.setAmount(rs.getInt("amount"));
				dto.setTotal(rs.getInt("total"));
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("list: " + e);
		}
		
		return null;
	}
	
}
