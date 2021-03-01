package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.AdminDTO;
import com.test.bookjuck.dto.MemberDTO;

public class AdminDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	
	public AdminDAO() {
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

	public int login(AdminDTO dto) {
		try {
			
			String sql = "select count(*) as cnt from tblAdmin where id =? and pw=?";

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

	public AdminDTO getMember(String id) {
		try {
		String sql = "select * from tblAdmin where id = ?";

		pstat = conn.prepareStatement(sql);
		pstat.setString(1, id);

		rs = pstat.executeQuery();
		
		if (rs.next()) {
			AdminDTO dto = new AdminDTO();

			dto.setSeq(rs.getString("seq"));
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			
			return dto;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
}
