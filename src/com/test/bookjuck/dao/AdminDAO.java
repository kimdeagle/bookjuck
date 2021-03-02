package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.AdminDTO;
import com.test.bookjuck.dto.MemberDTO;

/**
 * 
 * @author 최진영
 * 관리자 계정 정보
 */
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

	/**
	 * @author 최진영
	 * @param dto 로그인할 관리자 계정의 아이디, 비밀번호  호출
	 * @return 로그인 결과
	 * 관리자 로그인 
	 */
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

	
	/**
	 * @author 최진영
	 * @param id 
	 * @return 관리자 정보가 담긴 DTO
	 * 세션에 관리자 정보 담기 위해 사용
	 */
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
