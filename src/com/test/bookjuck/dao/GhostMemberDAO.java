package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.GhostMemberDTO;
import com.test.bookjuck.dto.MemberDTO;

public class GhostMemberDAO {

	   private Connection conn;
	   private Statement stat;
	   private PreparedStatement pstat;
	   private ResultSet rs;

	   public GhostMemberDAO() {
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
	public int add(GhostMemberDTO dto) {
		try {
			String sql ="insert into tblGhostMember(seq, seqMember, state, regDate) values(seqGhostMember.nextVal, ?, ?, ?)";
			

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqMember());
			pstat.setString(2, dto.getState());
			pstat.setString(3, dto.getRegDate());
			
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	// ############ (최진영) 종료
	
	
	// ############ (최진영) 시작
	public int check(MemberDTO dto) {
		try {
			String sql ="select count(*) as cnt from vwDormency where id=? and pw=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				return rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	// ############ (최진영) 종료

	
	// ############ (최진영) 시작
	public ArrayList<GhostMemberDTO> custDmcList(HashMap<String, String> map) {
		
		try {
			
		String sql = String.format("select * from vwDormency where rnum between %s and %s", map.get("begin"), map.get("end"));
		
		pstat = conn.prepareStatement(sql);
		
		rs = pstat.executeQuery();
		
		ArrayList<GhostMemberDTO> dlist = new ArrayList<GhostMemberDTO>();
		
		while(rs.next()){
			GhostMemberDTO dto = new GhostMemberDTO();
			dto.setSeq(rs.getString("seq"));
			dto.setName(rs.getString("name"));
			dto.setId(rs.getString("id"));
			dto.setTel(rs.getInt("tel"));				
			dto.setRegDate(rs.getString("regdate"));
			dto.setLogin(rs.getString("login"));
			dto.setTrsdate(rs.getString("trsdate"));
			dto.setRegdate_d(rs.getString("regdate_d"));
		
			dto.setLastDate(rs.getString("lastDate"));
			dto.setCuration(rs.getString("curation"));
			dto.setSsn(rs.getString("ssn"));
			dto.setPw(rs.getString("pw"));
			dto.setAddress(rs.getString("address"));
			dto.setEmail(rs.getString("email"));
			dto.setPrivacy(rs.getInt("privacy"));
			
			
			dlist.add(dto);
		}
			return dlist;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	// ############ (최진영) 종료

	
	// ############ (최진영) 시작
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String sql = "select count(*) as cnt from tblghostmember";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	// ############ (최진영) 종료
	
	// ############ (최진영) 시작
	public int check(String id, String pw) {
		try {
			String sql = "select count(*) as cnt from vwDormency where id = ? pw =?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setString(2, pw);
			
			
			rs = pstat.executeQuery();
			
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	// ############ (최진영) 종료

	public int del(GhostMemberDTO dto) {
		try {
			String sql = "DELETE FROM tblGhostMember where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqMember());
			
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	
}
