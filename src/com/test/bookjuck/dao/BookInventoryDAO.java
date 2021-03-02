package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookInventoryDTO;

/**
 * 도서 재고 관련 DB 작업 담당 클래스
 * @author 김주혁
 *
 */
public class BookInventoryDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	
	public BookInventoryDAO() {
	      conn = DBUtil.open();
	   }

	public void close() {

		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("BookInventoryDAO.close()");
			e.printStackTrace();
		}

	}

	//---------------주혁 시작
	
	/**
	 * (관리자) 도서 재고 추가 메서드
	 * @param bidto 추가할 도서 재고 정보
	 * @return 도서 재고 추가 성공 여부
	 */
	public int add(BookInventoryDTO bidto) {
		
		try {
			
			String sql = "insert into tblInventory (seq, seqBook, amount) values (seqInventory.nextVal, ?, ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, bidto.getSeqBook());
			pstat.setString(2, bidto.getAmount());
			
			return pstat.executeUpdate();			
			
		} catch (Exception e) {
			System.out.println("BookInventoryDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
	}

	
	/**
	 * (관리자) 도서 재고 수정 메서드
	 * @param bidto 수정할 도서 재고 정보
	 * @return 도서 재고 수정 성공 여부
	 */
	public int edit(BookInventoryDTO bidto) {
		
		try {
			
			String sql = "update tblInventory set amount = ? where seqBook = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, bidto.getAmount());
			pstat.setString(2, bidto.getSeqBook());
			
			return pstat.executeUpdate();			
			
		} catch (Exception e) {
			System.out.println("BookInventoryDAO.edit()");
			e.printStackTrace();
		}	
		
		return 0;
	}	
	
	//---------------주혁 끝
	
}
