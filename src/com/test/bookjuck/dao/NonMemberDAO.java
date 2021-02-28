package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.NonMemberDTO;

public class NonMemberDAO {
	   private Connection conn;
	   private Statement stat;
	   private PreparedStatement pstat;
	   private ResultSet rs;

	   public NonMemberDAO() {
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

	// ############ (최진영) 시작
	public int nmlogin(NonMemberDTO dto) {
		try {

			String sql = "select count(*) as cnt from tblNonMember where  email= ? and tel =? and pw=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getEmail());
			pstat.setInt(2, dto.getTel());
			pstat.setString(3, dto.getPw());
			
			
			System.out.println(dto.getTel());
			System.out.println(dto.getPw());
			
			rs = pstat.executeQuery();
			
			
			if(rs.next()){
			
					
				return rs.getInt("cnt");
				
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
				
		return 0;
	}
	// ############ (최진영) 종료

	
	// ############ (최진영) 시작
	/* public NonMemberDTO getNonmember(String email, int tel, String pw) { */
		public NonMemberDTO getNonmember(String email) {
		try {
			
			String sql = "select * from tblNonmember where email=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, email);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				NonMemberDTO dto = new NonMemberDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPw(rs.getString("pw"));
				dto.setTel(rs.getInt("tel"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	// ############ (최진영) 종료
	
}
