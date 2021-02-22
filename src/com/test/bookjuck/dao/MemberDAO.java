package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.MemberDTO;

public class MemberDAO {
	   private Connection conn;
	   private Statement stat;
	   private PreparedStatement pstat;
	   private ResultSet rs;

	   public MemberDAO() {
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

	/*최진영 - tos.jsp(이용약관 정보 추가) 시작*/
	public int Tosadd(MemberDTO dto) {
		try {
			
			String sql = "insert into tblMember(seq, id, pw, name, tel, regDate, address, ssn, login, email, points, privacy, lastDate) values(seqMember.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setInt(4, dto.getTel());
			pstat.setString(5, dto.getRegDate());
			pstat.setString(6, dto.getAddress());
			pstat.setString(7, dto.getSsn());
			pstat.setString(8, dto.getLogin());
			pstat.setString(9, dto.getEmail());
			pstat.setInt(10, dto.getPoints());
			pstat.setInt(11, dto.getPrivacy());
			pstat.setString(12, dto.getLastDate());
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	/*최진영 - tos.jsp(이용약관 정보 추가) 시작*/
}
