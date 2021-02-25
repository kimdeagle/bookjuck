package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.LetterDTO;

public class LetterDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public LetterDAO() {
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

	// ############ (조아라) 시작
	
	/**
	 * 큐레이션레터 한 개의 정보를 가지고 오는 메서드입니다.
	 * @param seq 큐레이션레터 PK인 seq입니다.
	 * @return 큐레이션레터의 정보를 담고 있는 LetterDTO를 반환합니다.
	 */
	public LetterDTO getInfo(String seq) {
		
		try {
			
			String sql="select * from tblLetter where seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs=pstat.executeQuery();
			
			if (rs.next()) {
				LetterDTO dto=new LetterDTO();
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getString("regdate"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("LetterDAO.getInfo()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 전송한 큐레이션 레터를 DB에 추가하는 메서드입니다.
	 * @param dto 전송한 큐레이션 레터의 정보를 담고 있는 DTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int add(LetterDTO dto) {
		
		try {
			
			String sql="insert into tblLetter(seq, title, content, regdate) values (seqletter.nextVal, ?, ?, sysdate)";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("LetterDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	/**
	 * 큐레이션 레터 전송내역을 저장하기 위해 방금 전송한 큐레이션 레터의 PK인 seq를 가져오는 메서드입니다.
	 * @return 방금 전송한 큐레이션 레터의 PK인 seq를 반환합니다.
	 */
	public String getLastSeq() {
		
		try {
			
			String sql="select max(seq) as num from tblLetter";
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getString("num");
			}
			
		} catch (Exception e) {
			System.out.println("LetterLogDAO.getLastSeq()");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	// ############ (조아라) 끝
	
	

}
