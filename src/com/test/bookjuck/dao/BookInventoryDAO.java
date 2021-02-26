package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookInventoryDTO;

public class BookInventoryDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	
	public BookInventoryDAO() {
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

	//---------------주혁 시작
	
	//BookAddOk 서블릿 -> 도서재고 추가
	public int add(BookInventoryDTO bidto) {
		
		try {
			
			String sql = "insert into tblInventory (seq, seqBook, amount) values (seqInventory.nextVal, ?, ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, bidto.getSeqBook());
			pstat.setString(2, bidto.getAmount());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}

	//BookEditOk 서블릿 -> 도서재고 수정
	public int edit(BookInventoryDTO bidto) {
		
		try {
			
			String sql = "update tblInventory set amount = ? where seqBook = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, bidto.getAmount());
			pstat.setString(2, bidto.getSeqBook());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		return 0;
	}	
	
	//---------------주혁 끝
	
}
