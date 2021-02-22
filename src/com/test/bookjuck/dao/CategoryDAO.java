package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.CategoryDTO;

public class CategoryDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public CategoryDAO() {
		conn = DBUtil.open();
	}
	
	public void close() {
		
		try {
			conn.close();			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	//Header 서블릿 -> 카테고리 리스트 반환
	public ArrayList<CategoryDTO> mCategoryList() {
		
		try {
			
			String sql = "select * from vwMCategory";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<CategoryDTO> mCategoryList = new ArrayList<CategoryDTO>();
			
			while (rs.next()) {
				CategoryDTO dto = new CategoryDTO();
				
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				dto.setlCategory(rs.getString("lCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				
				mCategoryList.add(dto);
			}
			
			return mCategoryList;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
}
