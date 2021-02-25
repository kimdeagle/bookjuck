package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.AuthorDTO;

public class AuthorDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public AuthorDAO() {
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

	//==============주혁 시작
	
	//admin -> BookAdd 서블릿 -> 작가 리스트
	public ArrayList<AuthorDTO> getAuthorList() {
		
		try {
			
			String sql = "select * from tblAuthor";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<AuthorDTO> alist = new ArrayList<AuthorDTO>();
			
			while (rs.next()) {
				AuthorDTO dto = new AuthorDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setIntro(rs.getString("intro"));
				
				alist.add(dto);
				
			}
			
			return alist;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	//BookAddOk 서블릿 -> 작가 추가
	public String add(AuthorDTO adto) {
		
		try {
			
			String sql = "insert into tblAuthor (seq, name, intro) values(seqAuthor.nextVal, ?, ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, adto.getName());
			pstat.setString(2, adto.getIntro());
			
			int result = pstat.executeUpdate();
			
			if (result == 1) {
				sql = "select max(seq) as seq from tblAuthor";
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				
				if (rs.next()) {
					return rs.getString("seq");
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	//==============주혁 끝

}
